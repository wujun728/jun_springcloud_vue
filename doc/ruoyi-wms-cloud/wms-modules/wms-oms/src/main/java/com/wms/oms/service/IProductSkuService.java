package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.ProductSku;

/**
 * 商品sku信息Service接口
 *
 * @author zzm
 * @date 2021-05-15
 */
public interface IProductSkuService
{
    /**
     * 查询商品sku信息
     *
     * @param id 商品sku信息ID
     * @return 商品sku信息
     */
    ProductSku selectProductSkuById(Long id);

    /**
     * 查询商品sku信息列表
     *
     * @param productSku 商品sku信息
     * @return 商品sku信息集合
     */
    List<ProductSku> selectProductSkuList(ProductSku productSku);

    /**
     * 新增商品sku信息
     *
     * @param productSku 商品sku信息
     * @return 结果
     */
    int insertProductSku(ProductSku productSku);

    /**
     * 修改商品sku信息
     *
     * @param productSku 商品sku信息
     * @return 结果
     */
    int updateProductSku(ProductSku productSku);

    /**
     * 批量删除商品sku信息
     *
     * @param ids 需要删除的商品sku信息ID
     * @return 结果
     */
    int deleteProductSkuByIds(Long[] ids);

    /**
     * 删除商品sku信息信息
     *
     * @param id 商品sku信息ID
     * @return 结果
     */
    int deleteProductSkuById(Long id);
}