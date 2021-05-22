package com.zebra.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zebra.framework.interceptor.AuthExrendInterceptor;

@Configuration
public class AuthExrendConfig implements WebMvcConfigurer {
	@Autowired
	private AuthExrendInterceptor authExrendInterceptor;
	private final String[] excludePathPatterns = new String[] { "/img/**", "/fonts/**", "/docs/**", "/ajax/**",
			"/ruoyi.png**", "/favicon.ico**", "/css/**", "/js/**", "/logout", "/login", "/captcha/captchaImage**",
			"/druid/**", "/ruoyi/**" };

	/**
	 * 拦截器配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authExrendInterceptor).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);
	}

}
