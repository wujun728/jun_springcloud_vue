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
 * t_commodity_order_deputy表 CommodityOrderDeputy
 * 
 * @author zebra
 * @date 2021-01-09
 */
@Table(name="t_commodity_order_deputy")
@Getter
@Setter
@ToString
public class CommodityOrderDeputy extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** id */
     @Id
     private String deputyId;

    /** 产品id */
     @Excel(name = "产品id")
     @Column(name="commodity_id")
     private String commodityId;

    /** 产品数量 */
     @Excel(name = "产品数量")
     @Column(name="commodity_count")
     private Integer commodityCount;

    /** 产品信息 */
     @Excel(name = "产品信息")
     @Column(name="commodity_json")
     private String commodityJson;

    /** 产品金额 */
     @Excel(name = "产品金额")
     @Column(name="deputy_money")
     private String deputyMoney;

    /** 支付金额 */
     @Excel(name = "支付金额")
     @Column(name="deputy_moeny_pay")
     private Double deputyMoenyPay;

    /** 优惠金额 */
     @Excel(name = "优惠金额")
     @Column(name="deputy_moeny_dis")
     private Double deputyMoenyDis;

    /** 订单编号 */
     @Excel(name = "订单编号")
     @Column(name="order_id")
     private String orderId;

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
