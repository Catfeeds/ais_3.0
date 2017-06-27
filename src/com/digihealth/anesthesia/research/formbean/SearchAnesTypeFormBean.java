package com.digihealth.anesthesia.research.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchAnesTypeFormBean {

	@ApiModelProperty(value = "麻醉类型")
	private String anesType;

	@ApiModelProperty(value = "avgTime")
	private Float avgTime;

	@ApiModelProperty(value = "总数量")
	private Integer totalNum;

	public String getAnesType() {
		return anesType;
	}

	public void setAnesType(String anesType) {
		this.anesType = anesType;
	}

	public Float getAvgTime() {
		return avgTime;
	}

	public void setAvgTime(Float avgTime) {
		this.avgTime = avgTime;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

}
