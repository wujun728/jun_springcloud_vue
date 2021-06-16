package com.estate.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.estate.api.system.domain.User;
import com.estate.user.vo.UserQueryVo;

public interface UserService extends IService<User> {

    User selectUserByUserName(String username);

    Page<User> getUserList(UserQueryVo query);

    User selectUserById(Long userId);

    boolean updateUser(User user);

    String checkUserNameUnique(String userName);

    String checkPhoneUnique(User user);

    String checkEmailUnique(User user);

    boolean addUser(User user);

    boolean delUser(Long[] userIds);
}
