package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import com.wms.common.core.utils.StringUtils;
import com.wms.oms.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.oms.mapper.WarehouseMapper;
import com.wms.oms.domain.Warehouse;
import com.wms.oms.service.IWarehouseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 仓库信息Service业务层处理
 *
 * @author zzm
 * @date 2021-05-14
 */
@Service
public class WarehouseServiceImpl implements IWarehouseService
{
    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 查询仓库信息
     *
     * @param id 仓库信息ID
     * @return 仓库信息
     */
    @Override
    public Warehouse selectWarehouseById(Long id)
    {
        return warehouseMapper.selectById(id);
    }

    /**
     * 查询仓库信息列表
     *
     * @param warehouse 仓库信息
     * @return 仓库信息
     */
    @Override
    public List<Warehouse> selectWarehouseList(Warehouse warehouse)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(StringUtils.isNotEmpty(warehouse.getSn())){
            queryWrapper.eq("sn", warehouse.getSn());
        }
        if(StringUtils.isNotEmpty(warehouse.getWarehouseName())){
            queryWrapper.like("warehouse_name", warehouse.getWarehouseName());
        }
        queryWrapper.eq("del_flag", false);
        return warehouseMapper.selectList(queryWrapper);
    }

    /**
     * 新增仓库信息
     *
     * @param warehouse 仓库信息
     * @return 结果
     */
    @Override
    public int insertWarehouse(Warehouse warehouse)
    {
        warehouse.setSn("WT"+DateUtils.getNowDate().getTime());
        warehouse.setDelFlag(Boolean.FALSE);
        warehouse.setCreateTime(DateUtils.getNowDate());
        return warehouseMapper.insert(warehouse);
    }

    /**
     * 修改仓库信息
     *
     * @param warehouse 仓库信息
     * @return 结果
     */
    @Override
    public int updateWarehouse(Warehouse warehouse)
    {
        warehouse.setUpdateTime(DateUtils.getNowDate());
        return warehouseMapper.updateById(warehouse);
    }

    /**
     * 批量删除仓库信息
     *
     * @param ids 需要删除的仓库信息ID
     * @return 结果
     */
    @Override
    public int deleteWarehouseByIds(Long[] ids)
    {
        Warehouse warehouse = new Warehouse();
        warehouse.setDelFlag(Boolean.TRUE);
        QueryWrapper<Warehouse> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", Arrays.asList(ids));
        return warehouseMapper.update(warehouse, queryWrapper);
    }

    /**
     * 删除仓库信息信息
     *
     * @param id 仓库信息ID
     * @return 结果
     */
    @Override
    public int deleteWarehouseById(Long id)
    {
        return warehouseMapper.deleteById(id);
    }
}