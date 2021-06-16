package com.zebra.api.bussiness.service;

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
	 *            订单编号
	 * @param isRollback
	 *            是否需要回滚 否：正常业务 是：直接响应失败
	 * @return
	 */
	public Json refundOrder(String orderId, boolean isRollback);
}
