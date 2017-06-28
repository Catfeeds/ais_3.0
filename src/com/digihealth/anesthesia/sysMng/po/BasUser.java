/*
 * BasUser.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-23 Created
 */
package com.digihealth.anesthesia.sysMng.po;

import java.io.Serializable;
import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "系统用户对象")
public class BasUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "基线id")
	private String beid;
	/**
	 * 登录名
	 */
	@ApiModelProperty(value = "登录名")
	private String userName;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	private String password;

	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	private String name;

	/**
	 * 手机
	 */
	@ApiModelProperty(value = "手机")
	private String mobile;

	/**
	 * 邮箱
	 */
	@ApiModelProperty(value = "邮箱")
	private String email;

	/**
	 * 图片
	 */
	@ApiModelProperty(value = "图片")
	private String photo;

	/**
	 * 登录IP地址
	 */
	@ApiModelProperty(value = "登录IP地址")
	private String loginIp;

	/**
	 * 最后登录时间
	 */
	@ApiModelProperty(value = "最后登录时间")
	private Date loginDate;

	/**
	 * 创建者
	 */
	@ApiModelProperty(value = "创建者")
	private String createUser;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	@ApiModelProperty(value = "拼音")
	private String pinYin;
	/**
	 * 是否锁定:1-锁定，0-未锁定
	 */
	@ApiModelProperty(value = "是否锁定:1-锁定，0-未锁定")
	private Integer locked;

	/**
	 * 是否可用:1-可用，0-不可用
	 */
	@ApiModelProperty(value = "是否可用:1-可用，0-不可用")
	private Integer enable;

	/**
	 * 盐
	 */
	@ApiModelProperty(value = "盐")
	private String salt;

	/**
	 * TOKEN
	 */
	@ApiModelProperty(value = "TOKEN")
	private String token;

	/**
	 * 用户类型 系统管理员：ADMIN ,医生：DOCTOR,护士：NURSE,护士长：HEAD_NURSE,主任医生：ARCHIATER
	 */
	@ApiModelProperty(value = "用户类型 系统管理员：ADMIN ,医生：DOCTOR,护士：NURSE,护士长：HEAD_NURSE,主任医生：ARCHIATER")
	private String userType;

	/**
	 * 职称
	 */
	@ApiModelProperty(value = "职称")
	private String professionalTitle;

	/**
	 * 行政级别
	 */
	@ApiModelProperty(value = "行政级别")
	private String executiveLevel;

	/**
	 * 角色ID
	 */
	@ApiModelProperty(value = "角色ID")
	private String roleId;

	/**
	 * 角色名称
	 */
	@ApiModelProperty(value = "角色名称")
	private String roleName;

	/**
	 * 角色类型
	 */
	@ApiModelProperty(value = "角色类型")
	private String roleType;

	/**
	 * 局点名称
	 */
	@ApiModelProperty(value = "局点名称")
	private String beName;

	/**
	 * 局点编码
	 */
	@ApiModelProperty(value = "局点编码")
	private String beCode;
	
	/**
	 * 子名称
	 */
	@ApiModelProperty(value = "子名称")
	private String subName;

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getCredentialsSalt() {
		return userName + salt;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo == null ? null : photo.trim();
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp == null ? null : loginIp.trim();
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType == null ? null : userType.trim();
	}

	public String getPinYin() {
		return pinYin;
	}

	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}

	public String getProfessionalTitle() {
		return professionalTitle;
	}

	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle == null ? null : professionalTitle.trim();
	}

	public String getExecutiveLevel() {
		return executiveLevel;
	}

	public void setExecutiveLevel(String executiveLevel) {
		this.executiveLevel = executiveLevel == null ? null : executiveLevel.trim();
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getBeName() {
		return beName;
	}

	public void setBeName(String beName) {
		this.beName = beName;
	}

	public String getBeCode() {
		return beCode;
	}

	public void setBeCode(String beCode) {
		this.beCode = beCode;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

}