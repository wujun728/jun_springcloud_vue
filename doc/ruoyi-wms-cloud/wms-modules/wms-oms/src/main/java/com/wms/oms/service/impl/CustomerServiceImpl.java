package com.wms.oms.service.impl;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wms.common.core.utils.DateUtils;
import com.wms.common.core.utils.SecurityUtils;
import com.wms.common.core.utils.StringUtils;
import com.wms.oms.domain.Customer;
import com.wms.oms.domain.CustomerContacts;
import com.wms.oms.mapper.CustomerContactsMapper;
import com.wms.oms.mapper.CustomerMapper;
import com.wms.oms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 客户信息Service业务层处理
 *
 * @author zzm
 * @date 2021-05-08
 */
@Service
public class CustomerServiceImpl implements ICustomerService
{
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerContactsMapper customerContactsMapper;

    /**
     * 查询客户信息
     *
     * @param id 客户信息ID
     * @return 客户信息
     */
    @Override
    public Customer selectCustomerById(Long id)
    {
        return customerMapper.selectById(id);
    }

    /**
     * 查询客户信息列表
     *
     * @param customer 客户信息
     * @return 客户信息
     */
    @Override
    public List<Customer> selectCustomerList(Customer customer)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(StringUtils.isNotEmpty(customer.getCustomerName())){
            queryWrapper.like("customer_name", customer.getCustomerName());
        }
        queryWrapper.eq("del_flag", Boolean.FALSE);
        return customerMapper.selectList(queryWrapper);
    }

    /**
     * 新增客户信息
     *
     * @param customer 客户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertCustomer(Customer customer)
    {
        customer.setSn("CT"+DateUtils.getNowDate().getTime());
        customer.setCreateBy(SecurityUtils.getUsername());
        customer.setCreateTime(DateUtils.getNowDate());
        customer.setDelFlag(Boolean.FALSE);
        int result = customerMapper.insert(customer);
        List<CustomerContacts> customerContactsList = customer.getCustomerContactsList();
        for(CustomerContacts customerContacts : customerContactsList){
            customerContacts.setCustomerId(customer.getId());
            customerContacts.setCreateBy(customer.getCreateBy());
            customerContacts.setCreateTime(customer.getCreateTime());
            customerContacts.setDelFlag(Boolean.FALSE);
            customerContactsMapper.insert(customerContacts);
        }
        return result;
    }

    /**
     * 修改客户信息
     *
     * @param customer 客户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateCustomer(Customer customer)
    {
        customer.setUpdateBy(SecurityUtils.getUsername());
        customer.setUpdateTime(DateUtils.getNowDate());
        for (CustomerContacts customerContacts : customer.getCustomerContactsList()) {
            if (customerContacts.getId() != null) {
                customerContacts.setUpdateTime(customer.getUpdateTime());
                customerContacts.setUpdateBy(customerContacts.getUpdateBy());
                customerContactsMapper.updateById(customerContacts);
            }else{
                customerContacts.setCustomerId(customer.getId());
                customerContacts.setCreateBy(customerContacts.getUpdateBy());
                customerContacts.setCreateTime(customer.getUpdateTime());
                customerContacts.setDelFlag(Boolean.FALSE);
                customerContactsMapper.insert(customerContacts);
            }
        }
        return customerMapper.updateById(customer);
    }

    /**
     * 批量删除客户信息
     *
     * @param ids 需要删除的客户信息ID
     * @return 结果
     */
    @Override
    public int deleteCustomerByIds(Long[] ids)
    {
        Customer customer = new Customer();
        customer.setDelFlag(Boolean.TRUE);
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id",Arrays.asList(ids));
        return customerMapper.update(customer, queryWrapper);
    }

    /**
     * 删除客户信息信息
     *
     * @param id 客户信息ID
     * @return 结果
     */
    @Override
    public int deleteCustomerById(Long id)
    {
        return customerMapper.deleteById(id);
    }
}