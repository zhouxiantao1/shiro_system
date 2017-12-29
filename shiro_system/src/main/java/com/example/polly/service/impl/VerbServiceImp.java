package com.example.polly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polly.dao.VerbDao;
import com.example.polly.enty.Verb;
import com.example.polly.service.VerbService;
/**
 * <p>User: zhouxiantao
 * <p>Date: 17-11-27
 * <p>Version: 1.0
 * */
@Service
public class VerbServiceImp implements VerbService {
	@Autowired
	private VerbDao verbDao;
	/**
	 * 新增
	 * */
	public void createVerb(Verb verb){
		verbDao.createVerb(verb);
	}
	/**
	 * 删除
	 * */
	public void deleteVerb(int id){
		verbDao.deleteVerb(id);
	}
	/**
	 * 根据id查询
	 * */
	public Verb getById(int id){
		return verbDao.getById(id);
	}
	/**
	 * 查询列表
	 * */
	public List<Verb> findList(Verb verb){
		return verbDao.findList(verb);
	}

}
