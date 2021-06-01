package com.zebra.bussiness.controller;

import com.zebra.bussiness.controller.extend.CommodityInfoControllerExtend;
import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.bussiness.domain.Merchaninfo;
import com.zebra.bussiness.domain.page.CommodityInfoPage;
import com.zebra.bussiness.service.ICommodityInfoService;
import com.zebra.common.annotation.Log;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.core.page.TableDataInfo;
import com.zebra.common.enums.BusinessType;
import com.zebra.common.utils.UidUtils;
import com.zebra.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 产品信息Controller
 *
 * @author zebra
 * @date 2020-06-11
 */
@Controller
@RequestMapping("/bussiness/commodityinfo")
public class CommodityInfoController extends CommodityInfoControllerExtend {
    private String prefix = "bussiness/commodityinfo";

    @Autowired
    private ICommodityInfoService commodityInfoService;

    @RequiresPermissions("bussinescategoryNames:commodityinfo:view")
    @GetMapping()
    public String commodityinfo(ModelMap mmap) {
        super.merchantAuth(mmap);
        return prefix + "/commodityinfo";
    }

    /**
     * 查询产品信息列表
     */
    @RequiresPermissions("bussiness:commodityinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CommodityInfo commodityInfo) {
        startPage();
        List<CommodityInfo> list = commodityInfoService.selectCommodityInfoList(commodityInfo);
        return getDataTable(super.getCommodityInfoPage(list));
    }

    /**
     * 导出产品信息列表
     */
    @RequiresPermissions("bussiness:commodityinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CommodityInfo commodityInfo) {
        List<CommodityInfo> list = commodityInfoService.selectCommodityInfoList(commodityInfo);
        ExcelUtil<CommodityInfoPage> util = new ExcelUtil<CommodityInfoPage>(CommodityInfoPage.class);
        return util.exportExcel(super.getCommodityInfoPage(list), "产品信息");
    }

    /**
     * 新增产品信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.addAttribute("specsTypeList", super.getSpecsTypeList());
        super.merchantAuth(mmap);
        return prefix + "/add";
    }

    /**
     * 新增保存产品信息
     */
    @RequiresPermissions("bussiness:commodityinfo:add")
    @Log(title = "产品信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CommodityInfo commodityInfo, @RequestParam("pic_file") MultipartFile pic_file) {
        commodityInfo.setCommodityId(UidUtils.getUUID(true));
        String fileUrl = super.saveFile(pic_file, commodityInfo.getCommodityId(), prefix, true);
        commodityInfo.setCommodityImg(fileUrl);
        Merchaninfo merchaninfo = super.getMerchantById(commodityInfo.getMerchantId());
        if (merchaninfo.getCommodityEquity() == 2) {
            commodityInfo.setExamineStatus(1);
        } else {
            commodityInfo.setExamineStatus(2);
        }
        return toAjax(commodityInfoService.insertCommodityInfo(commodityInfo));
    }

    /**
     * 修改产品信息
     */
    @GetMapping("/edit/{commodityId}")
    public String edit(@PathVariable("commodityId") String commodityId, ModelMap mmap) {
        super.merchantAuth(mmap);
        CommodityInfo commodityInfo = commodityInfoService.selectCommodityInfoById(commodityId);
        mmap.put("commodityInfo", commodityInfo);
        mmap.put("categoryName", super.getCategoryName(commodityInfo.getCategoryId()));

        return prefix + "/edit";
    }

    /**
     * 修改保存产品信息
     */
    @RequiresPermissions("bussiness:commodityinfo:edit")
    @Log(title = "产品信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommodityInfo commodityInfo, @RequestParam("pic_file") MultipartFile pic_file) {
        CommodityInfo info = commodityInfoService.selectCommodityInfoById(commodityInfo.getCommodityId());
        if (info == null)
            return error("产品信息不存在");
        super.getMerchantById(info.getMerchantId());
        commodityInfo.setMerchantId(info.getMerchantId());
        String fileUrl = super.saveFile(pic_file, commodityInfo.getCommodityId(), prefix, false);
        commodityInfo.setCommodityImg(fileUrl);
        commodityInfo.setExamineStatus(info.getExamineStatus());
        commodityInfo.setExamineDesc(null);
        commodityInfo.setMerchantId(info.getMerchantId());
        return toAjax(commodityInfoService.updateCommodityInfo(commodityInfo));
    }

    /**
     * 删除产品信息
     */
    @RequiresPermissions("bussiness:commodityinfo:remove")
    @Log(title = "产品信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(commodityInfoService.deleteCommodityInfoByIds(ids));
    }

    /**
     * 审核活动信息
     */
    @GetMapping("/examine/{commodityId}")
    public String examine(@PathVariable("commodityId") String commodityId, ModelMap mmap) {
        CommodityInfo commodityInfo = commodityInfoService.selectCommodityInfoById(commodityId);
        mmap.put("commodityInfo", commodityInfo);
        return prefix + "/examine";
    }

    /**
     * 审核保存商品信息
     */
    @RequiresPermissions("bussiness:commodityinfo:examine")
    @Log(title = "活动信息", businessType = BusinessType.EXAMINE)
    @PostMapping("/examine")
    @ResponseBody
    public AjaxResult examineSave(CommodityInfo commodityInfo) {
        CommodityInfo info = commodityInfoService.selectCommodityInfoById(commodityInfo.getCommodityId());
        if (info == null) {
            return error("商品信息不存在");
        }
        super.getMerchantById(info.getMerchantId());
        info.setExamineDesc(commodityInfo.getExamineDesc());
        info.setExamineStatus(commodityInfo.getExamineStatus());
        return toAjax(commodityInfoService.updateCommodityInfo(info));
    }
}