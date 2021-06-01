package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.SupplierContacts;

/**
 * 供应商联系人信息Service接口
 *
 * @author zzm
 * @date 2021-05-10
 */
public interface ISupplierContactsService
{
    /**
     * 查询供应商联系人信息
     *
     * @param id 供应商联系人信息ID
     * @return 供应商联系人信息
     */
    SupplierContacts selectSupplierContactsById(Long id);

    /**
     * 查询供应商联系人信息列表
     *
     * @param supplierContacts 供应商联系人信息
     * @return 供应商联系人信息集合
     */
    List<SupplierContacts> selectSupplierContactsList(SupplierContacts supplierContacts);

    /**
     * 新增供应商联系人信息
     *
     * @param supplierContacts 供应商联系人信息
     * @return 结果
     */
    int insertSupplierContacts(SupplierContacts supplierContacts);

    /**
     * 修改供应商联系人信息
     *
     * @param supplierContacts 供应商联系人信息
     * @return 结果
     */
    int updateSupplierContacts(SupplierContacts supplierContacts);

    /**
     * 批量删除供应商联系人信息
     *
     * @param ids 需要删除的供应商联系人信息ID
     * @return 结果
     */
    int deleteSupplierContactsByIds(Long[] ids);

    /**
     * 删除供应商联系人信息信息
     *
     * @param id 供应商联系人信息ID
     * @return 结果
     */
    int deleteSupplierContactsById(Long id);
}