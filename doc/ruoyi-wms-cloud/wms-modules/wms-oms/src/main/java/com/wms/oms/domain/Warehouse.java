package com.wms.oms.domain;

import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotEmpty;

/**
 * 仓库信息对象 wms_warehouse
 *
 * @author zzm
 * @date 2021-05-14
 */
@Data
@TableName("wms_warehouse")
public class Warehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 仓库编号 */
    private String sn;

    /** 仓库名称 */
    @NotEmpty(message = "仓库名称不能为空！")
    private String warehouseName;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;

}