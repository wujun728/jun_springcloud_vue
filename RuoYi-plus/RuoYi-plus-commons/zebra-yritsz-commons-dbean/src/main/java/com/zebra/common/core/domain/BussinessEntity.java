package com.zebra.common.core.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务Entity基类
 *
 * @author ruoyi
 */
@Getter
@Setter
public class BussinessEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 搜索值 */
	@Transient
	private String searchValue;

	/** 商户id */
	@Transient
	private List<Object> merchantIds;

	/** 请求参数 */
	@Transient
	private Map<String, Object> params;

	public Map<String, Object> getParams() {
		if (params == null) {
			params = new HashMap<>();
		}
		return params;
	}
}
