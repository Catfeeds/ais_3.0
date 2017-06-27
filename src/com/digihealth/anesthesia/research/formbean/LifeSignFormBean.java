package com.digihealth.anesthesia.research.formbean;

import java.util.List;

import com.digihealth.anesthesia.operProceed.formbean.LegendData;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class LifeSignFormBean {

	@ApiModelProperty(value = "x轴数据")
	private List<LifeSignXAxis1Data> xAxis;

	@ApiModelProperty(value = "series数据")
	private List<LifeSignSeriesData> series;

	@ApiModelProperty(value = "y轴数据")
	private List<LifeSignYAxisData> yAxis;

	@ApiModelProperty(value = "图例数据")
	private LegendData legend;

	public List<LifeSignXAxis1Data> getxAxis() {
		return xAxis;
	}

	public void setxAxis(List<LifeSignXAxis1Data> xAxis) {
		this.xAxis = xAxis;
	}

	public List<LifeSignSeriesData> getSeries() {
		return series;
	}

	public void setSeries(List<LifeSignSeriesData> series) {
		this.series = series;
	}

	public List<LifeSignYAxisData> getyAxis() {
		return yAxis;
	}

	public void setyAxis(List<LifeSignYAxisData> yAxis) {
		this.yAxis = yAxis;
	}

	public LegendData getLegend() {
		return legend;
	}

	public void setLegend(LegendData legend) {
		this.legend = legend;
	}

}
