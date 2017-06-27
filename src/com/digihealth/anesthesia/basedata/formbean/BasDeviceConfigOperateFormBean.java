package com.digihealth.anesthesia.basedata.formbean;

import java.util.List;

import com.digihealth.anesthesia.basedata.po.BasDeviceConfig;
import com.digihealth.anesthesia.basedata.po.BasDeviceMonitorConfig;
import com.digihealth.anesthesia.basedata.po.BasMonitorConfigFreq;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "设备与监测项配置参数对象")
public class BasDeviceConfigOperateFormBean {

	@ApiModelProperty(value = "设备与监测项配置")
	private List<BasDeviceMonitorConfig> deviceMonitorConfigList;

	@ApiModelProperty(value = "床旁设备")
	private BasDeviceConfig deviceConfig;

	@ApiModelProperty(value = "采集频率集合")
	private List<BasMonitorConfigFreq> monitorConfigFreqList;

	public List<BasDeviceMonitorConfig> getDeviceMonitorConfigList() {
		return deviceMonitorConfigList;
	}

	public void setDeviceMonitorConfigList(List<BasDeviceMonitorConfig> deviceMonitorConfigList) {
		this.deviceMonitorConfigList = deviceMonitorConfigList;
	}

	public BasDeviceConfig getDeviceConfig() {
		return deviceConfig;
	}

	public void setDeviceConfig(BasDeviceConfig deviceConfig) {
		this.deviceConfig = deviceConfig;
	}

	public List<BasMonitorConfigFreq> getMonitorConfigFreqList() {
		return monitorConfigFreqList;
	}

	public void setMonitorConfigFreqList(List<BasMonitorConfigFreq> monitorConfigFreqList) {
		this.monitorConfigFreqList = monitorConfigFreqList;
	}
	
}
