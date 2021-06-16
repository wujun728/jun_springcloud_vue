package com.estate.common.security.handle;

import com.alibaba.fastjson.JSON;
import com.estate.common.core.constant.HttpStatus;
import com.estate.common.core.result.Result;
import com.estate.common.core.utils.ServletUtils;
import com.estate.common.core.utils.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 认证失败处理类 返回未授权
 *
 * @author ruoyi
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        int code = HttpStatus.UNAUTHORIZED;
        String msg = StringUtils.format("请求访问：{}，失败，未认证无法访问系统资源", request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(Result.error(code, msg)));
    }
}
