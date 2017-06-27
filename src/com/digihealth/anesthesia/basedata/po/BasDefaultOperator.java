/*
 * BasDefaultOperator.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="手术室人员配置对象")
public class BasDefaultOperator {
    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
     * 手术室id
     */
    @ApiModelProperty(value="手术室id")
    private String operRoomId;

    /**
     * 手术室名称
     */
    @ApiModelProperty(value="手术室名称")
    private String operRoomName;

    /**
     * 器械护士
     */
    @ApiModelProperty(value="器械护士")
    private String instrnurseId1;

    /**
     * 巡回护士
     */
    @ApiModelProperty(value="巡回护士")
    private String circunurseId1;

    /**
     * 麻醉医生
     */
    @ApiModelProperty(value="麻醉医生")
    private String anesthetistId;

    /**
     * 灌注医生
     */
    @ApiModelProperty(value="灌注医生")
    private String perfusiondoctorId;

    /**
     * 器械护士2
     */
    @ApiModelProperty(value="器械护士2")
    private String instrnurseId2;

    /**
     * 巡回护士2
     */
    @ApiModelProperty(value="巡回护士2")
    private String circunurseId2;

    /**
     * 卫生护士
     */
    @ApiModelProperty(value="卫生护士")
    private String healthNurse;

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

    public String getOperRoomId() {
        return operRoomId;
    }

    public void setOperRoomId(String operRoomId) {
        this.operRoomId = operRoomId == null ? null : operRoomId.trim();
    }

    public String getOperRoomName() {
        return operRoomName;
    }

    public void setOperRoomName(String operRoomName) {
        this.operRoomName = operRoomName == null ? null : operRoomName.trim();
    }

    public String getInstrnurseId1() {
        return instrnurseId1;
    }

    public void setInstrnurseId1(String instrnurseId1) {
        this.instrnurseId1 = instrnurseId1 == null ? null : instrnurseId1.trim();
    }

    public String getCircunurseId1() {
        return circunurseId1;
    }

    public void setCircunurseId1(String circunurseId1) {
        this.circunurseId1 = circunurseId1 == null ? null : circunurseId1.trim();
    }

    public String getAnesthetistId() {
        return anesthetistId;
    }

    public void setAnesthetistId(String anesthetistId) {
        this.anesthetistId = anesthetistId == null ? null : anesthetistId.trim();
    }

    public String getPerfusiondoctorId() {
        return perfusiondoctorId;
    }

    public void setPerfusiondoctorId(String perfusiondoctorId) {
        this.perfusiondoctorId = perfusiondoctorId == null ? null : perfusiondoctorId.trim();
    }

    public String getInstrnurseId2() {
        return instrnurseId2;
    }

    public void setInstrnurseId2(String instrnurseId2) {
        this.instrnurseId2 = instrnurseId2 == null ? null : instrnurseId2.trim();
    }

    public String getCircunurseId2() {
        return circunurseId2;
    }

    public void setCircunurseId2(String circunurseId2) {
        this.circunurseId2 = circunurseId2 == null ? null : circunurseId2.trim();
    }

    public String getHealthNurse() {
        return healthNurse;
    }

    public void setHealthNurse(String healthNurse) {
        this.healthNurse = healthNurse == null ? null : healthNurse.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}