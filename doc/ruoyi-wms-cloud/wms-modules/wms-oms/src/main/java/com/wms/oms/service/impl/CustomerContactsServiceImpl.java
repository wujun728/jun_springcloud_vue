package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.oms.mapper.CustomerContactsMapper;
import com.wms.oms.domain.CustomerContacts;
import com.wms.oms.service.ICustomerContactsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 客户联系人信息Service业务层处理
 *
 * @author zzm
 * @date 2021-05-08
 */
@Service
public class CustomerContactsServiceImpl implements ICustomerContactsService
{
    @Autowired
    private CustomerContactsMapper customerContactsMapper;

    /**
     * 查询客户联系人信息
     *
     * @param id 客户联系人信息ID
     * @return 客户联系人信息
     */
    @Override
    public CustomerContacts selectCustomerContactsById(Long id)
    {
        return customerContactsMapper.selectById(id);
    }

    /**
     * 查询客户联系人信息列表
     *
     * @param customerContacts 客户联系人信息
     * @return 客户联系人信息
     */
    @Override
    public List<CustomerContacts> selectCustomerContactsList(CustomerContacts customerContacts)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        return customerContactsMapper.selectList(queryWrapper);
    }

    /**
     * 新增客户联系人信息
     *
     * @param customerContacts 客户联系人信息
     * @return 结果
     */
    @Override
    public int insertCustomerContacts(CustomerContacts customerContacts)
    {
        customerContacts.setCreateTime(DateUtils.getNowDate());
        return customerContactsMapper.insert(customerContacts);
    }

    /**
     * 修改客户联系人信息
     *
     * @param customerContacts 客户联系人信息
     * @return 结果
     */
    @Override
    public int updateCustomerContacts(CustomerContacts customerContacts)
    {
        customerContacts.setUpdateTime(DateUtils.getNowDate());
        return customerContactsMapper.updateById(customerContacts);
    }

    /**
     * 批量删除客户联系人信息
     *
     * @param ids 需要删除的客户联系人信息ID
     * @return 结果
     */
    @Override
    public int deleteCustomerContactsByIds(Long[] ids)
    {
        return customerContactsMapper.deleteBatchIds(Arrays.asList(ids));
    }

    /**
     * 删除客户联系人信息信息
     *
     * @param id 客户联系人信息ID
     * @return 结果
     */
    @Override
    public int deleteCustomerContactsById(Long id)
    {
        return customerContactsMapper.deleteById(id);
    }
}