package com.zebra.bussiness.domain.page;

import com.zebra.bussiness.domain.CommodityOrderDeputy;
import com.zebra.common.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanshuangbin
 * @date 2021-01-09 18:07
 */
@Setter
@Getter
public class CommodityOrderDeputyPage extends CommodityOrderDeputy {
    /**
     * 产品名称
     */
    @Excel(name = "产品名称")
    private String commodityName;
}
