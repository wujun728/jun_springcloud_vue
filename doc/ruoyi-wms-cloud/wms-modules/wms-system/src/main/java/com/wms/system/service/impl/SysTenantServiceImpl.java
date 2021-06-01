package com.wms.system.service.impl;

import java.util.List;
import java.util.Arrays;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wms.common.core.utils.DateUtils;
import com.wms.system.api.domain.SysUser;
import com.wms.system.mapper.SysRoleMapper;
import com.wms.system.mapper.SysUserMapper;
import com.wms.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wms.system.mapper.SysTenantMapper;
import com.wms.system.domain.SysTenant;
import com.wms.system.service.ISysTenantService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 租户管理Service业务层处理
 *
 * @author zzm
 * @date 2021-05-06
 */
@Service
public class SysTenantServiceImpl implements ISysTenantService
{
    @Autowired
    private SysTenantMapper sysTenantMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private ISysUserService sysUserService;


    /**
     * 查询租户管理
     *
     * @param id 租户管理ID
     * @return 租户管理
     */
    @Override
    public SysTenant selectSysTenantById(Long id)
    {
        return sysTenantMapper.selectById(id);
    }

    /**
     * 查询租户管理列表
     *
     * @param sysTenant 租户管理
     * @return 租户管理
     */
    @Override
    public List<SysTenant> selectSysTenantList(SysTenant sysTenant)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        return sysTenantMapper.selectList(queryWrapper);
    }

    /**
     * 新增租户管理
     *
     * @param sysTenant 租户管理
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSysTenant(SysTenant sysTenant)
    {
        sysTenant.setCreateTime(DateUtils.getNowDate());
        sysTenant.setDelFlag(false);
        int result = sysTenantMapper.insert(sysTenant);
        SysUser user = new SysUser();
        user.setNickName(sysTenant.getNickName());
        user.setPhonenumber(sysTenant.getPhone());
        user.setUserName(sysTenant.getPhone());
        user.setPassword(sysTenant.getPassword());
        user.setCreateBy(sysTenant.getCreateBy());
        user.setCreateTime(sysTenant.getCreateTime());
        user.setTenantId(sysTenant.getId());
        Long[] roleIds = {1l};
        user.setRoleIds(roleIds);
        sysUserService.insertUser(user);
        return result;
    }

    /**
     * 修改租户管理
     *
     * @param sysTenant 租户管理
     * @return 结果
     */
    @Override
    public int updateSysTenant(SysTenant sysTenant)
    {
        sysTenant.setUpdateTime(DateUtils.getNowDate());
        return sysTenantMapper.updateById(sysTenant);
    }

    /**
     * 批量删除租户管理
     *
     * @param ids 需要删除的租户管理ID
     * @return 结果
     */
    @Override
    public int deleteSysTenantByIds(Long[] ids)
    {
        return sysTenantMapper.deleteBatchIds(Arrays.asList(ids));
    }

    /**
     * 删除租户管理信息
     *
     * @param id 租户管理ID
     * @return 结果
     */
    @Override
    public int deleteSysTenantById(Long id)
    {
        return sysTenantMapper.deleteById(id);
    }
}
