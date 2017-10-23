package com.example.polly.dao;

import java.util.List;

import com.example.polly.enty.Role;
import com.example.polly.util.MyBatisDao;

/**
 * <p>User: zhouxiantao
 * <p>Date: 17-10-17
 * <p>Version: 1.0
 */
@MyBatisDao
public interface RoleDao {

    public Role createRole(Role role);
    public void deleteRole(Long roleId);
    public List<Role> findList(Role role);

    public void correlationPermissions(Long roleId, Long permissionIds);
    public void uncorrelationPermissions(Long roleId, Long permissionIds);

}
