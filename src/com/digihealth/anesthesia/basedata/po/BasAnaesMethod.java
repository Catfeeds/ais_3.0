/*
 * BasAnaesMethod.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="麻醉方法对象")
public class BasAnaesMethod {
    /**
     * 麻醉方法主键
     */
    @ApiModelProperty(value="麻醉方法主键")
    private String anaMedId;

    /**
     * 代码
     */
    @ApiModelProperty(value="代码")
    private String code;

    /**
     * 一级分类
     */
    @ApiModelProperty(value="一级分类")
    private String cate1;

    /**
     * 二级分类
     */
    @ApiModelProperty(value="二级分类")
    private String cate2;

    /**
     * 三级分类
     */
    @ApiModelProperty(value="三级分类")
    private String cate3;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 是否分类;0:否,1:是
     */
    @ApiModelProperty(value="是否分类;0:否,1:是")
    private Integer isCate;

    /**
     * 是否常用;0:否,1:是
     */
    @ApiModelProperty(value="是否常用;0:否,1:是")
    private Integer isUsually;

    /**
     * 是否可选;0:否,1:是
     */
    @ApiModelProperty(value="是否可选;0:否,1:是")
    private Integer optional;

    /**
     * 是否有效;0:否,1:是
     */
    @ApiModelProperty(value="是否有效;0:否,1:是")
    private Integer isValid;

    @ApiModelProperty(value="拼音")
    private String pinYin;

    /**
     * 麻醉类别
     */
    @ApiModelProperty(value="麻醉类别")
    private Integer anesType;

    private Integer isLocalAnaes;
    
    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getAnaMedId() {
        return anaMedId;
    }

    public void setAnaMedId(String anaMedId) {
        this.anaMedId = anaMedId == null ? null : anaMedId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCate1() {
        return cate1;
    }

    public void setCate1(String cate1) {
        this.cate1 = cate1 == null ? null : cate1.trim();
    }

    public String getCate2() {
        return cate2;
    }

    public void setCate2(String cate2) {
        this.cate2 = cate2 == null ? null : cate2.trim();
    }

    public String getCate3() {
        return cate3;
    }

    public void setCate3(String cate3) {
        this.cate3 = cate3 == null ? null : cate3.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getIsCate() {
        return isCate;
    }

    public void setIsCate(Integer isCate) {
        this.isCate = isCate;
    }

    public Integer getIsUsually() {
        return isUsually;
    }

    public void setIsUsually(Integer isUsually) {
        this.isUsually = isUsually;
    }

    public Integer getOptional() {
        return optional;
    }

    public void setOptional(Integer optional) {
        this.optional = optional;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
    }

    public Integer getAnesType() {
        return anesType;
    }

    public void setAnesType(Integer anesType) {
        this.anesType = anesType;
    }

    public Integer getIsLocalAnaes() {
		return isLocalAnaes;
	}

	public void setIsLocalAnaes(Integer isLocalAnaes) {
		this.isLocalAnaes = isLocalAnaes;
	}

	public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}