package com.digihealth.anesthesia.interfacedata.formbean;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.digihealth.anesthesia.interfacedata.po.OperList;

public class HisToRegOptFormBean implements Serializable{
	@NotEmpty(message = "appkey不能为空!")
	private String appkey;
	@NotEmpty(message = "token不能为空!")
	private String token;
	private OperList operList;
	
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public OperList getOperList() {
		return operList;
	}
	public void setOperList(OperList operList) {
		this.operList = operList;
	}
	
	
}
