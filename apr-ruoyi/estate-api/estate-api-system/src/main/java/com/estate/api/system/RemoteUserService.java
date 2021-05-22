package com.estate.api.system;

import com.estate.api.system.config.FeignConfig;
import com.estate.api.system.factory.RemoteUserFallbackFactory;
import com.estate.api.system.model.LoginUser;
import com.estate.api.system.vo.RouterVo;
import com.estate.common.core.constant.ServiceNameConstants;
import com.estate.common.core.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 用户服务
 *
 * @author ruoyi
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.USER_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class, configuration = {FeignConfig.class})
public interface RemoteUserService {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 结果
     */
    @GetMapping(value = "/system/user/info/{username}")
    R<LoginUser> getUserInfo(@PathVariable("username") String username);

    @GetMapping(value = "/system/menu/user/router/{userId}")
    R<List<RouterVo>> getRouters(@PathVariable("userId") Long userId);
}
