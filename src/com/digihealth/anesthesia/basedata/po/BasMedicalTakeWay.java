/*
 * BasMedicalTakeWay.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="给药方式对象")
public class BasMedicalTakeWay {
    
    @ApiModelProperty(value="主键id")
    private String medTakeWayId;

    @ApiModelProperty(value="代码")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 是否持续性;1-是，0-否
     */
    @ApiModelProperty(value="是否持续性;1-是，0-否")
    private Integer durable;

    /**
     * 分类
     */
    @ApiModelProperty(value="分类")
    private String category;

    /**
     * 给药方式
     */
    @ApiModelProperty(value="给药方式")
    private String measureMode;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getMedTakeWayId() {
        return medTakeWayId;
    }

    public void setMedTakeWayId(String medTakeWayId) {
        this.medTakeWayId = medTakeWayId == null ? null : medTakeWayId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDurable() {
        return durable;
    }

    public void setDurable(Integer durable) {
        this.durable = durable;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getMeasureMode() {
        return measureMode;
    }

    public void setMeasureMode(String measureMode) {
        this.measureMode = measureMode == null ? null : measureMode.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}