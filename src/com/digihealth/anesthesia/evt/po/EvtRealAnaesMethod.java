/*
 * EvtRealAnaesMethod.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "实际麻醉方法对象")
public class EvtRealAnaesMethod {
    /**
     * 实际麻醉方法主键
     */
	@ApiModelProperty(value = "实际麻醉方法主键")
    private String realAnaMedId;

    /**
     * 文书ID
     */
	@ApiModelProperty(value = "文书ID")
    private String docId;

    /**
     * 麻醉方法code
     */
	@ApiModelProperty(value = "麻醉方法code")
    private String anaMedId;

    /**
     * 麻醉方法名称
     */
	@ApiModelProperty(value = "麻醉方法名称")
    private String name;

    /**
     * 修改的名称
     */
	@ApiModelProperty(value = "修改的名称")
    private String editName;

    public String getRealAnaMedId() {
        return realAnaMedId;
    }

    public void setRealAnaMedId(String realAnaMedId) {
        this.realAnaMedId = realAnaMedId == null ? null : realAnaMedId.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getAnaMedId() {
        return anaMedId;
    }

    public void setAnaMedId(String anaMedId) {
        this.anaMedId = anaMedId == null ? null : anaMedId.trim();
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