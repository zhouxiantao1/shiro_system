package com.example.story.controller;

import java.util.*;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.freemake.util.JsonUtils;
import com.example.freemake.util.ReturnMsg;
import com.example.freemake.util.SockTest;
import com.example.freemake.util.TableData;
import com.example.story.entity.StoryPerson;
import com.example.story.service.StoryPersonService;

/**
 * @author zhouxiantao
 * @data 2018-01-03 15:11:16
 *
 * @version 1.0
 */

@Controller
@RequestMapping("/storyPerson")
public class StoryPersonController{

	@Autowired
	private StoryPersonService storyPersonService;
	
	private SockTest sockTest;
	
	private ReturnMsg msg;
	
	@RequiresPermissions("story:storyPerson:tolist")
	@RequestMapping(value = "/toList", method = RequestMethod.GET)
	public ModelAndView toList (HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		List<StoryPerson> storypersons = storyPersonService.pageList(0, 10, "");
		mv.addObject("storypersons", storypersons);
		mv.setViewName("story/storyPerson_list");
		System.out.println("=============="+sockTest);
		return mv;
	}
	
	@RequiresPermissions("story:storyPerson:list")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public String list(HttpServletRequest request,HttpServletResponse response) {
		TableData pagingInfo = new TableData();
		try {
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			String nameKey = request.getParameter("nameKey");
			List<StoryPerson> data = storyPersonService.pageList(pageIndex,pageSize,nameKey);
			long totalCount = storyPersonService.pageTotalCount();
			
			pagingInfo.setTotalCount(totalCount);
			pagingInfo.addRows(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagingInfo.toString();
	}
	
	@RequiresPermissions("story:storyPerson:toAdd")
	@RequestMapping(value = "/toAdd", method = RequestMethod.GET)
	public ModelAndView toAdd (HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("story/storyPerson_add");
		return mv;
	}
	
	@RequiresPermissions("story:storyPerson:add")
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String add(StoryPerson storyPerson, HttpServletRequest request,HttpServletResponse response){
		try{
			int size = storyPersonService.insert(storyPerson);
			msg = new ReturnMsg(true, "操作成功!" );
		} catch (Exception e) {
			msg = new ReturnMsg(false, "操作失败!" );
				e.printStackTrace();
			}
			return JsonUtils.objectToString(msg);
		}
		
	
	@RequiresPermissions("story:storyPerson:toUpdate")	
	@RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
	public ModelAndView toModify (@RequestParam String id,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try{
			StoryPerson data = storyPersonService.findById(id);
			mv.setViewName("story/storyPerson_edit");
			mv.addObject("data",data);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequiresPermissions("story:storyPerson:update")	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String modify(StoryPerson storyPerson, HttpServletRequest request,HttpServletResponse response){
		try{
			int size = storyPersonService.update(storyPerson);
			msg = new ReturnMsg(true, "操作成功!" );
		} catch (Exception e) {
			msg = new ReturnMsg(false, "操作失败!" );
				e.printStackTrace();
			}
			return JsonUtils.objectToString(msg);
		}
	
	@RequiresPermissions("story:storyPerson:toDetail")
	@RequestMapping(value = "/toDetail", method = RequestMethod.GET)
	public ModelAndView toAdd (@RequestParam String id,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try{
			StoryPerson storyPerson = storyPersonService.findById(id);
			mv.setViewName("story/storyPerson_detail");
			mv.addObject("data",storyPerson);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequiresPermissions("story:storyPerson:del")
	@ResponseBody
	@RequestMapping(value="/del",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String del(@RequestParam String id, HttpServletRequest request,HttpServletResponse response){
		try{
			int size = storyPersonService.del(id);
			msg = new ReturnMsg(true, "操作成功!" );
		} catch (Exception e) {
			msg = new ReturnMsg(false, "操作失败!" );
			e.printStackTrace();
		}
		return JsonUtils.objectToString(msg);
	}
	

}
