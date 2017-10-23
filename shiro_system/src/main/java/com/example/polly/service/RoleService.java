package com.example.polly.service;

import java.util.List;

import com.example.polly.enty.Role;

/**
 * <p>User: zhouxiaotao
 * <p>Date: 17-10-17
 * <p>Version: 1.0
 */
public interface RoleService {


    public Role createRole(Role role);
    public void deleteRole(Long roleId);

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Long roleId, Long permissionIds);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermissions(Long roleId, Long permissionIds);
    
    /**
     * 查询用户列表
     * @param roleId
     * @param permissionIds
     */
    public List<Role> findList(Role role); 

}
