package com.zebra.bussiness.cms.mapper;

import com.zebra.bussiness.cms.domain.CmsComment;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户评论Mapper接口
 * 
 * @author zebra
 * @date 2020-06-30
 */
public interface CmsCommentMapper  extends Mapper<CmsComment> {
    /**
     * 查询用户评论
     * 
     * @param commentId 用户评论ID
     * @return 用户评论
     */
    public CmsComment selectCmsCommentById(Long commentId);

    /**
     * 查询用户评论列表
     * 
     * @param cmsComment 用户评论
     * @return 用户评论集合
     */
    public List<CmsComment> selectCmsCommentList(CmsComment cmsComment);

    /**
     * 新增用户评论
     * 
     * @param cmsComment 用户评论
     * @return 结果
     */
    public int insertCmsComment(CmsComment cmsComment);

    /**
     * 修改用户评论
     * 
     * @param cmsComment 用户评论
     * @return 结果
     */
    public int updateCmsComment(CmsComment cmsComment);

    /**
     * 删除用户评论
     * 
     * @param commentId 用户评论ID
     * @return 结果
     */
    public int deleteCmsCommentById(Long commentId);

    /**
     * 批量删除用户评论
     * 
     * @param commentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsCommentByIds(String[] commentIds);
}
