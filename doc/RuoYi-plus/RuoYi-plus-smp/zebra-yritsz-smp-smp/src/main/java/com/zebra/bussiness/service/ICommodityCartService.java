package com.zebra.bussiness.service;

import com.zebra.bussiness.domain.CommodityCart;
import java.util.List;

/**
 * 购物车信息Service接口
 * 
 * @author zebra
 * @date 2021-01-09
 */
public interface ICommodityCartService {
    /**
     * 查询购物车信息
     * 
     * @param cartId 购物车信息ID
     * @return 购物车信息
     */
    public CommodityCart selectCommodityCartById(String cartId);

    /**
     * 查询购物车信息列表
     * 
     * @param commodityCart 购物车信息
     * @return 购物车信息集合
     */
    public List<CommodityCart> selectCommodityCartList(CommodityCart commodityCart);

    /**
     * 新增购物车信息
     * 
     * @param commodityCart 购物车信息
     * @return 结果
     */
    public int insertCommodityCart(CommodityCart commodityCart);

    /**
     * 修改购物车信息
     * 
     * @param commodityCart 购物车信息
     * @return 结果
     */
    public int updateCommodityCart(CommodityCart commodityCart);

    /**
     * 批量删除购物车信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityCartByIds(String ids);

    /**
     * 删除购物车信息信息
     * 
     * @param cartId 购物车信息ID
     * @return 结果
     */
    public int deleteCommodityCartById(String cartId);
}
