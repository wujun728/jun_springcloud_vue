package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.Inventory;

/**
 * 库存信息Service接口
 *
 * @author zzm
 * @date 2021-05-16
 */
public interface IInventoryService
{
    /**
     * 查询库存信息
     *
     * @param id 库存信息ID
     * @return 库存信息
     */
    Inventory selectInventoryById(Long id);

    /**
     * 查询库存信息列表
     *
     * @param inventory 库存信息
     * @return 库存信息集合
     */
    List<Inventory> selectInventoryList(Inventory inventory);

    /**
     * 新增库存信息
     *
     * @param inventory 库存信息
     * @return 结果
     */
    int insertInventory(Inventory inventory);

    /**
     * 修改库存信息
     *
     * @param inventory 库存信息
     * @return 结果
     */
    int updateInventory(Inventory inventory);

    /**
     * 批量删除库存信息
     *
     * @param ids 需要删除的库存信息ID
     * @return 结果
     */
    int deleteInventoryByIds(Long[] ids);

    /**
     * 删除库存信息信息
     *
     * @param id 库存信息ID
     * @return 结果
     */
    int deleteInventoryById(Long id);
}