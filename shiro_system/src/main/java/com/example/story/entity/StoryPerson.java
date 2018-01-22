package com.example.story.entity;

import java.util.*;
import java.sql.*;

/**
 * @author zhouxiantao
 * @data 2018-01-03 15:11:16
 *
 * @version 1.0
 */

public class StoryPerson{

	private Long id; // 

	private String personName; // 人物姓名

	private String personAge; // 人物年龄

	private String personGender; // 人物性别

	private String personFacial; // 人物外貌

	private String facialKey; // 外貌特征

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}

	public String getPersonName(){
		return personName;
	}
	
	public void setPersonName(String personName){
		this.personName = personName;
	}

	public String getPersonAge(){
		return personAge;
	}
	
	public void setPersonAge(String personAge){
		this.personAge = personAge;
	}

	public String getPersonGender(){
		return personGender;
	}
	
	public void setPersonGender(String personGender){
		this.personGender = personGender;
	}

	public String getPersonFacial(){
		return personFacial;
	}
	
	public void setPersonFacial(String personFacial){
		this.personFacial = personFacial;
	}

	public String getFacialKey(){
		return facialKey;
	}
	
	public void setFacialKey(String facialKey){
		this.facialKey = facialKey;
	}
}