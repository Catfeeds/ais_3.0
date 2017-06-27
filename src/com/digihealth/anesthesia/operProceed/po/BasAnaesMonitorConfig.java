package com.digihealth.anesthesia.operProceed.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


@ApiModel(value="麻醉监测标记点设置对象")
public class BasAnaesMonitorConfig {
    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
     * 手术ID
     */
    @ApiModelProperty(value="手术ID")
    private String regOptId;

    /**
     * 颜色
     */
    @ApiModelProperty(value="颜色")
    private String color;

    /**
     * 图片路径
     */
    @ApiModelProperty(value="图片路径")
    private String iconId;

    /**
     * b_monitor_config的eventId
     */
    @ApiModelProperty(value="eventId")
    private String eventId;

    /**
     * 设备id
     */
    @ApiModelProperty(value="设备id")
    private String deviceId;

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

    /**
     * 位置:0-描点位置,1-代表监测项位置
     */
    @ApiModelProperty(value="位置:0-描点位置,1-代表监测项位置")
    private Integer position;

    /**
     * 重复监测项对应的实际eventId
     */
    @ApiModelProperty(value="重复监测项对应的实际eventId")
    private String realEventId;

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

    public String getEventName()
    {
        return eventName;
    }

    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getRealEventId() {
        return realEventId;
    }

    public void setRealEventId(String realEventId) {
        this.realEventId = realEventId == null ? null : realEventId.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}