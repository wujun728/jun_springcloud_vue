package com.zebra.api.bussiness.feign.base;

import com.zebra.api.commons.bean.Json;

public class BaseService {
	/**
	 * 熔断响应
	 *
	 * @return
	 */
	protected Json returnHix() {
		return Json.errorHix();
	}
}
