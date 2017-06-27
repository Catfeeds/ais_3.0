/*
 * EvtCheckEvent.java
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

@ApiModel(value = "检查检验事件对象")
public class EvtCheckEvent {
    /**
     * 检查检验事件主键
     */
	@ApiModelProperty(value = "检查检验事件主键")
    private String cheEventId;

	@ApiModelProperty(value = "检查检验事件名称")
    private String cheEventName;
    /**
     * 文书Id
     */
	@ApiModelProperty(value = "文书Id")
    private String docId;

    /**
     * 创建时间
     */
	@ApiModelProperty(value = "创建时间")
    private Date occurTime;

    /**
     * 检验检测总结
     */
	@ApiModelProperty(value = "检验检测总结")
    private String resultSummary;

    public String getCheEventId() {
        return cheEventId;
    }

    public void setCheEventId(String cheEventId) {
        this.cheEventId = cheEventId == null ? null : cheEventId.trim();
    }

    public String getCheEventName() {
		return cheEventName;
	}

	public void setCheEventName(String cheEventName) {
		this.cheEventName = cheEventName;
	}

	public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    public String getResultSummary() {
        return resultSummary;
    }

    public void setResultSummary(String resultSummary) {
        this.resultSummary = resultSummary == null ? null : resultSummary.trim();
    }
}