package com.zebra.bussiness.cms.controller.extend;

import com.zebra.bussiness.cms.domain.CmsBlacklist;
import com.zebra.bussiness.cms.domain.CmsComment;
import com.zebra.bussiness.cms.domain.page.CmsCommentPage;
import com.zebra.bussiness.cms.mapper.CmsBlacklistMapper;
import com.zebra.bussiness.service.impl.extend.BaseServiceImplExtend;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

public class CmsCommentControllerExtend extends BaseServiceImplExtend {
    @Autowired
    private CmsBlacklistMapper cmsBlacklistMapper;

    protected List<CmsCommentPage> getCmsCommentPage(List<CmsComment> list) {
        List<CmsCommentPage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getCmsCommentPage(source));
        });
        return pages;
    }

    protected CmsCommentPage getCmsCommentPage(CmsComment source) {
        CmsCommentPage page = new CmsCommentPage();
        BeanUtils.copyProperties(source, page);
        page.setMerchantName(super.getMerchantName(page.getMerchantId()));
        return page;

    }

    protected void deleteBlackByAbuotId(String aubotId, String userId) {
        Example example = new Example(CmsBlacklist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("aubotId", aubotId);
        criteria.andEqualTo("userId", userId);
        cmsBlacklistMapper.deleteByExample(example);
    }

    protected CmsBlacklist getBlackByAbuotId(String aubotId, String userId) {
        Example example = new Example(CmsBlacklist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("aubotId", aubotId);
        criteria.andEqualTo("userId", userId);
        return cmsBlacklistMapper.selectOneByExample(example);
    }
}
