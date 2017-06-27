package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class HomeAnaesDoctorWorkingTimeFormBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "手术id")
	private String regOptId;

	@ApiModelProperty(value = "年份")
	private String year;

	@ApiModelProperty(value = "月份")
	private String month;

	@ApiModelProperty(value = "麻醉开始时间")
	private String anaesStartTime;

	@ApiModelProperty(value = "入室时间")
	private String inOperRoomTime;

	@ApiModelProperty(value = "出室时间")
	private String outOperRoomTime;

	@ApiModelProperty(value = "手术开始时间")
	private String operStartTime;

	@ApiModelProperty(value = "手术结束时间")
	private String operEndTime;

	@ApiModelProperty(value = "麻醉医生id")
	private String anesthetistId;

	@ApiModelProperty(value = "上级医生")
	private String circuanesthetistId;

	@ApiModelProperty(value = "交班人员id")
	private String shiftChangedPeopleId;

	@ApiModelProperty(value = "交班时间")
	private String shiftChangeTime;

	@ApiModelProperty(value = "接班人员id")
	private String shiftChangePeopleId;

	@ApiModelProperty(value = "用户登录名")
	private String userLoginName;

	@ApiModelProperty(value = "时间")
	private String times;

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getShiftChangePeopleId() {
		return shiftChangePeopleId;
	}

	public void setShiftChangePeopleId(String shiftChangePeopleId) {
		this.shiftChangePeopleId = shiftChangePeopleId;
	}

	public String getShiftChangedPeopleId() {
		return shiftChangedPeopleId;
	}

	public void setShiftChangedPeopleId(String shiftChangedPeopleId) {
		this.shiftChangedPeopleId = shiftChangedPeopleId;
	}

	public String getShiftChangeTime() {
		return shiftChangeTime;
	}

	public void setShiftChangeTime(String shiftChangeTime) {
		this.shiftChangeTime = shiftChangeTime;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getAnaesStartTime() {
		return anaesStartTime;
	}

	public void setAnaesStartTime(String anaesStartTime) {
		this.anaesStartTime = anaesStartTime;
	}

	public String getInOperRoomTime() {
		return inOperRoomTime;
	}

	public void setInOperRoomTime(String inOperRoomTime) {
		this.inOperRoomTime = inOperRoomTime;
	}

	public String getOutOperRoomTime() {
		return outOperRoomTime;
	}

	public void setOutOperRoomTime(String outOperRoomTime) {
		this.outOperRoomTime = outOperRoomTime;
	}

	public String getOperStartTime() {
		return operStartTime;
	}

	public void setOperStartTime(String operStartTime) {
		this.operStartTime = operStartTime;
	}

	public String getOperEndTime() {
		return operEndTime;
	}

	public void setOperEndTime(String operEndTime) {
		this.operEndTime = operEndTime;
	}

	public String getAnesthetistId() {
		return anesthetistId;
	}

	public void setAnesthetistId(String anesthetistId) {
		this.anesthetistId = anesthetistId;
	}

	public String getCircuanesthetistId() {
		return circuanesthetistId;
	}

	public void setCircuanesthetistId(String circuanesthetistId) {
		this.circuanesthetistId = circuanesthetistId;
	}

}
