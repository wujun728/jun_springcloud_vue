package com.zebra.bussiness.cms.domain;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;
import java.util.Date;

/**
 * cms_category表 CmsCategory
 * 
 * @author zebra
 * @date 2020-06-24
 */
@Table(name="cms_category")
@Getter
@Setter
@ToString
public class CmsCategory extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 分类ID */
     @Id
     private Long categoryId;

    /** 分类名称 */
     @Excel(name = "分类名称")
     @Column(name="category_name")
     private String categoryName;

    /** 父ID */
     @Excel(name = "父ID")
     @Column(name="category_parent_id")
     private Long categoryParentId;

    /** ids */
     @Column(name="category_ancestors")
     private String categoryAncestors;

    /** 排序 */
     @Column(name="category_sort")
     private Integer categorySort;

    /** 分类描述 */
     @Column(name="category_description")
     private String categoryDescription;

    /** 创建时间 */
     @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="create_time")
     private Date createTime;

    /** 更新时间 */
     @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="update_time")
     private Date updateTime;

    /** 更新人 */
     @Excel(name = "更新人")
     @Column(name="update_by")
     private String updateBy;

    /** 状态（0停用 1启用） */
     @Excel(name = "状态", readConverterExp = "0=停用,1=启用")
     @Column(name="category_status")
     private Integer categoryStatus;

    /** 删除标志（1删除 0正常） */
     @Column(name="del_flag")
     private Integer delFlag;

}
