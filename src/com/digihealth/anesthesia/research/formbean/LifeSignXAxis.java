package com.digihealth.anesthesia.research.formbean;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class LifeSignXAxis {

	@ApiModelProperty(value = "数据")
	private List<LifeSignXAxisData> data;

	public List<LifeSignXAxisData> getData() {
		return data;
	}

	public void setData(List<LifeSignXAxisData> data) {
		this.data = data;
	}

}
