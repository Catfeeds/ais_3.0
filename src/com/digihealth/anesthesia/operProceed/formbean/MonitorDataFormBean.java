package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

public class MonitorDataFormBean {
	private Integer size;//
	private Integer no;//页码
	private Date startTime;//开始时间
	private Date endTime;//结束时间
	private String regOptId;//患者id
	private Date inTime;//入室时间
	private String beid;

	public String getBeid()
    {
        return beid;
    }

    public void setBeid(String beid)
    {
        this.beid = beid;
    }

    public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
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

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

}
