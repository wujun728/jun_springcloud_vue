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

import com.zebra.bussiness.domain.Merchant;
import com.zebra.bussiness.domain.page.MerchantPage;
import com.zebra.bussiness.service.IMerchantService;
import com.zebra.common.annotation.Log;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.core.page.TableDataInfo;
import com.zebra.common.enums.BusinessType;
import com.zebra.common.utils.poi.ExcelUtil;

/**
 * 商户信息Controller
 *
 * @author zebra
 * @date 2020-03-03
 */
@Controller
@RequestMapping("/bussiness/merchant")
public class MerchantController extends BaseController {
	private String prefix = "bussiness/merchant";

	@Autowired
	private IMerchantService merchantService;

	@RequiresPermissions("bussiness:merchant:view")
	@GetMapping()
	public String merchant() {
 		return prefix + "/merchant";
	}

	/**
	 * 查询商户信息列表
	 */
	@RequiresPermissions("bussiness:merchant:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Merchant merchant) {
		startPage();
		List<MerchantPage> list = merchantService.selectMerchantList(merchant);
		return getDataTable(list);
	}

	/**
	 * 导出商户信息列表
	 */
	@RequiresPermissions("bussiness:merchant:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Merchant merchant) {
		List<MerchantPage> list = merchantService.selectMerchantList(merchant);
		ExcelUtil<MerchantPage> util = new ExcelUtil<MerchantPage>(MerchantPage.class);
		return util.exportExcel(list, "merchant");
	}

	/**
	 * 新增商户信息
	 */
	@GetMapping("/add")
	public String add() {
		return prefix + "/add";
	}

	/**
	 * 新增保存商户信息
	 */
	@RequiresPermissions("bussiness:merchant:add")
	@Log(title = "商户信息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Merchant merchant) {
		return toAjax(merchantService.insertMerchant(merchant));
	}

	/**
	 * 修改商户信息
	 */
	@GetMapping("/edit/{merchantId}")
	public String edit(@PathVariable("merchantId") Long merchantId, ModelMap mmap) {
		Merchant merchant = merchantService.selectMerchantById(merchantId);
		mmap.put("merchant", merchant);
		return prefix + "/edit";
	}

	/**
	 * 修改保存商户信息
	 */
	@RequiresPermissions("bussiness:merchant:edit")
	@Log(title = "商户信息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Merchant merchant) {
		return toAjax(merchantService.updateMerchant(merchant));
	}

	/**
	 * 删除商户信息
	 */
	@RequiresPermissions("bussiness:merchant:remove")
	@Log(title = "商户信息", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(merchantService.deleteMerchantByIds(ids));
	}
}
