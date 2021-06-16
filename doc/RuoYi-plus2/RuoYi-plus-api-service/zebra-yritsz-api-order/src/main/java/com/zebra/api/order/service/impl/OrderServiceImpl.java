package com.zebra.api.order.service.impl;

import java.util.Date;

import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.bussiness.domain.CommodityOrder;
import com.zebra.bussiness.mapper.CommodityInfoMapper;
import com.zebra.bussiness.mapper.CommodityOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.api.commons.bean.Json;
import com.zebra.api.commons.enums.OrderStatusEnum;
import com.zebra.api.commons.enums.RefundStatusEnum;
import com.zebra.api.commons.enums.ResultEnum;
import com.zebra.api.order.service.OrderService;

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
	private CommodityOrderMapper commodityOrderMapper;

	@Override
	public Json refundOrder(String orderId) {
		CommodityOrder orders = commodityOrderMapper.selectByPrimaryKey(orderId);
		if (orders == null)
			return Json.other(ResultEnum.PARAMNULL);

		if (orders.getOrderStatus() != OrderStatusEnum.ORDER_STATUS_2.getOrderStatus()&&orders.getOrderStatus() != OrderStatusEnum.ORDER_STATUS_4.getOrderStatus())
			return Json.other(ResultEnum.ORDER_NOPAY);

		/**
		 * 真正退款支付实现忽略，后期版本增加
		 */
		orders.setOrderStatus(OrderStatusEnum.ORDER_STATUS_5.getOrderStatus());
		orders.setUpdateTime(new Date());
		int falg = commodityOrderMapper.updateByPrimaryKeySelective(orders);
		if (falg == 0) {
			return Json.other(ResultEnum.FLAG_FAIL);
		}
		return Json.success(orders.getCommodityId());
	}

}
