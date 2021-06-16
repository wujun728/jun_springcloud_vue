package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.CommodityOrder;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商品订单Mapper接口
 * 
 * @author zebra
 * @date 2020-08-18
 */
public interface CommodityOrderMapper  extends Mapper<CommodityOrder> {
    /**
     * 查询商品订单
     * 
     * @param orderId 商品订单ID
     * @return 商品订单
     */
    public CommodityOrder selectCommodityOrderById(String orderId);

    /**
     * 查询商品订单列表
     * 
     * @param commodityOrder 商品订单
     * @return 商品订单集合
     */
    public List<CommodityOrder> selectCommodityOrderList(CommodityOrder commodityOrder);

    /**
     * 新增商品订单
     * 
     * @param commodityOrder 商品订单
     * @return 结果
     */
    public int insertCommodityOrder(CommodityOrder commodityOrder);

    /**
     * 修改商品订单
     * 
     * @param commodityOrder 商品订单
     * @return 结果
     */
    public int updateCommodityOrder(CommodityOrder commodityOrder);

    /**
     * 删除商品订单
     * 
     * @param orderId 商品订单ID
     * @return 结果
     */
    public int deleteCommodityOrderById(String orderId);

    /**
     * 批量删除商品订单
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityOrderByIds(String[] orderIds);
}
