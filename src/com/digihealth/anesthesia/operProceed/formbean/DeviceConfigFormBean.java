package com.digihealth.anesthesia.operProceed.formbean;

import java.util.List;

import com.digihealth.anesthesia.basedata.po.BasDeviceConfig;
import com.digihealth.anesthesia.basedata.po.BasDeviceMonitorConfig;

/**
 * 术中设备配置对象 Title: DeviceConfigFormBean.java Description:
 * 
 * @author chenyong
 * @created 2016年8月1日 下午4:26:31
 */
public class DeviceConfigFormBean {

	private List<BasDeviceMonitorConfig> deviceMonitorConfigList;
	private BasDeviceConfig deviceConfig;

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

}
