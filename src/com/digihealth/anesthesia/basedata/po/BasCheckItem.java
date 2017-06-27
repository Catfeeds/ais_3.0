/*
 * BasCheckItem.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="检验项目对象")
public class BasCheckItem {
    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private String chkItemId;

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
     * 单位
     */
    @ApiModelProperty(value="单位")
    private String unit;

    /**
     * 有效标志;0-无效，1-有效
     */
    @ApiModelProperty(value="有效标志;0-无效，1-有效")
    private Integer enable;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getChkItemId() {
        return chkItemId;
    }

    public void setChkItemId(String chkItemId) {
        this.chkItemId = chkItemId == null ? null : chkItemId.trim();
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

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}