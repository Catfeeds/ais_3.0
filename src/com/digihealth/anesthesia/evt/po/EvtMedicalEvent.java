/*
 * EvtMedicalEvent.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉事件表对象")
public class EvtMedicalEvent {
	/**
	 * 麻醉事件主键
	 */
	@ApiModelProperty(value = "麻醉事件主键")
	private String medEventId;

	@ApiModelProperty(value = "文书id")
	private String docId;

	/**
	 * 开始时间
	 */
	@ApiModelProperty(value = "开始时间")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@ApiModelProperty(value = "结束时间")
	private Date endTime;

	/**
	 * 剂量
	 */
	@ApiModelProperty(value = "剂量")
	private Float dosage;

	/**
	 * 浓度
	 */
	@ApiModelProperty(value = "浓度")
	private Float thickness;

	/**
	 * 浓度单位
	 */
	@ApiModelProperty(value = "浓度单位")
	private String thicknessUnit;

	/**
	 * 流速
	 */
	@ApiModelProperty(value = "流速")
	private Float flow;

	/**
	 * 流速单位
	 */
	@ApiModelProperty(value = "流速单位")
	private String flowUnit;

	/**
	 * 计价用量
	 */
	@ApiModelProperty(value = "计价用量")
	private Integer diluentQuant;

	/**
	 * 是否是持续性 1持续，0不持续
	 */
	@ApiModelProperty(value = "是否是持续性 1持续，0不持续")
	private Integer durable;

	/**
	 * 是否结束
	 */
	@ApiModelProperty(value = "是否结束")
	private Integer ended;

	/**
	 * 用药类型 1用药,2麻醉前用药,3药物维持
	 */
	@ApiModelProperty(value = "用药类型 1用药,2麻醉前用药,3药物维持")
	private Integer type;

	@ApiModelProperty(value = "创建人")
	private String createUser;

	@ApiModelProperty(value = "isCharged")
	private String isCharged;

	/**
	 * 药品id，关联药品表
	 */
	@ApiModelProperty(value = "药品id，关联药品表")
	private String medicineId;

	@ApiModelProperty(value = "occurHour")
	private String occurHour;

	@ApiModelProperty(value = "showOption")
	private String showOption;

	@ApiModelProperty(value = "isContinued")
	private Integer isContinued;

	@ApiModelProperty(value = "理由")
	private String reason;

	/**
	 * bas_medical_take_way的主键id
	 */
	@ApiModelProperty(value = "bas_medical_take_way的主键id")
	private String medTakeWayId;

	/**
	 * 药品价格id,bas_price表主键id
	 */
	@ApiModelProperty(value = "药品价格id,bas_price表主键id")
	private String priceId;

	/**
	 * 文书类型:1-麻醉记录单,2-pacu复苏记录单
	 */
	@ApiModelProperty(value = "文书类型:1-麻醉记录单,2-pacu复苏记录单")
	private Integer docType;

	/**
	 * 血浆浓度pc:0,效应室浓度ec:1
	 */
	@ApiModelProperty(value = "血浆浓度pc:0,效应室浓度ec:1")
	private Integer pcorec;
	/**
	 * tci单位:ug/ml,ng/ml
	 */
	@ApiModelProperty(value = "tci单位:ug/ml,ng/ml")
	private String tciUnit;

	/**
	 * 血浆浓度值或效应室浓度值
	 */
	@ApiModelProperty(value = "血浆浓度值或效应室浓度值")
	private Float tciValue;

	public String getMedEventId() {
		return medEventId;
	}

	public void setMedEventId(String medEventId) {
		this.medEventId = medEventId == null ? null : medEventId.trim();
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId == null ? null : docId.trim();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Float getDosage() {
		return dosage;
	}

	public void setDosage(Float dosage) {
		this.dosage = dosage;
	}

	public Float getThickness() {
		return thickness;
	}

	public void setThickness(Float thickness) {
		this.thickness = thickness;
	}

	public String getThicknessUnit() {
		return thicknessUnit;
	}

	public void setThicknessUnit(String thicknessUnit) {
		this.thicknessUnit = thicknessUnit == null ? null : thicknessUnit.trim();
	}

	public Float getFlow() {
		return flow;
	}

	public void setFlow(Float flow) {
		this.flow = flow;
	}

	public String getFlowUnit() {
		return flowUnit;
	}

	public void setFlowUnit(String flowUnit) {
		this.flowUnit = flowUnit == null ? null : flowUnit.trim();
	}

	public Integer getDiluentQuant() {
		return diluentQuant;
	}

	public void setDiluentQuant(Integer diluentQuant) {
		this.diluentQuant = diluentQuant;
	}

	public Integer getDurable() {
		return durable;
	}

	public void setDurable(Integer durable) {
		this.durable = durable;
	}

	public Integer getEnded() {
		return ended;
	}

	public void setEnded(Integer ended) {
		this.ended = ended;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public String getIsCharged() {
		return isCharged;
	}

	public void setIsCharged(String isCharged) {
		this.isCharged = isCharged == null ? null : isCharged.trim();
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId == null ? null : medicineId.trim();
	}

	public String getOccurHour() {
		return occurHour;
	}

	public void setOccurHour(String occurHour) {
		this.occurHour = occurHour == null ? null : occurHour.trim();
	}

	public String getShowOption() {
		return showOption;
	}

	public void setShowOption(String showOption) {
		this.showOption = showOption == null ? null : showOption.trim();
	}

	public Integer getIsContinued() {
		return isContinued;
	}

	public void setIsContinued(Integer isContinued) {
		this.isContinued = isContinued;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason == null ? null : reason.trim();
	}

	public String getMedTakeWayId() {
		return medTakeWayId;
	}

	public void setMedTakeWayId(String medTakeWayId) {
		this.medTakeWayId = medTakeWayId == null ? null : medTakeWayId.trim();
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId == null ? null : priceId.trim();
	}

	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
		this.docType = docType;
	}

	public Integer getPcorec() {
		return pcorec;
	}

	public void setPcorec(Integer pcorec) {
		this.pcorec = pcorec;
	}

	public String getTciUnit() {
		return tciUnit;
	}

	public void setTciUnit(String tciUnit) {
		this.tciUnit = tciUnit;
	}

	public Float getTciValue() {
		return tciValue;
	}

	public void setTciValue(Float tciValue) {
		this.tciValue = tciValue;
	}

}