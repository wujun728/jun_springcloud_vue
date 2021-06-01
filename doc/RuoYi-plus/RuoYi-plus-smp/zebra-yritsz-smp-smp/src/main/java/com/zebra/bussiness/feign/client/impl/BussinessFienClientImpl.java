package com.zebra.bussiness.feign.client.impl;

import com.zebra.bussiness.feign.base.BaseService;
import com.zebra.bussiness.feign.client.BussinessFienClient;
import com.zebra.bussiness.feign.util.APIJson;
import org.springframework.stereotype.Service;

@Service
public class BussinessFienClientImpl extends BaseService implements BussinessFienClient {

    @Override
    public APIJson refundOrder(String orderId, boolean isRollback) {
        return super.returnHix();
    }

}
