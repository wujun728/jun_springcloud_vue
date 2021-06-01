package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.InventoryLog;

/**
 * 库存操作日志Service接口
 *
 * @author zzm
 * @date 2021-05-16
 */
public interface IInventoryLogService
{
    /**
     * 查询库存操作日志
     *
     * @param id 库存操作日志ID
     * @return 库存操作日志
     */
    InventoryLog selectInventoryLogById(Long id);

    /**
     * 查询库存操作日志列表
     *
     * @param inventoryLog 库存操作日志
     * @return 库存操作日志集合
     */
    List<InventoryLog> selectInventoryLogList(InventoryLog inventoryLog);

    /**
     * 新增库存操作日志
     *
     * @param inventoryLog 库存操作日志
     * @return 结果
     */
    int insertInventoryLog(InventoryLog inventoryLog);

    /**
     * 修改库存操作日志
     *
     * @param inventoryLog 库存操作日志
     * @return 结果
     */
    int updateInventoryLog(InventoryLog inventoryLog);

    /**
     * 批量删除库存操作日志
     *
     * @param ids 需要删除的库存操作日志ID
     * @return 结果
     */
    int deleteInventoryLogByIds(Long[] ids);

    /**
     * 删除库存操作日志信息
     *
     * @param id 库存操作日志ID
     * @return 结果
     */
    int deleteInventoryLogById(Long id);
}