/*
 * BasDeviceSpecification.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="设备规格对象")
public class BasDeviceSpecification {
    /**
     * 设备id
     */
    @ApiModelProperty(value="设备id")
    private String deviceId;

    /**
     * 设备厂商
     */
    @ApiModelProperty(value="设备厂商")
    private String deviceFactory;

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
     * 设备协议名称
     */
    @ApiModelProperty(value="设备协议名称")
    private String protocol;

    /**
     * 端口
     */
    @ApiModelProperty(value="端口")
    private Integer netPort;

    @ApiModelProperty(value="broadPort")
    private Integer broadPort;

    /**
     * startbit
     */
    @ApiModelProperty(value="startbit")
    private Integer startBit;

    /**
     * 串口停止位
     */
    @ApiModelProperty(value="串口停止位")
    private Integer stopBit;

    /**
     * 串口数据位
     */
    @ApiModelProperty(value="串口数据位")
    private Integer dataBit;

    /**
     * 串口奇偶校验
     */
    @ApiModelProperty(value="串口奇偶校验")
    private String parityBit;

    /**
     * 接口类型（1：TCP；2：串口；3：UDP）
     */
    @ApiModelProperty(value="接口类型（1：TCP；2：串口；3：UDP）")
    private Integer interfaceType;

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

    public String getDeviceFactory() {
        return deviceFactory;
    }

    public void setDeviceFactory(String deviceFactory) {
        this.deviceFactory = deviceFactory == null ? null : deviceFactory.trim();
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

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    public Integer getNetPort() {
        return netPort;
    }

    public void setNetPort(Integer netPort) {
        this.netPort = netPort;
    }

    public Integer getBroadPort() {
        return broadPort;
    }

    public void setBroadPort(Integer broadPort) {
        this.broadPort = broadPort;
    }

    public Integer getStartBit() {
        return startBit;
    }

    public void setStartBit(Integer startBit) {
        this.startBit = startBit;
    }

    public Integer getStopBit() {
        return stopBit;
    }

    public void setStopBit(Integer stopBit) {
        this.stopBit = stopBit;
    }

    public Integer getDataBit() {
        return dataBit;
    }

    public void setDataBit(Integer dataBit) {
        this.dataBit = dataBit;
    }

    public String getParityBit() {
        return parityBit;
    }

    public void setParityBit(String parityBit) {
        this.parityBit = parityBit == null ? null : parityBit.trim();
    }

    public Integer getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Integer interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}