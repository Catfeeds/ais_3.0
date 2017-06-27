/*
 * BasPacuDeviceConfig.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "pacu床旁设备配置表对象")
public class BasPacuDeviceConfig {
    /**
     * 设备id
     */
    @ApiModelProperty(value="设备id")
    private String deviceId;

    /**
     * 床id
     */
    @ApiModelProperty(value="床id")
    private String bedId;

    /**
     * pacu室ID
     */
    @ApiModelProperty(value="pacu室ID")
    private String roomId;

    /**
     * ip地址
     */
    @ApiModelProperty(value="ip地址")
    private String ipAddress;

    /**
     * 串口设备接到电脑上的端口,COM1~COM10
     */
    @ApiModelProperty(value="串口设备接到电脑上的端口,COM1~COM10")
    private String serialPort;

    /**
     * 是否有效 1有效 0 无效
     */
    @ApiModelProperty(value="是否有效 1有效 0 无效")
    private Integer enable;

    /**
     * 1-设备检查成功；0-设备正在检查中；-1-设备检查失败
     */
    @ApiModelProperty(value="1-设备检查成功；0-设备正在检查中；-1-设备检查失败")
    private Integer status;

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

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId == null ? null : bedId.trim();
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getSerialPort() {
        return serialPort;
    }

    public void setSerialPort(String serialPort) {
        this.serialPort = serialPort == null ? null : serialPort.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}