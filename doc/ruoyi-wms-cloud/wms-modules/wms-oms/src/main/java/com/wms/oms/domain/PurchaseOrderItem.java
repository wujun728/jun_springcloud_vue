package com.wms.oms.domain;

import java.math.BigDecimal;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 采购订单明细对象 wms_purchase_order_item
 *
 * @author zzm
 * @date 2021-05-16
 */
@Data
@TableName("wms_purchase_order_item")
public class PurchaseOrderItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 订单主表id */
    private Long purchaseOrderId;

    /** 商品id */
    private Long productId;

    /** skuId */
    private Long skuId;

    /** 仓库id */
    private Long warehouseId;

    /** 购买单价 */
    private BigDecimal price;

    /** 购买数量 */
    private BigDecimal qty;

    /** 优惠率 */
    private BigDecimal discountRate;

    /** 优惠金额 */
    private BigDecimal discountAmount;

    /** 金额 */
    private BigDecimal amount;

    /** 备注 */
    private String memo;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;

}