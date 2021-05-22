package com.estate.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.estate.api.system.domain.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectRolePermissionByUserId(Long userId);

    List<Integer> selectRoleListByUserId(Long userId);

    Role checkRoleNameUnique(String roleName);

    Role checkRoleKeyUnique(String roleKey);
}
