package com.zebra.api.commons.catchexception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.zebra.api.commons.bean.Json;
import com.zebra.api.commons.enums.ResultEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * 请求错误捕捉
 *
 * @author zebra
 *
 * @param <T>
 */
@Slf4j
@RestControllerAdvice
public class DeployException<T> implements ResponseBodyAdvice<T> {
	@Override
	public T beforeBodyWrite(T t, MethodParameter arg1, MediaType arg2, Class<? extends HttpMessageConverter<?>> arg3,
			ServerHttpRequest arg4, ServerHttpResponse arg5) {
		return t;
	}

	@Override
	public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
		return true;
	}

	@ExceptionHandler(value = Exception.class)
	public Json defaultErrorHandler(Exception e, HttpServletResponse response) throws Exception {
		this.Throwing(e);
		if (e instanceof HttpRequestMethodNotSupportedException) {
			response.setStatus(400);
			return Json.other(ResultEnum.ERROR_400);
		} else if (e instanceof HttpMessageNotReadableException) {
			response.setStatus(400);
			return Json.other(ResultEnum.ERROR_400);
		} else if (e instanceof NoHandlerFoundException) {
			response.setStatus(404);
			return Json.other(ResultEnum.ERROR_404);
		} else {
			response.setStatus(500);
			return Json.other(ResultEnum.ERROR_500);
		}
	}

	private void Throwing(Exception ex) {
		log.info("[信息]异常：" + ex.getMessage());
		log.info("[信息]异常：" + ex.getStackTrace());
		StringBuffer sb = new StringBuffer("");
		for (int k = 0; k < ex.toString().length() + 10; k++) {
			sb.append("*");
		}
		log.info(sb.toString());
		log.info("*");
		log.info("*     日志定位：error_" + ex.hashCode());
		log.info("*     异常信息：" + ex.toString());
		log.info("*     相关位置：");
		for (int i = 0; i < ex.getStackTrace().length; i++) {
			StackTraceElement stackTraceElement = ex.getStackTrace()[i];
			if (stackTraceElement.getClassName().startsWith("com.zebra")) {
				log.info("*" + stackTraceElement.toString());
			}
		}
	}
}
