package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

public class MonitorData {
	private String id;
	private Float value;
	private String observeId;
	private String observeName;
	private Date time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public String getObserveId() {
		return observeId;
	}

	public void setObserveId(String observeId) {
		this.observeId = observeId;
	}

	public String getObserveName() {
		return observeName;
	}

	public void setObserveName(String observeName) {
		this.observeName = observeName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
