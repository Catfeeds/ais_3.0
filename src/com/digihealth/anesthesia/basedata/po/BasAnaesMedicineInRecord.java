/*
 * BasAnaesMedicineInRecord.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-16 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

public class BasAnaesMedicineInRecord {
    /**
     * id
     */
    private Integer id;

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
     * 入库数量
     */
    private Integer number;

    /**
     * 最小包装单位
     */
    private String minPackageUnit;

    /**
     * 生产日期
     */
    private Date productionTime;

    /**
     * 有效日期
     */
    private Date effectiveTime;

    /**
     * 价格
     */
    private Float price;

    /**
     * 发票号
     */
    private String invoiceNumber;

    /**
     * 经办人
     */
    private String operator;

    /**
     * 入库时间
     */
    private Date operateTime;

    /**
     * 核对人
     */
    private String checkName;

    /**
     * 核对时间
     */
    private Date checkTime;

    /**
     * 入库状态， 0 没有核对 ， 1 核对完成
     */
    private Integer status;
    
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMinPackageUnit() {
        return minPackageUnit;
    }

    public void setMinPackageUnit(String minPackageUnit) {
        this.minPackageUnit = minPackageUnit == null ? null : minPackageUnit.trim();
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName == null ? null : checkName.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPinYin()
	{
		return pinYin;
	}

	public void setPinYin(String pinYin)
	{
		this.pinYin = pinYin;
	}

	public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}