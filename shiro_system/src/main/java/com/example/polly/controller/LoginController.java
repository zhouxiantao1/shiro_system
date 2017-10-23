package com.example.polly.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value ="/login")
    public String showLoginForm(HttpServletRequest request, Model model) {
        String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "�û���/�������";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "�û���/�������";
        } else if(exceptionClassName != null) {
            error = "��������" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }
	@RequestMapping(value ="/")
    public String indexFrom(HttpServletRequest request, Model model) {
        return "index";
    }
}
