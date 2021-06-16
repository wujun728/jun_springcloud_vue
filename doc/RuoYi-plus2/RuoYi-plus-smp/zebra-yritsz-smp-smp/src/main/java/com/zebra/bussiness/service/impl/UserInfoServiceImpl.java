package com.zebra.bussiness.service.impl;

import java.util.List;
import com.zebra.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.mapper.UserInfoMapper;
import com.zebra.bussiness.domain.UserInfo;
import com.zebra.bussiness.service.IUserInfoService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 用户信息Service业务层处理
 * 
 * @author zebra
 * @date 2021-01-22
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询用户信息
     * 
     * @param userId 用户信息ID
     * @return 用户信息
     */
    @Override
    public UserInfo selectUserInfoById(String userId)
    {
        return userInfoMapper.selectUserInfoById(userId);
    }

    /**
     * 查询用户信息列表
     * 
     * @param userInfo 用户信息
     * @return 用户信息
     */
    @Override
    public List<UserInfo> selectUserInfoList(UserInfo userInfo)
    {
        return userInfoMapper.selectUserInfoList(userInfo);
    }

    /**
     * 新增用户信息
     * 
     * @param userInfo 用户信息
     * @return 结果
     */
    @Override
    public int insertUserInfo(UserInfo userInfo)
    {
        userInfo.setCreateTime(DateUtils.getNowDate());
        userInfo.setUpdateTime(DateUtils.getNowDate());
        return userInfoMapper.insertUserInfo(userInfo);
    }

    /**
     * 修改用户信息
     * 
     * @param userInfo 用户信息
     * @return 结果
     */
    @Override
    public int updateUserInfo(UserInfo userInfo)
    {
        userInfo.setUpdateTime(DateUtils.getNowDate());
        return userInfoMapper.updateUserInfo(userInfo);
    }

    /**
     * 删除用户信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserInfoByIds(String ids)
    {
        return userInfoMapper.deleteUserInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteUserInfoById(String userId)
    {
        return userInfoMapper.deleteUserInfoById(userId);
    }
}
