package com.digihealth.anesthesia.sysMng.formbean;

import java.io.Serializable;
import java.util.List;

import com.digihealth.anesthesia.sysMng.po.BasMenu;
import com.digihealth.anesthesia.sysMng.po.BasRole;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "修改权限参数对象")
public class UpRoleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "权限对象")
	private BasRole role;

	@ApiModelProperty(value = "菜单数组对象")
	private List<BasMenu> menus;

	public BasRole getRole() {
		return role;
	}

	public void setRole(BasRole role) {
		this.role = role;
	}

	public List<BasMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<BasMenu> menus) {
		this.menus = menus;
	}

}
