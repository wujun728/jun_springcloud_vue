package com.zebra.bussiness.cms.controller;

import java.util.List;

import com.zebra.bussiness.cms.mapper.CmsMaterialGroupMapper;
import com.zebra.common.core.domain.Ztree;
import com.zebra.common.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zebra.common.annotation.Log;
import com.zebra.common.enums.BusinessType;
import com.zebra.bussiness.cms.domain.CmsMaterialGroup;
import com.zebra.bussiness.cms.service.ICmsMaterialGroupService;
import com.zebra.common.core.controller.BaseController;
import com.zebra.common.core.domain.AjaxResult;
import com.zebra.common.utils.poi.ExcelUtil;
import com.zebra.common.core.page.TableDataInfo;
import tk.mybatis.mapper.entity.Example;

/**
 * 素材组别Controller
 *
 * @author zebra
 * @date 2020-06-24
 */
@Controller
@RequestMapping("/bussiness_cms/materialgroup")
public class CmsMaterialGroupController extends BaseController {
    private String prefix = "bussiness_cms/materialgroup";

    @Autowired
    private ICmsMaterialGroupService cmsMaterialGroupService;
    @Autowired
    private CmsMaterialGroupMapper cmsMaterialGroupMapper;

    @RequiresPermissions("bussiness_cms:materialgroup:view")
    @GetMapping()
    public String materialgroup() {
        return prefix + "/materialgroup";
    }

    /**
     * 查询素材组别列表
     */
    @RequiresPermissions("bussiness_cms:materialgroup:list")
    @RequestMapping("/list")
    @ResponseBody
    public List<CmsMaterialGroup> list(CmsMaterialGroup cmsMaterialGroup) {
        List<CmsMaterialGroup> list = cmsMaterialGroupService.selectCmsMaterialGroupList(cmsMaterialGroup);
        return list;
    }

    /**
     * 导出素材组别列表
     */
    @RequiresPermissions("bussiness_cms:materialgroup:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsMaterialGroup cmsMaterialGroup) {
        List<CmsMaterialGroup> list = cmsMaterialGroupService.selectCmsMaterialGroupList(cmsMaterialGroup);
        ExcelUtil<CmsMaterialGroup> util = new ExcelUtil<CmsMaterialGroup>(CmsMaterialGroup.class);
        return util.exportExcel(list, "materialgroup");
    }

    /**
     * 新增素材分组
     */
    @GetMapping(value = {"/addtree/{groupId}", "/addtree/", "/addtree"})
    public String add(@PathVariable(value = "groupId", required = false) String groupId, ModelMap mmap) {
        if (StringUtils.isNotNull(groupId)) {
            mmap.put("materialGroup", cmsMaterialGroupService.selectCmsMaterialGroupById(groupId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存素材组别
     */
    @RequiresPermissions("bussiness_cms:materialgroup:add")
    @Log(title = "素材组别", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CmsMaterialGroup cmsMaterialGroup) {
        return toAjax(cmsMaterialGroupService.insertCmsMaterialGroup(cmsMaterialGroup));
    }

    /**
     * 修改素材组别
     */
    @GetMapping("/edit/{groupId}")
    public String edit(@PathVariable("groupId") String groupId, ModelMap mmap) {
        CmsMaterialGroup cmsMaterialGroup = cmsMaterialGroupService.selectCmsMaterialGroupById(groupId);
        mmap.put("cmsMaterialGroup", cmsMaterialGroup);
        CmsMaterialGroup parentGroup = cmsMaterialGroupService.selectCmsMaterialGroupById(String.valueOf(cmsMaterialGroup.getGroupParentId()));
        String parentName = parentGroup == null ? "" : parentGroup.getGroupName();
        mmap.put("parentName", parentName);
        return prefix + "/edit";
    }

    /**
     * 修改保存素材组别
     */
    @RequiresPermissions("bussiness_cms:materialgroup:edit")
    @Log(title = "素材组别", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CmsMaterialGroup cmsMaterialGroup) {
        CmsMaterialGroup group = cmsMaterialGroupService.selectCmsMaterialGroupById(String.valueOf(cmsMaterialGroup.getGroupId()));
        if (cmsMaterialGroup == null) {
            return error("信息不存在");
        }
        if (cmsMaterialGroup.getGroupParentId() != null && cmsMaterialGroup.getGroupParentId().longValue() == group.getGroupId())
            return error("父级不能是组别自己");

        return toAjax(cmsMaterialGroupService.updateCmsMaterialGroup(cmsMaterialGroup));
    }

    /**
     * 删除素材组别
     */
    @RequiresPermissions("bussiness_cms:materialgroup:remove")
    @Log(title = "素材组别", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{groupId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("groupId") Long groupId) {
        CmsMaterialGroup cmsMaterialGroup = cmsMaterialGroupService.selectCmsMaterialGroupById(String.valueOf(groupId));
        if (cmsMaterialGroup == null) {
            return error("信息不存在");
        }
        Example e = new Example(CmsMaterialGroup.class);
        e.createCriteria().andEqualTo("groupParentId", cmsMaterialGroup.getGroupId());
        if (cmsMaterialGroupMapper.selectCountByExample(e) > 0) {
            return error("请先删除子级信息");
        }
        return toAjax(cmsMaterialGroupService.deleteCmsMaterialGroupByIds(String.valueOf(groupId)));
    }

    /**
     * 选择素材分组树
     */
    @GetMapping(value = {"/selectMaterialGroupTree/{groupId}", "/selectMaterialGroupTree/"})
    public String selectMaterialGroupTree(@PathVariable(value = "groupId", required = false) String groupId, ModelMap mmap) {
        if (StringUtils.isNotNull(groupId)) {
            mmap.put("materialGroup", cmsMaterialGroupService.selectCmsMaterialGroupById(groupId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载素材分组树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData() {
        List<Ztree> ztrees = cmsMaterialGroupService.selectMaterialGroupTree();
        return ztrees;
    }
}
