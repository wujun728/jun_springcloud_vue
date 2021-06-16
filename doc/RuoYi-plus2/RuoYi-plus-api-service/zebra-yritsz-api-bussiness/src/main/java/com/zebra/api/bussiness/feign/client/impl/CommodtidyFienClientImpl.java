package com.zebra.api.bussiness.feign.client.impl;

import org.springframework.stereotype.Service;

import com.zebra.api.bussiness.feign.base.BaseService;
import com.zebra.api.bussiness.feign.client.CommodtidyFienClient;
import com.zebra.api.commons.bean.Json;
import com.zebra.api.commons.bean.RequestTestBean;

@Service
public class CommodtidyFienClientImpl extends BaseService implements CommodtidyFienClient {

	@Override
	public Json editStock(String commodityId,RequestTestBean requestTestBean) {
		return super.returnHix();
	}

}
