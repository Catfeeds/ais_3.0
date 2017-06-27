package com.digihealth.anesthesia.doc.formbean;

import java.io.Serializable;

public class OptRiskFormBean implements Serializable{

	private String name;
	private String deptName;
	private String bed;
	private String hid;
	private String realOptName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getRealOptName() {
		return realOptName;
	}
	public void setRealOptName(String realOptName) {
		this.realOptName = realOptName;
	}
	
	
	
}
