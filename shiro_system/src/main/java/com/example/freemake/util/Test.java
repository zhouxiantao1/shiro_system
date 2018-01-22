package com.example.freemake.util;

import com.example.freemake.generate.MyFreeMarker;

public class Test {
	
	public static void main(String[] args) {
		MyFreeMarker my = new MyFreeMarker();
		try {
			my.CreateFile("story_person", "zhouxiantao", "story","小说人物", "story_person");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
