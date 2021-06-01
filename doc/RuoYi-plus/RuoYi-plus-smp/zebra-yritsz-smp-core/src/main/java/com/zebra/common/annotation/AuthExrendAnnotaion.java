package com.zebra.common.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * Title: 权限扩展注解<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年4月21日
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthExrendAnnotaion {

}
