package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.UserInfo;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户信息Mapper接口
 * 
 * @author zebra
 * @date 2021-01-22
 */
public interface UserInfoMapper  extends Mapper<UserInfo> {
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
     * 删除用户信息
     * 
     * @param userId 用户信息ID
     * @return 结果
     */
    public int deleteUserInfoById(String userId);

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserInfoByIds(String[] userIds);
}
