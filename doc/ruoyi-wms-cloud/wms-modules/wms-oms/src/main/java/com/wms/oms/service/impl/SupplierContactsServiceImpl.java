package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.oms.mapper.SupplierContactsMapper;
import com.wms.oms.domain.SupplierContacts;
import com.wms.oms.service.ISupplierContactsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * 供应商联系人信息Service业务层处理
 *
 * @author zzm
 * @date 2021-05-10
 */
@Service
public class SupplierContactsServiceImpl implements ISupplierContactsService
{
    @Autowired
    private SupplierContactsMapper supplierContactsMapper;

    /**
     * 查询供应商联系人信息
     *
     * @param id 供应商联系人信息ID
     * @return 供应商联系人信息
     */
    @Override
    public SupplierContacts selectSupplierContactsById(Long id)
    {
        return supplierContactsMapper.selectById(id);
    }

    /**
     * 查询供应商联系人信息列表
     *
     * @param supplierContacts 供应商联系人信息
     * @return 供应商联系人信息
     */
    @Override
    public List<SupplierContacts> selectSupplierContactsList(SupplierContacts supplierContacts)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        return supplierContactsMapper.selectList(queryWrapper);
    }

    /**
     * 新增供应商联系人信息
     *
     * @param supplierContacts 供应商联系人信息
     * @return 结果
     */
    @Override
    public int insertSupplierContacts(SupplierContacts supplierContacts)
    {
        supplierContacts.setCreateTime(DateUtils.getNowDate());
        return supplierContactsMapper.insert(supplierContacts);
    }

    /**
     * 修改供应商联系人信息
     *
     * @param supplierContacts 供应商联系人信息
     * @return 结果
     */
    @Override
    public int updateSupplierContacts(SupplierContacts supplierContacts)
    {
        supplierContacts.setUpdateTime(DateUtils.getNowDate());
        return supplierContactsMapper.updateById(supplierContacts);
    }

    /**
     * 批量删除供应商联系人信息
     *
     * @param ids 需要删除的供应商联系人信息ID
     * @return 结果
     */
    @Override
    public int deleteSupplierContactsByIds(Long[] ids)
    {
        return supplierContactsMapper.deleteBatchIds(Arrays.asList(ids));
    }

    /**
     * 删除供应商联系人信息信息
     *
     * @param id 供应商联系人信息ID
     * @return 结果
     */
    @Override
    public int deleteSupplierContactsById(Long id)
    {
        return supplierContactsMapper.deleteById(id);
    }
}