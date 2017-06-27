package com.digihealth.anesthesia.basedata.formbean;

import java.util.List;

import com.digihealth.anesthesia.basedata.po.BasPacuBedEventConfig;
import com.digihealth.anesthesia.basedata.po.BasPacuDeviceConfig;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "pacu床旁设备监测项配置参数对象")
public class PacuDeviceEventFormBean {

	@ApiModelProperty(value = "pacu床旁设备配置")
	private BasPacuDeviceConfig pacuDeviceConfig;

	@ApiModelProperty(value = "pacu床旁设备监测项配置")
	private List<BasPacuBedEventConfig> bedEventConfigList;

	public BasPacuDeviceConfig getPacuDeviceConfig() {
		return pacuDeviceConfig;
	}

	public void setPacuDeviceConfig(BasPacuDeviceConfig pacuDeviceConfig) {
		this.pacuDeviceConfig = pacuDeviceConfig;
	}

	public List<BasPacuBedEventConfig> getBedEventConfigList() {
		return bedEventConfigList;
	}

	public void setBedEventConfigList(
			List<BasPacuBedEventConfig> bedEventConfigList) {
		this.bedEventConfigList = bedEventConfigList;
	}

}
