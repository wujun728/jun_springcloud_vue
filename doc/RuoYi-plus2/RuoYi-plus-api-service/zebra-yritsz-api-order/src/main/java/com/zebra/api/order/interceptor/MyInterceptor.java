/**
 *@author am
 */
package com.zebra.api.order.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zebra.api.commons.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute(Constant.TIME_START, System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long attribute = (Long) request.getAttribute(Constant.TIME_START);
		long time = System.currentTimeMillis() - attribute;
		log.info("[信息]-响应时间" + time + "毫秒");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
