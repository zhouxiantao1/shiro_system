package com.example.polly.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.polly.enty.Verb;
import com.example.polly.service.VerbService;
import com.example.polly.util.ImportExcel;

@Controller
@RequestMapping("/verb")
public class VerbController {
	@Autowired
	private VerbService verbService;
	
	/**
	 * 导入excel
	 * */
	@RequiresPermissions("word:verb:import")
	@RequestMapping("/import")
	public void importVerb(MultipartFile file, Model model){
		try {
			if(file!=null){
				ImportExcel ei = new ImportExcel(file, 1, 0);
				for (int i = 1; i < ei.getLastDataRowNum(); i++) {
					Row row = ei.getRow(i);
					Object val = ei.getCellValue(row, 0);
					Object val1 = ei.getCellValue(row, 34);
					Verb verb =new Verb();
					verb.setVerbName(val.toString());
					verb.setDescription(val1.toString());
					this.verbService.createVerb(verb);
				}
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 导入excel
	 * */
	@RequiresPermissions("word:verb:view")
	@RequestMapping("/importView")
	public String importVerbView(HttpServletRequest request, HttpServletResponse response, Model model){
		return "word/verb_import";
		
	}
	
}
