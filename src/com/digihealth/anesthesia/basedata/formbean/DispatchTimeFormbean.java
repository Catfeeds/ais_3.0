package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "排程时间参数对象")
public class DispatchTimeFormbean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "手术时间")
	private Integer time;

	@ApiModelProperty(value = "开始时间")
	private String startTime;

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

}
