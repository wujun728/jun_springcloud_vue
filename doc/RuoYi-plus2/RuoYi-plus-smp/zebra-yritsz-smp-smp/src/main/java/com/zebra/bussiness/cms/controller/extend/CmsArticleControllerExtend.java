package com.zebra.bussiness.cms.controller.extend;

import com.zebra.bussiness.cms.domain.CmsArticle;
import com.zebra.bussiness.cms.domain.CmsArticleContent;
import com.zebra.bussiness.cms.domain.CmsCategory;
import com.zebra.bussiness.cms.domain.CmsMaterial;
import com.zebra.bussiness.cms.domain.page.CmsArticlePage;
import com.zebra.bussiness.cms.mapper.CmsArticleContentMapper;
import com.zebra.bussiness.cms.mapper.CmsCategoryMapper;
import com.zebra.bussiness.cms.mapper.CmsMaterialMapper;
import com.zebra.bussiness.cms.service.impl.CmsArticleServiceImpl;
import com.zebra.bussiness.service.impl.extend.BaseServiceImplExtend;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CmsArticleControllerExtend extends BaseServiceImplExtend {

    @Autowired
    private CmsCategoryMapper cmsCategoryMapper;
    @Autowired
    private CmsMaterialMapper cmsMaterialMapper;
    @Autowired
    private CmsArticleContentMapper cmsArticleContentMapper;

    protected List<CmsArticlePage> getCmsArticlePage(List<CmsArticle> list) {
        List<CmsArticlePage> pages = new ArrayList<>(list.size());
        BeanUtils.copyProperties(list, pages);
        list.forEach(source -> {
            pages.add(this.getCmsArticlePage(source));
        });
        return pages;
    }

    protected String getCategoryName(String ctegoryId) {
        CmsCategory category = cmsCategoryMapper.selectByPrimaryKey(ctegoryId);
        if (category != null)
            return category.getCategoryName();
        return null;
    }

    protected String getCmsArticleContent(String articleId) {
        CmsArticleContent cmsArticleContent = cmsArticleContentMapper.selectByPrimaryKey(articleId);
        if (cmsArticleContent != null)
            return cmsArticleContent.getContent();
        return null;
    }

    protected String getCmsMaterialName(String materialId) {
        CmsMaterial cmsMaterial = cmsMaterialMapper.selectByPrimaryKey(materialId);
        if (cmsMaterial != null)
            return cmsMaterial.getMaterialName();
        return null;
    }

    protected CmsArticlePage getCmsArticlePage(CmsArticle source) {
        CmsArticlePage page = new CmsArticlePage();
        BeanUtils.copyProperties(source, page);
        page.setMerchantName(super.getMerchantName(page.getMerchantId()));
        page.setCategoryName(this.getCategoryName(page.getCategoryId()));
        CmsMaterial cmsMaterial = cmsMaterialMapper.selectByPrimaryKey(page.getMaterialId());
        if (cmsMaterial != null)
            page.setMaterialUrl(super.getFtileHttp() + cmsMaterial.getSavePath());
        page.setContent(getCmsArticleContent(page.getArticleId()));
        return page;

    }
}
