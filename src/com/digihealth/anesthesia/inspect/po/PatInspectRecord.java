/*
 * PatInspectRecord.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2016-07-22 Created
 */
package com.digihealth.anesthesia.inspect.po;

import java.util.Date;

public class PatInspectRecord {
    private String id;

    /**
     * HIS系统检查id
     */
    private String inspectId;
    /**
     * 医嘱Id
     */
    private String docId;

    /**
     * 患者Id
     */
    private String patId;

    /**
     * 申请Id
     */
    private String no;

    /**
     * 申请日期
     */
    private Date date;

    /**
     * 申请科室
     */
    private String dep;

    /**
     * 样本
     */
    private String samp;

    /**
     * 大类
     */
    private String type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 说明
     */
    private String instruction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId == null ? null : patId.trim();
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
}