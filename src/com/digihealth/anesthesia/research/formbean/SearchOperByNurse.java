package com.digihealth.anesthesia.research.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchOperByNurse {

	@ApiModelProperty(value = "护士id")
	private String nurseId;

	@ApiModelProperty(value = "护士姓名")
	private String nurseName;

	@ApiModelProperty(value = "总计")
	private Integer total;

	@ApiModelProperty(value = "时间")
	private Integer time;

	@ApiModelProperty(value = "average")
	private Integer average;

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getAverage() {
		return average;
	}

	public void setAverage(Integer average) {
		this.average = average;
	}

	public String getNurseId() {
		return nurseId;
	}

	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
