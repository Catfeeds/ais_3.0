/*
 * DocPostOperRegard.java
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

@ApiModel(value = "术后回视记录单对象")
public class DocPostOperRegard {
	/**
	 * 术后回视主键
	 */
	@ApiModelProperty(value = "主键id")
	private String id;

	/**
	 * 手术id
	 */
	@ApiModelProperty(value = "患者id")
	private String regOptId;

	/**
	 * 访视护士解释工作是否到位
	 */
	@ApiModelProperty(value = "访视护士解释工作是否到位")
	private Integer explain;

	/**
	 * 术前的特殊手术体位指导是否有用
	 */
	@ApiModelProperty(value = "术前的特殊手术体位指导是否有用")
	private Integer preOperOptbody;

	/**
	 * 患者遮盖和保暖措施
	 */
	@ApiModelProperty(value = "患者遮盖和保暖措施")
	private Integer coverWarm;

	/**
	 * 术中手术体位摆放是否舒适
	 */
	@ApiModelProperty(value = "术中手术体位摆放是否舒适")
	private Integer operingOptbodyComfort;

	/**
	 * 术后伤口恢复情况
	 */
	@ApiModelProperty(value = "术后伤口恢复情况")
	private Integer postOperRestore;

	/**
	 * 通过访视对你有哪些帮助
	 */
	@ApiModelProperty(value = "通过访视对你有哪些帮助")
	private Integer byInterviewHelp;

	/**
	 * 对手术室护士工作的满意度
	 */
	@ApiModelProperty(value = "对手术室护士工作的满意度")
	private Integer satisfacation;

	/**
	 * 建议
	 */
	@ApiModelProperty(value = "建议")
	private String sugest;

	/**
	 * 访视者签名
	 */
	@ApiModelProperty(value = "访视者签名")
	private Integer interviewUser;

	/**
	 * 家属签名
	 */
	@ApiModelProperty(value = "家属签名")
	private String interviewRelation;

	/**
	 * 访视时间
	 */
	@ApiModelProperty(value = "访视时间")
	private Date interviewTime;

	/**
	 * END NO_END
	 */
	@ApiModelProperty(value = "是否完成 END NO_END")
	private String processState;

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

	public Integer getExplain() {
		return explain;
	}

	public void setExplain(Integer explain) {
		this.explain = explain;
	}

	public Integer getPreOperOptbody() {
		return preOperOptbody;
	}

	public void setPreOperOptbody(Integer preOperOptbody) {
		this.preOperOptbody = preOperOptbody;
	}

	public Integer getCoverWarm() {
		return coverWarm;
	}

	public void setCoverWarm(Integer coverWarm) {
		this.coverWarm = coverWarm;
	}

	public Integer getOperingOptbodyComfort() {
		return operingOptbodyComfort;
	}

	public void setOperingOptbodyComfort(Integer operingOptbodyComfort) {
		this.operingOptbodyComfort = operingOptbodyComfort;
	}

	public Integer getPostOperRestore() {
		return postOperRestore;
	}

	public void setPostOperRestore(Integer postOperRestore) {
		this.postOperRestore = postOperRestore;
	}

	public Integer getByInterviewHelp() {
		return byInterviewHelp;
	}

	public void setByInterviewHelp(Integer byInterviewHelp) {
		this.byInterviewHelp = byInterviewHelp;
	}

	public Integer getSatisfacation() {
		return satisfacation;
	}

	public void setSatisfacation(Integer satisfacation) {
		this.satisfacation = satisfacation;
	}

	public String getSugest() {
		return sugest;
	}

	public void setSugest(String sugest) {
		this.sugest = sugest == null ? null : sugest.trim();
	}

	public Integer getInterviewUser() {
		return interviewUser;
	}

	public void setInterviewUser(Integer interviewUser) {
		this.interviewUser = interviewUser;
	}

	public String getInterviewRelation() {
		return interviewRelation;
	}

	public void setInterviewRelation(String interviewRelation) {
		this.interviewRelation = interviewRelation == null ? null
				: interviewRelation.trim();
	}

	public Date getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState == null ? null : processState.trim();
	}
}