package com.example.story.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import com.example.freemake.util.JsonUtils;
import com.example.freemake.util.ReturnMsg;
import com.example.freemake.util.TableData;
import com.example.story.entity.StoryPerson;
import com.example.story.service.StoryAreaService;
import com.example.story.entity.StoryArea;
import com.example.story.entity.StoryAreaTree;

/**
 * @author zhouxiantao
 * @data 2018-02-26 15:41:30
 *
 * @version 1.0
 */

@Controller
@RequestMapping("storyArea")
public class StoryAreaController{

	@Autowired
	private StoryAreaService storyAreaService;
	
	private ReturnMsg msg;
	
	@RequiresPermissions("story:storyArea:tolist")
	@RequestMapping(value = "/toList", method = RequestMethod.GET)
	public ModelAndView toList (StoryArea storyArea,HttpServletRequest request,HttpServletResponse response)throws Exception{
		List<StoryArea> storyAreas = storyAreaService.pageList(0, 10, null);
		storyArea.setAreaParent("0");
		List<StoryAreaTree> storyAreaTrees = storyAreaService.findTree(storyArea);
		System.out.println(storyAreaTrees.toString());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("story/storyArea/storyArea_list");
		mv.addObject("storyAreas", storyAreas);
		mv.addObject("storyAreaTrees", storyAreaTrees);
		return mv;
	}
	
	@RequiresPermissions("story:storyArea:list")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public String list(StoryArea storyArea,HttpServletRequest request,HttpServletResponse response) {
		TableData pagingInfo = new TableData();
		try {
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			String nameKey = request.getParameter("nameKey");
			List<StoryArea> data = storyAreaService.pageList(pageIndex,pageSize,nameKey);
			
			long totalCount = storyAreaService.pageTotalCount();
			
			pagingInfo.setTotalCount(totalCount);
			pagingInfo.addRows(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagingInfo.toString();
	}
	
	@RequiresPermissions("story:storyArea:toAdd")
	@RequestMapping(value = "/toAdd", method = RequestMethod.GET)
	public ModelAndView toAdd (StoryArea storyArea,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.addObject("storyArea", storyArea);
		mv.setViewName("story/storyArea/storyArea_add");
		return mv;
	}
	
	@RequiresPermissions("story:storyArea:add")
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String add(StoryArea storyArea, HttpServletRequest request,HttpServletResponse response){
		try{
			long id = storyAreaService.maxid();
			storyArea.setId(id);
			if(storyArea.getAreaParent()!=null && (!"".equals(storyArea.getAreaParent()))){
				storyArea.setAreaParentids(storyArea.getAreaParent()+"-"+id);
			}else{
				storyArea.setAreaParent("0");
				storyArea.setAreaParentids(""+id);
			}
			
			int size = storyAreaService.insert(storyArea);
			msg = new ReturnMsg(true, "操作成功!" );
		} catch (Exception e) {
			msg = new ReturnMsg(false, "操作失败!" );
				e.printStackTrace();
			}
			return JsonUtils.objectToString(msg);
		}
		
	
	@RequiresPermissions("story:storyArea:toUpdate")	
	@RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
	public ModelAndView toModify (@RequestParam String id,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try{
			StoryArea data = storyAreaService.findById(id);
			mv.setViewName("story/storyArea/storyArea_edit");
			mv.addObject("data",data);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequiresPermissions("story:storyArea:update")	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String modify(@RequestParam StoryArea storyArea, HttpServletRequest request,HttpServletResponse response){
		try{
			int size = storyAreaService.update(storyArea);
			msg = new ReturnMsg(true, "操作成功!" );
		} catch (Exception e) {
			msg = new ReturnMsg(false, "操作失败!" );
				e.printStackTrace();
			}
			return JsonUtils.objectToString(msg);
		}
	
	@RequiresPermissions("story:storyArea:toDetail")
	@RequestMapping(value = "/toDetail", method = RequestMethod.GET)
	public ModelAndView toDetail (@RequestParam String id,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try{
			StoryArea data = storyAreaService.findById(id);
			mv.setViewName("story/storyArea/storyArea_detail");
			mv.addObject("data",data);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequiresPermissions("story:storyArea:del")
	@ResponseBody
	@RequestMapping(value="/del",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String del(@RequestParam String id, HttpServletRequest request,HttpServletResponse response){
		try{
			int size = storyAreaService.del(id);
			msg = new ReturnMsg(true, "操作成功!" );
		} catch (Exception e) {
			msg = new ReturnMsg(false, "操作失败!" );
			e.printStackTrace();
		}
		return JsonUtils.objectToString(msg);
	}
	

}
