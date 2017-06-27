/*
 * DocAnaesBeforeSafeCheck.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉实施前安全核查单对象")
public class DocAnaesBeforeSafeCheck {

	@ApiModelProperty(value = "主键id")
    private String anesBeforeId;

    /**
     * 患者id
     */
	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 患者基本信息确认
     */
	@ApiModelProperty(value = "患者基本信息确认")
    private String patientInfoConfirm;

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
     * 手术知情同意
     */
	@ApiModelProperty(value = "手术知情同意")
    private String operAccedeConfirm;

    /**
     * 麻醉知情同意
     */
	@ApiModelProperty(value = "麻醉知情同意")
    private String anaesAccedeConfirm;

    /**
     * 麻醉方式确认
     */
	@ApiModelProperty(value = "麻醉方式确认")
    private String anaesMethodConfirm;

    /**
     * 麻醉风险提示
     */
	@ApiModelProperty(value = "麻醉风险提示")
    private String anaesRiskConfirm;

    /**
     * 麻醉设备安全检查
     */
	@ApiModelProperty(value = "麻醉设备安全检查")
    private String anaesFqSafeCheckConfirm;

    /**
     * 皮肤是否完整
     */
	@ApiModelProperty(value = "皮肤是否完整")
    private String skinIntegratedConfirm;

    /**
     * 术野皮肤准备正确
     */
	@ApiModelProperty(value = "术野皮肤准备正确")
    private String skinSurgicalFieldConfirm;

    /**
     * 静脉通道确认
     */
	@ApiModelProperty(value = "静脉通道确认")
    private String venousAccessConfirm;

    /**
     * 患者是否有过敏史
     */
	@ApiModelProperty(value = "患者是否有过敏史")
    private String allergicDetail;

    /**
     * 抗菌药物皮试结果
     */
	@ApiModelProperty(value = "抗菌药物皮试结果")
    private String antSkinTestResult;

    /**
     * 血型
     */
	@ApiModelProperty(value = "血型")
    private String bloodType;

    /**
     * 备血
     */
	@ApiModelProperty(value = "备血")
    private String preparationBlood;

    /**
     * 假体
     */
	@ApiModelProperty(value = "假体")
    private String prosthesis;

    /**
     * 体内植入物
     */
	@ApiModelProperty(value = "体内植入物")
    private String implantVivo;

    /**
     * 影像学资料
     */
	@ApiModelProperty(value = "影像学资料")
    private String imagingData;

    /**
     * 其他
     */
	@ApiModelProperty(value = "其他")
    private String other;

    /**
     * 麻醉医生
     */
	@ApiModelProperty(value = "麻醉医生id")
    private String anesthetistId;

    /**
     * 手术医生
     */
	@ApiModelProperty(value = "手术医生id")
    private String operatorId;

    /**
     * 巡回护士
     */
	@ApiModelProperty(value = "巡回护士")
    private String circuNurseId;

    /**
     * NO_END:未完成,END:完成
     */
	@ApiModelProperty(value = "NO_END:未完成,END:完成")
    private String processState;

    /**
     * 困难气道
     */
	@ApiModelProperty(value = "困难气道")
    private String diffAirway;

	@ApiModelProperty(value = "手术医生")
	private String operatorName;
    /**
     * 误吸风险
     */
	@ApiModelProperty(value = "误吸风险")
    private String riskAspiration;

    /**
     * 输血同意书
     */
	@ApiModelProperty(value = "输血同意书")
    private String bloodAgree;

	@ApiModelProperty(value = "巡回护士")
	private String circunurseName;
	
	@ApiModelProperty(value = "麻醉医生")
	private String anesthetistName;
	
    public String getAnesBeforeId() {
        return anesBeforeId;
    }

    public void setAnesBeforeId(String anesBeforeId) {
        this.anesBeforeId = anesBeforeId == null ? null : anesBeforeId.trim();
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

    public String getOperAccedeConfirm() {
        return operAccedeConfirm;
    }

    public void setOperAccedeConfirm(String operAccedeConfirm) {
        this.operAccedeConfirm = operAccedeConfirm == null ? null : operAccedeConfirm.trim();
    }

    public String getAnaesAccedeConfirm() {
        return anaesAccedeConfirm;
    }

    public void setAnaesAccedeConfirm(String anaesAccedeConfirm) {
        this.anaesAccedeConfirm = anaesAccedeConfirm == null ? null : anaesAccedeConfirm.trim();
    }

    public String getAnaesMethodConfirm() {
        return anaesMethodConfirm;
    }

    public void setAnaesMethodConfirm(String anaesMethodConfirm) {
        this.anaesMethodConfirm = anaesMethodConfirm == null ? null : anaesMethodConfirm.trim();
    }

    public String getAnaesRiskConfirm() {
        return anaesRiskConfirm;
    }

    public void setAnaesRiskConfirm(String anaesRiskConfirm) {
        this.anaesRiskConfirm = anaesRiskConfirm == null ? null : anaesRiskConfirm.trim();
    }

    public String getAnaesFqSafeCheckConfirm() {
        return anaesFqSafeCheckConfirm;
    }

    public void setAnaesFqSafeCheckConfirm(String anaesFqSafeCheckConfirm) {
        this.anaesFqSafeCheckConfirm = anaesFqSafeCheckConfirm == null ? null : anaesFqSafeCheckConfirm.trim();
    }

    public String getSkinIntegratedConfirm() {
        return skinIntegratedConfirm;
    }

    public void setSkinIntegratedConfirm(String skinIntegratedConfirm) {
        this.skinIntegratedConfirm = skinIntegratedConfirm == null ? null : skinIntegratedConfirm.trim();
    }

    public String getSkinSurgicalFieldConfirm() {
        return skinSurgicalFieldConfirm;
    }

    public void setSkinSurgicalFieldConfirm(String skinSurgicalFieldConfirm) {
        this.skinSurgicalFieldConfirm = skinSurgicalFieldConfirm == null ? null : skinSurgicalFieldConfirm.trim();
    }

    public String getVenousAccessConfirm() {
        return venousAccessConfirm;
    }

    public void setVenousAccessConfirm(String venousAccessConfirm) {
        this.venousAccessConfirm = venousAccessConfirm == null ? null : venousAccessConfirm.trim();
    }

    public String getAllergicDetail() {
        return allergicDetail;
    }

    public void setAllergicDetail(String allergicDetail) {
        this.allergicDetail = allergicDetail == null ? null : allergicDetail.trim();
    }

    public String getAntSkinTestResult() {
        return antSkinTestResult;
    }

    public void setAntSkinTestResult(String antSkinTestResult) {
        this.antSkinTestResult = antSkinTestResult == null ? null : antSkinTestResult.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public String getPreparationBlood() {
        return preparationBlood;
    }

    public void setPreparationBlood(String preparationBlood) {
        this.preparationBlood = preparationBlood == null ? null : preparationBlood.trim();
    }

    public String getProsthesis() {
        return prosthesis;
    }

    public void setProsthesis(String prosthesis) {
        this.prosthesis = prosthesis == null ? null : prosthesis.trim();
    }

    public String getImplantVivo() {
        return implantVivo;
    }

    public void setImplantVivo(String implantVivo) {
        this.implantVivo = implantVivo == null ? null : implantVivo.trim();
    }

    public String getImagingData() {
        return imagingData;
    }

    public void setImagingData(String imagingData) {
        this.imagingData = imagingData == null ? null : imagingData.trim();
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

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getDiffAirway() {
        return diffAirway;
    }

    public void setDiffAirway(String diffAirway) {
        this.diffAirway = diffAirway == null ? null : diffAirway.trim();
    }

    public String getRiskAspiration() {
        return riskAspiration;
    }

    public void setRiskAspiration(String riskAspiration) {
        this.riskAspiration = riskAspiration == null ? null : riskAspiration.trim();
    }

    public String getBloodAgree() {
        return bloodAgree;
    }

    public void setBloodAgree(String bloodAgree) {
        this.bloodAgree = bloodAgree == null ? null : bloodAgree.trim();
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

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
    
}