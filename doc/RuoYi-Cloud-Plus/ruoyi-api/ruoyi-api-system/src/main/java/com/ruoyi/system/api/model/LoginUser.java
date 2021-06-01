package com.ruoyi.system.api.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruoyi.system.api.domain.SysUser;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 用户唯一标识
     */
    private String token;
    
    /**
     * 用户名id
     */
    private Long userid;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    @JsonIgnore
    private String password;
    
    /**
     * 登录时间
     */
    private Long loginTime;
    
    /**
     * 过期时间
     */
    private Long expireTime;
    
    /**
     * 登录IP地址
     */
    private String ipaddr;
    
    /**
     * 登录地址
     */
    private String loginLocation;
    
    /**
     * 浏览器
     */
    private String browser;
    
    /**
     * 操作系统
     */
    private String os;
    
    /**
     * 权限列表
     */
    private Set<String> permissions;
    
    /**
     * 角色列表
     */
    private Set<String> roles;
    
    /**
     * 用户信息
     */
    private SysUser sysUser;
}
