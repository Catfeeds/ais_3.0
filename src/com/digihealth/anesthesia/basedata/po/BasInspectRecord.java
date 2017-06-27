/*
 * BasInspectRecord.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="检验检查结果对象")
public class BasInspectRecord {

    @ApiModelProperty(value="主键id")
    private String id;

    /**
     * HIS系统检查id
     */
    @ApiModelProperty(value="HIS系统检查id")
    private String inspectId;

    /**
     * 医嘱Id
     */
    @ApiModelProperty(value="医嘱Id")
    private String docId;

    /**
     * 手术患者Id
     */
    @ApiModelProperty(value="手术患者Id")
    private String regOptId;

    /**
     * 申请Id
     */
    @ApiModelProperty(value="申请Id")
    private String no;

    /**
     * 申请日期
     */
    @ApiModelProperty(value="申请日期")
    private Date date;

    /**
     * 申请科室
     */
    @ApiModelProperty(value="申请科室")
    private String dep;

    /**
     * 样本
     */
    @ApiModelProperty(value="样本")
    private String samp;

    /**
     * 大类
     */
    @ApiModelProperty(value="大类")
    private String type;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 说明
     */
    @ApiModelProperty(value="说明")
    private String instruction;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInspectId() {
        return inspectId;
    }

    public void setInspectId(String inspectId) {
        this.inspectId = inspectId == null ? null : inspectId.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep == null ? null : dep.trim();
    }

    public String getSamp() {
        return samp;
    }

    public void setSamp(String samp) {
        this.samp = samp == null ? null : samp.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction == null ? null : instruction.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}