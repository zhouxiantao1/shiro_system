package com.example.polly.sys.view;

import java.io.File;
import java.util.Locale;

import org.springframework.web.servlet.view.InternalResourceView;
   /** 
	*  覆盖springmvc返回视图类型，来实现多种类型
	* @ClassName: HtmlResourceView  
	* @author zhouxiantao  
	* @date 2017-12-25
	* 
     */ 
public class HtmlResourceView extends InternalResourceView{
	@Override  
    public boolean checkResource(Locale locale) {  
     File file = new File(this.getServletContext().getRealPath("/") + getUrl());  
     return file.exists();// 判断该页面是否存在  
    }  
}
