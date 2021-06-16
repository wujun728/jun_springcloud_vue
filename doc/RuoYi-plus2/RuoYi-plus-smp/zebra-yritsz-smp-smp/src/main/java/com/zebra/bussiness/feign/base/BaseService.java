package com.zebra.bussiness.feign.base;


import com.zebra.bussiness.feign.util.APIJson;

public class BaseService {
	/**
	 * 熔断响应
	 *
	 * @return
	 */
	protected APIJson returnHix() {
		return APIJson.errorHix();
	}
}
