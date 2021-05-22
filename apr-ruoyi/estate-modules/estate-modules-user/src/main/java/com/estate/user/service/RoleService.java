package com.estate.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.estate.api.system.domain.Role;
import com.estate.user.vo.RoleQueryVo;

import java.util.List;
import java.util.Set;

public interface RoleService extends IService<Role> {

    Set<String> selectRolePermissionByUserId(Long userId);

    List<Role> selectRoleAll();

    List<Integer> selectRoleListByUserId(Long userId);

    Page<Role> getRoleList(RoleQueryVo query);

    String checkRoleNameUnique(Role role);

    String checkRoleKeyUnique(Role role);

    boolean addRole(Role role);

    boolean updateRole(Role role);

    boolean deleteRoleByIds(Long[] roleIds);
}
