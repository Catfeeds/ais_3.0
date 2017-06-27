package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.basedata.utils.UserUtils;

/**
 * 
 * Title: SearchRegOptByRoomIdAndOperDateAndStatu.java Description: 术中人员列表
 * 
 * @author chengwang
 * @created 2015-10-9 下午5:35:08
 */
public class SearchRegOptByRoomIdAndOperDateAndStateFormBean implements Serializable {
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
	// 术前诊断名称
	private String diagnosisName;
	// 手术日期
	private String operaDate;
	// 身高
	private String height;
	// 体重
	private String weight;
	// 手术室名称
	private String operRoomName;
	// 器械护士1
	private String instrnurseName1;
	// 器械护士2
	private String instrnurseName2;
	// 巡回护士1
	private String circunurseName1;
	// 巡回护士2
	private String circunurseName2;
	// 麻醉医生
	private String anesthetistName;
	// 上级麻醉医生
	private String circuanesthetistName;
	// 手术状态
	private String state;
	private String stateName;
	// 是否是急诊
	private Integer emergency;
	// 药物过敏
	private String hypersusceptibility;
	// 手术等级
	private String optLevel;
	// 拟施麻醉方法名称
	private String designedAnaesMethodName;
	// 手术医生NAME
	private String operatorName;
	// 灌注医生
	private String perfusiondoctorName;

	
	
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	

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

	/**    
	 * @author chengwang       
	 * @created 2015-10-12 下午2:27:01 
	 * @return type 
	 */
	
	public Integer getAgeDay() {
		return ageDay;
	}

	/**     
	 * @author chengwang       
	 * @created 2015-10-12 下午2:27:01         
	 * @param ageDay   
	 */
	public void setAgeDay(Integer ageDay) {
		this.ageDay = ageDay;
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

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
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

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getOperaDate() {
		return operaDate;
	}

	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
	}

	

	/**    
	 * @author chengwang       
	 * @created 2015-10-23 下午5:01:02 
	 * @return type 
	 */
	
	public String getRegOptId() {
		return regOptId;
	}

	/**     
	 * @author chengwang       
	 * @created 2015-10-23 下午5:01:02         
	 * @param regOptId   
	 */
	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	/**    
	 * @author chengwang       
	 * @created 2015-10-23 下午5:01:02 
	 * @return type 
	 */
	
	public String getOperRoomName() {
		return operRoomName;
	}

	/**     
	 * @author chengwang       
	 * @created 2015-10-23 下午5:01:02         
	 * @param operRoomName   
	 */
	public void setOperRoomName(String operRoomName) {
		this.operRoomName = operRoomName;
	}

	public String getAnesthetistName() {
		return anesthetistName;
	}

	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}

	public String getCircuanesthetistName() {
		return circuanesthetistName;
	}

	public void setCircuanesthetistName(String circuanesthetistName) {
		this.circuanesthetistName = circuanesthetistName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public Integer getEmergency() {
		return emergency;
	}

	public void setEmergency(Integer emergency) {
		this.emergency = emergency;
	}

	public String getHypersusceptibility() {
		return hypersusceptibility;
	}

	public void setHypersusceptibility(String hypersusceptibility) {
		this.hypersusceptibility = hypersusceptibility;
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

	public String getPerfusiondoctorName() {
		return perfusiondoctorName;
	}

	public void setPerfusiondoctorName(String perfusiondoctorName) {
		this.perfusiondoctorName = perfusiondoctorName;
	}

}
