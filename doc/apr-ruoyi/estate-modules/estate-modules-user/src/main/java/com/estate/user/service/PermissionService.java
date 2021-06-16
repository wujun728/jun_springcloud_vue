package com.estate.user.service;


import java.util.Set;

public interface PermissionService {

    Set<String> getRolePermission(Long userId);

    Set<String> getMenuPermission(Long userId);
}
