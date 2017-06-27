/*
 * DocOptRiskEvaluation.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "风险评估单对象")
public class DocOptRiskEvaluation {
    /**
     * 风险评估单ID
     */
    @ApiModelProperty(value = "风险评估单ID")
     private String optRiskEvaluationId;

    /**
     * 手术ID
     */
    @ApiModelProperty(value = "手术ID")
     private String regOptId;

    /**
     *  手术切口清洁度  1:I类  2:II类 3:III 4:IV
     */
    @ApiModelProperty(value = "手术切口清洁度  1:I类  2:II类 3:III 4:IV")
     private String incisionCleanliness;

    /**
     * 手术类别  1浅层组织2深部组织3器官手术4腔隙手术
     */
    @ApiModelProperty(value = "手术类别  1浅层组织2深部组织3器官手术4腔隙手术")
     private String surgeryCategory;

    /**
     * ASA分级 1-6表示级别
     */
    @ApiModelProperty(value = "ASA分级 1-6表示级别")
     private String asa;

    /**
     * 手术持续时间 1：3小时内完成 2：完成手术超3小时
     */
    @ApiModelProperty(value = "手术持续时间 1：3小时内完成 2：完成手术超3小时")
     private String durationSurgery;

    /**
     * 是否急诊手术 0是1不是 
     */
    @ApiModelProperty(value = "是否急诊手术 0是1不是 ")
     private Boolean emergency;

    /**
     * 手术风险评估分数
     */
    @ApiModelProperty(value = "手术风险评估分数")
     private String riskEvaluation;

    /**
     * NNIS分级 0-3级
     */
    @ApiModelProperty(value = "NNIS分级 0-3级")
     private String nnis;

    /**
     * 愈合感染 1甲级愈合 2浅层感染 3深层感染
     */
    @ApiModelProperty(value = "愈合感染 1甲级愈合 2浅层感染 3深层感染")
     private String healingInfections;

    @ApiModelProperty(value = "是否完成")
     private String processState;

    @ApiModelProperty(value = "完成时间")
     private String finishTime;

    @ApiModelProperty(value = "flag")
     private String flag;

    @ApiModelProperty(value = "手术医生id")
     private String doctorId;

    /**
     * 手术医生签名
     */
    @ApiModelProperty(value = "手术医生签名")
     private String doctorName;

    @ApiModelProperty(value = "麻醉医生id")
     private String anesthesId;

    /**
     * 麻醉医生签名
     */
    @ApiModelProperty(value = "麻醉医生签名")
     private String anesthesName;

    @ApiModelProperty(value = "护士id")
     private String nurseId;

    /**
     * 巡回护士签名
     */
    @ApiModelProperty(value = "巡回护士签名")
     private String tourNurseName;

    /**
     * NNIS分级评估手术医生签名
     */
    @ApiModelProperty(value = "NNIS分级评估手术医生签名")
     private String nnisDoctorName;

    /**
     * 经管医生签名
     */
    @ApiModelProperty(value = "经管医生签名")
     private String managerDoctorName;

    public String getOptRiskEvaluationId() {
        return optRiskEvaluationId;
    }

    public void setOptRiskEvaluationId(String optRiskEvaluationId) {
        this.optRiskEvaluationId = optRiskEvaluationId == null ? null : optRiskEvaluationId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getIncisionCleanliness() {
        return incisionCleanliness;
    }

    public void setIncisionCleanliness(String incisionCleanliness) {
        this.incisionCleanliness = incisionCleanliness == null ? null : incisionCleanliness.trim();
    }

    public String getSurgeryCategory() {
        return surgeryCategory;
    }

    public void setSurgeryCategory(String surgeryCategory) {
        this.surgeryCategory = surgeryCategory == null ? null : surgeryCategory.trim();
    }

    public String getAsa() {
        return asa;
    }

    public void setAsa(String asa) {
        this.asa = asa == null ? null : asa.trim();
    }

    public String getDurationSurgery() {
        return durationSurgery;
    }

    public void setDurationSurgery(String durationSurgery) {
        this.durationSurgery = durationSurgery == null ? null : durationSurgery.trim();
    }

    public Boolean getEmergency() {
        return emergency;
    }

    public void setEmergency(Boolean emergency) {
        this.emergency = emergency;
    }

    public String getRiskEvaluation() {
        return riskEvaluation;
    }

    public void setRiskEvaluation(String riskEvaluation) {
        this.riskEvaluation = riskEvaluation == null ? null : riskEvaluation.trim();
    }

    public String getNnis() {
        return nnis;
    }

    public void setNnis(String nnis) {
        this.nnis = nnis == null ? null : nnis.trim();
    }

    public String getHealingInfections() {
        return healingInfections;
    }

    public void setHealingInfections(String healingInfections) {
        this.healingInfections = healingInfections == null ? null : healingInfections.trim();
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime == null ? null : finishTime.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getAnesthesId() {
        return anesthesId;
    }

    public void setAnesthesId(String anesthesId) {
        this.anesthesId = anesthesId == null ? null : anesthesId.trim();
    }

    public String getAnesthesName() {
        return anesthesName;
    }

    public void setAnesthesName(String anesthesName) {
        this.anesthesName = anesthesName == null ? null : anesthesName.trim();
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId == null ? null : nurseId.trim();
    }

    public String getTourNurseName() {
        return tourNurseName;
    }

    public void setTourNurseName(String tourNurseName) {
        this.tourNurseName = tourNurseName == null ? null : tourNurseName.trim();
    }

    public String getNnisDoctorName() {
        return nnisDoctorName;
    }

    public void setNnisDoctorName(String nnisDoctorName) {
        this.nnisDoctorName = nnisDoctorName == null ? null : nnisDoctorName.trim();
    }

    public String getManagerDoctorName() {
        return managerDoctorName;
    }

    public void setManagerDoctorName(String managerDoctorName) {
        this.managerDoctorName = managerDoctorName == null ? null : managerDoctorName.trim();
    }
}