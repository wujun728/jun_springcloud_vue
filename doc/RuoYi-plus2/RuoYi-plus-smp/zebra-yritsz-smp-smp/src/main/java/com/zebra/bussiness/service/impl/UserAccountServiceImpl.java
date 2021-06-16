package com.zebra.bussiness.service.impl;

import java.util.List;
import com.zebra.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zebra.bussiness.mapper.UserAccountMapper;
import com.zebra.bussiness.domain.UserAccount;
import com.zebra.bussiness.service.IUserAccountService;
import com.zebra.common.core.text.Convert;
import com.zebra.framework.util.ShiroUtils;

/**
 * 用户账户Service业务层处理
 * 
 * @author zebra
 * @date 2021-01-22
 */
@Service
public class UserAccountServiceImpl implements IUserAccountService {
    @Autowired
    private UserAccountMapper userAccountMapper;

    /**
     * 查询用户账户
     * 
     * @param accountId 用户账户ID
     * @return 用户账户
     */
    @Override
    public UserAccount selectUserAccountById(String accountId)
    {
        return userAccountMapper.selectUserAccountById(accountId);
    }

    /**
     * 查询用户账户列表
     * 
     * @param userAccount 用户账户
     * @return 用户账户
     */
    @Override
    public List<UserAccount> selectUserAccountList(UserAccount userAccount)
    {
        return userAccountMapper.selectUserAccountList(userAccount);
    }

    /**
     * 新增用户账户
     * 
     * @param userAccount 用户账户
     * @return 结果
     */
    @Override
    public int insertUserAccount(UserAccount userAccount)
    {
        userAccount.setCreateTime(DateUtils.getNowDate());
        userAccount.setUpdateTime(DateUtils.getNowDate());
        return userAccountMapper.insertUserAccount(userAccount);
    }

    /**
     * 修改用户账户
     * 
     * @param userAccount 用户账户
     * @return 结果
     */
    @Override
    public int updateUserAccount(UserAccount userAccount)
    {
        userAccount.setUpdateTime(DateUtils.getNowDate());
        return userAccountMapper.updateUserAccount(userAccount);
    }

    /**
     * 删除用户账户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserAccountByIds(String ids)
    {
        return userAccountMapper.deleteUserAccountByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户账户信息
     * 
     * @param accountId 用户账户ID
     * @return 结果
     */
    @Override
    public int deleteUserAccountById(String accountId)
    {
        return userAccountMapper.deleteUserAccountById(accountId);
    }
}
