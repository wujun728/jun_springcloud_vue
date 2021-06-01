package com.wms.system.controller;

import java.util.List;

import com.wms.common.core.constant.UserConstants;
import com.wms.common.core.utils.SecurityUtils;
import com.wms.common.core.utils.StringUtils;
import com.wms.common.core.web.controller.BaseController;
import com.wms.common.core.web.domain.AjaxResult;
import com.wms.common.core.web.page.TableDataInfo;
import com.wms.common.security.annotation.PreAuthorize;
import com.wms.system.service.ISysUserService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wms.system.domain.SysTenant;
import com.wms.system.service.ISysTenantService;


/**
 * 租户管理Controller
 *
 * @author zzm
 * @date 2021-05-06
 */
@RestController
@RequestMapping("/tenant")
public class SysTenantController extends BaseController
{
    @Autowired
    private ISysTenantService sysTenantService;

    @Autowired
    private ISysUserService userService;



    /**
     * 查询租户管理列表
     */
    @PreAuthorize(hasPermi = "system:tenant:list")
    @GetMapping("/list")
    public TableDataInfo list(SysTenant sysTenant)
    {
        startPage();
        List<SysTenant> list = sysTenantService.selectSysTenantList(sysTenant);
        return getDataTable(list);
    }


    /**
     * 获取租户管理详细信息
     */
    @PreAuthorize(hasPermi = "system:tenant:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysTenantService.selectSysTenantById(id));
    }

    /**
     * 新增租户管理
     */
    @Ignore
    @PostMapping(value = "register")
    public AjaxResult register(@RequestBody SysTenant sysTenant)
    {
        if (StringUtils.isNotEmpty(sysTenant.getPhone())
                && UserConstants.NOT_UNIQUE.equals(userService.checkMobileUnique(sysTenant.getPhone())))
        {
            return AjaxResult.error("新增用户'" + sysTenant.getNickName() + "'失败，手机号码已存在");
        }
        sysTenant.setCreateBy(sysTenant.getPhone());
        sysTenant.setPassword(SecurityUtils.encryptPassword(sysTenant.getPassword()));
        return toAjax(sysTenantService.insertSysTenant(sysTenant));
    }

    /**
     * 修改租户管理
     */
    @PreAuthorize(hasPermi = "system:tenant:edit")
    @PostMapping(value = "update")
    public AjaxResult edit(@RequestBody SysTenant sysTenant)
    {
        return toAjax(sysTenantService.updateSysTenant(sysTenant));
    }

    /**
     * 删除租户管理
     */
    @PreAuthorize(hasPermi = "system:tenant:remove")
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysTenantService.deleteSysTenantByIds(ids));
    }
}