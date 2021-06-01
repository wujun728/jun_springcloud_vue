package com.wms.system.handlers;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import com.wms.common.core.utils.DateUtils;
import com.wms.common.security.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * 填充器
 */
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Autowired
    private TokenService tokenService;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        if (Objects.isNull(metaObject.getValue("createBy"))) {
            metaObject.setValue("createBy", tokenService.getLoginUser().getUsername());
        }
        if (Objects.isNull(metaObject.getValue("createTime"))) {
            metaObject.setValue("createTime", DateUtils.getNowDate());
        }
        if (Objects.isNull(metaObject.getValue("delFlag"))) {
            metaObject.setValue("delFlag", 0);
        }
        if (metaObject.hasGetter("tenantId") && Objects.isNull(metaObject.getValue("tenantId"))) {
            metaObject.setValue("tenantId", tokenService.getLoginUser().getTenantId());
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        metaObject.setValue("updateBy", tokenService.getLoginUser().getUsername());
        metaObject.setValue("updateTime", DateUtils.getNowDate());
    }

}