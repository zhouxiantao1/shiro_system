package com.example.freemake.util;

import com.example.freemake.generate.MyFreeMarker;

public class Test {
	
	public static void main(String[] args) {
		MyFreeMarker my = new MyFreeMarker();
		try {
			my.CreateFile("story_area", "zhouxiantao", "story","小说区域", "story_area","区域");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
