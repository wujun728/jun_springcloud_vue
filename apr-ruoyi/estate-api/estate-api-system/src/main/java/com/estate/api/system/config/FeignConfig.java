package com.estate.api.system.config;

import com.estate.common.core.constant.CacheConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class FeignConfig implements RequestInterceptor {

    /**
     * 配置Feign接口远程调用时，获取请求头，并带过去，在FeignClient注解中配置configuration参数即可
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        requestTemplate.header(CacheConstants.HEADER, request.getHeader(CacheConstants.HEADER));
    }
}