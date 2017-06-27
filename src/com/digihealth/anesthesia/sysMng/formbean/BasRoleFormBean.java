package com.digihealth.anesthesia.sysMng.formbean;

import com.digihealth.anesthesia.sysMng.po.BasRole;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询权限参数对象")
public class BasRoleFormBean extends BasRole {

	@ApiModelProperty(value = "当前页码")
	private Integer pageNo;

	@ApiModelProperty(value = "每页显示多少条")
	private Integer pageSize;

	@ApiModelProperty(value = "模块")
	private String module;

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

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

}
