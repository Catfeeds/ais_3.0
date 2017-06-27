/*
 * TmpAnaesDoctemp.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.tmp.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="文书模版表对象")
public class TmpAnaesDoctemp {
    /**
     * 模板ID
     */
    @ApiModelProperty(value="模板ID")
    private String id;

    @ApiModelProperty(value="创建时间")
    private String createTime;

    @ApiModelProperty(value="创建用户")
    private String createUser;

    @ApiModelProperty(value="模板名字")
    private String medTempName;

    @ApiModelProperty(value="拼音码")
    private String pinYin;

    @ApiModelProperty(value="创建用户名")
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

    /**
     * 文书类型.2:麻醉记录单(一);3:麻醉术前访视与评估记录单;4:麻醉记录单(二);5:手术安全核查表
     */
    @ApiModelProperty(value="文书类型")
    private Integer docType;

    /**
     * 模板Json数据，按前端展示要求保存为JSON
     */
    @ApiModelProperty(value="模板Json数据")
    private String tempJson;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public String getTempJson() {
        return tempJson;
    }

    public void setTempJson(String tempJson) {
        this.tempJson = tempJson == null ? null : tempJson.trim();
    }
}