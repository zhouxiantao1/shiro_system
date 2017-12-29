package com.example.polly.dao;

import java.util.List;

import com.example.polly.enty.Verb;
import com.example.polly.util.MyBatisDao;
/**
 * <p>User: zhouxiantao
 * <p>Date: 17-11-27
 * <p>Version: 1.0
 * */
@MyBatisDao
public interface VerbDao {
	public void createVerb(Verb verb);
	public void deleteVerb(int id);
	public Verb getById(int id);
	public List<Verb> findList(Verb verb);
	
}
