package com.zebra.api.order.service;

import com.zebra.api.commons.bean.Json;

/**
 * Title: 订单管理<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 *
 */
public interface OrderService {
	/**
	 * 订单退款
	 *
	 * @param orderId
	 * @return
	 */
	public Json refundOrder(String orderId);
}
