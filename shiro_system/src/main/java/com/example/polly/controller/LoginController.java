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
import com.example.polly.sys.shiro.CustomizedToken;
import com.example.polly.sys.shiro.LoginType;
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
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
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
		//登录
		String username = request.getParameter("username");
		String password = request.getParameter("password");
    	Subject subject = SecurityUtils.getSubject();
    	UsernamePasswordToken loginToken = new UsernamePasswordToken(username, password);
    	try {
    		//登录，即身份验证

    		subject.login(loginToken);
    		return "index";
    	} catch (AuthenticationException e) {
    		//身份验证失败
    		return null;
    	}
    }
	
	@RequestMapping(value ="/weiboLogin")
    public String showtoken(HttpServletRequest request, Model model) {
       
        return "/weiboLogin";
    }
	/**
	 * 第三方微博登录
	 * @throws OAuthSystemException 
	 * */
	@RequestMapping(value ="/weibogetlogin")
    public String weiboLogin(HttpSession session,HttpServletRequest request,HttpServletResponse response, Model model) throws OAuthSystemException {

		String error_code = request.getParameter("error_code");
		if(!StringUtils.isEmpty(error_code)){
			return null;
        }else{        	
        	//获取code
            String code = request.getParameter("code");
            String access_token = "";
            String uid = "";
            //获取token
            JSONObject token = getAccessToken(code);
            access_token = token.getString("access_token");
            uid = token.getString("uid");//微博id
            //获取用户信息
            JSONObject userInfo = getUserInfo(access_token, uid);
            String name = userInfo.getString("screen_name");//微博昵称
            String profile_image_url = userInfo.getString("profile_image_url");//头像的url
            String gender = "m".equals(userInfo.getString("gender"))?"1":"0";//性别1-男，0-女
            //判断用户是否存在
            Thirdparty thirdparty = new Thirdparty();
            thirdparty.setThirdpartyId(uid);
            List<Thirdparty> thirdpartys = userService.selectThirdparty(thirdparty);
            if(thirdpartys.size()>0){
            	Thirdparty thirdparty1 = thirdpartys.get(0);
            	User user = userService.findByUsername("admin");
            	//登录
            	Subject subject = SecurityUtils.getSubject();
            	CustomizedToken loginToken = new CustomizedToken(user.getUsername(), user.getPassword(),LoginType.THRID_TYPE);
            	try {
            		loginToken.setRememberMe(true);
            		//登录，即身份验证
            		subject.login(loginToken);
            	} catch (AuthenticationException e) {
            		//身份验证失败
            	}
            }else{
            	//新增用户
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
            	//登录
            	Subject subject = SecurityUtils.getSubject();
            	UsernamePasswordToken loginToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            	try {
            		loginToken.setRememberMe(true);
            		//登录，即身份验证
            		subject.login(loginToken);
            	} catch (AuthenticationException e) {
            		//身份验证失败
            	}
            }  
           
        	return "index";
        }
        
    }
	
	/**
     * 获取AccessToken
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
         * 返回数据
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
     * 获取用户信息
     * @param access_token
     * @param uid 查询的用户ID
     * @return
     */
    private JSONObject getUserInfo(String access_token,String uid){
        StringBuilder sb = new StringBuilder();
        sb.append("access_token=" + access_token);
        sb.append("&uid=" + uid);
        String result = HttpUtil.httpGet(GET_USER_INFO,sb.toString());
        //返回参数：查看http://open.weibo.com/wiki/2/users/show
        JSONObject json =JSONObject.fromObject(result);
        return json;
    }
    
    
}
