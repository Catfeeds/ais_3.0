package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

/**
 * 
 * Title: RegOptFormBean.java Description:
 * 
 * @author chenyong
 * @created 2016年7月21日 下午7:00:11
 */
public class RegOptFormBean {
	private String state; // 手术状态
	private Date startTime; // 开始时间
	private Date endTime; // 结束时间
	private String hisId; // 住院号
	private String roomId; // 房间ID

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getHisId() {
		return hisId;
	}

	public void setHisId(String hisId) {
		this.hisId = hisId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

}
