/*
 * DocTransferConnectType.java
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

@ApiModel(value = "手术病人转运交接记录类型表对象")
public class DocTransferConnectType {
	/**
	 * 交接记录单主键id
	 */
	@ApiModelProperty(value = "主键id")
	private String id;

	/**
	 * 患者id
	 */
	@ApiModelProperty(value = "患者id")
	private String regOptId;

	/**
	 * 交接id
	 */
	@ApiModelProperty(value = "交接id")
	private String transferId;

	/**
	 * 1:病人去向,2:pacu转出病人去向
	 */
	@ApiModelProperty(value = "1:病人去向,2:pacu转出病人去向")
	private Integer type;

	/**
	 * 1:pacu,2:病房,3:icu,4:其他
	 */
	@ApiModelProperty(value = "1:pacu,2:病房,3:icu,4:其他")
	private Integer direction;

	/**
	 * 意识状态
	 */
	@ApiModelProperty(value = "意识状态")
	private Integer consciousCondition;

	/**
	 * 具体情况
	 */
	@ApiModelProperty(value = "具体情况")
	private String definiteCase;

	/**
	 * 胃管
	 */
	@ApiModelProperty(value = "胃管")
	private Integer stomachTube;

	/**
	 * 尿管
	 */
	@ApiModelProperty(value = "尿管")
	private Integer urineTube;

	/**
	 * 气管插管
	 */
	@ApiModelProperty(value = "气管插管")
	private Integer tracheaTube;

	/**
	 * 镇痛泵
	 */
	@ApiModelProperty(value = "镇痛泵")
	private Integer analgesicPump;

	/**
	 * 病历
	 */
	@ApiModelProperty(value = "病历")
	private Integer medicalRecord;

	/**
	 * 术中带药使用情况
	 */
	@ApiModelProperty(value = "术中带药使用情况")
	private Integer operingMedicalUse;

	/**
	 * 手术护理记录单
	 */
	@ApiModelProperty(value = "手术护理记录单")
	private Integer operOptNurse;

	/**
	 * 其他
	 */
	@ApiModelProperty(value = "其他")
	private String other;

	/**
	 * 交接护士1
	 */
	@ApiModelProperty(value = "交接护士1")
	private String joinNurse1;

	/**
	 * 交接护士2
	 */
	@ApiModelProperty(value = "交接护士2")
	private String joinNurse2;

	/**
	 * 交接时间
	 */
	@ApiModelProperty(value = "交接时间")
	private Date joinTime;

	/**
     * 皮肤情况
     */
    @ApiModelProperty(value = "皮肤情况")
    private Integer skinCase;

    /**
     * 皮肤情况详情
     */
    @ApiModelProperty(value = "皮肤情况详情")
    private String skinCaseDetails;

    /**
     * 输液
     */
    @ApiModelProperty(value = "输液")
    private Integer transfusion;

    /**
     * 输液数量
     */
    @ApiModelProperty(value = "输液数量")
    private Integer transfusionAmount;

    /**
     * 引流管
     */
    @ApiModelProperty(value = "引流管")
    private Integer drainageTube;

    /**
     * 引流管数量
     */
    @ApiModelProperty(value = "引流管数量")
    private Integer drainageTubeAmount;

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

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId == null ? null : transferId.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public Integer getConsciousCondition() {
		return consciousCondition;
	}

	public void setConsciousCondition(Integer consciousCondition) {
		this.consciousCondition = consciousCondition;
	}

	public String getDefiniteCase() {
		return definiteCase;
	}

	public void setDefiniteCase(String definiteCase) {
		this.definiteCase = definiteCase == null ? null : definiteCase.trim();
	}

	public Integer getStomachTube() {
		return stomachTube;
	}

	public void setStomachTube(Integer stomachTube) {
		this.stomachTube = stomachTube;
	}

	public Integer getUrineTube() {
		return urineTube;
	}

	public void setUrineTube(Integer urineTube) {
		this.urineTube = urineTube;
	}

	public Integer getTracheaTube() {
		return tracheaTube;
	}

	public void setTracheaTube(Integer tracheaTube) {
		this.tracheaTube = tracheaTube;
	}

	public Integer getAnalgesicPump() {
		return analgesicPump;
	}

	public void setAnalgesicPump(Integer analgesicPump) {
		this.analgesicPump = analgesicPump;
	}

	public Integer getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(Integer medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Integer getOperingMedicalUse() {
		return operingMedicalUse;
	}

	public void setOperingMedicalUse(Integer operingMedicalUse) {
		this.operingMedicalUse = operingMedicalUse;
	}

	public Integer getOperOptNurse() {
		return operOptNurse;
	}

	public void setOperOptNurse(Integer operOptNurse) {
		this.operOptNurse = operOptNurse;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other == null ? null : other.trim();
	}

	public String getJoinNurse1() {
		return joinNurse1;
	}

	public void setJoinNurse1(String joinNurse1) {
		this.joinNurse1 = joinNurse1 == null ? null : joinNurse1.trim();
	}

	public String getJoinNurse2() {
		return joinNurse2;
	}

	public void setJoinNurse2(String joinNurse2) {
		this.joinNurse2 = joinNurse2 == null ? null : joinNurse2.trim();
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

    public Integer getSkinCase()
    {
        return skinCase;
    }

    public void setSkinCase(Integer skinCase)
    {
        this.skinCase = skinCase;
    }

    public String getSkinCaseDetails()
    {
        return skinCaseDetails;
    }

    public void setSkinCaseDetails(String skinCaseDetails)
    {
        this.skinCaseDetails = skinCaseDetails;
    }

    public Integer getTransfusion()
    {
        return transfusion;
    }

    public void setTransfusion(Integer transfusion)
    {
        this.transfusion = transfusion;
    }

    public Integer getTransfusionAmount()
    {
        return transfusionAmount;
    }

    public void setTransfusionAmount(Integer transfusionAmount)
    {
        this.transfusionAmount = transfusionAmount;
    }

    public Integer getDrainageTube()
    {
        return drainageTube;
    }

    public void setDrainageTube(Integer drainageTube)
    {
        this.drainageTube = drainageTube;
    }

    public Integer getDrainageTubeAmount()
    {
        return drainageTubeAmount;
    }

    public void setDrainageTubeAmount(Integer drainageTubeAmount)
    {
        this.drainageTubeAmount = drainageTubeAmount;
    }
}