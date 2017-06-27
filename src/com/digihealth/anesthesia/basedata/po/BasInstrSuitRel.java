/*
 * BasInstrSuitRel.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="手术包所对应的器械")
public class BasInstrSuitRel {
    
    @ApiModelProperty(value="主键id")
    private String instrSuitRelId;

    /**
     * 总数
     */
    @ApiModelProperty(value="总数")
    private Integer amount;

    /**
     * 器械耗材代码
     */
    @ApiModelProperty(value="器械耗材代码")
    private String instrumentId;

    /**
     * 手术包代码
     */
    @ApiModelProperty(value="手术包代码")
    private String instrsuitId;

    /**
     * 类型
     */
    @ApiModelProperty(value="类型")
    private String type;

    public String getInstrSuitRelId() {
        return instrSuitRelId;
    }

    public void setInstrSuitRelId(String instrSuitRelId) {
        this.instrSuitRelId = instrSuitRelId == null ? null : instrSuitRelId.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId == null ? null : instrumentId.trim();
    }

    public String getInstrsuitId() {
        return instrsuitId;
    }

    public void setInstrsuitId(String instrsuitId) {
        this.instrsuitId = instrsuitId == null ? null : instrsuitId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}