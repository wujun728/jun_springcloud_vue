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
import com.wms.oms.domain.ProductCategory;
import com.wms.oms.service.IProductCategoryService;

/**
 * 商品分类信息Controller
 *
 * @author zzm
 * @date 2021-05-14
 */
@RestController
@RequestMapping("/category")
public class ProductCategoryController extends BaseController
{
    @Autowired
    private IProductCategoryService productCategoryService;

    /**
     * 查询商品分类信息列表
     */
    @PreAuthorize(hasPermi = "oms:category:list")
    @GetMapping("/list")
    public AjaxResult list(ProductCategory productCategory)
    {
        List<ProductCategory> list = productCategoryService.selectProductCategoryList(productCategory);
        return AjaxResult.success(list);
    }


    /**
     * 获取商品分类信息详细信息
     */
    @PreAuthorize(hasPermi = "oms:category:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(productCategoryService.selectProductCategoryById(id));
    }

    /**
     * 新增商品分类信息
     */
    @PreAuthorize(hasPermi = "oms:category:add")
    @PostMapping(value = "save")
    public AjaxResult add(@RequestBody ProductCategory productCategory)
    {
        return toAjax(productCategoryService.insertProductCategory(productCategory));
    }

    /**
     * 修改商品分类信息
     */
    @PreAuthorize(hasPermi = "oms:category:edit")
    @PostMapping(value = "update")
    public AjaxResult edit(@RequestBody ProductCategory productCategory)
    {
        return toAjax(productCategoryService.updateProductCategory(productCategory));
    }

    /**
     * 删除商品分类信息
     */
    @PreAuthorize(hasPermi = "oms:category:remove")
    @PostMapping(value = "delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productCategoryService.deleteProductCategoryByIds(ids));
    }
}