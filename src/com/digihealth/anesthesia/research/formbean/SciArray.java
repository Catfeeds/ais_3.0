package com.digihealth.anesthesia.research.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "sci参数对象")
public class SciArray {

	@ApiModelProperty(value = "对应的表的column")
	private String field; //对应的表的column

	@ApiModelProperty(value = "对应的值")
	private String value; //对应的值

	@ApiModelProperty(value = "对应的名称")
	private String name; //对应的名称

	@ApiModelProperty(value = "范围最大值")
	private Integer max; //范围最大值

	@ApiModelProperty(value = "范围最小值")
	private Integer min; //范围最小值

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
