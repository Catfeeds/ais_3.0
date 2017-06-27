/*
 * DocAnalgesicMedicalInfo.java
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

@ApiModel(value = "访视情况对象")
public class DocAnalgesicMedicalInfo {
    /**
     * 记录单主键
     */
	@ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 患者Id
     */
	@ApiModelProperty(value = "患者Id")
    private String regOptId;

    /**
     * 镇痛随访记录Id
     */
	@ApiModelProperty(value = "镇痛随访记录Id")
    private String analgesicId;

    /**
     * 时间
     */
	@ApiModelProperty(value = "时间")
    private Date time;

    /**
     * 维持用药
     */
	@ApiModelProperty(value = "维持用药")
    private Float mainteAmount;

    /**
     * 单位
     */
	@ApiModelProperty(value = "单位")
    private String mainteUnit;

    /**
     * 追加用药
     */
	@ApiModelProperty(value = "追加用药")
    private Float addAmount;

    /**
     * 单位
     */
	@ApiModelProperty(value = "单位")
    private String addUnit;

	@ApiModelProperty(value = "lockTime")
    private Float lockTime;

    /**
     * 时间单位
     */
	@ApiModelProperty(value = "时间单位")
    private String lockUnit;

    /**
     * 追加用药
     */
	@ApiModelProperty(value = "追加用药")
    private String medId;

	@ApiModelProperty(value = "medName")
    private String medName;

    /**
     * 记录人员
     */
	@ApiModelProperty(value = "记录人员")
    private String inquiryDoctor;

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

    public String getAnalgesicId() {
        return analgesicId;
    }

    public void setAnalgesicId(String analgesicId) {
        this.analgesicId = analgesicId == null ? null : analgesicId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Float getMainteAmount() {
        return mainteAmount;
    }

    public void setMainteAmount(Float mainteAmount) {
        this.mainteAmount = mainteAmount;
    }

    public String getMainteUnit() {
        return mainteUnit;
    }

    public void setMainteUnit(String mainteUnit) {
        this.mainteUnit = mainteUnit == null ? null : mainteUnit.trim();
    }

    public Float getAddAmount() {
        return addAmount;
    }

    public void setAddAmount(Float addAmount) {
        this.addAmount = addAmount;
    }

    public String getAddUnit() {
        return addUnit;
    }

    public void setAddUnit(String addUnit) {
        this.addUnit = addUnit == null ? null : addUnit.trim();
    }

    public Float getLockTime() {
        return lockTime;
    }

    public void setLockTime(Float lockTime) {
        this.lockTime = lockTime;
    }

    public String getLockUnit() {
        return lockUnit;
    }

    public void setLockUnit(String lockUnit) {
        this.lockUnit = lockUnit == null ? null : lockUnit.trim();
    }

    public String getMedId() {
        return medId;
    }

    public void setMedId(String medId) {
        this.medId = medId == null ? null : medId.trim();
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName == null ? null : medName.trim();
    }

    public String getInquiryDoctor() {
        return inquiryDoctor;
    }

    public void setInquiryDoctor(String inquiryDoctor) {
        this.inquiryDoctor = inquiryDoctor == null ? null : inquiryDoctor.trim();
    }
}