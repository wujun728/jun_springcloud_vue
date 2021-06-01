package com.wms.system.api.factory;

import com.wms.system.api.RemoteFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.wms.common.core.domain.R;
import com.wms.system.api.domain.SysFile;
import feign.hystrix.FallbackFactory;

/**
 * 文件服务降级处理
 * 
 * @author wms
 */
@Component
public class RemoteFileFallbackFactory implements FallbackFactory<RemoteFileService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteFileFallbackFactory.class);

    @Override
    public RemoteFileService create(Throwable throwable)
    {
        log.error("文件服务调用失败:{}", throwable.getMessage());
        return new RemoteFileService()
        {
            @Override
            public R<SysFile> upload(MultipartFile file)
            {
                return R.fail("上传文件失败:" + throwable.getMessage());
            }
        };
    }
}
