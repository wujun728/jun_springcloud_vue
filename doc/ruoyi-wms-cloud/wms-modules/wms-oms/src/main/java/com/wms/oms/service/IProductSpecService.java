package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.ProductSpec;

/**
 * 商品规格Service接口
 *
 * @author zzm
 * @date 2021-05-14
 */
public interface IProductSpecService
{
    /**
     * 查询商品规格
     *
     * @param id 商品规格ID
     * @return 商品规格
     */
    ProductSpec selectProductSpecById(Long id);

    /**
     * 查询商品规格列表
     *
     * @param productSpec 商品规格
     * @return 商品规格集合
     */
    List<ProductSpec> selectProductSpecList(ProductSpec productSpec);

    /**
     * 新增商品规格
     *
     * @param productSpec 商品规格
     * @return 结果
     */
    int insertProductSpec(ProductSpec productSpec);

    /**
     * 修改商品规格
     *
     * @param productSpec 商品规格
     * @return 结果
     */
    int updateProductSpec(ProductSpec productSpec);

    /**
     * 批量删除商品规格
     *
     * @param ids 需要删除的商品规格ID
     * @return 结果
     */
    int deleteProductSpecByIds(Long[] ids);

    /**
     * 删除商品规格信息
     *
     * @param id 商品规格ID
     * @return 结果
     */
    int deleteProductSpecById(Long id);
}