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
	 * ����
	 * */
	public void createVerb(Verb verb);
	/**
	 * ɾ��
	 * */
	public void deleteVerb(int id);
	/**
	 * ����id��ѯ
	 * */
	public Verb getById(int id);
	/**
	 * ��ѯ�б�
	 * */
	public List<Verb> findList(Verb verb);
}
