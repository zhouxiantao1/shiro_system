package com.example.story.service.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.story.entity.StoryArea;
import com.example.story.entity.StoryAreaTree;
import com.example.story.service.StoryAreaService;
import com.example.story.dao.StoryAreaDao;

/**
 * @author zhouxiantao
 * @data 2018-02-23 16:44:42
 *
 * @version 1.0
 */

@Service("storyAreaService")
public class StoryAreaServiceImpl implements StoryAreaService{

	@Autowired
	private StoryAreaDao storyAreaDao;
	
	public int insert (StoryArea storyArea) throws Exception{
		return storyAreaDao.insert(storyArea);
	}
 	
 	public int del(String id) throws Exception{
 		return storyAreaDao.del(id);
 	}
 	
 	public int update(StoryArea storyArea) throws Exception{
 		return storyAreaDao.update(storyArea);
 	}
 	
 	public List<StoryArea> pageList(int pageIndex,int pageSize,String nameKey) throws Exception{
 		return storyAreaDao.pageList(pageIndex,pageSize,nameKey);
 	}
	
	public long pageTotalCount() throws Exception{
		return storyAreaDao.pageTotalCount();
	}
	
	public StoryArea findById(String id) throws Exception{
		return storyAreaDao.findById(id);
	}
	
	public long maxid(){
		return storyAreaDao.maxid();
	}
	
	public List<StoryAreaTree> findTree(StoryArea storyArea){
		return storyAreaDao.findTree(storyArea);
	}

}