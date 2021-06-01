package com.wms.oms.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.wms.oms.handlers.SpecAttrListHandler;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 * 商品规格对象 wms_product_spec
 *
 * @author zzm
 * @date 2021-05-14
 */
@Data
@TableName("wms_product_spec")
public class ProductSpec extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 规格名称 */
    private String specName;

    /** 规格属性 */
    @TableField(typeHandler = SpecAttrListHandler.class)
    private List specAttr;

    /** 删除标志（0代表存在 1代表删除） */
    private Boolean delFlag;

    /** 租户ID */
    private Long tenantId;


}