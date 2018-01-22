package com.example.story.service.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.story.entity.StoryPerson;
import com.example.story.service.StoryPersonService;
import com.example.story.dao.StoryPersonDao;

/**
 * @author zhouxiantao
 * @data 2018-01-03 15:11:16
 *
 * @version 1.0
 */

@Service
public class StoryPersonServiceImpl implements StoryPersonService{

	@Autowired
	private StoryPersonDao storyPersonDao;
	
	public int insert (StoryPerson storyPerson) throws Exception{
		return storyPersonDao.insert(storyPerson);
	}
 	
 	public int del(String id) throws Exception{
 		return storyPersonDao.del(id);
 	}
 	
 	public int update(StoryPerson storyPerson) throws Exception{
 		return storyPersonDao.update(storyPerson);
 	}
 	
 	public List<StoryPerson> pageList(int pageIndex,int pageSize,String nameKey) {
 		return storyPersonDao.pageList(pageIndex,pageSize,nameKey);
 	}
	
	public long pageTotalCount() throws Exception{
		return storyPersonDao.pageTotalCount();
	}
	
	public StoryPerson findById(String id) throws Exception{
		return storyPersonDao.findById(id);
	}

}