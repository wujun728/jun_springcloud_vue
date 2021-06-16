package com.zebra.bussiness.cms.service;

import com.zebra.bussiness.cms.domain.CmsArticle;
import com.zebra.bussiness.cms.domain.page.CmsArticlePage;

import java.util.List;

/**
 * 文章信息Service接口
 * 
 * @author zebra
 * @date 2020-06-25
 */
public interface ICmsArticleService {
    /**
     * 查询文章信息
     * 
     * @param articleId 文章信息ID
     * @return 文章信息
     */
    public CmsArticle selectCmsArticleById(String articleId);

    /**
     * 查询文章信息列表
     * 
     * @param cmsArticle 文章信息
     * @return 文章信息集合
     */
    public List<CmsArticle> selectCmsArticleList(CmsArticle cmsArticle);

    /**
     * 新增文章信息
     * 
     * @param cmsArticle 文章信息
     * @return 结果
     */
    public int insertCmsArticle(CmsArticlePage cmsArticle);

    /**
     * 修改文章信息
     * 
     * @param cmsArticle 文章信息
     * @return 结果
     */
    public int updateCmsArticle(CmsArticlePage cmsArticle);

    /**
     * 批量删除文章信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsArticleByIds(String ids);

    /**
     * 删除文章信息信息
     * 
     * @param articleId 文章信息ID
     * @return 结果
     */
    public int deleteCmsArticleById(String articleId);
}
