package com.example.polly.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import junit.framework.Assert;

public class MD5 {
	
	public static String getMD5(String password){
		 String hashAlgorithmName = "MD5";
	     String credentials = password;
	     int hashIterations = 1024;
	     Object obj = new SimpleHash(hashAlgorithmName, credentials, null, hashIterations);
	     System.out.println(obj);  
	     return obj.toString();
	}
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		int a= 3;
		int b =3;
		map.put("num", 0.01);
		if(a==b && map.get("num")!=null){
			System.out.println("123");
		}
    }
}
