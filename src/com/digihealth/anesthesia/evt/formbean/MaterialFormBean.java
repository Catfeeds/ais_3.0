package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;

public class MaterialFormBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String sex;
	private String age;
	private String deptName;
	private String bed;
	private String realoperationName;
	private String operaDate;
	private String operatorName;
	private String circunurseName;
	private String docId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	public String getRealoperationName() {
		return realoperationName;
	}
	public void setRealoperationName(String realoperationName) {
		this.realoperationName = realoperationName;
	}
	public String getOperaDate() {
		return operaDate;
	}
	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getCircunurseName() {
		return circunurseName;
	}
	public void setCircunurseName(String circunurseName) {
		this.circunurseName = circunurseName;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	
	
	
}
