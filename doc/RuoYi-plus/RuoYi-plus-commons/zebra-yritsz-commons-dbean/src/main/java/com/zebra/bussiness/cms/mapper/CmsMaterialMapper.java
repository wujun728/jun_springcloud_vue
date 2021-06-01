package com.zebra.bussiness.cms.mapper;

import com.zebra.bussiness.cms.domain.CmsMaterial;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 素材信息Mapper接口
 * 
 * @author zebra
 * @date 2020-06-24
 */
public interface CmsMaterialMapper  extends Mapper<CmsMaterial> {
    /**
     * 查询素材信息
     * 
     * @param materialId 素材信息ID
     * @return 素材信息
     */
    public CmsMaterial selectCmsMaterialById(String materialId);

    /**
     * 查询素材信息列表
     * 
     * @param cmsMaterial 素材信息
     * @return 素材信息集合
     */
    public List<CmsMaterial> selectCmsMaterialList(CmsMaterial cmsMaterial);

    /**
     * 新增素材信息
     * 
     * @param cmsMaterial 素材信息
     * @return 结果
     */
    public int insertCmsMaterial(CmsMaterial cmsMaterial);

    /**
     * 修改素材信息
     * 
     * @param cmsMaterial 素材信息
     * @return 结果
     */
    public int updateCmsMaterial(CmsMaterial cmsMaterial);

    /**
     * 删除素材信息
     * 
     * @param materialId 素材信息ID
     * @return 结果
     */
    public int deleteCmsMaterialById(String materialId);

    /**
     * 批量删除素材信息
     * 
     * @param materialIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCmsMaterialByIds(String[] materialIds);
}
