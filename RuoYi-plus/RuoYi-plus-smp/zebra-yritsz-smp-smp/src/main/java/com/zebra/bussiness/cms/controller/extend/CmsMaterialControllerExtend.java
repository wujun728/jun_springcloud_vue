package com.zebra.bussiness.cms.controller.extend;

import com.zebra.bussiness.cms.domain.CmsMaterial;
import com.zebra.bussiness.cms.domain.CmsMaterialGroup;
import com.zebra.bussiness.cms.domain.page.CmsMaterialPage;
import com.zebra.bussiness.cms.mapper.CmsMaterialGroupMapper;
import com.zebra.bussiness.service.impl.extend.BaseServiceImplExtend;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CmsMaterialControllerExtend extends BaseServiceImplExtend {

    @Autowired
    private CmsMaterialGroupMapper cmsMaterialGroupMapper;

    protected List<CmsMaterialPage> getCmsMaterialPage(List<CmsMaterial> list) {
        List<CmsMaterialPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getCmsMaterialPage(source));
        });
        return pages;
    }

    protected CmsMaterialPage getCmsMaterialPage(CmsMaterial source) {
        CmsMaterialPage page = new CmsMaterialPage();
        BeanUtils.copyProperties(source, page);
        page.setMerchantName(super.getMerchantName(page.getMerchantId()));
        CmsMaterialGroup cmsMaterialGroup = cmsMaterialGroupMapper.selectByPrimaryKey(page.getGroupId());
        if (cmsMaterialGroup != null)
            page.setGroupName(cmsMaterialGroup.getGroupName());
        return page;

    }
}
