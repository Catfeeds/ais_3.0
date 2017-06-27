/*
 * BasDispatch.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "排班对象")
public class BasDispatch {
	/**
	 * 患者id
	 */
	@ApiModelProperty(value = "患者id")
	private String regOptId;

	/**
	 * 手术室id
	 */
	@ApiModelProperty(value = "手术室id")
	private String operRoomId;

	/**
	 * 手术室名称
	 */
	@ApiModelProperty(value = "手术室名称")
	private String operRoomName;

	/**
	 * 器械护士1
	 */
	@ApiModelProperty(value = "器械护士1")
	private String instrnurseId1;

	/**
	 * 巡回护士1
	 */
	@ApiModelProperty(value = "巡回护士1")
	private String circunurseId1;

	/**
	 * 麻醉医生
	 */
	@ApiModelProperty(value = "麻醉医生")
	private String anesthetistId;

	/**
	 * 上级医生
	 */
	@ApiModelProperty(value = "上级医生")
	private String circuAnesthetistId;

	/**
	 * 灌注医生
	 */
	@ApiModelProperty(value = "灌注医生")
	private String perfusionDoctorId;

	/**
	 * 手术时间
	 */
	@ApiModelProperty(value = "手术时间")
	private String startTime;

	/**
	 * 器械护士2
	 */
	@ApiModelProperty(value = "器械护士2")
	private String instrnurseId2;

	/**
	 * 巡回护士2
	 */
	@ApiModelProperty(value = "巡回护士2")
	private String circunurseId2;

	/**
	 * 是否暂存;0-否,1-是
	 */
	@ApiModelProperty(value = "是否暂存;0-否,1-是")
	private Integer isHold;

	@ApiModelProperty(value = "手术排程日期")
	private String operaDate; // 手术排程日期
	/**
	 * 卫生护士
	 */
	@ApiModelProperty(value = "卫生护士")
	private String healthNurse;

	/**
	 * 手术体位
	 */
	@ApiModelProperty(value = "手术体位")
	private String optBody;

	/**
	 * 手术申请填写的手术时间
	 */
	@ApiModelProperty(value = "手术申请填写的手术时间")
	private String operRegDate;

	/**
	 * 台次
	 */
	@ApiModelProperty(value = "台次")
	private String pcs;

	/**
	 * 基线id
	 */
	@ApiModelProperty(value = "基线id")
	private String beid;

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId == null ? null : regOptId.trim();
	}

	public String getOperRoomId() {
		return operRoomId;
	}

	public void setOperRoomId(String operRoomId) {
		this.operRoomId = operRoomId == null ? null : operRoomId.trim();
	}

	public String getOperRoomName() {
		return operRoomName;
	}

	public void setOperRoomName(String operRoomName) {
		this.operRoomName = operRoomName == null ? null : operRoomName.trim();
	}

	public String getInstrnurseId1() {
		return instrnurseId1;
	}

	public void setInstrnurseId1(String instrnurseId1) {
		this.instrnurseId1 = instrnurseId1 == null ? null : instrnurseId1
				.trim();
	}

	public String getCircunurseId1() {
		return circunurseId1;
	}

	public void setCircunurseId1(String circunurseId1) {
		this.circunurseId1 = circunurseId1 == null ? null : circunurseId1
				.trim();
	}

	public String getAnesthetistId() {
		return anesthetistId;
	}

	public void setAnesthetistId(String anesthetistId) {
		this.anesthetistId = anesthetistId == null ? null : anesthetistId
				.trim();
	}

	public String getCircuAnesthetistId() {
		return circuAnesthetistId;
	}

	public void setCircuAnesthetistId(String circuAnesthetistId) {
		this.circuAnesthetistId = circuAnesthetistId == null ? null
				: circuAnesthetistId.trim();
	}

	public String getPerfusionDoctorId() {
		return perfusionDoctorId;
	}

	public void setPerfusionDoctorId(String perfusionDoctorId) {
		this.perfusionDoctorId = perfusionDoctorId == null ? null
				: perfusionDoctorId.trim();
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getInstrnurseId2() {
		return instrnurseId2;
	}

	public void setInstrnurseId2(String instrnurseId2) {
		this.instrnurseId2 = instrnurseId2 == null ? null : instrnurseId2
				.trim();
	}

	public String getCircunurseId2() {
		return circunurseId2;
	}

	public void setCircunurseId2(String circunurseId2) {
		this.circunurseId2 = circunurseId2 == null ? null : circunurseId2
				.trim();
	}

	public Integer getIsHold() {
		return isHold;
	}

	public void setIsHold(Integer isHold) {
		this.isHold = isHold;
	}

	public String getHealthNurse() {
		return healthNurse;
	}

	public void setHealthNurse(String healthNurse) {
		this.healthNurse = healthNurse == null ? null : healthNurse.trim();
	}

	public String getOptBody() {
		return optBody;
	}

	public void setOptBody(String optBody) {
		this.optBody = optBody == null ? null : optBody.trim();
	}

	public String getOperRegDate() {
		return operRegDate;
	}

	public void setOperRegDate(String operRegDate) {
		this.operRegDate = operRegDate == null ? null : operRegDate.trim();
	}

	public String getPcs() {
		return pcs;
	}

	public void setPcs(String pcs) {
		this.pcs = pcs;
	}

	public String getOperaDate() {
		return operaDate;
	}

	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid == null ? null : beid.trim();
	}
}