/*
 * BasDeviceMonitorConfig.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="设备与监测项配置对象")
public class BasDeviceMonitorConfig {
    /**
     * 设备id
     */
    @ApiModelProperty(value="设备id")
    private String deviceId;

    /**
     * eventId
     */
    @ApiModelProperty(value="监测项Id")
    private String eventId;

    /**
     * M:必须勾选，O:勾选，null代表没有勾选
     */
    @ApiModelProperty(value="M:必须勾选，O:勾选，null代表没有勾选")
    private String optional;

    /**
     * 房间id
     */
    @ApiModelProperty(value="房间id")
    private String roomId;

    /**
     * 采集服务需要的参数id
     */
    @ApiModelProperty(value="采集服务需要的参数id")
    private String paraId;

    /**
     * 采集服务需要的参数名称
     */
    @ApiModelProperty(value="采集服务需要的参数名称")
    private String paraName;

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

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional == null ? null : optional.trim();
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    public String getParaId() {
        return paraId;
    }

    public void setParaId(String paraId) {
        this.paraId = paraId == null ? null : paraId.trim();
    }

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName == null ? null : paraName.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}