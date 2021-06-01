package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.ProductCategory;

/**
 * 商品分类信息Service接口
 *
 * @author zzm
 * @date 2021-05-14
 */
public interface IProductCategoryService
{
    /**
     * 查询商品分类信息
     *
     * @param id 商品分类信息ID
     * @return 商品分类信息
     */
    ProductCategory selectProductCategoryById(Long id);

    /**
     * 查询商品分类信息列表
     *
     * @param productCategory 商品分类信息
     * @return 商品分类信息集合
     */
    List<ProductCategory> selectProductCategoryList(ProductCategory productCategory);

    /**
     * 新增商品分类信息
     *
     * @param productCategory 商品分类信息
     * @return 结果
     */
    int insertProductCategory(ProductCategory productCategory);

    /**
     * 修改商品分类信息
     *
     * @param productCategory 商品分类信息
     * @return 结果
     */
    int updateProductCategory(ProductCategory productCategory);

    /**
     * 批量删除商品分类信息
     *
     * @param ids 需要删除的商品分类信息ID
     * @return 结果
     */
    int deleteProductCategoryByIds(Long[] ids);

    /**
     * 删除商品分类信息信息
     *
     * @param id 商品分类信息ID
     * @return 结果
     */
    int deleteProductCategoryById(Long id);
}