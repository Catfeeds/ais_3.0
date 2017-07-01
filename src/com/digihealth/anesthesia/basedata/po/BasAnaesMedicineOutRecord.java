/*
 * BasAnaesMedicineOutRecord.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-14 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

public class BasAnaesMedicineOutRecord {
    /**
     * id
     */
    private Integer id;

    /**
     * 毒麻药库存id
     */
    private Integer storageId;

    /**
     * 药品编号
     */
    private String medicineCode;

    /**
     * 药品名称
     */
    private String medicineName;

    /**
     * 厂家
     */
    private String firm;

    /**
     * 规格
     */
    private String spec;

    /**
     * 批次
     */
    private String batch;

    /**
     * 有效日期
     */
    private Date effectiveTime;

    /**
     * 取出数量
     */
    private Integer outNumber = 0;

    /**
     * 退药数量
     */
    private Integer retreatNumber = 0;

    /**
     * 报损数量
     */
    private Integer loseNumber = 0;

    /**
     * 实际数量
     */
    private Integer actualNumber = 0;

    /**
     * 最小包装单位
     */
    private String minPackageUnit;

    /**
     * 取药日期
     */
    private Date outTime;

    /**
     * 经办人
     */
    private String operator;

    /**
     * 领用人
     */
    private String receiveName;

    /**
     * 取药类型：1 普通取药，2 手术取药
     */
    private String outType;

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
     * 药品名字拼音       
     */                   
    private String pinYin;
    
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

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode == null ? null : medicineCode.trim();
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName == null ? null : medicineName.trim();
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm == null ? null : firm.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Integer getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(Integer outNumber) {
        this.outNumber = outNumber;
    }

    public Integer getRetreatNumber() {
        return retreatNumber;
    }

    public void setRetreatNumber(Integer retreatNumber) {
        this.retreatNumber = retreatNumber;
    }

    public Integer getLoseNumber() {
        return loseNumber;
    }

    public void setLoseNumber(Integer loseNumber) {
        this.loseNumber = loseNumber;
    }

    public Integer getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(Integer actualNumber) {
        this.actualNumber = actualNumber;
    }

    public String getMinPackageUnit() {
        return minPackageUnit;
    }

    public void setMinPackageUnit(String minPackageUnit) {
        this.minPackageUnit = minPackageUnit == null ? null : minPackageUnit.trim();
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName == null ? null : receiveName.trim();
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType == null ? null : outType.trim();
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

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }

	public String getPinYin()
	{
		return pinYin;
	}

	public void setPinYin(String pinYin)
	{
		this.pinYin = pinYin;
	}

	public Integer getEnable()
	{
		return enable;
	}

	public void setEnable(Integer enable)
	{
		this.enable = enable;
	}
    
}