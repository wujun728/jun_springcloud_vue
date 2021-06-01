package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.PurchaseOrder;

/**
 * 采购订单Service接口
 *
 * @author zzm
 * @date 2021-05-16
 */
public interface IPurchaseOrderService
{
    /**
     * 查询采购订单
     *
     * @param id 采购订单ID
     * @return 采购订单
     */
    PurchaseOrder selectPurchaseOrderById(Long id);

    /**
     * 查询采购订单列表
     *
     * @param purchaseOrder 采购订单
     * @return 采购订单集合
     */
    List<PurchaseOrder> selectPurchaseOrderList(PurchaseOrder purchaseOrder);

    /**
     * 新增采购订单
     *
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    int insertPurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * 修改采购订单
     *
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    int updatePurchaseOrder(PurchaseOrder purchaseOrder);

    /**
     * 修改采购订单
     *
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    int confirm(PurchaseOrder purchaseOrder);

    /**
     * 批量删除采购订单
     *
     * @param ids 需要删除的采购订单ID
     * @return 结果
     */
    int deletePurchaseOrderByIds(Long[] ids);

    /**
     * 删除采购订单信息
     *
     * @param id 采购订单ID
     * @return 结果
     */
    int deletePurchaseOrderById(Long id);
}