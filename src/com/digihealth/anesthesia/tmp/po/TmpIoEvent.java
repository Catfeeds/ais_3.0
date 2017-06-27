/*
 * TmpIoEvent.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.tmp.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="入量模版对象")
public class TmpIoEvent {
    /**
     * 入量模版主键
     */
    @ApiModelProperty(value="出入量ID")
    private String ioeventId;

    /**
     * 模板ID
     */
    @ApiModelProperty(value="模板ID")
    private String medTempId;

    /**
     * 开始时间
     */
    @ApiModelProperty(value="开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value="结束时间")
    private Date endTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private String createUser;

    /**
     * 剂量数量
     */
    @ApiModelProperty(value="剂量数量")
    private Float dosageAmount;

    /**
     * 是否收费;1-是，0-否
     */
    @ApiModelProperty(value="是否收费")
    private Integer isCharged;

    /**
     * 入量基础表主键
     */
    @ApiModelProperty(value="入量基础表主键")
    private String ioDefId;

    /**
     * 通道
     */
    @ApiModelProperty(value="通道")
    private String passage;

    /**
     * 药品价格id
     */
    @ApiModelProperty(value="药品价格")
    private String priceId;
    
    @ApiModelProperty(value="名称")
    private String name;
    
    @ApiModelProperty(value="规格")
    private String spec;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSpec()
    {
        return spec;
    }

    public void setSpec(String spec)
    {
        this.spec = spec;
    }

    public String getIoeventId() {
        return ioeventId;
    }

    public void setIoeventId(String ioeventId) {
        this.ioeventId = ioeventId == null ? null : ioeventId.trim();
    }

    public String getMedTempId() {
        return medTempId;
    }

    public void setMedTempId(String medTempId) {
        this.medTempId = medTempId == null ? null : medTempId.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Float getDosageAmount() {
        return dosageAmount;
    }

    public void setDosageAmount(Float dosageAmount) {
        this.dosageAmount = dosageAmount;
    }

    public Integer getIsCharged() {
        return isCharged;
    }

    public void setIsCharged(Integer isCharged) {
        this.isCharged = isCharged;
    }

    public String getIoDefId() {
        return ioDefId;
    }

    public void setIoDefId(String ioDefId) {
        this.ioDefId = ioDefId == null ? null : ioDefId.trim();
    }

    public String getPassage() {
        return passage;
    }

    public void setPassage(String passage) {
        this.passage = passage == null ? null : passage.trim();
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId == null ? null : priceId.trim();
    }
}