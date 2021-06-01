package com.zebra.framework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import com.zebra.framework.exrend.AuthExrend;
import com.zebra.framework.util.ShiroUtils;
import com.zebra.system.domain.page.SysUserPage;

/**
 *
 * Title: AuthExrendInterceptor.java<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年4月30日
 *
 */
@Configuration
public class AuthExrendInterceptor extends AuthExrend implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			SysUserPage sysUser = ShiroUtils.getSysUser();
			if (sysUser != null && sysUser.getAdminStatus() == null) {
				super.Auth(sysUser);
			}
		} catch (Exception e) {
		}
		return true;

	}
}
