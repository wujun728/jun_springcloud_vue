package com.estate.api.system.factory;

import com.estate.api.system.RemoteUserService;
import com.estate.api.system.model.LoginUser;
import com.estate.api.system.vo.RouterVo;
import com.estate.common.core.result.R;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户服务降级处理
 *
 * @author ruoyi
 */
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService() {
            @Override
            public R<LoginUser> getUserInfo(String username) {
                return R.fail("获取用户失败:" + throwable.getMessage());
            }

            @Override
            public R<List<RouterVo>> getRouters(Long userId) {
                return R.fail("获取路由列表失败:" + throwable.getMessage());
            }
        };
    }
}