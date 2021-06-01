package com.wms.oms.controller;

import java.util.List;
import com.wms.common.core.web.controller.BaseController;
import com.wms.common.core.web.domain.AjaxResult;
import com.wms.common.core.web.page.TableDataInfo;
import com.wms.common.security.annotation.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wms.oms.domain.PurchaseOrder;
import com.wms.oms.service.IPurchaseOrderService;

import javax.validation.Valid;

/**
 * 采购订单Controller
 *
 * @author zzm
 * @date 2021-05-16
 */
@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController extends BaseController
{
    @Autowired
    private IPurchaseOrderService purchaseOrderService;

    /**
     * 查询采购订单列表
     */
    @PreAuthorize(hasPermi = "oms:purchase:list")
    @GetMapping("/list")
    public TableDataInfo list(PurchaseOrder purchaseOrder)
    {
        startPage();
        List<PurchaseOrder> list = purchaseOrderService.selectPurchaseOrderList(purchaseOrder);
        return getDataTable(list);
    }


    /**
     * 获取采购订单详细信息
     */
    @PreAuthorize(hasPermi = "oms:purchase:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(purchaseOrderService.selectPurchaseOrderById(id));
    }

    /**
     * 新增采购订单
     */
    @PreAuthorize(hasPermi = "oms:purchase:add")
    @PostMapping(value = "save")
    public AjaxResult add(@RequestBody @Valid PurchaseOrder purchaseOrder)
    {
        return toAjax(purchaseOrderService.insertPurchaseOrder(purchaseOrder));
    }

    /**
     * 修改采购订单
     */
    @PreAuthorize(hasPermi = "oms:purchase:edit")
    @PostMapping(value = "update")
    public AjaxResult edit(@RequestBody @Valid PurchaseOrder purchaseOrder)
    {
        return toAjax(purchaseOrderService.updatePurchaseOrder(purchaseOrder));
    }


    /**
     * 确认入库/出库
     */
    @PreAuthorize(hasPermi = "oms:purchase:edit")
    @PostMapping(value = "confirm")
    public AjaxResult confirm(@PathVariable("id") Long id)
    {
        PurchaseOrder purchaseOrder = purchaseOrderService.selectPurchaseOrderById(id);
        return toAjax(purchaseOrderService.confirm(purchaseOrder));
    }

    /**
     * 删除采购订单
     */
    @PreAuthorize(hasPermi = "oms:purchase:remove")
    @PostMapping(value = "delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(purchaseOrderService.deletePurchaseOrderByIds(ids));
    }
}