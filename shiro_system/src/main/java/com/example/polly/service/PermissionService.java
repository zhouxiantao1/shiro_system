package com.example.polly.service;

import java.util.List;

import com.example.polly.enty.Permission;

/**
 * <p>User: zhouxiaotao
 * <p>Date: 17-10-17
 * <p>Version: 1.0
 */
public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
    
    /**
     * 查询权限列表
     * */
    public List<Permission> findList(Permission permission);
}
