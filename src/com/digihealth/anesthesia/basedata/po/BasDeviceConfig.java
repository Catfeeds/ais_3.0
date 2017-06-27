/*
 * BasDeviceConfig.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="床旁设备对象")
public class BasDeviceConfig {
    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
     * 手术室ID
     */
    @ApiModelProperty(value="手术室ID")
    private String roomId;

    /**
     * 设备id
     */
    @ApiModelProperty(value="设备id")
    private String deviceId;

    /**
     * 床号id
     */
    @ApiModelProperty(value="床号id")
    private String bedId;

    /**
     * 设备类型：1.手术室终端；2：复苏室终端；3：心电监护仪、4：呼吸机、5：麻醉机
     */
    @ApiModelProperty(value="设备类型：1.手术室终端；2：复苏室终端；3：心电监护仪、4：呼吸机、5：麻醉机")
    private Integer deviceType;

    /**
     * 设备型号
     */
    @ApiModelProperty(value="设备型号")
    private String deviceModel;

    /**
     * 接口类型（1：TCP；2：串口；3：UDP）
     */
    @ApiModelProperty(value="接口类型（1：TCP；2：串口；3：UDP）")
    private Integer interfaceType;

    /**
     * ip地址
     */
    @ApiModelProperty(value="ip地址")
    private String ipAddress;

    /**
     * 网口
     */
    @ApiModelProperty(value="网口")
    private Integer netPort;

    /**
     * 串口设备接到电脑上的端口,COM1~COM10
     */
    @ApiModelProperty(value="串口设备接到电脑上的端口,COM1~COM10")
    private String serialPort;

    /**
     * 波特率
     */
    @ApiModelProperty(value="波特率")
    private Integer baudRate;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

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

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel == null ? null : deviceModel.trim();
    }

    public Integer getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Integer interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public Integer getNetPort() {
        return netPort;
    }

    public void setNetPort(Integer netPort) {
        this.netPort = netPort;
    }

    public String getSerialPort() {
        return serialPort;
    }

    public void setSerialPort(String serialPort) {
        this.serialPort = serialPort == null ? null : serialPort.trim();
    }

    public Integer getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(Integer baudRate) {
        this.baudRate = baudRate;
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