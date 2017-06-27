/*
 * BasMonitorPupil.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.operProceed.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="瞳孔监测数据表")
public class BasMonitorPupil {
    
    @ApiModelProperty(value="主键id")
    private String id;

    /**
     * reg_opt_id,患者id
     */
    @ApiModelProperty(value="患者id")
    private String regOptId;

    /**
     * 时间
     */
    @ApiModelProperty(value="时间")
    private Date time;

    /**
     * 左
     */
    @ApiModelProperty(value="左")
    private String left;

    /**
     * 右
     */
    @ApiModelProperty(value="右")
    private String right;

    /**
     * 对光反射
     */
    @ApiModelProperty(value="对光反射")
    private String lightReaction;

    /**
     * 是否正常值，0正常，-1过低，1过高
     */
    @ApiModelProperty(value="是否正常值")
    private Integer state;

    /**
     * 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
     */
    @ApiModelProperty(value="数据状态")
    private Integer amendFlag;

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

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left == null ? null : left.trim();
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right == null ? null : right.trim();
    }

    public String getLightReaction() {
        return lightReaction;
    }

    public void setLightReaction(String lightReaction) {
        this.lightReaction = lightReaction == null ? null : lightReaction.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAmendFlag() {
        return amendFlag;
    }

    public void setAmendFlag(Integer amendFlag) {
        this.amendFlag = amendFlag;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}