package com.zebra.bussiness.domain;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * t_commodity_category表 CommodityCategory
 * 
 * @author zebra
 * @date 2020-06-11
 */
@Table(name="t_commodity_category")
@Getter
@Setter
@ToString
public class CommodityCategory extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 类别id */
     @Id
     private Long categoryId;

    /** 类别名称 */
     @Excel(name = "类别名称")
     @Column(name="category_name")
     private String categoryName;

    /** 类别属性（1一级 2二级） */
     @Excel(name = "类别属性", readConverterExp = "1=一级,2=二级")
     @Column(name="category_attribute")
     private Integer categoryAttribute;

    /** 父级id */
     @Excel(name = "父级id")
     @Column(name="category_parid")
     private Long categoryParid;

    /** icon图片 */
     @Excel(name = "icon图片")
     @Column(name="category_icon")
     private String categoryIcon;

    /** 排序 */
     @Excel(name = "排序")
     @Column(name="zebra_order")
     private Integer zebraOrder;

    /** 商户id */
     @Excel(name = "商户id")
     @Column(name="merchant_id")
     private String merchantId;

    /** 创建时间 */
     @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="create_time")
     private Date createTime;

    /** 更新时间 */
     @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="update_time")
     private Date updateTime;

    /** 操作人 */
     @Excel(name = "操作人")
     @Column(name="update_by")
     private String updateBy;

}