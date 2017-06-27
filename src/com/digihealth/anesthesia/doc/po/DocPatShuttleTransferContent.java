/*
 * DocPatShuttleTransferContent.java
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

@ApiModel(value = "手术患者接送交接单内容表对象")
public class DocPatShuttleTransferContent {
	@ApiModelProperty(value = "主键id")
	private String id;

	@ApiModelProperty(value = "手术患者接送交接单主表id")
	private String patShuttleId;

	/**
	 * 核对患者身份正确
	 */
	@ApiModelProperty(value = "核对患者身份正确")
	private Integer correctIden;

	/**
	 * 未用完的血制品
	 */
	@ApiModelProperty(value = "未用完的血制品")
	private Integer unuseBloodProduct;

	/**
	 * 术中用药有无过敏
	 */
	@ApiModelProperty(value = "术中用药有无过敏")
	private Integer medAllergy;

	/**
	 * 术中输血有无过敏
	 */
	@ApiModelProperty(value = "术中输血有无过敏")
	private Integer transfusionAllergy;

	/**
	 * 止痛泵
	 */
	@ApiModelProperty(value = "止痛泵")
	private Integer pcia;

	/**
	 * 手术室护士签名
	 */
	@ApiModelProperty(value = "手术室护士签名")
	private String signUser;

	/**
	 * 手术室护士签名日期时间
	 */
	@ApiModelProperty(value = "手术室护士签名日期时间")
	private Date signTime;

	/**
	 * 核对内容位置
	 */
	@ApiModelProperty(value = "核对内容位置")
	private String checkPoint;

	/**
	 * 未用完的药
	 */
	@ApiModelProperty(value = "未用完的药")
	private String unuseDrug;

	/**
	 * 剩余量
	 */
	@ApiModelProperty(value = "剩余量")
	private String surplus;

	/**
	 * 皮肤完整
	 */
	@ApiModelProperty(value = "皮肤完整")
	private String skinFull;

	/**
	 * 手术室带回
	 */
	@ApiModelProperty(value = "手术室带回")
	private String operroomTake;

	/**
	 * 静脉通路部位
	 */
	@ApiModelProperty(value = "静脉通路部位")
	private String veinBody;

	/**
	 * 其他
	 */
	@ApiModelProperty(value = "其他")
	private String other;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getPatShuttleId() {
		return patShuttleId;
	}

	public void setPatShuttleId(String patShuttleId) {
		this.patShuttleId = patShuttleId == null ? null : patShuttleId.trim();
	}

	public Integer getCorrectIden() {
		return correctIden;
	}

	public void setCorrectIden(Integer correctIden) {
		this.correctIden = correctIden;
	}

	public Integer getUnuseBloodProduct() {
		return unuseBloodProduct;
	}

	public void setUnuseBloodProduct(Integer unuseBloodProduct) {
		this.unuseBloodProduct = unuseBloodProduct;
	}

	public Integer getMedAllergy() {
		return medAllergy;
	}

	public void setMedAllergy(Integer medAllergy) {
		this.medAllergy = medAllergy;
	}

	public Integer getTransfusionAllergy() {
		return transfusionAllergy;
	}

	public void setTransfusionAllergy(Integer transfusionAllergy) {
		this.transfusionAllergy = transfusionAllergy;
	}

	public Integer getPcia() {
		return pcia;
	}

	public void setPcia(Integer pcia) {
		this.pcia = pcia;
	}

	public String getSignUser() {
		return signUser;
	}

	public void setSignUser(String signUser) {
		this.signUser = signUser == null ? null : signUser.trim();
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getCheckPoint() {
		return checkPoint;
	}

	public void setCheckPoint(String checkPoint) {
		this.checkPoint = checkPoint == null ? null : checkPoint.trim();
	}

	public String getUnuseDrug() {
		return unuseDrug;
	}

	public void setUnuseDrug(String unuseDrug) {
		this.unuseDrug = unuseDrug == null ? null : unuseDrug.trim();
	}

	public String getSurplus() {
		return surplus;
	}

	public void setSurplus(String surplus) {
		this.surplus = surplus == null ? null : surplus.trim();
	}

	public String getSkinFull() {
		return skinFull;
	}

	public void setSkinFull(String skinFull) {
		this.skinFull = skinFull == null ? null : skinFull.trim();
	}

	public String getOperroomTake() {
		return operroomTake;
	}

	public void setOperroomTake(String operroomTake) {
		this.operroomTake = operroomTake == null ? null : operroomTake.trim();
	}

	public String getVeinBody() {
		return veinBody;
	}

	public void setVeinBody(String veinBody) {
		this.veinBody = veinBody == null ? null : veinBody.trim();
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other == null ? null : other.trim();
	}
}