package com.zebra.bussiness.cms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zebra.bussiness.cms.controller.extend.CmsArticleControllerExtend;
import com.zebra.bussiness.cms.domain.CmsArticleTemplate;
import com.zebra.bussiness.cms.domain.CmsCategory;
import com.zebra.bussiness.cms.domain.page.CmsArticlePage;
import com.zebra.common.exception.BusinessException;
import com.zebra.common.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zebra.common.annotation.Log;
import com.zebra.common.enums.BusinessType;
import com.zebra.bussiness.cms.domain.CmsArticle;
import com.zebra.bussiness.cms.service.ICmsArticleService;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.utils.poi.ExcelUtil;
import com.zebra.common.core.page.TableDataInfo;
import org.springframework.web.util.HtmlUtils;

/**
 * 文章信息Controller
 *
 * @author zebra
 * @date 2020-06-25
 */
@Controller
@RequestMapping("/bussiness_cms/article")
public class CmsArticleController extends CmsArticleControllerExtend {
    private String prefix = "bussiness_cms/article";

    @Autowired
    private ICmsArticleService cmsArticleService;

    @RequiresPermissions("bussiness_cms:article:view")
    @GetMapping()
    public String article(ModelMap mmap) {
        super.merchantAuth(mmap);
        return prefix + "/article";
    }

    /**
     * 查询文章信息列表
     */
    @RequiresPermissions("bussiness_cms:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CmsArticlePage cmsArticle) {
        startPage();
        List<CmsArticle> list = cmsArticleService.selectCmsArticleList(cmsArticle);
        return getDataTable(super.getCmsArticlePage(list));
    }

    /**
     * 导出文章信息列表
     */
    @RequiresPermissions("bussiness_cms:article:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsArticle cmsArticle) {
        List<CmsArticle> list = cmsArticleService.selectCmsArticleList(cmsArticle);
        ExcelUtil<CmsArticlePage> util = new ExcelUtil<CmsArticlePage>(CmsArticlePage.class);
        return util.exportExcel(super.getCmsArticlePage(list), "文章信息");
    }

    @RequestMapping("/detail/{id}")
    public String article_detail(@PathVariable String id, Model model) {
        CmsArticlePage article = super.getCmsArticlePage(cmsArticleService.selectCmsArticleById(id));
        if (article == null) {
            throw new BusinessException("您要访问的文章不存在!");
        }
        model.addAttribute("fullTabs", null);
        model.addAttribute("tagsList", null);//这个值用于输出模板文件的标签
        Map dataMap = JSONObject.parseObject(JSON.toJSONString(article), Map.class);
        model.addAllAttributes(dataMap);
        return prefix + "/article-duoguyu";

    }

    /**
     * 新增文章信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        super.merchantAuth(mmap);
        return prefix + "/add";
    }

    /**
     * 新增保存文章信息
     */
    @RequiresPermissions("bussiness_cms:article:add")
    @Log(title = "文章信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsArticlePage cmsArticle) {
        return toAjax(cmsArticleService.insertCmsArticle(cmsArticle));
    }

    /**
     * 修改文章信息
     */
    @GetMapping("/edit/{articleId}")
    public String edit(@PathVariable("articleId") String articleId, ModelMap mmap) {
        CmsArticle cmsArticle = cmsArticleService.selectCmsArticleById(articleId);
        mmap.put("cmsArticle", cmsArticle);
        mmap.put("categoryName", super.getCategoryName(cmsArticle.getCategoryId()));
        mmap.put("materialName", super.getCmsMaterialName(cmsArticle.getMaterialId()));
        mmap.put("content", super.getCmsArticleContent(cmsArticle.getArticleId()));
        super.merchantAuth(mmap);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章信息
     */
    @RequiresPermissions("bussiness_cms:article:edit")
    @Log(title = "文章信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsArticlePage cmsArticle) {
        return toAjax(cmsArticleService.updateCmsArticle(cmsArticle));
    }

    /**
     * 删除文章信息
     */
    @RequiresPermissions("bussiness_cms:article:remove")
    @Log(title = "文章信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cmsArticleService.deleteCmsArticleByIds(ids));
    }

    /**
     * 审核文章信息
     */
    @GetMapping("/examine/{articleId}")
    public String examine(@PathVariable("articleId") String articleId, ModelMap mmap) {
        CmsArticle cmsArticle = cmsArticleService.selectCmsArticleById(articleId);
        mmap.put("cmsArticle", cmsArticle);
        return prefix + "/examine";
    }

    /**
     * 审核保存活动信息
     */
    @RequiresPermissions("bussiness_cms:articletemplate:examine")
    @Log(title = "文章信息", businessType = BusinessType.EXAMINE)
    @PostMapping("/examine")
    @ResponseBody
    public AjaxResult examineSave(CmsArticle cmsArticle) {
        CmsArticle ainfo = cmsArticleService.selectCmsArticleById(cmsArticle.getArticleId());
        if (ainfo == null) {
            return error("文章信息信息不存在");
        }
        ainfo.setArticleStatus(cmsArticle.getArticleStatus());
        CmsArticlePage cmsArticlePage = new CmsArticlePage();
        BeanUtils.copyProperties(ainfo, cmsArticlePage);
        return toAjax(cmsArticleService.updateCmsArticle(cmsArticlePage));
    }
}
