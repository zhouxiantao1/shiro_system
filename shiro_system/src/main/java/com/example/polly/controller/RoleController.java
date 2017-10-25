package com.example.polly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.example.polly.enty.User;
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
	
//	@RequiresPermissions("sys:role:list")
	@RequestMapping("/list")
	public String getUserList(HttpServletRequest request,HttpServletResponse response,Role role, Model model){
		List<Role> roles = roleService.findList(role);	
		model.addAttribute("roles", roles);
		return "sys/roles";
	}
	
	@RequestMapping("/get")
	public String getRole(HttpServletRequest request,HttpServletResponse response,Role role, Model model){
		List<Permission> permissions = permissionService.findList(null);
		
		List<Tree> trees = new ArrayList<Tree>();
		for(Permission permission : permissions){
			Tree tree = new Tree();
			tree.setId(permission.getId());
			tree.setpId(permission.getParentId());
			tree.setName(permission.getDescription());
			trees.add(tree);
		}
		
		JSONArray json = JSONArray.fromObject(trees); 
		String str = json.toString();//°Ñjson×ª»»ÎªString 
		System.out.println("=====123===="+str);
		model.addAttribute("trees", str);
		return "sys/role_permissions";
	}
}
