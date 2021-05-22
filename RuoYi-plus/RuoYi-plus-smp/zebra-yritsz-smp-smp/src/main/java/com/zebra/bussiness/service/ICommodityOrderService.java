package com.zebra.bussiness.service;

import com.zebra.bussiness.domain.CommodityOrder;
import com.zebra.common.core.domain.AjaxResult;

import java.util.List;

/**
 * 商品订单Service接口
 * 
 * @author zebra
 * @date 2020-08-18
 */
public interface ICommodityOrderService {
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
    public AjaxResult updateCommodityOrder(CommodityOrder commodityOrder);

    /**
     * 批量删除商品订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityOrderByIds(String ids);

    /**
     * 删除商品订单信息
     * 
     * @param orderId 商品订单ID
     * @return 结果
     */
    public int deleteCommodityOrderById(String orderId);
}
