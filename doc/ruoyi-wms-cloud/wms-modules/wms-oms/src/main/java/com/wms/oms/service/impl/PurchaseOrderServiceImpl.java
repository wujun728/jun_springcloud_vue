package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import com.wms.oms.domain.Inventory;
import com.wms.oms.domain.InventoryLog;
import com.wms.oms.domain.PurchaseOrderItem;
import com.wms.oms.enums.InventoryStatus;
import com.wms.oms.enums.InventoryType;
import com.wms.oms.mapper.InventoryLogMapper;
import com.wms.oms.mapper.InventoryMapper;
import com.wms.oms.mapper.PurchaseOrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.common.core.utils.SecurityUtils;
import com.wms.oms.mapper.PurchaseOrderMapper;
import com.wms.oms.domain.PurchaseOrder;
import com.wms.oms.service.IPurchaseOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 采购订单Service业务层处理
 *
 * @author zzm
 * @date 2021-05-16
 */
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService
{
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private PurchaseOrderItemMapper purchaseOrderItemMapper;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private InventoryLogMapper inventoryLogMapper;

    /**
     * 查询采购订单
     *
     * @param id 采购订单ID
     * @return 采购订单
     */
    @Override
    public PurchaseOrder selectPurchaseOrderById(Long id)
    {
        return purchaseOrderMapper.selectById(id);
    }

    /**
     * 查询采购订单列表
     *
     * @param purchaseOrder 采购订单
     * @return 采购订单
     */
    @Override
    public List<PurchaseOrder> selectPurchaseOrderList(PurchaseOrder purchaseOrder)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("wpo.del_flag", false);
        return purchaseOrderMapper.selectList(queryWrapper);
    }

    /**
     * 新增采购订单
     *
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrder.setDelFlag(false);
        purchaseOrder.setCreateBy(SecurityUtils.getUsername());
        purchaseOrder.setCreateTime(DateUtils.getNowDate());
        purchaseOrder.setInventoryType(InventoryType.PURCHASE_IN.getValue());
        purchaseOrder.setInventoryStatus(InventoryStatus.NOT_CONFIRM.getValue());
        int result = purchaseOrderMapper.insert(purchaseOrder);
        for (PurchaseOrderItem purchaseOrderItem : purchaseOrder.getPurchaseOrderItemList()) {
            purchaseOrderItem.setPurchaseOrderId(purchaseOrder.getId());
            purchaseOrderItem.setCreateTime(purchaseOrder.getCreateTime());
            purchaseOrderItem.setCreateBy(purchaseOrder.getCreateBy());
            purchaseOrderItem.setDelFlag(Boolean.FALSE);
            purchaseOrderItemMapper.insert(purchaseOrderItem);
        }
        return result;
    }

    /**
     * 修改采购订单
     *
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatePurchaseOrder(PurchaseOrder purchaseOrder)
    {
        purchaseOrder.setUpdateBy(SecurityUtils.getUsername());
        purchaseOrder.setUpdateTime(DateUtils.getNowDate());
        for(PurchaseOrderItem purchaseOrderItem : purchaseOrder.getPurchaseOrderItemList()){
            if(purchaseOrderItem.getId()!=null){
                purchaseOrderItem.setUpdateTime(purchaseOrder.getUpdateTime());
                purchaseOrderItem.setUpdateBy(purchaseOrder.getUpdateBy());
                purchaseOrderItemMapper.updateById(purchaseOrderItem);
            }else{
                purchaseOrderItem.setPurchaseOrderId(purchaseOrder.getId());
                purchaseOrderItem.setCreateTime(purchaseOrder.getUpdateTime());
                purchaseOrderItem.setCreateBy(purchaseOrder.getUpdateBy());
                purchaseOrderItem.setDelFlag(Boolean.FALSE);
                purchaseOrderItemMapper.insert(purchaseOrderItem);
            }
        }
        return purchaseOrderMapper.updateById(purchaseOrder);
    }

    /**
     * 确认入库/出库
     *
     * @param purchaseOrder 采购订单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int confirm(PurchaseOrder purchaseOrder)
    {
        for(PurchaseOrderItem purchaseOrderItem : purchaseOrder.getPurchaseOrderItemList()){
            // 记录库存
            Inventory inventory = new Inventory();
            inventory.setSkuId(purchaseOrderItem.getSkuId());
            inventory.setQty(inventory.getQty()!=null ? inventory.getQty().add(purchaseOrderItem.getQty()):purchaseOrderItem.getQty());
            inventory.setWarehouseId(purchaseOrderItem.getWarehouseId());
            inventory.setDelFlag(Boolean.FALSE);
            inventory.setCreateBy(SecurityUtils.getUsername());
            inventory.setCreateTime(DateUtils.getNowDate());
            inventoryMapper.insert(inventory);

            // 库存日志
            InventoryLog inventoryLog = new InventoryLog();
            inventoryLog.setInventoryType(purchaseOrder.getInventoryType());
            inventoryLog.setSkuId(purchaseOrderItem.getSkuId());
            inventoryLog.setDelFlag(Boolean.FALSE);
            inventoryLog.setWarehouseId(purchaseOrderItem.getWarehouseId());
            inventoryLog.setQty(purchaseOrderItem.getQty());
            inventoryLog.setSn(purchaseOrder.getSn());
            inventoryLog.setCreateTime(inventory.getCreateTime());
            inventoryLog.setCreateBy(SecurityUtils.getUsername());
            inventoryLogMapper.insert(inventoryLog);

        }
        // 确认入库
        purchaseOrder.setInventoryStatus(InventoryStatus.CONFIRM_IN.getValue());
        return purchaseOrderMapper.updateById(purchaseOrder);
    }

    /**
     * 批量删除采购订单
     *
     * @param ids 需要删除的采购订单ID
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderByIds(Long[] ids)
    {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setDelFlag(Boolean.TRUE);
        purchaseOrder.setUpdateTime(DateUtils.getNowDate());
        purchaseOrder.setUpdateBy(SecurityUtils.getUsername());
        QueryWrapper<PurchaseOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",Arrays.asList(ids));
        return purchaseOrderMapper.update(purchaseOrder, queryWrapper);
    }

    /**
     * 删除采购订单信息
     *
     * @param id 采购订单ID
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderById(Long id)
    {
        return purchaseOrderMapper.deleteById(id);
    }
}