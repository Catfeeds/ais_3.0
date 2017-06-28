package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;
import java.util.List;

import com.digihealth.anesthesia.basedata.formbean.DocumentStateFormbean;
import com.digihealth.anesthesia.basedata.utils.UserUtils;

/**
 * 
 * Title: SearchRegOptByLoginNameAndStatu.java Description:
 * 根据登录账号和手术状态获取人员列表信息描述类
 * 
 * @author chengwang
 * @created 2015-10-9 上午10:21:21
 */
public class SearchRegOptByLoginNameAndStateFormBean implements Serializable {

	/** 描述 (@author: chengwang) */

	private static final long serialVersionUID = 1L;
	// 手术ID
	private String regOptId;
	// 姓名
	private String name;
	// 医疗费用类型
	private String medicalType;
	// 住院号
	private String hid;
	// 性别
	private String sex;
	// 出生
	private String birthday;
	// 年龄
	private String age;

	private String ageMon;

	private Integer ageDay;
	// 床号
	private String bed;
	// 病区名称
	private String regionId;
	// 病区名称
	private String regionName;
	// 科室名称
	private String deptId;
	// 科室名称
	private String deptName;
	// 拟施手术名称
	private String designedOptName;
	// 术前诊断名称
	private String diagnosisName;
	// 手术日期
	private String operaDate;
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
	// 是否局麻
	private String isLocalAnaes;
	// 拟施麻醉方法名称
	private String designedAnaesMethodName;

	private List<String> designedAnaesMethodCodes;
	// 手术医生NAME
	private String operatorName;
	// 灌注医生
	private String perfusiondoctorName;
	// 费用统计状态
	private String costsettlementState;
	// 术中状态
	private String operateState;
	private float height;
	private float weight;
	private String hbsag;
	private String hcv;
	private String hiv;
	private String hp;
	private String assistantName;
	private String reasons;
	private String documentState;
	private List<DocumentStateFormbean> documentStateList;
	private String operaTime;
	private String pacuId;

	public String getOperaTime() {
		return operaTime;
	}

	public void setOperaTime(String operaTime) {
		this.operaTime = operaTime;
	}

	public String getDocumentState() {
		return documentState;
	}

	public void setDocumentState(String documentState) {
		this.documentState = documentState;
	}

	public List<DocumentStateFormbean> getDocumentStateList() {
		return documentStateList;
	}

	public void setDocumentStateList(
			List<DocumentStateFormbean> documentStateList) {
		this.documentStateList = documentStateList;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

	public String getHbsag() {
		return hbsag;
	}

	public void setHbsag(String hbsag) {
		this.hbsag = hbsag;
	}

	public String getHcv() {
		return hcv;
	}

	public void setHcv(String hcv) {
		this.hcv = hcv;
	}

	public String getHiv() {
		return hiv;
	}

	public void setHiv(String hiv) {
		this.hiv = hiv;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getAssistantName() {
		return assistantName;
	}

	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}

	public String getOperateState() {
		return operateState;
	}

	public void setOperateState(String operateState) {
		this.operateState = operateState;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-12 下午1:49:16
	 * @return type
	 */

	public String getCostsettlementState() {
		return costsettlementState;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-12 下午1:49:16
	 * @param costsettlementState
	 */
	public void setCostsettlementState(String costsettlementState) {
		this.costsettlementState = costsettlementState;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-12 上午10:55:38
	 * @return type
	 */

	public String getAgeMon() {
		return ageMon;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-12 上午10:55:38
	 * @param ageMon
	 */
	public void setAgeMon(String ageMon) {
		this.ageMon = ageMon;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-12 上午10:55:38
	 * @return type
	 */

	public Integer getAgeDay() {
		return ageDay;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-12 上午10:55:38
	 * @param ageDay
	 */
	public void setAgeDay(Integer ageDay) {
		this.ageDay = ageDay;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午5:00:22
	 * @return type
	 */

	public String getRegOptId() {
		return regOptId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午5:00:22
	 * @param regOptId
	 */
	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午5:00:22
	 * @return type
	 */

	public String getOperRoomName() {
		return operRoomName;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午5:00:22
	 * @param operRoomName
	 */
	public void setOperRoomName(String operRoomName) {
		this.operRoomName = operRoomName;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAge() {
		return UserUtils.getAge(age, ageMon, ageDay);
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

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
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

	public String getPerfusiondoctorName() {
		return perfusiondoctorName;
	}

	public void setPerfusiondoctorName(String perfusiondoctorName) {
		this.perfusiondoctorName = perfusiondoctorName;
	}

	public String getMedicalType() {
		return medicalType;
	}

	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	public String getOptLevel() {
		return optLevel;
	}

	public void setOptLevel(String optLevel) {
		this.optLevel = optLevel;
	}

	public String getIsLocalAnaes() {
		return isLocalAnaes;
	}

	public void setIsLocalAnaes(String isLocalAnaes) {
		this.isLocalAnaes = isLocalAnaes;
	}

	public String getDesignedAnaesMethodName() {
		return designedAnaesMethodName;
	}

	public void setDesignedAnaesMethodName(String designedAnaesMethodName) {
		this.designedAnaesMethodName = designedAnaesMethodName;
	}

	public List<String> getDesignedAnaesMethodCodes() {
		return designedAnaesMethodCodes;
	}

	public void setDesignedAnaesMethodCodes(
			List<String> designedAnaesMethodCodes) {
		this.designedAnaesMethodCodes = designedAnaesMethodCodes;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPacuId() {
		return pacuId;
	}

	public void setPacuId(String pacuId) {
		this.pacuId = pacuId;
	}

}
