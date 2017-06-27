/*
 * EvtRescueevent.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="抢救事件")
public class EvtRescueevent {
    /**
     * 抢救事件主键
     */
	@ApiModelProperty(value="抢救事件主键")
    private String rescueEventId;

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
     * 文书id
     */
	@ApiModelProperty(value="文书id")
    private String docId;

    /**
     * 模式 normal 普通 save抢救 
     */
	@ApiModelProperty(value="模式 normal 普通 save抢救 ")
    private String model;

    /**
     * 事件当前有效状态 0-无效，1-有效
     */
	@ApiModelProperty(value="事件当前有效状态 0-无效，1-有效")
    private Integer currentState;

    public String getRescueEventId() {
        return rescueEventId;
    }

    public void setRescueEventId(String rescueEventId) {
        this.rescueEventId = rescueEventId == null ? null : rescueEventId.trim();
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

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }
}