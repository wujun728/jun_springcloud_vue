package com.estate.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.estate.api.system.domain.User;
import com.estate.common.core.constant.UserConstants;
import com.estate.common.core.utils.StringUtils;
import com.estate.user.entity.UserRole;
import com.estate.user.mapper.UserMapper;
import com.estate.user.mapper.UserRoleMapper;
import com.estate.user.service.UserService;
import com.estate.user.vo.UserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User selectUserByUserName(String username) {
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("user_name",username);
//        return this.getOne(wrapper);
        return userMapper.selectUserByUserName(username);
    }

    /**
     * 获取用户列表
     *
     * @param query
     * @return
     */
    @Override
    public Page<User> getUserList(UserQueryVo query) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Page<User> page = new Page<>(query.getPageNum(), query.getPageSize());

        if (!StringUtils.isEmpty(query.getUserName())) {
            wrapper.like("user_name", query.getUserName());
        }

        if (!StringUtils.isEmpty(query.getPhonenumber())) {
            wrapper.like("phonenumber", query.getPhonenumber());
        }

        if (!StringUtils.isEmpty(query.getStatus())) {
            wrapper.eq("status", query.getStatus());
        }

        if (!StringUtils.isEmpty((String) query.getParams().get("beginTime")) &&
                !StringUtils.isEmpty((String) query.getParams().get("endTime"))) {
            wrapper.between("create_time", query.getParams().get("beginTime"), query.getParams().get("endTime"));
        }

        Page<User> pageList = this.page(page, wrapper);
        return pageList;
    }

    @Override
    public User selectUserById(Long userId) {
        return this.getById(userId);
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(User user) {
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(user.getUserId());

        // 新建用户与角色关联
        this.addUserRole(user);

        // 修改用户信息
        boolean b = this.updateById(user);
        return b;
    }

    /**
     * 新建用户与角色关联
     *
     * @param user
     * @return
     */
    public void addUserRole(User user) {
        Long[] roleIds = user.getRoleIds();
        if (StringUtils.isNotNull(roleIds)) {
            List<UserRole> list = new ArrayList<>();
            for (Long role : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setRoleId(role);
                userRole.setUserId(user.getUserId());
                list.add(userRole);
            }
            if (list.size() > 0) {
                userRoleMapper.batchUserRole(list);
            }
        }
    }


    @Override
    public String checkUserNameUnique(String userName) {
        User user = this.getOne(new QueryWrapper<User>().eq("user_name", userName));
        if (user != null) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkPhoneUnique(User user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        User oneUser = this.getOne(new QueryWrapper<User>().eq("phonenumber", user.getPhonenumber()));
        if (StringUtils.isNotNull(oneUser) && oneUser.getUserId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkEmailUnique(User user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        User oneUser = this.getOne(new QueryWrapper<User>().eq("email", user.getEmail()));
        if (StringUtils.isNotNull(oneUser) && oneUser.getUserId().longValue() != userId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(User user) {
        // 一定要先添加用户，再添加用户与角色关联，因为先添加用户与角色关联是没有用户id的，
        // 所以要先添加用户，然后user参数中userId就不为null了，否则添加用户与角色关联时 userId 为null，添加失败
        boolean b = this.save(user);
        // 新建用户与角色关联
        this.addUserRole(user);
        return b;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delUser(Long[] userIds) {
        List<Long> userIdList = Arrays.asList(userIds);
        boolean b = this.removeByIds(userIdList);
        userRoleMapper.deleteUserRole(userIds);
        return b;
    }
}
