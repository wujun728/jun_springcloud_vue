package com.wms.system.api.factory;

import com.wms.system.api.domain.SysOperLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.wms.common.core.domain.R;
import com.wms.system.api.RemoteLogService;
import feign.hystrix.FallbackFactory;

/**
 * 日志服务降级处理
 * 
 * @author wms
 */
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteLogFallbackFactory.class);

    @Override
    public RemoteLogService create(Throwable throwable)
    {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new RemoteLogService()
        {
            @Override
            public R<Boolean> saveLog(SysOperLog sysOperLog)
            {
                return null;
            }

            @Override
            public R<Boolean> saveLogininfor(String username, String status, String message)
            {
                return null;
            }
        };

    }
}
