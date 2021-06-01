package com.zebra.bussiness.domain.page;

import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.common.annotation.Excel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommodityInfoPage extends CommodityInfo {
	private static final long serialVersionUID = 1L;

	@Excel(name = "所属商户")
	private String merchantName;
}
