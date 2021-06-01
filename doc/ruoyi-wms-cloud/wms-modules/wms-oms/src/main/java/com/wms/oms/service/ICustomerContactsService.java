package com.wms.oms.service;

import java.util.List;
import com.wms.oms.domain.CustomerContacts;

/**
 * 客户联系人信息Service接口
 *
 * @author zzm
 * @date 2021-05-08
 */
public interface ICustomerContactsService
{
    /**
     * 查询客户联系人信息
     *
     * @param id 客户联系人信息ID
     * @return 客户联系人信息
     */
    CustomerContacts selectCustomerContactsById(Long id);

    /**
     * 查询客户联系人信息列表
     *
     * @param customerContacts 客户联系人信息
     * @return 客户联系人信息集合
     */
    List<CustomerContacts> selectCustomerContactsList(CustomerContacts customerContacts);

    /**
     * 新增客户联系人信息
     *
     * @param customerContacts 客户联系人信息
     * @return 结果
     */
    int insertCustomerContacts(CustomerContacts customerContacts);

    /**
     * 修改客户联系人信息
     *
     * @param customerContacts 客户联系人信息
     * @return 结果
     */
    int updateCustomerContacts(CustomerContacts customerContacts);

    /**
     * 批量删除客户联系人信息
     *
     * @param ids 需要删除的客户联系人信息ID
     * @return 结果
     */
    int deleteCustomerContactsByIds(Long[] ids);

    /**
     * 删除客户联系人信息信息
     *
     * @param id 客户联系人信息ID
     * @return 结果
     */
    int deleteCustomerContactsById(Long id);
}