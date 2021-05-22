package com.zebra.bussiness.cms.controller.extend;

import com.zebra.bussiness.cms.domain.CmsBlacklist;
import com.zebra.bussiness.cms.domain.page.CmsBlacklistPage;
import com.zebra.bussiness.service.impl.extend.BaseServiceImplExtend;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CmsBlacklistControllerExtend extends BaseServiceImplExtend {

    protected List<CmsBlacklistPage> getCmsBlacklistPage(List<CmsBlacklist> list) {
        List<CmsBlacklistPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getCmsBlacklistPage(source));
        });
        return pages;
    }

    protected CmsBlacklistPage getCmsBlacklistPage(CmsBlacklist source) {
        CmsBlacklistPage page = new CmsBlacklistPage();
        BeanUtils.copyProperties(source, page);
        page.setMerchantName(super.getMerchantName(page.getMerchantId()));
        return page;

    }
}
