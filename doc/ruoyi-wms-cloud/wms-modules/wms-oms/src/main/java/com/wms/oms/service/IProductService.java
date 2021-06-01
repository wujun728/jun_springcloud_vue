package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.Product;
import com.wms.oms.domain.dto.ProductDto;

/**
 * 商品信息Service接口
 *
 * @author zzm
 * @date 2021-05-04
 */
public interface IProductService
{
    /**
     * 查询商品信息
     *
     * @param id 商品信息ID
     * @return 商品信息
     */
    Product selectProductById(Long id);

    /**
     * 查询商品信息列表
     *
     * @param product 商品信息
     * @return 商品信息集合
     */
    List<Product> selectProductList(Product product);


    /**
     * 查询商品信息列表
     *
     * @param product 商品信息
     * @return 商品信息集合
     */
    List<ProductDto> selectProductDtoList(Product product);


    /**
     * 新增商品信息
     *
     * @param product 商品信息
     * @return 结果
     */
    int insertProduct(Product product);

    /**
     * 修改商品信息
     *
     * @param product 商品信息
     * @return 结果
     */
    int updateProduct(Product product);

    /**
     * 批量删除商品信息
     *
     * @param ids 需要删除的商品信息ID
     * @return 结果
     */
    int deleteProductByIds(Long[] ids);

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息ID
     * @return 结果
     */
    int deleteProductById(Long id);
}