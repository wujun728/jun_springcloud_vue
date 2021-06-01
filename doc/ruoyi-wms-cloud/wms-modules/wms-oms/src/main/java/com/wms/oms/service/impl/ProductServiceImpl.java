package com.wms.oms.service.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wms.common.core.utils.DateUtils;
import com.wms.common.core.utils.SecurityUtils;
import com.wms.common.core.utils.StringUtils;
import com.wms.oms.domain.Customer;
import com.wms.oms.domain.ProductSku;
import com.wms.oms.domain.dto.ProductDto;
import com.wms.oms.mapper.ProductDtoMapper;
import com.wms.oms.mapper.ProductSkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.oms.mapper.ProductMapper;
import com.wms.oms.domain.Product;
import com.wms.oms.service.IProductService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品信息Service业务层处理
 *
 * @author zzm
 * @date 2021-05-04
 */
@Service
public class ProductServiceImpl implements IProductService
{
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductSkuMapper productSkuMapper;

    @Autowired
    private ProductDtoMapper productDtoMapper;

    /**
     * 查询商品信息
     *
     * @param id 商品信息ID
     * @return 商品信息
     */
    @Override
    public Product selectProductById(Long id)
    {
        return productMapper.selectById(id);
    }

    /**
     * 查询商品信息列表
     *
     * @param product 商品信息
     * @return 商品信息
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StringUtils.isNotEmpty(product.getSn())) {
            queryWrapper.like("sn", product.getSn());
        }
        if (StringUtils.isNotEmpty(product.getProductCode())){
            queryWrapper.eq("product_code", product.getProductCode());
        }
        if (StringUtils.isNotEmpty(product.getProductName())){
            queryWrapper.like("product_name", product.getProductName());
        }
        queryWrapper.eq("wp.del_flag", false);
        return productMapper.selectList(queryWrapper);
    }

    /**
     * 查询商品信息列表
     *
     * @param product 商品信息
     * @return 商品信息
     */
    @Override
    public List<ProductDto> selectProductDtoList(Product product)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("p.del_flag", false);
        return productDtoMapper.selectList(queryWrapper);
    }

    /**
     * 新增商品信息
     *
     * @param product 商品信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertProduct(Product product)
    {
        product.setSn("PT" + DateUtils.getNowDate().getTime());
        product.setCreateBy(SecurityUtils.getUsername());
        product.setCreateTime(DateUtils.getNowDate());
        product.setDelFlag(Boolean.FALSE);
        int result = productMapper.insert(product);
        int i = 0;
        for (ProductSku productSku : product.getProductSkuList()) {
            i++;
            productSku.setSn("ST"+ (DateUtils.getNowDate().getTime()+i));
            productSku.setDelFlag(Boolean.FALSE);
            productSku.setProductId(product.getId());
            productSku.setCreateTime(product.getCreateTime());
            productSku.setCreateBy(product.getCreateBy());
            productSkuMapper.insert(productSku);
        }
        return result;
    }

    /**
     * 修改商品信息
     *
     * @param product 商品信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateProduct(Product product)
    {
        product.setUpdateBy(SecurityUtils.getUsername());
        product.setUpdateTime(DateUtils.getNowDate());
        this.deleteProductSkuById(product.getId());
        int i = 0;
        for (ProductSku productSku : product.getProductSkuList()) {
                i++;
                productSku.setProductId(product.getId());
                productSku.setSn("ST"+ (DateUtils.getNowDate().getTime()+i));
                productSku.setCreateTime(product.getUpdateTime());
                productSku.setCreateBy(product.getUpdateBy());
                productSku.setDelFlag(Boolean.FALSE);
                productSkuMapper.insert(productSku);
        }
        return productMapper.updateById(product);
    }

    /**
     * 批量删除商品信息
     *
     * @param ids 需要删除的商品信息ID
     * @return 结果
     */
    @Override
    public int deleteProductByIds(Long[] ids)
    {
        Product product = new Product();
        product.setDelFlag(Boolean.TRUE);
        product.setUpdateTime(DateUtils.getNowDate());
        product.setUpdateBy(SecurityUtils.getUsername());
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",Arrays.asList(ids));
        return productMapper.update(product, queryWrapper);
    }


    private void deleteProductSkuById(Long productId){
        ProductSku productSku = new ProductSku();
        productSku.setDelFlag(Boolean.TRUE);
        productSku.setUpdateBy(SecurityUtils.getUsername());
        productSku.setUpdateTime(DateUtils.getNowDate());
        QueryWrapper<ProductSku> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id", productId);
        productSkuMapper.update(productSku, queryWrapper);
    }

    /**
     * 删除商品信息信息
     *
     * @param id 商品信息ID
     * @return 结果
     */
    @Override
    public int deleteProductById(Long id)
    {
        return productMapper.deleteById(id);
    }
}