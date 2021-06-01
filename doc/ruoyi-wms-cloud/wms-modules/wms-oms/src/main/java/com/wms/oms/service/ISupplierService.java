package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.Supplier;

/**
 * 供应商信息Service接口
 *
 * @author zzm
 * @date 2021-05-10
 */
public interface ISupplierService
{
    /**
     * 查询供应商信息
     *
     * @param id 供应商信息ID
     * @return 供应商信息
     */
    Supplier selectSupplierById(Long id);

    /**
     * 查询供应商信息列表
     *
     * @param supplier 供应商信息
     * @return 供应商信息集合
     */
    List<Supplier> selectSupplierList(Supplier supplier);

    /**
     * 新增供应商信息
     *
     * @param supplier 供应商信息
     * @return 结果
     */
    int insertSupplier(Supplier supplier);

    /**
     * 修改供应商信息
     *
     * @param supplier 供应商信息
     * @return 结果
     */
    int updateSupplier(Supplier supplier);

    /**
     * 批量删除供应商信息
     *
     * @param ids 需要删除的供应商信息ID
     * @return 结果
     */
    int deleteSupplierByIds(Long[] ids);

    /**
     * 删除供应商信息信息
     *
     * @param id 供应商信息ID
     * @return 结果
     */
    int deleteSupplierById(Long id);
}