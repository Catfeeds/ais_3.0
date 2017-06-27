/*
 * BasDept.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "科室对象")
public class BasDept {
    /**
     * 主键id
     */
	@ApiModelProperty(value = "ID")
    private String deptId;

    /**
     * 名称
     */
	@ApiModelProperty(value = "名称")
    private String name;

	@ApiModelProperty(value = "描述")
    private String remarks;

    /**
     * 是否有效;0-无效，1-有效
     */
	@ApiModelProperty(value = "是否有效;0-无效，1-有效")
    private Integer enable;

    /**
     * 基线id
     */
	@ApiModelProperty(value = "基线id")
    private String beid;
	
    /**
     * 拼音
     */
	@ApiModelProperty(value = "pinYin")
    private String pinYin;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }

	public String getPinYin()
	{
		return pinYin;
	}

	public void setPinYin(String pinYin)
	{
		this.pinYin = pinYin;
	}

}