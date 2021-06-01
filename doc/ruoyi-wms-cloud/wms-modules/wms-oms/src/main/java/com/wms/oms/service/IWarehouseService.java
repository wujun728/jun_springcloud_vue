package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.Warehouse;

/**
 * 仓库信息Service接口
 *
 * @author zzm
 * @date 2021-05-14
 */
public interface IWarehouseService
{
    /**
     * 查询仓库信息
     *
     * @param id 仓库信息ID
     * @return 仓库信息
     */
    Warehouse selectWarehouseById(Long id);

    /**
     * 查询仓库信息列表
     *
     * @param warehouse 仓库信息
     * @return 仓库信息集合
     */
    List<Warehouse> selectWarehouseList(Warehouse warehouse);

    /**
     * 新增仓库信息
     *
     * @param warehouse 仓库信息
     * @return 结果
     */
    int insertWarehouse(Warehouse warehouse);

    /**
     * 修改仓库信息
     *
     * @param warehouse 仓库信息
     * @return 结果
     */
    int updateWarehouse(Warehouse warehouse);

    /**
     * 批量删除仓库信息
     *
     * @param ids 需要删除的仓库信息ID
     * @return 结果
     */
    int deleteWarehouseByIds(Long[] ids);

    /**
     * 删除仓库信息信息
     *
     * @param id 仓库信息ID
     * @return 结果
     */
    int deleteWarehouseById(Long id);
}