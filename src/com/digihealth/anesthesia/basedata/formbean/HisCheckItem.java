package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HisCheckItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer cheItemId;
	
	@JsonProperty(value = "Code")
	private String code;
	
	@JsonProperty(value = "Name")
	private String name;
	
	@JsonProperty(value = "Unit")
	private String unit;
	
	@JsonProperty(value = "Enable")
	private String enable;

	public Integer getCheItemId() {
		return cheItemId;
	}

	public void setCheItemId(Integer cheItemId) {
		this.cheItemId = cheItemId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = StringUtils.isEmpty(name) ? name : name.trim();
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = StringUtils.isEmpty(unit) ? unit : unit.trim();
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

}
