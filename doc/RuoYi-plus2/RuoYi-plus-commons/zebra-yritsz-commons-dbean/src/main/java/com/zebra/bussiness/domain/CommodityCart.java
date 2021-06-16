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
 * t_commodity_cart表 CommodityCart
 * 
 * @author zebra
 * @date 2021-01-09
 */
@Table(name="t_commodity_cart")
@Getter
@Setter
@ToString
public class CommodityCart extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 购物车id */
     @Id
     private String cartId;

    /** 产品id */
     @Excel(name = "产品id")
     @Column(name="commodity_id")
     private String commodityId;

    /** 产品数量 */
     @Excel(name = "产品数量")
     @Column(name="commodity_count")
     private Integer commodityCount;

    /** 加入时价格 */
     @Excel(name = "加入时价格")
     @Column(name="commodity_money")
     private Double commodityMoney;

    /** 产品信息 */
     @Excel(name = "产品信息")
     @Column(name="commodity_json")
     private String commodityJson;

    /** 用户id */
     @Excel(name = "用户id")
     @Column(name="user_id")
     private String userId;

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

    /** 数据版本 */
     @Column(name="data_ver_flag")
     private Long dataVerFlag;

}
