/**
 * @author am
 * 2018-07-02
 * 1.0.1
 */

package com.zebra.api.order.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zebra.api.commons.util.RequestUtil;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Slf4j
public class LogAspect {

	@Pointcut("@annotation(com.zebra.api.order.aop.LogAnnotation)")
	public void logAspect() {
	}

	@Before("logAspect()")
	public void doBefore(JoinPoint joinPoint) {
		String opertype = "";
		try {
			opertype = getlogAnnotationOper(joinPoint);
		} catch (Exception e) {
			log.error("[信息]通过反射获取注解描述失败", e);
		}
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String ip = RequestUtil.getIpAddr(request);
		log.info("[信息]-[{}]-【{}】", ip, opertype);

	}

	@AfterReturning(pointcut = "logAspect()", returning = "j")
	public void doAfterReturning(JoinPoint joinPoint, Object j) {
	}

	/**
	 * 返回LogAnnotation 注解类中的oper
	 *
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getlogAnnotationOper(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Method[] methods = Class.forName(targetName).getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				if (method.getParameterTypes().length == method.getParameterTypes().length) {
					description = method.getAnnotation(LogAnnotation.class).oper().toString();
					break;
				}
			}
		}
		return description;
	}
}
