/*
 * BasRegionBed.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="恢复室床位信息")
public class BasRegionBed {
    /**
     * id
     */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 房间Id
     */
    @ApiModelProperty(value="房间Id")
    private String roomId;

    /**
     * 类型，默认为空
     */
    @ApiModelProperty(value="类型，默认为空")
    private String type;

    /**
     * 等级，默认为空
     */
    @ApiModelProperty(value="等级，默认为空")
    private String level;

    /**
     * 术间分类，默认为空
     */
    @ApiModelProperty(value="术间分类，默认为空")
    private String operClass;

    /**
     * 专科ID，默认为空
     */
    @ApiModelProperty(value="专科ID，默认为空")
    private String deptId;

    /**
     * 专科名称，默认为空
     */
    @ApiModelProperty(value="专科名称，默认为空")
    private String deptName;

    /**
     * 手术Id，扩展使用
     */
    @ApiModelProperty(value="手术Id，扩展使用")
    private String regOptId;

    /**
     * 对应采集程序IP
     */
    @ApiModelProperty(value="对应采集程序IP")
    private String ipAddr;

    /**
     * 采集程序端口
     */
    @ApiModelProperty(value="采集程序端口")
    private Integer port;

    /**
     * 有效标志：0，空床、1，已分配、-1，不可用
     */
    @ApiModelProperty(value="有效标志：0，空床、1，已分配、-1，不可用")
    private Integer status;

    /**
     * 采样间隔1
     */
    @ApiModelProperty(value="采样间隔1")
    private Integer sampFreq1;

    /**
     * 采样间隔2
     */
    @ApiModelProperty(value="采样间隔2")
    private Integer sampFreq2;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getOperClass() {
        return operClass;
    }

    public void setOperClass(String operClass) {
        this.operClass = operClass == null ? null : operClass.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getSampFreq1() {
        return sampFreq1;
    }

    public void setSampFreq1(Integer sampFreq1) {
        this.sampFreq1 = sampFreq1;
    }

    public Integer getSampFreq2() {
        return sampFreq2;
    }

    public void setSampFreq2(Integer sampFreq2) {
        this.sampFreq2 = sampFreq2;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}