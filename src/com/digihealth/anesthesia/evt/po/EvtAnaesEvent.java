/*
 * EvtAnaesEvent.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉事件对象")
public class EvtAnaesEvent {
	/**
	 * 麻醉事件主键
	 */
	@ApiModelProperty(value = "麻醉事件主键")
	private String anaEventId;

	/**
	 * 事件代码
	 */
	@ApiModelProperty(value = "事件代码")
	private Integer code;

	/**
	 * 发生时间
	 */
	@ApiModelProperty(value = "发生时间")
	private Date occurTime;

	/**
	 * 文书ID
	 */
	@ApiModelProperty(value = " 文书ID")
	private String docId;

	/**
	 * 用于心肺复苏是否成功.0:否;1:是
	 */
	@ApiModelProperty(value = "用于心肺复苏是否成功.0:否;1:是")
	private Integer isSuccess;

	/**
	 * 文书类型：1-麻醉记录单，2-pacu观察记录单
	 */
	@ApiModelProperty(value = "文书类型：1-麻醉记录单，2-pacu观察记录单")
	private Integer docType;
	
	@ApiModelProperty(value = "出室去向")
	private String leaveTo;
	
	@ApiModelProperty(value = "代码名称")
	private String codeName;

	public String getAnaEventId() {
		return anaEventId;
	}

	public void setAnaEventId(String anaEventId) {
		this.anaEventId = anaEventId == null ? null : anaEventId.trim();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Date getOccurTime() {
		return occurTime;
	}

	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId == null ? null : docId.trim();
	}

	public Integer getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
		this.docType = docType;
	}

	public String getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(String leaveTo) {
		this.leaveTo = leaveTo;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@Override
	public String toString() {
		return "EvtAnaesEvent [anaEventId=" + anaEventId + ", code=" + code + ", occurTime=" + occurTime + ", docId=" + docId + ", isSuccess=" + isSuccess + ", docType=" + docType + ", leaveTo=" + leaveTo + ", codeName=" + codeName + "]";
	}
	
	

}