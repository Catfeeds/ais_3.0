/*
 * BasColumnStyle.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="大屏列样式对象")
public class BasColumnStyle {
    
    @ApiModelProperty(value="主键id")
	private String id;

	/**
	 * 1内屏 2外屏
	 */
    @ApiModelProperty(value="大屏类型：1内屏 2外屏")
	private Integer type;

	/**
	 * 字段
	 */
    @ApiModelProperty(value="字段")
	private String column;

	/**
	 * 字段名称
	 */
    @ApiModelProperty(value="字段名称")
	private String columnName;

    @ApiModelProperty(value="样式")
	private String style;

	/**
	 * 是否显示 1是，0否
	 */
    @ApiModelProperty(value="是否显示 1是，0否")
	private String displayState;

	/**
	 * 排序
	 */
    @ApiModelProperty(value="排序")
	private Integer sort;

	/**
	 * 基线id
	 */
    @ApiModelProperty(value="基线id")
	private String beid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column == null ? null : column.trim();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName == null ? null : columnName.trim();
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style == null ? null : style.trim();
	}

	public String getDisplayState() {
		return displayState;
	}

	public void setDisplayState(String displayState) {
		this.displayState = displayState == null ? null : displayState.trim();
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid == null ? null : beid.trim();
	}
}