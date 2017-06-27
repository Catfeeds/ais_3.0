/*
 * BasMedicalTakeReason.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="给药理由")
public class BasMedicalTakeReason {
    /**
     * id
     */
    @ApiModelProperty(value="主键id")
    private String medTakeReasonId;

    /**
     * 理由
     */
    @ApiModelProperty(value="理由")
    private String reason;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getMedTakeReasonId() {
        return medTakeReasonId;
    }

    public void setMedTakeReasonId(String medTakeReasonId) {
        this.medTakeReasonId = medTakeReasonId == null ? null : medTakeReasonId.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}