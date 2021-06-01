package com.zebra.bussiness.controller.extend;

import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.bussiness.domain.page.CommodityInfoPage;
import com.zebra.bussiness.service.impl.extend.CommodityInfoServiceImplExtend;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CommodityInfoControllerExtend extends CommodityInfoServiceImplExtend {


    protected List<CommodityInfoPage> getCommodityInfoPage(List<CommodityInfo> list) {
        List<CommodityInfoPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getCommodityInfoPage(source));
        });
        return pages;
    }

    protected CommodityInfoPage getCommodityInfoPage(CommodityInfo source) {
        CommodityInfoPage page = new CommodityInfoPage();
        BeanUtils.copyProperties(source, page);
        page.setMerchantName(super.getMerchantName(page.getMerchantId()));
        page.setCategoryName(super.getCategoryName(page.getCategoryId()));
        return page;
    }

}
