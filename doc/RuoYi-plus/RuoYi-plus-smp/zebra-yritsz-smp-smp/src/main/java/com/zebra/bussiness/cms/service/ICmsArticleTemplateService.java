package com.zebra.bussiness.cms.service;

import com.zebra.bussiness.cms.domain.CmsArticleTemplate;
import java.util.List;

/**
 * 文章模板Service接口
 * 
 * @author zebra
 * @date 2020-07-28
 */
public interface ICmsArticleTemplateService {
    /**
     * 查询文章模板
     * 
     * @param templeId 文章模板ID
     * @return 文章模板
     */
    public CmsArticleTemplate selectCmsArticleTemplateById(Long templeId);

    /**
     * 查询文章模板列表
     * 
     * @param cmsArticleTemplate 文章模板
     * @return 文章模板集合
     */
    public List<CmsArticleTemplate> selectCmsArticleTemplateList(CmsArticleTemplate cmsArticleTemplate);

    /**
     * 新增文章模板
     * 
     * @param cmsArticleTemplate 文章模板
     * @return 结果
     */
    public int insertCmsArticleTemplate(CmsArticleTemplate cmsArticleTemplate);

    /**
     * 修改文章模板
     * 
     * @param cmsArticleTemplate 文章模板
     * @return 结果
     */
    public int updateCmsArticleTemplate(CmsArticleTemplate cmsArticleTemplate);

    /**
     * 批量删除文章模板
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsArticleTemplateByIds(String ids);

    /**
     * 删除文章模板信息
     * 
     * @param templeId 文章模板ID
     * @return 结果
     */
    public int deleteCmsArticleTemplateById(Long templeId);
}
