package com.digihealth.anesthesia.research.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchOperByASALevel {

	@ApiModelProperty(value = "asa等级")
	private String asaLevel;

	@ApiModelProperty(value = "总计")
	private Integer total;

	public String getAsaLevel() {
		return asaLevel;
	}

	public void setAsaLevel(String asaLevel) {
		this.asaLevel = asaLevel;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
