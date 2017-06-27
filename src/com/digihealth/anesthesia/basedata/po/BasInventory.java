/*
 * BasInventory.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="库存表对象")
public class BasInventory {
    
    @ApiModelProperty(value="主键id")
    private String invtId;

    @ApiModelProperty(value="收费项目id")
    private String chargeItemId;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 简名
     */
    @ApiModelProperty(value="简名")
    private String briefName;

    /**
     * 拼音
     */
    @ApiModelProperty(value="拼音")
    private String pinYin;

    /**
     * 规格
     */
    @ApiModelProperty(value="规格")
    private String spec;

    @ApiModelProperty(value="厂商")
    private String firm;

    /**
     * 批次
     */
    @ApiModelProperty(value="批次")
    private String batch;

    /**
     * 类型
     */
    @ApiModelProperty(value="类型")
    private String type;

    /**
     * 最小包装单位
     */
    @ApiModelProperty(value="最小包装单位")
    private String minPackageUnit;

    /**
     * 最小包装价格
     */
    @ApiModelProperty(value="最小包装价格")
    private Float priceMinPackage;

    /**
     * 生产日期
     */
    @ApiModelProperty(value="生产日期")
    private String productionDate;

    /**
     * 过期日期
     */
    @ApiModelProperty(value="过期日期")
    private String expiryDate;

    /**
     * 库存费用
     */
    @ApiModelProperty(value="库存费用")
    private Float inventoryAmount;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getInvtId() {
        return invtId;
    }

    public void setInvtId(String invtId) {
        this.invtId = invtId == null ? null : invtId.trim();
    }

    public String getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(String chargeItemId) {
        this.chargeItemId = chargeItemId == null ? null : chargeItemId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBriefName() {
        return briefName;
    }

    public void setBriefName(String briefName) {
        this.briefName = briefName == null ? null : briefName.trim();
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate == null ? null : productionDate.trim();
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate == null ? null : expiryDate.trim();
    }

    public Float getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(Float inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}