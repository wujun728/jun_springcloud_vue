package com.wms.oms.controller;

import java.util.List;
import com.wms.common.core.web.controller.BaseController;
import com.wms.common.core.web.domain.AjaxResult;
import com.wms.common.core.web.page.TableDataInfo;
import com.wms.common.security.annotation.PreAuthorize;
import com.wms.oms.domain.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wms.oms.domain.SaleOrder;
import com.wms.oms.service.ISaleOrderService;

/**
 * 销售订单Controller
 *
 * @author zzm
 * @date 2021-05-16
 */
@RestController
@RequestMapping("/saleOrder")
public class SaleOrderController extends BaseController
{
    @Autowired
    private ISaleOrderService saleOrderService;

    /**
     * 查询销售订单列表
     */
    @PreAuthorize(hasPermi = "oms:saleOrder:list")
    @GetMapping("/list")
    public TableDataInfo list(SaleOrder saleOrder)
    {
        startPage();
        List<SaleOrder> list = saleOrderService.selectSaleOrderList(saleOrder);
        return getDataTable(list);
    }


    /**
     * 获取销售订单详细信息
     */
    @PreAuthorize(hasPermi = "oms:saleOrder:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(saleOrderService.selectSaleOrderById(id));
    }

    /**
     * 新增销售订单
     */
    @PreAuthorize(hasPermi = "oms:saleOrder:add")
    @PostMapping(value = "save")
    public AjaxResult add(@RequestBody SaleOrder saleOrder)
    {
        return toAjax(saleOrderService.insertSaleOrder(saleOrder));
    }

    /**
     * 修改销售订单
     */
    @PreAuthorize(hasPermi = "oms:saleOrder:edit")
    @PostMapping(value = "update")
    public AjaxResult edit(@RequestBody SaleOrder saleOrder)
    {
        return toAjax(saleOrderService.updateSaleOrder(saleOrder));
    }

    /**
     * 确认入库/出库
     */
    @PreAuthorize(hasPermi = "oms:saleOrder:edit")
    @PostMapping(value = "confirm")
    public AjaxResult confirm(@PathVariable("id") Long id)
    {
        SaleOrder saleOrder = saleOrderService.selectSaleOrderById(id);
        return toAjax(saleOrderService.confirm(saleOrder));
    }

    /**
     * 删除销售订单
     */
    @PreAuthorize(hasPermi = "oms:saleOrder:remove")
    @PostMapping(value = "delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(saleOrderService.deleteSaleOrderByIds(ids));
    }
}