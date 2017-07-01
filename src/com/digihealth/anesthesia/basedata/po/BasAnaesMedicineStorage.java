/*
 * BasAnaesMedicineStorage.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-06-13 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

public class BasAnaesMedicineStorage {
    private Integer id;

    /**
     * 药品code
     */
    private String medicineCode;

    /**
     * 药品名字
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
     * 数量
     */
    private Integer number = 0;

    /**
     * 最小包装单位
     */
    private String minPackageUnit;
    
    /**
     * 生产日期
     */
    private Date productionTime;
    
    /**
     * 有效期
     */
    private Date effectiveTime;

    /**                                        
     * 药品名字拼音       
     */                   
    private String pinYin;
    
    /**
     * 局点编号
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

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }

	public Date getEffectiveTime()
	{
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime)
	{
		this.effectiveTime = effectiveTime;
	}

	public String getPinYin()
	{
		return pinYin;
	}

	public void setPinYin(String pinYin)
	{
		this.pinYin = pinYin;
	}

	public Date getProductionTime()
	{
		return productionTime;
	}

	public void setProductionTime(Date productionTime)
	{
		this.productionTime = productionTime;
	}
    
}