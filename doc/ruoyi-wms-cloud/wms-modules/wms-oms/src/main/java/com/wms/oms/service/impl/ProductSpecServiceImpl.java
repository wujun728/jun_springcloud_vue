package com.wms.oms.service.impl;

import java.security.Security;
import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import com.wms.common.core.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.oms.mapper.ProductSpecMapper;
import com.wms.oms.domain.ProductSpec;
import com.wms.oms.service.IProductSpecService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 商品规格Service业务层处理
 *
 * @author zzm
 * @date 2021-05-14
 */
@Service
public class ProductSpecServiceImpl implements IProductSpecService
{
    @Autowired
    private ProductSpecMapper productSpecMapper;

    /**
     * 查询商品规格
     *
     * @param id 商品规格ID
     * @return 商品规格
     */
    @Override
    public ProductSpec selectProductSpecById(Long id)
    {
        return productSpecMapper.selectById(id);
    }

    /**
     * 查询商品规格列表
     *
     * @param productSpec 商品规格
     * @return 商品规格
     */
    @Override
    public List<ProductSpec> selectProductSpecList(ProductSpec productSpec)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        return productSpecMapper.selectList(queryWrapper);
    }

    /**
     * 新增商品规格
     *
     * @param productSpec 商品规格
     * @return 结果
     */
    @Override
    public int insertProductSpec(ProductSpec productSpec)
    {
        productSpec.setCreateBy(SecurityUtils.getUsername());
        productSpec.setCreateTime(DateUtils.getNowDate());
        productSpec.setDelFlag(Boolean.FALSE);
        return productSpecMapper.insert(productSpec);
    }

    /**
     * 修改商品规格
     *
     * @param productSpec 商品规格
     * @return 结果
     */
    @Override
    public int updateProductSpec(ProductSpec productSpec)
    {
        productSpec.setUpdateBy(SecurityUtils.getUsername());
        productSpec.setUpdateTime(DateUtils.getNowDate());
        return productSpecMapper.updateById(productSpec);
    }

    /**
     * 批量删除商品规格
     *
     * @param ids 需要删除的商品规格ID
     * @return 结果
     */
    @Override
    public int deleteProductSpecByIds(Long[] ids)
    {
        return productSpecMapper.deleteBatchIds(Arrays.asList(ids));
    }

    /**
     * 删除商品规格信息
     *
     * @param id 商品规格ID
     * @return 结果
     */
    @Override
    public int deleteProductSpecById(Long id)
    {
        return productSpecMapper.deleteById(id);
    }
}