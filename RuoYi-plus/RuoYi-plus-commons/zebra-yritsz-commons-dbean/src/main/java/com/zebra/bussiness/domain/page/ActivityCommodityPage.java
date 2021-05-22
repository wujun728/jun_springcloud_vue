package com.zebra.bussiness.domain.page;

import com.zebra.bussiness.domain.ActivityCommodity;
import com.zebra.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class ActivityCommodityPage extends ActivityCommodity {
    private static final long serialVersionUID = 1L;
    /**
     * 商户名称
     */
    @Excel(name = "所属商户")
    private String merchantName;
    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String commodityName;

    /**
     * 活动名称
     */
    @Excel(name = "活动名称")
    @Column(name = "activity_name")
    private String activityName;

    /**
     * 商品状态（1上架 2下架）
     */
    @Excel(name = "商品状态", readConverterExp = "1=上架,2=下架")
    @Column(name = "commodity_status")
    private Integer commodityStatus;


    /**
     * 商品费用
     */
    @Excel(name = "商品原价")
    @Column(name = "commodity_moeny")
    private Integer commodityMoeny;
}
