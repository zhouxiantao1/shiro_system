package com.example.polly.dao;

import java.util.List;

import com.example.polly.enty.Words;
import com.example.polly.util.MyBatisDao;

/**
 * <p>User: zhouxiantao
 * <p>Date: 17-11-27
 * <p>Version: 1.0
 * */
@MyBatisDao
public interface WordsDao {
	public void createWords(Words words);
	public void deleteWords(int id);
	public Words getById(int id);
	public List<Words> findList(Words words);
}
