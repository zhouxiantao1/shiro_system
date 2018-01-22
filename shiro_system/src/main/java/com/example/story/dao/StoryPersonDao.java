package com.example.story.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;

import com.example.polly.util.MyBatisDao;
import com.example.story.entity.StoryPerson;

/**
 * @author zhouxiantao
 * @data 2018-01-03 15:11:16
 *
 * @version 1.0
 */
 
@MyBatisDao
 public interface StoryPersonDao{
 
 	public int insert (StoryPerson storyPerson) throws Exception;
 	
 	public int del(String id) throws Exception;
 	
 	public int update(StoryPerson storyPerson) throws Exception;
 	
 	public List<StoryPerson> pageList(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("nameKey")String nameKey);
	
	public long pageTotalCount() throws Exception;
	
	public StoryPerson findById(String id) throws Exception;
 
 }
	
	
	
	

	
