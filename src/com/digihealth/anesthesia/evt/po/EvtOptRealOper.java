/*
 * EvtOptRealOper.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "已施手术对象")
public class EvtOptRealOper {
    /**
     * 已施手术主键
     */
	@ApiModelProperty(value = "已施手术主键")
    private String optRealOperId;

    /**
     * 文书ID
     */
	@ApiModelProperty(value = "文书ID")
    private String docId;

    /**
     * 已施手术CODE
     */
	@ApiModelProperty(value = "已施手术CODE")
    private String operDefId;

    /**
     * 已施手术名称
     */
	@ApiModelProperty(value = "已施手术名称")
    private String name;

    /**
     * 修改的名称
     */
	@ApiModelProperty(value = "修改的名称")
    private String editName;

    public String getOptRealOperId() {
        return optRealOperId;
    }

    public void setOptRealOperId(String optRealOperId) {
        this.optRealOperId = optRealOperId == null ? null : optRealOperId.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getOperDefId() {
        return operDefId;
    }

    public void setOperDefId(String operDefId) {
        this.operDefId = operDefId == null ? null : operDefId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEditName() {
        return editName;
    }

    public void setEditName(String editName) {
        this.editName = editName == null ? null : editName.trim();
    }
}