package com.cloud.user.config;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 开启session共享
 * 
 * @author 小威老师
 *
 */
@EnableRedisHttpSession
public class SessionConfig {

}
