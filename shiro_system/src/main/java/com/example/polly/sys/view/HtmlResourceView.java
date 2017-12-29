package com.example.polly.sys.view;

import java.io.File;
import java.util.Locale;

import org.springframework.web.servlet.view.InternalResourceView;
   /** 
	*  ����springmvc������ͼ���ͣ���ʵ�ֶ�������
	* @ClassName: HtmlResourceView  
	* @author zhouxiantao  
	* @date 2017-12-25
	* 
     */ 
public class HtmlResourceView extends InternalResourceView{
	@Override  
    public boolean checkResource(Locale locale) {  
     File file = new File(this.getServletContext().getRealPath("/") + getUrl());  
     return file.exists();// �жϸ�ҳ���Ƿ����  
    }  
}
