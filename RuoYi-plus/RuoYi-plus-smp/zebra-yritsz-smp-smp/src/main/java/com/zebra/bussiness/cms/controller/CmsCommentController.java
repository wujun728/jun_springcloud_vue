package com.zebra.bussiness.cms.controller;

import com.alibaba.fastjson.JSON;
import com.zebra.bussiness.cms.controller.extend.CmsCommentControllerExtend;
import com.zebra.bussiness.cms.domain.CmsBlacklist;
import com.zebra.bussiness.cms.domain.CmsComment;
import com.zebra.bussiness.cms.domain.page.CmsCommentPage;
import com.zebra.bussiness.cms.service.ICmsBlacklistService;
import com.zebra.bussiness.cms.service.ICmsCommentService;
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
 * 用户评论Controller
 *
 * @author zebra
 * @date 2020-06-30
 */
@Controller
@RequestMapping("/bussiness_cms/comment")
public class CmsCommentController extends CmsCommentControllerExtend {
    private String prefix = "bussiness_cms/comment";

    @Autowired
    private ICmsCommentService cmsCommentService;
    @Autowired
    private ICmsBlacklistService cmsBlacklistService;

    @RequiresPermissions("bussiness_cms:comment:view")
    @GetMapping()
    public String comment(ModelMap mmap) {
        super.merchantAuth(mmap);
        return prefix + "/comment";
    }

    @RequiresPermissions("bussiness_cms:comment:list")
    @GetMapping("/comment_list")
    public String comment_list(ModelMap mmap, String commentTid) {
        super.merchantAuth(mmap);
        mmap.addAttribute("commentTid", commentTid);
        return prefix + "/comment_list";
    }

    /**
     * 查询用户评论列表
     */
    @RequiresPermissions("bussiness_cms:comment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CmsComment cmsComment) {
        startPage();
        List<CmsComment> list = cmsCommentService.selectCmsCommentList(cmsComment);
        return getDataTable(super.getCmsCommentPage(list));
    }

    /**
     * 导出用户评论列表
     */
    @RequiresPermissions("bussiness_cms:comment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsComment cmsComment) {
        List<CmsComment> list = cmsCommentService.selectCmsCommentList(cmsComment);
        ExcelUtil<CmsCommentPage> util = new ExcelUtil<CmsCommentPage>(CmsCommentPage.class);
        return util.exportExcel(super.getCmsCommentPage(list), "用户评论");
    }

    /**
     * 新增用户评论
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户评论
     */
    @RequiresPermissions("bussiness_cms:comment:add")
    @Log(title = "用户评论", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsComment cmsComment) {
        return toAjax(cmsCommentService.insertCmsComment(cmsComment));
    }

    /**
     * 修改用户评论
     */
    @GetMapping("/edit/{commentId}")
    public String edit(@PathVariable("commentId") Long commentId, ModelMap mmap) {
        CmsComment cmsComment = cmsCommentService.selectCmsCommentById(commentId);
        mmap.put("cmsComment", cmsComment);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户评论
     */
    @RequiresPermissions("bussiness_cms:comment:edit")
    @Log(title = "用户评论", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsComment cmsComment) {
        CmsComment cm = cmsCommentService.selectCmsCommentById(cmsComment.getCommentId());
        if (cm == null)
            return error("信息不存在");
        cm.setCommentReply(cmsComment.getCommentReply());
        cm.setTopFlag(cmsComment.getTopFlag());
        cm.setUserStatus(cmsComment.getUserStatus());
        if (cm.getUserStatus() == 2) {
            cm.setTopFlag(0);

            CmsBlacklist cmsBlacklist = super.getBlackByAbuotId(String.valueOf(cm.getCommentId()), cm.getUserId());
            if (cmsBlacklist == null) {
                cmsBlacklist = new CmsBlacklist();
                cmsBlacklist.setBlacklistType(1);
                cmsBlacklist.setAubotId(String.valueOf(cm.getCommentId()));
                cmsBlacklist.setAubotInfo(cm.getCommentReply());
                cmsBlacklist.setUserId(cm.getUserId());
                cmsBlacklist.setMerchantId(cm.getMerchantId());
                cmsBlacklist.setOtherInfo(JSON.toJSONString(cm));
                cmsBlacklistService.insertCmsBlacklist(cmsBlacklist);
            } else {
                cmsBlacklist.setBlacklistType(1);
                cmsBlacklist.setAubotInfo(cm.getCommentReply());
                cmsBlacklistService.updateCmsBlacklist(cmsBlacklist);
            }
        } else if (cm.getUserStatus() == 1) {
            super.deleteBlackByAbuotId(String.valueOf(cm.getCommentId()), cm.getUserId());
        }
        return toAjax(cmsCommentService.updateCmsComment(cm));
    }

    /**
     * 删除用户评论
     */
    @RequiresPermissions("bussiness_cms:comment:remove")
    @Log(title = "用户评论", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cmsCommentService.deleteCmsCommentByIds(ids));
    }
}
