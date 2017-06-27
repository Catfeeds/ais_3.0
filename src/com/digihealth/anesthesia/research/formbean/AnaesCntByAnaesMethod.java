package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉方法参数对象")
public class AnaesCntByAnaesMethod implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "麻醉方法")
	private String anaMed;// 麻醉方法

	@ApiModelProperty(value = "麻醉方法名称")
	private String anaMedName;// 麻醉方法名称

	@ApiModelProperty(value = "总数")
	private Integer total;

	public String getAnaMedName() {
		return anaMedName;
	}

	public void setAnaMedName(String anaMedName) {
		this.anaMedName = anaMedName;
	}

	public String getAnaMed() {
		return anaMed;
	}

	public void setAnaMed(String anaMed) {
		this.anaMed = anaMed;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
