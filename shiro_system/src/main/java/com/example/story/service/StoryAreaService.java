package com.example.story.service;

import java.util.*;
import com.example.story.entity.StoryArea;
import com.example.story.entity.StoryAreaTree;

/**
 * @author zhouxiantao
 * @data 2018-02-23 16:44:42
 *
 * @version 1.0
 */
 

 public interface StoryAreaService {
 
 	public int insert (StoryArea storyArea) throws Exception;
 	
 	public int del(String id) throws Exception;
 	
 	public int update(StoryArea storyArea) throws Exception;
 	
 	public List<StoryArea> pageList(int pageIndex,int pageSize,String nameKey) throws Exception;
	
	public long pageTotalCount() throws Exception;
	
	public StoryArea findById(String id) throws Exception;
	
	public long maxid();
	
	public List<StoryAreaTree> findTree(StoryArea storyArea);
 
 }
	
	
	
	

	
