package com.zebra.bussiness.controller;

import com.zebra.bussiness.controller.extend.MerchaninfoControllerExtend;
import com.zebra.bussiness.domain.CityInfo;
import com.zebra.bussiness.domain.Merchaninfo;
import com.zebra.bussiness.domain.ProvinceInfo;
import com.zebra.bussiness.domain.page.MerchantInfoPage;
import com.zebra.bussiness.service.ICityInfoService;
import com.zebra.bussiness.service.IMerchaninfoService;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 商户信息Controller
 *
 * @author zebra
 * @date 2020-05-13
 */
@Controller
@RequestMapping("/bussiness/merchantinfo")
public class MerchaninfoController extends MerchaninfoControllerExtend {
    private String prefix = "bussiness/merchantinfo";

    @Autowired
    private IMerchaninfoService merchaninfoService;
    @Autowired
    private ICityInfoService cityInfoService;


    @RequiresPermissions("bussiness:merchantinfo:view")
    @GetMapping()
    public String merchantinfo() {
        return prefix + "/merchantinfo";
    }

    /**
     * 查询商户信息列表
     */
    @RequiresPermissions("bussiness:merchantinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Merchaninfo merchaninfo) {
        startPage();
        List<Merchaninfo> list = merchaninfoService.selectMerchaninfoList(merchaninfo);
        return getDataTable(super.getMerchantInfoPage(list));
    }

    /**
     * 导出商户信息列表
     */
    @RequiresPermissions("bussiness:merchantinfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Merchaninfo merchaninfo) {
        List<Merchaninfo> list = merchaninfoService.selectMerchaninfoList(merchaninfo);
        ExcelUtil<MerchantInfoPage> util = new ExcelUtil<MerchantInfoPage>(MerchantInfoPage.class);
        return util.exportExcel(super.getMerchantInfoPage(list), "商户信息");
    }

    /**
     * 新增商户信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        List<ProvinceInfo> provinceList = super.getProvinceList();
        mmap.addAttribute("provinceList", provinceList);
        return prefix + "/add";
    }

    /**
     * 新增保存商户信息
     */
    @RequiresPermissions("bussiness:merchantinfo:add")
    @Log(title = "商户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Merchaninfo merchaninfo, @RequestParam("pic_file") MultipartFile pic_file, @RequestParam("pic_file2") MultipartFile pic_file2) {
        merchaninfo.setMerchantId(super.getUid());
        String merchantImg = super.saveFile(pic_file, merchaninfo.getMerchantId(), prefix, true);
        merchaninfo.setMerchantImg(merchantImg);
        String merchantLicenseImg = super.saveFile(pic_file2, merchaninfo.getMerchantId() + "_l", prefix, false);
        merchaninfo.setMerchantLicenseImg(merchantLicenseImg);
        return toAjax(merchaninfoService.insertMerchaninfo(merchaninfo));
    }

    /**
     * 修改商户信息
     */
    @GetMapping("/edit/{merchantId}")
    public String edit(@PathVariable("merchantId") String merchantId, ModelMap mmap) {
        Merchaninfo merchaninfo = merchaninfoService.selectMerchaninfoById(merchantId);
        mmap.put("merchaninfo", merchaninfo);

        List<ProvinceInfo> provinceList = super.getProvinceList();
        mmap.addAttribute("provinceList", provinceList);

        CityInfo cityInfo = new CityInfo();
        cityInfo.setProvinceId(merchaninfo.getProvinceId());
        mmap.addAttribute("cityList", cityInfoService.selectCityInfoList(cityInfo));

        String deptName = super.getDeptName(merchaninfo.getDeptId());
        mmap.addAttribute("deptName", deptName);

        return prefix + "/edit";
    }

    /**
     * 修改保存商户信息
     */
    @RequiresPermissions("bussiness:merchantinfo:edit")
    @Log(title = "商户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Merchaninfo merchaninfo, @RequestParam("pic_file") MultipartFile pic_file, @RequestParam("pic_file2") MultipartFile pic_file2) {
        Merchaninfo mBean = merchaninfoService.selectMerchaninfoById(merchaninfo.getMerchantId());
        if (mBean == null)
            return error("商户信息不存在");
        String merchantImg = super.saveFile(pic_file, merchaninfo.getMerchantId(), prefix, false);
        merchaninfo.setMerchantImg(merchantImg);
        String merchantLicenseImg = super.saveFile(pic_file2, merchaninfo.getMerchantId() + "_l", prefix, false);
        merchaninfo.setMerchantLicenseImg(merchantLicenseImg);
        return toAjax(merchaninfoService.updateMerchaninfo(merchaninfo));
    }

    /**
     * 审核商户信息
     */
    @GetMapping("/examine/{merchantId}")
    public String exam(@PathVariable("merchantId") String merchantId, ModelMap mmap) {
        Merchaninfo merchaninfo = merchaninfoService.selectMerchaninfoById(merchantId);
        mmap.put("merchaninfo", merchaninfo);
        return prefix + "/examine";
    }

    /**
     * 修改保存商户信息
     */
    @RequiresPermissions("bussiness:merchantinfo:examine")
    @Log(title = "商户信息", businessType = BusinessType.EXAMINE)
    @PostMapping("/examine")
    @ResponseBody
    public AjaxResult examineSave(Merchaninfo merchaninfo) {
        Merchaninfo mBean = merchaninfoService.selectMerchaninfoById(merchaninfo.getMerchantId());
        if (mBean == null)
            return error("商户信息不存在");

        return toAjax(merchaninfoService.updateMerchaninfo(merchaninfo));
    }


    /**
     * 删除商户信息
     */
    @RequiresPermissions("bussiness:merchantinfo:remove")
    @Log(title = "商户信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(merchaninfoService.deleteMerchaninfoByIds(ids));
    }
}
