package com.zebra.bussiness.cms.mapper;

import com.zebra.bussiness.cms.domain.CmsMaterialGroup;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 素材组别Mapper接口
 * 
 * @author zebra
 * @date 2020-06-24
 */
public interface CmsMaterialGroupMapper  extends Mapper<CmsMaterialGroup> {
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
     * 删除素材组别
     * 
     * @param groupId 素材组别ID
     * @return 结果
     */
    public int deleteCmsMaterialGroupById(String groupId);

    /**
     * 批量删除素材组别
     * 
     * @param groupIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsMaterialGroupByIds(String[] groupIds);
}
