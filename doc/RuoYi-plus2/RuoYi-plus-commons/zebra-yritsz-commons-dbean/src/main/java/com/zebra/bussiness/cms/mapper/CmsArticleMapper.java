package com.zebra.bussiness.cms.mapper;

import com.zebra.bussiness.cms.domain.CmsArticle;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 文章信息Mapper接口
 * 
 * @author zebra
 * @date 2020-06-25
 */
public interface CmsArticleMapper  extends Mapper<CmsArticle> {
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
    public int insertCmsArticle(CmsArticle cmsArticle);

    /**
     * 修改文章信息
     * 
     * @param cmsArticle 文章信息
     * @return 结果
     */
    public int updateCmsArticle(CmsArticle cmsArticle);

    /**
     * 删除文章信息
     * 
     * @param articleId 文章信息ID
     * @return 结果
     */
    public int deleteCmsArticleById(String articleId);

    /**
     * 批量删除文章信息
     * 
     * @param articleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsArticleByIds(String[] articleIds);
}
