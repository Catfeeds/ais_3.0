package com.digihealth.anesthesia.research.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class LifeSignObserveFormBean {

	@ApiModelProperty(value = "监测点id")
	private String observeId;

	@ApiModelProperty(value = "监测点名称")
	private String observeName;

	@ApiModelProperty(value = "监测项描述")
	private String eventDesc;

	public String getObserveId() {
		return observeId;
	}

	public void setObserveId(String observeId) {
		this.observeId = observeId;
	}

	public String getObserveName() {
		return observeName;
	}

	public void setObserveName(String observeName) {
		this.observeName = observeName == null ? null : observeName.trim();
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc == null ? null : eventDesc.trim();
	}

}
