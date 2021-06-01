package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.Orders;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 订单信息Mapper接口
 * 
 * @author zebra
 * @date 2020-03-25
 */
public interface OrdersMapper  extends Mapper<Orders> 
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
    public List<Orders> selectOrdersList(Orders orders);

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
     * 删除订单信息
     * 
     * @param orderId 订单信息ID
     * @return 结果
     */
    public int deleteOrdersById(String orderId);

    /**
     * 批量删除订单信息
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrdersByIds(String[] orderIds);
}
