/*
 * BasRoleMenu.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-23 Created
 */
package com.digihealth.anesthesia.sysMng.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "角色菜单权限对象")
public class BasRoleMenu {
	/**
	 * 权限表ID
	 */
	@ApiModelProperty(value = "权限表ID")
	private String menuId;

	/**
	 * 角色表ID
	 */
	@ApiModelProperty(value = "角色表ID")
	private String roleId;

	/**
	 * 局点id
	 */
	@ApiModelProperty(value = "局点id")
	private String beid;

	/**
	 * 按钮权限字符串：1、查询列表 Q_LIST ,2、查询详情 Q_DET , 3、添加
	 * ADD（手动录入）,4、修改UPD（批准手术、取消、保存、提交、归档、退档）,5、删除 DEL,6、his同步
	 * H_SYNC（his导入）,7、数据导入 IMP,8、批量执行 BATEXEC 9、打印 PRINT,10、文书完成情况 DOCFIN
	 * 11、批量打印、一键打印 KEYPRINT 12、导出数据、导出excel EXP, 13、对比 COMPARE 14、选择模板
	 * CHOOSE(应用暂时先不算)
	 */
	@ApiModelProperty(value = "按钮权限字符串列表")
	private String permission;

	public BasRoleMenu() {
		super();
	}

	public BasRoleMenu(String menuId, String roleId, String beid, String permission) {
		super();
		this.menuId = menuId;
		this.roleId = roleId;
		this.beid = beid;
		this.permission = permission;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid == null ? null : beid.trim();
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission == null ? null : permission.trim();
	}
}