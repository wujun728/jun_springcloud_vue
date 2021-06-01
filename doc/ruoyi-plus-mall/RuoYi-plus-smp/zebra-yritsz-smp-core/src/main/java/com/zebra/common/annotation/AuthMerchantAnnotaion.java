package com.zebra.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zebra.common.constant.Constants;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthMerchantAnnotaion {
	/**
	 * 表的别名
	 */
	public String tableAlias() default "";

	/**
	 * 权限字段
	 */
	public String fieldAlias() default Constants.AUTH_FILED;

}
