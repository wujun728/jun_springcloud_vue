package com.zebra.bussiness.service.impl;

import java.util.List;
import com.zebra.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.mapper.ActivityCommodityMapper;
import com.zebra.bussiness.domain.ActivityCommodity;
import com.zebra.bussiness.service.IActivityCommodityService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 参与活动商品Service业务层处理
 * 
 * @author zebra
 * @date 2020-09-09
 */
@Service
public class ActivityCommodityServiceImpl implements IActivityCommodityService {
    @Autowired
    private ActivityCommodityMapper activityCommodityMapper;

    /**
     * 查询参与活动商品
     * 
     * @param id 参与活动商品ID
     * @return 参与活动商品
     */
    @Override
    public ActivityCommodity selectActivityCommodityById(String id)
    {
        return activityCommodityMapper.selectActivityCommodityById(id);
    }

    /**
     * 查询参与活动商品列表
     * 
     * @param activityCommodity 参与活动商品
     * @return 参与活动商品
     */
    @Override
    public List<ActivityCommodity> selectActivityCommodityList(ActivityCommodity activityCommodity)
    {
        return activityCommodityMapper.selectActivityCommodityList(activityCommodity);
    }

    /**
     * 新增参与活动商品
     * 
     * @param activityCommodity 参与活动商品
     * @return 结果
     */
    @Override
    public int insertActivityCommodity(ActivityCommodity activityCommodity)
    {
        activityCommodity.setCreateTime(DateUtils.getNowDate());
        activityCommodity.setUpdateTime(DateUtils.getNowDate());
        activityCommodity.setUpdateBy(ShiroUtils.getLoginName());
        return activityCommodityMapper.insertActivityCommodity(activityCommodity);
    }

    /**
     * 修改参与活动商品
     * 
     * @param activityCommodity 参与活动商品
     * @return 结果
     */
    @Override
    public int updateActivityCommodity(ActivityCommodity activityCommodity)
    {
        activityCommodity.setUpdateTime(DateUtils.getNowDate());
        activityCommodity.setUpdateBy(ShiroUtils.getLoginName());
        return activityCommodityMapper.updateActivityCommodity(activityCommodity);
    }

    /**
     * 删除参与活动商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActivityCommodityByIds(String ids)
    {
        return activityCommodityMapper.deleteActivityCommodityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除参与活动商品信息
     * 
     * @param id 参与活动商品ID
     * @return 结果
     */
    @Override
    public int deleteActivityCommodityById(String id)
    {
        return activityCommodityMapper.deleteActivityCommodityById(id);
    }
}
