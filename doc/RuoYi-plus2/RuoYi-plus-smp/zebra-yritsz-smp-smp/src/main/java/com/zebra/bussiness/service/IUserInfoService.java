package com.zebra.bussiness.service;

import com.zebra.bussiness.domain.UserInfo;
import java.util.List;

/**
 * 用户信息Service接口
 * 
 * @author zebra
 * @date 2021-01-22
 */
public interface IUserInfoService {
    /**
     * 查询用户信息
     * 
     * @param userId 用户信息ID
     * @return 用户信息
     */
    public UserInfo selectUserInfoById(String userId);

    /**
     * 查询用户信息列表
     * 
     * @param userInfo 用户信息
     * @return 用户信息集合
     */
    public List<UserInfo> selectUserInfoList(UserInfo userInfo);

    /**
     * 新增用户信息
     * 
     * @param userInfo 用户信息
     * @return 结果
     */
    public int insertUserInfo(UserInfo userInfo);

    /**
     * 修改用户信息
     * 
     * @param userInfo 用户信息
     * @return 结果
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserInfoByIds(String ids);

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息ID
     * @return 结果
     */
    public int deleteUserInfoById(String userId);
}
