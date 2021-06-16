package com.zebra.api.bussiness.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Title:日志描述<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 */
@Getter
@AllArgsConstructor
public enum LogDescribeEnum {
	NO_ENABLED("[信息]未开启签名校验"), NO_HEADER("[信息]请求【{}】头部信息不存在"), SECURIT_NLL("[信息]秘钥【{}】信息不存在"), SECURIT_STATUS("[信息]秘钥【{}】状态异常"), SIGN_NULL("签名信息不存在"), SIGN_FAIL("签名信息错误");

	private final String msg;
}
