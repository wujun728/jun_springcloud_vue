package com.zebra.bussiness.controller.extend;

import com.zebra.bussiness.domain.CommodityCart;
import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.bussiness.domain.page.CommodityCartPage;
import com.zebra.bussiness.service.impl.extend.BaseServiceImplExtend;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CommodityCartExtendController extends BaseServiceImplExtend {
    protected List<CommodityCartPage> getCommodityCartPage(List<CommodityCart> list) {
        List<CommodityCartPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getCommodityCartPage(source));
        });
        return pages;
    }

    protected CommodityCartPage getCommodityCartPage(CommodityCart source) {
        CommodityCartPage page = new CommodityCartPage();
        BeanUtils.copyProperties(source, page);
        page.setMerchantName(super.getMerchantName(page.getMerchantId()));
        page.setUserName(super.getUserName(page.getUserId()));
        CommodityInfo commodityInfo = super.getCommodityById(page.getCommodityId());
        if (commodityInfo != null) {
            page.setCommodityImg(commodityInfo.getCommodityImg());
            page.setCommodityName(commodityInfo.getCommodityName());
        }
        return page;
    }
}
