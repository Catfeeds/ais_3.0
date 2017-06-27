package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;
import java.util.List;

import com.digihealth.anesthesia.basedata.po.BasMonitorConfigFreq;

public class MonitorFreqFormBean {
	private String regOptId; // 患者id
	private List<BasMonitorConfigFreq> freqList; // 频率的list
	private Date time; // 修改频率时间

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public List<BasMonitorConfigFreq> getFreqList() {
		return freqList;
	}

	public void setFreqList(List<BasMonitorConfigFreq> freqList) {
		this.freqList = freqList;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
