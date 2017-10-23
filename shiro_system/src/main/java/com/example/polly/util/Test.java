package com.example.polly.util;

import com.example.polly.enty.User;
import com.example.polly.service.impl.PasswordHelper;

public class Test {

	public static void main(String[] args){
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		PasswordHelper passwordHelper = new PasswordHelper();
		passwordHelper.encryptPassword(user);
		System.out.println("password=="+user.getPassword());
		System.out.println("Salt=="+user.getSalt());
	}
}
