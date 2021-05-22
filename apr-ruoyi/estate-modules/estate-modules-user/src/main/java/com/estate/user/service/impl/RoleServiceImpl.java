package com.estate.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.estate.api.system.domain.Role;
import com.estate.common.core.constant.UserConstants;
import com.estate.common.core.exception.CustomException;
import com.estate.common.core.utils.StringUtils;
import com.estate.user.entity.RoleMenu;
import com.estate.user.mapper.RoleMapper;
import com.estate.user.mapper.RoleMenuMapper;
import com.estate.user.mapper.UserRoleMapper;
import com.estate.user.service.RoleService;
import com.estate.user.vo.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        List<Role> perms = roleMapper.selectRolePermissionByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (Role perm : perms) {
            if (StringUtils.isNotNull(perm)) {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }

    @Override
    public List<Role> selectRoleAll() {
        List<Role> list = this.list();
        return list;
    }

    @Override
    public List<Integer> selectRoleListByUserId(Long userId) {
        return roleMapper.selectRoleListByUserId(userId);
    }

    @Override
    public Page<Role> getRoleList(RoleQueryVo query) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        Page<Role> page = new Page<>(query.getPageNum(), query.getPageSize());

        if (!StringUtils.isEmpty(query.getRoleName())) {
            wrapper.like("role_name", query.getRoleName());
        }

        if (!StringUtils.isEmpty(query.getRoleKey())) {
            wrapper.like("role_key", query.getRoleKey());
        }

        if (!StringUtils.isEmpty(query.getStatus())) {
            wrapper.eq("status", query.getStatus());
        }

        if (!StringUtils.isEmpty((String) query.getParams().get("beginTime")) &&
                !StringUtils.isEmpty((String) query.getParams().get("endTime"))) {
            wrapper.between("create_time", query.getParams().get("beginTime"), query.getParams().get("endTime"));
        }
        Page<Role> pageList = this.page(page, wrapper);
        return pageList;
    }

    @Override
    public String checkRoleNameUnique(Role role) {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        Role info = roleMapper.checkRoleNameUnique(role.getRoleName());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkRoleKeyUnique(Role role) {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        Role info = roleMapper.checkRoleKeyUnique(role.getRoleKey());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addRole(Role role) {
        boolean save = this.save(role);
        this.addRoleMenu(role);
        return save;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRole(Role role) {
        roleMenuMapper.deleteRoleMenuByRoleId(role.getRoleId());
        this.addRoleMenu(role);
        boolean b = this.updateById(role);
        return b;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteRoleByIds(Long[] roleIds) {
        for (Long roleId : roleIds) {
            // 获取角色信息
            Role role = this.getById(roleId);
            // 查询有几个用户分配了该角色
            Integer result = userRoleMapper.countUserRoleByRoleId(roleId);
            if (result > 0) { // 如果拥有该角色的用户不为0，则不能删除该角色
                throw new CustomException(String.format("%1$s已分配,不能删除", role.getRoleName()));
            }
        }

        // 删除角色与菜单关联
        roleMenuMapper.deleteRoleMenu(roleIds);
        // 删除角色
        boolean b = this.removeByIds(Arrays.asList(roleIds));
        return b;
    }

    /**
     * 添加角色和菜单关联
     *
     * @param role
     */
    public void addRoleMenu(Role role) {
        Long[] menuIds = role.getMenuIds();
        if (StringUtils.isNotNull(menuIds)) {
            List<RoleMenu> list = new ArrayList<>();
            for (Long menuId : menuIds) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(role.getRoleId());
                roleMenu.setMenuId(menuId);
                list.add(roleMenu);
            }
            if (list.size() > 0) {
                roleMenuMapper.batchRoleMenu(list);
            }
        }
    }


}
