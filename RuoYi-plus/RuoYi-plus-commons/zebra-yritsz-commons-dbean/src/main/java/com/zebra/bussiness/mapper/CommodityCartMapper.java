package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.CommodityCart;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 购物车信息Mapper接口
 * 
 * @author zebra
 * @date 2021-01-09
 */
public interface CommodityCartMapper  extends Mapper<CommodityCart> {
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
     * 删除购物车信息
     * 
     * @param cartId 购物车信息ID
     * @return 结果
     */
    public int deleteCommodityCartById(String cartId);

    /**
     * 批量删除购物车信息
     * 
     * @param cartIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityCartByIds(String[] cartIds);
}
