package com.wms.oms.controller;

import java.util.List;
import com.wms.common.core.web.controller.BaseController;
import com.wms.common.core.web.domain.AjaxResult;
import com.wms.common.core.web.page.TableDataInfo;
import com.wms.common.security.annotation.PreAuthorize;
import com.wms.oms.domain.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wms.oms.domain.Product;
import com.wms.oms.service.IProductService;

import javax.validation.Valid;


/**
 * 商品信息Controller
 *
 * @author zzm
 * @date 2021-05-04
 */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController
{
    @Autowired
    private IProductService productService;

    /**
     * 查询商品信息列表
     */
    @PreAuthorize(hasPermi = "oms:product:list")
    @GetMapping("/list")
    public TableDataInfo list(Product product)
    {
        startPage();
        List<Product> list = productService.selectProductList(product);
        return getDataTable(list);
    }

    /**
     * 查询商品DTO信息列表
     */
    @PreAuthorize(hasPermi = "oms:product:list")
    @GetMapping("/dtoList")
    public AjaxResult dtoList(Product product){
        List<ProductDto> list = productService.selectProductDtoList(product);
        return AjaxResult.success(list);
    }


    /**
     * 获取商品信息详细信息
     */
    @PreAuthorize(hasPermi = "oms:product:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(productService.selectProductById(id));
    }

    /**
     * 新增商品信息
     */
    @PreAuthorize(hasPermi = "oms:product:add")
    @PostMapping("save")
    public AjaxResult add(@RequestBody @Valid Product product)
    {
        return toAjax(productService.insertProduct(product));
    }

    /**
     * 修改商品信息
     */
    @PreAuthorize(hasPermi = "oms:product:edit")
    @PostMapping("update")
    public AjaxResult edit(@RequestBody @Valid Product product)
    {
        return toAjax(productService.updateProduct(product));
    }

    /**
     * 删除商品信息
     */
    @PreAuthorize(hasPermi = "oms:product:remove")
    @PostMapping("delete/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productService.deleteProductByIds(ids));
    }
}