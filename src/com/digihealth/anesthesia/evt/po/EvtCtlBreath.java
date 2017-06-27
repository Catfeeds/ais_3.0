/*
 * EvtCtlBreath.java
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

@ApiModel(value = "呼吸事件对象")
public class EvtCtlBreath {
    /**
     * 呼吸事件主键
     */
	@ApiModelProperty(value = "呼吸事件主键")
    private String ctlBreId;

    /**
     * 开始时间
     */
	@ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
	@ApiModelProperty(value = "结束时间")
    private Date endTime;

    /**
     * 文书id
     */
	@ApiModelProperty(value = "文书ID")
    private String docId;

    /**
     * 1自主呼吸 2辅助胡须 3控制呼吸
     */
	@ApiModelProperty(value = "1自主呼吸 2辅助胡须 3控制呼吸")
    private Integer type;

    /**
     * 当前是否生效;1-生效，0-无效
     */
	@ApiModelProperty(value = "当前是否生效;1-生效，0-无效")
    private Integer currentState;

    public String getCtlBreId() {
        return ctlBreId;
    }

    public void setCtlBreId(String ctlBreId) {
        this.ctlBreId = ctlBreId == null ? null : ctlBreId.trim();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }
}