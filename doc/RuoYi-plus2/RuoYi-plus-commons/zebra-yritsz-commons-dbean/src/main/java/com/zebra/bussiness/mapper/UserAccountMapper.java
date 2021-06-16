package com.zebra.bussiness.mapper;

import com.zebra.bussiness.domain.UserAccount;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户账户Mapper接口
 * 
 * @author zebra
 * @date 2021-01-22
 */
public interface UserAccountMapper  extends Mapper<UserAccount> {
    /**
     * 查询用户账户
     * 
     * @param accountId 用户账户ID
     * @return 用户账户
     */
    public UserAccount selectUserAccountById(String accountId);

    /**
     * 查询用户账户列表
     * 
     * @param userAccount 用户账户
     * @return 用户账户集合
     */
    public List<UserAccount> selectUserAccountList(UserAccount userAccount);

    /**
     * 新增用户账户
     * 
     * @param userAccount 用户账户
     * @return 结果
     */
    public int insertUserAccount(UserAccount userAccount);

    /**
     * 修改用户账户
     * 
     * @param userAccount 用户账户
     * @return 结果
     */
    public int updateUserAccount(UserAccount userAccount);

    /**
     * 删除用户账户
     * 
     * @param accountId 用户账户ID
     * @return 结果
     */
    public int deleteUserAccountById(String accountId);

    /**
     * 批量删除用户账户
     * 
     * @param accountIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserAccountByIds(String[] accountIds);
}
