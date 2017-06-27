package com.digihealth.anesthesia.pacu.datasync.entity;

import java.util.ArrayList;
import java.util.List;

import com.digihealth.anesthesia.operProceed.po.BasObserveData;

// 监测记录点
public class MonitorRecord {
    private String time;
    private String freq;
    private List<BasObserveData> obsDatas;
    private String intervalTime;
    
    public MonitorRecord() {
        obsDatas = new ArrayList<BasObserveData>();
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public List<BasObserveData> getObsDatas() {
        return obsDatas;
    }

    public void setObsDatas(List<BasObserveData> obsDatas) {
        this.obsDatas = obsDatas;
    }

	public String getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}
    
}
