package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.common.core.utils.SecurityUtils;
import com.wms.oms.mapper.PurchaseOrderItemMapper;
import com.wms.oms.domain.PurchaseOrderItem;
import com.wms.oms.service.IPurchaseOrderItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 采购订单明细Service业务层处理
 *
 * @author zzm
 * @date 2021-05-16
 */
@Service
public class PurchaseOrderItemServiceImpl implements IPurchaseOrderItemService
{
    @Autowired
    private PurchaseOrderItemMapper purchaseOrderItemMapper;

    /**
     * 查询采购订单明细
     *
     * @param id 采购订单明细ID
     * @return 采购订单明细
     */
    @Override
    public PurchaseOrderItem selectPurchaseOrderItemById(Long id)
    {
        return purchaseOrderItemMapper.selectById(id);
    }

    /**
     * 查询采购订单明细列表
     *
     * @param purchaseOrderItem 采购订单明细
     * @return 采购订单明细
     */
    @Override
    public List<PurchaseOrderItem> selectPurchaseOrderItemList(PurchaseOrderItem purchaseOrderItem)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        return purchaseOrderItemMapper.selectList(queryWrapper);
    }

    /**
     * 新增采购订单明细
     *
     * @param purchaseOrderItem 采购订单明细
     * @return 结果
     */
    @Override
    public int insertPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem)
    {
        purchaseOrderItem.setDelFlag(false);
        purchaseOrderItem.setCreateBy(SecurityUtils.getUsername());
        purchaseOrderItem.setCreateTime(DateUtils.getNowDate());
        return purchaseOrderItemMapper.insert(purchaseOrderItem);
    }

    /**
     * 修改采购订单明细
     *
     * @param purchaseOrderItem 采购订单明细
     * @return 结果
     */
    @Override
    public int updatePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem)
    {
        purchaseOrderItem.setUpdateBy(SecurityUtils.getUsername());
        purchaseOrderItem.setUpdateTime(DateUtils.getNowDate());
        return purchaseOrderItemMapper.updateById(purchaseOrderItem);
    }

    /**
     * 批量删除采购订单明细
     *
     * @param ids 需要删除的采购订单明细ID
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderItemByIds(Long[] ids)
    {
        PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
        purchaseOrderItem.setDelFlag(Boolean.TRUE);
        purchaseOrderItem.setUpdateTime(DateUtils.getNowDate());
        purchaseOrderItem.setUpdateBy(SecurityUtils.getUsername());
        QueryWrapper<PurchaseOrderItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",Arrays.asList(ids));
        return purchaseOrderItemMapper.update(purchaseOrderItem, queryWrapper);
    }

    /**
     * 删除采购订单明细信息
     *
     * @param id 采购订单明细ID
     * @return 结果
     */
    @Override
    public int deletePurchaseOrderItemById(Long id)
    {
        return purchaseOrderItemMapper.deleteById(id);
    }
}