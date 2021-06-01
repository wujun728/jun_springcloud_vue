package com.wms.system.service;

import java.util.List;
import com.wms.system.domain.SysTenant;

/**
 * 租户管理Service接口
 *
 * @author zzm
 * @date 2021-05-06
 */
public interface ISysTenantService
{
    /**
     * 查询租户管理
     *
     * @param id 租户管理ID
     * @return 租户管理
     */
    SysTenant selectSysTenantById(Long id);

    /**
     * 查询租户管理列表
     *
     * @param sysTenant 租户管理
     * @return 租户管理集合
     */
    List<SysTenant> selectSysTenantList(SysTenant sysTenant);

    /**
     * 新增租户管理
     *
     * @param sysTenant 租户管理
     * @return 结果
     */
    int insertSysTenant(SysTenant sysTenant);

    /**
     * 修改租户管理
     *
     * @param sysTenant 租户管理
     * @return 结果
     */
    int updateSysTenant(SysTenant sysTenant);

    /**
     * 批量删除租户管理
     *
     * @param ids 需要删除的租户管理ID
     * @return 结果
     */
    int deleteSysTenantByIds(Long[] ids);

    /**
     * 删除租户管理信息
     *
     * @param id 租户管理ID
     * @return 结果
     */
    int deleteSysTenantById(Long id);
}