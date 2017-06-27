/*
 * BasOperateLog.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-24 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="操作日志对象")
public class BasOperateLog {
    
    @ApiModelProperty(value="主键id")
	private String id;

	/**
	 * 业务ID
	 */
    @ApiModelProperty(value="业务ID")
	private String busiId;

	/**
	 * 操作员
	 */
    @ApiModelProperty(value="操作员")
	private String operName;

    @ApiModelProperty(value="操作员id")
	private String operId;

	/**
	 * 是否登录错误：0正确，1不正确
	 */
    @ApiModelProperty(value="是否登录错误：0正确，1不正确")
	private Integer isError;
	/**
	 * 登录渠道
	 */
    @ApiModelProperty(value="登录渠道")
	private String channel;
	/**
	 * 时间
	 */
    @ApiModelProperty(value="时间")
	private Date operTime;

    @ApiModelProperty(value="类型")
	private String operType;

	/**
	 * 所属模块
	 */
    @ApiModelProperty(value="所属模块")
	private String operModule;

    @ApiModelProperty(value="备注")
	private String remark;

    @ApiModelProperty(value="基线id")
	private String beid;
	/**
	 * 操作详细信息
	 */
    @ApiModelProperty(value="操作详细信息")
	private String operContents;

    @ApiModelProperty(value="描述")
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId == null ? null : busiId.trim();
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName == null ? null : operName.trim();
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId == null ? null : operId.trim();
	}

	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public Integer getIsError() {
		return isError;
	}

	public void setIsError(Integer isError) {
		this.isError = isError;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType == null ? null : operType.trim();
	}

	public String getOperModule() {
		return operModule;
	}

	public void setOperModule(String operModule) {
		this.operModule = operModule == null ? null : operModule.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

	public String getOperContents() {
		return operContents;
	}

	public void setOperContents(String operContents) {
		this.operContents = operContents == null ? null : operContents.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}