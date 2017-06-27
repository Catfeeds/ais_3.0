package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.digihealth.anesthesia.common.utils.PingYinUtil;
import com.digihealth.anesthesia.common.utils.StringUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Project Name:ais File Name:BaseInfoQuery.java Package
 * Name:com.digihealth.anesthesia.basedata.formbean Date:2015-10-22 上午10:31:58
 * Copyright (c) 2015, ly351x@sina.com All Rights Reserved.
 */

@ApiModel(value = "查询参数对象")
public class BaseInfoQuery implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "拼音")
	private String pinyin;
	@ApiModelProperty(value = "是否可用")
	private String enable;
	@ApiModelProperty(value = "第几页")
	private Integer pageNo;
	@ApiModelProperty(value = "每页显示多少行")
	private Integer pageSize;
	@ApiModelProperty(value = "")
	private String type;
	@ApiModelProperty(value = "")
	private String subType;
	@ApiModelProperty(value = "")
	private String delFlag;
	@ApiModelProperty(value = "用户类型")
	private String userType;
	@ApiModelProperty(value = "状态")
	private String state;
	@ApiModelProperty(value = "")
	private String operDate;
	@ApiModelProperty(value = "")
	private String operTime;
	@ApiModelProperty(value = "")
	private String isHold;
	@ApiModelProperty(value = "")
	private List<String> stateItems;
	@ApiModelProperty(value = "手术室ID")
	private String operRoomId;
	@ApiModelProperty(value = "手术ID")
	private String regOptId;
	@ApiModelProperty(value = "")
	private String eventId;
	@ApiModelProperty(value = "编码")
	private String code;
	@ApiModelProperty(value = "")
	private String source;
	@ApiModelProperty(value = "文书ID")
	private String docId;
	@ApiModelProperty(value = "")
	private String id;
	@ApiModelProperty(value = "0表示描点画图 1表示数据项")
	private String position; // 0表示描点画图 1表示数据项
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "基线ID")
	private String beid;
	@ApiModelProperty(value = "住院号")
	private String hid;

	public String getHid()
    {
        return hid;
    }

    public void setHid(String hid)
    {
        this.hid = hid;
    }

    public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getOperRoomId() {
		return operRoomId;
	}

	public void setOperRoomId(String operRoomId) {
		this.operRoomId = operRoomId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getStateItems() {
		if (StringUtils.isNotBlank(state)) {
			stateItems = new ArrayList<String>();
			String[] states = state.split(",");
			for (int i = 0; i < states.length; i++) {
				stateItems.add(states[i]);
			}
		}
		return stateItems;
	}

	public void setStateItems(List<String> stateItems) {
		this.stateItems = stateItems;
	}

	public String getIsHold() {
		return isHold;
	}

	public void setIsHold(String isHold) {
		this.isHold = isHold;
	}

	public String getOperDate() {
		return operDate;
	}

	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}

	public String getOperTime() {
		return operTime;
	}

	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = PingYinUtil.getFirstSpell(pinyin);
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Integer getPageNo() {
		if (pageNo != null) {
			return (pageNo - 1) * pageSize;
		}
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "BaseInfoQuery [pinyin=" + pinyin + ", enable=" + enable
				+ ", pageNo=" + pageNo + ", pageSize=" + pageSize + ", type="
				+ type + ", subType=" + subType + ", delFlag=" + delFlag
				+ ", userType=" + userType + ", state=" + state + ", operDate="
				+ operDate + ", operTime=" + operTime + ", isHold=" + isHold
				+ ", stateItems=" + stateItems + ", operRoomId=" + operRoomId
				+ ", regOptId=" + regOptId + "]";
	}

}
