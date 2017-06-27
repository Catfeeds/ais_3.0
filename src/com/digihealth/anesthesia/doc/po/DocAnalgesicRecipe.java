/*
 * DocAnalgesicRecipe.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "镇痛配方对象")
public class DocAnalgesicRecipe {
    /**
     * 记录单主键
     */
	@ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 患者Id
     */
	@ApiModelProperty(value = "患者Id")
    private String regOptId;

    /**
     * 镇痛随访记录Id
     */
	@ApiModelProperty(value = "镇痛随访记录Id")
    private String analgesicId;

	@ApiModelProperty(value = "药品Id")
    private String medId;

    /**
     * 药品
     */
	@ApiModelProperty(value = "药品名称")
    private String medName;

    /**
     * 剂量
     */
	@ApiModelProperty(value = "剂量")
    private Float dosage;

    /**
     * 剂量单位
     */
	@ApiModelProperty(value = "剂量单位")
    private String units;

	@ApiModelProperty(value = "类型")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getAnalgesicId() {
        return analgesicId;
    }

    public void setAnalgesicId(String analgesicId) {
        this.analgesicId = analgesicId == null ? null : analgesicId.trim();
    }

    public String getMedId() {
        return medId;
    }

    public void setMedId(String medId) {
        this.medId = medId == null ? null : medId.trim();
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName == null ? null : medName.trim();
    }

    public Float getDosage() {
        return dosage;
    }

    public void setDosage(Float dosage) {
        this.dosage = dosage;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}