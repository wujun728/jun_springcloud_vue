package com.zebra.bussiness.controller;

import com.zebra.bussiness.controller.extend.UserAccountControllerExtend;
import com.zebra.bussiness.domain.UserAccount;
import com.zebra.bussiness.domain.page.UserAccountPage;
import com.zebra.bussiness.service.IUserAccountService;
import com.zebra.common.annotation.Log;
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
 * 用户账户Controller
 *
 * @author zebra
 * @date 2021-01-22
 */
@Controller
@RequestMapping("/bussiness/useraccount")
public class UserAccountController extends UserAccountControllerExtend {
    private String prefix = "bussiness/useraccount";

    @Autowired
    private IUserAccountService userAccountService;

    @RequiresPermissions("bussiness:useraccount:view")
    @GetMapping()
    public String useraccount() {
        return prefix + "/useraccount";
    }

    /**
     * 查询用户账户列表
     */
    @RequiresPermissions("bussiness:useraccount:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserAccount userAccount) {
        startPage();
        List<UserAccount> list = userAccountService.selectUserAccountList(userAccount);
        return getDataTable(super.getUserAccountPage(list));
    }

    /**
     * 导出用户账户列表
     */
    @RequiresPermissions("bussiness:useraccount:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserAccount userAccount) {
        List<UserAccount> list = userAccountService.selectUserAccountList(userAccount);
        ExcelUtil<UserAccountPage> util = new ExcelUtil<UserAccountPage>(UserAccountPage.class);
        return util.exportExcel(super.getUserAccountPage(list), "用户账户");
    }

    /**
     * 新增用户账户
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户账户
     */
    @RequiresPermissions("bussiness:useraccount:add")
    @Log(title = "用户账户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserAccount userAccount) {
        return toAjax(userAccountService.insertUserAccount(userAccount));
    }

    /**
     * 修改用户账户
     */
    @GetMapping("/edit/{accountId}")
    public String edit(@PathVariable("accountId") String accountId, ModelMap mmap) {
        UserAccount userAccount = userAccountService.selectUserAccountById(accountId);
        mmap.put("userAccount", userAccount);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户账户
     */
    @RequiresPermissions("bussiness:useraccount:edit")
    @Log(title = "用户账户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserAccount userAccount) {
        UserAccount userBean = userAccountService.selectUserAccountById(userAccount.getAccountId());
        if (userBean == null)
            return error("用户账户信息不存在");
        userBean.setAccountStatus(userAccount.getAccountStatus());
        userBean.setAccountRemarks(userAccount.getAccountRemarks());
        return toAjax(userAccountService.updateUserAccount(userBean));
    }

    /**
     * 删除用户账户
     */
    @RequiresPermissions("bussiness:useraccount:remove")
    @Log(title = "用户账户", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(userAccountService.deleteUserAccountByIds(ids));
    }
}
