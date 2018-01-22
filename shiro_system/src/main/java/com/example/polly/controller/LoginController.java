package com.example.polly.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.polly.enty.Thirdparty;
import com.example.polly.enty.User;
import com.example.polly.service.UserService;
import com.example.polly.service.impl.PasswordHelper;
import com.example.polly.util.HttpUtil;

import net.sf.json.JSONObject;


@Controller
public class LoginController {
	 
    private final static String CLIENT_ID = "";
    private final static String CLIENT_SERCRET = "";
    private final static String GET_TOKEN_URL = "https://api.weibo.com/oauth2/access_token";
    private final static String REDIRECT_URI = "http://172.16.19.118:8090/shiro_system/";
    private final static String GET_USER_INFO = "https://api.weibo.com/2/users/show.json";
    private final static String GET_TOKEN_INFO_URL = "https://api.weibo.com/oauth2/get_token_info";
    private final static String STATE = "register";
	
    @Autowired
    private UserService userService;
    
	
	@RequestMapping(value ="/login")
    public String showLoginForm(HttpServletRequest request, Model model) {
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "�û���/�������";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "�û���/�������";
        } else if(exceptionClassName != null) {
            error = "�������" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }
	
	@RequestMapping(value ="/")
    public String indexFrom(HttpServletRequest request, Model model) {
        return "index";
    }
	
	@RequestMapping(value ="/testLogin")
    public String testLogin(HttpServletRequest request, Model model) {
		//��¼
		String username = request.getParameter("username");
		String password = request.getParameter("password");
    	Subject subject = SecurityUtils.getSubject();
    	UsernamePasswordToken loginToken = new UsernamePasswordToken(username, password);
    	try {
    		//��¼���������֤

    		subject.login(loginToken);
    		return "index";
    	} catch (AuthenticationException e) {
    		//�����֤ʧ��
    		return null;
    	}
    }
	
	@RequestMapping(value ="/weiboLogin")
    public String showtoken(HttpServletRequest request, Model model) {
       
        return "/weiboLogin";
    }
	/**
	 * ����΢����¼
	 * @throws OAuthSystemException 
	 * */
	@RequestMapping(value ="/weibogetlogin")
    public String weiboLogin(HttpSession session,HttpServletRequest request,HttpServletResponse response, Model model) throws OAuthSystemException {

		String error_code = request.getParameter("error_code");
		if(!StringUtils.isEmpty(error_code)){
			return null;
        }else{        	
        	//��ȡcode
            String code = request.getParameter("code");
            String access_token = "";
            String uid = "";
            //��ȡtoken
            JSONObject token = getAccessToken(code);
            access_token = token.getString("access_token");
            uid = token.getString("uid");//΢��id
            //��ȡ�û���Ϣ
            JSONObject userInfo = getUserInfo(access_token, uid);
            String name = userInfo.getString("screen_name");//΢���ǳ�
            String profile_image_url = userInfo.getString("profile_image_url");//ͷ���url
            String gender = "m".equals(userInfo.getString("gender"))?"1":"0";//�Ա�1-�У�0-Ů
            //�ж��û��Ƿ����
            Thirdparty thirdparty = new Thirdparty();
            thirdparty.setThirdpartyId(uid);
            List<Thirdparty> thirdpartys = userService.selectThirdparty(thirdparty);
            if(thirdpartys.size()>0){
            	Thirdparty thirdparty1 = thirdpartys.get(0);
            	User user = userService.findByUsername("admin");
            	//��¼
            	Subject subject = SecurityUtils.getSubject();
            	UsernamePasswordToken loginToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());
//            	CustomizedToken loginToken = new CustomizedToken(user.getUsername(), user.getPassword(),LoginType.THRID_TYPE);
            	try {
            		loginToken.setRememberMe(true);
            		//��¼���������֤
            		subject.login(loginToken);
            	} catch (AuthenticationException e) {
            		//�����֤ʧ��
            	}
            }else{
            	//�����û�
            	User user = new User();
            	user.setUsername(name);
            	user.setPassword("123456");
            	PasswordHelper passwordHelper = new PasswordHelper();
                passwordHelper.encryptPassword(user);
                user.setRealName(name);
                thirdparty.setUserName(user.getUsername());
                thirdparty.setThirdpartyType("weibo");
                thirdparty.setAvailable("0");
            	userService.createThirdparty(thirdparty);
            	userService.createUser(user);
            	//��¼
            	Subject subject = SecurityUtils.getSubject();
            	UsernamePasswordToken loginToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            	try {
            		loginToken.setRememberMe(true);
            		//��¼���������֤
            		subject.login(loginToken);
            	} catch (AuthenticationException e) {
            		//�����֤ʧ��
            	}
            }  
           
        	return "index";
        }
        
    }
	
	/**
     * ��ȡAccessToken
     */
    private JSONObject getAccessToken(String code) {
    	String url = "https://api.weibo.com/oauth2/access_token";  
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("grant_type", "authorization_code");
        map.put("client_id", "3472698345");
        map.put("client_secret", "a26c3f2cf4c26109df1489de1997104e");
        map.put("redirect_uri", "http://172.16.19.118:8090/shiro_system/weibogetlogin");
        map.put("code", code);   
        String result = HttpUtil.httpPost(url,map);
        System.out.println("===========result============"+result);
        /**
         * �������
         *  {
         *      "access_token": "ACCESS_TOKEN",
         *      "expires_in": 1234,
         *      "remind_in":"798114",
         *      "uid":"12341234"
         *  }
         */
        JSONObject json =JSONObject.fromObject(result);
        return json;
    }
    
    /**
     * ��ȡ�û���Ϣ
     * @param access_token
     * @param uid ��ѯ���û�ID
     * @return
     */
    private JSONObject getUserInfo(String access_token,String uid){
        StringBuilder sb = new StringBuilder();
        sb.append("access_token=" + access_token);
        sb.append("&uid=" + uid);
        String result = HttpUtil.httpGet(GET_USER_INFO,sb.toString());
        //���ز���鿴http://open.weibo.com/wiki/2/users/show
        JSONObject json =JSONObject.fromObject(result);
        return json;
    }
    
    
}
