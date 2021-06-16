package com.zebra.bussiness.service;

import com.zebra.bussiness.domain.SpecsType;
import java.util.List;

/**
 * 规格类型Service接口
 * 
 * @author zebra
 * @date 2020-09-15
 */
public interface ISpecsTypeService {
    /**
     * 查询规格类型
     * 
     * @param specsTypeId 规格类型ID
     * @return 规格类型
     */
    public SpecsType selectSpecsTypeById(String specsTypeId);

    /**
     * 查询规格类型列表
     * 
     * @param specsType 规格类型
     * @return 规格类型集合
     */
    public List<SpecsType> selectSpecsTypeList(SpecsType specsType);

    /**
     * 新增规格类型
     * 
     * @param specsType 规格类型
     * @return 结果
     */
    public int insertSpecsType(SpecsType specsType);

    /**
     * 修改规格类型
     * 
     * @param specsType 规格类型
     * @return 结果
     */
    public int updateSpecsType(SpecsType specsType);

    /**
     * 批量删除规格类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSpecsTypeByIds(String ids);

    /**
     * 删除规格类型信息
     * 
     * @param specsTypeId 规格类型ID
     * @return 结果
     */
    public int deleteSpecsTypeById(String specsTypeId);
}
