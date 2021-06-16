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
 * t_activity_commodity表 ActivityCommodity
 * 
 * @author zebra
 * @date 2020-09-09
 */
@Table(name="t_activity_commodity")
@Getter
@Setter
@ToString
public class ActivityCommodity extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 参与编号 */
     @Excel(name = "参与编号")
     @Id
     private String id;

    /** 活动id */
     @Excel(name = "活动id")
     @Column(name="activity_id")
     private String activityId;

    /** 产品id */
     @Excel(name = "产品id")
     @Column(name="commodity_id")
     private String commodityId;

    /** 商品数量 */
     @Excel(name = "商品数量")
     @Column(name="commodity_count")
     private Integer commodityCount;

    /** 开始时间 */
     @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="start_time")
     private Date startTime;

    /** 结束时间 */
     @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="end_time")
     private Date endTime;

    /** 团购人数 */
     @Excel(name = "团购人数")
     @Column(name="buyers_number")
     private Integer buyersNumber;

    /** 优惠费用 */
     @Excel(name = "优惠费用")
     @Column(name="preferential")
     private Integer preferential;

    /** 审核状态（1审核通过 2待审核 3审核拒绝） */
     @Excel(name = "审核状态", readConverterExp = "1=审核通过,2=待审核,3=审核拒绝")
     @Column(name="examine_status")
     private Integer examineStatus;

    /** 审核描述 */
     @Excel(name = "审核描述")
     @Column(name="examine_desc")
     private String examineDesc;

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
     @Column(name="update_by")
     private String updateBy;

    /** 数据版本 */
     @Column(name="data_ver_flag")
     private Long dataVerFlag;

}
