/*
 * SciResearchField.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2016-11-02 Created
 */
package com.digihealth.anesthesia.research.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询对象")
public class SciResearchField {
	/**
	 * 主键自增
	 */
	@ApiModelProperty(value = "主键id")
	private Integer id;

	/**
	 * 列表框对应的名称
	 */
	@ApiModelProperty(value = "列表框对应的名称")
	private String name;

	/**
	 * 名称描述
	 */
	@ApiModelProperty(value = "名称描述")
	private String describe;

	/**
	 * 对应的弹出框类型
	 */
	@ApiModelProperty(value = "对应的弹出框类型")
	private String type;

	/**
	 * 对应的json的名称
	 */
	@ApiModelProperty(value = "对应的json的名称")
	private String jsonName;

	/**
	 * 父级名称
	 */
	@ApiModelProperty(value = "父级名称")
	private String pName;

	/**
	 * 单位
	 */
	@ApiModelProperty(value = "单位")
	private String units;

	/**
	 * 是否显示:0-不显示，1-显示
	 */
	@ApiModelProperty(value = "是否显示:0-不显示，1-显示")
	private Integer isShow;

	/**
	 * 查询条件对应的字段名称
	 */
	@ApiModelProperty(value = "查询条件对应的字段名称")
	private String fieldName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe == null ? null : describe.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getJsonName() {
		return jsonName;
	}

	public void setJsonName(String jsonName) {
		this.jsonName = jsonName == null ? null : jsonName.trim();
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName == null ? null : pName.trim();
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units == null ? null : units.trim();
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName == null ? null : fieldName.trim();
	}
}