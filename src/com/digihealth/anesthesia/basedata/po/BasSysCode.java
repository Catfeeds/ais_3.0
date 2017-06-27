/*
 * BasSysCode.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="系统码表对象")
public class BasSysCode {
    /**
     * 码表ID
     */
    @ApiModelProperty(value="码表ID")
    private String sysCodeId;

    /**
     * 组
     */
    @ApiModelProperty(value="组")
    private String groupId;

    /**
     * 组对应名称
     */
    @ApiModelProperty(value="组对应名称")
    private String groupName;

    /**
     * 码值
     */
    @ApiModelProperty(value="码值")
    private String codeValue;

    /**
     * 码值名称
     */
    @ApiModelProperty(value="码值名称")
    private String codeName;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer order;

    /**
     * 是否可用;1-可用，0-不可用
     */
    @ApiModelProperty(value="是否可用;1-可用，0-不可用")
    private Integer enable;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getSysCodeId() {
        return sysCodeId;
    }

    public void setSysCodeId(String sysCodeId) {
        this.sysCodeId = sysCodeId == null ? null : sysCodeId.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue == null ? null : codeValue.trim();
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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