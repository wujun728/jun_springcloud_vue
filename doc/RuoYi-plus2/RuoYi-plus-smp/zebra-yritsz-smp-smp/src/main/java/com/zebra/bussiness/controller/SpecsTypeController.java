package com.zebra.bussiness.controller;

import com.zebra.bussiness.domain.SpecsType;
import com.zebra.bussiness.service.ISpecsTypeService;
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
 * 规格类型Controller
 * 
 * @author zebra
 * @date 2020-09-15
 */
@Controller
@RequestMapping("/bussiness/specstype")
public class SpecsTypeController extends BaseController {
    private String prefix = "bussiness/specstype";

    @Autowired
    private ISpecsTypeService specsTypeService;

    @RequiresPermissions("bussiness:specstype:view")
    @GetMapping()
    public String specstype()
    {
        return prefix + "/specstype";
    }

    /**
     * 查询规格类型列表
     */
    @RequiresPermissions("bussiness:specstype:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SpecsType specsType)
    {
        startPage();
        List<SpecsType> list = specsTypeService.selectSpecsTypeList(specsType);
        return getDataTable(list);
    }

    /**
     * 导出规格类型列表
     */
    @RequiresPermissions("bussiness:specstype:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SpecsType specsType)
    {
        List<SpecsType> list = specsTypeService.selectSpecsTypeList(specsType);
        ExcelUtil<SpecsType> util = new ExcelUtil<SpecsType>(SpecsType.class);
        return util.exportExcel(list, "specstype");
    }

    /**
     * 新增规格类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存规格类型
     */
    @RequiresPermissions("bussiness:specstype:add")
    @Log(title = "规格类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SpecsType specsType)
    {
        return toAjax(specsTypeService.insertSpecsType(specsType));
    }

    /**
     * 修改规格类型
     */
    @GetMapping("/edit/{specsTypeId}")
    public String edit(@PathVariable("specsTypeId") String specsTypeId, ModelMap mmap)
    {
        SpecsType specsType = specsTypeService.selectSpecsTypeById(specsTypeId);
        mmap.put("specsType", specsType);
        return prefix + "/edit";
    }

    /**
     * 修改保存规格类型
     */
    @RequiresPermissions("bussiness:specstype:edit")
    @Log(title = "规格类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SpecsType specsType)
    {
        return toAjax(specsTypeService.updateSpecsType(specsType));
    }

    /**
     * 删除规格类型
     */
    @RequiresPermissions("bussiness:specstype:remove")
    @Log(title = "规格类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(specsTypeService.deleteSpecsTypeByIds(ids));
    }
}
