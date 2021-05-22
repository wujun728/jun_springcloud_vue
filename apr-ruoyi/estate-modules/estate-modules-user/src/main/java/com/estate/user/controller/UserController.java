package com.estate.user.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.estate.api.system.domain.Role;
import com.estate.api.system.domain.User;
import com.estate.api.system.model.LoginUser;
import com.estate.common.core.constant.UserConstants;
import com.estate.common.core.result.R;
import com.estate.common.core.result.Result;
import com.estate.common.core.utils.StringUtils;
import com.estate.common.security.annotation.PreAuthorize;
import com.estate.common.security.utils.SecurityUtils;
import com.estate.user.service.PermissionService;
import com.estate.user.service.RoleService;
import com.estate.user.service.UserService;
import com.estate.user.vo.UserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;


    /**
     * 查询用户列表
     *
     * @param query
     * @return
     */
    @PreAuthorize(hasPermi = "system:user:list")
    @GetMapping("/list")
    public Result getUserList(UserQueryVo query) {
        Result result = Result.success();
        Page<User> list = userService.getUserList(query);
        result.put(Result.DATA_TAG, list.getRecords());
        result.put("total", list.getTotal());
        return result;
    }

    /**
     * 修改用户状态
     *
     * @param user
     * @return
     */
    @PreAuthorize(hasPermi = "system:user:edit")
    @PutMapping("/changeStatus")
    public Result changeStatus(@RequestBody User user) {
        boolean b = userService.updateById(user);
        if (b) {
            return Result.success();
        }
        return Result.error();
    }


    /**
     * 根据用户编号获取详细信息
     */
    @PreAuthorize(hasPermi = "system:user:query")
    @GetMapping(value = {"/", "/{userId}"})
    public Result getInfo(@PathVariable(value = "userId", required = false) Long userId) {
        Result result = Result.success();
        List<Role> roles = roleService.selectRoleAll();
        // 如果修改的用户是admin，返回所有的角色列表，反之返回除超级管理员之外的角色列表
        result.put("roles", User.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        if (StringUtils.isNotNull(userId)) {
            result.put(Result.DATA_TAG, userService.selectUserById(userId));
            result.put("roleIds", roleService.selectRoleListByUserId(userId));
        }
        return result;
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PreAuthorize(hasPermi = "system:user:add")
    @PostMapping("/addUser")
    public Result addUser(@Validated @RequestBody User user) {

        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName()))) {
            return Result.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        } else if (StringUtils.isNotEmpty(user.getPhonenumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return Result.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        } else if (StringUtils.isNotEmpty(user.getEmail())
                && UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return Result.error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }

        // 密码加密
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        boolean b = userService.addUser(user);
        if (b) {
            return Result.success();
        }
        return Result.error();
    }


    /**
     * 修改用户
     * @param user
     * @return
     */
    @PreAuthorize(hasPermi = "system:user:edit")
    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody User user) {
        if (StringUtils.isNotEmpty(user.getPhonenumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return Result.error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
        } else if (StringUtils.isNotEmpty(user.getEmail())
                && UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return Result.error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }

        boolean b = userService.updateUser(user);
        if (b) {
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 删除用户
     * @param userIds
     * @return
     */
    @PreAuthorize(hasPermi = "system:user:remove")
    @DeleteMapping("/{userIds}")
    public Result delUser(@PathVariable("userIds") Long[] userIds) {
        boolean b = userService.delUser(userIds);
        if (b) {
            return Result.success();
        }
        return Result.error();
    }


    /**
     * 重置用户密码
     * @param user
     * @return
     */
    @PreAuthorize(hasPermi = "system:user:edit")
    @PutMapping("/resetPwd")
    public Result resetPwd(@RequestBody User user) {
        String password = SecurityUtils.encryptPassword(user.getPassword());
        user.setPassword(password);
        boolean b = userService.updateById(user);
        if (b) {
            return Result.success();
        }
        return Result.error();
    }

    @PreAuthorize(hasPermi = "system:user:export")
    @PostMapping("/export")
    public void exportUserList(HttpServletResponse response, @RequestBody UserQueryVo query) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.addHeader("Access-Control-Expose-Headers", "Content-disposition");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), User.class).excelType(ExcelTypeEnum.XLSX).sheet("模板").doWrite(userService.getUserList(query).getRecords());

    }


    /**
     * 获取当前用户信息（feign调用）
     */
    @GetMapping("/info/{username}")
    public R<LoginUser> info(@PathVariable("username") String username) {
        User sysUser = userService.selectUserByUserName(username);
        if (StringUtils.isNull(sysUser)) {
            return R.fail("用户名或密码错误");
        }
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(sysUser.getUserId());
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(sysUser.getUserId());
        LoginUser sysUserVo = new LoginUser();
        sysUserVo.setUser(sysUser);
        sysUserVo.setRoles(roles);
        sysUserVo.setPermissions(permissions);
        return R.ok(sysUserVo);
    }


}
