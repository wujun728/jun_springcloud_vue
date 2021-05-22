package com.estate.auth.controller;

import com.alibaba.nacos.api.common.Constants;
import com.estate.api.system.model.LoginUser;
import com.estate.api.system.vo.RouterVo;
import com.estate.auth.model.LoginBody;
import com.estate.auth.service.LoginService;
import com.estate.common.core.result.Result;
import com.estate.common.core.utils.ServletUtils;
import com.estate.common.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginBody loginBody) {
        Result result = Result.success();
        LoginUser user = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        // 生成令牌
        String token = tokenService.createToken(user);
        result.put(Constants.TOKEN, token);
        return result;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/getInfo")
    public Result getInfo() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        if (loginUser != null) {
            Result result = Result.success();
            result.put("user", loginUser.getUser());
            result.put("roles", loginUser.getRoles());
            result.put("permissions", loginUser.getPermissions());
            return result;
        }
        return Result.error();
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("/getRouters")
    public Result getRouters() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        List<RouterVo> routers = loginService.getRouters(loginUser.getUser().getUserId());

        return Result.success(routers);
    }


}
