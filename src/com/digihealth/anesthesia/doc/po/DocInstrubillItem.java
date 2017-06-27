/*
 * DocInstrubillItem.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术所用的器械对象")
public class DocInstrubillItem {
	@ApiModelProperty(value = "主键id")
    private String instruItemId;

    /**
     * 患者id
     */
	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 器械CODE
     */
	@ApiModelProperty(value = "器械id")
    private String instrumentId;

	@ApiModelProperty(value = "器械名称")
	private String instruItemName;
	
    /**
     * 术前清点
     */
	@ApiModelProperty(value = "术前清点")
    private Integer origamount;

    /**
     * 术中加数
     */
	@ApiModelProperty(value = "术中加数")
    private Integer inadd;

    /**
     * 关空腔脏器核对
     */
	@ApiModelProperty(value = "关空腔脏器核对")
    private Integer hollowViscus;

    /**
     * 关体腔前
     */
	@ApiModelProperty(value = "关体腔前")
    private Integer cloBeBody;

    /**
     * 关体腔后
     */
	@ApiModelProperty(value = "关体腔后")
    private Integer cloAfBody;

	@ApiModelProperty(value = "创建人")
    private String createUser;

	@ApiModelProperty(value = "创建时间")
    private Date createTime;

    public String getInstruItemId() {
        return instruItemId;
    }

    public void setInstruItemId(String instruItemId) {
        this.instruItemId = instruItemId == null ? null : instruItemId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public Integer getOrigamount() {
        return origamount;
    }

    public void setOrigamount(Integer origamount) {
        this.origamount = origamount;
    }

    public Integer getInadd() {
        return inadd;
    }

    public void setInadd(Integer inadd) {
        this.inadd = inadd;
    }

    public Integer getHollowViscus() {
        return hollowViscus;
    }

    public void setHollowViscus(Integer hollowViscus) {
        this.hollowViscus = hollowViscus;
    }

    public Integer getCloBeBody() {
        return cloBeBody;
    }

    public void setCloBeBody(Integer cloBeBody) {
        this.cloBeBody = cloBeBody;
    }

    public Integer getCloAfBody() {
        return cloAfBody;
    }

    public void setCloAfBody(Integer cloAfBody) {
        this.cloAfBody = cloAfBody;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getInstruItemName() {
		return instruItemName;
	}

	public void setInstruItemName(String instruItemName) {
		this.instruItemName = instruItemName;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}