   
	 /**     
     * @discription 在此输入一句话描述此文件的作用
     * @author chengwang       
     * @created 2015-10-27 下午2:42:59    
     * tags     
     * see_to_target     
     */
    
package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.basedata.utils.UserUtils;

  
    /**        
 * Title: SafeCheckFormBean.java    
 * Description: 描述
 * @author chengwang       
 * @created 2015-10-27 下午2:42:59    
 */

public class SearchSafeCheckRegOptFormBean implements Serializable{
	
	private String name;
	private String regOptId;
	private String hid;
	private String sex;
	private String age;
	private String ageMon;
	private Integer ageDay;
	private String deptName;
	private String regionName;
	private String bed;
	private String operaDate;
	private String diagnosisName;
	private String designedOptName;
	private String designedAnaesMethodName;
	private String operatorName;
	private String anesthetistName;
	private String instrnurseName1;
	private String instrnurseName2;
	private String circunurseName1;
	private String circunurseName2;
	private String circuanesthetistName;
	private String perfusiondoctorName;
	
	public String getAge() {
		return UserUtils.getAge(age, ageMon, ageDay);
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAgeMon() {
		return ageMon;
	}
	public void setAgeMon(String ageMon) {
		this.ageMon = ageMon;
	}
	public Integer getAgeDay() {
		return ageDay;
	}
	public void setAgeDay(Integer ageDay) {
		this.ageDay = ageDay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegOptId() {
		return regOptId;
	}
	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getOperaDate() {
		return operaDate;
	}
	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
	}
	public String getDiagnosisName() {
		return diagnosisName;
	}
	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}
	public String getDesignedOptName() {
		return designedOptName;
	}
	public void setDesignedOptName(String designedOptName) {
		this.designedOptName = designedOptName;
	}
	public String getDesignedAnaesMethodName() {
		return designedAnaesMethodName;
	}
	public void setDesignedAnaesMethodName(String designedAnaesMethodName) {
		this.designedAnaesMethodName = designedAnaesMethodName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getAnesthetistName() {
		return anesthetistName;
	}
	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}
	public String getInstrnurseName1() {
		return instrnurseName1;
	}
	public void setInstrnurseName1(String instrnurseName1) {
		this.instrnurseName1 = instrnurseName1;
	}
	public String getInstrnurseName2() {
		return instrnurseName2;
	}
	public void setInstrnurseName2(String instrnurseName2) {
		this.instrnurseName2 = instrnurseName2;
	}
	public String getCircunurseName1() {
		return circunurseName1;
	}
	public void setCircunurseName1(String circunurseName1) {
		this.circunurseName1 = circunurseName1;
	}
	public String getCircunurseName2() {
		return circunurseName2;
	}
	public void setCircunurseName2(String circunurseName2) {
		this.circunurseName2 = circunurseName2;
	}
	public String getCircuanesthetistName() {
		return circuanesthetistName;
	}
	public void setCircuanesthetistName(String circuanesthetistName) {
		this.circuanesthetistName = circuanesthetistName;
	}
	public String getPerfusiondoctorName() {
		return perfusiondoctorName;
	}
	public void setPerfusiondoctorName(String perfusiondoctorName) {
		this.perfusiondoctorName = perfusiondoctorName;
	}
	
	

}
