/**
 * 
 */
package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.digihealth.anesthesia.basedata.utils.UserUtils;

/**
 * 
 * Title: SearchOperaPatrolRecordFormBean.java Description: 术中巡视信息
 * 
 * @author liukui
 * @created 2015-10-19 下午3:30:17
 */
public class SearchOperaPatrolRecordFormBean implements Serializable {


	private static final long serialVersionUID = 1L;
	// 手术ID
	private String regOptId;
	// 姓名
	private String name;
	// 住院号
	private String hid;
	// 性别
	private String sex;
	// 年龄
	private String age;
	private String ageMon;
	private Integer ageDay;
	// 床号
	private String bed;
	// 拟施手术名称
	private String designedOptName;
	// 手术日期
	private String operaDate;
	// 手术室名称
	private String operRoomName;
	// 手术室名称
	private int operRoomId;
	// 身高
	private String height;
	// 体重
	private String weight;
	// 手术状态
	private String state;
	// 手术等级
	private String optLevel;
	// 拟施麻醉方法名称
	private String designedAnaesMethodName;
	// 手术医生NAME
	private String operatorName;
	//手术状态
	private String operateState;
	//麻醉医生
	private String anaesDocName;
	//
	private String emergency;
	
	
	public String getEmergency() {
		return emergency;
	}
	public void setEmergency(String emergency) {
		this.emergency = emergency;
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
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getAnaesDocName() {
		return anaesDocName;
	}
	public void setAnaesDocName(String anaesDocName) {
		this.anaesDocName = anaesDocName;
	}
	public String getOperateState() {
		return operateState;
	}
	public void setOperateState(String operateState) {
		this.operateState = operateState;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRegOptId() {
		return regOptId;
	}
	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String getAge() {
		return this.getAge(age, ageMon, ageDay);
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getDesignedOptName() {
		return designedOptName;
	}
	public void setDesignedOptName(String designedOptName) {
		this.designedOptName = designedOptName;
	}
	public String getOperaDate() {
		return operaDate;
	}
	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
	}
	public String getOperRoomName() {
		return operRoomName;
	}
	public void setOperRoomName(String operRoomName) {
		this.operRoomName = operRoomName;
	}
	public int getOperRoomId() {
		return operRoomId;
	}
	public void setOperRoomId(int operRoomId) {
		this.operRoomId = operRoomId;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOptLevel() {
		return optLevel;
	}
	public void setOptLevel(String optLevel) {
		this.optLevel = optLevel;
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
	
	public static String getAge(String age,String ageMon,Integer ageDay){
		if(age!=null&&(!age.equals(""))&&(!age.equals("0"))){
			return age+"岁";
		}else if(age == null || age.equals("")||age.equals("0")){
			if(ageMon!=null&&(!ageMon.equals(""))&&(!ageMon.equals("0"))){
				return ageMon+"月";
			}else if(ageMon == null || ageMon.equals("")||ageMon.equals("0")){
				if(ageDay>0){
					return ageDay+"天";
				}else{
					return "";
				}
			}
		}
		return "0";
	}
}
