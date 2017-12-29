package com.example.polly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polly.dao.WordsDao;
import com.example.polly.enty.Words;
import com.example.polly.service.WordsService;

@Service
public class WordsServiceImp implements WordsService{
	@Autowired
	private WordsDao wordsDao;
	
	public void createWords(Words words) {
		wordsDao.createWords(words);
	}

	public void deleteWords(int id) {
		wordsDao.deleteWords(id);
	}

	public Words getById(int id) {
		return wordsDao.getById(id);
	}

	public List<Words> findList(Words words) {
		return wordsDao.findList(words);
	}

}
