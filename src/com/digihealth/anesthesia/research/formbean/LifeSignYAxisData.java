package com.digihealth.anesthesia.research.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class LifeSignYAxisData implements Comparable<LifeSignYAxisData> {

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "类型")
	private String type;

	@ApiModelProperty(value = "最大值")
	private Integer max;

	@ApiModelProperty(value = "最小值")
	private Integer min;

	@ApiModelProperty(value = "排序")
	private Integer order; // 该字段用于排序

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

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public int compareTo(LifeSignYAxisData o) {
		return this.getOrder().compareTo(o.getOrder());
	}
}
