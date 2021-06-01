package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.common.core.utils.SecurityUtils;
import com.wms.oms.mapper.SaleOrderItemMapper;
import com.wms.oms.domain.SaleOrderItem;
import com.wms.oms.service.ISaleOrderItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 销售订单明细Service业务层处理
 *
 * @author zzm
 * @date 2021-05-16
 */
@Service
public class SaleOrderItemServiceImpl implements ISaleOrderItemService
{
    @Autowired
    private SaleOrderItemMapper saleOrderItemMapper;

    /**
     * 查询销售订单明细
     *
     * @param id 销售订单明细ID
     * @return 销售订单明细
     */
    @Override
    public SaleOrderItem selectSaleOrderItemById(Long id)
    {
        return saleOrderItemMapper.selectById(id);
    }

    /**
     * 查询销售订单明细列表
     *
     * @param saleOrderItem 销售订单明细
     * @return 销售订单明细
     */
    @Override
    public List<SaleOrderItem> selectSaleOrderItemList(SaleOrderItem saleOrderItem)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        return saleOrderItemMapper.selectList(queryWrapper);
    }

    /**
     * 新增销售订单明细
     *
     * @param saleOrderItem 销售订单明细
     * @return 结果
     */
    @Override
    public int insertSaleOrderItem(SaleOrderItem saleOrderItem)
    {
        saleOrderItem.setDelFlag(false);
        saleOrderItem.setCreateBy(SecurityUtils.getUsername());
        saleOrderItem.setCreateTime(DateUtils.getNowDate());
        return saleOrderItemMapper.insert(saleOrderItem);
    }

    /**
     * 修改销售订单明细
     *
     * @param saleOrderItem 销售订单明细
     * @return 结果
     */
    @Override
    public int updateSaleOrderItem(SaleOrderItem saleOrderItem)
    {
        saleOrderItem.setUpdateBy(SecurityUtils.getUsername());
        saleOrderItem.setUpdateTime(DateUtils.getNowDate());
        return saleOrderItemMapper.updateById(saleOrderItem);
    }

    /**
     * 批量删除销售订单明细
     *
     * @param ids 需要删除的销售订单明细ID
     * @return 结果
     */
    @Override
    public int deleteSaleOrderItemByIds(Long[] ids)
    {
        SaleOrderItem saleOrderItem = new SaleOrderItem();
        saleOrderItem.setDelFlag(Boolean.TRUE);
        saleOrderItem.setUpdateTime(DateUtils.getNowDate());
        saleOrderItem.setUpdateBy(SecurityUtils.getUsername());
        QueryWrapper<SaleOrderItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",Arrays.asList(ids));
        return saleOrderItemMapper.update(saleOrderItem, queryWrapper);
    }

    /**
     * 删除销售订单明细信息
     *
     * @param id 销售订单明细ID
     * @return 结果
     */
    @Override
    public int deleteSaleOrderItemById(Long id)
    {
        return saleOrderItemMapper.deleteById(id);
    }
}