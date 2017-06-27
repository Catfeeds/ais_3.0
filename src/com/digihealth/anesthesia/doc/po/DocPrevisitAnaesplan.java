/*
 * DocPrevisitAnaesplan.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "术前访视一般情况及体格检查表对象")
public class DocPrevisitAnaesplan {
	@ApiModelProperty(value = "主键id")
	private String id;

	/**
	 * 外键，关联pre_visit_id
	 */
	@ApiModelProperty(value = "外键，关联pre_visit_id")
	private String preVisitId;

	@ApiModelProperty(value = "患者id")
	private String regOptId;

	/**
	 * 综合ASA分级
	 */
	@ApiModelProperty(value = "综合ASA分级")
	private String asa;

	/**
	 * 麻醉适应症
	 */
	@ApiModelProperty(value = "麻醉适应症")
	private Integer anesthIndica;

	/**
	 * 按期手术
	 */
	@ApiModelProperty(value = "按期手术")
	private Integer scheduled;

	/**
	 * 麻醉方法
	 */
	@ApiModelProperty(value = "麻醉方法")
	private String anaesType;

	/**
	 * 其他麻醉方法
	 */
	@ApiModelProperty(value = "其他麻醉方法")
	private String othAnaesType;

	/**
	 * 全身麻醉位置
	 */
	@ApiModelProperty(value = "全身麻醉位置")
	private String genAnesPos;

	/**
	 * 穿刺点
	 */
	@ApiModelProperty(value = "穿刺点")
	private String puncPoint;

	/**
	 * 麻醉准备
	 */
	@ApiModelProperty(value = "麻醉准备")
	private Integer anaesPrep;

	/**
	 * 麻醉特殊准备
	 */
	@ApiModelProperty(value = "麻醉特殊准备")
	private Integer anaesPrepSpec;

	/**
	 * 监测项目
	 */
	@ApiModelProperty(value = "监测项目")
	private String monitorItem;

	/**
	 * 监测项目其他
	 */
	@ApiModelProperty(value = "监测项目其他")
	private String monitorOther;

	/**
	 * 设备与药物
	 */
	@ApiModelProperty(value = "设备与药物")
	private String deviceMed;

	/**
	 * 其他设备与药物
	 */
	@ApiModelProperty(value = "其他设备与药物")
	private String otherDevMed;

	/**
	 * 变更麻醉方法
	 */
	@ApiModelProperty(value = "变更麻醉方法")
	private Integer anaesMethChg;

	/**
	 * 变更麻醉方法
	 */
	@ApiModelProperty(value = "变更麻醉方法")
	private String anaesMethChgRea;

	/**
	 * 麻醉特殊准备详情
	 */
	@ApiModelProperty(value = "麻醉特殊准备详情")
	private String anaesPrepSpecRes;

	/**
	 * 出室去向
	 */
	@ApiModelProperty(value = "出室去向")
	private String leaveTo;

	/**
	 * 综合ASA E分级
	 */
	@ApiModelProperty(value = "综合ASA E分级")
	private String asaE;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getPreVisitId() {
		return preVisitId;
	}

	public void setPreVisitId(String preVisitId) {
		this.preVisitId = preVisitId == null ? null : preVisitId.trim();
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId == null ? null : regOptId.trim();
	}

	public String getAsa() {
		return asa;
	}

	public void setAsa(String asa) {
		this.asa = asa == null ? null : asa.trim();
	}

	public Integer getAnesthIndica() {
		return anesthIndica;
	}

	public void setAnesthIndica(Integer anesthIndica) {
		this.anesthIndica = anesthIndica;
	}

	public Integer getScheduled() {
		return scheduled;
	}

	public void setScheduled(Integer scheduled) {
		this.scheduled = scheduled;
	}

	public String getAnaesType() {
		return anaesType;
	}

	public void setAnaesType(String anaesType) {
		this.anaesType = anaesType == null ? null : anaesType.trim();
	}

	public String getOthAnaesType() {
		return othAnaesType;
	}

	public void setOthAnaesType(String othAnaesType) {
		this.othAnaesType = othAnaesType == null ? null : othAnaesType.trim();
	}

	public String getGenAnesPos() {
		return genAnesPos;
	}

	public void setGenAnesPos(String genAnesPos) {
		this.genAnesPos = genAnesPos == null ? null : genAnesPos.trim();
	}

	public String getPuncPoint() {
		return puncPoint;
	}

	public void setPuncPoint(String puncPoint) {
		this.puncPoint = puncPoint == null ? null : puncPoint.trim();
	}

	public Integer getAnaesPrep() {
		return anaesPrep;
	}

	public void setAnaesPrep(Integer anaesPrep) {
		this.anaesPrep = anaesPrep;
	}

	public Integer getAnaesPrepSpec() {
		return anaesPrepSpec;
	}

	public void setAnaesPrepSpec(Integer anaesPrepSpec) {
		this.anaesPrepSpec = anaesPrepSpec;
	}

	public String getMonitorItem() {
		return monitorItem;
	}

	public void setMonitorItem(String monitorItem) {
		this.monitorItem = monitorItem == null ? null : monitorItem.trim();
	}

	public String getMonitorOther() {
		return monitorOther;
	}

	public void setMonitorOther(String monitorOther) {
		this.monitorOther = monitorOther == null ? null : monitorOther.trim();
	}

	public String getDeviceMed() {
		return deviceMed;
	}

	public void setDeviceMed(String deviceMed) {
		this.deviceMed = deviceMed == null ? null : deviceMed.trim();
	}

	public String getOtherDevMed() {
		return otherDevMed;
	}

	public void setOtherDevMed(String otherDevMed) {
		this.otherDevMed = otherDevMed == null ? null : otherDevMed.trim();
	}

	public Integer getAnaesMethChg() {
		return anaesMethChg;
	}

	public void setAnaesMethChg(Integer anaesMethChg) {
		this.anaesMethChg = anaesMethChg;
	}

	public String getAnaesMethChgRea() {
		return anaesMethChgRea;
	}

	public void setAnaesMethChgRea(String anaesMethChgRea) {
		this.anaesMethChgRea = anaesMethChgRea == null ? null : anaesMethChgRea
				.trim();
	}

	public String getAnaesPrepSpecRes() {
		return anaesPrepSpecRes;
	}

	public void setAnaesPrepSpecRes(String anaesPrepSpecRes) {
		this.anaesPrepSpecRes = anaesPrepSpecRes == null ? null
				: anaesPrepSpecRes.trim();
	}

	public String getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(String leaveTo) {
		this.leaveTo = leaveTo == null ? null : leaveTo.trim();
	}

	public String getAsaE() {
		return asaE;
	}

	public void setAsaE(String asaE) {
		this.asaE = asaE == null ? null : asaE.trim();
	}
}