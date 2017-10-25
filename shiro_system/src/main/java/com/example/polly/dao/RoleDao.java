package com.example.polly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

    public void correlationPermissions(@Param("roleId")Long roleId, @Param("permissionId")Long permissionId,@Param("available")String available,@Param("level")int level);
    public void uncorrelationPermissions(Long roleId, Long permissionId);
    public List<Long> findPermissionListByRoleId(Long roleId);
    public void updateRolePermissionByRoleId(Long roleId);
}
