/*
 * BasInstrsuit.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="手术包对象")
public class BasInstrsuit {
    
    @ApiModelProperty(value="主键id")
    private String instrsuitId;

    /**
     * 代码
     */
    @ApiModelProperty(value="代码")
    private String code;

    /**
     * 手术包名称
     */
    @ApiModelProperty(value="手术包名称")
    private String name;

    @ApiModelProperty(value="拼音码")
    private String pinYin;

    /**
     * 有效标志
     */
    @ApiModelProperty(value="有效标志")
    private Integer enable;

    /**
     * 价格
     */
    @ApiModelProperty(value="价格")
    private Float price;

    /**
     * 总数
     */
    @ApiModelProperty(value="总数")
    private Integer totalAmount;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getInstrsuitId() {
        return instrsuitId;
    }

    public void setInstrsuitId(String instrsuitId) {
        this.instrsuitId = instrsuitId == null ? null : instrsuitId.trim();
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}