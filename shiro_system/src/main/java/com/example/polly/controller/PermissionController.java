package com.example.polly.controller;

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
	public String getUserList(HttpServletRequest request,HttpServletResponse response,Permission permission, Model model){
		List<Permission> permissions = permissionService.findList(permission);	
		model.addAttribute("permissions", permissions);
		return "sys/permissions";
	}
}
