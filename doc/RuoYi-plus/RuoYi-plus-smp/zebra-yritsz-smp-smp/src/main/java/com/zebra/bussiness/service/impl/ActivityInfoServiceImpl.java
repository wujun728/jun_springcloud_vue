package com.zebra.bussiness.service.impl;

import java.util.List;

import com.zebra.bussiness.service.impl.extend.BaseServiceImplExtend;
import com.zebra.common.utils.DateUtils;
import com.zebra.common.utils.UidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.mapper.ActivityInfoMapper;
import com.zebra.bussiness.domain.ActivityInfo;
import com.zebra.bussiness.service.IActivityInfoService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 活动信息Service业务层处理
 *
 * @author zebra
 * @date 2020-09-09
 */
@Service
public class ActivityInfoServiceImpl extends BaseServiceImplExtend implements IActivityInfoService {
    @Autowired
    private ActivityInfoMapper activityInfoMapper;

    /**
     * 查询活动信息
     *
     * @param activityId 活动信息ID
     * @return 活动信息
     */
    @Override
    public ActivityInfo selectActivityInfoById(String activityId) {
        return activityInfoMapper.selectActivityInfoById(activityId);
    }

    /**
     * 查询活动信息列表
     *
     * @param activityInfo 活动信息
     * @return 活动信息
     */
    @Override
    public List<ActivityInfo> selectActivityInfoList(ActivityInfo activityInfo) {
         return activityInfoMapper.selectActivityInfoList(activityInfo);
    }

    /**
     * 新增活动信息
     *
     * @param activityInfo 活动信息
     * @return 结果
     */
    @Override
    public int insertActivityInfo(ActivityInfo activityInfo) {
        activityInfo.setCreateTime(DateUtils.getNowDate());
        activityInfo.setUpdateTime(DateUtils.getNowDate());
        activityInfo.setUpdateBy(ShiroUtils.getLoginName());
        return activityInfoMapper.insertActivityInfo(activityInfo);
    }

    /**
     * 修改活动信息
     *
     * @param activityInfo 活动信息
     * @return 结果
     */
    @Override
    public int updateActivityInfo(ActivityInfo activityInfo) {
        activityInfo.setUpdateTime(DateUtils.getNowDate());
        activityInfo.setUpdateBy(ShiroUtils.getLoginName());
        return activityInfoMapper.updateActivityInfo(activityInfo);
    }

    /**
     * 删除活动信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteActivityInfoByIds(String ids) {
        return activityInfoMapper.deleteActivityInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除活动信息信息
     *
     * @param activityId 活动信息ID
     * @return 结果
     */
    @Override
    public int deleteActivityInfoById(String activityId) {
        return activityInfoMapper.deleteActivityInfoById(activityId);
    }
}
