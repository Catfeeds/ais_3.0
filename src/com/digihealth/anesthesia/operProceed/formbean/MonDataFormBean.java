package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;
import java.util.List;

public class MonDataFormBean {
	private Date time;
	private Integer freq;
	private Integer index;
	private List<MonitorData> monitorDataList;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getFreq() {
		return freq;
	}

	public void setFreq(Integer freq) {
		this.freq = freq;
	}

	public List<MonitorData> getMonitorDataList() {
		return monitorDataList;
	}

	public void setMonitorDataList(List<MonitorData> monitorDataList) {
		this.monitorDataList = monitorDataList;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}
