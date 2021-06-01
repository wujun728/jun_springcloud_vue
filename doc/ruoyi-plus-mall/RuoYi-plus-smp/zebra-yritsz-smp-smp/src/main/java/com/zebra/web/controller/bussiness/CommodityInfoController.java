package com.zebra.web.controller.bussiness;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zebra.bussiness.domain.CommodityInfo;
import com.zebra.bussiness.domain.page.CommodityInfoPage;
import com.zebra.bussiness.service.ICommodityInfoService;
import com.zebra.bussiness.service.IMerchantService;
import com.zebra.common.annotation.Log;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.core.page.TableDataInfo;
import com.zebra.common.enums.BusinessType;
import com.zebra.common.utils.poi.ExcelUtil;
import com.zebra.framework.util.ShiroUtils;

/**
 * 产品信息Controller
 *
 * @author zebra
 * @date 2020-03-25
 */
@Controller
@RequestMapping("/bussiness/info")
public class CommodityInfoController extends BaseController {
	private String prefix = "bussiness/info";
	@Autowired
	private IMerchantService iMerchantService;
	@Autowired
	private ICommodityInfoService commodityInfoService;

	@RequiresPermissions("bussiness:info:view")
	@GetMapping()
	public String info(ModelMap mmap) {
		mmap.addAttribute("acs", iMerchantService.getAll(ShiroUtils.getObjs()));
		return prefix + "/info";
	}

	/**
	 * 查询产品信息列表
	 */
	@RequiresPermissions("bussiness:info:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CommodityInfo commodityInfo) {
		startPage();
		List<CommodityInfoPage> list = commodityInfoService.selectCommodityInfoList(commodityInfo);
		return getDataTable(list);
	}

	/**
	 * 导出产品信息列表
	 */
	@RequiresPermissions("bussiness:info:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(CommodityInfo commodityInfo) {
		List<CommodityInfoPage> list = commodityInfoService.selectCommodityInfoList(commodityInfo);
		ExcelUtil<CommodityInfoPage> util = new ExcelUtil<CommodityInfoPage>(CommodityInfoPage.class);
		return util.exportExcel(list, "info");
	}

	/**
	 * 新增产品信息
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存产品信息
	 */
	@RequiresPermissions("bussiness:info:add")
	@Log(title = "产品信息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CommodityInfo commodityInfo) {
		return toAjax(commodityInfoService.insertCommodityInfo(commodityInfo));
	}

	/**
	 * 修改产品信息
	 */
	@GetMapping("/edit/{commodityId}")
	public String edit(@PathVariable("commodityId") String commodityId, ModelMap mmap) {
		CommodityInfo commodityInfo = commodityInfoService.selectCommodityInfoById(commodityId);
		mmap.put("commodityInfo", commodityInfo);
		return prefix + "/edit";
	}

	/**
	 * 修改保存产品信息
	 */
	@RequiresPermissions("bussiness:info:edit")
	@Log(title = "产品信息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CommodityInfo commodityInfo) {
		return toAjax(commodityInfoService.updateCommodityInfo(commodityInfo));
	}

	/**
	 * 删除产品信息
	 */
	@RequiresPermissions("bussiness:info:remove")
	@Log(title = "产品信息", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(commodityInfoService.deleteCommodityInfoByIds(ids));
	}
}
