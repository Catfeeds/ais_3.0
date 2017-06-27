/*
 * BasChargePackages.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="收费项目包对象")
public class BasChargePackages {
    /**
     * 手术包id
     */
    @ApiModelProperty(value="手术包id")
    private String chargePkgId;

    /**
     * 手术包code
     */
    @ApiModelProperty(value="手术包code")
    private String chargePackagesCode;

    /**
     * 手续包名称
     */
    @ApiModelProperty(value="手续包名称")
    private String chargePackagesName;

    /**
     * 拼音
     */
    @ApiModelProperty(value="拼音")
    private String pinYin;

    /**
     * 类型
     */
    @ApiModelProperty(value="类型")
    private String type;

    /**
     * 是否可用 1可用，0不可用
     */
    @ApiModelProperty(value="是否可用 1可用，0不可用")
    private Integer enable;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getChargePkgId() {
        return chargePkgId;
    }

    public void setChargePkgId(String chargePkgId) {
        this.chargePkgId = chargePkgId == null ? null : chargePkgId.trim();
    }

    public String getChargePackagesCode() {
        return chargePackagesCode;
    }

    public void setChargePackagesCode(String chargePackagesCode) {
        this.chargePackagesCode = chargePackagesCode == null ? null : chargePackagesCode.trim();
    }

    public String getChargePackagesName() {
        return chargePackagesName;
    }

    public void setChargePackagesName(String chargePackagesName) {
        this.chargePackagesName = chargePackagesName == null ? null : chargePackagesName.trim();
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}