package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.CommodityInfo;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 产品信息Mapper接口
 * 
 * @author zebra
 * @date 2020-03-25
 */
public interface CommodityInfoMapper  extends Mapper<CommodityInfo> 
{
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
     * 删除产品信息
     * 
     * @param commodityId 产品信息ID
     * @return 结果
     */
    public int deleteCommodityInfoById(String commodityId);

    /**
     * 批量删除产品信息
     * 
     * @param commodityIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityInfoByIds(String[] commodityIds);
}
