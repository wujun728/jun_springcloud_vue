package com.zebra.bussiness.domain.page;

import com.zebra.bussiness.domain.Orders;
import com.zebra.common.annotation.Excel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrdersPage extends Orders {
	private static final long serialVersionUID = 1L;

	@Excel(name = "所属商户")
	private String merchantName;

	@Excel(name = "商品名称")
	private String commodityName;
}
