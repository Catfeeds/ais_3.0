/*
 * BasMonitorFreqChange.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.operProceed.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "采集频率修改记录表对象")
public class BasMonitorFreqChange {
	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键ID")
	private String id;

	/**
	 * reg_opt_id，患者id
	 */
	@ApiModelProperty(value = "患者id")
	private String regOptId;

	/**
	 * 修改频率时间
	 */
	@ApiModelProperty(value = "修改频率时间")
	private Date time;

	/**
	 * 新的频率值
	 */
	@ApiModelProperty(value = "新的频率值")
	private Integer freq;

	/**
	 * 旧的频率值
	 */
	@ApiModelProperty(value = "旧的频率值")
	private Integer oldFreq;

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

	public Integer getFreq() {
		return freq;
	}

	public void setFreq(Integer freq) {
		this.freq = freq;
	}

	public Integer getOldFreq() {
		return oldFreq;
	}

	public void setOldFreq(Integer oldFreq) {
		this.oldFreq = oldFreq;
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

}