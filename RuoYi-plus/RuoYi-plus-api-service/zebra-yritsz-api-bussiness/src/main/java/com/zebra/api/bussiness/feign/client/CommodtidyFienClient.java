package com.zebra.api.bussiness.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zebra.api.bussiness.feign.client.impl.CommodtidyFienClientImpl;
import com.zebra.api.commons.bean.Json;
import com.zebra.api.commons.bean.RequestTestBean;

/**
 * Title: 产品模块<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 */
@FeignClient(value = "${commodtidy.server.name}", fallback = CommodtidyFienClientImpl.class)
public interface CommodtidyFienClient {

	@RequestMapping(value = "/commodityServer/editStock/{commodityId}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Json editStock(@PathVariable(value = "commodityId") String commodityId,RequestTestBean requestTestBean);
}
