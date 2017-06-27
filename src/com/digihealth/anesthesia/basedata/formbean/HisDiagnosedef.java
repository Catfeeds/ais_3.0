package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HisDiagnosedef implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer diagDefId;

	@JsonProperty(value = "Code")
	private String code;

	@JsonProperty(value = "Name")
	private String name;

	@JsonProperty(value = "Pinyin")
	private String pinyin;

	@JsonProperty(value = "Enable")
	private String enable;

	public Integer getDiagDefId() {
		return diagDefId;
	}

	public void setDiagDefId(Integer diagDefId) {
		this.diagDefId = diagDefId;
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
		;
		;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = StringUtils.isEmpty(pinyin) ? pinyin : pinyin.trim();
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "Diagnosedef [diagDefId=" + diagDefId + ", code=" + code
				+ ", name=" + name + ", pinyin=" + pinyin + ", enable="
				+ enable + "]";
	}

}