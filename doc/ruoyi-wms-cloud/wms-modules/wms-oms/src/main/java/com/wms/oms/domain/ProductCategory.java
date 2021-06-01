package com.wms.oms.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import com.wms.common.core.web.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类信息对象 wms_product_category
 *
 * @author zzm
 * @date 2021-05-14
 */
@Data
@TableName("wms_product_category")
public class ProductCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 分类名称 */
    private String categoryName;

    /** 父类别id */
    private Long parentId;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    /** 租户ID */
    private Long tenantId;

    /** 子菜单 */
    @TableField(exist = false)
    private List<ProductCategory> children = new ArrayList<ProductCategory>();

}