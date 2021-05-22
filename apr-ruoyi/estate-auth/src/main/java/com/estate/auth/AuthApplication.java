package com.estate.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.estate.api.system"})
// 使用@SpringBootApplication自带的@ComponentScan注解默认无法把其他模块的依赖加入IOC容器
// 手动定义@ComponentScan注解会把@SpringBootApplication中的@ComponentScan注解代替
// 手动定义的@ComponentScan优先级最高
// 这里我们需要把auth，system，security，redis模块中的类加入到IOC容器中，他们都在com.estate包下，所以可以简写成com.estate
// @ComponentScan(basePackages = {"com.estate"})//默认扫描当前包和所有子包。
// 它们的依赖关系是 auth -> security -> (system -> core, redis)
@ComponentScan(basePackages = {"com.estate.auth","com.estate.api.system","com.estate.common.security","com.estate.common.redis"})
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
