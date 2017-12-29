package com.example.polly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.polly.enty.Permission;
import com.example.polly.enty.Role;
import com.example.polly.enty.Tree;
import com.example.polly.service.PermissionService;
import com.example.polly.service.RoleService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	
	@RequiresPermissions("sys:role:list")
	@RequestMapping("/list")
	public String getUserList(HttpServletRequest request,HttpServletResponse response,Role role, Model model){
		List<Role> roles = roleService.findList(role);	
		model.addAttribute("roles", roles);
		return "sys/roles";
	}
	
	@RequiresPermissions("sys:role:get")
	@RequestMapping("/get")
	public String getRole(HttpServletRequest request,HttpServletResponse response,Role role, Model model){
		List<Permission> permissions = permissionService.findList(null);
		//查询角色已有的权限
		List<Long> permissionids = roleService.findPermissionListByRoleId(1L);
		
		List<Tree> trees = new ArrayList<Tree>();
		for(Permission permission : permissions){
			Tree tree = new Tree();
			tree.setId(permission.getId());
			tree.setpId(permission.getParentId());
			tree.setName(permission.getDescription());
			for(Long permissionId : permissionids){
				if(permissionId==permission.getId()){
					tree.setChecked(true);
				}
			}
			
			trees.add(tree);
		}
		
		JSONArray json = JSONArray.fromObject(trees); 
		String str = json.toString();//把json转换为String 
		model.addAttribute("trees", str);
		model.addAttribute("role", "admin");
		model.addAttribute("roleId", 1L);
		return "sys/role_permissions";
	}
	
	@RequiresPermissions("sys:role:addRolePermission")
	@RequestMapping("/addRolePermission")
	public void addRolePermissions(HttpServletRequest request,HttpServletResponse response,Long roleId,String permissionIds, Model model){
		//移除角色-权限关联关系
		roleService.updateRolePermissionByRoleId(roleId);
		Permission permission = new Permission();
		permission.setParentId(0L);
		permission.setAvailable("0");
		List<Permission> permissions = permissionService.findList(permission);
		//添加角色-权限关系关系
		String[] permissionIdList = permissionIds.split(",");
		for(String permissionId : permissionIdList){
			int level = 2;
			for(Permission permission1 : permissions){
				if(permission1.getId()== Long.valueOf(permissionId)){
					if(permission1.getParentId()==0){
						level = 1;
					}
				}
			}
			roleService.correlationPermissions(Long.valueOf(roleId), Long.valueOf(permissionId), "0",level);
		}
	}
}
