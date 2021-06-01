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
 * cms_material_group表 CmsMaterialGroup
 * 
 * @author zebra
 * @date 2020-06-24
 */
@Table(name="cms_material_group")
@Getter
@Setter
@ToString
public class CmsMaterialGroup extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 分组id */
     @Id
     private Long groupId;

    /** 父ID */
     @Excel(name = "父ID")
     @Column(name="group_parent_id")
     private Long groupParentId;

    /** 分组名称 */
     @Excel(name = "分组名称")
     @Column(name="group_name")
     private String groupName;

    /** 分组描述 */
     @Excel(name = "分组描述")
     @Column(name="groupd_escription")
     private String groupdEscription;

    /** 分组排序 */
     @Excel(name = "分组排序")
     @Column(name="group_sort")
     private Integer groupSort;

    /** 操作人 */
     @Excel(name = "操作人")
     @Column(name="update_by")
     private String updateBy;

    /** 创建时间 */
     @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="create_time")
     private Date createTime;

    /** 更新时间 */
     @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="update_time")
     private Date updateTime;

}
