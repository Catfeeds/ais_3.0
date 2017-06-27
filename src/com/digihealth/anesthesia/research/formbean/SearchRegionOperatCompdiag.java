package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchRegionOperatCompdiag implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "年龄")
	private String age;

	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "病区名称")
	private String regionName;

	@ApiModelProperty(value = "住院号")
	private String hid;

	@ApiModelProperty(value = "床号")
	private String bed;

	@ApiModelProperty(value = "拟施诊断名称")
	private String diagnosisName;

	@ApiModelProperty(value = "拟施诊断名称2")
	private String diagnosisName2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getDiagnosisName2() {
		return diagnosisName2;
	}

	public void setDiagnosisName2(String diagnosisName2) {
		this.diagnosisName2 = diagnosisName2;
	}

}
