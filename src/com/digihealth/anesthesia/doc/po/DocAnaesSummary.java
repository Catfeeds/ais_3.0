/*
 * DocAnaesSummary.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉总结对象")
public class DocAnaesSummary {
	@ApiModelProperty(value = "主键id")
    private String anaSumId;

	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 麻醉实施情况
     */
	@ApiModelProperty(value = "麻醉实施情况")
    private String anaesImplSituation;

    /**
     * 麻醉小结
     */
	@ApiModelProperty(value = "麻醉小结")
    private String anestSummary;

    /**
     * 麻醉医生
     */
	@ApiModelProperty(value = "麻醉医生")
    private String anesthetistId;

    /**
     * 操作日期
     */
	@ApiModelProperty(value = "操作日期")
    private String operaDate;

    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成")
    private String processState;

    /**
     * 血型
     */
	@ApiModelProperty(value = "血型")
    private String bloodType;

    /**
     * 特殊情况
     */
	@ApiModelProperty(value = "特殊情况")
    private Integer expCase;

    /**
     * 特殊情况说明
     */
	@ApiModelProperty(value = "特殊情况说明")
    private String specialNote;

    /**
     * 肌力恢复
     */
	@ApiModelProperty(value = "肌力恢复")
    private Integer muscleRecovery;

    /**
     * 咳嗽吞咽反射
     */
	@ApiModelProperty(value = "咳嗽吞咽反射")
    private Integer coughReflex;

    /**
     * 定向恢复
     */
	@ApiModelProperty(value = "定向恢复")
    private Integer directlRec;

    /**
     * 意识
     */
	@ApiModelProperty(value = "意识")
    private Integer consciou;

    /**
     * 麻醉平面
     */
	@ApiModelProperty(value = "麻醉平面")
    private String anesPlane;

    /**
     * 备注
     */
	@ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 病人自控镇痛
     */
	@ApiModelProperty(value = "病人自控镇痛")
    private Integer controAnal;

    /**
     * 去向
     */
	@ApiModelProperty(value = "去向")
    private Integer leaveTo;

	@ApiModelProperty(value = "收缩压")
    private Float bpSys;//收缩压
	
	@ApiModelProperty(value = "舒张压")
    private Float bpDias;//舒张压

	@ApiModelProperty(value = "P")
    private Integer p;

	@ApiModelProperty(value = "R")
    private Integer r;

	@ApiModelProperty(value = "麻醉知情同意书")
    private Integer agreeDoc;//同意书
	
	@ApiModelProperty(value = "麻醉记录单")
    private Integer recordDoc;//记录单
	
	@ApiModelProperty(value = "麻醉目录单")
    private Integer catalogDoc;//目录
	
	/**
     * 人工气道/硬膜外导管拔除
     */
	@ApiModelProperty(value = "人工气道/硬膜外导管拔除")
    private Integer artifiAirwayRemoval;
    
    /**
     * 病人自控镇痛部位
     */
	@ApiModelProperty(value = "病人自控镇痛部位")
    private Integer controAnalPlace;
	
    public Integer getArtifiAirwayRemoval()
    {
        return artifiAirwayRemoval;
    }

    public void setArtifiAirwayRemoval(Integer artifiAirwayRemoval)
    {
        this.artifiAirwayRemoval = artifiAirwayRemoval;
    }

    public Integer getControAnalPlace()
    {
        return controAnalPlace;
    }

    public void setControAnalPlace(Integer controAnalPlace)
    {
        this.controAnalPlace = controAnalPlace;
    }

    public String getAnaSumId() {
        return anaSumId;
    }

    public void setAnaSumId(String anaSumId) {
        this.anaSumId = anaSumId == null ? null : anaSumId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getAnaesImplSituation() {
        return anaesImplSituation;
    }

    public void setAnaesImplSituation(String anaesImplSituation) {
        this.anaesImplSituation = anaesImplSituation == null ? null : anaesImplSituation.trim();
    }

    public String getAnestSummary() {
        return anestSummary;
    }

    public void setAnestSummary(String anestSummary) {
        this.anestSummary = anestSummary == null ? null : anestSummary.trim();
    }

    public String getAnesthetistId() {
        return anesthetistId;
    }

    public void setAnesthetistId(String anesthetistId) {
        this.anesthetistId = anesthetistId == null ? null : anesthetistId.trim();
    }

    public String getOperaDate() {
        return operaDate;
    }

    public void setOperaDate(String operaDate) {
        this.operaDate = operaDate == null ? null : operaDate.trim();
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public Integer getExpCase() {
        return expCase;
    }

    public void setExpCase(Integer expCase) {
        this.expCase = expCase;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote == null ? null : specialNote.trim();
    }

    public Integer getMuscleRecovery() {
        return muscleRecovery;
    }

    public void setMuscleRecovery(Integer muscleRecovery) {
        this.muscleRecovery = muscleRecovery;
    }

    public Integer getCoughReflex() {
        return coughReflex;
    }

    public void setCoughReflex(Integer coughReflex) {
        this.coughReflex = coughReflex;
    }

    public Integer getDirectlRec() {
        return directlRec;
    }

    public void setDirectlRec(Integer directlRec) {
        this.directlRec = directlRec;
    }

    public Integer getConsciou() {
        return consciou;
    }

    public void setConsciou(Integer consciou) {
        this.consciou = consciou;
    }

    public String getAnesPlane() {
        return anesPlane;
    }

    public void setAnesPlane(String anesPlane) {
        this.anesPlane = anesPlane == null ? null : anesPlane.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getControAnal() {
        return controAnal;
    }

    public void setControAnal(Integer controAnal) {
        this.controAnal = controAnal;
    }

    public Integer getLeaveTo() {
        return leaveTo;
    }

    public void setLeaveTo(Integer leaveTo) {
        this.leaveTo = leaveTo;
    }

	public Float getBpSys() {
		return bpSys;
	}

	public void setBpSys(Float bpSys) {
		this.bpSys = bpSys;
	}

	public Float getBpDias() {
		return bpDias;
	}

	public void setBpDias(Float bpDias) {
		this.bpDias = bpDias;
	}

	public Integer getP() {
		return p;
	}

	public void setP(Integer p) {
		this.p = p;
	}

	public Integer getR() {
		return r;
	}

	public void setR(Integer r) {
		this.r = r;
	}

	public Integer getAgreeDoc() {
		return agreeDoc;
	}

	public void setAgreeDoc(Integer agreeDoc) {
		this.agreeDoc = agreeDoc;
	}

	public Integer getRecordDoc() {
		return recordDoc;
	}

	public void setRecordDoc(Integer recordDoc) {
		this.recordDoc = recordDoc;
	}

	public Integer getCatalogDoc() {
		return catalogDoc;
	}

	public void setCatalogDoc(Integer catalogDoc) {
		this.catalogDoc = catalogDoc;
	}
    
}