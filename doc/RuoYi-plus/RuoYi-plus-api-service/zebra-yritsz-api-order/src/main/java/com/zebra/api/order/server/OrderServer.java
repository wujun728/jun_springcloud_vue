package com.zebra.api.order.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zebra.api.commons.bean.Json;
import com.zebra.api.order.aop.LogAnnotation;
import com.zebra.api.order.aop.LogAnnotation.OPERTYPE;
import com.zebra.api.order.service.OrderService;

/**
 *
 * Title: 订单<br/>
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
	private OrderService demoService;

	/**
	 * 订单退款
	 *
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/refundOrder/{orderId}")
	@ResponseBody
	@LogAnnotation(oper = OPERTYPE.refundOrder)
	public Json refundOrder(@PathVariable(value = "orderId") String orderId) {
		return demoService.refundOrder(orderId);
	}
}
