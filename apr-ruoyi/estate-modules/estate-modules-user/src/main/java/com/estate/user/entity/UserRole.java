package com.estate.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user_role")
public class UserRole {

    /** 用户ID */
    private Long userId;

    /** 角色ID */
    private Long roleId;
}
