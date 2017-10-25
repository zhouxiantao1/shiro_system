package com.example.polly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polly.dao.PermissionDao;
import com.example.polly.enty.Permission;
import com.example.polly.service.PermissionService;

/**
 * <p>User: zhouxiaotao
 * <p>Date: 17-10-17
 * <p>Version: 1.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
    private PermissionDao permissionDao;

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public void createPermission(Permission permission) {
         permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
    
    /**
     * 查询权限列表
     * */
    public List<Permission> findList(Permission permission){
    	return permissionDao.findList(permission);
    }
    
    /**
     * 根据父类查询
     * */
    public Permission getByParentId(Long parentId){
    	return permissionDao.getByParentId(parentId);
    }
}
