/*
 * DocInsuredItem.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "参保患者特殊用药、卫材条目对象")
public class DocInsuredItem {
    /**
     * 主键Id
     */
    @ApiModelProperty(value = "主键Id")
     private String id;

    /**
     * 参保单Id
     */
    @ApiModelProperty(value = "参保单Id")
     private String insuredId;

    /**
     * 患者ID
     */
    @ApiModelProperty(value = "患者ID")
     private String regOptId;

    /**
     * 用药或耗材类型。1:自费用药;2:限字号用药;3:诊疗项目体内置放材料;4:贵重药品卫材
     */
    @ApiModelProperty(value = "用药或耗材类型。1:自费用药;2:限字号用药;3:诊疗项目体内置放材料;4:贵重药品卫材")
     private Integer type;

    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
     private Date time;

    /**
     * 药品或者耗材code
     */
    @ApiModelProperty(value = "药品或者耗材code")
     private String code;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
     private String name;

    /**
     * 规格
     */
    @ApiModelProperty(value = "规格")
     private String spec;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
     private Float price;

    /**
     * 用药依据
     */
    @ApiModelProperty(value = "用药依据")
     private String reason;

    /**
     * 1:药品;2:耗材
     */
    @ApiModelProperty(value = "1:药品;2:耗材")
     private Integer kind;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(String insuredId) {
        this.insuredId = insuredId == null ? null : insuredId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }
}