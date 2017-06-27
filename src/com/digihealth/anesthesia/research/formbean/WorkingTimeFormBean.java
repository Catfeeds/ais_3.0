package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "待办工作查询参数")
public class WorkingTimeFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "年份")
	private String year;

	@ApiModelProperty(value = "月份")
	private String month;

	@ApiModelProperty(value = "时间")
	private String time;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
