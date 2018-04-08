package com.example.story.entity;

import java.util.*;
import java.sql.*;

/**
 * @author zhouxiantao
 * @data 2018-02-26 15:41:30
 *
 * @version 1.0
 */

public class StoryArea{

	private long id; // 

	private String areaName; // 

	private String areaParentids; // 

	private String areaParent; // 

	private String areaDescription; // 

	private java.lang.Object available; // 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAreaName(){
		return areaName;
	}
	
	public void setAreaName(String areaName){
		this.areaName = areaName;
	}

	public String getAreaParentids(){
		return areaParentids;
	}
	
	public void setAreaParentids(String areaParentids){
		this.areaParentids = areaParentids;
	}

	public String getAreaParent() {
		return areaParent;
	}

	public void setAreaParent(String areaParent) {
		this.areaParent = areaParent;
	}

	public String getAreaDescription(){
		return areaDescription;
	}
	
	public void setAreaDescription(String areaDescription){
		this.areaDescription = areaDescription;
	}

	public java.lang.Object getAvailable(){
		return available;
	}
	
	public void setAvailable(java.lang.Object available){
		this.available = available;
	}
}