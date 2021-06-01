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
import com.wms.oms.domain.Supplier;
import com.wms.oms.service.ISupplierService;

import javax.validation.Valid;

/**
 * 供应商信息Controller
 *
 * @author zzm
 * @date 2021-05-10
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController extends BaseController
{
    @Autowired
    private ISupplierService supplierService;

    /**
     * 查询供应商信息列表
     */
    @PreAuthorize(hasPermi = "oms:supplier:list")
    @GetMapping("/list")
    public TableDataInfo list(Supplier supplier)
    {
        startPage();
        List<Supplier> list = supplierService.selectSupplierList(supplier);
        return getDataTable(list);
    }

    /**
     * 查询所有供应商信息列表
     */
    @PreAuthorize(hasPermi = "oms:supplier:list")
    @GetMapping("/allList")
    public AjaxResult allList(Supplier supplier)
    {
        List<Supplier> list = supplierService.selectSupplierList(supplier);
        return AjaxResult.success(list);
    }


    /**
     * 获取供应商信息详细信息
     */
    @PreAuthorize(hasPermi = "oms:supplier:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(supplierService.selectSupplierById(id));
    }

    /**
     * 新增供应商信息
     */
    @PreAuthorize(hasPermi = "oms:supplier:add")
    @PostMapping(value = "save")
    public AjaxResult add(@RequestBody @Valid Supplier supplier)
    {
        return toAjax(supplierService.insertSupplier(supplier));
    }

    /**
     * 修改供应商信息
     */
    @PreAuthorize(hasPermi = "oms:supplier:edit")
    @PostMapping(value = "update")
    public AjaxResult edit(@RequestBody @Valid Supplier supplier)
    {
        return toAjax(supplierService.updateSupplier(supplier));
    }

    /**
     * 删除供应商信息
     */
    @PreAuthorize(hasPermi = "oms:supplier:remove")
    @PostMapping(value = "delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(supplierService.deleteSupplierByIds(ids));
    }
}