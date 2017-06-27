/*
 * BasObserveDataHis.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-07 Created
 */
package com.digihealth.anesthesia.operProceed.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "采集数据历史表对象")
public class BasObserveDataHis {
	@ApiModelProperty(value = "主键id")
	private String id;

	/**
	 * 文书ID
	 */
	@ApiModelProperty(value = "文书ID")
	private String regOptId;

	/**
	 * 时间
	 */
	@ApiModelProperty(value = "时间")
	private Date time;

	/**
	 * 观察点ID
	 */
	@ApiModelProperty(value = "观察点ID")
	private String observeId;

	/**
	 * 新值
	 */
	@ApiModelProperty(value = "新值")
	private Float value;

	/**
	 * 状态
	 */
	@ApiModelProperty(value = "状态")
	private Integer state;

	/**
	 * 监测项名称
	 */
	@ApiModelProperty(value = "监测项名称")
	private String observeName;

	/**
	 * 图标
	 */
	@ApiModelProperty(value = "图标")
	private String icon;

	/**
	 * 颜色
	 */
	@ApiModelProperty(value = "颜色")
	private String color;

	/**
	 * 频率
	 */
	@ApiModelProperty(value = "频率")
	private Integer freq;

	/**
	 * 位置
	 */
	@ApiModelProperty(value = "位置")
	private Integer position;

	/**
	 * 间隔时间
	 */
	@ApiModelProperty(value = "间隔时间")
	private Integer intervalTime;

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getObserveName() {
		return observeName;
	}

	public void setObserveName(String observeName) {
		this.observeName = observeName == null ? null : observeName.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color == null ? null : color.trim();
	}

	public Integer getFreq() {
		return freq;
	}

	public void setFreq(Integer freq) {
		this.freq = freq;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Integer intervalTime) {
		this.intervalTime = intervalTime;
	}
}