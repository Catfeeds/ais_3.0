package com.digihealth.anesthesia.operProceed.formbean;

import java.util.List;

import com.digihealth.anesthesia.operProceed.po.BasObserveData;

public class ObserveDataFormBean {
	private String time;
	private List<BasObserveData> observes;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<BasObserveData> getObserves() {
		return observes;
	}

	public void setObserves(List<BasObserveData> observes) {
		this.observes = observes;
	}

}
