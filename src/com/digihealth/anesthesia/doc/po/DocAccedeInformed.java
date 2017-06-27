/*
 * DocAccedeInformed.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉同意书知情详情表对象")
public class DocAccedeInformed {
    /**
     * 主键id
     */
	@ApiModelProperty(value = "主键id")
    private String anasInformedId;

    /**
     * 知情同意书id
     */
	@ApiModelProperty(value = "知情同意书id")
    private String accedeId;

    /**
     * 内容
     */
	@ApiModelProperty(value = "内容")
    private String content;

    /**
     * 显示多少条
     */
	@ApiModelProperty(value = "显示多少条")
    private Integer id;

    public String getAnasInformedId() {
        return anasInformedId;
    }

    public void setAnasInformedId(String anasInformedId) {
        this.anasInformedId = anasInformedId == null ? null : anasInformedId.trim();
    }

    public String getAccedeId() {
        return accedeId;
    }

    public void setAccedeId(String accedeId) {
        this.accedeId = accedeId == null ? null : accedeId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}