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
import com.example.polly.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	@RequiresPermissions("sys:permission:list")
	@RequestMapping("/list")
	public String getPermissionList(HttpServletRequest request,HttpServletResponse response,Permission permission, Model model){
		List<Permission> permissions = permissionService.findList(permission);	
		List<Permission> permissionList = new ArrayList<Permission>();
		for(Permission permission1 : permissions){
			if("0".equals(permission1.getParentId().toString())){
				permission1.setParentIdsAndId(permission1.getId().toString());
				permission1.setParentIds("0");
				permissionList.add(permission1);
				for(Permission permission2 : permissions){
					if(permission2.getParentId()==permission1.getId()){
						permission2.setParentIdsAndId(permission2.getParentIds()+"-"+permission2.getId());
						permissionList.add(permission2);
						for(Permission permission3 : permissions){
							if(permission3.getParentId()==permission2.getId()){
								permission3.setParentIdsAndId(permission3.getParentIds()+"-"+permission3.getId());
								permissionList.add(permission3);
							}
						}
					}
				}
			}
		}
		model.addAttribute("permissionList", permissionList);
		return "sys/permissions";
	}
	
//	@RequiresPermissions("sys:permission:add")
	@RequestMapping("/add")
	public String addPermission(HttpServletRequest request,HttpServletResponse response,String status,Permission permission, Model model){
		if("1".equals(status)){//新增		
			if(permission.getParentId()==null){
				permission.setParentId(0L);
				permission.setParentIds("0");
			}else{
				//查询父类
				Permission permissionParent = permissionService.getByParentId(permission.getParentId());
				if(permissionParent.getParentId()==0){
					String parentIds = permissionParent.getId().toString();
					permission.setParentIds(parentIds);
				}else{
					String parentIds = permissionParent.getParentIds() + "-" + permissionParent.getId();
					permission.setParentIds(parentIds);
				}
			}
			permissionService.createPermission(permission);
		}
		return null;
	}
	
	@RequestMapping("/get")
	public String getPermission(HttpServletRequest request,HttpServletResponse response,String status,Permission permission, Model model){
		model.addAttribute("permission", permission);
		model.addAttribute("status", status);
		return "sys/permissions_new";
	}
}
