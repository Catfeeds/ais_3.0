/*
 * DocPrePostVisit.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术病人术前术后访问记录单对象")
public class DocPrePostVisit {
	@ApiModelProperty(value = "主键ID")
	private String id;

	@ApiModelProperty(value = "患者id")
	private String regOptId;

	@ApiModelProperty(value = "是否完成")
	private String processState;

	/**
	 * 血型
	 */
	@ApiModelProperty(value = "血型")
	private Integer blood;

	/**
	 * 药物过敏史
	 */
	@ApiModelProperty(value = "药物过敏史")
	private String allergy;

	/**
	 * 既往病史
	 */
	@ApiModelProperty(value = "既往病史")
	private String briefHis;

	/**
	 * 既往病史其他
	 */
	@ApiModelProperty(value = "既往病史其他")
	private String briefHisOther;

	/**
	 * 术前护理问题及护理措施
	 */
	@ApiModelProperty(value = "术前护理问题及护理措施")
	private String nurseProblem;

	/**
	 * 术前护理问题及护理措施其他
	 */
	@ApiModelProperty(value = "术前护理问题及护理措施其他")
	private String nurseProblemOther;

	/**
	 * 术前访视人Id
	 */
	@ApiModelProperty(value = "术前访视人Id")
	private String preVisitorId;

	/**
	 * 术前访视人姓名
	 */
	@ApiModelProperty(value = "术前访视人姓名")
	private String preVisitorName;

	/**
	 * 术前访视时间
	 */
	@ApiModelProperty(value = "术前访视时间")
	private Date preVisitTime;

	/**
	 * 病人入手术室心理状况
	 */
	@ApiModelProperty(value = "病人入手术室心理状况")
	private String psychological;

	/**
	 * 病人入手术室心理状况其他
	 */
	@ApiModelProperty(value = "病人入手术室心理状况其他")
	private String psychologicalOther;

	/**
	 * 手术室环境
	 */
	@ApiModelProperty(value = "手术室环境")
	private Integer environment;

	/**
	 * 手术室护士工作态度
	 */
	@ApiModelProperty(value = "手术室护士工作态度")
	private Integer workAttitude;

	/**
	 * 手术室护士对患者
	 */
	@ApiModelProperty(value = "手术室护士对患者")
	private Integer care;

	/**
	 * 建议
	 */
	@ApiModelProperty(value = "建议")
	private String suggest;

	/**
	 * 术后访视人ID
	 */
	@ApiModelProperty(value = "术后访视人ID")
	private String postVisitorId;

	/**
	 * 术后访视人姓名
	 */
	@ApiModelProperty(value = "术后访视人姓名")
	private String postVisitorName;

	/**
	 * 术后访视时间
	 */
	@ApiModelProperty(value = "术后访视时间")
	private Date postVisitTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId == null ? null : regOptId.trim();
	}

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState == null ? null : processState.trim();
	}

	public Integer getBlood() {
		return blood;
	}

	public void setBlood(Integer blood) {
		this.blood = blood;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy == null ? null : allergy.trim();
	}

	public String getBriefHis() {
		return briefHis;
	}

	public void setBriefHis(String briefHis) {
		this.briefHis = briefHis == null ? null : briefHis.trim();
	}

	public String getBriefHisOther() {
		return briefHisOther;
	}

	public void setBriefHisOther(String briefHisOther) {
		this.briefHisOther = briefHisOther == null ? null : briefHisOther
				.trim();
	}

	public String getNurseProblem() {
		return nurseProblem;
	}

	public void setNurseProblem(String nurseProblem) {
		this.nurseProblem = nurseProblem == null ? null : nurseProblem.trim();
	}

	public String getNurseProblemOther() {
		return nurseProblemOther;
	}

	public void setNurseProblemOther(String nurseProblemOther) {
		this.nurseProblemOther = nurseProblemOther == null ? null
				: nurseProblemOther.trim();
	}

	public String getPreVisitorId() {
		return preVisitorId;
	}

	public void setPreVisitorId(String preVisitorId) {
		this.preVisitorId = preVisitorId;
	}

	public String getPreVisitorName() {
		return preVisitorName;
	}

	public void setPreVisitorName(String preVisitorName) {
		this.preVisitorName = preVisitorName == null ? null : preVisitorName
				.trim();
	}

	public Date getPreVisitTime() {
		return preVisitTime;
	}

	public void setPreVisitTime(Date preVisitTime) {
		this.preVisitTime = preVisitTime;
	}

	public String getPsychological() {
		return psychological;
	}

	public void setPsychological(String psychological) {
		this.psychological = psychological == null ? null : psychological
				.trim();
	}

	public String getPsychologicalOther() {
		return psychologicalOther;
	}

	public void setPsychologicalOther(String psychologicalOther) {
		this.psychologicalOther = psychologicalOther == null ? null
				: psychologicalOther.trim();
	}

	public Integer getEnvironment() {
		return environment;
	}

	public void setEnvironment(Integer environment) {
		this.environment = environment;
	}

	public Integer getWorkAttitude() {
		return workAttitude;
	}

	public void setWorkAttitude(Integer workAttitude) {
		this.workAttitude = workAttitude;
	}

	public Integer getCare() {
		return care;
	}

	public void setCare(Integer care) {
		this.care = care;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest == null ? null : suggest.trim();
	}

	public String getPostVisitorId() {
		return postVisitorId;
	}

	public void setPostVisitorId(String postVisitorId) {
		this.postVisitorId = postVisitorId;
	}

	public String getPostVisitorName() {
		return postVisitorName;
	}

	public void setPostVisitorName(String postVisitorName) {
		this.postVisitorName = postVisitorName == null ? null : postVisitorName
				.trim();
	}

	public Date getPostVisitTime() {
		return postVisitTime;
	}

	public void setPostVisitTime(Date postVisitTime) {
		this.postVisitTime = postVisitTime;
	}
}