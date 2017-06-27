/*
 * EvtMeterial.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "安装体内置入材料情况对象")
public class EvtMaterial {
    /**
     * ID
     */
	@ApiModelProperty(value = "ID")
    private String id;

    /**
     * 文书ID
     */
	@ApiModelProperty(value = "文书ID")
    private String docId;

    /**
     * 材料名称
     */
	@ApiModelProperty(value = "材料名称")
    private String materialName;

    /**
     * 型号编号
     */
	@ApiModelProperty(value = "型号编号")
    private String modelNumber;

    /**
     * 供货公司
     */
	@ApiModelProperty(value = "供货公司")
    private String company;

    /**
     * 来源 （进口、合资、国产）
     */
	@ApiModelProperty(value = "来源 （进口、合资、国产）")
    private String source;

    /**
     * 数量
     */
	@ApiModelProperty(value = "数量")
    private Integer number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber == null ? null : modelNumber.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}