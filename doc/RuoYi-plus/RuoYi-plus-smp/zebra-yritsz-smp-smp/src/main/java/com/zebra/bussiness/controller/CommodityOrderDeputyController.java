package com.zebra.bussiness.controller;

import com.zebra.bussiness.controller.extend.CommodityOrderDeputyDeputyControllerExtend;
import com.zebra.bussiness.domain.CommodityOrderDeputy;
import com.zebra.bussiness.domain.page.CommodityOrderDeputyPage;
import com.zebra.bussiness.service.ICommodityOrderDeputyService;
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
 * 订单辅助Controller
 *
 * @author zebra
 * @date 2021-01-09
 */
@Controller
@RequestMapping("/bussiness/commodityorderdeputy")
public class CommodityOrderDeputyController extends CommodityOrderDeputyDeputyControllerExtend {
    private String prefix = "bussiness/commodityorderdeputy";

    @Autowired
    private ICommodityOrderDeputyService commodityOrderDeputyService;

    @RequiresPermissions("bussiness:commodityorderdeputy:view")
    @GetMapping()
    public String commodityorderdeputy() {
        return prefix + "/commodityorderdeputy";
    }

    /**
     * 查询订单辅助列表
     */
    @RequiresPermissions("bussiness:commodityorderdeputy:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CommodityOrderDeputy commodityOrderDeputy) {
        startPage();
        List<CommodityOrderDeputy> list = commodityOrderDeputyService.selectCommodityOrderDeputyList(commodityOrderDeputy);
        return getDataTable(super.getCommodityOrderDeputyPage(list));
    }

    /**
     * 导出订单辅助列表
     */
    @RequiresPermissions("bussiness:commodityorderdeputy:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CommodityOrderDeputy commodityOrderDeputy) {
        List<CommodityOrderDeputy> list = commodityOrderDeputyService.selectCommodityOrderDeputyList(commodityOrderDeputy);
        ExcelUtil<CommodityOrderDeputyPage> util = new ExcelUtil<CommodityOrderDeputyPage>(CommodityOrderDeputyPage.class);
        return util.exportExcel(super.getCommodityOrderDeputyPage(list), "订单信息");
    }

    /**
     * 新增订单辅助
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存订单辅助
     */
    @RequiresPermissions("bussiness:commodityorderdeputy:add")
    @Log(title = "订单辅助", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CommodityOrderDeputy commodityOrderDeputy) {
        return toAjax(commodityOrderDeputyService.insertCommodityOrderDeputy(commodityOrderDeputy));
    }

    /**
     * 修改订单辅助
     */
    @GetMapping("/edit/{deputyId}")
    public String edit(@PathVariable("deputyId") String deputyId, ModelMap mmap) {
        CommodityOrderDeputy commodityOrderDeputy = commodityOrderDeputyService.selectCommodityOrderDeputyById(deputyId);
        mmap.put("commodityOrderDeputy", commodityOrderDeputy);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单辅助
     */
    @RequiresPermissions("bussiness:commodityorderdeputy:edit")
    @Log(title = "订单辅助", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommodityOrderDeputy commodityOrderDeputy) {
        return toAjax(commodityOrderDeputyService.updateCommodityOrderDeputy(commodityOrderDeputy));
    }

    /**
     * 删除订单辅助
     */
    @RequiresPermissions("bussiness:commodityorderdeputy:remove")
    @Log(title = "订单辅助", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(commodityOrderDeputyService.deleteCommodityOrderDeputyByIds(ids));
    }
}
