package com.ruoyi.common.security.annotation;

import com.ruoyi.common.security.feign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 自定义feign注解
 * 添加basePackages路径
 *
 * @author ruoyi
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableRyFeignClients {
    String[] value() default {};
    
    String[] basePackages() default {"com.ruoyi"};
    
    Class<?>[] basePackageClasses() default {};
    
    Class<?>[] defaultConfiguration() default {FeignAutoConfiguration.class};
    
    Class<?>[] clients() default {};
}
