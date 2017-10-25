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
    public void correlationPermissions(Long roleId, Long permissionId,String available,int level);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermissions(Long roleId, Long permissionId);
    
    /**
     * 查询用户列表
     * @param roleId
     * @param permissionIds
     */
    public List<Role> findList(Role role);
    
    /**
     * 根据roleid获取权限id集合
     * */
    public List<Long> findPermissionListByRoleId(Long roleId);
    
    /**
     * 根据roleId更新角色-权限表
     * */
    public void updateRolePermissionByRoleId(Long roleId);
}
