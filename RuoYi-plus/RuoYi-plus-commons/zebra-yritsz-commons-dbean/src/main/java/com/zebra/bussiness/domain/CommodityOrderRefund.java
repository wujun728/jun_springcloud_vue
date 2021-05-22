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
 * t_commodity_order_refund表 CommodityOrderRefund
 * 
 * @author zebra
 * @date 2021-01-09
 */
@Table(name="t_commodity_order_refund")
@Getter
@Setter
@ToString
public class CommodityOrderRefund extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 退款单号 */
     @Excel(name = "退款单号")
     @Id
     private String refundId;

    /** 退款金额 */
     @Excel(name = "退款金额")
     @Column(name="refund_money")
     private Double refundMoney;

    /** 退款状态（0处理中 1已退款 2退款失败 3人工退款） */
     @Excel(name = "退款状态", readConverterExp = "0=处理中,1=已退款,2=退款失败,3=人工退款")
     @Column(name="refund_status")
     private Integer refundStatus;

    /** 退款备注 */
     @Excel(name = "退款备注")
     @Column(name="refund_remarks")
     private String refundRemarks;

    /** 用户id */
     @Excel(name = "用户id")
     @Column(name="user_id")
     private String userId;

    /** 订单号 */
     @Excel(name = "订单号")
     @Column(name="order_id")
     private String orderId;

    /** 商户id */
     @Excel(name = "商户id")
     @Column(name="merchant_id")
     private String merchantId;

    /** 退款时间 */
     @Excel(name = "退款时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="refund_time")
     private Date refundTime;

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
