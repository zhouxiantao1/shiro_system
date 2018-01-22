package com.example.story.service;

import java.util.*;
import com.example.story.entity.StoryPerson;

/**
 * @author zhouxiantao
 * @data 2018-01-03 15:11:16
 *
 * @version 1.0
 */
 

 public interface StoryPersonService {
 
 	public int insert (StoryPerson storyPerson) throws Exception;
 	
 	public int del(String id) throws Exception;
 	
 	public int update(StoryPerson storyPerson) throws Exception;
 	
 	public List<StoryPerson> pageList(int pageIndex,int pageSize,String nameKey);
	
	public long pageTotalCount() throws Exception;
	
	public StoryPerson findById(String id) throws Exception;
 
 }
	
	
	
	

	
