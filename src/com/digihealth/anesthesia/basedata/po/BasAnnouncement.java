/*
 * BasAnnouncement.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "信息公告对象")
public class BasAnnouncement {
	/**
	 * ID
	 */
	@ApiModelProperty(value = "id")
	private String id;

	/**
	 * 标题
	 */
	@ApiModelProperty(value = "标题")
	private String title;

	/**
	 * 公告内容
	 */
	@ApiModelProperty(value = "公告信息内容")
	private String content;

	/**
	 * 发布时间
	 */
	@ApiModelProperty(value = "发布时间")
	private Date time;

	/**
	 * 发布时间(转换为string类型)
	 */
	@ApiModelProperty(value = "发布时间(转换为string类型)")
	private String timeStr;
	
	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	private String createUser;

	/**
	 * 创建人姓名
	 */
	@ApiModelProperty(value = "创建人姓名")
	private String createUserName;
	
	@ApiModelProperty(value = "开始时间")
	private String beginTime;

	@ApiModelProperty(value = "结束时间")
	private String endTime;
	
	/**
	 * 基线id
	 */
	@ApiModelProperty(value = "基线id")
	private String beid;
	
	/**
	 * 是否有效 1有效  0 无效
	 */
	@ApiModelProperty(value = "是否有效 1有效  0 无效")
	private Integer enable;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getTimeStr() {
		return timeStr;
	}

	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid == null ? null : beid.trim();
	}

	public Integer getEnable()
	{
		return enable;
	}

	public void setEnable(Integer enable)
	{
		this.enable = enable;
	}
}