package com.estate.api.system.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import com.estate.api.system.model.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
@TableName("sys_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "id",index = 0)
    @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId; // 用户ID

    @ExcelProperty(value = "用户账号",index = 1)
    private String userName; // 用户账号

    @ExcelIgnore
    private String password; // 密码

    @ExcelProperty(value = "用户昵称",index = 2)
    private String nickName; // 用户昵称

    @ExcelProperty(value = "邮箱",index = 3)
    private String email; // 邮箱

    @ExcelProperty(value = "手机号码",index = 4)
    private String phonenumber; // 手机号码

    @ExcelProperty(value = "用户性别",index = 5)
    private String sex; // 用户性别(0=男,1=女,2=未知)

    @ExcelIgnore
    private String avatar; // 用户头像

    @ExcelProperty(value = "账号状态",index = 6)
    private String status; // 账号状态(0=正常,1=停用)

    @ExcelProperty(value = "删除标志",index = 7)
    @TableLogic(value = "0",delval = "2")//(0代表存在 2代表删除)
    private String delFlag; // 删除标志(0代表存在 2代表删除)



    /**
     * 角色对象
     */
    @ExcelIgnore
    @TableField(exist = false)
    private List<Role> roles;

    /**
     * 角色组
     */
    @ExcelIgnore
    @TableField(exist = false)
    private Long[] roleIds;

    public User() {
    }

    public User(Long userId) {
        this.userId = userId;
    }

    // 是否为admin
    public boolean isAdmin() {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

}
