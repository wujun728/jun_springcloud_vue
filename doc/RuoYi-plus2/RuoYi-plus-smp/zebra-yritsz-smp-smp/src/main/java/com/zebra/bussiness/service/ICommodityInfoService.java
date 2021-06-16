package com.zebra.bussiness.service;

import com.zebra.bussiness.domain.CommodityInfo;
import java.util.List;

/**
 * 产品信息Service接口
 * 
 * @author zebra
 * @date 2020-06-05
 */
public interface ICommodityInfoService {
    /**
     * 查询产品信息
     * 
     * @param commodityId 产品信息ID
     * @return 产品信息
     */
    public CommodityInfo selectCommodityInfoById(String commodityId);

    /**
     * 查询产品信息列表
     * 
     * @param commodityInfo 产品信息
     * @return 产品信息集合
     */
    public List<CommodityInfo> selectCommodityInfoList(CommodityInfo commodityInfo);

    /**
     * 新增产品信息
     * 
     * @param commodityInfo 产品信息
     * @return 结果
     */
    public int insertCommodityInfo(CommodityInfo commodityInfo);

    /**
     * 修改产品信息
     * 
     * @param commodityInfo 产品信息
     * @return 结果
     */
    public int updateCommodityInfo(CommodityInfo commodityInfo);

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityInfoByIds(String ids);

    /**
     * 删除产品信息信息
     * 
     * @param commodityId 产品信息ID
     * @return 结果
     */
    public int deleteCommodityInfoById(String commodityId);
}
