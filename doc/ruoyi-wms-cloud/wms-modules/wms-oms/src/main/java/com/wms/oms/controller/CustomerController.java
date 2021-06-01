package com.wms.oms.controller;

import java.util.List;

import com.wms.common.core.web.controller.BaseController;
import com.wms.common.core.web.domain.AjaxResult;
import com.wms.common.core.web.page.TableDataInfo;
import com.wms.common.security.annotation.PreAuthorize;
import com.wms.oms.domain.Customer;
import com.wms.oms.service.ICustomerService;
import com.wms.system.api.RemoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * 客户信息Controller
 *
 * @author zzm
 * @date 2021-05-08
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController
{
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private RemoteUserService remoteUserService;

    /**
     * 查询客户信息列表
     */
    @PreAuthorize(hasPermi = "oms:customer:list")
    @GetMapping("/list")
    public TableDataInfo list(Customer customer)
    {
        startPage();
        List<Customer> list = customerService.selectCustomerList(customer);
        return getDataTable(list);
    }

    /**
     * 查询所有供应商信息列表
     */
    @PreAuthorize(hasPermi = "oms:customer:list")
    @GetMapping("/allList")
    public AjaxResult allList(Customer customer)
    {
        List<Customer> list = customerService.selectCustomerList(customer);
        return AjaxResult.success(list);
    }


    /**
     * 获取客户信息详细信息
     */
    @PreAuthorize(hasPermi = "oms:customer:query")
    @GetMapping(value = {"/","/{id}"})
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id)
    {
        AjaxResult ajax = AjaxResult.success();
        if (id != null) {
            ajax.put(AjaxResult.DATA_TAG, customerService.selectCustomerById(id));
        }
        ajax.put("users", remoteUserService.selectAllUser());
        return ajax;
    }

    /**
     * 新增客户信息
     */
    @PreAuthorize(hasPermi = "oms:customer:add")
    @PostMapping(value = "save")
    public AjaxResult add(@RequestBody @Valid Customer customer)
    {
        return toAjax(customerService.insertCustomer(customer));
    }

    /**
     * 修改客户信息
     */
    @PreAuthorize(hasPermi = "oms:customer:edit")
    @PostMapping(value = "update")
    public AjaxResult edit(@RequestBody @Valid Customer customer)
    {
        return toAjax(customerService.updateCustomer(customer));
    }

    /**
     * 删除客户信息
     */
    @PreAuthorize(hasPermi = "oms:customer:remove")
    @PostMapping("delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(customerService.deleteCustomerByIds(ids));
    }
}
