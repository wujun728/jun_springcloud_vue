package com.zebra.bussiness.service;

import java.util.List;

import com.zebra.bussiness.domain.Orders;
import com.zebra.bussiness.domain.page.OrdersPage;

/**
 * 订单信息Service接口
 *
 * @author zebra
 * @date 2020-03-03
 */
public interface IOrdersService
{
    /**
     * 查询订单信息
     *
     * @param orderId 订单信息ID
     * @return 订单信息
     */
    public Orders selectOrdersById(String orderId);

    /**
     * 查询订单信息列表
     *
     * @param orders 订单信息
     * @return 订单信息集合
     */
    public List<OrdersPage> selectOrdersList(Orders orders);

    /**
     * 新增订单信息
     *
     * @param orders 订单信息
     * @return 结果
     */
    public int insertOrders(Orders orders);

    /**
     * 修改订单信息
     *
     * @param orders 订单信息
     * @return 结果
     */
    public int updateOrders(Orders orders);

    /**
     * 批量删除订单信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrdersByIds(String ids);

    /**
     * 删除订单信息信息
     *
     * @param orderId 订单信息ID
     * @return 结果
     */
    public int deleteOrdersById(String orderId);
}
