package com.zebra.bussiness.feign.client;

import com.zebra.bussiness.feign.client.impl.BussinessFienClientImpl;
import com.zebra.bussiness.feign.util.APIJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title:订单模块<br/>
 * Description:<br/>
 *
 * @author zebra
 * @Date 2020年3月25日
 */
@FeignClient(value = "zebra-yritsz-api-bussiness", fallback = BussinessFienClientImpl.class)
public interface BussinessFienClient {

    /**
     * 退款
     *
     * @param orderId    订单编号
     * @param isRollback 是否回滚 true:库存正常业务，false库存业务失败回滚
     * @return
     */
    @RequestMapping(value = "/orderServer/refundOrder/{orderId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public APIJson refundOrder(@PathVariable(value = "orderId") String orderId, boolean isRollback);
}
