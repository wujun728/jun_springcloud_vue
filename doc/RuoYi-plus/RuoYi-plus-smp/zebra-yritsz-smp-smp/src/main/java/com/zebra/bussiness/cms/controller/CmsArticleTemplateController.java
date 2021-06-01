package com.zebra.bussiness.cms.controller;

import java.util.List;

import com.zebra.common.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zebra.common.annotation.Log;
import com.zebra.common.enums.BusinessType;
import com.zebra.bussiness.cms.domain.CmsArticleTemplate;
import com.zebra.bussiness.cms.service.ICmsArticleTemplateService;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.utils.poi.ExcelUtil;
import com.zebra.common.core.page.TableDataInfo;

/**
 * 文章模板Controller
 *
 * @author zebra
 * @date 2020-07-28
 */
@Controller
@RequestMapping("/bussiness_cms/articletemplate")
public class CmsArticleTemplateController extends BaseController {
    private String prefix = "bussiness_cms/articletemplate";

    @Autowired
    private ICmsArticleTemplateService cmsArticleTemplateService;

    @RequiresPermissions("bussiness_cms:articletemplate:view")
    @GetMapping()
    public String articletemplate() {
        return prefix + "/articletemplate";
    }

    /**
     * 查询文章模板列表
     */
    @RequiresPermissions("bussiness_cms:articletemplate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CmsArticleTemplate cmsArticleTemplate) {
        startPage();
        List<CmsArticleTemplate> list = cmsArticleTemplateService.selectCmsArticleTemplateList(cmsArticleTemplate);
        return getDataTable(list);
    }

    /**
     * 导出文章模板列表
     */
    @RequiresPermissions("bussiness_cms:articletemplate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsArticleTemplate cmsArticleTemplate) {
        List<CmsArticleTemplate> list = cmsArticleTemplateService.selectCmsArticleTemplateList(cmsArticleTemplate);
        ExcelUtil<CmsArticleTemplate> util = new ExcelUtil<CmsArticleTemplate>(CmsArticleTemplate.class);
        return util.exportExcel(list, "articletemplate");
    }

    /**
     * 新增文章模板
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存文章模板
     */
    @RequiresPermissions("bussiness_cms:articletemplate:add")
    @Log(title = "文章模板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsArticleTemplate cmsArticleTemplate) {
        return toAjax(cmsArticleTemplateService.insertCmsArticleTemplate(cmsArticleTemplate));
    }

    /**
     * 修改文章模板
     */
    @GetMapping("/edit/{templeId}")
    public String edit(@PathVariable("templeId") Long templeId, ModelMap mmap) {
        CmsArticleTemplate cmsArticleTemplate = cmsArticleTemplateService.selectCmsArticleTemplateById(templeId);
        mmap.put("cmsArticleTemplate", cmsArticleTemplate);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章模板
     */
    @RequiresPermissions("bussiness_cms:articletemplate:edit")
    @Log(title = "文章模板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsArticleTemplate cmsArticleTemplate) {
        return toAjax(cmsArticleTemplateService.updateCmsArticleTemplate(cmsArticleTemplate));
    }

    /**
     * 删除文章模板
     */
    @RequiresPermissions("bussiness_cms:articletemplate:remove")
    @Log(title = "文章模板", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cmsArticleTemplateService.deleteCmsArticleTemplateByIds(ids));
    }


    /**
     * 审核文章模板
     */
    @GetMapping("/examine/{templeId}")
    public String examine(@PathVariable("templeId") Long templeId, ModelMap mmap) {
        CmsArticleTemplate cmsArticleTemplate = cmsArticleTemplateService.selectCmsArticleTemplateById(templeId);
        mmap.put("cmsArticleTemplate", cmsArticleTemplate);
        return prefix + "/examine";
    }

    /**
     * 审核保存活动信息
     */
    @RequiresPermissions("bussiness_cms:articletemplate:examine")
    @Log(title = "文章模板", businessType = BusinessType.EXAMINE)
    @PostMapping("/examine")
    @ResponseBody
    public AjaxResult examineSave(CmsArticleTemplate cmsArticleTemplate) {
        CmsArticleTemplate ainfo = cmsArticleTemplateService.selectCmsArticleTemplateById(cmsArticleTemplate.getTempleId());
        if (ainfo == null) {
            return error("文章模板信息不存在");
        }
        ainfo.setAuditState(cmsArticleTemplate.getAuditState());
        ainfo.setAuditReason(cmsArticleTemplate.getAuditReason());
        ainfo.setAuditTime(DateUtils.getNowDate());
        return toAjax(cmsArticleTemplateService.updateCmsArticleTemplate(ainfo));
    }

    @GetMapping("/templateList")
    public String articleTemplateList() {
        return prefix + "/articleTemplateList";
    }
}
