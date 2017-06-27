package com.digihealth.anesthesia.sysMng.formbean;

import java.util.List;

import com.digihealth.anesthesia.sysMng.po.BasMenu;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询菜单参数对象")
public class BasMenuFormBean extends BasMenu {

	@ApiModelProperty(value = "当前页码")
	private Integer pageNo;

	@ApiModelProperty(value = "每页显示多少条")
	private Integer pageSize;

	private Boolean open;
	private Boolean checked;
	// private MenuState state;

	private String pId;

	/**
	 * 菜单权限对象
	 */
	private List<ButtonPermission> buttonPermissionList;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	public List<ButtonPermission> getButtonPermissionList() {
		return buttonPermissionList;
	}

	public void setButtonPermissionList(List<ButtonPermission> buttonPermissionList) {
		this.buttonPermissionList = buttonPermissionList;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

}
