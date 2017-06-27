/*
 * BasInventoryMonth.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="库存月度表对象")
public class BasInventoryMonth {
    
    @ApiModelProperty(value="主键id")
    private String invtMonId;

    @ApiModelProperty(value="收费项目id")
    private String chargeItemId;

    @ApiModelProperty(value="规格")
    private String spec;

    @ApiModelProperty(value="厂商")
    private String firm;

    /**
     * 批次
     */
    @ApiModelProperty(value="批次")
    private String batch;

    @ApiModelProperty(value="月库存")
    private String inventoryMonth;

    @ApiModelProperty(value="库存费用")
    private Float inventoryMonthAmount;

    @ApiModelProperty(value="类型")
    private String type;

    @ApiModelProperty(value="基线id")
    private String beid;

    public String getInvtMonId() {
        return invtMonId;
    }

    public void setInvtMonId(String invtMonId) {
        this.invtMonId = invtMonId == null ? null : invtMonId.trim();
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

    public String getInventoryMonth() {
        return inventoryMonth;
    }

    public void setInventoryMonth(String inventoryMonth) {
        this.inventoryMonth = inventoryMonth == null ? null : inventoryMonth.trim();
    }

    public Float getInventoryMonthAmount() {
        return inventoryMonthAmount;
    }

    public void setInventoryMonthAmount(Float inventoryMonthAmount) {
        this.inventoryMonthAmount = inventoryMonthAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}