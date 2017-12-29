package com.example.polly.util;

import com.example.polly.enty.User;
import com.example.polly.service.impl.PasswordHelper;

public class Test {
	
//	static abstract class Human{}
//	static class Man extends Human{}
//	static class Woman extends Human{}
//	public void sayHolle(Human human){
//		System.out.println("holle human");
//	}
//	
//	public void sayHolle(Man man){
//		System.out.println("holle man");
//	}
//	public void sayHolle(Woman woman){
//		System.out.println("holle woman");
//	}
	static abstract class Chinese{}
	static class A extends Chinese{}
	static class B extends Chinese{}
	public static class Father{
		public void SayA(A a){
			System.out.println("father say a");
		}
		public void SayA(B a){
			System.out.println("father say b");
		}
	}
	public class Son extends Father{
		public void SayA(A a){
			System.out.println("son say a");
		}
		public void SayA(B a){
			System.out.println("son say b");
		}
	}
	public static void main(String[] args){
		
		Father father = new Father();
//		Father son = new Son();
		Test test = new Test();
		Chinese a = new A();
		Chinese b = new B();
//		father.SayA(a);
		
		
//		User user = new User();
//		user.setUsername("admin");
//		user.setPassword("123456");
//		PasswordHelper passwordHelper = new PasswordHelper();
//		passwordHelper.encryptPassword(user);
//		System.out.println("password=="+user.getPassword());
//		System.out.println("Salt=="+user.getSalt());
	}
}
