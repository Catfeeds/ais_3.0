package com.digihealth.anesthesia.sysMng.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "参数对象")
public class CheckButtonPermission {
	
	@ApiModelProperty(value = "id")
	String id;
	
	@ApiModelProperty(value = "名称")
	String name;
	
	// 菜单 permission
	@ApiModelProperty(value = "菜单权限")
	String permission;
	
	// 角色拥有的 permission
	@ApiModelProperty(value = "角色拥有的权限")
	String permission2;

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
		this.name = name;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission2() {
		return permission2;
	}

	public void setPermission2(String permission2) {
		this.permission2 = permission2;
	}

}
