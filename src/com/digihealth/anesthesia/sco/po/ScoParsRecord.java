/*
 * ScoParsRecord.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.sco.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉恢复评分对象")
public class ScoParsRecord {
	/**
	 * 评分ID
	 */

	@ApiModelProperty(value = "评分ID")
	private String scoId;

	/**
	 * 手术Id
	 */

	@ApiModelProperty(value = "手术Id")
	private String regOptId;

	/**
	 * 评分人
	 */

	@ApiModelProperty(value = "评分人")
	private String eval;

	/**
	 * 评分时间
	 */

	@ApiModelProperty(value = "评分时间")
	private Date evalTime;

	/**
	 * 总分
	 */

	@ApiModelProperty(value = "总分")
	private Float totalSco;

	/**
	 * 活动力
	 */

	@ApiModelProperty(value = "活动力")
	private Integer activity;

	/**
	 * 呼吸
	 */

	@ApiModelProperty(value = "呼吸")
	private Integer breathe;

	/**
	 * 循环
	 */

	@ApiModelProperty(value = "循环")
	private Integer cycle;

	/**
	 * 意识
	 */

	@ApiModelProperty(value = "意识")
	private Integer awareness;

	/**
	 * 氧饱和度SPO2
	 */

	@ApiModelProperty(value = "氧饱和度SPO2")
	private Integer spo2;

	public String getScoId() {
		return scoId;
	}

	public void setScoId(String scoId) {
		this.scoId = scoId == null ? null : scoId.trim();
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId == null ? null : regOptId.trim();
	}

	public String getEval() {
		return eval;
	}

	public void setEval(String eval) {
		this.eval = eval == null ? null : eval.trim();
	}

	public Date getEvalTime() {
		return evalTime;
	}

	public void setEvalTime(Date evalTime) {
		this.evalTime = evalTime;
	}

	public Float getTotalSco() {
		return totalSco;
	}

	public void setTotalSco(Float totalSco) {
		this.totalSco = totalSco;
	}

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

	public Integer getBreathe() {
		return breathe;
	}

	public void setBreathe(Integer breathe) {
		this.breathe = breathe;
	}

	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public Integer getAwareness() {
		return awareness;
	}

	public void setAwareness(Integer awareness) {
		this.awareness = awareness;
	}

	public Integer getSpo2() {
		return spo2;
	}

	public void setSpo2(Integer spo2) {
		this.spo2 = spo2;
	}
}