package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "模板参数对象")
public class ResearchAnalysisList implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "不能为空!")
	@Size(min = 1, max = 20, message = "长度必须是1~20之间")
	@ApiModelProperty(value = "名称")
	private String name;

	@Size(max = 40, message = "长度必须小于40")
	@ApiModelProperty(value = "值")
	private String value;

	@NotEmpty(message = "不能为空!")
	@ApiModelProperty(value = "类型")
	private String type;

	@Size(max = 40, message = "长度必须小于40")
	@ApiModelProperty(value = "bt1")
	private String bt1;

	@Size(max = 40, message = "长度必须小于40")
	@ApiModelProperty(value = "bt2")
	private String bt2;

	@ApiModelProperty(value = "array")
	private List array = new ArrayList();

	@ApiModelProperty(value = "单位")
	private String unit;

	public String getUnit() {
		return org.apache.commons.lang3.StringUtils.isEmpty(unit) ? "" : unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBt1() {
		return bt1;
	}

	public void setBt1(String bt1) {
		this.bt1 = bt1;
	}

	public String getBt2() {
		return bt2;
	}

	public void setBt2(String bt2) {
		this.bt2 = bt2;
	}

	public List getArray() {
		return array;
	}

	public void setArray(List array) {
		this.array = array;
	}

}
