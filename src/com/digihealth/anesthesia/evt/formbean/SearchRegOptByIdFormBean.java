/**
 * 
 */
package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: SearchRegOptByIdFormBean.java Description: 手术申请中查看病人详细信息
 * 
 * @author chengwang
 * @created 2015-10-19 下午3:30:17
 */
@ApiModel(value = "患者详细信息参数对象")
public class SearchRegOptByIdFormBean implements Serializable {

	/** 描述 (@author: chengwang) */

	private static final long serialVersionUID = 1L;
	// 手术ID
	@ApiModelProperty(value = "患者id")
	private String regOptId;
	// 姓名
	@ApiModelProperty(value = "患者姓名")
	private String name;
	// 医疗费用类型
	@ApiModelProperty(value = "医疗费用类型")
	private String medicalType;
	// 住院号
	@ApiModelProperty(value = "住院号")
	private String hid;
	// 性别
	@ApiModelProperty(value = "性别")
	private String sex;
	// 出生
	@ApiModelProperty(value = "出生")
	private String birthday;
	// 年龄
	@ApiModelProperty(value = "年龄")
	private String age;

	@ApiModelProperty(value = "年龄月")
	private String ageMon;

	@ApiModelProperty(value = "年龄天")
	private Integer ageDay;
	// 床号
	@ApiModelProperty(value = "床号")
	private String bed;
	// 病区code
	@ApiModelProperty(value = "病区id")
	private String regionId;
	// 病区名称
	@ApiModelProperty(value = "病区名称")
	private String regionName;
	// 科室code
	@ApiModelProperty(value = "科室id")
	private String deptId;
	// 科室名称
	@ApiModelProperty(value = "科室名称")
	private String deptName;
	// 拟施手术名称
	@ApiModelProperty(value = "拟施手术CODE")
	private String designedOptCode;
	// 拟施手术名称
	@ApiModelProperty(value = "拟施手术名称")
	private String designedOptName;
	// 术前诊断名称
	@ApiModelProperty(value = "术前诊断CODE")
	private String diagnosisCode;
	// 术前诊断名称
	@ApiModelProperty(value = "术前诊断名称")
	private String diagnosisName;
	// 手术日期
	@ApiModelProperty(value = "手术日期")
	private String operaDate;
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	@ApiModelProperty(value = "结束时间")
	private String endTime;
	// 手术室名称
	@ApiModelProperty(value = "手术室名称")
	private String operRoomName;
	// 手术室名称
	@ApiModelProperty(value = "手术室id")
	private int operRoomId;
	@ApiModelProperty(value = "是否暂存;0-否,1-是")
	private Integer isHold;
	@ApiModelProperty(value = "卫生护士id")
	private String healthNurse;
	@ApiModelProperty(value = "卫生护士名字")
	private String healthNurseName;
	// 器械护士1
	@ApiModelProperty(value = "器械护士1id")
	private String instrnurseId1;
	// 器械护士2
	@ApiModelProperty(value = "器械护士2id")
	private String instrnurseId2;
	// 器械护士1
	@ApiModelProperty(value = "器械护士1名字")
	private String instrnurseName1;
	// 器械护士2
	@ApiModelProperty(value = "器械护士2名字")
	private String instrnurseName2;
	// 巡回护士1
	@ApiModelProperty(value = "巡回护士1名字")
	private String circunurseName1;
	// 巡回护士1
	@ApiModelProperty(value = "巡回护士1id")
	private String circunurseId1;
	// 巡回护士2
	@ApiModelProperty(value = "巡回护士2id")
	private String circunurseId2;
	// 巡回护士2
	@ApiModelProperty(value = "巡回护士2名字")
	private String circunurseName2;
	// 麻醉医生
	@ApiModelProperty(value = "麻醉医生名字")
	private String anesthetistName;
	// 麻醉医生
	@ApiModelProperty(value = "麻醉医生id")
	private String anesthetistId;
	// 上级麻醉医生
	@ApiModelProperty(value = "上级麻醉医生名字")
	private String circuanesthetistName;
	// 上级麻醉医生
	@ApiModelProperty(value = "上级麻醉医生id")
	private String circuanesthetistId;
	// 体重
	@ApiModelProperty(value = "体重")
	private Float weight;
	// 身高
	@ApiModelProperty(value = "身高")
	private Float height;
	// 手术状态
	@ApiModelProperty(value = "手术状态")
	private String state;

	@ApiModelProperty(value = "状态名称")
	private String stateName;
	// 是否是急诊
	@ApiModelProperty(value = "是否是急诊")
	private Integer emergency;
	// 药物过敏
	@ApiModelProperty(value = "药物过敏")
	private String hypersusceptibility;
	// 手术等级
	@ApiModelProperty(value = "手术等级")
	private String optLevel;
	// 是否局麻
	@ApiModelProperty(value = "是否局麻")
	private String isLocalAnaes;
	// 拟施麻醉方法Code
	@ApiModelProperty(value = "拟施麻醉方法Code")
	private String designedAnaesMethodCode;
	// 拟施麻醉方法名称
	@ApiModelProperty(value = "拟施麻醉方法名称")
	private String designedAnaesMethodName;
	// 手术医生NAME
	@ApiModelProperty(value = "手术医生名字")
	private String operatorName;
	@ApiModelProperty(value = "手术医生id")
	private String operatorId;
	@ApiModelProperty(value = "灌注医生id")
	private String perfusiondoctorId;
	// 灌注医生
	@ApiModelProperty(value = "灌注医生名字")
	private String perfusiondoctorName;
	// 费用统计状态
	@ApiModelProperty(value = "费用统计状态")
	private String costsettlementState;
	@ApiModelProperty(value = "hbsag")
	private String hbsag;
	@ApiModelProperty(value = "hcv")
	private String hcv;
	@ApiModelProperty(value = "hiv")
	private String hiv;
	@ApiModelProperty(value = "hp")
	private String hp;
	@ApiModelProperty(value = "助手医生id")
	private String assistantId;
	@ApiModelProperty(value = "助手医生名字")
	private String assistantName;
	@ApiModelProperty(value = "手术停止原因")
	private String reasons;
	@ApiModelProperty(value = "备注")
	private String remark;
	@ApiModelProperty(value = "是否门诊;0-住院,1-门诊")
	private Integer operSource;
	@ApiModelProperty(value = "切口等级")
	private Integer cutLevel;
	@ApiModelProperty(value = "台次")
	private Integer pcs;// 台次

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOperSource() {
		return operSource;
	}

