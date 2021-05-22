package com.zebra.bussiness.cms.service;

import com.zebra.bussiness.cms.domain.CmsCategory;
import java.util.List;
import com.zebra.common.core.domain.Ztree;

/**
 * 文章分类Service接口
 * 
 * @author zebra
 * @date 2020-06-24
 */
public interface ICmsCategoryService {
    /**
     * 查询文章分类
     * 
     * @param categoryId 文章分类ID
     * @return 文章分类
     */
    public CmsCategory selectCmsCategoryById(Long categoryId);

    /**
     * 查询文章分类列表
     * 
     * @param cmsCategory 文章分类
     * @return 文章分类集合
     */
    public List<CmsCategory> selectCmsCategoryList(CmsCategory cmsCategory);

    /**
     * 新增文章分类
     * 
     * @param cmsCategory 文章分类
     * @return 结果
     */
    public int insertCmsCategory(CmsCategory cmsCategory);

    /**
     * 修改文章分类
     * 
     * @param cmsCategory 文章分类
     * @return 结果
     */
    public int updateCmsCategory(CmsCategory cmsCategory);

    /**
     * 批量删除文章分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsCategoryByIds(String ids);

    /**
     * 删除文章分类信息
     * 
     * @param categoryId 文章分类ID
     * @return 结果
     */
    public int deleteCmsCategoryById(Long categoryId);

    /**
     * 查询文章分类树列表
     * 
     * @return 所有文章分类信息
     */
    public List<Ztree> selectCmsCategoryTree();
}
