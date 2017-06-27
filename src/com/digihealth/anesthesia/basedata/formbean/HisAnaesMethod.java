package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HisAnaesMethod implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "Code")
	private String code;
	
	@JsonProperty(value = "Cate1")
	private String cate1;
	
	@JsonProperty(value = "Cate2")
	private String cate2;
	
	@JsonProperty(value = "Cate3")
	private String cate3;
	
	@JsonProperty(value = "Name")
	private String name;
	
	@JsonProperty(value = "IsCate")
	private String isCate;
	
	@JsonProperty(value = "IsUsually")
	private String isUsually;
	
	@JsonProperty(value = "Optional")
	private String optional;
	
	@JsonProperty(value = "IsValid")
	private String isValid; // 是否有效
	
	@JsonProperty(value = "Pinyin")
	private String pinyin; // 拼音查询
	
	private Integer anaMedId;// 主键

	public HisAnaesMethod(String name, Integer anaMedId) {
		super();
		this.name = name;
		this.anaMedId = anaMedId;
	}

	@Override
	public String toString() {
		return "AnaesMethod [code=" + code + ", cate1=" + cate1 + ", cate2="
				+ cate2 + ", cate3=" + cate3 + ", name=" + name + ", isCate="
				+ isCate + ", isUsually=" + isUsually + ", optional="
				+ optional + ", isValid=" + isValid + ", pinyin=" + pinyin
				+ ", anaMedId=" + anaMedId + "]";
	}

	public HisAnaesMethod() {
		super();
	}

	public HisAnaesMethod(String code, String cate1, String cate2,
			String cate3, String name, String isCate, String isUsually,
			String optional, String isValid, String pinyin, Integer anaMedId) {
		super();
		this.code = code;
		this.cate1 = cate1;
		this.cate2 = cate2;
		this.cate3 = cate3;
		this.name = name;
		this.isCate = isCate;
		this.isUsually = isUsually;
		this.optional = optional;
		this.isValid = isValid;
		this.pinyin = pinyin;
		this.anaMedId = anaMedId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午4:36:34
	 * @param isUsually
	 */
	public void setIsUsually(String isUsually) {
		this.isUsually = StringUtils.isEmpty(isUsually) ? isUsually : isUsually
				.trim();
	}

	public void setAnaMedId(Integer anaMedId) {
		this.anaMedId = anaMedId;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = StringUtils.isEmpty(pinyin) ? pinyin : pinyin.trim();
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午5:21:42
	 * @return type
	 */

	public Integer getAnaMedId() {
		return anaMedId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCate1() {
		return cate1;
	}

	public void setCate1(String cate1) {
		this.cate1 = cate1;
	}

	public String getCate2() {
		return cate2;
	}

	public void setCate2(String cate2) {
		this.cate2 = cate2;
	}

	public String getCate3() {
		return cate3;
	}

	public void setCate3(String cate3) {
		this.cate3 = cate3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = StringUtils.isEmpty(name) ? name : name.trim();
	}

	public String getIsCate() {
		return isCate;
	}

	public void setIsCate(String isCate) {
		this.isCate = isCate;
	}

	public String getIsUsually() {
		return isUsually;
	}

	public void setIs_usually(String isUsually) {
		this.isUsually = isUsually;
	}

	public String getOptional() {
		return optional;
	}

	public void setOptional(String optional) {
		this.optional = optional;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
}