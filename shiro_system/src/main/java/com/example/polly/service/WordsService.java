package com.example.polly.service;

import java.util.List;

import com.example.polly.enty.Words;

public interface WordsService {
	public void createWords(Words words);
	public void deleteWords(int id);
	public Words getById(int id);
	public List<Words> findList(Words words);
}
