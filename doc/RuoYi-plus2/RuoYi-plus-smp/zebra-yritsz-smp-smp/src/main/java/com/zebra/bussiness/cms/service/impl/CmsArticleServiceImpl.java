package com.zebra.bussiness.cms.service.impl;

import java.util.List;

import com.zebra.bussiness.cms.domain.CmsArticleContent;
import com.zebra.bussiness.cms.domain.page.CmsArticlePage;
import com.zebra.bussiness.cms.mapper.CmsArticleContentMapper;
import com.zebra.common.exception.BusinessException;
import com.zebra.common.utils.DateUtils;
import com.zebra.common.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.cms.mapper.CmsArticleMapper;
import com.zebra.bussiness.cms.domain.CmsArticle;
import com.zebra.bussiness.cms.service.ICmsArticleService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文章信息Service业务层处理
 *
 * @author zebra
 * @date 2020-06-25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CmsArticleServiceImpl implements ICmsArticleService {
    @Autowired
    private CmsArticleMapper cmsArticleMapper;
    @Autowired
    private CmsArticleContentMapper cmsArticleContentMapper;

    /**
     * 查询文章信息
     *
     * @param articleId 文章信息ID
     * @return 文章信息
     */
    @Override
    public CmsArticle selectCmsArticleById(String articleId) {
        return cmsArticleMapper.selectCmsArticleById(articleId);
    }

    /**
     * 查询文章信息列表
     *
     * @param cmsArticle 文章信息
     * @return 文章信息
     */
    @Override
    public List<CmsArticle> selectCmsArticleList(CmsArticle cmsArticle) {
        return cmsArticleMapper.selectCmsArticleList(cmsArticle);
    }

    /**
     * 新增文章信息
     *
     * @param cmsArticle 文章信息
     * @return 结果
     */
    @Override
    public int insertCmsArticle(CmsArticlePage cmsArticle) {
        cmsArticle.setArticleId(DateUtils.dateTimeNow());
        cmsArticle.setCreateTime(DateUtils.getNowDate());
        cmsArticle.setUpdateTime(DateUtils.getNowDate());
        cmsArticle.setUpdateBy(ShiroUtils.getLoginName());
        CmsArticleContent cmsArticleContent = new CmsArticleContent();
        cmsArticleContent.setId(cmsArticle.getArticleId());
        cmsArticleContent.setContent(cmsArticle.getContent());
        int a = cmsArticleContentMapper.insertCmsArticleContent(cmsArticleContent);
        if (a == 0)
            return 0;
        a = cmsArticleMapper.insertCmsArticle(cmsArticle);
        if (a == 0)
            throw new BusinessException("添加文章发生错误");
        return a;
    }

    /**
     * 修改文章信息
     *
     * @param cmsArticle 文章信息
     * @return 结果
     */
    @Override
    public int updateCmsArticle(CmsArticlePage cmsArticle) {
        cmsArticle.setUpdateTime(DateUtils.getNowDate());
        cmsArticle.setUpdateBy(ShiroUtils.getLoginName());
        CmsArticleContent cmsArticleContent = cmsArticleContentMapper.selectCmsArticleContentById(cmsArticle.getArticleId());
        if (cmsArticleContent == null)
            throw new BusinessException("内容信息不存在");
        cmsArticleContent.setContent(cmsArticle.getContent());
        int a = cmsArticleMapper.updateCmsArticle(cmsArticle);
        if (a == 0)
            return 0;
        if (!StringUtils.isEmpty(cmsArticle.getContent())) {
            a = cmsArticleContentMapper.updateByPrimaryKeySelective(cmsArticleContent);
            if (a == 0)
                throw new BusinessException("修改文章发生错误");
        }
        return a;
    }

    /**
     * 删除文章信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsArticleByIds(String ids) {
        int a = cmsArticleMapper.deleteCmsArticleByIds(Convert.toStrArray(ids));
        if (a == 0)
            return 0;
        a = cmsArticleContentMapper.deleteCmsArticleContentByIds(Convert.toStrArray(ids));
        if (a == 0)
            throw new BusinessException("删除文章发生错误");
        return a;
    }

    /**
     * 删除文章信息信息
     *
     * @param articleId 文章信息ID
     * @return 结果
     */
    @Override
    public int deleteCmsArticleById(String articleId) {
        return cmsArticleMapper.deleteCmsArticleById(articleId);
    }
}
