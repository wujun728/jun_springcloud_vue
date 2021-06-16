package com.zebra.bussiness.cms.service;

import com.zebra.bussiness.cms.domain.CmsMaterialGroup;
import com.zebra.common.core.domain.Ztree;

import java.util.List;

/**
 * 素材组别Service接口
 * 
 * @author zebra
 * @date 2020-06-24
 */
public interface ICmsMaterialGroupService {
    /**
     * 查询素材组别
     * 
     * @param groupId 素材组别ID
     * @return 素材组别
     */
    public CmsMaterialGroup selectCmsMaterialGroupById(String groupId);

    /**
     * 查询素材组别列表
     * 
     * @param cmsMaterialGroup 素材组别
     * @return 素材组别集合
     */
    public List<CmsMaterialGroup> selectCmsMaterialGroupList(CmsMaterialGroup cmsMaterialGroup);

    /**
     * 新增素材组别
     * 
     * @param cmsMaterialGroup 素材组别
     * @return 结果
     */
    public int insertCmsMaterialGroup(CmsMaterialGroup cmsMaterialGroup);

    /**
     * 修改素材组别
     * 
     * @param cmsMaterialGroup 素材组别
     * @return 结果
     */
    public int updateCmsMaterialGroup(CmsMaterialGroup cmsMaterialGroup);

    /**
     * 批量删除素材组别
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsMaterialGroupByIds(String ids);

    /**
     * 删除素材组别信息
     * 
     * @param groupId 素材组别ID
     * @return 结果
     */
    public int deleteCmsMaterialGroupById(String groupId);

    /**
     * 查询素材分组树列表
     *
     * @return 所有素材分组信息
     */
    public List<Ztree> selectMaterialGroupTree();
}
