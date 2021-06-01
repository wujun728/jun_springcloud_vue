package com.zebra.bussiness.feign.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应信息bean
 *
 * @author zebra
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIJson {
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
     * 响应正确
     *
     * @param code
     * @return
     */
    public static Boolean success(String code) {
        return APIResultEnum.SUCCESS.getCode().equals(code);
    }

    /**
     * 熔断错误响应-无参
     *
     * @return
     */
    public static APIJson errorHix() {
        return new APIJson("500", "系统内部错误，触发熔断", null);
    }

}
