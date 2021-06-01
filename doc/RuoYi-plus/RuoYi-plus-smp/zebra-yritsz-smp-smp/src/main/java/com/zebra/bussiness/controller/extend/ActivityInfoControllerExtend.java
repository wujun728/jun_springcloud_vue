package com.zebra.bussiness.controller.extend;

import com.zebra.bussiness.domain.ActivityInfo;
import com.zebra.bussiness.domain.page.ActivityInfoPage;
import com.zebra.bussiness.service.impl.extend.CommodityInfoServiceImplExtend;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ActivityInfoControllerExtend extends CommodityInfoServiceImplExtend {


    protected List<ActivityInfoPage> getActivityInfoPage(List<ActivityInfo> list) {
        List<ActivityInfoPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getActivityInfoPage(source));
        });
        return pages;
    }

    protected ActivityInfoPage getActivityInfoPage(ActivityInfo source) {
        ActivityInfoPage page = new ActivityInfoPage();
        BeanUtils.copyProperties(source, page);
        page.setCategoryName(super.getCategoryName(String.valueOf(page.getCategoryId())));
        return page;
    }

}
