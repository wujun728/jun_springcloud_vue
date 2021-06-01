package com.wms.oms.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品sku对象
 *
 * @author zzm
 * @date 2021-05-16
 */
@Data
public class ProductDto implements Serializable {


    private Long id;

    /** 商品编号 */
    private String sn;


    /** 商品类别id */
    private Long categoryId;

    /** 是否多规格 */
    private Boolean isSpec;

    /** 商品名称 */
    private String productName;

    /** sku图片 */
    private String images;

    /** 备注 */
    private String remark;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;

    /** 商品条码 */
    private String barCode;

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

}
