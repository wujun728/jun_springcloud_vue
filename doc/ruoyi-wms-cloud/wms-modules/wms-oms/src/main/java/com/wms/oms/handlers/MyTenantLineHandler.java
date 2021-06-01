package com.wms.oms.handlers;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.wms.common.core.utils.StringUtils;
import com.wms.common.security.service.TokenService;
import com.wms.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NullValue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Slf4j
public class MyTenantLineHandler implements TenantLineHandler {

    /**
     * 排除过滤的表
     */
    private static final String[] tableList = {};

    /**
     * 排除过滤的表前缀
     */
    private static final String[] tablePrefix = {};

    @Autowired
    private TokenService tokenService;


    /**
     * 返回当前用户的租户ID
     */
    @Override
    public Expression getTenantId() {
        // 取出当前请求的服务商ID，通过解析器注入到SQL中。
        Long tenantId = tokenService.getLoginUser() != null ? tokenService.getLoginUser().getTenantId() : null;
//        log.debug("当前租户为:{}", tenantId);
        if (tenantId == null) {
            return new NullValue();
        }
        return new LongValue(tenantId);
    }

    /**
     * 跳过不需要加多租户的表
     */
    @Override
    public boolean ignoreTable(String tableName) {
        String prefix = StringUtils.substringBefore(tableName, "_");
        if (Arrays.asList(tableList).contains(tableName) || Arrays.asList(tablePrefix).contains(prefix) ||  getCurrentTenantId() == null) {
            return true;
        }
        return false;
    }

    /**
     * 当前租户Id
     */
    private Long getCurrentTenantId() {
        LoginUser loginUser = tokenService.getLoginUser();
        if (loginUser != null) {
            return loginUser.getTenantId();
        }
        return null;
    }

}
