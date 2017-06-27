/*
 * BasPacuBedEventConfig.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "pacu床旁设备监测项配置表对象")
public class BasPacuBedEventConfig {
    /**
     * 设备id
     */
    @ApiModelProperty(value="设备id")
    private String deviceId;

    /**
     * 采集项id
     */
    @ApiModelProperty(value="采集项id")
    private String eventId;

    /**
     * 床id
     */
    @ApiModelProperty(value="床id")
    private String bedId;

    /**
     * M:必须勾选，O:勾选，N:没有勾选
     */
    @ApiModelProperty(value="M:必须勾选，O:勾选，N:没有勾选")
    private String optDisplay;

    /**
     * M:必须采集，O:勾选,N:没有勾选
     */
    @ApiModelProperty(value="M:必须采集，O:勾选,N:没有勾选")
    private String optCollect;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId == null ? null : bedId.trim();
    }

    public String getOptDisplay() {
        return optDisplay;
    }

    public void setOptDisplay(String optDisplay) {
        this.optDisplay = optDisplay == null ? null : optDisplay.trim();
    }

    public String getOptCollect() {
        return optCollect;
    }

    public void setOptCollect(String optCollect) {
        this.optCollect = optCollect == null ? null : optCollect.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}