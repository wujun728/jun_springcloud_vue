package com.zebra.bussiness.service;

import com.zebra.bussiness.domain.ActivityCommodity;
import java.util.List;

/**
 * 参与活动商品Service接口
 * 
 * @author zebra
 * @date 2020-09-09
 */
public interface IActivityCommodityService {
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
     * 批量删除参与活动商品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteActivityCommodityByIds(String ids);

    /**
     * 删除参与活动商品信息
     * 
     * @param id 参与活动商品ID
     * @return 结果
     */
    public int deleteActivityCommodityById(String id);
}
