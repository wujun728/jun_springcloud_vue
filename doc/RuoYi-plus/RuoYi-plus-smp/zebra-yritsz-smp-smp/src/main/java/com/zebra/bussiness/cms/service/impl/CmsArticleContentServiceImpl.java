package com.zebra.bussiness.cms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.cms.mapper.CmsArticleContentMapper;
import com.zebra.bussiness.cms.domain.CmsArticleContent;
import com.zebra.bussiness.cms.service.ICmsArticleContentService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 文章内容关联Service业务层处理
 * 
 * @author zebra
 * @date 2020-06-26
 */
@Service
public class CmsArticleContentServiceImpl implements ICmsArticleContentService {
    @Autowired
    private CmsArticleContentMapper cmsArticleContentMapper;

    /**
     * 查询文章内容关联
     * 
     * @param id 文章内容关联ID
     * @return 文章内容关联
     */
    @Override
    public CmsArticleContent selectCmsArticleContentById(String id)
    {
        return cmsArticleContentMapper.selectCmsArticleContentById(id);
    }

    /**
     * 查询文章内容关联列表
     * 
     * @param cmsArticleContent 文章内容关联
     * @return 文章内容关联
     */
    @Override
    public List<CmsArticleContent> selectCmsArticleContentList(CmsArticleContent cmsArticleContent)
    {
        return cmsArticleContentMapper.selectCmsArticleContentList(cmsArticleContent);
    }

    /**
     * 新增文章内容关联
     * 
     * @param cmsArticleContent 文章内容关联
     * @return 结果
     */
    @Override
    public int insertCmsArticleContent(CmsArticleContent cmsArticleContent)
    {
        return cmsArticleContentMapper.insertCmsArticleContent(cmsArticleContent);
    }

    /**
     * 修改文章内容关联
     * 
     * @param cmsArticleContent 文章内容关联
     * @return 结果
     */
    @Override
    public int updateCmsArticleContent(CmsArticleContent cmsArticleContent)
    {
        return cmsArticleContentMapper.updateCmsArticleContent(cmsArticleContent);
    }

    /**
     * 删除文章内容关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsArticleContentByIds(String ids)
    {
        return cmsArticleContentMapper.deleteCmsArticleContentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章内容关联信息
     * 
     * @param id 文章内容关联ID
     * @return 结果
     */
    @Override
    public int deleteCmsArticleContentById(String id)
    {
        return cmsArticleContentMapper.deleteCmsArticleContentById(id);
    }
}
