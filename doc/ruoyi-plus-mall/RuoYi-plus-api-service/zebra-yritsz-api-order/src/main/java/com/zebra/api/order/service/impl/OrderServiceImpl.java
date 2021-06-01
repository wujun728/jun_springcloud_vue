package com.zebra.api.order.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.api.commons.bean.Json;
import com.zebra.api.commons.enums.OrderStatusEnum;
import com.zebra.api.commons.enums.RefundStatusEnum;
import com.zebra.api.commons.enums.ResultEnum;
import com.zebra.api.order.service.OrderService;
import com.zebra.bussiness.domain.Orders;
import com.zebra.bussiness.mapper.OrdersMapper;

/**
 * Title: 订单管理实现<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public Json refundOrder(String orderId) {
		Orders orders = ordersMapper.selectByPrimaryKey(orderId);
		if (orders == null)
			return Json.other(ResultEnum.PARAMNULL);

		if (orders.getOrderStatus() != OrderStatusEnum.ORDER_STATUS_2.getOrderStatus())
			return Json.other(ResultEnum.ORDER_NOPAY);

		if (orders.getRefundStatus() != RefundStatusEnum.REFUND_STATUS_3.getRefundStatus())
			return Json.other(ResultEnum.ORDER_ISREFUD);

		/**
		 * 真正退款支付实现忽略，后期版本增加
		 */
		orders.setRefundStatus(RefundStatusEnum.REFUND_STATUS_1.getRefundStatus());
		orders.setUpdateDatetime(new Date());
		int falg = ordersMapper.updateByPrimaryKeySelective(orders);
		if (falg == 0) {
			return Json.other(ResultEnum.FLAG_FAIL);
		}
		return Json.success(orders.getCommodityId());
	}

}
