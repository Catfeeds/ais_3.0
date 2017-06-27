package com.digihealth.anesthesia.basedata.formbean;

import org.hibernate.validator.constraints.NotEmpty;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "采集数据表参数对象")
public class PacuStartFormbean {

	@ApiModelProperty(value = "床位id")
	private String bedId;

	@NotEmpty(message = "不能为空!")
	@ApiModelProperty(value = "患者id")
	private String regOptId;

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

}
