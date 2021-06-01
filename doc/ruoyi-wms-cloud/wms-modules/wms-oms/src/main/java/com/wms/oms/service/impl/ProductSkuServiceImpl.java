package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.oms.mapper.ProductSkuMapper;
import com.wms.oms.domain.ProductSku;
import com.wms.oms.service.IProductSkuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 商品sku信息Service业务层处理
 *
 * @author zzm
 * @date 2021-05-15
 */
@Service
public class ProductSkuServiceImpl implements IProductSkuService
{
    @Autowired
    private ProductSkuMapper productSkuMapper;

    /**
     * 查询商品sku信息
     *
     * @param id 商品sku信息ID
     * @return 商品sku信息
     */
    @Override
    public ProductSku selectProductSkuById(Long id)
    {
        return productSkuMapper.selectById(id);
    }

    /**
     * 查询商品sku信息列表
     *
     * @param productSku 商品sku信息
     * @return 商品sku信息
     */
    @Override
    public List<ProductSku> selectProductSkuList(ProductSku productSku)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        return productSkuMapper.selectList(queryWrapper);
    }

    /**
     * 新增商品sku信息
     *
     * @param productSku 商品sku信息
     * @return 结果
     */
    @Override
    public int insertProductSku(ProductSku productSku)
    {
        productSku.setCreateTime(DateUtils.getNowDate());
        return productSkuMapper.insert(productSku);
    }

    /**
     * 修改商品sku信息
     *
     * @param productSku 商品sku信息
     * @return 结果
     */
    @Override
    public int updateProductSku(ProductSku productSku)
    {
        productSku.setUpdateTime(DateUtils.getNowDate());
        return productSkuMapper.updateById(productSku);
    }

    /**
     * 批量删除商品sku信息
     *
     * @param ids 需要删除的商品sku信息ID
     * @return 结果
     */
    @Override
    public int deleteProductSkuByIds(Long[] ids)
    {
        return productSkuMapper.deleteBatchIds(Arrays.asList(ids));
    }

    /**
     * 删除商品sku信息信息
     *
     * @param id 商品sku信息ID
     * @return 结果
     */
    @Override
    public int deleteProductSkuById(Long id)
    {
        return productSkuMapper.deleteById(id);
    }
}