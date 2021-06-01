package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.PurchaseOrderItem;

/**
 * 采购订单明细Service接口
 *
 * @author zzm
 * @date 2021-05-16
 */
public interface IPurchaseOrderItemService
{
    /**
     * 查询采购订单明细
     *
     * @param id 采购订单明细ID
     * @return 采购订单明细
     */
    PurchaseOrderItem selectPurchaseOrderItemById(Long id);

    /**
     * 查询采购订单明细列表
     *
     * @param purchaseOrderItem 采购订单明细
     * @return 采购订单明细集合
     */
    List<PurchaseOrderItem> selectPurchaseOrderItemList(PurchaseOrderItem purchaseOrderItem);

    /**
     * 新增采购订单明细
     *
     * @param purchaseOrderItem 采购订单明细
     * @return 结果
     */
    int insertPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);

    /**
     * 修改采购订单明细
     *
     * @param purchaseOrderItem 采购订单明细
     * @return 结果
     */
    int updatePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);

    /**
     * 批量删除采购订单明细
     *
     * @param ids 需要删除的采购订单明细ID
     * @return 结果
     */
    int deletePurchaseOrderItemByIds(Long[] ids);

    /**
     * 删除采购订单明细信息
     *
     * @param id 采购订单明细ID
     * @return 结果
     */
    int deletePurchaseOrderItemById(Long id);
}