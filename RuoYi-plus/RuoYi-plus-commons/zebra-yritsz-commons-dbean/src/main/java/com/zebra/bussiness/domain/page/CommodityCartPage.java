package com.zebra.bussiness.domain.page;

import com.zebra.bussiness.domain.CommodityCart;
import com.zebra.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanshuangbin
 * @date 2021-01-09 18:18
 */
@Getter
@Setter
public class CommodityCartPage extends CommodityCart {
    /**
     * 所属商户
     */
    @Excel(name = "所属商户")
    private String merchantName;
    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String commodityName;


    /** 产品图片 */
    private String commodityImg;

    @Excel(name = "用户信息")
    private String userName;
}
