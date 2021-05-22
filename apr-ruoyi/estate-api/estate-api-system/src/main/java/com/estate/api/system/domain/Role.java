package com.estate.api.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.estate.api.system.model.BaseEntity;
import lombok.Data;

@Data
@TableName("sys_role")
public class Role extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限
     */
    private String roleKey;

    /**
     * 角色状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic(value = "0",delval = "2")
    private String delFlag;

    /**
     * 用户是否存在此角色标识 默认不存在
     */
    @TableField(exist = false)
    private boolean flag = false;

    /**
     * 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）
     */
    @TableField(exist = false)
    private boolean menuCheckStrictly;


    /**
     * 菜单组
     */
    @TableField(exist = false)
    private Long[] menuIds;

    public boolean isAdmin() {
        return isAdmin(this.roleId);
    }

    public static boolean isAdmin(Long roleId) {
        return roleId != null && 1L == roleId;
    }

    public boolean isMenuCheckStrictly() {
        return menuCheckStrictly;
    }

    public Role() {
    }

    public Role(Long roleId) {
        this.roleId = roleId;
    }
}
