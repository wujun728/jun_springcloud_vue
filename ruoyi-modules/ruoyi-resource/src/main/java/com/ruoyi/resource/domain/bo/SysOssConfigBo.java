package com.ruoyi.resource.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 对象存储配置业务对象 sys_oss_config
 *
 * @author Lion Li
 * @author 孤舟烟雨
 * @date 2021-08-13
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("对象存储配置业务对象")
public class SysOssConfigBo extends BaseEntity {

    /**
     * 主建
     */
    @ApiModelProperty(value = "主建", required = true)
    @NotNull(message = "主建不能为空", groups = {EditGroup.class})
    private Long ossConfigId;

    /**
     * 配置key
     */
    @ApiModelProperty(value = "configKey", required = true)
    @NotBlank(message = "configKey不能为空", groups = {AddGroup.class, EditGroup.class})
    @Size(min = 2, max = 100, message = "configKey长度必须介于2和20 之间")
    private String configKey;

    /**
     * accessKey
     */
    @ApiModelProperty(value = "accessKey", required = true)
    @NotBlank(message = "accessKey不能为空", groups = {AddGroup.class, EditGroup.class})
    @Size(min = 2, max = 100, message = "accessKey长度必须介于2和100 之间")
    private String accessKey;

    /**
     * 秘钥
     */
    @ApiModelProperty(value = "secretKey", required = true)
    @NotBlank(message = "secretKey不能为空", groups = {AddGroup.class, EditGroup.class})
    @Size(min = 2, max = 100, message = "secretKey长度必须介于2和100 之间")
    private String secretKey;

    /**
     * 桶名称
     */
    @ApiModelProperty(value = "bucketName", required = true)
    @NotBlank(message = "bucketName不能为空", groups = {AddGroup.class, EditGroup.class})
    @Size(min = 2, max = 100, message = "bucketName长度必须介于2和100之间")
    private String bucketName;

    /**
     * 前缀
     */
    @ApiModelProperty(value = "前缀")
    private String prefix;

    /**
     * 访问站点
     */
    @ApiModelProperty(value = "endpoint", required = true)
    @NotBlank(message = "endpoint不能为空", groups = {AddGroup.class, EditGroup.class})
    @Size(min = 2, max = 100, message = "endpoint长度必须介于2和100之间")
    private String endpoint;

    /**
     * 是否https（Y=是,N=否）
     */
    @ApiModelProperty("是否https（Y=是,N=否）")
    private String isHttps;

    /**
     * 状态（0=正常,1=停用）
     */
    @ApiModelProperty("状态（0=正常,1=停用）")
    private String status;

    /**
     * 域
     */
    @ApiModelProperty(value = "region")
    private String region;

    /**
     * 扩展字段
     */
    @ApiModelProperty(value = "扩展字段")
    private String ext1;

}
