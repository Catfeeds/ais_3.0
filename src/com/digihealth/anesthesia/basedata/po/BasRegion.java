/*
 * BasRegion.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="病区信息对象")
public class BasRegion {
    /**
     * id
     */
    @ApiModelProperty(value="病区id")
    private String regionId;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 是否有效
     */
    @ApiModelProperty(value="是否有效")
    private Integer enable;
    
    /**
     * 拼音
     */
    @ApiModelProperty(value="拼音")
    private String pinYin;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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