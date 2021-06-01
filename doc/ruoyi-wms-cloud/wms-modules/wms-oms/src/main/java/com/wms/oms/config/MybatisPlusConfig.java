package com.wms.oms.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;

import com.wms.oms.handlers.MyMetaObjectHandler;
import com.wms.oms.handlers.MyTenantLineHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus 配置
 *
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(blockAttackInnerInterceptor());
        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor());
        interceptor.addInnerInterceptor(tenantLineInnerInterceptor());
        return interceptor;
    }

    /**
     * 多租户过滤
     */
    @Bean
    public MyTenantLineHandler myTenantLineHandler() {
        return new MyTenantLineHandler();
    }

    /**
     * 多租户
     */
    @Bean
    public TenantLineInnerInterceptor tenantLineInnerInterceptor() {
        return new TenantLineInnerInterceptor(myTenantLineHandler());
    }

    /**
     * 防止全表更新与删除
     */
    @Bean
    public BlockAttackInnerInterceptor blockAttackInnerInterceptor() {
        return new BlockAttackInnerInterceptor();
    }

    /**
     * 乐观锁
     */
    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }

    /**
     * 自动填充
     */
    @Bean
    public MyMetaObjectHandler myMetaObjectHandler() {
        return new MyMetaObjectHandler();
    }


}