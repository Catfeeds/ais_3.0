/*
 * EvtEgress.java
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

@ApiModel(value = "出量事件对象")
public class EvtEgress {
    /**
     * 出入量药品事件主键
     */
	@ApiModelProperty(value = "出入量药品事件主键")
    private String egressId;

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
     * 结束时间
     */
	@ApiModelProperty(value = "结束时间")
    private Date endTime;

    /**
     * 创建人
     */
	@ApiModelProperty(value = "创建人")
    private String createUser;

    /**
     * 出入量基础表主键
     */
	@ApiModelProperty(value = "出入量基础表主键")
    private String ioDefId;

    /**
     * 检查值
     */
	@ApiModelProperty(value = "检查值")
    private String value;

    /**
     * 文书类型：1-麻醉记录单，2-pacu观察记录单
     */
	@ApiModelProperty(value = "文书类型：1-麻醉记录单，2-pacu观察记录单")
    private Integer docType;

    public String getEgressId() {
        return egressId;
    }

    public void setEgressId(String egressId) {
        this.egressId = egressId == null ? null : egressId.trim();
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateuser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getIoDefId() {
        return ioDefId;
    }

    public void setIoDefId(String ioDefId) {
        this.ioDefId = ioDefId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }
}