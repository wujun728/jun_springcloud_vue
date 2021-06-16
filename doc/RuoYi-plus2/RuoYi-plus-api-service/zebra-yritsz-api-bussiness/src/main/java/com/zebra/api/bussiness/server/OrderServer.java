package com.zebra.api.bussiness.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zebra.api.bussiness.aop.LogAnnotation;
import com.zebra.api.bussiness.aop.LogAnnotation.OPERTYPE;
import com.zebra.api.bussiness.service.OrderService;
import com.zebra.api.commons.bean.Json;

/**
 *
 * Title: 订单模块<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 *
 */
@RestController
@RequestMapping("/orderServer")
public class OrderServer {
	@Autowired
	private OrderService orderService;

	/**
	 * 订单退款
	 *
	 * @param orderId
	 *            订单号
	 * @param isRollback
	 *            是否需要回滚 否：库存正常业务 是：库存直接响应失败
	 * @return
	 */
	@RequestMapping(value = "/refundOrder/{orderId}")
	@ResponseBody
	@LogAnnotation(oper = OPERTYPE.refundOrder)
	public Json refundOrder(@PathVariable(value = "orderId") String orderId, boolean isRollback) {
		return orderService.refundOrder(orderId, isRollback);
	}

}
