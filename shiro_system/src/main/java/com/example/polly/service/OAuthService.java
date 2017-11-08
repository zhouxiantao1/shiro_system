package com.example.polly.service;

import org.springframework.cache.CacheManager;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-17
 * <p>Version: 1.0
 */
public interface OAuthService {
	
    /**
     * 添加 auth code
     * */
    public void addAuthCode(String authCode, String username);
    
    /**
     * 添加 access token
     * */
    public void addAccessToken(String accessToken, String username);

    /**
     * 验证auth code是否有效
     * */
    boolean checkAuthCode(String authCode);
    /**
     * 验证access token是否有效
     * */
    boolean checkAccessToken(String accessToken);
    
    /**
     * 根据auth code 获取用户名
     * */
    String getUsernameByAuthCode(String authCode);
    /**
     * 根据access token获取用户名
     * */
    String getUsernameByAccessToken(String accessToken);

    /**
     * auth code / access token 过期时间
     * */
    long getExpireIn();


//    public boolean checkClientId(String clientId);
//
//    public boolean checkClientSecret(String clientSecret);


}
