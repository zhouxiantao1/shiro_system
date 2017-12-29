package com.example.polly.service;

import java.util.List;

import com.example.polly.enty.Verb;
/**
 * <p>User: zhouxiantao
 * <p>Date: 17-11-27
 * <p>Version: 1.0
 * */
public interface VerbService {
	/**
	 * 新增
	 * */
	public void createVerb(Verb verb);
	/**
	 * 删除
	 * */
	public void deleteVerb(int id);
	/**
	 * 根据id查询
	 * */
	public Verb getById(int id);
	/**
	 * 查询列表
	 * */
	public List<Verb> findList(Verb verb);
}
