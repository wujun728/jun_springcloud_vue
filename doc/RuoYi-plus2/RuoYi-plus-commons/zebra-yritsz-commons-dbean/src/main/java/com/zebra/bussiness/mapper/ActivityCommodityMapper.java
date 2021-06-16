package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.ActivityCommodity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 参与活动商品Mapper接口
 * 
 * @author zebra
 * @date 2020-09-09
 */
public interface ActivityCommodityMapper  extends Mapper<ActivityCommodity> {
    /**
     * 查询参与活动商品
     * 
     * @param id 参与活动商品ID
     * @return 参与活动商品
     */
    public ActivityCommodity selectActivityCommodityById(String id);

    /**
     * 查询参与活动商品列表
     * 
     * @param activityCommodity 参与活动商品
     * @return 参与活动商品集合
     */
    public List<ActivityCommodity> selectActivityCommodityList(ActivityCommodity activityCommodity);

    /**
     * 新增参与活动商品
     * 
     * @param activityCommodity 参与活动商品
     * @return 结果
     */
    public int insertActivityCommodity(ActivityCommodity activityCommodity);

    /**
     * 修改参与活动商品
     * 
     * @param activityCommodity 参与活动商品
     * @return 结果
     */
    public int updateActivityCommodity(ActivityCommodity activityCommodity);

    /**
     * 删除参与活动商品
     * 
     * @param id 参与活动商品ID
     * @return 结果
     */
    public int deleteActivityCommodityById(String id);

    /**
     * 批量删除参与活动商品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActivityCommodityByIds(String[] ids);
}
