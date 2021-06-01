package com.wms.oms.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 库存信息对象 wms_inventory
 *
 * @author zzm
 * @date 2021-05-16
 */
@Data
@TableName("wms_inventory")
public class Inventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** skuId */
    private Long skuId;

    /** 仓库id */
    private Long warehouseId;

    /** 库存数量 */
    private BigDecimal qty;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;

    /** 版本号 */
    @Version
    private Integer version;

}