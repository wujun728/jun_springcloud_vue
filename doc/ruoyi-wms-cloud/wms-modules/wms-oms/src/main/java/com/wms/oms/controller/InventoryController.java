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
import com.wms.oms.domain.Inventory;
import com.wms.oms.service.IInventoryService;

/**
 * 库存信息Controller
 *
 * @author zzm
 * @date 2021-05-16
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController extends BaseController
{
    @Autowired
    private IInventoryService inventoryService;

    /**
     * 查询库存信息列表
     */
    @PreAuthorize(hasPermi = "oms:inventory:list")
    @GetMapping("/list")
    public TableDataInfo list(Inventory inventory)
    {
        startPage();
        List<Inventory> list = inventoryService.selectInventoryList(inventory);
        return getDataTable(list);
    }


    /**
     * 获取库存信息详细信息
     */
    @PreAuthorize(hasPermi = "oms:inventory:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(inventoryService.selectInventoryById(id));
    }

    /**
     * 新增库存信息
     */
    @PreAuthorize(hasPermi = "oms:inventory:add")
    @PostMapping(value = "save")
    public AjaxResult add(@RequestBody Inventory inventory)
    {
        return toAjax(inventoryService.insertInventory(inventory));
    }

    /**
     * 修改库存信息
     */
    @PreAuthorize(hasPermi = "oms:inventory:edit")
    @PostMapping(value = "update")
    public AjaxResult edit(@RequestBody Inventory inventory)
    {
        return toAjax(inventoryService.updateInventory(inventory));
    }

    /**
     * 删除库存信息
     */
    @PreAuthorize(hasPermi = "oms:inventory:remove")
    @PostMapping(value = "delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(inventoryService.deleteInventoryByIds(ids));
    }
}