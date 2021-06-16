package com.zebra.bussiness.controller;

import com.zebra.bussiness.domain.CommodityCategory;
import com.zebra.bussiness.service.ICommodityCategoryService;
import com.zebra.common.annotation.Log;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.core.domain.Ztree;
import com.zebra.common.enums.BusinessType;
import com.zebra.common.utils.StringUtils;
import com.zebra.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产品类别Controller
 * 
 * @author zebra
 * @date 2020-07-01
 */
@Controller
@RequestMapping("/bussiness/commoditycategory")
public class CommodityCategoryController extends BaseController {
    private String prefix = "bussiness/commoditycategory";

    @Autowired
    private ICommodityCategoryService commodityCategoryService;

    @RequiresPermissions("bussiness:commoditycategory:view")
    @GetMapping()
    public String commoditycategory()
    {
        return prefix + "/commoditycategory";
    }

    /**
     * 查询产品类别树列表
     */
    @RequiresPermissions("bussiness:commoditycategory:list")
    @RequestMapping("/list")
    @ResponseBody
    public List<CommodityCategory> list(CommodityCategory commodityCategory)
    {
        List<CommodityCategory> list = commodityCategoryService.selectCommodityCategoryList(commodityCategory);
        return list;
    }

    /**
     * 导出产品类别列表
     */
    @RequiresPermissions("bussiness:commoditycategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CommodityCategory commodityCategory)
    {
        List<CommodityCategory> list = commodityCategoryService.selectCommodityCategoryList(commodityCategory);
        ExcelUtil<CommodityCategory> util = new ExcelUtil<CommodityCategory>(CommodityCategory.class);
        return util.exportExcel(list, "commoditycategory");
    }

    /**
     * 新增产品类别
     */
    @GetMapping(value = { "/add/{categoryId}", "/add/" })
    public String add(@PathVariable(value = "categoryId", required = false) Long categoryId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(categoryId))
        {
            mmap.put("commodityCategory", commodityCategoryService.selectCommodityCategoryById(categoryId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存产品类别
     */
    @RequiresPermissions("bussiness:commoditycategory:add")
    @Log(title = "产品类别", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CommodityCategory commodityCategory)
    {
        return toAjax(commodityCategoryService.insertCommodityCategory(commodityCategory));
    }

    /**
     * 修改产品类别
     */
    @GetMapping("/edit/{categoryId}")
    public String edit(@PathVariable("categoryId") Long categoryId, ModelMap mmap)
    {
        CommodityCategory commodityCategory = commodityCategoryService.selectCommodityCategoryById(categoryId);
        CommodityCategory pInfo=commodityCategoryService.selectCommodityCategoryById(commodityCategory.getCategoryParid());
        String parentName=null;
        if(pInfo!=null){
            parentName=pInfo.getCategoryName();
        }
        mmap.put("parentName", parentName);
        mmap.put("commodityCategory", commodityCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品类别
     */
    @RequiresPermissions("bussiness:commoditycategory:edit")
    @Log(title = "产品类别", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommodityCategory commodityCategory)
    {
        return toAjax(commodityCategoryService.updateCommodityCategory(commodityCategory));
    }

    /**
     * 删除
     */
    @RequiresPermissions("bussiness:commoditycategory:remove")
    @Log(title = "产品类别", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{categoryId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("categoryId") Long categoryId)
    {
        return toAjax(commodityCategoryService.deleteCommodityCategoryById(categoryId));
    }

    /**
     * 选择产品类别树
     */
    @GetMapping(value = { "/selectCommoditycategoryTree/{categoryId}", "/selectCommoditycategoryTree/" })
    public String selectCommoditycategoryTree(@PathVariable(value = "categoryId", required = false) Long categoryId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(categoryId))
        {
            mmap.put("commodityCategory", commodityCategoryService.selectCommodityCategoryById(categoryId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载产品类别树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = commodityCategoryService.selectCommodityCategoryTree();
        return ztrees;
    }
}
