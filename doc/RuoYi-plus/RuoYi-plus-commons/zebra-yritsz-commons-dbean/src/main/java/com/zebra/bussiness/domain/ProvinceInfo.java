package com.zebra.bussiness.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * t_province_info表 ProvinceInfo
 * 
 * @author zebra
 * @date 2020-06-05
 */
@Table(name="t_province_info")
@Getter
@Setter
@ToString
public class ProvinceInfo extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 省份编码 */
     @Id
     private String provinceId;

    /** 省份名称 */
     @Excel(name = "${comment}")
     @Column(name="province_name")
     private String provinceName;
     
     /** 创建时间 */
     @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="create_time")
     private Date createTime;

    /** 更新时间 */
     @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="update_time")
     private Date updateTime;

}
