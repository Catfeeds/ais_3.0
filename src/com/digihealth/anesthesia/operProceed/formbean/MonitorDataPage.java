package com.digihealth.anesthesia.operProceed.formbean;

import java.util.List;

public class MonitorDataPage {
	private List<XAxisData1> xAxis;
	private List<YAxisData> yAxis;
	private List<SeriesData> series;
	private List<MonDataFormBean> monDataList;
	private Integer freq;

	public List<XAxisData1> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<XAxisData1> xAxis) {
		this.xAxis = xAxis;
	}

	public List<YAxisData> getyAxis() {
		return yAxis;
	}

	public void setyAxis(List<YAxisData> yAxis) {
		this.yAxis = yAxis;
	}

	public List<SeriesData> getSeries() {
		return series;
	}

	public void setSeries(List<SeriesData> series) {
		this.series = series;
	}

	public List<MonDataFormBean> getMonDataList() {
		return monDataList;
	}

	public void setMonDataList(List<MonDataFormBean> monDataList) {
		this.monDataList = monDataList;
	}

	public Integer getFreq() {
		return freq;
	}

	public void setFreq(Integer freq) {
		this.freq = freq;
	}

}
