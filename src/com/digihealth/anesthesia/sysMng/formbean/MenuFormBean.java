package com.digihealth.anesthesia.sysMng.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "系统菜单参数对象")
public class MenuFormBean {

	@ApiModelProperty(value = "主键id")
	private String id;

	@ApiModelProperty(value = "父id")
	private String pId;

	@ApiModelProperty(value = "菜单名称")
	private String name;

	@ApiModelProperty(value = "是否打开")
	private Boolean open;

	@ApiModelProperty(value = "是否选中")
	private Boolean checked;

	@ApiModelProperty(value = "按钮权限字符串列表")
	private String permission;

	// private MenuState state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	// public MenuState getState() {
	// return state;
	// }
	//
	// public void setState(MenuState state) {
	// this.state = state;
	// }

}
