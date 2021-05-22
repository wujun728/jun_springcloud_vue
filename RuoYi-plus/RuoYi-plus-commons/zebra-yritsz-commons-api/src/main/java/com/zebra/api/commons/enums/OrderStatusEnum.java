package com.zebra.api.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Title:订单状态<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
	/**
	 * 订单状态（1待支付 2支付成功 3支付失败 4退款申请 5退款）
	 */
	ORDER_STATUS_1(1), ORDER_STATUS_2(2), ORDER_STATUS_3(3), ORDER_STATUS_4(4), ORDER_STATUS_5(5);
	private final Integer orderStatus;
}
