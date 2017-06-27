/*
 * BasMonitorConfigDefault.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-11 Created
 */
package com.digihealth.anesthesia.operProceed.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "不同设备相同指标配置对象")
public class BasMonitorConfigDefault {
	/**
	 * 重复监测项的统一eventId
	 */
	@ApiModelProperty(value = "重复监测项的统一eventId")
	private String eventId;

	/**
	 * 基线id
	 */
	@ApiModelProperty(value = "基线id")
	private String beid;

	/**
	 * 监测项名称
	 */
	@ApiModelProperty(value = "监测项名称")
	private String eventName;

	/**
	 * 默认的eventId
	 */
	@ApiModelProperty(value = "默认的eventId")
	private String defaultEventId;

	/**
	 * 描述
	 */
	@ApiModelProperty(value = "描述")
	private String remark;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId == null ? null : eventId.trim();
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid == null ? null : beid.trim();
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName == null ? null : eventName.trim();
	}

	public String getDefaultEventId() {
		return defaultEventId;
	}

	public void setDefaultEventId(String defaultEventId) {
		this.defaultEventId = defaultEventId == null ? null : defaultEventId
				.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}