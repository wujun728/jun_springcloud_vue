package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.common.core.utils.SecurityUtils;
import com.wms.oms.mapper.InventoryMapper;
import com.wms.oms.domain.Inventory;
import com.wms.oms.service.IInventoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 库存信息Service业务层处理
 *
 * @author zzm
 * @date 2021-05-16
 */
@Service
public class InventoryServiceImpl implements IInventoryService
{
    @Autowired
    private InventoryMapper inventoryMapper;

    /**
     * 查询库存信息
     *
     * @param id 库存信息ID
     * @return 库存信息
     */
    @Override
    public Inventory selectInventoryById(Long id)
    {
        return inventoryMapper.selectById(id);
    }

    /**
     * 查询库存信息列表
     *
     * @param inventory 库存信息
     * @return 库存信息
     */
    @Override
    public List<Inventory> selectInventoryList(Inventory inventory)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        return inventoryMapper.selectList(queryWrapper);
    }

    /**
     * 新增库存信息
     *
     * @param inventory 库存信息
     * @return 结果
     */
    @Override
    public int insertInventory(Inventory inventory)
    {
        inventory.setDelFlag(false);
        inventory.setCreateBy(SecurityUtils.getUsername());
        inventory.setCreateTime(DateUtils.getNowDate());
        return inventoryMapper.insert(inventory);
    }

    /**
     * 修改库存信息
     *
     * @param inventory 库存信息
     * @return 结果
     */
    @Override
    public int updateInventory(Inventory inventory)
    {
        inventory.setUpdateBy(SecurityUtils.getUsername());
        inventory.setUpdateTime(DateUtils.getNowDate());
        return inventoryMapper.updateById(inventory);
    }

    /**
     * 批量删除库存信息
     *
     * @param ids 需要删除的库存信息ID
     * @return 结果
     */
    @Override
    public int deleteInventoryByIds(Long[] ids)
    {
        Inventory inventory = new Inventory();
        inventory.setDelFlag(Boolean.TRUE);
        inventory.setUpdateTime(DateUtils.getNowDate());
        inventory.setUpdateBy(SecurityUtils.getUsername());
        QueryWrapper<Inventory> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",Arrays.asList(ids));
        return inventoryMapper.update(inventory, queryWrapper);
    }

    /**
     * 删除库存信息信息
     *
     * @param id 库存信息ID
     * @return 结果
     */
    @Override
    public int deleteInventoryById(Long id)
    {
        return inventoryMapper.deleteById(id);
    }
}