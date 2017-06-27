/*
 * DocNursingDiagnosis.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "围手术期子表对象")
public class DocNursingDiagnosis {
    /**
     * ID
     */
    @ApiModelProperty(value = "主键id")
     private String nursingDiagnosisId;

    /**
     * 围手术期访视单ID
     */
    @ApiModelProperty(value = "围手术期访视单ID")
     private String perioperativeVisitId;

    /**
     * 护理诊断
     */
    @ApiModelProperty(value = "护理诊断")
     private String nursingDiagnosis;

    /**
     * 措施
     */
    @ApiModelProperty(value = "措施")
     private String measure;

    /**
     * 效果评估
     */
    @ApiModelProperty(value = "效果评估")
     private String effectEvaluation;

    public String getNursingDiagnosisId() {
        return nursingDiagnosisId;
    }

    public void setNursingDiagnosisId(String nursingDiagnosisId) {
        this.nursingDiagnosisId = nursingDiagnosisId == null ? null : nursingDiagnosisId.trim();
    }

    public String getPerioperativeVisitId() {
        return perioperativeVisitId;
    }

    public void setPerioperativeVisitId(String perioperativeVisitId) {
        this.perioperativeVisitId = perioperativeVisitId == null ? null : perioperativeVisitId.trim();
    }

    public String getNursingDiagnosis() {
        return nursingDiagnosis;
    }

    public void setNursingDiagnosis(String nursingDiagnosis) {
        this.nursingDiagnosis = nursingDiagnosis == null ? null : nursingDiagnosis.trim();
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure == null ? null : measure.trim();
    }

    public String getEffectEvaluation() {
        return effectEvaluation;
    }

    public void setEffectEvaluation(String effectEvaluation) {
        this.effectEvaluation = effectEvaluation == null ? null : effectEvaluation.trim();
    }
}