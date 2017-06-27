/*
 * BasProperties.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="系统属性表")
public class BasProperties {
    /**
     * 编号
     */
    @ApiModelProperty(value="编号")
    private Integer id;

    /**
     * 属性名字
     */
    @ApiModelProperty(value="属性名字")
    private String propName;

    /**
     * 属性值
     */
    @ApiModelProperty(value="属性值")
    private String propValue;

    /**
     * 状态：0无效，1有效
     */
    @ApiModelProperty(value="状态：0无效，1有效")
    private Integer state;

    /**
     * 系统参数描述
     */
    @ApiModelProperty(value="系统参数描述")
    private String remark;

    /**
     * 局点id
     */
    @ApiModelProperty(value="局点id")
    private String beid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName == null ? null : propName.trim();
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue == null ? null : propValue.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}