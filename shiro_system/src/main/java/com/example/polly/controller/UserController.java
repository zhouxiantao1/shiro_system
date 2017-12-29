package com.example.polly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.polly.enty.User;
import com.example.polly.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequiresPermissions("sys:user:add")
	@RequestMapping("/add")
	public void getSystemr(HttpServletRequest request,HttpServletResponse response,User user, Model model){
		this.userService.createUser(user);
	}
	
	@RequiresPermissions("sys:user:get")
	@RequestMapping("/get")
	public String getUser(HttpServletRequest request,HttpServletResponse response,Model model){
		return "sys/user";
	}
	
	@RequestMapping("/update")
	public void getUdate(HttpServletRequest request,HttpServletResponse response, Model model){
		this.userService.changePassword(1L, "123456");
	}
	
	@RequiresPermissions("sys:user:list")
	@RequestMapping("/list")
	public String getUserList(HttpServletRequest request,HttpServletResponse response,User user, Model model){
		List<User> userList = userService.findList(user);	
		model.addAttribute("userList", userList);
		return "sys/users";
	}
}
