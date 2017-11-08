package com.example.polly.service.impl;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polly.service.ClientService;
import com.example.polly.service.OAuthService;
import com.example.polly.sys.spring.SpringUtils;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-17
 * <p>Version: 1.0
 */

public class OAuthServiceImpl implements OAuthService {
	
    private Cache cache;

    public void setCacheManager(CacheManager cacheManager){
    	this.cache = cacheManager.getCache("code-cache");
    }
    
    public void addAuthCode(String authCode, String username) {
    	
        cache.put(authCode, username);
        System.out.println("=======authCode========"+authCode);
        System.out.println("=======cache========"+cache.get(authCode));
    }


    public void addAccessToken(String accessToken, String username) {
        cache.put(accessToken, username);
    }


    public String getUsernameByAuthCode(String authCode) {
        return (String)cache.get(authCode);
    }


    public String getUsernameByAccessToken(String accessToken) {
        return (String)cache.get(accessToken);
    }


    public boolean checkAuthCode(String authCode) {
    	System.out.println("=======authCode========"+authCode);
    	System.out.println("=======cache11========"+cache.get(authCode));
        return cache.get(authCode) != null;
    }

 
    public boolean checkAccessToken(String accessToken) {
        return cache.get(accessToken) != null;
    }


//    public boolean checkClientId(String clientId) {
//        return clientService.findByClientId(clientId) != null;
//    }
//
//
//    public boolean checkClientSecret(String clientSecret) {
//        return clientService.findByClientKey(clientSecret) != null;
//    }

    /**
     * 令牌的有效时间
     * */
    public long getExpireIn() {
        return 3600L;
    }


}
