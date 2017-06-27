/*
 * DocNurseInterviewRecord.java
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

@ApiModel(value = "手术室护理工作访视记录对象")
public class DocNurseInterviewRecord {
    /**
     * 手术室护理工作访视记录
     */
    @ApiModelProperty(value = "主键id")
     private String id;

    /**
     * 手术id
     */
    @ApiModelProperty(value = "手术id")
     private String regOptId;

    /**
     * 患者心理状况,单选
     */
    @ApiModelProperty(value = "患者心理状况,单选")
     private Integer patientMind;

    /**
     * 访视者签名
     */
    @ApiModelProperty(value = "访视者签名")
     private Integer interviewUser;

    /**
     * 家属
     */
    @ApiModelProperty(value = "家属")
     private String interviewRelation;

    /**
     * 访视时间
     */
    @ApiModelProperty(value = "访视时间")
     private Date interviewTime;

    /**
     * END,NO_END
     */
    @ApiModelProperty(value = "是否完成 END,NO_END")
     private String processState;

    /**
     * 查询病历资料
     */
    @ApiModelProperty(value = "查询病历资料")
     private String medicalRecord;

    /**
     * 相关情况介绍
     */
    @ApiModelProperty(value = "相关情况介绍")
     private String conditionIntroduce;

    /**
     * 术前准备情况
     */
    @ApiModelProperty(value = "术前准备情况")
     private String prePrepareCase;

    /**
     * 术前事项交代
     */
    @ApiModelProperty(value = "术前事项交代")
     private String preOperExplain;

    /**
     * 术前可能发生压疮
     */
    @ApiModelProperty(value = "术前可能发生压疮")
     private String operPressureSore;

    /**
     * 预防压疮采取的措施
     */
    @ApiModelProperty(value = "预防压疮采取的措施")
     private String preventPressureMeasure;

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

    public Integer getPatientMind() {
        return patientMind;
    }

    public void setPatientMind(Integer patientMind) {
        this.patientMind = patientMind;
    }

    public Integer getInterviewUser() {
        return interviewUser;
    }

    public void setInterviewUser(Integer interviewUser) {
        this.interviewUser = interviewUser;
    }

    public String getInterviewRelation() {
        return interviewRelation;
    }

    public void setInterviewRelation(String interviewRelation) {
        this.interviewRelation = interviewRelation == null ? null : interviewRelation.trim();
    }

    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord == null ? null : medicalRecord.trim();
    }

    public String getConditionIntroduce() {
        return conditionIntroduce;
    }

    public void setConditionIntroduce(String conditionIntroduce) {
        this.conditionIntroduce = conditionIntroduce == null ? null : conditionIntroduce.trim();
    }

    public String getPrePrepareCase() {
        return prePrepareCase;
    }

    public void setPrePrepareCase(String prePrepareCase) {
        this.prePrepareCase = prePrepareCase == null ? null : prePrepareCase.trim();
    }

    public String getPreOperExplain() {
        return preOperExplain;
    }

    public void setPreOperExplain(String preOperExplain) {
        this.preOperExplain = preOperExplain == null ? null : preOperExplain.trim();
    }

    public String getOperPressureSore() {
        return operPressureSore;
    }

    public void setOperPressureSore(String operPressureSore) {
        this.operPressureSore = operPressureSore == null ? null : operPressureSore.trim();
    }

    public String getPreventPressureMeasure() {
        return preventPressureMeasure;
    }

    public void setPreventPressureMeasure(String preventPressureMeasure) {
        this.preventPressureMeasure = preventPressureMeasure == null ? null : preventPressureMeasure.trim();
    }
}