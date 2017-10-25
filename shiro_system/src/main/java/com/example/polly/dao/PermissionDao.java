package com.example.polly.dao;

import java.util.List;

import com.example.polly.enty.Permission;
import com.example.polly.util.MyBatisDao;

/**
 * <p>User: zhouxiantao
 * <p>Date: 17-10-17
 * <p>Version: 1.0
 */
@MyBatisDao
public interface PermissionDao {
	
	public List<Permission> findList(Permission permission);

    public void createPermission(Permission permission);

    public void deletePermission(Long permissionId);
    
    public Permission getByParentId(Long parentId);
    
    

}
