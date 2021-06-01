package com.zebra.bussiness.domain.page;

import com.zebra.bussiness.domain.Merchaninfo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MerchantInfoPage extends Merchaninfo {
	private static final long serialVersionUID = 1L;
	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 城市名称
	 */
	private String cityName;
}
