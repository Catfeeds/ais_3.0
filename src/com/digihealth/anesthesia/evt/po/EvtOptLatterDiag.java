/*
 * EvtOptLatterDiag.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "术中诊断对象")
public class EvtOptLatterDiag {
	/**
	 * 术中诊断主键
	 */
	@ApiModelProperty(value = "术中诊断主键")
	private String optLatterDiagId;

	/**
	 * 文书ID
	 */
	@ApiModelProperty(value = "文书ID")
	private String docId;

	/**
	 * 诊断名称ID
	 */
	@ApiModelProperty(value = "诊断名称ID")
	private String diagDefId;

	/**
	 * 名称
	 */
	@ApiModelProperty(value = "名称")
	private String name;

	/**
	 * 名称修改编辑
	 */
	@ApiModelProperty(value = "名称修改编辑")
	private String editName;

	public String getOptLatterDiagId() {
		return optLatterDiagId;
	}

	public void setOptLatterDiagId(String optLatterDiagId) {
		this.optLatterDiagId = optLatterDiagId == null ? null : optLatterDiagId.trim();
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId == null ? null : docId.trim();
	}

	public String getDiagDefId() {
		return diagDefId;
	}

	public void setDiagDefId(String diagDefId) {
		this.diagDefId = diagDefId == null ? null : diagDefId.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getEditName() {
		return editName;
	}

	public void setEditName(String editName) {
		this.editName = editName == null ? null : editName.trim();
	}
}