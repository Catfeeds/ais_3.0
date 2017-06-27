package com.digihealth.anesthesia.research.formbean;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class LifeSignSeriesData {

	@ApiModelProperty(value = "监测项名称")
	private String name; // 监测项名称

	@ApiModelProperty(value = "监测项")
	private String observeId; // 监测项

	@ApiModelProperty(value = "类型")
	private String type; // line

	@ApiModelProperty(value = "对应哪个y轴")
	private Integer yAxisIndex; // 对应哪个y轴

	@ApiModelProperty(value = "数据")
	private List<Float> data; // 数据

	public LifeSignSeriesData() {
		super();
	}

	public LifeSignSeriesData(String name, String observeId, String type, Integer yAxisIndex, List<Float> data) {
		super();
		this.name = name;
		this.observeId = observeId;
		this.type = type;
		this.yAxisIndex = yAxisIndex;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObserveId() {
		return observeId;
	}

	public void setObserveId(String observeId) {
		this.observeId = observeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getyAxisIndex() {
		return yAxisIndex;
	}

	public void setyAxisIndex(Integer yAxisIndex) {
		this.yAxisIndex = yAxisIndex;
	}

	public List<Float> getData() {
		return data;
	}

	public void setData(List<Float> data) {
		this.data = data;
	}

}
