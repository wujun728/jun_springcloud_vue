package com.estate.api.system.model;

import com.estate.api.system.domain.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 用户名id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 角色列表
     */
    private Set<String> roles;

    /**
     * 权限列表
     */
    private Set<String> permissions;

    /**
     * 用户信息
     */
    private User user;

    public LoginUser() {
    }

    public LoginUser(User user, Set<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    public LoginUser(User user, Set<String> roles, Set<String> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }



}
