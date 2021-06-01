package com.zebra.api.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Title: 退款状态<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 */
@Getter
@AllArgsConstructor
public enum RefundStatusEnum {
	/**
	 * 是否退款（1已退款 2退款中 3未退款 4退款失败）
	 */
	REFUND_STATUS_1(1), REFUND_STATUS_2(2), REFUND_STATUS_3(3), REFUND_STATUS_4(4);
	private final Integer refundStatus;
}
