package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class AnaesDocObserveTimeCount implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "姓名")
	private String name; // 姓名

	@ApiModelProperty(value = "总数")
	private Long total;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
