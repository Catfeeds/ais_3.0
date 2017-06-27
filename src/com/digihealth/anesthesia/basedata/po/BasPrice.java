/*
 * BasPrice.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="药品价格对象")
public class BasPrice {
    
    @ApiModelProperty(value="主键id")
    private String priceId;

    /**
     * 代码
     */
    @ApiModelProperty(value="代码")
    private String code;

    @ApiModelProperty(value="hisMedicineCode")
    private String hisMedicineCode;

    /**
     * 规格
     */
    @ApiModelProperty(value="规格")
    private String spec;

    /**
     * 厂家
     */
    @ApiModelProperty(value="厂家")
    private String firm;

    /**
     * 批次
     */
    @ApiModelProperty(value="批次")
    private String batch;

    /**
     * 最小计价 (包装)单位
     */
    @ApiModelProperty(value="最小计价 (包装)单位")
    private String minPackageUnit;

    /**
     * 最小计价单位对应价格
     */
    @ApiModelProperty(value="最小计价单位对应价格")
    private Float priceMinPackage;

    /**
     * 是否可用;1-是，0-无
     */
    @ApiModelProperty(value="是否可用;1-是，0-无")
    private Integer enable;

    /**
     * 药房代码
     */
    @ApiModelProperty(value="药房代码")
    private String pharmaciesCode;

    /**
     * 药房名称
     */
    @ApiModelProperty(value="药房名称")
    private String pharmaciesName;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId == null ? null : priceId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getHisMedicineCode() {
        return hisMedicineCode;
    }

    public void setHisMedicineCode(String hisMedicineCode) {
        this.hisMedicineCode = hisMedicineCode == null ? null : hisMedicineCode.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm == null ? null : firm.trim();
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public String getMinPackageUnit() {
        return minPackageUnit;
    }

    public void setMinPackageUnit(String minPackageUnit) {
        this.minPackageUnit = minPackageUnit == null ? null : minPackageUnit.trim();
    }

    public Float getPriceMinPackage() {
        return priceMinPackage;
    }

    public void setPriceMinPackage(Float priceMinPackage) {
        this.priceMinPackage = priceMinPackage;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getPharmaciesCode() {
        return pharmaciesCode;
    }

    public void setPharmaciesCode(String pharmaciesCode) {
        this.pharmaciesCode = pharmaciesCode == null ? null : pharmaciesCode.trim();
    }

    public String getPharmaciesName() {
        return pharmaciesName;
    }

    public void setPharmaciesName(String pharmaciesName) {
        this.pharmaciesName = pharmaciesName == null ? null : pharmaciesName.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}