package com.example.story.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import com.example.story.entity.StoryArea;
import com.example.story.entity.StoryAreaTree;

/**
 * @author zhouxiantao
 * @data 2018-02-26 15:41:30
 *
 * @version 1.0
 */
 

 public interface StoryAreaDao{
 
 	public int insert (StoryArea storyArea) throws Exception;
 	
 	public int del(String id) throws Exception;
 	
 	public int update(StoryArea storyArea) throws Exception;
 	
 	public List<StoryArea> pageList(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("nameKey")String nameKey) throws Exception;
	
	public long pageTotalCount() throws Exception;
	
	public StoryArea findById(String id) throws Exception;
	
	public long maxid();
	
	public List<StoryAreaTree> findTree(StoryArea storyArea);
 
 }
	
	
	
	

	
