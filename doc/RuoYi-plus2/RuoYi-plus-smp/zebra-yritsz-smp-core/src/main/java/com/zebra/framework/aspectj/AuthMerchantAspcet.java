package com.zebra.framework.aspectj;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zebra.common.annotation.AuthMerchantAnnotaion;
import com.zebra.common.core.domain.BussinessEntity;
import com.zebra.common.utils.StringUtils;
import com.zebra.framework.util.ShiroUtils;

@Aspect
@Component
@Scope(value = "prototype")
public class AuthMerchantAspcet {
	/**
	 * 数据权限过滤关键字
	 */
	public static final String DATA_SCOPE = "dataMerchantAuth";

	@Pointcut("@annotation(com.zebra.common.annotation.AuthMerchantAnnotaion)")
	public void authMerchantAspect() {
	}

	@Before("authMerchantAspect()")
	public void doAfterReturning(JoinPoint joinPoint) {
		// 获得注解
		AuthMerchantAnnotaion controllerDataScope = getAnnotationLog(joinPoint);
		if (controllerDataScope == null) {
			return;
		} // 获取当前的用户商户权限
		List<Object> list = ShiroUtils.getObjs();
		this.dataScopeFilter(joinPoint, list, controllerDataScope.tableAlias(), controllerDataScope.fieldAlias());
	}

	/**
	 * 商户数据范围过滤
	 *
	 * @param joinPoint
	 * @param list
	 * @param tableAlias
	 * @param fieldAlias
	 */
	private void dataScopeFilter(JoinPoint joinPoint, List<Object> list, String tableAlias, String fieldAlias) {
		BussinessEntity baseEntity = (BussinessEntity) joinPoint.getArgs()[0];
		String sql = null;
		if (list != null && list.size() > 0) {
			StringBuffer stringBuffer = new StringBuffer("(");
			int i = 0;
			for (Object str : list) {
				if (i == 0) {
					stringBuffer.append(StringUtils.format("{}{}{}", "'", String.valueOf(str), "'"));
				} else {
					stringBuffer.append(StringUtils.format("{}{}{}{}", ",", "'", String.valueOf(str), "'"));
				}
				i++;
			}
			stringBuffer.append(")");

			if (!StringUtils.isEmpty(tableAlias)) {
				fieldAlias = StringUtils.format("{}{}{}", tableAlias, ".", fieldAlias);
			}
			sql = StringUtils.format("{}{}{}", fieldAlias, " in ", stringBuffer.toString());

		}
		baseEntity.getParams().put(DATA_SCOPE, sql);
	}

	/**
	 * 是否存在注解，如果存在就获取
	 */
	private AuthMerchantAnnotaion getAnnotationLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();

		if (method != null) {
			return method.getAnnotation(AuthMerchantAnnotaion.class);
		}
		return null;
	}

}
