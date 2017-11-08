package com.example.polly.sys.shiro;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import com.mysql.jdbc.StringUtils;

public class CustomizedModularRealmAuthenticator extends ModularRealmAuthenticator{
	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// �ж�getRealms()�Ƿ񷵻�Ϊ��
		assertRealmsConfigured();
		// ǿ��ת�����Զ����CustomizedToken
		CustomizedToken customizedToken = (CustomizedToken) authenticationToken;
		// ��¼����
		String loginType = customizedToken.getLoginType();
		// ����Realm
		Collection<Realm> realms = getRealms();
		// ��¼���Ͷ�Ӧ������Realm
		Collection<Realm> typeRealms = new ArrayList<Realm>();

		for (Realm realm : realms) {
			if(StringUtils.isNullOrEmpty(loginType)){
				if(realm.getName().contains(LoginType.USER_TYPE)){
					typeRealms.add(realm);
				}
				typeRealms = realms;
			}else{
				if (realm.getName().contains(loginType)){
					typeRealms.add(realm);
				}		
			}			
		}
		
		// �ж��ǵ�Realm���Ƕ�Realm
		if (typeRealms.size() == 1)
			return doSingleRealmAuthentication(typeRealms.iterator().next(), customizedToken);
		else
			return doMultiRealmAuthentication(typeRealms, customizedToken);
	}
}
