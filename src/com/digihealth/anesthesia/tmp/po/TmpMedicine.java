/*
 * TmpMedicine.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.tmp.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="用药模版表对象")
public class TmpMedicine {
    /**
     * 模板ID
     */
    @ApiModelProperty(value="模板ID")
    private String medTempId;

    @ApiModelProperty(value="创建时间")
    private String createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private String createUser;

    @ApiModelProperty(value="模板名字")
    private String medTempName;

    @ApiModelProperty(value="拼音")
    private String pinYin;
    
    @ApiModelProperty(value="创建用户名字")
    private String createName;

    /**
     * 模板级别：1，个人；2，科室
     */
    @ApiModelProperty(value="模板级别")
    private Integer type;

    /**
     * 模板描述
     */
    @ApiModelProperty(value="模板描述")
    private String remark;

    public String getMedTempId() {
        return medTempId;
    }

    public void setMedTempId(String medTempId) {
        this.medTempId = medTempId == null ? null : medTempId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getMedTempName() {
        return medTempName;
    }

    public void setMedTempName(String medTempName) {
        this.medTempName = medTempName == null ? null : medTempName.trim();
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}