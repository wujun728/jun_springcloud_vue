package com.estate.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.estate.api.system.vo.RouterVo;
import com.estate.user.entity.Menu;
import com.estate.user.entity.TreeSelect;

import java.util.List;
import java.util.Set;

public interface MenuService extends IService<Menu> {

    Set<String> selectMenuPermsByUserId(Long userId);

    List<Menu> selectMenuTreeByUserId(Long userId);

    List<RouterVo> buildMenus(List<Menu> menus);

    List<Menu> treeSelect(Long userId);

    List<TreeSelect> buildMenuTreeSelect(List<Menu> menus);

    List<Integer> selectMenuListByRoleId(Long roleId);

    List<Menu> selectMenuList(Menu menu, Long userId);

    String checkMenuNameUnique(Menu menu);
}
