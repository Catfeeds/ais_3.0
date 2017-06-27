package com.digihealth.anesthesia.research.formbean;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * filter对象 Title: SciResearchFilter.java Description:
 * 
 * @author chenyong
 * @created 2016年10月21日 下午3:58:20
 */
@ApiModel(value = "查询参数对象")
public class SciResearchFilter {

	@ApiModelProperty(value = "json 对应的条件框 名称")
	private String name; // json 对应的条件框 名称

	@ApiModelProperty(value = "equal 时的 value")
	private String value; // equal 时的 value

	@ApiModelProperty(value = "type:equal between andor")
	private String type; // type:equal between andor

	@ApiModelProperty(value = "between min")
	private String bt1;// between min

	@ApiModelProperty(value = "between max")
	private String bt2; // between max

	@ApiModelProperty(value = "array对象")
	private List<SciArray> array; // array对象

	@ApiModelProperty(value = "唯一值")
	private String andor; // andor 唯一值

	@ApiModelProperty(value = "对应的父对象filter名称")
	private String pid; // 对应的父对象filter名称

	@ApiModelProperty(value = "备注")
	private String remark;

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

	public List<SciArray> getArray() {
		return array;
	}

	public void setArray(List<SciArray> array) {
		this.array = array;
	}

	public String getAndor() {
		return andor;
	}

	public void setAndor(String andor) {
		this.andor = andor;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
