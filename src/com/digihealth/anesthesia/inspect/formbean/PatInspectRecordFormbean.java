package com.digihealth.anesthesia.inspect.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "检验检查结果参数对象")
public class PatInspectRecordFormbean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "患者id")
	private String regOptId;

	@ApiModelProperty(value = "姓名")
	private String name; // 姓名

	@ApiModelProperty(value = "住院号")
	private String hid; // 住院号

	@ApiModelProperty(value = "手术室")
	private String roomName;// 手术室

	@ApiModelProperty(value = "手术时间")
	private String operaDate;// 手术时间

	@ApiModelProperty(value = "手术状态")
	private String state;// 手术状态

	@ApiModelProperty(value = "拟实施手术")
	private String designedOptName;// 拟实施手术

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getOperaDate() {
		return operaDate;
	}

	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDesignedOptName() {
		return designedOptName;
	}

	public void setDesignedOptName(String designedOptName) {
		this.designedOptName = designedOptName;
	}

}
