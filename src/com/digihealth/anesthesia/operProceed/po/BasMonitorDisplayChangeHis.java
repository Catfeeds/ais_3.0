/*
 * BasMonitorDisplayChangeHis.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-07 Created
 */
package com.digihealth.anesthesia.operProceed.po;

import java.sql.Timestamp;
import java.util.Date;

import com.digihealth.anesthesia.common.utils.SysUtil;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "修改历史表对象")
public class BasMonitorDisplayChangeHis {
	@ApiModelProperty(value = "主键id")
	private String id;

	/**
	 * 手术id
	 */
	@ApiModelProperty(value = "手术id")
	private String regOptId;

	/**
	 * 时间
	 */
	@ApiModelProperty(value = "时间")
	private Date time;

	/**
	 * 检测项id
	 */
	@ApiModelProperty(value = "检测项id")
	private String observeId;

	/**
	 * 新值
	 */
	@ApiModelProperty(value = "新值")
	private Float value;

	/**
	 * 旧值
	 */
	@ApiModelProperty(value = "旧值")
	private Float oldValue;

	/**
	 * 修改人
	 */
	@ApiModelProperty(value = "修改人")
	private String userId;

	/**
	 * 备注，修改原因
	 */
	@ApiModelProperty(value = "备注，修改原因")
	private String memo;

	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	private Date modifyTime;

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getObserveId() {
		return observeId;
	}

	public void setObserveId(String observeId) {
		this.observeId = observeId == null ? null : observeId.trim();
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Float getOldValue() {
		return oldValue;
	}

	public void setOldValue(Float oldValue) {
		this.oldValue = oldValue;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public void setObserveDataChange(BasMonitorDisplay md, Float newValue,
			String memo) {
		this.regOptId = md.getRegOptId();
		this.id = md.getId();
		this.modifyTime = SysUtil.getCurrentTimeStamp();
		this.observeId = md.getObserveId();
		this.oldValue = md.getValue();
		this.time = new Timestamp(md.getTime().getTime());
		this.userId = "";
		this.value = newValue;
		this.memo = memo;
	}
}