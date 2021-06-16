package com.zebra.bussiness.cms.controller;

import com.zebra.bussiness.cms.controller.extend.CmsBlacklistControllerExtend;
import com.zebra.bussiness.cms.domain.CmsBlacklist;
import com.zebra.bussiness.cms.domain.page.CmsBlacklistPage;
import com.zebra.bussiness.cms.service.ICmsBlacklistService;
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
 * 黑名单Controller
 *
 * @author zebra
 * @date 2020-06-30
 */
@Controller
@RequestMapping("/bussiness_cms/blacklist")
public class CmsBlacklistController extends CmsBlacklistControllerExtend {
    private String prefix = "bussiness_cms/blacklist";

    @Autowired
    private ICmsBlacklistService cmsBlacklistService;

    @RequiresPermissions("bussiness_cms:blacklist:view")
    @GetMapping()
    public String blacklist(ModelMap mmap) {
        super.merchantAuth(mmap);

        return prefix + "/blacklist";
    }

    /**
     * 查询黑名单列表
     */
    @RequiresPermissions("bussiness_cms:blacklist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CmsBlacklist cmsBlacklist) {
        startPage();
        List<CmsBlacklist> list = cmsBlacklistService.selectCmsBlacklistList(cmsBlacklist);
        return getDataTable(super.getCmsBlacklistPage(list));
    }

    /**
     * 导出黑名单列表
     */
    @RequiresPermissions("bussiness_cms:blacklist:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsBlacklist cmsBlacklist) {
        List<CmsBlacklist> list = cmsBlacklistService.selectCmsBlacklistList(cmsBlacklist);
        ExcelUtil<CmsBlacklistPage> util = new ExcelUtil<CmsBlacklistPage>(CmsBlacklistPage.class);
        return util.exportExcel(super.getCmsBlacklistPage(list), "用户黑名单");
    }

    /**
     * 新增黑名单
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存黑名单
     */
    @RequiresPermissions("bussiness_cms:blacklist:add")
    @Log(title = "黑名单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsBlacklist cmsBlacklist) {
        return toAjax(cmsBlacklistService.insertCmsBlacklist(cmsBlacklist));
    }

    /**
     * 修改黑名单
     */
    @GetMapping("/edit/{blacklistId}")
    public String edit(@PathVariable("blacklistId") Integer blacklistId, ModelMap mmap) {
        CmsBlacklist cmsBlacklist = cmsBlacklistService.selectCmsBlacklistById(blacklistId);
        mmap.put("cmsBlacklist", cmsBlacklist);
        return prefix + "/edit";
    }

    /**
     * 修改保存黑名单
     */
    @RequiresPermissions("bussiness_cms:blacklist:edit")
    @Log(title = "黑名单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsBlacklist cmsBlacklist) {
        return toAjax(cmsBlacklistService.updateCmsBlacklist(cmsBlacklist));
    }

    /**
     * 删除黑名单
     */
    @RequiresPermissions("bussiness_cms:blacklist:remove")
    @Log(title = "黑名单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cmsBlacklistService.deleteCmsBlacklistByIds(ids));
    }
}
