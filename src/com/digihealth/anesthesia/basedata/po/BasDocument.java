/*
 * BasDocument.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "文书类别表对象")
public class BasDocument {
	/**
	 * 文书id
	 */
	@ApiModelProperty(value = "文书id")
	private String docId;

	/**
	 * 文书名称
	 */
	@ApiModelProperty(value = "文书名称")
	private String name;

	/**
	 * 文书对应的表名
	 */
	@ApiModelProperty(value = "文书对应的表名")
	private String table;

	/**
	 * 进入术中文书是否必须完成;0:否,1:是
	 */
	@ApiModelProperty(value = "进入术中文书是否必须完成;0:否,1:是")
	private Integer isEnterOperFinish;

	/**
	 * 是否为必须完成的文书，才能打印。0:否,1:是
	 */
	@ApiModelProperty(value = "是否为必须完成的文书，才能打印。0:否,1:是")
	private Integer isNeed;

	/**
	 * 是否术中展示;0:否,1:是
	 */
	@ApiModelProperty(value = "是否术中展示;0:否,1:是")
	private Integer isOperShow;

	/**
	 * 前端依赖的别名
	 */
	@ApiModelProperty(value = "前端依赖的别名")
	private String aliasName;

	/**
	 * 术前:03,术中:04,复苏:05,术后:06
	 */
	@ApiModelProperty(value = "术前:03,术中:04,复苏:05,术后:06")
	private String operationState;

	/**
	 * 是否可用;0-不可用，1-可用
	 */
	@ApiModelProperty(value = "是否可用;0-不可用，1-可用")
	private Integer enable;

	/**
	 * 基线id
	 */
	@ApiModelProperty(value = "基线id")
	private String beid;

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId == null ? null : docId.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table == null ? null : table.trim();
	}

	public Integer getIsEnterOperFinish() {
		return isEnterOperFinish;
	}

	public void setIsEnterOperFinish(Integer isEnterOperFinish) {
		this.isEnterOperFinish = isEnterOperFinish;
	}

	public Integer getIsNeed() {
		return isNeed;
	}

	public void setIsNeed(Integer isNeed) {
		this.isNeed = isNeed;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName == null ? null : aliasName.trim();
	}

	public String getOperationState() {
		return operationState;
	}

	public void setOperationState(String operationState) {
		this.operationState = operationState == null ? null : operationState.trim();
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid == null ? null : beid.trim();
	}

	public Integer getIsOperShow() {
		return isOperShow;
	}

	public void setIsOperShow(Integer isOperShow) {
		this.isOperShow = isOperShow;
	}

}