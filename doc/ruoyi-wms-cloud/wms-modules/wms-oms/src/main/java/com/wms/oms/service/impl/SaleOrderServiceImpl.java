package com.wms.oms.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import com.wms.oms.domain.*;
import com.wms.oms.enums.InventoryStatus;
import com.wms.oms.mapper.InventoryLogMapper;
import com.wms.oms.mapper.InventoryMapper;
import com.wms.oms.mapper.SaleOrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.common.core.utils.SecurityUtils;
import com.wms.oms.mapper.SaleOrderMapper;
import com.wms.oms.service.ISaleOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * 销售订单Service业务层处理
 *
 * @author zzm
 * @date 2021-05-16
 */
@Service
public class SaleOrderServiceImpl implements ISaleOrderService
{
    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @Autowired
    private SaleOrderItemMapper saleOrderItemMapper;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private InventoryLogMapper inventoryLogMapper;

    /**
     * 查询销售订单
     *
     * @param id 销售订单ID
     * @return 销售订单
     */
    @Override
    public SaleOrder selectSaleOrderById(Long id)
    {
        return saleOrderMapper.selectById(id);
    }

    /**
     * 查询销售订单列表
     *
     * @param saleOrder 销售订单
     * @return 销售订单
     */
    @Override
    public List<SaleOrder> selectSaleOrderList(SaleOrder saleOrder)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("wso.del_flag", false);
        return saleOrderMapper.selectList(queryWrapper);
    }

    /**
     * 新增销售订单
     *
     * @param saleOrder 销售订单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSaleOrder(SaleOrder saleOrder)
    {
        saleOrder.setDelFlag(false);
        saleOrder.setCreateBy(SecurityUtils.getUsername());
        saleOrder.setCreateTime(DateUtils.getNowDate());
        saleOrder.setInventoryStatus(InventoryStatus.NOT_CONFIRM.getValue());
        int result = saleOrderMapper.insert(saleOrder);
        for (SaleOrderItem saleOrderItem : saleOrder.getSaleOrderItemList()) {
            saleOrderItem.setSaleOrderId(saleOrder.getId());
            saleOrderItem.setCreateBy(saleOrder.getCreateBy());
            saleOrderItem.setCreateTime(saleOrder.getCreateTime());
            saleOrderItem.setDelFlag(Boolean.FALSE);
            saleOrderItemMapper.insert(saleOrderItem);
        }
        return result;
    }

    /**
     * 修改销售订单
     *
     * @param saleOrder 销售订单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSaleOrder(SaleOrder saleOrder) {
        saleOrder.setUpdateBy(SecurityUtils.getUsername());
        saleOrder.setUpdateTime(DateUtils.getNowDate());
        for (SaleOrderItem saleOrderItem : saleOrder.getSaleOrderItemList()) {
            if (saleOrderItem.getId() == null) {
                saleOrderItem.setSaleOrderId(saleOrder.getId());
                saleOrderItem.setCreateBy(saleOrder.getUpdateBy());
                saleOrderItem.setCreateTime(saleOrder.getUpdateTime());
                saleOrderItem.setDelFlag(Boolean.FALSE);
                saleOrderItemMapper.insert(saleOrderItem);
            } else {
                saleOrderItem.setUpdateBy(saleOrder.getUpdateBy());
                saleOrderItem.setUpdateTime(saleOrder.getUpdateTime());
                saleOrderItemMapper.updateById(saleOrderItem);
            }
        }
        return saleOrderMapper.updateById(saleOrder);
    }


    /**
     * 确认出库
     *
     * @param saleOrder 销售订单
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int confirm(SaleOrder saleOrder)
    {
        for(SaleOrderItem saleOrderItem : saleOrder.getSaleOrderItemList()){
            // 记录库存
            Inventory inventory = new Inventory();
            inventory.setSkuId(saleOrderItem.getSkuId());
            inventory.setQty(inventory.getQty()!=null ? inventory.getQty().subtract(saleOrderItem.getQty()) : BigDecimal.ZERO.subtract(saleOrderItem.getQty()));
            Assert.isTrue(inventory.getQty().compareTo(BigDecimal.ZERO) >= 0 , "库存不足扣减!");
            inventory.setWarehouseId(saleOrderItem.getWarehouseId());
            inventory.setDelFlag(Boolean.FALSE);
            inventory.setCreateBy(SecurityUtils.getUsername());
            inventory.setCreateTime(DateUtils.getNowDate());
            inventoryMapper.insert(inventory);

            // 库存日志
            InventoryLog inventoryLog = new InventoryLog();
            inventoryLog.setInventoryType(saleOrder.getInventoryType());
            inventoryLog.setSkuId(saleOrderItem.getSkuId());
            inventoryLog.setDelFlag(Boolean.FALSE);
            inventoryLog.setWarehouseId(saleOrderItem.getWarehouseId());
            inventoryLog.setQty(saleOrderItem.getQty());
            inventoryLog.setSn(saleOrder.getSn());
            inventoryLog.setCreateTime(inventory.getCreateTime());
            inventoryLog.setCreateBy(SecurityUtils.getUsername());
            inventoryLogMapper.insert(inventoryLog);

        }
        // 确认入库
        saleOrder.setInventoryStatus(InventoryStatus.CONFIRM_OUT.getValue());
        return saleOrderMapper.updateById(saleOrder);
    }

    /**
     * 批量删除销售订单
     *
     * @param ids 需要删除的销售订单ID
     * @return 结果
     */
    @Override
    public int deleteSaleOrderByIds(Long[] ids)
    {
        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setDelFlag(Boolean.TRUE);
        saleOrder.setUpdateTime(DateUtils.getNowDate());
        saleOrder.setUpdateBy(SecurityUtils.getUsername());
        QueryWrapper<SaleOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",Arrays.asList(ids));
        return saleOrderMapper.update(saleOrder, queryWrapper);
    }

    /**
     * 删除销售订单信息
     *
     * @param id 销售订单ID
     * @return 结果
     */
    @Override
    public int deleteSaleOrderById(Long id)
    {
        return saleOrderMapper.deleteById(id);
    }
}