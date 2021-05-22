package com.zebra.bussiness.controller;

import com.zebra.bussiness.domain.UserInfo;
import com.zebra.bussiness.service.IUserInfoService;
import com.zebra.common.annotation.Log;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.core.page.TableDataInfo;
import com.zebra.common.enums.BusinessType;
import com.zebra.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息Controller
 * 
 * @author zebra
 * @date 2021-01-22
 */
@Controller
@RequestMapping("/bussiness/userinfo")
public class UserInfoController extends BaseController {
    private String prefix = "bussiness/userinfo";

    @Autowired
    private IUserInfoService userInfoService;

    @RequiresPermissions("bussiness:userinfo:view")
    @GetMapping()
    public String userinfo()
    {
        return prefix + "/userinfo";
    }

    /**
     * 查询用户信息列表
     */
    @RequiresPermissions("bussiness:userinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserInfo userInfo)
    {
        startPage();
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @RequiresPermissions("bussiness:userinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserInfo userInfo)
    {
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        return util.exportExcel(list, "用户信息");
    }

    /**
     * 新增用户信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户信息
     */
    @RequiresPermissions("bussiness:userinfo:add")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserInfo userInfo)
    {
        return toAjax(userInfoService.insertUserInfo(userInfo));
    }

    /**
     * 修改用户信息
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") String userId, ModelMap mmap)
    {
        UserInfo userInfo = userInfoService.selectUserInfoById(userId);
        mmap.put("userInfo", userInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户信息
     */
    @RequiresPermissions("bussiness:userinfo:edit")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserInfo userInfo)
    {
        return toAjax(userInfoService.updateUserInfo(userInfo));
    }

    /**
     * 删除用户信息
     */
    @RequiresPermissions("bussiness:userinfo:remove")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userInfoService.deleteUserInfoByIds(ids));
    }
}
