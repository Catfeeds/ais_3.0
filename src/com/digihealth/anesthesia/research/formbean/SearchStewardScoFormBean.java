package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchStewardScoFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "日期")
	private String enterTime;// 日期

	@ApiModelProperty(value = "入pacu个数")
	private Integer pacuTotal;// 入pacu个数

	@ApiModelProperty(value = "评分数")
	private Integer stewardTotal;// 评分数

	public String getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	public Integer getPacuTotal() {
		return pacuTotal;
	}

	public void setPacuTotal(Integer pacuTotal) {
		this.pacuTotal = pacuTotal;
	}

	public Integer getStewardTotal() {
		return stewardTotal;
	}

	public void setStewardTotal(Integer stewardTotal) {
		this.stewardTotal = stewardTotal;
	}

}
