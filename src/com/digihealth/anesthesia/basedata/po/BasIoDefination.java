/*
 * BasIoDefination.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="出入量对象")
public class BasIoDefination {
    /**
     * ID
     */
    @ApiModelProperty(value="主键id")
    private String ioDefId;

    /**
     * 代码
     */
    @ApiModelProperty(value="代码")
    private String code;

    /**
     * 类型
     */
    @ApiModelProperty(value="类型")
    private String type;

    /**
     * 子类型
     */
    @ApiModelProperty(value="子类型")
    private String subType;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 简称
     */
    @ApiModelProperty(value="简称")
    private String briefName;

    @ApiModelProperty(value="单位")
    private String unit;

    /**
     * 是否有效;1-有效，0-无效
     */
    @ApiModelProperty(value="是否有效;1-有效，0-无效")
    private Integer enable;

    @ApiModelProperty(value="规格")
    private String spec;

    /**
     * 拼音码
     */
    @ApiModelProperty(value="拼音码")
    private String pinYin;

    /**
     * 剂量单位
     */
    @ApiModelProperty(value="剂量单位")
    private String dosageUnit;

    /**
     * 每最小包装单位中所含有的总剂量
     */
    @ApiModelProperty(value="每最小包装单位中所含有的总剂量")
    private Float packageDosageAmount;

    @ApiModelProperty(value="血型")
    private String blood;

    /**
     * 是否为自体血 0否，1是
     */
    @ApiModelProperty(value="是否为自体血 0否，1是")
    private Integer autoBlood;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getIoDefId() {
        return ioDefId;
    }

    public void setIoDefId(String ioDefId) {
        this.ioDefId = ioDefId == null ? null : ioDefId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType == null ? null : subType.trim();
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
    }

    public String getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        this.dosageUnit = dosageUnit == null ? null : dosageUnit.trim();
    }

    public Float getPackageDosageAmount() {
        return packageDosageAmount;
    }

    public void setPackageDosageAmount(Float packageDosageAmount) {
        this.packageDosageAmount = packageDosageAmount;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood == null ? null : blood.trim();
    }

    public Integer getAutoBlood() {
        return autoBlood;
    }

    public void setAutoBlood(Integer autoBlood) {
        this.autoBlood = autoBlood;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}