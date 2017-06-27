/*
 * BasPacuMonitorConfig.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "pacu采集指标基础表")
public class BasPacuMonitorConfig
{
    
    @ApiModelProperty(value = "监测项id")
    private String eventId;
    
    /**
     * 监测项名称
     */
    
    @ApiModelProperty(value = "监测项名称")
    private String eventName;
    
    @ApiModelProperty(value = "精确值")
    private Integer precision;
    
    @ApiModelProperty(value = "频率")
    private Integer frequency;
    
    /**
     * 最大值
     */
    
    @ApiModelProperty(value = "最大值")
    private Float max;
    
    /**
     * 最小值
     */
    
    @ApiModelProperty(value = "最小值")
    private Float min;
    
    @ApiModelProperty(value = "amendFlag")
    private Integer amendFlag;
    
    @ApiModelProperty(value = "颜色")
    private String color;
    
    @ApiModelProperty(value = "图标")
    private String iconId;
    
    @ApiModelProperty(value = "监测项描述")
    private String eventDesc;
    
    /**
     * 必须显示:1
     */
    
    @ApiModelProperty(value = "必须显示:1")
    private Integer mustShow;
    
    /**
     * 必须采集:1
     */
    
    @ApiModelProperty(value = "必须采集:1")
    private Integer mustCollect;
    
    /**
     * 0:描点；1：数字,-1:实时
     */
    
    @ApiModelProperty(value = "0:描点；1：数字,-1:实时")
    private Integer position;
    
    @ApiModelProperty(value = "单位")
    private String units;
    
    /**
     * 设备类型：1.手术室终端；2：复苏室终端；3：心电监护仪、4：呼吸机、5：麻醉机
     */
    
    @ApiModelProperty(value = "设备类型：1.手术室终端；2：复苏室终端；3：心电监护仪、4：呼吸机、5：麻醉机")
    private Integer deviceType;
    
    /**
     * 基线id
     */
    
    @ApiModelProperty(value = "基线id")
    private String beid;
    
    public String getEventId()
    {
        return eventId;
    }
    
    public void setEventId(String eventId)
    {
        this.eventId = eventId == null ? null : eventId.trim();
    }
    
    public String getEventName()
    {
        return eventName;
    }
    
    public void setEventName(String eventName)
    {
        this.eventName = eventName == null ? null : eventName.trim();
    }
    
    public Integer getPrecision()
    {
        return precision;
    }
    
    public void setPrecision(Integer precision)
    {
        this.precision = precision;
    }
    
    public Integer getFrequency()
    {
        return frequency;
    }
    
    public void setFrequency(Integer frequency)
    {
        this.frequency = frequency;
    }
    
    public Float getMax()
    {
        return max;
    }
    
    public void setMax(Float max)
    {
        this.max = max;
    }
    
    public Float getMin()
    {
        return min;
    }
    
    public void setMin(Float min)
    {
        this.min = min;
    }
    
    public Integer getAmendFlag()
    {
        return amendFlag;
    }
    
    public void setAmendFlag(Integer amendFlag)
    {
        this.amendFlag = amendFlag;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public void setColor(String color)
    {
        this.color = color == null ? null : color.trim();
    }
    
    public String getIconId()
    {
        return iconId;
    }
    
    public void setIconId(String iconId)
    {
        this.iconId = iconId == null ? null : iconId.trim();
    }
    
    public String getEventDesc()
    {
        return eventDesc;
    }
    
    public void setEventDesc(String eventDesc)
    {
        this.eventDesc = eventDesc == null ? null : eventDesc.trim();
    }
    
    public Integer getMustShow()
    {
        return mustShow;
    }
    
    public void setMustShow(Integer mustShow)
    {
        this.mustShow = mustShow;
    }
    
    public Integer getMustCollect()
    {
        return mustCollect;
    }
    
    public void setMustCollect(Integer mustCollect)
    {
        this.mustCollect = mustCollect;
    }
    
    public Integer getPosition()
    {
        return position;
    }
    
    public void setPosition(Integer position)
    {
        this.position = position;
    }
    
    public String getUnits()
    {
        return units;
    }
    
    public void setUnits(String units)
    {
        this.units = units == null ? null : units.trim();
    }
    
    public Integer getDeviceType()
    {
        return deviceType;
    }
    
    public void setDeviceType(Integer deviceType)
    {
        this.deviceType = deviceType;
    }
    
    public String getBeid()
    {
        return beid;
    }
    
    public void setBeid(String beid)
    {
        this.beid = beid == null ? null : beid.trim();
    }
}