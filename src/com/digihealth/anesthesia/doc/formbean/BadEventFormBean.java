package com.digihealth.anesthesia.doc.formbean;

import java.io.Serializable;

/**
 * 
     * Title: BadEventFormBean.java    
     * Description: 不良时间手术基本信息
     * @author chengwang       
     * @created 2015年10月30日 上午11:44:32
 */
public class BadEventFormBean implements Serializable{

	private String deptName;
	private String bed;
	private String hid;
	private String name;
	private String sex;
	private String age;
	private int ageMon;
	private int ageDay;
	private Integer emergency;
	private String anaesStartTime;
	private String operStartTime;
	private String realDiagnosisName;
	private String realDesignedOptName;
	private String realDesignedAnaesMethodName;
	private String anesthetistName;
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
	public int getAgeMon() {
		return ageMon;
	}
	public void setAgeMon(int ageMon) {
		this.ageMon = ageMon;
	}
	public int getAgeDay() {
		return ageDay;
	}
	public void setAgeDay(int ageDay) {
		this.ageDay = ageDay;
	}
	
	public Integer getEmergency() {
		return emergency;
	}
	public void setEmergency(Integer emergency) {
		this.emergency = emergency;
	}
	public String getAnaesStartTime() {
		return anaesStartTime;
	}
	public void setAnaesStartTime(String anaesStartTime) {
		this.anaesStartTime = anaesStartTime;
	}
	public String getOperStartTime() {
		return operStartTime;
	}
	public void setOperStartTime(String operStartTime) {
		this.operStartTime = operStartTime;
	}
	public String getRealDiagnosisName() {
		return realDiagnosisName;
	}
	public void setRealDiagnosisName(String realDiagnosisName) {
		this.realDiagnosisName = realDiagnosisName;
	}
	public String getRealDesignedOptName() {
		return realDesignedOptName;
	}
	public void setRealDesignedOptName(String realDesignedOptName) {
		this.realDesignedOptName = realDesignedOptName;
	}
	public String getRealDesignedAnaesMethodName() {
		return realDesignedAnaesMethodName;
	}
	public void setRealDesignedAnaesMethodName(String realDesignedAnaesMethodName) {
		this.realDesignedAnaesMethodName = realDesignedAnaesMethodName;
	}
	public String getAnesthetistName() {
		return anesthetistName;
	}
	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}
	
	
}
