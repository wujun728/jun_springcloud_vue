package com.zebra.bussiness.cms.service.impl;

import com.zebra.bussiness.cms.domain.CmsComment;
import com.zebra.bussiness.cms.mapper.CmsCommentMapper;
import com.zebra.bussiness.cms.service.ICmsCommentService;
import com.zebra.common.core.text.Convert;
import com.zebra.common.utils.DateUtils;
import com.zebra.framework.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户评论Service业务层处理
 * 
 * @author zebra
 * @date 2020-06-30
 */
@Service
public class CmsCommentServiceImpl implements ICmsCommentService {
    @Autowired
    private CmsCommentMapper cmsCommentMapper;

    /**
     * 查询用户评论
     * 
     * @param commentId 用户评论ID
     * @return 用户评论
     */
    @Override
    public CmsComment selectCmsCommentById(Long commentId)
    {
        return cmsCommentMapper.selectCmsCommentById(commentId);
    }

    /**
     * 查询用户评论列表
     * 
     * @param cmsComment 用户评论
     * @return 用户评论
     */
    @Override
    public List<CmsComment> selectCmsCommentList(CmsComment cmsComment)
    {
        return cmsCommentMapper.selectCmsCommentList(cmsComment);
    }

    /**
     * 新增用户评论
     * 
     * @param cmsComment 用户评论
     * @return 结果
     */
    @Override
    public int insertCmsComment(CmsComment cmsComment)
    {
        cmsComment.setCreateTime(DateUtils.getNowDate());
        cmsComment.setUpdateTime(DateUtils.getNowDate());
        cmsComment.setUpdateBy(ShiroUtils.getLoginName());
        return cmsCommentMapper.insertCmsComment(cmsComment);
    }

    /**
     * 修改用户评论
     * 
     * @param cmsComment 用户评论
     * @return 结果
     */
    @Override
    public int updateCmsComment(CmsComment cmsComment)
    {
        cmsComment.setUpdateTime(DateUtils.getNowDate());
        cmsComment.setUpdateBy(ShiroUtils.getLoginName());
        return cmsCommentMapper.updateCmsComment(cmsComment);
    }

    /**
     * 删除用户评论对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsCommentByIds(String ids)
    {
        return cmsCommentMapper.deleteCmsCommentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户评论信息
     * 
     * @param commentId 用户评论ID
     * @return 结果
     */
    @Override
    public int deleteCmsCommentById(Long commentId)
    {
        return cmsCommentMapper.deleteCmsCommentById(commentId);
    }
}
