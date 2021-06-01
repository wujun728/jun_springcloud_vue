package com.wms.oms.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wms.common.core.web.domain.BaseEntity;
import com.wms.oms.handlers.SpecAttrListHandler;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 商品信息对象 wms_product
 *
 * @author zzm
 * @date 2021-05-04
 */
@Data
@TableName("wms_product")
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 商品编号 */
    private String sn;

    /** 商品编码 */
    private String productCode;

    /** 商品类别id */
    @NotNull(message = "商户类别不能为空!")
    private Long categoryId;

    /** 是否多规格 */
    private Boolean isSpec;

    /** 商品名称 */
    @NotEmpty(message = "商品名称不能为空!")
    private String productName;

    /** 规格参数 */
    @TableField(typeHandler = SpecAttrListHandler.class)
    private List specList;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;

    /** 关联分类 */
    @TableField(exist = false)
    private ProductCategory productCategory;

    /** 关联sku */
    @TableField(exist = false)
    private List<ProductSku> productSkuList;

}