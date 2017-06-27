/*
 * EvtMedicalEventDetail.java
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

@ApiModel(value = "用药事件详情表对象")
public class EvtMedicalEventDetail {
    /**
     * 详情id
     */
    @ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 用药事件id
     */
    @ApiModelProperty(value = "用药事件id")
    private String medEventId;

    /**
     * 浓度
     */
    @ApiModelProperty(value = "浓度")
    private Float thickness;

    /**
     * 浓度单位
     */
    @ApiModelProperty(value = "浓度单位")
    private String thicknessUnit;

    /**
     * 流速
     */
    @ApiModelProperty(value = "流速")
    private Float flow;

    /**
     * 流速单位
     */
    @ApiModelProperty(value = "流速单位")
    private String flowUnit;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMedEventId() {
        return medEventId;
    }

    public void setMedEventId(String medEventId) {
        this.medEventId = medEventId == null ? null : medEventId.trim();
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public String getThicknessUnit() {
        return thicknessUnit;
    }

    public void setThicknessUnit(String thicknessUnit) {
        this.thicknessUnit = thicknessUnit == null ? null : thicknessUnit.trim();
    }

    public Float getFlow() {
        return flow;
    }

    public void setFlow(Float flow) {
        this.flow = flow;
    }

    public String getFlowUnit() {
        return flowUnit;
    }

    public void setFlowUnit(String flowUnit) {
        this.flowUnit = flowUnit == null ? null : flowUnit.trim();
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
}