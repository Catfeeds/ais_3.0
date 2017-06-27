/*
 * CollectPacuData.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2016-08-03 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "观测对象")
public class DocCollectPacuData {
	@ApiModelProperty(value = "主键id")
    private String id;

	/**
	 * 时间
	 */
	@ApiModelProperty(value = "时间")
    private Date time;

	/**
	 * 患者id
	 */
	@ApiModelProperty(value = "患者id")
    private String docId;

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

    @ApiModelProperty(value = "observeName")
     private String observeName;

    @ApiModelProperty(value = "图标")
     private String icon;

    @ApiModelProperty(value = "颜色")
     private String color;

    @ApiModelProperty(value = "freq")
     private Integer freq;

    @ApiModelProperty(value = "position")
     private Integer position;

    @ApiModelProperty(value = "intervalTime")
     private Integer intervalTime;

	/**
	 * 设备id
	 */
    @ApiModelProperty(value = "设备id")
     private String deviceId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId == null ? null : docId.trim();
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

	@Override
	public String toString() {
		return "CollectPacuData [id=" + id + ", time=" + time + ", docId=" + docId + ", observeId=" + observeId + ", value=" + value + ", state=" + state + ", observeName=" + observeName + ", icon=" + icon + ", color=" + color + ", freq=" + freq + ", position=" + position + ", intervalTime=" + intervalTime + ", deviceId=" + deviceId + "]";
	}

}