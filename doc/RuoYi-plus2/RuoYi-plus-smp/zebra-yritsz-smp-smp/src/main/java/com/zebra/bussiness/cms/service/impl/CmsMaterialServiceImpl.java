package com.zebra.bussiness.cms.service.impl;

import java.util.List;
import com.zebra.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.cms.mapper.CmsMaterialMapper;
import com.zebra.bussiness.cms.domain.CmsMaterial;
import com.zebra.bussiness.cms.service.ICmsMaterialService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 素材信息Service业务层处理
 * 
 * @author zebra
 * @date 2020-06-24
 */
@Service
public class CmsMaterialServiceImpl implements ICmsMaterialService {
    @Autowired
    private CmsMaterialMapper cmsMaterialMapper;

    /**
     * 查询素材信息
     * 
     * @param materialId 素材信息ID
     * @return 素材信息
     */
    @Override
    public CmsMaterial selectCmsMaterialById(String materialId)
    {
        return cmsMaterialMapper.selectCmsMaterialById(materialId);
    }

    /**
     * 查询素材信息列表
     * 
     * @param cmsMaterial 素材信息
     * @return 素材信息
     */
    @Override
    public List<CmsMaterial> selectCmsMaterialList(CmsMaterial cmsMaterial)
    {
        return cmsMaterialMapper.selectCmsMaterialList(cmsMaterial);
    }

    /**
     * 新增素材信息
     * 
     * @param cmsMaterial 素材信息
     * @return 结果
     */
    @Override
    public int insertCmsMaterial(CmsMaterial cmsMaterial)
    {
        cmsMaterial.setUpdateBy(ShiroUtils.getLoginName());
        cmsMaterial.setCreateTime(DateUtils.getNowDate());
        cmsMaterial.setUpdateTime(DateUtils.getNowDate());
        return cmsMaterialMapper.insertCmsMaterial(cmsMaterial);
    }

    /**
     * 修改素材信息
     * 
     * @param cmsMaterial 素材信息
     * @return 结果
     */
    @Override
    public int updateCmsMaterial(CmsMaterial cmsMaterial)
    {
        cmsMaterial.setUpdateBy(ShiroUtils.getLoginName());
        cmsMaterial.setUpdateTime(DateUtils.getNowDate());
        return cmsMaterialMapper.updateCmsMaterial(cmsMaterial);
    }

    /**
     * 删除素材信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCmsMaterialByIds(String ids)
    {
        return cmsMaterialMapper.deleteCmsMaterialByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除素材信息信息
     * 
     * @param materialId 素材信息ID
     * @return 结果
     */
    @Override
    public int deleteCmsMaterialById(String materialId)
    {
        return cmsMaterialMapper.deleteCmsMaterialById(materialId);
    }
}
