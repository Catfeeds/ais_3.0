package com.digihealth.anesthesia.basedata.formbean;

import com.digihealth.anesthesia.basedata.po.BasDept;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询科室参数对象")
public class BasDeptFormBean extends BasDept {

	@ApiModelProperty(value = "当前页码")
	private Integer pageNo;

	@ApiModelProperty(value = "每页显示多少条")
	private Integer pageSize;

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
}
