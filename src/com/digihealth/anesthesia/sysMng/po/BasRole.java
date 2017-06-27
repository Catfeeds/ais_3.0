/*
 * BasRole.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-23 Created
 */
package com.digihealth.anesthesia.sysMng.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "系统角色对象")
public class BasRole {
	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "主键id")
	private String id;
	/**
	 * 角色名称
	 */
	@ApiModelProperty(value = "角色名称")
	private String name;

	@ApiModelProperty(value = "菜单名称")
	private String menuName;
	/**
	 * 描述
	 */
	@ApiModelProperty(value = "描述")
	private String description;

	/**
	 * 是否可用:1-可用，0-不可用
	 */
	@ApiModelProperty(value = "是否可用:1-可用，0-不可用")
	private Integer enable;

	/**
	 * 局点id
	 */
	@ApiModelProperty(value = "局点id")
	private String beid;

	/**
	 * 局点名字
	 */
	@ApiModelProperty(value = "局点名字")
	private String beName;
	/**
	 * 角色类型 运营管理员：OPERATOR_ADMIN,系统管理员：ADMIN,麻醉医生：ANAES_DOCTOR,护士：NURSE,护士长：
	 * HEAD_NURSE,麻醉主任：ANAES_DIRECTOR,其他：OTHER
	 */
	@ApiModelProperty(value = "角色类型 运营管理员：OPERATOR_ADMIN,系统管理员：ADMIN,麻醉医生：ANAES_DOCTOR,护士：NURSE,护士长：HEAD_NURSE,麻醉主任：ANAES_DIRECTOR,其他：OTHER")
	private String roleType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

	public String getBeName() {
		return beName;
	}

	public void setBeName(String beName) {
		this.beName = beName;
	}

	public String getRoleType() {
		return roleType = roleType == null ? null : roleType.trim();
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

}