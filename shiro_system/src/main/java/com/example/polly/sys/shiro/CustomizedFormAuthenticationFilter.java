package com.example.polly.sys.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomizedFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response){
		String username = getUsername(request);
        String password = getPassword(request);
        return (CustomizedToken)createToken(username, password, request, response);
	}
}
