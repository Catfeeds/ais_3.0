/*
 * EvtInEvent.java
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

@ApiModel(value = "入量药品事件对象")
public class EvtInEvent {
	/**
	 * 入量药品事件主键
	 */

	@ApiModelProperty(value = "入量药品事件主键")
	private String inEventId;

	/**
	 * 文书ID
	 */
	@ApiModelProperty(value = "文书ID")
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
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	private String createUser;

	/**
	 * 剂量数量
	 */
	@ApiModelProperty(value = "剂量数量")
	private Float dosageAmount;

	/**
	 * 是否收费
	 */
	@ApiModelProperty(value = "是否收费")
	private Integer isCharged;

	/**
	 * 出入量基础表主键
	 */
	@ApiModelProperty(value = "出入量基础表主键")
	private String ioDefId;

	/**
	 * 通道
	 */
	@ApiModelProperty(value = "通道")
	private String passage;

	/**
	 * 药品价格id
	 */
	@ApiModelProperty(value = "药品价格id")
	private String priceId;

	/**
	 * 血型
	 */
	@ApiModelProperty(value = "血型")
	private String blood;

	/**
	 * 文书类型：1-麻醉记录单，2-pacu观察记录单
	 */
	@ApiModelProperty(value = "文书类型：1-麻醉记录单，2-pacu观察记录单")
	private Integer docType;

	public String getInEventId() {
		return inEventId;
	}

	public void setInEventId(String inEventId) {
		this.inEventId = inEventId == null ? null : inEventId.trim();
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

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public Float getDosageAmount() {
		return dosageAmount;
	}

	public void setDosageAmount(Float dosageAmount) {
		this.dosageAmount = dosageAmount;
	}

	public Integer getIsCharged() {
		return isCharged;
	}

	public void setIsCharged(Integer isCharged) {
		this.isCharged = isCharged;
	}

	public String getIoDefId() {
		return ioDefId;
	}

	public void setIoDefId(String ioDefId) {
		this.ioDefId = ioDefId == null ? null : ioDefId.trim();
	}

	public String getPassage() {
		return passage;
	}

	public void setPassage(String passage) {
		this.passage = passage == null ? null : passage.trim();
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId == null ? null : priceId.trim();
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood == null ? null : blood.trim();
	}

	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
		this.docType = docType;
	}
}