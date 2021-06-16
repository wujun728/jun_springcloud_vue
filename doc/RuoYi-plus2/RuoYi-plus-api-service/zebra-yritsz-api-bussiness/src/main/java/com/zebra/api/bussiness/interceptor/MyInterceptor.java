/**
 *@author am
 */
package com.zebra.api.bussiness.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zebra.api.bussiness.enums.LogDescribeEnum;
import com.zebra.api.commons.bean.Json;
import com.zebra.api.commons.config.ConfigServerRedis;
import com.zebra.api.commons.enums.ResultEnum;
import com.zebra.api.commons.util.Constant;
import com.zebra.api.commons.util.RequestUtil;
import com.zebra.api.commons.util.SignConstants;
import com.zebra.api.commons.util.SignConstants.SignType;
import com.zebra.api.commons.util.SignUtil;
import com.zebra.bussiness.domain.ApiSecurity;
import com.zebra.common.redis.realize.base.RealizeBase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyInterceptor implements HandlerInterceptor {
	@Value("${api.security.enabled}")
	private Boolean API_SECURITY;
	@Autowired
	private RealizeBase<ApiSecurity> apiSecurityRealize;
	@Autowired
	private ConfigServerRedis configServerRedis;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Boolean flag = true;
		request.setAttribute(Constant.TIME_START, System.currentTimeMillis());
		String key = "";
		String tokenKey = "";
		key = request.getHeader(Constant.HAND_KEY);
		if (!API_SECURITY) {
			log.info(LogDescribeEnum.NO_ENABLED.getMsg());
			return true;
		}
		if (StringUtils.isEmpty(key)) {
			log.info(LogDescribeEnum.NO_HEADER.getMsg(), request.getRequestURI());
			return this.failInterceptor(response);
		}
		MDC.put("index", key);
		log.info("[信息]-<<<请求地址>>>-{}", request.getRequestURI());
		ApiSecurity apiSecurit = apiSecurityRealize.getHk(configServerRedis.getKey(), key);
		if (apiSecurit == null) {
			log.info(LogDescribeEnum.SECURIT_NLL.getMsg(), key);
			return this.failInterceptor(response);
		}
		if (!apiSecurit.getApiStatus()) {
			log.info(LogDescribeEnum.SECURIT_STATUS.getMsg(), key);
			return this.failInterceptor(response);
		}
		String secret = apiSecurit.getApiSecret();
		tokenKey = RequestUtil.readJSONString(request);
		log.info("[请求]-" + tokenKey);
		if (StringUtils.isEmpty(tokenKey)) {
			log.info(LogDescribeEnum.SIGN_NULL.getMsg());
			return this.failInterceptor(response);
		}
		try {
			if (!SignUtil.getSignIsNotKey(tokenKey)) {
				flag = false;
			} else {
				Map<String, Object> map = JSON.parseObject(tokenKey);
				log.debug("[信息]获取签名：{}", map.toString());
				String signParam = map.get(SignConstants.FIELD_SIGN).toString();
				String TOKEN_TIME = map.get(SignConstants.TOKEN_TIME).toString();
				String TOKEN_NONCE_STR = map.get(SignConstants.TOKEN_NONCE_STR).toString();
				if (!SignUtil.getSignIsNull(signParam, TOKEN_TIME, TOKEN_NONCE_STR)) {
					flag = false;
				} else {
					String singServer = SignUtil.generateSignature(map, secret, SignType.HMACSHA256);
					if (!signParam.equals(singServer)) {
						log.info(LogDescribeEnum.SIGN_FAIL.getMsg(), singServer);
						flag = false;
					}
				}
			}

		} catch (Exception e) {
			log.error("[信息]校验签名时发生异常", e);
			flag = false;
		}
		if (!flag) {
			return failInterceptor(response);
		}
		request.setAttribute(Constant.REQUEST_PARAM, tokenKey);
		return true;
	}

	/**
	 * 拦截器过滤失败
	 *
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public boolean failInterceptor(HttpServletResponse response) throws IOException {
		PrintWriter out = null;
		try {
			Object res = JSONObject.toJSON(Json.other(ResultEnum.ERROR_TOKEN));
			out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			out.println(res.toString());
			log.info("[信息]-响应：{}", res.toString());
			MDC.remove("index");
			MDC.clear();
			out.flush();
			out.close();
			return false;
		} catch (Exception e) {
			log.error("[信息]校验签名失败：响应发生异常", e);
			response.sendError(500);
			MDC.remove("index");
			MDC.clear();
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long attribute = (Long) request.getAttribute(Constant.TIME_START);
		long time = System.currentTimeMillis() - attribute;
		log.info("[信息]-响应时间" + time + "毫秒");
		MDC.remove("index");
		MDC.clear();
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
