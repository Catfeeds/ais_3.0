/*
 * BasOperationPeople.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="手术名称对象")
public class BasOperationPeople {
    
    @ApiModelProperty(value="主键id")
    private String operatorId;

    /**
     * 代码
     */
    @ApiModelProperty(value="代码")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 有效标志;0-无效，1-有效
     */
    @ApiModelProperty(value="有效标志;0-无效，1-有效")
    private Integer enable;

    /**
     * 科室
     */
    @ApiModelProperty(value="科室")
    private Integer region;

    /**
     * 拼音码
     */
    @ApiModelProperty(value="拼音码")
    private String pinYin;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
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

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}