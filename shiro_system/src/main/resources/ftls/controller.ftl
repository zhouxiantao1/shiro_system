package ${pack};

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
${importservice};
${importEntity};

/**
 * @author ${annotation.authorName}
 * @data ${annotation.date}
 *
 * @version ${annotation.version}
 */

@Controller
@RequestMapping("${className}")
public class ${ClassName}Controller{

	@Autowired
	private ${ClassName}Service ${className}Service;
	
	private ReturnMsg msg;
	
	@RequiresPermissions("${module}:${className}:tolist")
	@RequestMapping(value = "/toList", method = RequestMethod.GET)
	public ModelAndView toList (HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("${module}/${className}/${className}_list");
		return mv;
	}
	
	@RequiresPermissions("${module}:${className}:list")
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public String list(HttpServletRequest request,HttpServletResponse response) {
		TableData pagingInfo = new TableData();
		try {
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			String nameKey = request.getParameter("nameKey");
			List<${ClassName}> data = ${className}Service.pageList(pageIndex,pageSize,nameKey);
			long totalCount = ${className}Service.pageTotalCount();
			
			pagingInfo.setTotalCount(totalCount);
			pagingInfo.addRows(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagingInfo.toString();
	}
	
	@RequiresPermissions("${module}:${className}:toAdd")
	@RequestMapping(value = "/toAdd", method = RequestMethod.GET)
	public ModelAndView toAdd (HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("${module}/${className}/${className}_add");
		return mv;
	}
	
	@RequiresPermissions("${module}:${className}:add")
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String add(@RequestParam ${ClassName} ${className}, HttpServletRequest request,HttpServletResponse response){
		try{
			int size = ${className}Service.insert(${className});
			msg = new ReturnMsg(true, "操作成功!" );
		} catch (Exception e) {
			msg = new ReturnMsg(false, "操作失败!" );
				e.printStackTrace();
			}
			return JsonUtils.objectToString(msg);
		}
		
	
	@RequiresPermissions("${module}:${className}:toUpdate")	
	@RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
	public ModelAndView toModify (@RequestParam String ${Pk},HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try{
			${ClassName} data = ${className}Service.findById(${Pk});
			mv.setViewName("${module}/${className}/${className}_edit");
			mv.addObject("data",data);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequiresPermissions("${module}:${className}:update")	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String modify(@RequestParam ${ClassName} ${className}, HttpServletRequest request,HttpServletResponse response){
		try{
			int size = ${className}Service.update(${className});
			msg = new ReturnMsg(true, "操作成功!" );
		} catch (Exception e) {
			msg = new ReturnMsg(false, "操作失败!" );
				e.printStackTrace();
			}
			return JsonUtils.objectToString(msg);
		}
	
	@RequiresPermissions("${module}:${className}:toDetail")
	@RequestMapping(value = "/toDetail", method = RequestMethod.GET)
	public ModelAndView toAdd (@RequestParam String ${Pk},HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try{
			${ClassName} data = ${className}Service.findById(${Pk});
			mv.setViewName("${module}/${className}/${className}_detail");
			mv.addObject("data",data);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequiresPermissions("${module}:${className}:del")
	@ResponseBody
	@RequestMapping(value="/del",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	public String del(@RequestParam String ${Pk}, HttpServletRequest request,HttpServletResponse response){
		try{
			int size = ${className}Service.del(${Pk});
			msg = new ReturnMsg(true, "操作成功!" );
		} catch (Exception e) {
			msg = new ReturnMsg(false, "操作失败!" );
			e.printStackTrace();
		}
		return JsonUtils.objectToString(msg);
	}
	

}
