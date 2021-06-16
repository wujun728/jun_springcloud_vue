package com.zebra.bussiness.cms.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.zebra.common.core.domain.Ztree;
import com.zebra.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.cms.mapper.CmsCategoryMapper;
import com.zebra.bussiness.cms.domain.CmsCategory;
import com.zebra.bussiness.cms.service.ICmsCategoryService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 文章分类Service业务层处理
 * 
 * @author zebra
 * @date 2020-06-24
 */
@Service
public class CmsCategoryServiceImpl implements ICmsCategoryService {
    @Autowired
    private CmsCategoryMapper cmsCategoryMapper;

    /**
     * 查询文章分类
     * 
     * @param categoryId 文章分类ID
     * @return 文章分类
     */
    @Override
    public CmsCategory selectCmsCategoryById(Long categoryId)
    {
        return cmsCategoryMapper.selectCmsCategoryById(categoryId);
    }

    /**
     * 查询文章分类列表
     * 
     * @param cmsCategory 文章分类
     * @return 文章分类
     */
    @Override
    public List<CmsCategory> selectCmsCategoryList(CmsCategory cmsCategory)
    {
        return cmsCategoryMapper.selectCmsCategoryList(cmsCategory);
    }

    /**
     * 新增文章分类
     * 
     * @param cmsCategory 文章分类
     * @return 结果
     */
    @Override
    public int insertCmsCategory(CmsCategory cmsCategory)
    {
        cmsCategory.setCreateTime(DateUtils.getNowDate());
        cmsCategory.setUpdateTime(DateUtils.getNowDate());
        cmsCategory.setUpdateBy(ShiroUtils.getLoginName());
        return cmsCategoryMapper.insertCmsCategory(cmsCategory);
    }

    /**
     * 修改文章分类
     * 
     * @param cmsCategory 文章分类
     * @return 结果
     */
    @Override
    public int updateCmsCategory(CmsCategory cmsCategory)
    {
        cmsCategory.setUpdateTime(DateUtils.getNowDate());
        cmsCategory.setUpdateBy(ShiroUtils.getLoginName());
        return cmsCategoryMapper.updateCmsCategory(cmsCategory);
    }

    /**
     * 删除文章分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsCategoryByIds(String ids)
    {
        return cmsCategoryMapper.deleteCmsCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章分类信息
     * 
     * @param categoryId 文章分类ID
     * @return 结果
     */
    @Override
    public int deleteCmsCategoryById(Long categoryId)
    {
        return cmsCategoryMapper.deleteCmsCategoryById(categoryId);
    }

    /**
     * 查询文章分类树列表
     * 
     * @return 所有文章分类信息
     */
    @Override
    public List<Ztree> selectCmsCategoryTree()
    {
        List<CmsCategory> cmsCategoryList = cmsCategoryMapper.selectCmsCategoryList(new CmsCategory());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (CmsCategory cmsCategory : cmsCategoryList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(cmsCategory.getCategoryId());
            ztree.setpId(cmsCategory.getCategoryParentId());
            ztree.setName(cmsCategory.getCategoryName());
            ztree.setTitle(cmsCategory.getCategoryName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
