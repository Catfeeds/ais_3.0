/*
 * BasDiagnosedef.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="诊断名称对象")
public class BasDiagnosedef {
    /**
     * 诊断id
     */
    @ApiModelProperty(value="诊断id")
    private String diagDefId;

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
     * 拼音
     */
    @ApiModelProperty(value="拼音")
    private String pinYin;

    /**
     * 是否有效;0-无效，1-有效
     */
    @ApiModelProperty(value="是否有效;0-无效，1-有效")
    private Integer enable;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getDiagDefId() {
        return diagDefId;
    }

    public void setDiagDefId(String diagDefId) {
        this.diagDefId = diagDefId == null ? null : diagDefId.trim();
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

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
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