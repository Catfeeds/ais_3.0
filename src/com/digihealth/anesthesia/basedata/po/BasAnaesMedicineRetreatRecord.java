/*
 * BasAnaesMedicineRetreatRecord.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-15 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

public class BasAnaesMedicineRetreatRecord {
    /**
     * id
     */
    private Integer id;

    /**
     * 取药记录id
     */
    private Integer outRecordId;

    /**
     * 退药类型：1 普通取药，2 手术取药
     */
    private String retreatType;

    /**
     * 退药数量
     */
    private Integer retreatNumber = 0;

    /**
     * 退药日期
     */
    private Date retreatTime;

    /**
     * 经办人
     */
    private String operator;

    /**
     * 退药人
     */
    private String retreatName;

    /**
     * 退药理由
     */
    private String retreatreason;

    /**
     * 手术id
     */
    private String regOptId;

    /**
     * 描述
     */
    private String remark;
    
    /**
     * 是否有效： 0 逻辑删除，1正常数据  
     */
    private Integer enable;

    /**
     * 局点id
     */
    private String beid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOutRecordId() {
        return outRecordId;
    }

    public void setOutRecordId(Integer outRecordId) {
        this.outRecordId = outRecordId;
    }

    public String getRetreatType() {
        return retreatType;
    }

    public void setRetreatType(String retreatType) {
        this.retreatType = retreatType == null ? null : retreatType.trim();
    }

    public Integer getRetreatNumber() {
        return retreatNumber;
    }

    public void setRetreatNumber(Integer retreatNumber) {
        this.retreatNumber = retreatNumber;
    }

    public Date getRetreatTime() {
        return retreatTime;
    }

    public void setRetreatTime(Date retreatTime) {
        this.retreatTime = retreatTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getRetreatName() {
        return retreatName;
    }

    public void setRetreatName(String retreatName) {
        this.retreatName = retreatName == null ? null : retreatName.trim();
    }

    public String getRetreatreason() {
        return retreatreason;
    }

    public void setRetreatreason(String retreatreason) {
        this.retreatreason = retreatreason == null ? null : retreatreason.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getEnable()
	{
		return enable;
	}

	public void setEnable(Integer enable)
	{
		this.enable = enable;
	}

	public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}