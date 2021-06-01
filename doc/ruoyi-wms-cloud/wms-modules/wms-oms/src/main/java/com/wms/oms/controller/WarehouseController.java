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
import com.wms.oms.domain.Warehouse;
import com.wms.oms.service.IWarehouseService;

import javax.validation.Valid;

/**
 * 仓库信息Controller
 *
 * @author zzm
 * @date 2021-05-14
 */
@RestController
@RequestMapping("/warehouse")
public class WarehouseController extends BaseController
{
    @Autowired
    private IWarehouseService warehouseService;

    /**
     * 查询仓库信息列表
     */
    @PreAuthorize(hasPermi = "oms:warehouse:list")
    @GetMapping("/list")
    public TableDataInfo list(Warehouse warehouse)
    {
        startPage();
        List<Warehouse> list = warehouseService.selectWarehouseList(warehouse);
        return getDataTable(list);
    }

    /**
     * 查询仓库信息列表
     */
    @PreAuthorize(hasPermi = "oms:warehouse:list")
    @GetMapping("/allList")
    public AjaxResult allList(Warehouse warehouse)
    {
        List<Warehouse> list = warehouseService.selectWarehouseList(warehouse);
        return AjaxResult.success(list);
    }


    /**
     * 获取仓库信息详细信息
     */
    @PreAuthorize(hasPermi = "oms:warehouse:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(warehouseService.selectWarehouseById(id));
    }

    /**
     * 新增仓库信息
     */
    @PreAuthorize(hasPermi = "oms:warehouse:add")
    @PostMapping(value = "save")
    public AjaxResult add(@RequestBody @Valid Warehouse warehouse)
    {
        return toAjax(warehouseService.insertWarehouse(warehouse));
    }

    /**
     * 修改仓库信息
     */
    @PreAuthorize(hasPermi = "oms:warehouse:edit")
    @PostMapping(value = "update")
    public AjaxResult edit(@RequestBody Warehouse warehouse)
    {
        return toAjax(warehouseService.updateWarehouse(warehouse));
    }

    /**
     * 删除仓库信息
     */
    @PreAuthorize(hasPermi = "oms:warehouse:remove")
    @PostMapping(value = "delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(warehouseService.deleteWarehouseByIds(ids));
    }
}
