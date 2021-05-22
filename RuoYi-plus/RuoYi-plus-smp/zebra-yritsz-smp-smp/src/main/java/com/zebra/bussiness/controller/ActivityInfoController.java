package com.zebra.bussiness.controller;

import com.zebra.bussiness.controller.extend.ActivityInfoControllerExtend;
import com.zebra.bussiness.domain.ActivityInfo;
import com.zebra.bussiness.service.IActivityInfoService;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 活动信息Controller
 *
 * @author zebra
 * @date 2020-09-09
 */
@Controller
@RequestMapping("/bussiness/activityinfo")
public class ActivityInfoController extends ActivityInfoControllerExtend {
    private String prefix = "bussiness/activityinfo";

    @Autowired
    private IActivityInfoService activityInfoService;

    @RequiresPermissions("bussiness:activityinfo:view")
    @GetMapping()
    public String activityinfo() {
        return prefix + "/activityinfo";
    }

    /**
     * 查询活动信息列表
     */
    @RequiresPermissions("bussiness:activityinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActivityInfo activityInfo) {
        startPage();
        List<ActivityInfo> list = activityInfoService.selectActivityInfoList(activityInfo);
        return getDataTable(super.getActivityInfoPage(list));
    }

    /**
     * 导出活动信息列表
     */
    @RequiresPermissions("bussiness:activityinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActivityInfo activityInfo) {
        List<ActivityInfo> list = activityInfoService.selectActivityInfoList(activityInfo);
        ExcelUtil<ActivityInfo> util = new ExcelUtil<ActivityInfo>(ActivityInfo.class);
        return util.exportExcel(list, "activityinfo");
    }

    /**
     * 新增活动信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存活动信息
     */
    @RequiresPermissions("bussiness:activityinfo:add")
    @Log(title = "活动信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActivityInfo activityInfo, @RequestParam("pic_file") MultipartFile pic_file) {
        activityInfo.setActivityId(super.getUid());
        String fileUrl = super.saveFile(pic_file, activityInfo.getActivityId(), prefix, true);
        activityInfo.setActivityImg(fileUrl);
        return toAjax(activityInfoService.insertActivityInfo(activityInfo));
    }

    /**
     * 修改活动信息
     */
    @GetMapping("/edit/{activityId}")
    public String edit(@PathVariable("activityId") String activityId, ModelMap mmap) {
        ActivityInfo activityInfo = activityInfoService.selectActivityInfoById(activityId);
        mmap.put("activityInfo", activityInfo);
        mmap.put("categoryName", super.getCategoryName(String.valueOf(activityInfo.getCategoryId())));
        return prefix + "/edit";
    }

    /**
     * 修改保存活动信息
     */
    @RequiresPermissions("bussiness:activityinfo:edit")
    @Log(title = "活动信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActivityInfo activityInfo, @RequestParam("pic_file") MultipartFile pic_file) {
        String fileUrl = super.saveFile(pic_file, activityInfo.getActivityId(), prefix, false);
        activityInfo.setActivityImg(fileUrl);
        return toAjax(activityInfoService.updateActivityInfo(activityInfo));
    }

    /**
     * 删除活动信息
     */
    @RequiresPermissions("bussiness:activityinfo:remove")
    @Log(title = "活动信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(activityInfoService.deleteActivityInfoByIds(ids));
    }
}
