package com.digihealth.anesthesia.interfacedata.po;

import java.io.Serializable;

import com.digihealth.anesthesia.common.persistence.DataEntity;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询对象")
public class Operdef implements Serializable {

	@ApiModelProperty(value = "编码")
	private Integer Code;

	@ApiModelProperty(value = "名称")
	private String Name;

	@ApiModelProperty(value = "拼音")
	private String Pinyin;

	@ApiModelProperty(value = "是否可用")
	private Integer Enable;

	public Integer getCode() {
		return Code;
	}

	public void setCode(Integer code) {
		Code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPinyin() {
		return Pinyin;
	}

	public void setPinyin(String pinyin) {
		Pinyin = pinyin;
	}

	public Integer getEnable() {
		return Enable;
	}

	public void setEnable(Integer enable) {
		Enable = enable;
	}

}