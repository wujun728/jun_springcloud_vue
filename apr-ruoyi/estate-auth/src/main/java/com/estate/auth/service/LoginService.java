package com.estate.auth.service;


import com.estate.api.system.RemoteUserService;
import com.estate.api.system.domain.User;
import com.estate.api.system.model.LoginUser;
import com.estate.api.system.vo.RouterVo;
import com.estate.common.core.constant.UserConstants;
import com.estate.common.core.enums.UserStatus;
import com.estate.common.core.exception.BaseException;
import com.estate.common.core.result.R;
import com.estate.common.core.utils.StringUtils;
import com.estate.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//import org.springframework.security.authentication.AuthenticationManager;

/**
 * 登录校验方法
 *
 * @author ruoyi
 */
@Component
public class LoginService {
//    @Autowired
//    private TokenService tokenService;

//    @Resource
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private RedisCache redisCache;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
//    public String login(String username, String password/**, String code, String uuid*/) {
//        // 用户验证
//        Authentication authentication = null;
//        try {
//            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
//            authentication = authenticationManager
//                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (Exception e) {
//            if (e instanceof BadCredentialsException) {
//                // 用户名正确，密码错误会抛出UserPasswordNotMatchException
//                throw new UserPasswordNotMatchException();
//            } else {
//                throw new CustomException(e.getMessage());
//            }
//        }
//
//        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
//        // 生成token
//        return tokenService.createToken(loginUser);
//    }

    @Autowired
    private RemoteUserService remoteUserService;

    /**
     * 登录
     */
    public LoginUser login(String username, String password) {
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(username, password)) {
            throw new BaseException("用户/密码必须填写");
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            throw new BaseException("用户密码不在指定范围");
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            throw new BaseException("用户名不在指定范围");
        }
        // 查询用户信息
        R<LoginUser> userResult = remoteUserService.getUserInfo(username);

        if (R.FAIL == userResult.getCode()) {
            throw new BaseException(userResult.getMsg());
        }

        if (StringUtils.isNull(userResult) || StringUtils.isNull(userResult.getData())) {
            throw new BaseException("登录用户：" + username + " 不存在");
        }
        LoginUser userInfo = userResult.getData();
        User user = userResult.getData().getUser();
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {

            throw new BaseException("对不起，您的账号：" + username + " 已被删除");
        }
        if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            throw new BaseException("对不起，您的账号：" + username + " 已停用");
        }
        if (!SecurityUtils.matchesPassword(password, user.getPassword())) {
            throw new BaseException("用户不存在/密码错误");
        }

        return userInfo;
    }


    public List<RouterVo> getRouters(Long userId){
        R<List<RouterVo>> routers = remoteUserService.getRouters(userId);
        return routers.getData();
    }
}
