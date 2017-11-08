package com.example.polly.sys.shiro;

public class LoginType {
	public static final  String USER_TYPE = "userRealm";
	public static final String THRID_TYPE = "thirdpartyRealm";

    private String type;

    private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
