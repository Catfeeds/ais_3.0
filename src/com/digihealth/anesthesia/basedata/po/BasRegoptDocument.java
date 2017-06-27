/*
 * BasRegoptDocument.java
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

@ApiModel(value = "患者手术文书对应表对象")
public class BasRegoptDocument {
    /**
     * 主键id
     */
	@ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 患者id
     */
	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 文书id
     */
	@ApiModelProperty(value = "文书id")
    private String docId;

    /**
     * 创建时间
     */
	@ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 完成状态;END-完成，NO_END-未完成，预留，方便扩展
     */
	@ApiModelProperty(value = "完成状态;END-完成，NO_END-未完成，预留，方便扩展")
    private String processState;

    /**
     * 基线id
     */
	@ApiModelProperty(value = "基线id")
    private String beid;

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

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}