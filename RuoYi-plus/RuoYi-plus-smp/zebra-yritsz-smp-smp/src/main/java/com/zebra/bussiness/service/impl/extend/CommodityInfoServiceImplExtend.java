package com.zebra.bussiness.service.impl.extend;

import com.zebra.bussiness.domain.CommodityCategory;
import com.zebra.bussiness.domain.SpecsType;
import com.zebra.bussiness.mapper.CommodityCategoryMapper;
import com.zebra.bussiness.mapper.SpecsTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.zebra.bussiness.domain.CityInfo;
import com.zebra.bussiness.domain.ProvinceInfo;
import com.zebra.bussiness.mapper.CityInfoMapper;
import com.zebra.bussiness.mapper.ProvinceInfoMapper;
import com.zebra.common.utils.StringUtils;
import com.zebra.system.domain.SysDept;
import com.zebra.system.mapper.SysDeptMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class CommodityInfoServiceImplExtend extends BaseServiceImplExtend {
    @Autowired
    private CommodityCategoryMapper commodityCategoryMapper;
    @Autowired
    private SpecsTypeMapper specsTypeMapper;

    protected String getCategoryName(String categoryId) {
        CommodityCategory commodityCategory = commodityCategoryMapper.selectByPrimaryKey(categoryId);
        if (commodityCategory != null)
            return commodityCategory.getCategoryName();
        return null;
    }

    protected List<SpecsType> getSpecsTypeList() {
        Example example = new Example(SpecsType.class);
        example.setOrderByClause(" zebra_order asc");
        return specsTypeMapper.selectByExample(example);
    }
}
