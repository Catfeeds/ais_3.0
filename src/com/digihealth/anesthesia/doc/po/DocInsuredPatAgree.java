/*
 * DocInsuredPatAgree.java
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

@ApiModel(value = "参保患者特殊用药、卫材知情单对象")
public class DocInsuredPatAgree {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
     private String id;

    /**
     * 患者id
     */
    @ApiModelProperty(value = "患者id")
     private String regOptId;

    /**
     * 文书状态END,NO_END
     */
    @ApiModelProperty(value = "文书状态END,NO_END")
     private String processState;

    /**
     * 病人或家属签名
     */
    @ApiModelProperty(value = "病人或家属签名")
     private String patSign;

    /**
     * 医生签名
     */
    @ApiModelProperty(value = "医生签名")
     private String docSign;

    /**
     * 科主任签名
     */
    @ApiModelProperty(value = "科主任签名")
     private String directorSign;

    /**
     * 签名时间
     */
    @ApiModelProperty(value = "签名时间")
     private Date signTime;

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

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getPatSign() {
        return patSign;
    }

    public void setPatSign(String patSign) {
        this.patSign = patSign == null ? null : patSign.trim();
    }

    public String getDocSign() {
        return docSign;
    }

    public void setDocSign(String docSign) {
        this.docSign = docSign == null ? null : docSign.trim();
    }

    public String getDirectorSign() {
        return directorSign;
    }

    public void setDirectorSign(String directorSign) {
        this.directorSign = directorSign == null ? null : directorSign.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }
}