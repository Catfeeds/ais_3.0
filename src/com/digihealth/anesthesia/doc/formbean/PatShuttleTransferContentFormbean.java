package com.digihealth.anesthesia.doc.formbean;

/*
 * PatShuttleTransferContent.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-01-14 Created
 */
import java.util.Date;

import com.digihealth.anesthesia.doc.formbean.DocKVFilters;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术患者接送交接单内容参数对象")
public class PatShuttleTransferContentFormbean {
	@ApiModelProperty(value = "主键id")
	private String id;

	@ApiModelProperty(value = "手术患者接送交接单id")
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
	 * 其他
	 */
	@ApiModelProperty(value = "其他")
	private DocKVFilters other;

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
	 * 未用完的药
	 */
	@ApiModelProperty(value = "未用完的药")
	private DocKVFilters unuseDrug;

	/**
	 * 剩余量
	 */
	@ApiModelProperty(value = "剩余量")
	private DocKVFilters surplus;

	/**
	 * 皮肤完整
	 */
	@ApiModelProperty(value = "皮肤完整")
	private DocKVFilters skinFull;

	/**
	 * 手术室带回
	 */
	@ApiModelProperty(value = "手术室带回")
	private DocKVFilters operroomTake;

	/**
	 * 静脉通路部位
	 */
	@ApiModelProperty(value = "静脉通路部位")
	private DocKVFilters veinBody;

	@ApiModelProperty(value = "表明数据块 左边/右边")
	private String checkPoint;//表明数据块 左边/右边
	
	public DocKVFilters getOther() {
		return other;
	}

	public void setOther(DocKVFilters other) {
		this.other = other;
	}

	public DocKVFilters getUnuseDrug() {
		return unuseDrug;
	}

	public void setUnuseDrug(DocKVFilters unuseDrug) {
		this.unuseDrug = unuseDrug;
	}

	public DocKVFilters getSurplus() {
		return surplus;
	}

	public void setSurplus(DocKVFilters surplus) {
		this.surplus = surplus;
	}

	public DocKVFilters getSkinFull() {
		return skinFull;
	}

	public void setSkinFull(DocKVFilters skinFull) {
		this.skinFull = skinFull;
	}

	public DocKVFilters getOperroomTake() {
		return operroomTake;
	}

	public void setOperroomTake(DocKVFilters operroomTake) {
		this.operroomTake = operroomTake;
	}

	public DocKVFilters getVeinBody() {
		return veinBody;
	}

	public void setVeinBody(DocKVFilters veinBody) {
		this.veinBody = veinBody;
	}

	public String getCheckPoint() {
		return checkPoint;
	}

	public void setCheckPoint(String checkPoint) {
		this.checkPoint = checkPoint;
	}

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

	
}