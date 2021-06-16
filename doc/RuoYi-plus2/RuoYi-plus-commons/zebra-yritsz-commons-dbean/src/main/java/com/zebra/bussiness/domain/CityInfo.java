package com.zebra.bussiness.domain;

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
 * t_city_info表 CityInfo
 * 
 * @author zebra
 * @date 2020-06-05
 */
@Table(name="t_city_info")
@Getter
@Setter
@ToString
public class CityInfo extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 城市代码 */
     @Id
     private String cityCode;

    /** 城市名称 */
     @Excel(name = "城市名称")
     @Column(name="city_name")
     private String cityName;

    /** 省份id */
     @Excel(name = "省份id")
     @Column(name="province_id")
     private String provinceId;

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
