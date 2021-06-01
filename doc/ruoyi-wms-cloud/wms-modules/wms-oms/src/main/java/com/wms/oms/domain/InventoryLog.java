package com.wms.oms.domain;

import java.math.BigDecimal;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 库存操作日志对象 wms_inventory_log
 *
 * @author zzm
 * @date 2021-05-16
 */
@Data
@TableName("wms_inventory_log")
public class InventoryLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 单号 */
    private String sn;

    /** 仓库id */
    private Long warehouseId;

    /** 库存变动类型(0-采购入库,1-销售出库,2-调拨入库,3-调拨出库,4-盘盈入库,5-盘亏出库) */
    private String inventoryType;

    /** 商品skuId */
    private Long skuId;

    /** 库存数量 */
    private BigDecimal qty;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;

}