package com.zebra.api.commons.bean;

import lombok.Data;

@Data
public class RequestTestBean {
	/**
	 * 是否需要回滚 否：正常业务 是：直接响应失败
	 */
	private Boolean isRollback;
}
