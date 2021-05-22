package com.zebra.bussiness.cms.controller;

import java.util.List;

import com.zebra.bussiness.cms.controller.extend.CmsMaterialControllerExtend;
import com.zebra.bussiness.cms.domain.page.CmsMaterialPage;
import com.zebra.bussiness.domain.Merchaninfo;
import com.zebra.bussiness.service.impl.extend.BaseServiceImplExtend;
import com.zebra.common.config.ConfigServerApplication;
import com.zebra.common.utils.DateUtils;
import com.zebra.common.utils.StringUtils;
import com.zebra.common.utils.UidUtils;
import com.zebra.common.utils.file.FileUploadUtils;
import com.zebra.common.utils.file.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.zebra.common.annotation.Log;
import com.zebra.common.enums.BusinessType;
import com.zebra.bussiness.cms.domain.CmsMaterial;
import com.zebra.bussiness.cms.service.ICmsMaterialService;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.utils.poi.ExcelUtil;
import com.zebra.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

/**
 * 素材信息Controller
 *
 * @author zebra
 * @date 2020-06-24
 */
@Controller
@Slf4j
@RequestMapping("/bussiness_cms/material")
public class CmsMaterialController extends CmsMaterialControllerExtend {
    private String prefix = "bussiness_cms/material";

    @Autowired
    private ICmsMaterialService cmsMaterialService;
    @Autowired
    private ConfigServerApplication configServerApplication;


    @RequiresPermissions("bussiness_cms:material:view")
    @GetMapping()
    public String material(ModelMap mmap) {
        super.merchantAuth(mmap);
        return prefix + "/material";
    }

    @GetMapping("material_group")
    public String material_group(ModelMap mmap) {
        super.merchantAuth(mmap);
        return prefix + "/material_group";
    }
    /**
     * 查询素材信息列表
     */
    @RequiresPermissions("bussiness_cms:material:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CmsMaterial cmsMaterial) {
        startPage();
        List<CmsMaterial> list = cmsMaterialService.selectCmsMaterialList(cmsMaterial);
        return getDataTable(super.getCmsMaterialPage(list));
    }

    /**
     * 导出素材信息列表
     */
    @RequiresPermissions("bussiness_cms:material:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsMaterial cmsMaterial) {
        List<CmsMaterial> list = cmsMaterialService.selectCmsMaterialList(cmsMaterial);
        ExcelUtil<CmsMaterialPage> util = new ExcelUtil<CmsMaterialPage>(CmsMaterialPage.class);
        return util.exportExcel(super.getCmsMaterialPage(list), "material");
    }

    /**
     * 新增素材信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        super.merchantAuth(mmap);
        return prefix + "/add";
    }

    /**
     * 新增保存素材信息
     */
    @RequiresPermissions("bussiness_cms:material:add")
    @Log(title = "素材信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsMaterial cmsMaterial, @RequestParam("pic_file") MultipartFile pic_file) {
        try {
            cmsMaterial.setMaterialId(UidUtils.getUUID(true));
            if (pic_file != null && !pic_file.isEmpty()) {
                if (!configServerApplication.getUploadImageFileExts().contains(FileUploadUtils.getExtension(pic_file))) {
                    return error("请上传正确的素材图片！");
                }
                if (Long.parseLong(configServerApplication.getUploadImageFileMaxSize()) < pic_file.getSize()) {
                    return error("素材图片超出大小限制！");
                }
                String path = "/material/";
                String fileNam = StringUtils.format("{}.{}", cmsMaterial.getMaterialId(), FileUploadUtils.getExtension(pic_file));
                FileUploadUtils.savefile(configServerApplication.getUploadPath() + path, fileNam, pic_file.getBytes());
                cmsMaterial.setSavePath(StringUtils.format("{}{}{}?{}", "/upload/", path, fileNam, DateUtils.dateTime()));
            } else {
                return error("请上传正确的素材图片！");
            }
        } catch (Exception e) {
            log.error("上传素材图片失败！", e);
            return error(e.getMessage());
        }
        return toAjax(cmsMaterialService.insertCmsMaterial(cmsMaterial));
    }

    /**
     * 修改素材信息
     */
    @GetMapping("/edit/{materialId}")
    public String edit(@PathVariable("materialId") String materialId, ModelMap mmap) {
        CmsMaterial cmsMaterial = cmsMaterialService.selectCmsMaterialById(materialId);
        mmap.put("cmsMaterial", super.getCmsMaterialPage(cmsMaterial));
        super.merchantAuth(mmap);
        return prefix + "/edit";
    }

    /**
     * 修改保存素材信息
     */
    @RequiresPermissions("bussiness_cms:material:edit")
    @Log(title = "素材信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsMaterial cmsMaterial, @RequestParam(value = "pic_file", required = false) MultipartFile pic_file) {
        CmsMaterial cms = cmsMaterialService.selectCmsMaterialById(cmsMaterial.getMaterialId());
        if (cms == null) {
            return error("素材信息不存在");
        }
        try {
            if (pic_file != null && !pic_file.isEmpty()) {
                if (!configServerApplication.getUploadImageFileExts().contains(FileUploadUtils.getExtension(pic_file))) {
                    return error("请上传正确的素材图片！");
                }
                if (Long.parseLong(configServerApplication.getUploadImageFileMaxSize()) < pic_file.getSize()) {
                    return error("素材图片超出大小限制！");
                }
                String path = "/material/";
                String fileNam = StringUtils.format("{}.{}", cmsMaterial.getMaterialId(), FileUploadUtils.getExtension(pic_file));
                FileUploadUtils.savefile(configServerApplication.getUploadPath() + path, fileNam, pic_file.getBytes());
                cmsMaterial.setSavePath(StringUtils.format("{}{}{}?{}", "/upload/", path, fileNam, DateUtils.dateTime()));
            }
        } catch (Exception e) {
            log.error("上传素材图片失败！", e);
            return error(e.getMessage());
        }
        return toAjax(cmsMaterialService.updateCmsMaterial(cmsMaterial));
    }

    /**
     * 删除素材信息
     */
    @RequiresPermissions("bussiness_cms:material:remove")
    @Log(title = "素材信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cmsMaterialService.deleteCmsMaterialByIds(ids));
    }
}
