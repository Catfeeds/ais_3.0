/*
 * EvtOperBodyEvent.java
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

@ApiModel(value = "手术体位事件表对象")
public class EvtOperBodyEvent {
    /**
     * 手术体位变更事件主键
     */
    @ApiModelProperty(value = "主键ID")
    private String optBodyEventId;

    /**
     * 文书ID
     */
    @ApiModelProperty(value = "文书ID")
    private String docId;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 手术体位
     */
    @ApiModelProperty(value = "手术体位")
    private String optBody;

    /**
     * 老的手术体位
     */
    @ApiModelProperty(value = "老的手术体位")
    private String optBodyOld;

    public String getOptBodyEventId() {
        return optBodyEventId;
    }

    public void setOptBodyEventId(String optBodyEventId) {
        this.optBodyEventId = optBodyEventId == null ? null : optBodyEventId.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getOptBody() {
        return optBody;
    }

    public void setOptBody(String optBody) {
        this.optBody = optBody == null ? null : optBody.trim();
    }

    public String getOptBodyOld() {
        return optBodyOld;
    }

    public void setOptBodyOld(String optBodyOld) {
        this.optBodyOld = optBodyOld == null ? null : optBodyOld.trim();
    }
}