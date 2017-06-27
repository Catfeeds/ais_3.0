package com.digihealth.anesthesia.basedata.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PACU床位配置参数对象")
public class PacuBedEventConfigFormBean {
	/**
	 * 设备id
	 */
	@ApiModelProperty(value = "设备id")
	private String deviceId;

	/**
	 * 采集项id
	 */
	@ApiModelProperty(value = "采集项id")
	private String eventId;

	/**
	 * 床id
	 */
	@ApiModelProperty(value = "床位id")
	private String bedId;

	/**
	 * M:必须勾选，O:勾选，N:没有勾选
	 */
	@ApiModelProperty(value = "M:必须勾选，O:勾选，N:没有勾选")
	private String optDisplay;

	/**
	 * M:必须采集，O:勾选,N:没有勾选
	 */
	@ApiModelProperty(value = "M:必须采集，O:勾选,N:没有勾选")
	private String optCollect;

	@ApiModelProperty(value = "采集项名称")
	private String eventName;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public String getOptDisplay() {
		return optDisplay;
	}

	public void setOptDisplay(String optDisplay) {
		this.optDisplay = optDisplay;
	}

	public String getOptCollect() {
		return optCollect;
	}

	public void setOptCollect(String optCollect) {
		this.optCollect = optCollect;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

}
