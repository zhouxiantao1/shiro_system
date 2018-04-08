package com.example.story.entity;

import java.util.List;

public class StoryAreaTree {
	private long id; // 

	private String areaName; // 

	private String areaParentids; // 

	private String areaParent; // 

	private String areaDescription; // 

	private java.lang.Object available; //
	
	private List<StoryAreaTree> children;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaParentids() {
		return areaParentids;
	}

	public void setAreaParentids(String areaParentids) {
		this.areaParentids = areaParentids;
	}

	public String getAreaParent() {
		return areaParent;
	}

	public void setAreaParent(String areaParent) {
		this.areaParent = areaParent;
	}

	public String getAreaDescription() {
		return areaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

	public java.lang.Object getAvailable() {
		return available;
	}

	public void setAvailable(java.lang.Object available) {
		this.available = available;
	}

	public List<StoryAreaTree> getChildren() {
		return children;
	}

	public void setChildren(List<StoryAreaTree> children) {
		this.children = children;
	}

} 
