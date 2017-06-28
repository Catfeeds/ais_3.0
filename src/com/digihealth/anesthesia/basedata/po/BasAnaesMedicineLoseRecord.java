/*
 * BasAnaesMedicineLoseRecord.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-15 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

public class BasAnaesMedicineLoseRecord {
    /**
     * id
     */
    private Integer id;

    /**
     * 报损类型：1 普通报损，2 手术报损，3清点报损
     */
    private String loseType;

    /**
     * 取药记录id
     */
    private Integer outRecordId;

    /**
     * 毒麻药库存id，专为库存清点报损用的。
     */
    private Integer storageId;

    /**
     * 报损数量
     */
    private Integer loseNumber;

    /**
     * 报损日期
     */
    private Date loseTime;

    /**
     * 经办人
     */
    private String operator;

    /**
     * 报损人
     */
    private String loseName;

    /**
     * 报损理由
     */
    private String loseReason;

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

    public String getLoseType() {
        return loseType;
    }

    public void setLoseType(String loseType) {
        this.loseType = loseType == null ? null : loseType.trim();
    }

    public Integer getOutRecordId() {
        return outRecordId;
    }

    public void setOutRecordId(Integer outRecordId) {
        this.outRecordId = outRecordId;
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Integer getLoseNumber() {
        return loseNumber;
    }

    public void setLoseNumber(Integer loseNumber) {
        this.loseNumber = loseNumber;
    }

    public Date getLoseTime() {
        return loseTime;
    }

    public void setLoseTime(Date loseTime) {
        this.loseTime = loseTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getLoseName() {
        return loseName;
    }

    public void setLoseName(String loseName) {
        this.loseName = loseName == null ? null : loseName.trim();
    }

    public String getLoseReason() {
        return loseReason;
    }

    public void setLoseReason(String loseReason) {
        this.loseReason = loseReason == null ? null : loseReason.trim();
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