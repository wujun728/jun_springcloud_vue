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
 * t_specs_type表 SpecsType
 * 
 * @author zebra
 * @date 2020-09-15
 */
@Table(name="t_specs_type")
@Getter
@Setter
@ToString
public class SpecsType extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** $column.columnComment */
     @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
     @Id
     private String specsTypeId;

    /** $column.columnComment */
     @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
     @Column(name="specs_type")
     private String specsType;

    /** 排序 */
     @Excel(name = "排序")
     @Column(name="zebra_order")
     private Integer zebraOrder;

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
