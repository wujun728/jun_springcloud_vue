package com.wms.oms.service;

import java.util.List;

import com.wms.oms.domain.PurchaseOrder;
import com.wms.oms.domain.SaleOrder;

/**
 * 销售订单Service接口
 *
 * @author zzm
 * @date 2021-05-16
 */
public interface ISaleOrderService
{
    /**
     * 查询销售订单
     *
     * @param id 销售订单ID
     * @return 销售订单
     */
    SaleOrder selectSaleOrderById(Long id);

    /**
     * 查询销售订单列表
     *
     * @param saleOrder 销售订单
     * @return 销售订单集合
     */
    List<SaleOrder> selectSaleOrderList(SaleOrder saleOrder);

    /**
     * 新增销售订单
     *
     * @param saleOrder 销售订单
     * @return 结果
     */
    int insertSaleOrder(SaleOrder saleOrder);

    /**
     * 修改销售订单
     *
     * @param saleOrder 销售订单
     * @return 结果
     */
    int updateSaleOrder(SaleOrder saleOrder);

    /**
     * 确认销售订单
     *
     * @param saleOrder 销售订单
     * @return 结果
     */
    int confirm(SaleOrder saleOrder);

    /**
     * 批量删除销售订单
     *
     * @param ids 需要删除的销售订单ID
     * @return 结果
     */
    int deleteSaleOrderByIds(Long[] ids);

    /**
     * 删除销售订单信息
     *
     * @param id 销售订单ID
     * @return 结果
     */
    int deleteSaleOrderById(Long id);
}