package com.estate.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.estate.user.entity.UserRole;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRole> {
    Integer deleteUserRoleByUserId(Long userId);

    boolean batchUserRole(List<UserRole> list);

    boolean deleteUserRole(Long[] userIds);

    Integer countUserRoleByRoleId(Long roleId);
}
