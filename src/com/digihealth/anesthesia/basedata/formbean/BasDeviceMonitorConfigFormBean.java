package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "设备与监测项配置参数对象")
public class BasDeviceMonitorConfigFormBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "设备id")
	private String deviceId;

	@ApiModelProperty(value = "eventId")
	private String eventId;

	@ApiModelProperty(value = "M:必须勾选，O:勾选，null代表没有勾选")
	private String optional;

	@ApiModelProperty(value = "手术间id")
	private String roomId;

	@ApiModelProperty(value = "eventName")
	private String eventName;

	@ApiModelProperty(value = "eventDesc")
	private String eventDesc;
	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

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
	
	public String getOptional() {
		return optional;
	}

	public void setOptional(String optional) {
		this.optional = optional;
	}
}