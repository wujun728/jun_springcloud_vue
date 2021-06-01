package com.wms.oms.domain;

import java.math.BigDecimal;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 销售订单明细对象 wms_sale_order_item
 *
 * @author zzm
 * @date 2021-05-16
 */
@Data
@TableName("wms_sale_order_item")
public class SaleOrderItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 销售订单主表id */
    private Long saleOrderId;

    /** 商品id */
    private Long productId;

    /** sku_id */
    private Long skuId;

    /** 仓库id */
    private Long warehouseId;

    /** 销售单价 */
    private BigDecimal price;

    /** 销售数量 */
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