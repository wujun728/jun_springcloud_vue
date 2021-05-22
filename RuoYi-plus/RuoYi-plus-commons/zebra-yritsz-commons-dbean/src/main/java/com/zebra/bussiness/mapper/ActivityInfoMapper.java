package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.ActivityInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 活动信息Mapper接口
 * 
 * @author zebra
 * @date 2020-09-09
 */
public interface ActivityInfoMapper  extends Mapper<ActivityInfo> {
    /**
     * 查询活动信息
     * 
     * @param activityId 活动信息ID
     * @return 活动信息
     */
    public ActivityInfo selectActivityInfoById(String activityId);

    /**
     * 查询活动信息列表
     * 
     * @param activityInfo 活动信息
     * @return 活动信息集合
     */
    public List<ActivityInfo> selectActivityInfoList(ActivityInfo activityInfo);

    /**
     * 新增活动信息
     * 
     * @param activityInfo 活动信息
     * @return 结果
     */
    public int insertActivityInfo(ActivityInfo activityInfo);

    /**
     * 修改活动信息
     * 
     * @param activityInfo 活动信息
     * @return 结果
     */
    public int updateActivityInfo(ActivityInfo activityInfo);

    /**
     * 删除活动信息
     * 
     * @param activityId 活动信息ID
     * @return 结果
     */
    public int deleteActivityInfoById(String activityId);

    /**
     * 批量删除活动信息
     * 
     * @param activityIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteActivityInfoByIds(String[] activityIds);
}
