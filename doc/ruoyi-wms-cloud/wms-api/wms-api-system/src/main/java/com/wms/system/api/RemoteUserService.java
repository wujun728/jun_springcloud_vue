package com.wms.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.wms.common.core.constant.ServiceNameConstants;
import com.wms.common.core.domain.R;
import com.wms.system.api.factory.RemoteUserFallbackFactory;
import com.wms.system.api.model.LoginUser;

import java.util.List;

/**
 * 用户服务
 * 
 * @author wms
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService
{
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 结果
     */
    @GetMapping(value = "/user/info/{username}")
    public R<LoginUser> getUserInfo(@PathVariable("username") String username);

    /**
     * 查询所有当前租户下的用户
     * @return
     */
    @GetMapping(value = "/user/all")
    R<List> selectAllUser();

}
