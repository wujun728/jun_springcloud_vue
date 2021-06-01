package com.zebra.web.controller.bussiness;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zebra.bussiness.domain.Orders;
import com.zebra.bussiness.domain.page.OrdersPage;
import com.zebra.bussiness.service.IMerchantService;
import com.zebra.bussiness.service.IOrdersService;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.core.page.TableDataInfo;
import com.zebra.common.utils.poi.ExcelUtil;
import com.zebra.framework.util.ShiroUtils;

/**
 * 订单信息Controller
 *
 * @author zebra
 * @date 2020-03-03
 */
@Controller
@RequestMapping("/bussiness/orders")
public class OrdersController extends BaseController {
	private String prefix = "bussiness/orders";

	@Autowired
	private IOrdersService ordersService;
	@Autowired
	private IMerchantService iMerchantService;

	@RequiresPermissions("bussiness:orders:view")
	@GetMapping()
	public String orders(ModelMap mmap) {
		mmap.addAttribute("acs", iMerchantService.getAll(ShiroUtils.getObjs()));
		return prefix + "/orders";
	}

	/**
	 * 查询订单信息列表
	 */
	@RequiresPermissions("bussiness:orders:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Orders orders) {
		startPage();
		List<OrdersPage> list = ordersService.selectOrdersList(orders);
		return getDataTable(list);
	}

	/**
	 * 导出订单信息列表
	 */
	@RequiresPermissions("bussiness:orders:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(Orders orders) {
		List<OrdersPage> list = ordersService.selectOrdersList(orders);
		ExcelUtil<OrdersPage> util = new ExcelUtil<OrdersPage>(OrdersPage.class);
		return util.exportExcel(list, "orders");
	}
}
