package com.digihealth.anesthesia.operProceed.formbean;

import java.util.List;

public class DataStatFormbean {

	private List<Series> series;
	private List<YAxisData> yAxis;
	private List<XAisData> xAxis;
	private List<SeriesPie> seriesPies;

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

	public List<SeriesPie> getSeriesPies()
	{
		return seriesPies;
	}

	public void setSeriesPies(List<SeriesPie> seriesPies)
	{
		this.seriesPies = seriesPies;
	}

	public List<YAxisData> getyAxis() {
		return yAxis;
	}

	public void setyAxis(List<YAxisData> yAxis) {
		this.yAxis = yAxis;
	}

	public List<XAisData> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<XAisData> xAxis) {
		this.xAxis = xAxis;
	}
}
