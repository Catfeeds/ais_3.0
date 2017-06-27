package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

public class XAxisDataBean {
	private Date value; //即time
	private Integer freq; //间隔时间

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	public Integer getFreq() {
		return freq;
	}

	public void setFreq(Integer freq) {
		this.freq = freq;
	}

}
