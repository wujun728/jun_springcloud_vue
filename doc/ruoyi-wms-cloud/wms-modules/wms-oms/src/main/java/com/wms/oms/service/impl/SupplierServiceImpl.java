package com.wms.oms.service.impl;

import java.util.List;
import java.util.Arrays;
import com.wms.common.core.utils.DateUtils;
import com.wms.common.core.utils.SecurityUtils;
import com.wms.common.core.utils.StringUtils;
import com.wms.oms.domain.SupplierContacts;
import com.wms.oms.mapper.SupplierContactsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.oms.mapper.SupplierMapper;
import com.wms.oms.domain.Supplier;
import com.wms.oms.service.ISupplierService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 供应商信息Service业务层处理
 *
 * @author zzm
 * @date 2021-05-10
 */
@Service
public class SupplierServiceImpl implements ISupplierService
{
    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private SupplierContactsMapper supplierContactsMapper;

    /**
     * 查询供应商信息
     *
     * @param id 供应商信息ID
     * @return 供应商信息
     */
    @Override
    public Supplier selectSupplierById(Long id)
    {
        return supplierMapper.selectById(id);
    }

    /**
     * 查询供应商信息列表
     *
     * @param supplier 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<Supplier> selectSupplierList(Supplier supplier)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StringUtils.isNotEmpty(supplier.getSn())) {
            queryWrapper.eq("sn", supplier.getSn());
        }
        if (StringUtils.isNotEmpty(supplier.getSupplierName())) {
            queryWrapper.like("supplier_name", supplier.getSupplierName());
        }
        queryWrapper.eq("del_flag", false);
        return supplierMapper.selectList(queryWrapper);
    }

    /**
     * 新增供应商信息
     *
     * @param supplier 供应商信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSupplier(Supplier supplier)
    {
        supplier.setSn("ST"+DateUtils.getNowDate().getTime());
        supplier.setCreateBy(SecurityUtils.getUsername());
        supplier.setDelFlag(Boolean.FALSE);
        supplier.setCreateTime(DateUtils.getNowDate());
        int result = supplierMapper.insert(supplier);
        List<SupplierContacts> supplierContactsList = supplier.getSupplierContactsList();
        for(SupplierContacts supplierContacts : supplierContactsList){
            supplierContacts.setSupplierId(supplier.getId());
            supplierContacts.setCreateBy(supplier.getCreateBy());
            supplierContacts.setDelFlag(Boolean.FALSE);
            supplierContacts.setCreateTime(supplier.getCreateTime());
            supplierContactsMapper.insert(supplierContacts);
        }
        return result;
    }

    /**
     * 修改供应商信息
     *
     * @param supplier 供应商信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSupplier(Supplier supplier)
    {
        supplier.setUpdateTime(DateUtils.getNowDate());
        supplier.setUpdateBy(SecurityUtils.getUsername());
        for (SupplierContacts supplierContacts : supplier.getSupplierContactsList()) {
            if (supplierContacts.getId() != null) {
                supplierContacts.setUpdateBy(supplier.getUpdateBy());
                supplierContacts.setUpdateTime(supplier.getUpdateTime());
                supplierContactsMapper.updateById(supplierContacts);
            } else {
                supplierContacts.setSupplierId(supplier.getId());
                supplierContacts.setCreateTime(supplier.getUpdateTime());
                supplierContacts.setCreateBy(supplier.getUpdateBy());
                supplierContacts.setDelFlag(Boolean.FALSE);
                supplierContactsMapper.insert(supplierContacts);
            }
        }
        return supplierMapper.updateById(supplier);
    }

    /**
     * 批量删除供应商信息
     *
     * @param ids 需要删除的供应商信息ID
     * @return 结果
     */
    @Override
    public int deleteSupplierByIds(Long[] ids)
    {
        Supplier supplier = new Supplier();
        supplier.setDelFlag(Boolean.TRUE);
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", Arrays.asList(ids));
        return supplierMapper.update(supplier, queryWrapper);
    }

    /**
     * 删除供应商信息信息
     *
     * @param id 供应商信息ID
     * @return 结果
     */
    @Override
    public int deleteSupplierById(Long id)
    {
        return supplierMapper.deleteById(id);
    }
}