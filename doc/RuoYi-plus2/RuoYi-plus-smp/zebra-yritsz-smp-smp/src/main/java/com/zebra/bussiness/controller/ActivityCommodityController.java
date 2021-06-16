package com.zebra.bussiness.controller;

import com.zebra.bussiness.controller.extend.ActivityCommodityExtend;
import com.zebra.bussiness.domain.ActivityCommodity;
import com.zebra.bussiness.service.IActivityCommodityService;
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
 * 参与活动商品Controller
 *
 * @author zebra
 * @date 2020-09-09
 */
@Controller
@RequestMapping("/bussiness/activitycommodity")
public class ActivityCommodityController extends ActivityCommodityExtend {
    private String prefix = "bussiness/activitycommodity";

    @Autowired
    private IActivityCommodityService activityCommodityService;

    @RequiresPermissions("bussiness:activitycommodity:view")
    @GetMapping()
    public String activitycommodity(ModelMap mmap) {
        super.merchantAuth(mmap);
        super.getActivity(mmap);
        return prefix + "/activitycommodity";
    }

    /**
     * 查询参与活动商品列表
     */
    @RequiresPermissions("bussiness:activitycommodity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ActivityCommodity activityCommodity) {
        startPage();
        List<ActivityCommodity> list = activityCommodityService.selectActivityCommodityList(activityCommodity);
        return getDataTable(super.getActivityCommodityPage(list));
    }

    /**
     * 导出参与活动商品列表
     */
    @RequiresPermissions("bussiness:activitycommodity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ActivityCommodity activityCommodity) {
        List<ActivityCommodity> list = activityCommodityService.selectActivityCommodityList(activityCommodity);
        ExcelUtil<ActivityCommodity> util = new ExcelUtil<ActivityCommodity>(ActivityCommodity.class);
        return util.exportExcel(list, "activitycommodity");
    }

    /**
     * 新增参与活动商品
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存参与活动商品
     */
    @RequiresPermissions("bussiness:activitycommodity:add")
    @Log(title = "参与活动商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ActivityCommodity activityCommodity) {
        return toAjax(activityCommodityService.insertActivityCommodity(activityCommodity));
    }

    /**
     * 修改参与活动商品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        ActivityCommodity activityCommodity = activityCommodityService.selectActivityCommodityById(id);
        mmap.put("activityCommodity", super.getActivityCommodityPage(activityCommodity));
        return prefix + "/edit";
    }

    /**
     * 修改保存参与活动商品
     */
    @RequiresPermissions("bussiness:activitycommodity:edit")
    @Log(title = "参与活动商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ActivityCommodity activityCommodity) {
        return toAjax(activityCommodityService.updateActivityCommodity(activityCommodity));
    }

    /**
     * 删除参与活动商品
     */
    @RequiresPermissions("bussiness:activitycommodity:remove")
    @Log(title = "参与活动商品", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(activityCommodityService.deleteActivityCommodityByIds(ids));
    }
}
