package com.digihealth.anesthesia.sysMng.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询局点对象")
public class BasBusDropDownFormBean {
	/**
	 * 局点id，主键
	 */
	@ApiModelProperty(value = "局点id")
	private String beid;

	/**
	 * 局点名称
	 */
	@ApiModelProperty(value = "局点名称")
	private String name;

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
