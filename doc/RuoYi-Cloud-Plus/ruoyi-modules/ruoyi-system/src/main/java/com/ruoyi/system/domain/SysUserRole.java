package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户和角色关联 sys_user_role
 *
 * @author ruoyi
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sys_user_role")
public class SysUserRole {
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 角色ID
     */
    private Long roleId;
}
