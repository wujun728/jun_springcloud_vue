package com.wms.oms.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.wms.oms.handlers.SpecAttrListHandler;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 商品sku信息对象 wms_product_sku
 *
 * @author zzm
 * @date 2021-05-15
 */
@Data
@TableName("wms_product_sku")
public class ProductSku extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 商品编号 */
    private String sn;

    /** 商品条码 */
    private String barCode;

    /** 商品sku名称 */
    private String skuName;

    /** 规格 */
    private String specifications;


    /** 商品id */
    private Long productId;

    /** 零售价 */
    private BigDecimal salePrice;

    /** 批发价 */
    private BigDecimal tradePrice;

    /** 会员价 */
    private BigDecimal vipPrice;

    /** 折扣一 */
    private BigDecimal discount1;

    /** 折扣二 */
    private BigDecimal discount2;

    /** 预计采购价 */
    private BigDecimal purchasePrice;

    /** 图片 */
    private String images;


    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;

}