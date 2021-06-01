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
import com.wms.oms.domain.ProductSpec;
import com.wms.oms.service.IProductSpecService;

/**
 * 商品规格Controller
 *
 * @author zzm
 * @date 2021-05-14
 */
@RestController
@RequestMapping("/spec")
public class ProductSpecController extends BaseController
{
    @Autowired
    private IProductSpecService productSpecService;

    /**
     * 查询商品规格列表
     */
    @PreAuthorize(hasPermi = "oms:spec:list")
    @GetMapping("/list")
    public TableDataInfo list(ProductSpec productSpec)
    {
        startPage();
        List<ProductSpec> list = productSpecService.selectProductSpecList(productSpec);
        return getDataTable(list);
    }


    /**
     * 获取商品规格详细信息
     */
    @PreAuthorize(hasPermi = "oms:spec:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(productSpecService.selectProductSpecById(id));
    }

    /**
     * 新增商品规格
     */
    @PreAuthorize(hasPermi = "oms:spec:add")
    @PostMapping(value = "save")
    public AjaxResult add(@RequestBody ProductSpec productSpec)
    {
        return toAjax(productSpecService.insertProductSpec(productSpec));
    }

    /**
     * 修改商品规格
     */
    @PreAuthorize(hasPermi = "oms:spec:edit")
    @PostMapping(value = "update")
    public AjaxResult edit(@RequestBody ProductSpec productSpec)
    {
        return toAjax(productSpecService.updateProductSpec(productSpec));
    }

    /**
     * 删除商品规格
     */
    @PreAuthorize(hasPermi = "oms:spec:remove")
    @PostMapping(value = "delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productSpecService.deleteProductSpecByIds(ids));
    }
}