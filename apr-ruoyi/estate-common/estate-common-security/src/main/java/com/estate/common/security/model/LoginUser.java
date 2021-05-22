//package com.estate.common.security.model;
//
//import com.estate.api.system.domain.User;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Set;
//
//public class LoginUser implements UserDetails {
//
//
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * 用户唯一标识
//     */
//    private String token;
//
//    /**
//     * 过期时间
//     */
//    private Long expireTime;
//
//    /**
//     * 角色列表
//     */
//    private Set<String> roles;
//
//    /**
//     * 权限列表
//     */
//    private Set<String> permissions;
//
//    /**
//     * 用户信息
//     */
//    private User user;
//
//    public LoginUser() {
//    }
//
//    public LoginUser(User user, Set<String> permissions) {
//        this.user = user;
//        this.permissions = permissions;
//    }
//
//    public LoginUser(User user, Set<String> roles, Set<String> permissions) {
//        this.user = user;
//        this.roles = roles;
//        this.permissions = permissions;
//    }
//
//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public Long getExpireTime() {
//        return expireTime;
//    }
//
//    public void setExpireTime(Long expireTime) {
//        this.expireTime = expireTime;
//    }
//
//    public Set<String> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<String> roles) {
//        this.roles = roles;
//    }
//
//    public Set<String> getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(Set<String> permissions) {
//        this.permissions = permissions;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//
//    /**
//     * @JsonIgnore 注解表示，该对象序列化成json时，json中不包含这个字段
//     */
//    @JsonIgnore
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @JsonIgnore
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    /**
//     * 账户是否未过期,过期无法验证
//     */
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    /**
//     * 指定用户是否解锁,锁定的用户无法进行身份验证
//     *
//     * @return
//     */
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    /**
//     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
//     *
//     * @return
//     */
//    @JsonIgnore
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    /**
//     * 是否可用 ,禁用的用户不能身份验证
//     *
//     * @return
//     */
//    @JsonIgnore
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//
//    // 因为使用的是Redis存储登录用户对象，
//    // 所以用户权限是直接从Redis中取出用户对象然后getPermissions取出用户权限的，
//    // 所以这里没有用到getAuthorities()所以return null;
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//}
