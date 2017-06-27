/*
 * BasObserveData.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-07 Created
 */
package com.digihealth.anesthesia.operProceed.po;

import java.sql.Timestamp;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "采集数据表（秒表）对象")
public class BasObserveData {
	@ApiModelProperty(value = "主键id")
	private String id;

	/**
	 * 时间
	 */
	@ApiModelProperty(value = "时间")
	private Timestamp time;

	/**
	 * 文书ID
	 */
	@ApiModelProperty(value = "文书ID")
	private String regOptId;

	/**
	 * 观察点ID
	 */
	@ApiModelProperty(value = "观察点ID")
	private String observeId;

	/**
	 * 观测点的值
	 */
	@ApiModelProperty(value = "观测点的值")
	private Float value;

	/**
	 * 是否正常值，0正常，-1过低，1过高
	 */
	@ApiModelProperty(value = "是否正常值，0正常，-1过低，1过高")
	private Integer state;

	@ApiModelProperty(value = "监测项名称")
	private String observeName;

	@ApiModelProperty(value = "图标")
	private String icon;

	@ApiModelProperty(value = "颜色")
	private String color;

	@ApiModelProperty(value = "频率")
	private Integer freq;

	@ApiModelProperty(value = "位置")
	private Integer position;

	@ApiModelProperty(value = "间隔时间")
	private Integer intervalTime;

	/**
	 * 设备id
	 */
	@ApiModelProperty(value = "设备id")
	private String deviceId;

	@ApiModelProperty(value = "单位")
	private String units;

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId == null ? null : regOptId.trim();
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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId == null ? null : deviceId.trim();
	}
}