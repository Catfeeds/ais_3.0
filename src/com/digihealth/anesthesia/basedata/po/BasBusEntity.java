/*
 * BasBusEntity.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-23 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="基线表对象")
public class BasBusEntity {
    /**
     * 局点id，主键
     */
    @ApiModelProperty(value="局点id，主键")
    private String beid;

    /**
     * 局点名称
     */
    @ApiModelProperty(value="局点名称")
    private String name;

    /**
     * 局点编码
     */
    @ApiModelProperty(value="局点编码")
    private String code;
    
    /**
     * 子名称
     */
    @ApiModelProperty(value="子名称")
    private String subName;

    /**
     * 电话
     */
    @ApiModelProperty(value="电话")
    private String tel;

    /**
     * 地址
     */
    @ApiModelProperty(value="地址")
    private String address;

    /**
     * 描述
     */
    @ApiModelProperty(value="描述")
    private String description;

    /**
     * 是否可用:1-可用，0-不可用
     */
    @ApiModelProperty(value="是否可用:1-可用，0-不可用")
    private Integer enable;

    /**
     * 是否当前局点：1-是，0否
     */
    @ApiModelProperty(value="是否当前局点：1-是，0否")
    private Integer isCurBe;

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getIsCurBe() {
        return isCurBe;
    }

    public void setIsCurBe(Integer isCurBe) {
        this.isCurBe = isCurBe;
    }
}