package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "床旁设备配置参数对象")
public class DeviceMonitorFormbean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "设备id")
	private String deviceId;

	@ApiModelProperty(value = "设备生产厂家")
	private String deviceFactory;

	@ApiModelProperty(value = "设备类型：1.手术室终端；2：复苏室终端；3：心电监护仪、4：呼吸机、5：麻醉机")
	private Integer deviceType;

	@ApiModelProperty(value = "设备型号")
	private String devicemodel;

	@ApiModelProperty(value = "protocol")
	private String protocol;

	@ApiModelProperty(value = "eventId")
	private String eventId;

	public String getDeviceFactory() {
		return deviceFactory;
	}

	public void setDeviceFactory(String deviceFactory) {
		this.deviceFactory = deviceFactory;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getDevicemodel() {
		return devicemodel;
	}

	public void setDevicemodel(String devicemodel) {
		this.devicemodel = devicemodel;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
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

}
