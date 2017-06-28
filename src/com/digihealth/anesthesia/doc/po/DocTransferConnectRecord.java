/*
 * DocTransferConnectRecord.java
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

@ApiModel(value = "手术病人转运交接记录单对象")
public class DocTransferConnectRecord {
	/**
	 * 交接记录单主键id
	 */
	@ApiModelProperty(value = "交接记录单主键id")
	private String id;

	/**
	 * 患者id
	 */
	@ApiModelProperty(value = "患者id")
	private String regOptId;

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
	 * 病历
	 */
	@ApiModelProperty(value = "病历")
	private Integer medicalRecord;

	/**
	 * 药品
	 */
	@ApiModelProperty(value = "药品")
	private String drug;

	/**
	 * 入手术室时间
	 */
	@ApiModelProperty(value = "入手术室时间")
	private Date inRoomTime;

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
	 * 文书状态
	 */
	@ApiModelProperty(value = "文书状态")
	private String processState;

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
	 * 影像片
	 */
	@ApiModelProperty(value = "影像片")
	private Integer iconPiece;

    /**
     * 影像片数量
     */
	@ApiModelProperty(value = "影像片数量")
    private Integer iconPieceAmount;

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

	/**
	 * 术中带药
	 */
	@ApiModelProperty(value = "术中带药")
	private Integer operingMedical;

    /**
     * 术中带药详情
     */
	@ApiModelProperty(value = "术中带药详情")
    private String operingMedicalDetails;

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

	public Integer getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(Integer medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug == null ? null : drug.trim();
	}

	public Date getInRoomTime() {
		return inRoomTime;
	}

	public void setInRoomTime(Date inRoomTime) {
		this.inRoomTime = inRoomTime;
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

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState == null ? null : processState.trim();
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

    public Integer getIconPiece()
    {
        return iconPiece;
    }

    public void setIconPiece(Integer iconPiece)
    {
        this.iconPiece = iconPiece;
    }

    public Integer getIconPieceAmount()
    {
        return iconPieceAmount;
    }

    public void setIconPieceAmount(Integer iconPieceAmount)
    {
        this.iconPieceAmount = iconPieceAmount;
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

    public Integer getOperingMedical()
    {
        return operingMedical;
    }

    public void setOperingMedical(Integer operingMedical)
    {
        this.operingMedical = operingMedical;
    }

    public String getOperingMedicalDetails()
    {
        return operingMedicalDetails;
    }

    public void setOperingMedicalDetails(String operingMedicalDetails)
    {
        this.operingMedicalDetails = operingMedicalDetails;
    }
}