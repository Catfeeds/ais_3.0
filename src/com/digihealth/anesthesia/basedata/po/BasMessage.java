/*
 * BasMessage.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="系统消息对象")
public class BasMessage {
    /**
     * 消息主键id
     */
    @ApiModelProperty(value="消息主键id")
    private Integer id;

    /**
     * 保存需要同步的消息
     */
    @ApiModelProperty(value="保存需要同步的消息")
    private String message;

    /**
     * 时间
     */
    @ApiModelProperty(value="时间")
    private Date time;

    /**
     * 优先级：0-普通，1-急，2-加急；级别越高，，消息越先消费
     */
    @ApiModelProperty(value="优先级：0-普通，1-急，2-加急；级别越高，，消息越先消费")
    private Integer priority;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}