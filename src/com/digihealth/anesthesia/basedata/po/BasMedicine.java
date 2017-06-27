/*
 * BasMedicine.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="药品对象")
public class BasMedicine {
    
    @ApiModelProperty(value="主键id")
    private String medicineId;

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

    @ApiModelProperty(value="来源")
    private String source;

    @ApiModelProperty(value="拼音")
    private String pinYin;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 规格
     */
    @ApiModelProperty(value="规格")
    private String spec;

    @ApiModelProperty(value="药品历史code")
    private String hisMedicineCode;

    /**
     * 简称
     */
    @ApiModelProperty(value="简称")
    private String briefName;

    /**
     * 剂量单位
     */
    @ApiModelProperty(value="剂量单位")
    private String dosageUnit;

    /**
     * 药品分类
     */
    @ApiModelProperty(value="药品分类")
    private String roughType;

    /**
     * 每最小包装单位中所含有的总剂量
     */
    @ApiModelProperty(value="每最小包装单位中所含有的总剂量")
    private Float packageDosageAmount;

    /**
     * 是否可用;1-是，0-否
     */
    @ApiModelProperty(value="是否可用;1-是，0-否")
    private Integer enable;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId == null ? null : medicineId.trim();
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getHisMedicineCode() {
        return hisMedicineCode;
    }

    public void setHisMedicineCode(String hisMedicineCode) {
        this.hisMedicineCode = hisMedicineCode == null ? null : hisMedicineCode.trim();
    }

    public String getBriefName() {
        return briefName;
    }

    public void setBriefName(String briefName) {
        this.briefName = briefName == null ? null : briefName.trim();
    }

    public String getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        this.dosageUnit = dosageUnit == null ? null : dosageUnit.trim();
    }

    public String getRoughType() {
        return roughType;
    }

    public void setRoughType(String roughType) {
        this.roughType = roughType == null ? null : roughType.trim();
    }

    public Float getPackageDosageAmount() {
        return packageDosageAmount;
    }

    public void setPackageDosageAmount(Float packageDosageAmount) {
        this.packageDosageAmount = packageDosageAmount;
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