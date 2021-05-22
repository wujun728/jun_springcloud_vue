package com.zebra.bussiness.cms.controller;

import com.zebra.bussiness.cms.domain.CmsCategory;
import com.zebra.bussiness.cms.service.ICmsCategoryService;
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
 * 文章分类Controller
 * 
 * @author zebra
 * @date 2020-06-24
 */
@Controller
@RequestMapping("/bussiness_cms/category")
public class CmsCategoryController extends BaseController {
    private String prefix = "bussiness_cms/category";

    @Autowired
    private ICmsCategoryService cmsCategoryService;

    @RequiresPermissions("bussiness_cms:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询文章分类树列表
     */
    @RequiresPermissions("bussiness_cms:category:list")
    @RequestMapping("/list")
    @ResponseBody
    public List<CmsCategory> list(CmsCategory cmsCategory)
    {
        List<CmsCategory> list = cmsCategoryService.selectCmsCategoryList(cmsCategory);
        return list;
    }

    /**
     * 导出文章分类列表
     */
    @RequiresPermissions("bussiness_cms:category:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsCategory cmsCategory)
    {
        List<CmsCategory> list = cmsCategoryService.selectCmsCategoryList(cmsCategory);
        ExcelUtil<CmsCategory> util = new ExcelUtil<CmsCategory>(CmsCategory.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 新增文章分类
     */
    @GetMapping(value = { "/add/{categoryId}", "/add/" })
    public String add(@PathVariable(value = "categoryId", required = false) String categoryId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(categoryId))
        {
            mmap.put("cmsCategory", cmsCategoryService.selectCmsCategoryById(Long.parseLong(categoryId)));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存文章分类
     */
    @RequiresPermissions("bussiness_cms:category:add")
    @Log(title = "文章分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsCategory cmsCategory)
    {
        return toAjax(cmsCategoryService.insertCmsCategory(cmsCategory));
    }

    /**
     * 修改文章分类
     */
    @GetMapping("/edit/{categoryId}")
    public String edit(@PathVariable("categoryId") Long categoryId, ModelMap mmap)
    {
        CmsCategory cmsCategory = cmsCategoryService.selectCmsCategoryById(categoryId);
        CmsCategory category = cmsCategoryService.selectCmsCategoryById(cmsCategory.getCategoryParentId());
        String parentName = category == null ? "" : category.getCategoryName();
        mmap.put("parentNamesCategory", parentName);
        mmap.put("cmsCategory", cmsCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章分类
     */
    @RequiresPermissions("bussiness_cms:category:edit")
    @Log(title = "文章分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsCategory cmsCategory)
    {
        return toAjax(cmsCategoryService.updateCmsCategory(cmsCategory));
    }

    /**
     * 删除
     */
    @RequiresPermissions("bussiness_cms:category:remove")
    @Log(title = "文章分类", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{categoryId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("categoryId") Long categoryId)
    {
        return toAjax(cmsCategoryService.deleteCmsCategoryById(categoryId));
    }

    /**
     * 选择文章分类树
     */
    @GetMapping(value = { "/selectCategoryTree/{categoryId}", "/selectCategoryTree/" })
    public String selectCategoryTree(@PathVariable(value = "categoryId", required = false) Long categoryId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(categoryId))
        {
            mmap.put("cmsCategory", cmsCategoryService.selectCmsCategoryById(categoryId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载文章分类树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = cmsCategoryService.selectCmsCategoryTree();
        return ztrees;
    }
}
