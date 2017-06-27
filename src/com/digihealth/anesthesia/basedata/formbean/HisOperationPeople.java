package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 手术人员
 * 
 * @author liukui
 * 
 */
@ApiModel(value = "his手术人员参数对象")
public class HisOperationPeople implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "Code")
	@ApiModelProperty(value = "编码")
	private Integer code;

	@JsonProperty(value = "Name")
	@ApiModelProperty(value = "名称")
	private String name;

	@JsonProperty(value = "Enable")
	@ApiModelProperty(value = "是否可用;1-是，0-否")
	private String enable;

	@ApiModelProperty(value = "病区")
	private Integer region;

	@JsonProperty(value = "Pinyin")
	@ApiModelProperty(value = "拼音")
	private String pinyin;

	@ApiModelProperty(value = "人员id")
	private Integer operatorId;

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
}