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
     * ��ӽ�ɫ-Ȩ��֮���ϵ
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Long roleId, Long permissionIds);

    /**
     * �Ƴ���ɫ-Ȩ��֮���ϵ
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermissions(Long roleId, Long permissionIds);
    
    /**
     * ��ѯ�û��б�
     * @param roleId
     * @param permissionIds
     */
    public List<Role> findList(Role role); 

}
