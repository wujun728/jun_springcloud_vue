package com.zebra.api.bussiness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zebra.api.bussiness.feign.client.CommodtidyFienClient;
import com.zebra.api.bussiness.feign.client.OrderFienClient;
import com.zebra.api.bussiness.service.OrderService;
import com.zebra.api.commons.bean.Json;
import com.zebra.api.commons.bean.RequestTestBean;
import com.zebra.api.commons.enums.ResultEnum;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

/**
 * Title: 订单管理实现<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 *
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderFienClient orderFienClient;
	@Autowired
	private CommodtidyFienClient commodtidyFienClient;

	/**
	 * 1：订单模块进行退款</br>
	 * 2：退款成功商品模块增加库存 </br>
	 * 3：商品模块响应失败进行事务回滚
	 *
	 */
	@Override
	@GlobalTransactional
	public Json refundOrder(String orderId, boolean isRollback) {
		log.info("[信息]订单退款-【订单模块】-请求：{}", orderId);
		Json json = orderFienClient.refundOrder(orderId);
		log.info("[信息]订单退款-【订单模块】-响应：{}", json.toString());
		if (json.getCode().equals(ResultEnum.SUCCESS.getCode())) {
			String commodtidyId = json.getObj().toString();
			RequestTestBean requestTestBean = new RequestTestBean();
			requestTestBean.setIsRollback(isRollback);
			log.info("[信息]订单退款-【产品模块】-请求：{}-{}", commodtidyId, requestTestBean.toString());
			json = commodtidyFienClient.editStock(commodtidyId, requestTestBean);
			log.info("[信息]订单退款-【产品模块】-响应：{}", json.toString());
			if (!json.getCode().equals(ResultEnum.SUCCESS.getCode())) {
	            throw new RuntimeException("产品模块更新失败,执行订单退款回滚");
			}
		} else {
			return json;
		}
		return Json.success();
	}

}
