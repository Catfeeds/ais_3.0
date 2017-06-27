/*
 * DocPrePostVisitItem.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术病人术前术后访问记录单条目对象")
public class DocPrePostVisitItem {
	@ApiModelProperty(value = "主键id")
	private String id;

	@ApiModelProperty(value = "患者ID")
	private String regOptId;

	@ApiModelProperty(value = "手术病人术前术后访问记录单id")
	private String prePostId;

	/**
	 * 类型
	 */
	@ApiModelProperty(value = "类型")
	private Integer type;

	/**
	 * 时间
	 */
	@ApiModelProperty(value = "时间")
	private Date time;

	/**
	 * code
	 */
	@ApiModelProperty(value = "code")
	private String itemCode;

	/**
	 * 名称
	 */
	@ApiModelProperty(value = "名称")
	private String itemName;

	/**
	 * 事由
	 */
	@ApiModelProperty(value = "事由")
	private String reason;

	/**
	 * 护理人员Id
	 */
	@ApiModelProperty(value = "护理人员Id")
	private Integer nurseId;

	/**
	 * 护理人员姓名
	 */
	@ApiModelProperty(value = "护理人员姓名")
	private String nurseName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId == null ? null : regOptId.trim();
	}

	public String getPrePostId() {
		return prePostId;
	}

	public void setPrePostId(String prePostId) {
		this.prePostId = prePostId == null ? null : prePostId.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode == null ? null : itemCode.trim();
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason == null ? null : reason.trim();
	}

	public Integer getNurseId() {
		return nurseId;
	}

	public void setNurseId(Integer nurseId) {
		this.nurseId = nurseId;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName == null ? null : nurseName.trim();
	}
}