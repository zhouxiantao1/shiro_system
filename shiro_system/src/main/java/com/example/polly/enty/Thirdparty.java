package com.example.polly.enty;

public class Thirdparty {
	private int id;
	private String thirdpartyId;//第三方ID
	private String userName;//本地用户名
	private String thirdpartyType;//第三方类型
	private String available;//是否可用 0-可用，1-不可用
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getThirdpartyId() {
		return thirdpartyId;
	}
	public void setThirdpartyId(String thirdpartyId) {
		this.thirdpartyId = thirdpartyId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getThirdpartyType() {
		return thirdpartyType;
	}
	public void setThirdpartyType(String thirdpartyType) {
		this.thirdpartyType = thirdpartyType;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
}
