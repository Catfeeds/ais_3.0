/*
 * BasInOutInfo.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="出入库对象")
public class BasInOutInfo {
    
    @ApiModelProperty(value="主键id")
    private String ioId;

    /**
     * 业务流水号
     */
    @ApiModelProperty(value="业务流水号")
    private String businessSerialNumber;

    /**
     * 发票号
     */
    @ApiModelProperty(value="发票号")
    private String invoiceNumber;

    /**
     * 收费项目ID
     */
    @ApiModelProperty(value="收费项目ID")
    private String chargeItemId;

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
     * 经办人
     */
    @ApiModelProperty(value="经办人")
    private String operator;

    /**
     * 入库价
     */
    @ApiModelProperty(value="入库价")
    private Float priceStock;

    /**
     * 出/入库数量
     */
    @ApiModelProperty(value="出/入库数量")
    private Float inOutAmount;

    /**
     * 出/入库金额
     */
    @ApiModelProperty(value="出/入库金额")
    private Float inOutMoney;

    /**
     * 出/入库方式
     */
    @ApiModelProperty(value="出/入库方式")
    private String inOutWay;

    /**
     * 出/入库科室
     */
    @ApiModelProperty(value="出/入库科室")
    private String inOutDept;

    /**
     * 出/入库日期
     */
    @ApiModelProperty(value="出/入库日期")
    private String inOutDate;

    /**
     * 出库/入库
     */
    @ApiModelProperty(value="出库/入库")
    private String inOutType;

    @ApiModelProperty(value="库存")
    private Float inventoryAmount;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 最小包装单位
     */
    @ApiModelProperty(value="最小包装单位")
    private String minPackageUnit;

    /**
     * 药品/器械/耗材/手术包
     */
    @ApiModelProperty(value="药品/器械/耗材/手术包")
    private String materielType;

    /**
     * 领用人
     */
    @ApiModelProperty(value="领用人")
    private String nurse;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;
    
    @ApiModelProperty(value="生产日期")
    private String productionDate;//生产日期

    @ApiModelProperty(value="失效日期")
    private String expiryDate;//失效日期                                            
    
    @ApiModelProperty(value="出入库方式名称")
    private String inOutWayName;

    public String getProductionDate()
    {
        return productionDate;
    }

    public void setProductionDate(String productionDate)
    {
        this.productionDate = productionDate;
    }

    public String getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public String getInOutWayName()
    {
        return inOutWayName;
    }

    public void setInOutWayName(String inOutWayName)
    {
        this.inOutWayName = inOutWayName;
    }

    public String getIoId() {
        return ioId;
    }

    public void setIoId(String ioId) {
        this.ioId = ioId == null ? null : ioId.trim();
    }

    public String getBusinessSerialNumber() {
        return businessSerialNumber;
    }

    public void setBusinessSerialNumber(String businessSerialNumber) {
        this.businessSerialNumber = businessSerialNumber == null ? null : businessSerialNumber.trim();
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
    }

    public String getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(String chargeItemId) {
        this.chargeItemId = chargeItemId == null ? null : chargeItemId.trim();
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Float getPriceStock() {
        return priceStock;
    }

    public void setPriceStock(Float priceStock) {
        this.priceStock = priceStock;
    }

    public Float getInOutAmount() {
        return inOutAmount;
    }

    public void setInOutAmount(Float inOutAmount) {
        this.inOutAmount = inOutAmount;
    }

    public Float getInOutMoney() {
        return inOutMoney;
    }

    public void setInOutMoney(Float inOutMoney) {
        this.inOutMoney = inOutMoney;
    }

    public String getInOutWay() {
        return inOutWay;
    }

    public void setInOutWay(String inOutWay) {
        this.inOutWay = inOutWay == null ? null : inOutWay.trim();
    }

    public String getInOutDept() {
        return inOutDept;
    }

    public void setInOutDept(String inOutDept) {
        this.inOutDept = inOutDept == null ? null : inOutDept.trim();
    }

    public String getInOutDate() {
        return inOutDate;
    }

    public void setInOutDate(String inOutDate) {
        this.inOutDate = inOutDate == null ? null : inOutDate.trim();
    }

    public String getInOutType() {
        return inOutType;
    }

    public void setInOutType(String inOutType) {
        this.inOutType = inOutType == null ? null : inOutType.trim();
    }

    public Float getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(Float inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMinPackageUnit() {
        return minPackageUnit;
    }

    public void setMinPackageUnit(String minPackageUnit) {
        this.minPackageUnit = minPackageUnit == null ? null : minPackageUnit.trim();
    }

    public String getMaterielType() {
        return materielType;
    }

    public void setMaterielType(String materielType) {
        this.materielType = materielType == null ? null : materielType.trim();
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse == null ? null : nurse.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}