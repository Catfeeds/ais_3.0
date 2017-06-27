/*
 * BasChargeItemPackagesRel.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="收费项目关联表对象")
public class BasChargeItemPackagesRel {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private String chgItmPkgId;

    /**
     * 收费项目金额
     */
    @ApiModelProperty(value="收费项目金额")
    private Float chgItemAmount;

    /**
     * 收费项目id
     */
    @ApiModelProperty(value="收费项目id")
    private String chargeItemId;

    /**
     * 收费项目包id
     */
    @ApiModelProperty(value="收费项目包id")
    private String chargePkgId;

    public String getChgItmPkgId() {
        return chgItmPkgId;
    }

    public void setChgItmPkgId(String chgItmPkgId) {
        this.chgItmPkgId = chgItmPkgId == null ? null : chgItmPkgId.trim();
    }

    public Float getChgItemAmount() {
        return chgItemAmount;
    }

    public void setChgItemAmount(Float chgItemAmount) {
        this.chgItemAmount = chgItemAmount;
    }

    public String getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(String chargeItemId) {
        this.chargeItemId = chargeItemId == null ? null : chargeItemId.trim();
    }

    public String getChargePkgId() {
        return chargePkgId;
    }

    public void setChargePkgId(String chargePkgId) {
        this.chargePkgId = chargePkgId == null ? null : chargePkgId.trim();
    }
}