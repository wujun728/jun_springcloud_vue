package com.wms.system.api.factory;

import com.wms.system.api.RemoteUserService;
import com.wms.system.api.model.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.wms.common.core.domain.R;
import feign.hystrix.FallbackFactory;

import java.util.List;

/**
 * 用户服务降级处理
 * 
 * @author wms
 */
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public RemoteUserService create(Throwable throwable)
    {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService()
        {
            @Override
            public R<LoginUser> getUserInfo(String username)
            {
                return R.fail("获取用户失败:" + throwable.getMessage());
            }

            @Override
            public R<List> selectAllUser() {
                return R.fail("获取用户列表失败:" + throwable.getMessage());
            }
        };
    }
}
