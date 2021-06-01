package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.oms.mapper.ProductCategoryMapper;
import com.wms.oms.domain.ProductCategory;
import com.wms.oms.service.IProductCategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 商品分类信息Service业务层处理
 *
 * @author zzm
 * @date 2021-05-14
 */
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService
{
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    /**
     * 查询商品分类信息
     *
     * @param id 商品分类信息ID
     * @return 商品分类信息
     */
    @Override
    public ProductCategory selectProductCategoryById(Long id)
    {
        return productCategoryMapper.selectById(id);
    }

    /**
     * 查询商品分类信息列表
     *
     * @param productCategory 商品分类信息
     * @return 商品分类信息
     */
    @Override
    public List<ProductCategory> selectProductCategoryList(ProductCategory productCategory)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        return productCategoryMapper.selectList(queryWrapper);
    }

    /**
     * 新增商品分类信息
     *
     * @param productCategory 商品分类信息
     * @return 结果
     */
    @Override
    public int insertProductCategory(ProductCategory productCategory)
    {
        productCategory.setCreateTime(DateUtils.getNowDate());
        return productCategoryMapper.insert(productCategory);
    }

    /**
     * 修改商品分类信息
     *
     * @param productCategory 商品分类信息
     * @return 结果
     */
    @Override
    public int updateProductCategory(ProductCategory productCategory)
    {
        productCategory.setUpdateTime(DateUtils.getNowDate());
        return productCategoryMapper.updateById(productCategory);
    }

    /**
     * 批量删除商品分类信息
     *
     * @param ids 需要删除的商品分类信息ID
     * @return 结果
     */
    @Override
    public int deleteProductCategoryByIds(Long[] ids)
    {
        return productCategoryMapper.deleteBatchIds(Arrays.asList(ids));
    }

    /**
     * 删除商品分类信息信息
     *
     * @param id 商品分类信息ID
     * @return 结果
     */
    @Override
    public int deleteProductCategoryById(Long id)
    {
        return productCategoryMapper.deleteById(id);
    }
}