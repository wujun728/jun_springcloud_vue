package com.estate.common.security.handle;

import com.alibaba.fastjson.JSON;
import com.estate.api.system.model.LoginUser;
import com.estate.common.core.constant.HttpStatus;
import com.estate.common.core.result.Result;
import com.estate.common.core.utils.ServletUtils;
import com.estate.common.core.utils.StringUtils;
import com.estate.common.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义退出处理类 返回成功
 *
 * @author ruoyi
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    private TokenService tokenService;

    /**
     * 退出处理
     *
     * @return
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)) {
//            String userName = loginUser.getUserName();
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
        }
        ServletUtils.renderString(response, JSON.toJSONString(Result.error(HttpStatus.SUCCESS, "退出成功")));
    }
}
