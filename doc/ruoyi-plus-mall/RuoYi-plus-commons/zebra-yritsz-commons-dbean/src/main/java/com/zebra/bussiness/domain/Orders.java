package com.zebra.bussiness.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zebra.common.annotation.Excel;
import com.zebra.common.core.domain.BussinessEntity;
import com.zebra.common.core.domain.MyNextVersion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tk.mybatis.mapper.annotation.Version;

/**
 * t_orders表 Orders
 *
 * @author zebra
 * @date 2020-03-25
 */
@Table(name = "t_orders")
@Getter
@Setter
@ToString
public class Orders extends BussinessEntity {
	private static final long serialVersionUID = 1L;

	/** 订单编号 */
	@Id
	private String orderId;

	/** 商品id */
	@Excel(name = "商品id")
	@Column(name = "commodity_id")
	private String commodityId;

	/** 订单金额 */
	@Excel(name = "订单金额")
	@Column(name = "order_money")
	private Double orderMoney;

	/** 支付渠道（1支付宝 2微信） */
	@Excel(name = "支付渠道", readConverterExp = "1=支付宝,2=微信")
	@Column(name = "order_pay_way")
	private Integer orderPayWay;

	/** 订单状态（1待支付 2已支付 3支付失败） */
	@Excel(name = "订单状态", readConverterExp = "1=待支付,2=已支付,3=支付失败")
	@Column(name = "order_status")
	private Integer orderStatus;

	/** 退款状态 */
	@Excel(name = "退款状态")
	@Column(name = "refund_status")
	private Integer refundStatus;

	/** 用户名称 */
	@Excel(name = "用户名称")
	@Column(name = "user_name")
	private String userName;

	/** 创建时间 */
	@Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "create_datetime")
	private Date createDatetime;

	/** 更新时间 */
	@Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "update_datetime")
	private Date updateDatetime;

	/** 支付时间 */
	@Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "pay_datetime")
	private Date payDatetime;

	/** 商户id */
	@Excel(name = "商户id")
	@Column(name = "mechant_id")
	private Long mechantId;

	/** 数据版本 */
	@Version(nextVersion = MyNextVersion.class)
	@Column(name = "data_ver_flag")
	private Long dataVerFlag;
}
