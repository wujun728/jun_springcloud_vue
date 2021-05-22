package com.zebra.bussiness.cms.mapper;

import com.zebra.bussiness.cms.domain.CmsArticleContent;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 文章内容关联Mapper接口
 * 
 * @author zebra
 * @date 2020-06-26
 */
public interface CmsArticleContentMapper  extends Mapper<CmsArticleContent> {
    /**
     * 查询文章内容关联
     * 
     * @param id 文章内容关联ID
     * @return 文章内容关联
     */
    public CmsArticleContent selectCmsArticleContentById(String id);

    /**
     * 查询文章内容关联列表
     * 
     * @param cmsArticleContent 文章内容关联
     * @return 文章内容关联集合
     */
    public List<CmsArticleContent> selectCmsArticleContentList(CmsArticleContent cmsArticleContent);

    /**
     * 新增文章内容关联
     * 
     * @param cmsArticleContent 文章内容关联
     * @return 结果
     */
    public int insertCmsArticleContent(CmsArticleContent cmsArticleContent);

    /**
     * 修改文章内容关联
     * 
     * @param cmsArticleContent 文章内容关联
     * @return 结果
     */
    public int updateCmsArticleContent(CmsArticleContent cmsArticleContent);

    /**
     * 删除文章内容关联
     * 
     * @param id 文章内容关联ID
     * @return 结果
     */
    public int deleteCmsArticleContentById(String id);

    /**
     * 批量删除文章内容关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsArticleContentByIds(String[] ids);
}
