package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.common.core.utils.SecurityUtils;
import com.wms.oms.mapper.InventoryLogMapper;
import com.wms.oms.domain.InventoryLog;
import com.wms.oms.service.IInventoryLogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 库存操作日志Service业务层处理
 *
 * @author zzm
 * @date 2021-05-16
 */
@Service
public class InventoryLogServiceImpl implements IInventoryLogService
{
    @Autowired
    private InventoryLogMapper inventoryLogMapper;

    /**
     * 查询库存操作日志
     *
     * @param id 库存操作日志ID
     * @return 库存操作日志
     */
    @Override
    public InventoryLog selectInventoryLogById(Long id)
    {
        return inventoryLogMapper.selectById(id);
    }

    /**
     * 查询库存操作日志列表
     *
     * @param inventoryLog 库存操作日志
     * @return 库存操作日志
     */
    @Override
    public List<InventoryLog> selectInventoryLogList(InventoryLog inventoryLog)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        return inventoryLogMapper.selectList(queryWrapper);
    }

    /**
     * 新增库存操作日志
     *
     * @param inventoryLog 库存操作日志
     * @return 结果
     */
    @Override
    public int insertInventoryLog(InventoryLog inventoryLog)
    {
        inventoryLog.setDelFlag(false);
        inventoryLog.setCreateBy(SecurityUtils.getUsername());
        inventoryLog.setCreateTime(DateUtils.getNowDate());
        return inventoryLogMapper.insert(inventoryLog);
    }

    /**
     * 修改库存操作日志
     *
     * @param inventoryLog 库存操作日志
     * @return 结果
     */
    @Override
    public int updateInventoryLog(InventoryLog inventoryLog)
    {
        inventoryLog.setUpdateBy(SecurityUtils.getUsername());
        inventoryLog.setUpdateTime(DateUtils.getNowDate());
        return inventoryLogMapper.updateById(inventoryLog);
    }

    /**
     * 批量删除库存操作日志
     *
     * @param ids 需要删除的库存操作日志ID
     * @return 结果
     */
    @Override
    public int deleteInventoryLogByIds(Long[] ids)
    {
        InventoryLog inventoryLog = new InventoryLog();
        inventoryLog.setDelFlag(Boolean.TRUE);
        inventoryLog.setUpdateTime(DateUtils.getNowDate());
        inventoryLog.setUpdateBy(SecurityUtils.getUsername());
        QueryWrapper<InventoryLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",Arrays.asList(ids));
        return inventoryLogMapper.update(inventoryLog, queryWrapper);
    }

    /**
     * 删除库存操作日志信息
     *
     * @param id 库存操作日志ID
     * @return 结果
     */
    @Override
    public int deleteInventoryLogById(Long id)
    {
        return inventoryLogMapper.deleteById(id);
    }
}