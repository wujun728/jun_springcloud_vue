package com.zebra.bussiness.controller;

import com.zebra.bussiness.domain.CommodityOrderRefund;
import com.zebra.bussiness.service.ICommodityOrderRefundService;
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
 * 退款订单Controller
 * 
 * @author zebra
 * @date 2021-01-09
 */
@Controller
@RequestMapping("/bussiness/commodityorderrefund")
public class CommodityOrderRefundController extends BaseController {
    private String prefix = "bussiness/commodityorderrefund";

    @Autowired
    private ICommodityOrderRefundService commodityOrderRefundService;

    @RequiresPermissions("bussiness:commodityorderrefund:view")
    @GetMapping()
    public String commodityorderrefund()
    {
        return prefix + "/commodityorderrefund";
    }

    /**
     * 查询退款订单列表
     */
    @RequiresPermissions("bussiness:commodityorderrefund:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CommodityOrderRefund commodityOrderRefund)
    {
        startPage();
        List<CommodityOrderRefund> list = commodityOrderRefundService.selectCommodityOrderRefundList(commodityOrderRefund);
        return getDataTable(list);
    }

    /**
     * 导出退款订单列表
     */
    @RequiresPermissions("bussiness:commodityorderrefund:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CommodityOrderRefund commodityOrderRefund)
    {
        List<CommodityOrderRefund> list = commodityOrderRefundService.selectCommodityOrderRefundList(commodityOrderRefund);
        ExcelUtil<CommodityOrderRefund> util = new ExcelUtil<CommodityOrderRefund>(CommodityOrderRefund.class);
        return util.exportExcel(list, "commodityorderrefund");
    }

    /**
     * 新增退款订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存退款订单
     */
    @RequiresPermissions("bussiness:commodityorderrefund:add")
    @Log(title = "退款订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CommodityOrderRefund commodityOrderRefund)
    {
        return toAjax(commodityOrderRefundService.insertCommodityOrderRefund(commodityOrderRefund));
    }

    /**
     * 修改退款订单
     */
    @GetMapping("/edit/{refundId}")
    public String edit(@PathVariable("refundId") String refundId, ModelMap mmap)
    {
        CommodityOrderRefund commodityOrderRefund = commodityOrderRefundService.selectCommodityOrderRefundById(refundId);
        mmap.put("commodityOrderRefund", commodityOrderRefund);
        return prefix + "/edit";
    }

    /**
     * 修改保存退款订单
     */
    @RequiresPermissions("bussiness:commodityorderrefund:edit")
    @Log(title = "退款订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommodityOrderRefund commodityOrderRefund)
    {
        return toAjax(commodityOrderRefundService.updateCommodityOrderRefund(commodityOrderRefund));
    }

    /**
     * 删除退款订单
     */
    @RequiresPermissions("bussiness:commodityorderrefund:remove")
    @Log(title = "退款订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(commodityOrderRefundService.deleteCommodityOrderRefundByIds(ids));
    }
}
