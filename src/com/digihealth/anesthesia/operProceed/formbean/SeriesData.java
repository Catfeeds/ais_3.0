package com.digihealth.anesthesia.operProceed.formbean;

import java.util.List;

public class SeriesData {
	private String observeId;//监测项id 
	private String name; //监测项名称
	private String type; // line 
	private List<SeriesDataObj> data; //数据点
	private String symbol;  //图标
	private String symbolSvg;  //图标
	private Integer yAxisIndex; //对应哪个y轴
	private Integer symbolSize; //给前端使用的size 线的大小
	private String color;//颜色
	private String units;//单位
	private Float max; //当前监测点的最大值
	private Float min; //当前监测点的最小值

	public SeriesData() {
		super();
	}

	public SeriesData(List<SeriesDataObj> data) {
		super();
		this.data = data;
	}

	public SeriesData(String name, String type, List<SeriesDataObj> data, String symbol, Integer yAxisIndex, Integer symbolSize) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.symbol = symbol;
		this.yAxisIndex = yAxisIndex;
		this.symbolSize = symbolSize;
	}

	public SeriesData(String name, String type, List<SeriesDataObj> data, String symbol, Integer yAxisIndex, Integer symbolSize, String color) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.symbol = symbol;
		this.yAxisIndex = yAxisIndex;
		this.symbolSize = symbolSize;
		this.color = color;
	}

	public SeriesData(String name, String type, List<SeriesDataObj> data, String symbol, Integer yAxisIndex, Integer symbolSize, String color, String units) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.symbol = symbol;
		this.yAxisIndex = yAxisIndex;
		this.symbolSize = symbolSize;
		this.color = color;
		this.units = units;
	}

	public SeriesData(String observeId, String name, String type, List<SeriesDataObj> data, String symbol, Integer yAxisIndex, Integer symbolSize, String color, String units) {
		super();
		this.observeId = observeId;
		this.name = name;
		this.type = type;
		this.data = data;
		this.symbol = symbol;
		this.yAxisIndex = yAxisIndex;
		this.symbolSize = symbolSize;
		this.color = color;
		this.units = units;
	}
	
	public String getSymbolSvg() {
		return symbolSvg;
	}

	public void setSymbolSvg(String symbolSvg) {
		this.symbolSvg = symbolSvg;
	}

	public SeriesData(String observeId, String name, String type, List<SeriesDataObj> data, String symbol, Integer yAxisIndex, Integer symbolSize, String color, String units, Float max, Float min) {
		super();
		this.observeId = observeId;
		this.name = name;
		this.type = type;
		this.data = data;
		this.symbol = symbol;
		this.yAxisIndex = yAxisIndex;
		this.symbolSize = symbolSize;
		this.color = color;
		this.units = units;
		this.max = max;
		this.min = min;
	}
	
	public SeriesData(String observeId, String name, String type, List<SeriesDataObj> data, String symbol, String symbolSvg, Integer yAxisIndex, Integer symbolSize, String color, String units, Float max, Float min) {
		super();
		this.observeId = observeId;
		this.name = name;
		this.type = type;
		this.data = data;
		this.symbol = symbol;
		this.symbolSvg = symbolSvg;
		this.yAxisIndex = yAxisIndex;
		this.symbolSize = symbolSize;
		this.color = color;
		this.units = units;
		this.max = max;
		this.min = min;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<SeriesDataObj> getData() {
		return data;
	}

	public void setData(List<SeriesDataObj> data) {
		this.data = data;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getyAxisIndex() {
		return yAxisIndex;
	}

	public void setyAxisIndex(Integer yAxisIndex) {
		this.yAxisIndex = yAxisIndex;
	}

	public Integer getSymbolSize() {
		return symbolSize;
	}

	public void setSymbolSize(Integer symbolSize) {
		this.symbolSize = symbolSize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getObserveId() {
		return observeId;
	}

	public void setObserveId(String observeId) {
		this.observeId = observeId;
	}

	public Float getMax() {
		return max;
	}

	public void setMax(Float max) {
		this.max = max;
	}

	public Float getMin() {
		return min;
	}

	public void setMin(Float min) {
		this.min = min;
	}

}
