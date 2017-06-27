package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class StatisticsAnaesMethodFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "时间")
	private String time;

	@ApiModelProperty(value = "vo")
	private String[] vo;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String[] getVo() {
		return vo;
	}

	public void setVo(String[] vo) {
		this.vo = vo;
	}

}
