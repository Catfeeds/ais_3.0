/*
 * BasInstrument.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="器械对象")
public class BasInstrument {
    
    @ApiModelProperty(value="主键id")
    private String instrumentId;

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
     * 类型
     */
    @ApiModelProperty(value="类型")
    private String type;

    /**
     * 拼音码
     */
    @ApiModelProperty(value="拼音码")
    private String pinYin;

    /**
     * 是否有效
     */
    @ApiModelProperty(value="是否有效")
    private Integer enable;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;
    
    /**
     * 数量
     */
    @ApiModelProperty(value="数量")
    private Integer amount;
    
    /**
     * 手术包id
     */
    @ApiModelProperty(value="手术包id")
    private String instrSuitRelId;

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public String getInstrSuitRelId()
    {
        return instrSuitRelId;
    }

    public void setInstrSuitRelId(String instrSuitRelId)
    {
        this.instrSuitRelId = instrSuitRelId;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId == null ? null : instrumentId.trim();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}