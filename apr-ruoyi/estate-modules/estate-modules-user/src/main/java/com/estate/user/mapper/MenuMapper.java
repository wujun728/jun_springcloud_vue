package com.estate.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.estate.user.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectMenuPermsByUserId(Long userId);

    List<Menu> selectMenuTreeByUserId(Long userId);

    List<Menu> selectMenuTreeAll();

    List<Menu> selectMenuList();

    List<Menu> selectMenuListByUserId(Long userId);

    List<Integer> selectMenuListByRoleId(@Param("roleId") Long roleId,@Param("menuCheckStrictly") boolean menuCheckStrictly);

    List<Menu> selectLikeMenuListByUserId(@Param("menu") Menu menu,@Param("userId") Long userId);

    List<Menu> selectLikeMenuList(Menu menu);
}
