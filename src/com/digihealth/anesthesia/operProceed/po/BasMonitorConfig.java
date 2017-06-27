/*
 * BasMonitorConfig.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-11 Created
 */
package com.digihealth.anesthesia.operProceed.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="监测项对象")
public class BasMonitorConfig {
    /**
     * eventId，监测项id
     */
    @ApiModelProperty(value="监测项id")
    private String eventId;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    /**
     * 监测项名称
     */
    @ApiModelProperty(value="监测项名称")
    private String eventName;

    @ApiModelProperty(value="偏差")
    private Integer precision;

    @ApiModelProperty(value="频率")
    private Integer frequency;

    /**
     * 最大值
     */
    @ApiModelProperty(value="最大值")
    private Float max;

    /**
     * 最小值
     */
    @ApiModelProperty(value="最小值")
    private Float min;

    @ApiModelProperty(value="修正")
    private Integer amendFlag;

    /**
     * 颜色
     */
    @ApiModelProperty(value="颜色")
    private String color;

    /**
     * 图标
     */
    @ApiModelProperty(value="图标")
    private String iconId;

    /**
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String eventDesc;

    /**
     * 必须显示;1-必须展示，null非必需展示
     */
    @ApiModelProperty(value="必须显示;1-必须展示，null非必需展示")
    private String mustShow;

    /**
     * 0:描点；1：数字，-1实时
     */
    @ApiModelProperty(value="0:描点；1：数字，-1实时")
    private Integer position;

    /**
     * 单位
     */
    @ApiModelProperty(value="单位")
    private String units;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Integer getAmendFlag() {
        return amendFlag;
    }

    public void setAmendFlag(Integer amendFlag) {
        this.amendFlag = amendFlag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId == null ? null : iconId.trim();
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc == null ? null : eventDesc.trim();
    }

    public String getMustShow() {
        return mustShow;
    }

    public void setMustShow(String mustShow) {
        this.mustShow = mustShow == null ? null : mustShow.trim();
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }
}