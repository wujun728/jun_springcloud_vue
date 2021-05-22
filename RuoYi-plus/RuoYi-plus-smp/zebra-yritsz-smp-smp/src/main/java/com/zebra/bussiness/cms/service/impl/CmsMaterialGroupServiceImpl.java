package com.zebra.bussiness.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zebra.common.core.domain.Ztree;
import com.zebra.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.cms.mapper.CmsMaterialGroupMapper;
import com.zebra.bussiness.cms.domain.CmsMaterialGroup;
import com.zebra.bussiness.cms.service.ICmsMaterialGroupService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 素材组别Service业务层处理
 * 
 * @author zebra
 * @date 2020-06-24
 */
@Service
public class CmsMaterialGroupServiceImpl implements ICmsMaterialGroupService {
    @Autowired
    private CmsMaterialGroupMapper cmsMaterialGroupMapper;

    /**
     * 查询素材组别
     * 
     * @param groupId 素材组别ID
     * @return 素材组别
     */
    @Override
    public CmsMaterialGroup selectCmsMaterialGroupById(String groupId)
    {
        return cmsMaterialGroupMapper.selectCmsMaterialGroupById(groupId);
    }

    /**
     * 查询素材组别列表
     * 
     * @param cmsMaterialGroup 素材组别
     * @return 素材组别
     */
    @Override
    public List<CmsMaterialGroup> selectCmsMaterialGroupList(CmsMaterialGroup cmsMaterialGroup)
    {
        return cmsMaterialGroupMapper.selectCmsMaterialGroupList(cmsMaterialGroup);
    }

    /**
     * 新增素材组别
     * 
     * @param cmsMaterialGroup 素材组别
     * @return 结果
     */
    @Override
    public int insertCmsMaterialGroup(CmsMaterialGroup cmsMaterialGroup)
    {
        cmsMaterialGroup.setUpdateBy(ShiroUtils.getLoginName());
        cmsMaterialGroup.setCreateTime(DateUtils.getNowDate());
        cmsMaterialGroup.setUpdateTime(DateUtils.getNowDate());
        return cmsMaterialGroupMapper.insertCmsMaterialGroup(cmsMaterialGroup);
    }

    /**
     * 修改素材组别
     * 
     * @param cmsMaterialGroup 素材组别
     * @return 结果
     */
    @Override
    public int updateCmsMaterialGroup(CmsMaterialGroup cmsMaterialGroup)
    {
        cmsMaterialGroup.setUpdateBy(ShiroUtils.getLoginName());
        cmsMaterialGroup.setUpdateTime(DateUtils.getNowDate());
        return cmsMaterialGroupMapper.updateCmsMaterialGroup(cmsMaterialGroup);
    }

    /**
     * 删除素材组别对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsMaterialGroupByIds(String ids)
    {
        return cmsMaterialGroupMapper.deleteCmsMaterialGroupByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除素材组别信息
     * 
     * @param groupId 素材组别ID
     * @return 结果
     */
    @Override
    public int deleteCmsMaterialGroupById(String groupId)
    {
        return cmsMaterialGroupMapper.deleteCmsMaterialGroupById(groupId);
    }

    /**
     * 查询素材分组树列表
     *
     * @return 所有素材分组信息
     */
    @Override
    public List<Ztree> selectMaterialGroupTree() {
        List<CmsMaterialGroup> materialGroupList = cmsMaterialGroupMapper.selectAll();
        List<Ztree> ztrees=  new ArrayList<Ztree>();
        for (CmsMaterialGroup materialGroup : materialGroupList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(materialGroup.getGroupId());
            ztree.setpId(materialGroup.getGroupParentId());
            ztree.setName(materialGroup.getGroupName());
            ztree.setTitle(materialGroup.getGroupName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
