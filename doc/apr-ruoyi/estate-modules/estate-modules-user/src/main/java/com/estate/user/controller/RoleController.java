package com.estate.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.estate.api.system.domain.Role;
import com.estate.api.system.model.LoginUser;
import com.estate.common.core.constant.UserConstants;
import com.estate.common.core.result.Result;
import com.estate.common.core.utils.ServletUtils;
import com.estate.common.core.utils.StringUtils;
import com.estate.common.security.annotation.PreAuthorize;
import com.estate.common.security.service.TokenService;
import com.estate.user.service.PermissionService;
import com.estate.user.service.RoleService;
import com.estate.user.service.UserService;
import com.estate.user.vo.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserService userService;

    @PreAuthorize(hasPermi = "system:role:list")
    @GetMapping("/list")
    public Result getRoleList(RoleQueryVo query) {
        Result result = Result.success();
        Page<Role> list = roleService.getRoleList(query);
        result.put(Result.DATA_TAG, list.getRecords());
        result.put("total", list.getTotal());
        return result;
    }


    /**
     * 新增角色
     */
    @PreAuthorize(hasPermi = "system:role:add")
    @PostMapping("/addRole")
    public Result addRole(@Validated @RequestBody Role role) {
        if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleNameUnique(role))) {
            return Result.error("新增角色'" + role.getRoleName() + "'失败，角色名称已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleKeyUnique(role))) {
            return Result.error("新增角色'" + role.getRoleKey() + "'失败，角色权限已存在");
        }

        boolean b = roleService.addRole(role);
        if (b) {
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 修改角色状态
     *
     * @param role
     * @return
     */
    @PreAuthorize(hasPermi = "system:role:edit")
    @PutMapping("/changeStatus")
    public Result changeStatus(@RequestBody Role role) {
        boolean b = roleService.updateById(role);
        if (b) {
            return Result.success();
        }
        return Result.error();
    }


    @PreAuthorize(hasPermi = "system:role:query")
    @GetMapping("/{roleId}")
    public Result getRoleById(@PathVariable("roleId") Long roleId) {
        Role role = roleService.getById(roleId);
        return Result.success(role);
    }

    @PreAuthorize(hasPermi = "system:role:edit")
    @PutMapping("/updateRole")
    public Result updateRole(@Validated @RequestBody Role role) {

        if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleNameUnique(role))) {
            return Result.error("修改角色'" + role.getRoleName() + "'失败，角色名称已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(roleService.checkRoleKeyUnique(role))) {
            return Result.error("修改角色'" + role.getRoleKey() + "'失败，角色权限已存在");
        }

        boolean b = roleService.updateRole(role);
        if (b) {
            // 更新redis缓存用户权限
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            if (StringUtils.isNotNull(loginUser.getUser()) && !loginUser.getUser().isAdmin()) {
                loginUser.setPermissions(permissionService.getMenuPermission(loginUser.getUser().getUserId()));
                loginUser.setUser(userService.selectUserByUserName(loginUser.getUser().getUserName()));
                tokenService.setLoginUser(loginUser);
            }
            return Result.success();
        }
        return Result.error();
    }

    @PreAuthorize(hasPermi = "system:role:remove")
    @DeleteMapping("/{roleIds}")
    public Result delRole(@PathVariable("roleIds") Long[] roleIds) {
        boolean b = roleService.deleteRoleByIds(roleIds);
        if (b) {
            return Result.success();
        }
        return Result.error();
    }


}
