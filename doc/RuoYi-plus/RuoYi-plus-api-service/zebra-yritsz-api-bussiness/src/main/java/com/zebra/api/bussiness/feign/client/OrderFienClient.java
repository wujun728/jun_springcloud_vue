package com.zebra.api.bussiness.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zebra.api.bussiness.feign.client.impl.OrderFienClientImpl;
import com.zebra.api.commons.bean.Json;

/**
 * Title:订单模块<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 *
 */
@FeignClient(value = "${order.server.name}", fallback = OrderFienClientImpl.class)
public interface OrderFienClient {

	@RequestMapping(value = "/orderServer/refundOrder/{orderId}")
	public Json refundOrder(@PathVariable(value = "orderId") String orderId);
}
