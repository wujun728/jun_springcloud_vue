package com.zebra.bussiness.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zebra.bussiness.domain.ProvinceInfo;
import com.zebra.bussiness.service.IProvinceInfoService;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.page.TableDataInfo;

/**
 * 省份信息Controller
 * 
 * @author zebra
 * @date 2020-06-05
 */
@Controller
@RequestMapping("/bussiness/provinceinfo")
public class ProvinceInfoController extends BaseController {
    private String prefix = "bussiness/provinceinfo";

    @Autowired
    private IProvinceInfoService provinceInfoService;

    @RequiresPermissions("bussiness:provinceinfo:view")
    @GetMapping()
    public String provinceinfo()
    {
        return prefix + "/provinceinfo";
    }

    /**
     * 查询省份信息列表
     */
    @RequiresPermissions("bussiness:provinceinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProvinceInfo provinceInfo)
    {
        startPage();
        List<ProvinceInfo> list = provinceInfoService.selectProvinceInfoList(provinceInfo);
        return getDataTable(list);
    }
}
