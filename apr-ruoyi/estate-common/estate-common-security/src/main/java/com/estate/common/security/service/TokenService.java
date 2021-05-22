package com.estate.common.security.service;


import com.estate.api.system.model.LoginUser;
import com.estate.common.core.constant.CacheConstants;
import com.estate.common.core.utils.StringUtils;
import com.estate.common.core.utils.uuid.IdUtils;
import com.estate.common.redis.utils.RedisCache;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * token验证处理
 *
 * @author ruoyi
 */
@Component
public class TokenService {

    // 令牌自定义标识
    private final static String HEADER = CacheConstants.HEADER;
    // 令牌秘钥
    private final static String SECRET = CacheConstants.SECRET;
    // 令牌有效期
    private final static Integer EXPIRE_TIME = CacheConstants.EXPIRE_TIME;

    // token令牌前缀
    private final static String TOKEN_PREFIX = CacheConstants.TOKEN_PREFIX;
    // token中存UUID的Map key
    private final static String LOGIN_USER_KEY = CacheConstants.LOGIN_USER_KEY;
    // redis中存的key前缀
    private final static String LOGIN_TOKEN_KEY = CacheConstants.LOGIN_TOKEN_KEY;


    protected static final long MILLIS_SECOND = 1000;
    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;
    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    @Autowired
    private RedisCache redisCache;

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            // 解析token，token不合法会出现异常
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息，先从token中获取UUID
            String uuid = (String) claims.get(LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
            // 根据key从Redis中取出LoginUser对象
            LoginUser user = redisCache.getCacheObject(userKey);
            return user;
        }
        return null;
    }

    /**
     * 设置用户身份信息
     */
    public void setLoginUser(LoginUser loginUser) {
        if (StringUtils.isNotNull(loginUser) && StringUtils.isNotEmpty(loginUser.getToken())) {
            refreshToken(loginUser);
        }
    }

    /**
     * 删除用户身份信息
     */
    public void delLoginUser(String token) {
        if (StringUtils.isNotEmpty(token)) {
            String userKey = getTokenKey(token);
            redisCache.deleteObject(userKey);
        }
    }

    /**
     * 创建令牌
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    public String createToken(LoginUser loginUser) {
        String token = IdUtils.fastUUID();
        loginUser.setToken(token);
//        setUserAgent(loginUser);
        // 往Redis中加入loginUser对象
        refreshToken(loginUser);

        Map<String, Object> claims = new HashMap<>();
        // 根据loginUser的UUID属性生成token
        claims.put(LOGIN_USER_KEY, token);
        return createToken(claims);
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

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(LoginUser loginUser) {
//        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(System.currentTimeMillis() + EXPIRE_TIME * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存，这里的key加上了Constants.LOGIN_TOKEN_KEY
        String userKey = getTokenKey(loginUser.getToken());
        // 把loginUser对象加入Redis缓存，过期时间为30分钟
        redisCache.setCacheObject(userKey, loginUser, EXPIRE_TIME, TimeUnit.MINUTES);
    }

    /**
     * 设置用户代理信息
     *
     * @param loginUser 登录信息
     */
//    public void setUserAgent(LoginUser loginUser)
//    {
//        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
//        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
//        loginUser.setIpaddr(ip);
//        loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
//        loginUser.setBrowser(userAgent.getBrowser().getName());
//        loginUser.setOs(userAgent.getOperatingSystem().getName());
//    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String createToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
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
                .setSigningKey(SECRET)
                // 当token格式错误时会出现以下异常，格式错误一般是手动修改token，并非token过期
                // 修改token三个不同的部分会出现不同的异常，
                // 修改头部会出现 MalformedJwtException
                // 修改负荷和签名会出现 SignatureException
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }

    /**
     * 获取请求token
     *
     * @param request
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(HEADER);
        if (StringUtils.isNotEmpty(token) && token.startsWith(TOKEN_PREFIX)) {
            token = token.replace(TOKEN_PREFIX, "");
        }
        return token;
    }

    private String getTokenKey(String uuid) {
        return LOGIN_TOKEN_KEY + uuid;
    }
}