	public void setOperSource(Integer operSource) {
		this.operSource = operSource;
	}

	public Integer getCutLevel() {
		return cutLevel;
	}

	public void setCutLevel(Integer cutLevel) {
		this.cutLevel = cutLevel;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

	public Float getWeight() {
		return weight;
	}

	public Float getHeight() {
		return height;
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

	public String getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(String assistantId) {
		this.assistantId = assistantId;
	}

	public String getAssistantName() {
		return assistantName;
	}

	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPerfusiondoctorId() {
		return perfusiondoctorId;
	}

	public void setPerfusiondoctorId(String perfusiondoctorId) {
		this.perfusiondoctorId = perfusiondoctorId;
	}

	public int getOperRoomId() {
		return operRoomId;
	}

	public void setOperRoomId(int operRoomId) {
		this.operRoomId = operRoomId;
	}

	public Integer getIsHold() {
		return isHold;
	}

	public void setIsHold(Integer isHold) {
		this.isHold = isHold;
	}

	public String getHealthNurse() {
		return healthNurse;
	}

	public void setHealthNurse(String healthNurse) {
		this.healthNurse = healthNurse;
	}

	public String getHealthNurseName() {
		return healthNurseName;
	}

	public void setHealthNurseName(String healthNurseName) {
		this.healthNurseName = healthNurseName;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:48:25
	 * @return type
	 */

	public String getOperatorId() {
		return operatorId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:48:25
	 * @param operatorId
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:43:31
	 * @return type
	 */

	public String getRegionId() {
		return regionId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:43:31
	 * @param regionId
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:43:31
	 * @return type
	 */

	public String getDeptId() {
		return deptId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:43:31
	 * @param deptId
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:39:32
	 * @return type
	 */

	public String getDesignedOptCode() {
		return designedOptCode;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:39:32
	 * @param designedOptCode
	 */
	public void setDesignedOptCode(String designedOptCode) {
		this.designedOptCode = designedOptCode;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:39:32
	 * @return type
	 */

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:39:32
	 * @param diagnosisCode
	 */
	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:39:32
	 * @return type
	 */

	public String getDesignedAnaesMethodCode() {
		return designedAnaesMethodCode;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:39:32
	 * @param designedAnaesMethodCode
	 */
	public void setDesignedAnaesMethodCode(String designedAnaesMethodCode) {
		this.designedAnaesMethodCode = designedAnaesMethodCode;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:55:38
	 * @return type
	 */

	public String getStartTime() {
		return startTime;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:55:38
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @return type
	 */

	public String getEndTime() {
		return endTime;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @return type
	 */

	public String getInstrnurseId1() {
		return instrnurseId1;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @param instrnurseId1
	 */
	public void setInstrnurseId1(String instrnurseId1) {
		this.instrnurseId1 = instrnurseId1;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @return type
	 */

	public String getInstrnurseId2() {
		return instrnurseId2;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @param instrnurseId2
	 */
	public void setInstrnurseId2(String instrnurseId2) {
		this.instrnurseId2 = instrnurseId2;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @return type
	 */

	public String getCircunurseId1() {
		return circunurseId1;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @param circunurseId1
	 */
	public void setCircunurseId1(String circunurseId1) {
		this.circunurseId1 = circunurseId1;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @return type
	 */

	public String getCircunurseId2() {
		return circunurseId2;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @param circunurseId2
	 */
	public void setCircunurseId2(String circunurseId2) {
		this.circunurseId2 = circunurseId2;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @return type
	 */

	public String getAnesthetistId() {
		return anesthetistId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @param anesthetistId
	 */
	public void setAnesthetistId(String anesthetistId) {
		this.anesthetistId = anesthetistId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @return type
	 */

	public String getCircuanesthetistId() {
		return circuanesthetistId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 上午10:31:15
	 * @param circuanesthetistId
	 */
	public void setCircuanesthetistId(String circuanesthetistId) {
		this.circuanesthetistId = circuanesthetistId;
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
	 * @created 2015-10-23 下午5:01:38
	 * @return type
	 */

	public String getRegOptId() {
		return regOptId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午5:01:38
	 * @param regOptId
	 */
	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午5:01:38
	 * @return type
	 */

	public String getOperRoomName() {
		return operRoomName;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午5:01:38
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

	public String getAgeMon() {
		return ageMon;
	}

	public void setAgeMon(String ageMon) {
		this.ageMon = ageMon;
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

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Integer getPcs() {
		return pcs;
	}

	public void setPcs(Integer pcs) {
		this.pcs = pcs;
	}

}
