package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.SaleOrderItem;

/**
 * 销售订单明细Service接口
 *
 * @author zzm
 * @date 2021-05-16
 */
public interface ISaleOrderItemService
{
    /**
     * 查询销售订单明细
     *
     * @param id 销售订单明细ID
     * @return 销售订单明细
     */
    SaleOrderItem selectSaleOrderItemById(Long id);

    /**
     * 查询销售订单明细列表
     *
     * @param saleOrderItem 销售订单明细
     * @return 销售订单明细集合
     */
    List<SaleOrderItem> selectSaleOrderItemList(SaleOrderItem saleOrderItem);

    /**
     * 新增销售订单明细
     *
     * @param saleOrderItem 销售订单明细
     * @return 结果
     */
    int insertSaleOrderItem(SaleOrderItem saleOrderItem);

    /**
     * 修改销售订单明细
     *
     * @param saleOrderItem 销售订单明细
     * @return 结果
     */
    int updateSaleOrderItem(SaleOrderItem saleOrderItem);

    /**
     * 批量删除销售订单明细
     *
     * @param ids 需要删除的销售订单明细ID
     * @return 结果
     */
    int deleteSaleOrderItemByIds(Long[] ids);

    /**
     * 删除销售订单明细信息
     *
     * @param id 销售订单明细ID
     * @return 结果
     */
    int deleteSaleOrderItemById(Long id);
}