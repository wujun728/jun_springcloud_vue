package com.zebra.bussiness.controller;

import com.zebra.bussiness.controller.extend.CommodityOrderControllerExtend;
import com.zebra.bussiness.domain.CommodityOrder;
import com.zebra.bussiness.domain.page.CommodityOrderPage;
import com.zebra.bussiness.service.ICommodityOrderService;
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
 * 商品订单Controller
 *
 * @author zebra
 * @date 2020-08-18
 */
@Controller
@RequestMapping("/bussiness/commodityorder")
public class CommodityOrderController extends CommodityOrderControllerExtend {
    private String prefix = "bussiness/commodityorder";

    @Autowired
    private ICommodityOrderService commodityOrderService;

    @RequiresPermissions("bussiness:commodityorder:view")
    @GetMapping()
    public String commodityorder(ModelMap mmap) {
        super.merchantAuth(mmap);
        return prefix + "/commodityorder";
    }

    /**
     * 查询商品订单列表
     */
    @RequiresPermissions("bussiness:commodityorder:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CommodityOrder commodityOrder) {
        startPage();
        List<CommodityOrder> list = commodityOrderService.selectCommodityOrderList(commodityOrder);
        return getDataTable(super.getCommodityOrderPage(list));
    }

    /**
     * 导出商品订单列表
     */
    @RequiresPermissions("bussiness:commodityorder:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CommodityOrder commodityOrder) {
        List<CommodityOrder> list = commodityOrderService.selectCommodityOrderList(commodityOrder);
        ExcelUtil<CommodityOrderPage> util = new ExcelUtil<CommodityOrderPage>(CommodityOrderPage.class);
        return util.exportExcel(super.getCommodityOrderPage(list), "商品信息");
    }

    /**
     * 新增商品订单
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存商品订单
     */
    @RequiresPermissions("bussiness:commodityorder:add")
    @Log(title = "商品订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CommodityOrder commodityOrder) {
        return toAjax(commodityOrderService.insertCommodityOrder(commodityOrder));
    }

    /**
     * 修改商品订单
     */
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") String orderId, ModelMap mmap) {
        CommodityOrder commodityOrder = commodityOrderService.selectCommodityOrderById(orderId);
        mmap.put("commodityOrder", commodityOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品订单
     */
    @RequiresPermissions("bussiness:commodityorder:edit")
    @Log(title = "商品订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommodityOrder commodityOrder) {
        return commodityOrderService.updateCommodityOrder(commodityOrder);
    }

    /**
     * 删除商品订单
     */
    @RequiresPermissions("bussiness:commodityorder:remove")
    @Log(title = "商品订单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(commodityOrderService.deleteCommodityOrderByIds(ids));
    }
}
