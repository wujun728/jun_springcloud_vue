package com.ruoyi.common.security.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.core.utils.ip.AddressUtils;
import eu.bitwalker.useragentutils.UserAgent;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.ruoyi.common.core.constant.CacheConstants;
import com.ruoyi.common.core.constant.Constants;
import com.ruoyi.common.core.utils.IdUtils;
import com.ruoyi.common.core.utils.ServletUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.utils.ip.IpUtils;
import com.ruoyi.common.redis.service.RedisService;
import com.ruoyi.system.api.model.LoginUser;

/**
 * token验证处理
 *
 * @author ruoyi
 */
@Component
public class TokenService {
    @Autowired
    private RedisService redisService;
    
    private final static long EXPIRE_TIME = Constants.TOKEN_EXPIRE * 60;
    
    private final static String ACCESS_TOKEN = CacheConstants.LOGIN_TOKEN_KEY;
    
    protected static final long MILLIS_SECOND = 1000;
    
    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;
    
    // 令牌自定义标识
    /*@Value("${token.header}")
    private String header;*/
    
    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;
    
    // 令牌有效期（默认30分钟）
    /*@Value("${token.expireTime}")
    private int expireTime;*/
    
    /**
     * 创建令牌
     */
    public Map<String, Object> createToken(LoginUser loginUser) {
        // 生成token
        String token = IdUtils.fastUUID();
        loginUser.setToken(token);
        loginUser.setUserid(loginUser.getSysUser().getUserId());
        loginUser.setUsername(loginUser.getSysUser().getUserName());
        setUserAgent(loginUser);
        refreshToken(loginUser);
        
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, token);
        String jwtToken = createToken(claims);
        // 保存或更新用户token
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", jwtToken);
        map.put("expires_in", EXPIRE_TIME);
        redisService.setCacheObject(ACCESS_TOKEN + token, loginUser, EXPIRE_TIME, TimeUnit.SECONDS);
        return map;
    }
    
    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public LoginUser getLoginUser() {
        return getLoginUser(ServletUtils.getRequest());
    }
    
    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = SecurityUtils.getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
            // 需要解码得到uuid
            String userKey = getTokenKey(uuid);
            LoginUser user = redisService.getCacheObject(userKey);
            return user;
        }
        return null;
    }
    
    /**
     * 获取请求token
     *
     * @param request
     * @return token
     *//*
    private String getToken(HttpServletRequest request)
    {
        String token = request.getHeader(Constants.AUTH_HEADER);
        if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX))
        {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }*/
    
    /**
     * 设置用户身份信息
     */
    public void setLoginUser(LoginUser loginUser) {
        if (StringUtils.isNotNull(loginUser) && StringUtils.isNotEmpty(loginUser.getToken())) {
            refreshToken(loginUser);
        }
    }
    
    public void delLoginUser(String token) {
        if (StringUtils.isNotEmpty(token)) {
            String userKey = getTokenKey(token);
            redisService.deleteObject(userKey);
        }
    }
    
    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + EXPIRE_TIME * MILLIS_SECOND);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisService.setCacheObject(userKey, loginUser, EXPIRE_TIME, TimeUnit.SECONDS);
    }
    
    private String getTokenKey(String token) {
        return ACCESS_TOKEN + token;
    }
    
    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME * MILLIS_SECOND);
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
        return token;
    }
    
    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
    
    /**
     * 设置用户代理信息
     *
     * @param loginUser 登录信息
     */
    public void setUserAgent(LoginUser loginUser) {
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        loginUser.setIpaddr(ip);
        loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
        loginUser.setBrowser(userAgent.getBrowser().getName());
        loginUser.setOs(userAgent.getOperatingSystem().getName());
    }
    
    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param loginUser
     * @return 令牌
     */
    public void verifyToken(LoginUser loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            refreshToken(loginUser);
        }
    }
}
