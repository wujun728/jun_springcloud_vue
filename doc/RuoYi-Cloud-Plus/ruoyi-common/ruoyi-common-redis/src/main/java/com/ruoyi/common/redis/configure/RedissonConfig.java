package com.ruoyi.common.redis.configure;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * redisson配置
 *
 * @author rayson.fang
 * @date 2021/05/26 17:27
 **/
@Configuration
public class RedissonConfig {
    @Autowired
    RedisProperties redisProperties;
    
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        String redisUrl = String.format("redis://%s:%s", redisProperties.getHost() + "", redisProperties.getPort() + "");
        config.useSingleServer().setAddress(redisUrl);
        if (StringUtils.isNotEmpty(redisProperties.getPassword())) {
            config.useSingleServer().setPassword(redisProperties.getPassword());
        }
        
        //config.useSingleServer().setDatabase(3);
        
        //添加主从配置
        // config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});
        // 集群模式配置 setScanInterval()扫描间隔时间，单位是毫秒, //可以用"rediss://"来启用SSL连接
        // config.useClusterServers().setScanInterval(2000).addNodeAddress("redis://127.0.0.1:7000", "redis://127.0.0.1:7001").addNodeAddress("redis://127.0.0.1:7002");
        return Redisson.create(config);
    }
}
