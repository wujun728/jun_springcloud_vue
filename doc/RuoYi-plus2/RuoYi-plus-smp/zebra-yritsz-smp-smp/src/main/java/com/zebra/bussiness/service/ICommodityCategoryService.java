package com.zebra.bussiness.service;

import com.zebra.bussiness.domain.CommodityCategory;
import com.zebra.common.core.domain.Ztree;

import java.util.List;

/**
 * 产品类别Service接口
 * 
 * @author zebra
 * @date 2020-07-01
 */
public interface ICommodityCategoryService {
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
     * 批量删除产品类别
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityCategoryByIds(String ids);

    /**
     * 删除产品类别信息
     * 
     * @param categoryId 产品类别ID
     * @return 结果
     */
    public int deleteCommodityCategoryById(Long categoryId);

    /**
     * 查询产品类别树列表
     * 
     * @return 所有产品类别信息
     */
    public List<Ztree> selectCommodityCategoryTree();
}
