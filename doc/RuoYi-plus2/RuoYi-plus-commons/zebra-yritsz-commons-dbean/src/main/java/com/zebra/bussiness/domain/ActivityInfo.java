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
 * t_activity_info表 ActivityInfo
 * 
 * @author zebra
 * @date 2020-09-09
 */
@Table(name="t_activity_info")
@Getter
@Setter
@ToString
public class ActivityInfo extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 活动id */
     @Id
     private String activityId;

    /** 活动名称 */
     @Excel(name = "活动名称")
     @Column(name="activity_name")
     private String activityName;

    /** 类别id(空不限制) */
     @Excel(name = "类别id(空不限制)")
     @Column(name="category_id")
     private Long categoryId;

    /** 活动图片 */
     @Excel(name = "活动图片")
     @Column(name="activity_img")
     private String activityImg;

    /** 活动信息 */
     @Excel(name = "活动信息")
     @Column(name="activity_info")
     private String activityInfo;

    /** 活动类型（1团购 2秒杀 3普通） */
     @Excel(name = "活动类型", readConverterExp = "1=团购,2=秒杀,3=普通")
     @Column(name="activity_type")
     private Integer activityType;

    /** 活动属性（1需要审核 2无需审核） */
     @Excel(name = "活动属性", readConverterExp = "1=需要审核,2=无需审核")
     @Column(name="activity_attribute")
     private Integer activityAttribute;

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

    /** 数据版本 */
     @Column(name="data_ver_flag")
     private Long dataVerFlag;

    /** 删除标志（0代表存在 2代表删除） */
     @Column(name="del_flag")
     private String delFlag;

}
