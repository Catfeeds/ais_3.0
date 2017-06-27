package com.digihealth.anesthesia.research.formbean;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class LifeSignXAxis1Data {

	@ApiModelProperty(value = "数据")
	private List<Integer> data;

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

}
