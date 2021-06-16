package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.CommodityOrderDeputy;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 订单辅助Mapper接口
 * 
 * @author zebra
 * @date 2021-01-09
 */
public interface CommodityOrderDeputyMapper  extends Mapper<CommodityOrderDeputy> {
    /**
     * 查询订单辅助
     * 
     * @param deputyId 订单辅助ID
     * @return 订单辅助
     */
    public CommodityOrderDeputy selectCommodityOrderDeputyById(String deputyId);

    /**
     * 查询订单辅助列表
     * 
     * @param commodityOrderDeputy 订单辅助
     * @return 订单辅助集合
     */
    public List<CommodityOrderDeputy> selectCommodityOrderDeputyList(CommodityOrderDeputy commodityOrderDeputy);

    /**
     * 新增订单辅助
     * 
     * @param commodityOrderDeputy 订单辅助
     * @return 结果
     */
    public int insertCommodityOrderDeputy(CommodityOrderDeputy commodityOrderDeputy);

    /**
     * 修改订单辅助
     * 
     * @param commodityOrderDeputy 订单辅助
     * @return 结果
     */
    public int updateCommodityOrderDeputy(CommodityOrderDeputy commodityOrderDeputy);

    /**
     * 删除订单辅助
     * 
     * @param deputyId 订单辅助ID
     * @return 结果
     */
    public int deleteCommodityOrderDeputyById(String deputyId);

    /**
     * 批量删除订单辅助
     * 
     * @param deputyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommodityOrderDeputyByIds(String[] deputyIds);
}
