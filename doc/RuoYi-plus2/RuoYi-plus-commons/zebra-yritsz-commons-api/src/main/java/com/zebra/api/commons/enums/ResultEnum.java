package com.zebra.api.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Title: 响应描述<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
	SUCCESS("0000", "操作成功"), ERROR("-1", "trigger fuse server busy"), ERROR_400("400", "this is 400"), ERROR_404("404",
			"this is 404"), ERROR_500("500", "this is 500"), ERROR_TOKEN("9998",
					"This is an illegal request."), FLAG_FAIL("20001", "操作失败，版本错误"), PARAMERROR("1000",
							"参数错误"), PARAMNULL("1001", "信息不存在"), COMMODITY_FAIL("1002",
									"产品操作失败"), ORDER_NOPAY("1003", "订单未完成支付"), ORDER_ISREFUD("1004", "订单已经退款");

	private final String code;
	private final String msg;

}
