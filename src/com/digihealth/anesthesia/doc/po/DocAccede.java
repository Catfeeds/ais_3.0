/*
 * DocAccede.java
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

@ApiModel(value = "麻醉同意书对象")
public class DocAccede {

	@ApiModelProperty(value = "主键id")
    private String accedeId;

	@ApiModelProperty(value = "患者id")
    private String regOptId;

	@ApiModelProperty(value = "其他不良信息")
    private String other;

	@ApiModelProperty(value = "麻醉医生id")
    private String anaestheitistId;

    /**
     * 麻醉医生签订时间
     */
	@ApiModelProperty(value = "麻醉医生签订时间")
    private String anaestheitistSignTime;

    /**
     * 患者或代理人签名
     */
	@ApiModelProperty(value = "患者或代理人签名")
    private String patient;

    /**
     * 与患者关系
     */
	@ApiModelProperty(value = "与患者关系")
    private String patientRelationship;

    /**
     * 患者签订时间
     */
	@ApiModelProperty(value = "患者签订时间")
    private String patientSignTime;

    /**
     * 谈话地点
     */
	@ApiModelProperty(value = "谈话地点")
    private String talkLocation;

	@ApiModelProperty(value = "flag")
    private String flag;

    /**
     * 完成状态;NO_END:未完成,END:完成
     */
	@ApiModelProperty(value = "完成状态;NO_END:未完成,END:完成")
    private String processState;

    /**
     * 选中的选项
     */
	@ApiModelProperty(value = "选中的选项")
    private String selected;

    /**
     * 疾病名称
     */
	@ApiModelProperty(value = "疾病名称")
    private String diagnosisName;

	@ApiModelProperty(value = "麻醉方法编号")
    private String anaseMethodCode;

    /**
     * 麻醉方式
     */
	@ApiModelProperty(value = "麻醉方法")
    private String anaseMethod;

    /**
     * 其他风险
     */
	@ApiModelProperty(value = "其他风险")
    private String otherRisk;

    /**
     * 患者知情选择
     */
	@ApiModelProperty(value = "患者知情选择")
    private String patientChoose;

	@ApiModelProperty(value = "")
    private Integer trachealTntubation;

	@ApiModelProperty(value = "")
    private Integer catheterizationArtery;

	@ApiModelProperty(value = "")
    private Integer centralCatheter;

	@ApiModelProperty(value = "")
    private Integer spinalPuncture;

	@ApiModelProperty(value = "麻醉方法名称")
	private String anaestheitistName;

	@ApiModelProperty(value = "麻醉方法列表")
	private List<Map> anaseMethodList;
	/**
	 * 治疗内容 text
	 */
	@ApiModelProperty(value = "治疗内容")
	private String cureContent;
	
    public String getAccedeId() {
        return accedeId;
    }

    public void setAccedeId(String accedeId) {
        this.accedeId = accedeId == null ? null : accedeId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getAnaestheitistId() {
        return anaestheitistId;
    }

    public void setAnaestheitistId(String anaestheitistId) {
        this.anaestheitistId = anaestheitistId == null ? null : anaestheitistId.trim();
    }

    public String getAnaestheitistSignTime() {
        return anaestheitistSignTime;
    }

    public void setAnaestheitistSignTime(String anaestheitistSignTime) {
        this.anaestheitistSignTime = anaestheitistSignTime == null ? null : anaestheitistSignTime.trim();
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient == null ? null : patient.trim();
    }

    public String getPatientRelationship() {
        return patientRelationship;
    }

    public void setPatientRelationship(String patientRelationship) {
        this.patientRelationship = patientRelationship == null ? null : patientRelationship.trim();
    }

    public String getPatientSignTime() {
        return patientSignTime;
    }

    public void setPatientSignTime(String patientSignTime) {
        this.patientSignTime = patientSignTime == null ? null : patientSignTime.trim();
    }

    public String getTalkLocation() {
        return talkLocation;
    }

    public void setTalkLocation(String talkLocation) {
        this.talkLocation = talkLocation == null ? null : talkLocation.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected == null ? null : selected.trim();
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName == null ? null : diagnosisName.trim();
    }

    public String getAnaseMethodCode() {
        return anaseMethodCode;
    }

    public void setAnaseMethodCode(String anaseMethodCode) {
        this.anaseMethodCode = anaseMethodCode == null ? null : anaseMethodCode.trim();
    }

    public String getAnaseMethod() {
        return anaseMethod;
    }

    public void setAnaseMethod(String anaseMethod) {
        this.anaseMethod = anaseMethod == null ? null : anaseMethod.trim();
    }

    public String getOtherRisk() {
        return otherRisk;
    }

    public void setOtherRisk(String otherRisk) {
        this.otherRisk = otherRisk == null ? null : otherRisk.trim();
    }

    public String getPatientChoose() {
        return patientChoose;
    }

    public void setPatientChoose(String patientChoose) {
        this.patientChoose = patientChoose == null ? null : patientChoose.trim();
    }

    public Integer getTrachealTntubation() {
        return trachealTntubation;
    }

    public void setTrachealTntubation(Integer trachealTntubation) {
        this.trachealTntubation = trachealTntubation;
    }

    public Integer getCatheterizationArtery() {
        return catheterizationArtery;
    }

    public void setCatheterizationArtery(Integer catheterizationArtery) {
        this.catheterizationArtery = catheterizationArtery;
    }

    public Integer getCentralCatheter() {
        return centralCatheter;
    }

    public void setCentralCatheter(Integer centralCatheter) {
        this.centralCatheter = centralCatheter;
    }

    public Integer getSpinalPuncture() {
        return spinalPuncture;
    }

    public void setSpinalPuncture(Integer spinalPuncture) {
        this.spinalPuncture = spinalPuncture;
    }

	public String getCureContent() {
		return cureContent;
	}

	public void setCureContent(String cureContent) {
		this.cureContent = cureContent;
	}

	public String getAnaestheitistName() {
		return anaestheitistName;
	}

	public void setAnaestheitistName(String anaestheitistName) {
		this.anaestheitistName = anaestheitistName;
	}

	public List<Map> getAnaseMethodList() {
		return anaseMethodList;
	}

	public void setAnaseMethodList(List<Map> anaseMethodList) {
		this.anaseMethodList = anaseMethodList;
	}
    
}