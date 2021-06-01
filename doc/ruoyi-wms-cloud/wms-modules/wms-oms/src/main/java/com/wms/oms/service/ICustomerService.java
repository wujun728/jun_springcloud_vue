package com.wms.oms.service;

import com.wms.oms.domain.Customer;

import java.util.List;

/**
 * 客户信息Service接口
 *
 * @author zzm
 * @date 2021-05-08
 */
public interface ICustomerService
{
    /**
     * 查询客户信息
     *
     * @param id 客户信息ID
     * @return 客户信息
     */
    Customer selectCustomerById(Long id);

    /**
     * 查询客户信息列表
     *
     * @param customer 客户信息
     * @return 客户信息集合
     */
    List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增客户信息
     *
     * @param customer 客户信息
     * @return 结果
     */
    int insertCustomer(Customer customer);

    /**
     * 修改客户信息
     *
     * @param customer 客户信息
     * @return 结果
     */
    int updateCustomer(Customer customer);

    /**
     * 批量删除客户信息
     *
     * @param ids 需要删除的客户信息ID
     * @return 结果
     */
    int deleteCustomerByIds(Long[] ids);

    /**
     * 删除客户信息信息
     *
     * @param id 客户信息ID
     * @return 结果
     */
    int deleteCustomerById(Long id);
}