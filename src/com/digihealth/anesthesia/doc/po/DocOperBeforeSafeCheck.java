/*
 * DocOperBeforeSafeCheck.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.List;
import java.util.Map;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术开始前安全核查单对象")
public class DocOperBeforeSafeCheck {
	@ApiModelProperty(value = "主键id")
    private String operBeforeId;

	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 患者基本信息确认
     */
	@ApiModelProperty(value = "患者基本信息确认")
    private String patientInfoConfirm;

    /**
     * 手术前诊断确认
     */
	@ApiModelProperty(value = "手术前诊断确认")
    private String operBeDiagConfirm;

    /**
     * 手术方式确认
     */
	@ApiModelProperty(value = "手术方式确认")
    private String desigedOperConfirm;

    /**
     * 手术部位与标识正确
     */
	@ApiModelProperty(value = "手术部位与标识正确")
    private String operSiteLogoConfirm;

    /**
     * 麻醉风险提示
     */
	@ApiModelProperty(value = "麻醉风险提示")
    private String anaesRiskConfirm;

    /**
     * 手术前准备完善确认
     */
	@ApiModelProperty(value = "手术前准备完善确认")
    private String operBeReadyConfirm;

    /**
     * 手术重点和难点确认
     */
	@ApiModelProperty(value = "手术重点和难点确认")
    private String operBeEmphasisConfirm;

	@ApiModelProperty(value = "")
    private String operBeOther;

    /**
     * 麻醉准备完善确认
     */
	@ApiModelProperty(value = "麻醉准备完善确认")
    private String anaesBeReadyConfirm;

    /**
     * 麻醉重点和难点确认
     */
	@ApiModelProperty(value = "麻醉重点和难点确认")
    private String anaesBeEmphasisConfirm;

    /**
     * 其他
     */
	@ApiModelProperty(value = "其他")
    private String anaesBeOther;

    /**
     * 手术所需物件准备确认
     */
	@ApiModelProperty(value = "手术所需物件准备确认")
    private String operThingConfirm;

    /**
     * 物品灭菌合格确认
     */
	@ApiModelProperty(value = "物品灭菌合格确认")
    private String thingSterilizationConfirm;

    /**
     * 手术用药准备确认
     */
	@ApiModelProperty(value = "手术用药准备确认")
    private String operMedConfirm;

    /**
     * 其他
     */
	@ApiModelProperty(value = "其他")
    private String operMedOther;

    /**
     * 是否需要相关影像资料
     */
	@ApiModelProperty(value = "是否需要相关影像资料")
    private String imageDataConfirm;

	@ApiModelProperty(value = "其他")
    private String other;

	@ApiModelProperty(value = "麻醉医生id")
    private String anesthetistId;

	@ApiModelProperty(value = "手术医生id")
    private String operatorId;

	@ApiModelProperty(value = "巡回护士id")
    private String circuNurseId;

	@ApiModelProperty(value = "")
    private String instrumentConfirm;

	@ApiModelProperty(value = "手术医生")
	private String operatorName;
	
	@ApiModelProperty(value = "巡回护士")
	private String circunurseName;
	
	@ApiModelProperty(value = "麻醉医生")
	private String anesthetistName;
    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成")
    private String processState;

    /**
     * 大于等于10毫升/kg
     */
	@ApiModelProperty(value = "大于等于10毫升/kg")
    private String sssxl;
	
	@ApiModelProperty(value = "安全核查单护士")
	private List<String> circunurseList;//安全核查单护士
	
	@ApiModelProperty(value = "安全核查麻醉医生")
    private List<String> anesthetistList;//安全核查麻醉医生
	
	@ApiModelProperty(value = "安全核查手术医生")
    private List<String> operatorList;//安全核查手术医生

    public List<String> getCircunurseList()
    {
        return circunurseList;
    }

    public void setCircunurseList(List<String> circunurseList)
    {
        this.circunurseList = circunurseList;
    }

    public List<String> getAnesthetistList()
    {
        return anesthetistList;
    }

    public void setAnesthetistList(List<String> anesthetistList)
    {
        this.anesthetistList = anesthetistList;
    }

    public List<String> getOperatorList()
    {
        return operatorList;
    }

    public void setOperatorList(List<String> operatorList)
    {
        this.operatorList = operatorList;
    }

    public String getOperBeforeId() {
        return operBeforeId;
    }

    public void setOperBeforeId(String operBeforeId) {
        this.operBeforeId = operBeforeId == null ? null : operBeforeId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getPatientInfoConfirm() {
        return patientInfoConfirm;
    }

    public void setPatientInfoConfirm(String patientInfoConfirm) {
        this.patientInfoConfirm = patientInfoConfirm == null ? null : patientInfoConfirm.trim();
    }

    public String getOperBeDiagConfirm() {
        return operBeDiagConfirm;
    }

    public void setOperBeDiagConfirm(String operBeDiagConfirm) {
        this.operBeDiagConfirm = operBeDiagConfirm == null ? null : operBeDiagConfirm.trim();
    }

    public String getDesigedOperConfirm() {
        return desigedOperConfirm;
    }

    public void setDesigedOperConfirm(String desigedOperConfirm) {
        this.desigedOperConfirm = desigedOperConfirm == null ? null : desigedOperConfirm.trim();
    }

    public String getOperSiteLogoConfirm() {
        return operSiteLogoConfirm;
    }

    public void setOperSiteLogoConfirm(String operSiteLogoConfirm) {
        this.operSiteLogoConfirm = operSiteLogoConfirm == null ? null : operSiteLogoConfirm.trim();
    }

    public String getAnaesRiskConfirm() {
        return anaesRiskConfirm;
    }

    public void setAnaesRiskConfirm(String anaesRiskConfirm) {
        this.anaesRiskConfirm = anaesRiskConfirm == null ? null : anaesRiskConfirm.trim();
    }

    public String getOperBeReadyConfirm() {
        return operBeReadyConfirm;
    }

    public void setOperBeReadyConfirm(String operBeReadyConfirm) {
        this.operBeReadyConfirm = operBeReadyConfirm == null ? null : operBeReadyConfirm.trim();
    }

    public String getOperBeEmphasisConfirm() {
        return operBeEmphasisConfirm;
    }

    public void setOperBeEmphasisConfirm(String operBeEmphasisConfirm) {
        this.operBeEmphasisConfirm = operBeEmphasisConfirm == null ? null : operBeEmphasisConfirm.trim();
    }

    public String getOperBeOther() {
        return operBeOther;
    }

    public void setOperBeOther(String operBeOther) {
        this.operBeOther = operBeOther == null ? null : operBeOther.trim();
    }

    public String getAnaesBeReadyConfirm() {
        return anaesBeReadyConfirm;
    }

    public void setAnaesBeReadyConfirm(String anaesBeReadyConfirm) {
        this.anaesBeReadyConfirm = anaesBeReadyConfirm == null ? null : anaesBeReadyConfirm.trim();
    }

    public String getAnaesBeEmphasisConfirm() {
        return anaesBeEmphasisConfirm;
    }

    public void setAnaesBeEmphasisConfirm(String anaesBeEmphasisConfirm) {
        this.anaesBeEmphasisConfirm = anaesBeEmphasisConfirm == null ? null : anaesBeEmphasisConfirm.trim();
    }

    public String getAnaesBeOther() {
        return anaesBeOther;
    }

    public void setAnaesBeOther(String anaesBeOther) {
        this.anaesBeOther = anaesBeOther == null ? null : anaesBeOther.trim();
    }

    public String getOperThingConfirm() {
        return operThingConfirm;
    }

    public void setOperThingConfirm(String operThingConfirm) {
        this.operThingConfirm = operThingConfirm == null ? null : operThingConfirm.trim();
    }

    public String getThingSterilizationConfirm() {
        return thingSterilizationConfirm;
    }

    public void setThingSterilizationConfirm(String thingSterilizationConfirm) {
        this.thingSterilizationConfirm = thingSterilizationConfirm == null ? null : thingSterilizationConfirm.trim();
    }

    public String getOperMedConfirm() {
        return operMedConfirm;
    }

    public void setOperMedConfirm(String operMedConfirm) {
        this.operMedConfirm = operMedConfirm == null ? null : operMedConfirm.trim();
    }

    public String getOperMedOther() {
        return operMedOther;
    }

    public void setOperMedOther(String operMedOther) {
        this.operMedOther = operMedOther == null ? null : operMedOther.trim();
    }

    public String getImageDataConfirm() {
        return imageDataConfirm;
    }

    public void setImageDataConfirm(String imageDataConfirm) {
        this.imageDataConfirm = imageDataConfirm == null ? null : imageDataConfirm.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getAnesthetistId() {
        return anesthetistId;
    }

    public void setAnesthetistId(String anesthetistId) {
        this.anesthetistId = anesthetistId == null ? null : anesthetistId.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getCircuNurseId() {
        return circuNurseId;
    }

    public void setCircuNurseId(String circuNurseId) {
        this.circuNurseId = circuNurseId == null ? null : circuNurseId.trim();
    }

    public String getInstrumentConfirm() {
        return instrumentConfirm;
    }

    public void setInstrumentConfirm(String instrumentConfirm) {
        this.instrumentConfirm = instrumentConfirm == null ? null : instrumentConfirm.trim();
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCircunurseName() {
		return circunurseName;
	}

	public void setCircunurseName(String circunurseName) {
		this.circunurseName = circunurseName;
	}

	public String getAnesthetistName() {
		return anesthetistName;
	}

	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}

	public String getSssxl() {
        return sssxl;
    }

    public void setSssxl(String sssxl) {
        this.sssxl = sssxl == null ? null : sssxl.trim();
    }
}