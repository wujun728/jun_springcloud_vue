package com.zebra.bussiness.controller.extend;

import com.zebra.bussiness.domain.ActivityCommodity;
import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.bussiness.domain.page.ActivityCommodityPage;
import com.zebra.bussiness.service.impl.extend.BaseServiceImplExtend;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ActivityCommodityExtend extends BaseServiceImplExtend {


    protected List<ActivityCommodityPage> getActivityCommodityPage(List<ActivityCommodity> list) {
        List<ActivityCommodityPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getActivityCommodityPage(source));
        });
        return pages;
    }
    protected ActivityCommodityPage getActivityCommodityPage(ActivityCommodity source) {
        ActivityCommodityPage page = new ActivityCommodityPage();
        BeanUtils.copyProperties(source, page);
        page.setMerchantName(super.getMerchantName(page.getMerchantId()));
        page.setActivityName(super.getActivityName(page.getActivityId()));
        CommodityInfo commodityInfo = super.getCommodityById(page.getCommodityId());
        if (commodityInfo != null) {
            page.setCommodityName(commodityInfo.getCommodityName());
            page.setCommodityStatus(commodityInfo.getCommodityStatus());
            page.setCommodityMoeny(commodityInfo.getCommodityMoeny());
        }
        return page;
    }

}
