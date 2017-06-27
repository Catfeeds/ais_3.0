/*
 * PatInspectItem.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2016-07-22 Created
 */
package com.digihealth.anesthesia.inspect.po;

public class PatInspectItem {
    private String id;

    /**
     * 检验检测记录Id
     */
    private String recId;

    /**
     * 编号
     */
    private Integer no;

    /**
     * 检验名称
     */
    private String name;

    /**
     * 值
     */
    private String val;

    /**
     * 参考值
     */
    private String refVal;

    /**
     * 单位
     */
    private String unit;

    /**
     * 培养结果
     */
    private String result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId == null ? null : recId.trim();
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }

    public String getRefVal() {
        return refVal;
    }

    public void setRefVal(String refVal) {
        this.refVal = refVal == null ? null : refVal.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}