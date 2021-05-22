package com.estate.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.estate.user.entity.RoleMenu;

import java.util.List;

public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    void batchRoleMenu(List<RoleMenu> list);

    void deleteRoleMenuByRoleId(Long roleId);

    void deleteRoleMenu(Long[] roleIds);
}
