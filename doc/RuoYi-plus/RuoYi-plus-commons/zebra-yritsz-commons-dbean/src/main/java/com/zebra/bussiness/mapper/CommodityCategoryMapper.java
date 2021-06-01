package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.CommodityCategory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 产品类别Mapper接口
 * 
 * @author zebra
 * @date 2020-06-05
 */
public interface CommodityCategoryMapper  extends Mapper<CommodityCategory> {
    /**
     * 查询产品类别
     * 
     * @param categoryId 产品类别ID
     * @return 产品类别
     */
    public CommodityCategory selectCommodityCategoryById(Long categoryId);

    /**
     * 查询产品类别列表
     * 
     * @param commodityCategory 产品类别
     * @return 产品类别集合
     */
    public List<CommodityCategory> selectCommodityCategoryList(CommodityCategory commodityCategory);

    /**
     * 新增产品类别
     * 
     * @param commodityCategory 产品类别
     * @return 结果
     */
    public int insertCommodityCategory(CommodityCategory commodityCategory);

    /**
     * 修改产品类别
     * 
     * @param commodityCategory 产品类别
     * @return 结果
     */
    public int updateCommodityCategory(CommodityCategory commodityCategory);

    /**
     * 删除产品类别
     * 
     * @param categoryId 产品类别ID
     * @return 结果
     */
    public int deleteCommodityCategoryById(Long categoryId);

    /**
     * 批量删除产品类别
     * 
     * @param categoryIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityCategoryByIds(String[] categoryIds);
}
