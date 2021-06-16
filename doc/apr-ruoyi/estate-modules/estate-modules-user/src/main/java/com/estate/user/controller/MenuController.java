package com.estate.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.estate.api.system.model.LoginUser;
import com.estate.api.system.vo.RouterVo;
import com.estate.common.core.constant.Constants;
import com.estate.common.core.constant.UserConstants;
import com.estate.common.core.result.R;
import com.estate.common.core.result.Result;
import com.estate.common.core.utils.ServletUtils;
import com.estate.common.core.utils.StringUtils;
import com.estate.common.security.annotation.PreAuthorize;
import com.estate.common.security.service.TokenService;
import com.estate.user.entity.Menu;
import com.estate.user.entity.RoleMenu;
import com.estate.user.entity.TreeSelect;
import com.estate.user.mapper.RoleMenuMapper;
import com.estate.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private TokenService tokenService;


    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 获取菜单列表
     */
    @PreAuthorize(hasPermi = "system:menu:list")
    @GetMapping("/list")
    public Result getMenuList(Menu menu) {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long userId = loginUser.getUser().getUserId();

        List<Menu> menus = menuService.selectMenuList(menu, userId);

        return Result.success(menus);

    }

    @PreAuthorize(hasPermi = "system:menu:query")
    @GetMapping("/{menuId}")
    public Result getMenuById(@PathVariable("menuId") Long menuId) {
        Menu menu = menuService.getById(menuId);
        return Result.success(menu);
    }


    @PreAuthorize(hasPermi = "system:menu:add")
    @PostMapping("/addMenu")
    public Result addMenu(@RequestBody Menu menu) {
        if (UserConstants.NOT_UNIQUE.equals(menuService.checkMenuNameUnique(menu))) {
            return Result.error("新增菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        } else if (UserConstants.YES_FRAME.equals(menu.getIsFrame())
                && !StringUtils.startsWithAny(menu.getPath(), Constants.HTTP, Constants.HTTPS)) {
            return Result.error("新增菜单'" + menu.getMenuName() + "'失败，地址必须以http(s)://开头");
        }

        boolean save = menuService.save(menu);
        if (save) {
            return Result.success();
        }
        return Result.error();
    }

    @PreAuthorize(hasPermi = "system:menu:edit")
    @PutMapping("/updateMenu")
    public Result updateMenu(@RequestBody Menu menu) {
        if (UserConstants.NOT_UNIQUE.equals(menuService.checkMenuNameUnique(menu))) {
            return Result.error("修改菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        } else if (UserConstants.YES_FRAME.equals(menu.getIsFrame())
                && !StringUtils.startsWithAny(menu.getPath(), Constants.HTTP, Constants.HTTPS)) {
            return Result.error("修改菜单'" + menu.getMenuName() + "'失败，地址必须以http(s)://开头");
        } else if (menu.getMenuId().equals(menu.getParentId())) {
            return Result.error("修改菜单'" + menu.getMenuName() + "'失败，上级菜单不能选择自己");
        }

        boolean b = menuService.updateById(menu);
        if (b) {
            return Result.success();
        }
        return Result.error();
    }


    @PreAuthorize(hasPermi = "system:menu:remove")
    @DeleteMapping("/{menuId}")
    public Result delMenu(@PathVariable("menuId") Long menuId) {
        QueryWrapper<Menu> menuWrapper = new QueryWrapper<>();
        menuWrapper.eq("parent_id", menuId);
        if (menuService.count(menuWrapper) > 0) {
            return Result.error("存在子菜单,不允许删除");
        }

        QueryWrapper<RoleMenu> roleMenuWrapper = new QueryWrapper<>();
        roleMenuWrapper.eq("menu_id", menuId);
        if (roleMenuMapper.selectCount(roleMenuWrapper) > 0) {
            return Result.error("菜单已分配,不允许删除");
        }

        boolean b = menuService.removeById(menuId);
        if (b) {
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 查询用户路由（feign远程调用）
     *
     * @param userId
     * @return
     */
    @GetMapping("/user/router/{userId}")
    R<List<RouterVo>> getRouters(@PathVariable("userId") Long userId) {
        List<Menu> menus = menuService.selectMenuTreeByUserId(userId);
        List<RouterVo> routerVos = menuService.buildMenus(menus);
        return R.ok(routerVos);
    }

    /**
     * 获取菜单下拉树列表(点击添加按钮时查询出的菜单列表)
     */
    @GetMapping("/treeSelect")
    public Result treeSelect() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long userId = loginUser.getUser().getUserId();
        List<Menu> menus = menuService.treeSelect(userId);
        List<TreeSelect> treeSelectList = menuService.buildMenuTreeSelect(menus);
        return Result.success(treeSelectList);
    }


    /**
     * 根据角色Id查询菜单结构(点击修改按钮时查询出的菜单列表，以及默认选中的菜单列表)
     *
     * @param roleId
     * @return
     */
    @GetMapping("/roleMenuTreeSelect/{roleId}")
    public Result roleMenuTreeSelectByRoleId(@PathVariable("roleId") Long roleId) {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        Long userId = loginUser.getUser().getUserId();
        // 根据用户id查询菜单列表
        List<Menu> menus = menuService.treeSelect(userId);
        // 把菜单列表包装成前端tree组件的格式
        List<TreeSelect> treeSelectList = menuService.buildMenuTreeSelect(menus);
        // 根据角色id查询菜单列表（在前端作为默认选中的数据）
        List<Integer> menuList = menuService.selectMenuListByRoleId(roleId);

        Result result = Result.success();
        result.put("menus", treeSelectList);
        result.put("checkedKeys", menuList);
        return result;
    }


}
