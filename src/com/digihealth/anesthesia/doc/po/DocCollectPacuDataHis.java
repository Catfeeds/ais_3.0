/*
 * CollectPacuDataHis.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2016-08-24 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "观测对象")
public class DocCollectPacuDataHis {
    @ApiModelProperty(value = "主键id")
     private String id;

    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
     private Date time;

    /**
     * 患者id
     */
    @ApiModelProperty(value = "患者id")
     private String doc_id;

    /**
     * 观察点ID
     */
    @ApiModelProperty(value = "观察点ID")
     private String observe_id;

    /**
     * 观测点的值
     */
    @ApiModelProperty(value = "观测点的值")
     private Float value;

    /**
     * 是否正常值，0正常，-1过低，1过高
     */
    @ApiModelProperty(value = "是否正常值，0正常，-1过低，1过高")
     private Integer state;

    @ApiModelProperty(value = "observe_name")
     private String observe_name;

    @ApiModelProperty(value = "图标")
     private String icon;

    @ApiModelProperty(value = "颜色")
     private String color;

    @ApiModelProperty(value = "freq")
     private Integer freq;

    @ApiModelProperty(value = "position")
     private Integer position;

    @ApiModelProperty(value = "interval_time")
     private Integer interval_time;

    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id")
     private String device_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id == null ? null : doc_id.trim();
    }

    public String getObserve_id() {
        return observe_id;
    }

    public void setObserve_id(String observe_id) {
        this.observe_id = observe_id == null ? null : observe_id.trim();
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getObserve_name() {
        return observe_name;
    }

    public void setObserve_name(String observe_name) {
        this.observe_name = observe_name == null ? null : observe_name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getInterval_time() {
        return interval_time;
    }

    public void setInterval_time(Integer interval_time) {
        this.interval_time = interval_time;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id == null ? null : device_id.trim();
    }
}