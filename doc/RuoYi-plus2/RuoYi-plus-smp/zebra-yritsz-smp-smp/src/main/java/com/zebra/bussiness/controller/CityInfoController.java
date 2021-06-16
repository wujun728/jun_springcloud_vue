package com.zebra.bussiness.controller;

import com.zebra.bussiness.controller.extend.CityInfoControllerExtend;
import com.zebra.bussiness.domain.CityInfo;
import com.zebra.bussiness.service.ICityInfoService;
import com.zebra.common.annotation.Log;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.core.page.TableDataInfo;
import com.zebra.common.enums.BusinessType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市信息Controller
 *
 * @author zebra
 * @date 2020-06-05
 */
@Controller
@RequestMapping("/bussiness/cityinfo")
public class CityInfoController extends CityInfoControllerExtend {
    private String prefix = "bussiness/cityinfo";

    @Autowired
    private ICityInfoService cityInfoService;

    @RequiresPermissions("bussiness:cityinfo:view")
    @GetMapping()
    public String cityinfo(ModelMap mmap) {
        mmap.addAttribute("province", super.getProvinceList());
        return prefix + "/cityinfo";
    }

    /**
     * 查询城市信息列表
     */
    @RequiresPermissions("bussiness:cityinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CityInfo cityInfo) {
        startPage();
        List<CityInfo> list = cityInfoService.selectCityInfoList(cityInfo);
        return getDataTable(super.getCityInfoPage(list));
    }

    /**
     * 新增城市信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.addAttribute("province", super.getProvinceList());
        return prefix + "/add";
    }

    /**
     * 新增保存城市信息
     */
    @RequiresPermissions("bussiness:cityinfo:add")
    @Log(title = "城市信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CityInfo cityInfo) {
        if (cityInfoService.selectCityInfoById(cityInfo.getCityCode()) != null)
            return error("该城市编码已经存在！");
        return toAjax(cityInfoService.insertCityInfo(cityInfo));
    }

    /**
     * 修改城市信息
     */
    @GetMapping("/edit/{cityCode}")
    public String edit(@PathVariable("cityCode") String cityCode, ModelMap mmap) {
        mmap.addAttribute("province", super.getProvinceList());
        CityInfo cityInfo = cityInfoService.selectCityInfoById(cityCode);
        mmap.put("cityInfo", cityInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存城市信息
     */
    @RequiresPermissions("bussiness:cityinfo:edit")
    @Log(title = "城市信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CityInfo cityInfo) {
        return toAjax(cityInfoService.updateCityInfo(cityInfo));
    }

    /**
     * 删除城市信息
     */
    @RequiresPermissions("bussiness:cityinfo:remove")
    @Log(title = "城市信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(cityInfoService.deleteCityInfoByIds(ids));
    }


    @PostMapping("/listByProvinceId")
    @ResponseBody
    public AjaxResult listByProvinceId(String provinceId) {
        CityInfo cityInfo = new CityInfo();
        cityInfo.setProvinceId(provinceId);
        List<CityInfo> list = cityInfoService.selectCityInfoList(cityInfo);
        return AjaxResult.success(list);
    }

}
