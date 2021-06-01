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
import com.wms.oms.domain.InventoryLog;
import com.wms.oms.service.IInventoryLogService;

/**
 * 库存操作日志Controller
 *
 * @author zzm
 * @date 2021-05-16
 */
@RestController
@RequestMapping("/inventoryLog")
public class InventoryLogController extends BaseController
{
    @Autowired
    private IInventoryLogService inventoryLogService;

    /**
     * 查询库存操作日志列表
     */
    @PreAuthorize(hasPermi = "oms:inventoryLog:list")
    @GetMapping("/list")
    public TableDataInfo list(InventoryLog inventoryLog)
    {
        startPage();
        List<InventoryLog> list = inventoryLogService.selectInventoryLogList(inventoryLog);
        return getDataTable(list);
    }


    /**
     * 获取库存操作日志详细信息
     */
    @PreAuthorize(hasPermi = "oms:inventoryLog:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(inventoryLogService.selectInventoryLogById(id));
    }

    /**
     * 新增库存操作日志
     */
    @PreAuthorize(hasPermi = "oms:inventoryLog:add")
    @PostMapping(value = "save")
    public AjaxResult add(@RequestBody InventoryLog inventoryLog)
    {
        return toAjax(inventoryLogService.insertInventoryLog(inventoryLog));
    }

    /**
     * 修改库存操作日志
     */
    @PreAuthorize(hasPermi = "oms:inventoryLog:edit")
    @PostMapping(value = "update")
    public AjaxResult edit(@RequestBody InventoryLog inventoryLog)
    {
        return toAjax(inventoryLogService.updateInventoryLog(inventoryLog));
    }

    /**
     * 删除库存操作日志
     */
    @PreAuthorize(hasPermi = "oms:inventoryLog:remove")
    @PostMapping(value = "delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(inventoryLogService.deleteInventoryLogByIds(ids));
    }
}