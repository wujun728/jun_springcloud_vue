package com.zebra.api.commons.bean;

import com.zebra.api.commons.enums.ResultEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 响应信息bean
 *
 * @author zebra
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Json {
	/**
	 * 响应码
	 */
	private String code;
	/**
	 * 响应说明
	 */
	private String msg;
	/**
	 * 响应数据
	 */
	private Object obj;

	/**
	 * 正确响应-无参
	 *
	 * @return
	 */
	public static Json success() {
		return jsonBean(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), null);
	}

	/**
	 * 正确响应-有参
	 *
	 * @param obj
	 * @return
	 */
	public static Json success(Object obj) {
		return jsonBean(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), obj);
	}

	/**
	 * 熔断错误响应-无参
	 *
	 * @return
	 */
	public static Json errorHix() {
		return jsonBean(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg(), null);
	}

	/**
	 * 熔断错误响应-无参
	 *
	 * @return
	 */
	public static Json error() {
		return jsonBean(ResultEnum.ERROR_500.getCode(), ResultEnum.ERROR_500.getMsg(), null);
	}

	/**
	 * 其他响应-无参
	 *
	 * @param resultEnum
	 * @return
	 */
	public static Json other(ResultEnum resultEnum) {
		return jsonBean(resultEnum.getCode(), resultEnum.getMsg(), null);
	}

	/**
	 * 其他响应-有参
	 *
	 * @param resultEnum
	 * @param obj
	 * @return
	 */
	public static Json other(ResultEnum resultEnum, Object obj) {
		return jsonBean(resultEnum.getCode(), resultEnum.getMsg(), null);
	}

	private static Json jsonBean(String code, String msg, Object obj) {
		return new Json(code, msg, obj);
	}
}
