/*
 * DocSelfPayAccede.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "医保病人麻醉科自费项目同意书对象")
public class DocSelfPayAccede {

	@ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 数据状态
     */
	@ApiModelProperty(value = "数据状态")
    private String state;

    /**
     * 手术ID
     */
	@ApiModelProperty(value = "手术ID")
    private String regOptId;

    /**
     * 类型(乙类药品或其他)
     */
	@ApiModelProperty(value = "类型(乙类药品或其他)")
    private String type;

    /**
     * 项目类型
     */
	@ApiModelProperty(value = "项目类型")
    private String projectType;

	@ApiModelProperty(value = "项目名称")
    private String projectName;

    /**
     * 项目比例
     */
	@ApiModelProperty(value = "项目比例")
    private String projectScale;

    /**
     * 备注
     */
	@ApiModelProperty(value = "备注")
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectScale() {
		return projectScale;
	}

	public void setProjectScale(String projectScale) {
		this.projectScale = projectScale;
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}