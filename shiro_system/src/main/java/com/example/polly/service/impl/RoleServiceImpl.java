package com.example.polly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polly.dao.RoleDao;
import com.example.polly.enty.Role;
import com.example.polly.service.RoleService;

/**
 * <p>User: zhouxiaotao
 * <p>Date: 17-10-17
 * <p>Version: 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
    private RoleDao roleDao;

    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Long roleId, Long permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermissions(Long roleId, Long permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }
    
    /**
     * 查询用户列表
     * @param roleId
     * @param permissionIds
     */
    public List<Role> findList(Role role){
    	return roleDao.findList(role);
    }

}
