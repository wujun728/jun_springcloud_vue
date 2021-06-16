package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.SpecsType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 规格类型Mapper接口
 * 
 * @author zebra
 * @date 2020-09-15
 */
public interface SpecsTypeMapper  extends Mapper<SpecsType> {
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
     * 删除规格类型
     * 
     * @param specsTypeId 规格类型ID
     * @return 结果
     */
    public int deleteSpecsTypeById(String specsTypeId);

    /**
     * 批量删除规格类型
     * 
     * @param specsTypeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSpecsTypeByIds(String[] specsTypeIds);
}
