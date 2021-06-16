package com.zebra.framework.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zebra.common.core.domain.AjaxResult;
import com.zebra.framework.exrend.AuthExrend;
import com.zebra.framework.util.ShiroUtils;
import com.zebra.system.domain.SysUser;

@Aspect
@Component
@Scope(value = "prototype")
public class AuthExrendAspcet extends AuthExrend{

	@Pointcut("@annotation(com.zebra.common.annotation.AuthExrendAnnotaion)")
	public void logAspect() {
	}

	@AfterReturning(pointcut = "logAspect()", returning = "j")
	public void doAfterReturning(JoinPoint joinPoint, Object j) {
		AjaxResult ajaxResult = AjaxResult.error();
		if (j instanceof AjaxResult) {
			ajaxResult = (AjaxResult) j;
		}
		if (ajaxResult.getCode() == 0) {
			SysUser sysUser = ShiroUtils.getSysUser();
			if (sysUser != null) {
				super.Auth(sysUser);
			}
		}

	}
}
