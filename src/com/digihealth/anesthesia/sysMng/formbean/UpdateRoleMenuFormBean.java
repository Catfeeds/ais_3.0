package com.digihealth.anesthesia.sysMng.formbean;

import java.util.List;

import com.digihealth.anesthesia.sysMng.po.BasRole;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "角色信息对象")
public class UpdateRoleMenuFormBean {

	@ApiModelProperty(value = "菜单模块")
	private String module;
	
	@ApiModelProperty(value = "角色对象")
	private BasRole role;
	
	@ApiModelProperty(value = "角色拥有的菜单列表")
	private List<MenuFormBean> roleMenus;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public BasRole getRole() {
		return role;
	}

	public void setRole(BasRole role) {
		this.role = role;
	}

	public List<MenuFormBean> getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(List<MenuFormBean> roleMenus) {
		this.roleMenus = roleMenus;
	}

}
