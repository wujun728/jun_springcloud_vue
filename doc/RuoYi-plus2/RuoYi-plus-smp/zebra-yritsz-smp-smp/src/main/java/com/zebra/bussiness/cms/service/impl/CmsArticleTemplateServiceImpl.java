package com.zebra.bussiness.cms.service.impl;

import java.util.List;
import com.zebra.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.cms.mapper.CmsArticleTemplateMapper;
import com.zebra.bussiness.cms.domain.CmsArticleTemplate;
import com.zebra.bussiness.cms.service.ICmsArticleTemplateService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 文章模板Service业务层处理
 * 
 * @author zebra
 * @date 2020-07-28
 */
@Service
public class CmsArticleTemplateServiceImpl implements ICmsArticleTemplateService {
    @Autowired
    private CmsArticleTemplateMapper cmsArticleTemplateMapper;

    /**
     * 查询文章模板
     * 
     * @param templeId 文章模板ID
     * @return 文章模板
     */
    @Override
    public CmsArticleTemplate selectCmsArticleTemplateById(Long templeId)
    {
        return cmsArticleTemplateMapper.selectCmsArticleTemplateById(templeId);
    }

    /**
     * 查询文章模板列表
     * 
     * @param cmsArticleTemplate 文章模板
     * @return 文章模板
     */
    @Override
    public List<CmsArticleTemplate> selectCmsArticleTemplateList(CmsArticleTemplate cmsArticleTemplate)
    {
        return cmsArticleTemplateMapper.selectCmsArticleTemplateList(cmsArticleTemplate);
    }

    /**
     * 新增文章模板
     * 
     * @param cmsArticleTemplate 文章模板
     * @return 结果
     */
    @Override
    public int insertCmsArticleTemplate(CmsArticleTemplate cmsArticleTemplate)
    {
        cmsArticleTemplate.setCreateTime(DateUtils.getNowDate());
        cmsArticleTemplate.setUpdateTime(DateUtils.getNowDate());
        cmsArticleTemplate.setUpdateBy(ShiroUtils.getLoginName());
        return cmsArticleTemplateMapper.insertCmsArticleTemplate(cmsArticleTemplate);
    }

    /**
     * 修改文章模板
     * 
     * @param cmsArticleTemplate 文章模板
     * @return 结果
     */
    @Override
    public int updateCmsArticleTemplate(CmsArticleTemplate cmsArticleTemplate)
    {
        cmsArticleTemplate.setUpdateTime(DateUtils.getNowDate());
        cmsArticleTemplate.setUpdateBy(ShiroUtils.getLoginName());
        return cmsArticleTemplateMapper.updateCmsArticleTemplate(cmsArticleTemplate);
    }

    /**
     * 删除文章模板对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsArticleTemplateByIds(String ids)
    {
        return cmsArticleTemplateMapper.deleteCmsArticleTemplateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章模板信息
     * 
     * @param templeId 文章模板ID
     * @return 结果
     */
    @Override
    public int deleteCmsArticleTemplateById(Long templeId)
    {
        return cmsArticleTemplateMapper.deleteCmsArticleTemplateById(templeId);
    }
}
