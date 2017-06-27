package com.digihealth.anesthesia.research.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class HospitalKeyOperationFormBean {

	@ApiModelProperty(value = "日期")
	private String dateName;

	@ApiModelProperty(value = "重点手术总例数")
	private String keyOperationNum;

	@ApiModelProperty(value = "死亡例数")
	private String deathNum;

	@ApiModelProperty(value = "术后非计划重返再次手术例数")
	private String returnNum;

	public HospitalKeyOperationFormBean() {
		super();
	}

	public HospitalKeyOperationFormBean(String dateName, String keyOperationNum, String deathNum, String returnNum) {
		super();
		this.dateName = dateName;
		this.keyOperationNum = keyOperationNum;
		this.deathNum = deathNum;
		this.returnNum = returnNum;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public String getKeyOperationNum() {
		return keyOperationNum;
	}

	public void setKeyOperationNum(String keyOperationNum) {
		this.keyOperationNum = keyOperationNum;
	}

	public String getDeathNum() {
		return deathNum;
	}

	public void setDeathNum(String deathNum) {
		this.deathNum = deathNum;
	}

	public String getReturnNum() {
		return returnNum;
	}

	public void setReturnNum(String returnNum) {
		this.returnNum = returnNum;
	}

}
