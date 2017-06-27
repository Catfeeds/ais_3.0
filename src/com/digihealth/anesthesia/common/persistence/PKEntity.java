package com.digihealth.anesthesia.common.persistence;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "联合主键对象")
public class PKEntity<P> {
	@ApiModelProperty(value = "主键")
	private P id;

	@ApiModelProperty(value = "基线id")
	private String beid;

	public P getId() {
		return id;
	}

	public void setId(P id) {
		this.id = id;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

}
