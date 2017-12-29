package com.example.polly.controller;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.polly.enty.Words;
import com.example.polly.service.WordsService;
import com.example.polly.util.ImportExcel;

@Controller
@RequestMapping("/words")
public class WordsController {
	@Autowired
	private WordsService wordsService;
	/**
	 * µº»Îexcel
	 * */
	@RequiresPermissions("word:words:import")
	@RequestMapping("/import")
	public void importVerb(MultipartFile file, Model model){
		try {
			if(file!=null){
				ImportExcel ei = new ImportExcel(file, 1, 0);
				for (int i = 1; i < ei.getLastDataRowNum(); i++) {
					Row row = ei.getRow(i);
					Object val = ei.getCellValue(row, 0);
					Object val1 = ei.getCellValue(row, 34);
					Words words =new Words();
					words.setName(ei.getCellValue(row, 1).toString());
					words.setType(ei.getCellValue(row, 2).toString());
					words.setTypeName(ei.getCellValue(row, 3).toString());
					words.setAppearNum(ei.getCellValue(row, 4).toString());
					words.setAppearFreq(ei.getCellValue(row, 5).toString());
					this.wordsService.createWords(words);
				}
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
