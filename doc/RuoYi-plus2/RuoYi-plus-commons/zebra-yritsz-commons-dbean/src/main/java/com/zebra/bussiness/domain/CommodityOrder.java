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
 * t_commodity_order表 CommodityOrder
 * 
 * @author zebra
 * @date 2021-01-09
 */
@Table(name="t_commodity_order")
@Getter
@Setter
@ToString
public class CommodityOrder extends BussinessEntity {
    private static final long serialVersionUID = 1L;
	
    /** 订单编号 */
     @Id
     private String orderId;

    /** 支付方式（1微信 2支付宝 3线下） */
     @Excel(name = "支付方式", readConverterExp = "1=微信,2=支付宝,3=线下")
     @Column(name="order_way")
     private Integer orderWay;

    /** 订单金额 */
     @Excel(name = "订单金额")
     @Column(name="order_money")
     private Double orderMoney;

    /** 支付金额 */
     @Excel(name = "支付金额")
     @Column(name="order_moeny_pay")
     private Double orderMoenyPay;

    /** 优惠金额 */
     @Excel(name = "优惠金额")
     @Column(name="order_moeny_dis")
     private Double orderMoenyDis;

    /** 订单状态（1待支付 2支付成功 3支付失败） */
     @Excel(name = "订单状态", readConverterExp = "1=待支付,2=支付成功,3=支付失败")
     @Column(name="order_status")
     private Integer orderStatus;

    /** 退款状态（0未退款 1已退款 2退款申请 3退款驳回） */
     @Excel(name = "退款状态", readConverterExp = "0=未退款,1=已退款,2=退款申请,3=退款驳回")
     @Column(name="order_refund_status")
     private Integer orderRefundStatus;

    /** 订单备注 */
     @Excel(name = "订单备注")
     @Column(name="order_remarks")
     private String orderRemarks;

    /** 用户姓名 */
     @Excel(name = "用户姓名")
     @Column(name="user_name")
     private String userName;

    /** 用户电话 */
     @Excel(name = "用户电话")
     @Column(name="user_phone")
     private String userPhone;

    /** 用户地址 */
     @Excel(name = "用户地址")
     @Column(name="user_address")
     private String userAddress;

    /** 发货状态（0未发货 1已发货） */
     @Excel(name = "发货状态", readConverterExp = "0=未发货,1=已发货")
     @Column(name="deliver_status")
     private Integer deliverStatus;

    /** 发货时间 */
     @Excel(name = "发货时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="deliver_time")
     private Date deliverTime;

    /** 收货状态（0未收货 1已收货 2退货中 3已退货） */
     @Excel(name = "收货状态", readConverterExp = "0=未收货,1=已收货,2=退货中,3=已退货")
     @Column(name="receiving_status")
     private Integer receivingStatus;

    /** 收货时间 */
     @Excel(name = "收货时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="receiving_time")
     private Date receivingTime;

    /** 快递类型 */
     @Excel(name = "快递类型")
     @Column(name="express_type")
     private Integer expressType;

    /** 快递单号 */
     @Excel(name = "快递单号")
     @Column(name="express_number")
     private String expressNumber;

    /** 失效时间 */
     @Excel(name = "失效时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="invalid_time")
     private Date invalidTime;

    /** 支付时间 */
     @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
     @Column(name="pay_time")
     private Date payTime;

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

    /** 操作备注 */
     @Excel(name = "操作备注")
     @Column(name="update_remarks")
     private String updateRemarks;

    /** 数据版本 */
     @Column(name="data_ver_flag")
     private Long dataVerFlag;

}
