package com.zebra.bussiness.feign.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Title: 响应描述<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年8月18日
 */
@Getter
@AllArgsConstructor
public enum APIResultEnum {
    SUCCESS("0000", "操作成功");
    private final String code;
    private final String msg;

}
