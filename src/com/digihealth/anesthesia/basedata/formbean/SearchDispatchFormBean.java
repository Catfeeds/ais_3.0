package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Project Name:ais File SearchDispatchFormBean Package
 * Name:com.digihealth.anesthesia.basedata.formbean Date:2015-10-22 上午10:31:58
 * Copyright (c) 2015, ly351x@sina.com All Rights Reserved.
 */

@ApiModel(value = "查询排程信息参数对象")
public class SearchDispatchFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 病人id
	 */
	@ApiModelProperty(value = "患者id")
	private String regOptId;

	@ApiModelProperty(value = "患者姓名")
	private String regOptName;
	/**
	 * 手术室名称
	 */
	@ApiModelProperty(value = "手术室名称")
	private String operRoomName;
	/**
	 * 手术室id
	 */
	@ApiModelProperty(value = "手术室id")
	private String operRoomId;
	/**
	 * 器械护士1的id
	 */
	@ApiModelProperty(value = "器械护士1id")
	private String instrnurseId1;

	@ApiModelProperty(value = "器械护士1")
	private String instrnurseName1;
	/**
	 * 巡回护士1的ID
	 */
	@ApiModelProperty(value = "巡回护士1id")
	private String circunurseId1;

	@ApiModelProperty(value = "巡回护士1")
	private String circunurseName1;
	/**
	 * 麻醉医生id
	 */
	@ApiModelProperty(value = "麻醉医生id")
	private String anesthetistId;

	@ApiModelProperty(value = "麻醉医生")
	private String anesthetistName;
	/**
	 * 上级麻醉医生id
	 */
	@ApiModelProperty(value = "上级麻醉医生id")
	private String circuanesthetistId;

	@ApiModelProperty(value = "上级麻醉医生")
	private String circuanesthetistName;
	/**
	 * 灌注医生id
	 */
	@ApiModelProperty(value = "灌注医生id")
	private String perfusiondoctorId;

	@ApiModelProperty(value = "灌注医生")
	private String perfusiondoctorName;
	/**
	 * 排班时间
	 */
	@ApiModelProperty(value = "排班时间")
	private String startTime;
	/**
	 * 器械护士2的id
	 */
	@ApiModelProperty(value = "器械护士2id")
	private String instrnurseId2;

	@ApiModelProperty(value = "器械护士2")
	private String instrnurseName2;
	/**
	 * 巡回护士2的id
	 */
	@ApiModelProperty(value = "巡回护士2id")
	private String circunurseId2;

	@ApiModelProperty(value = "巡回护士2")
	private String circunurseName2;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "住院号")
	private String hid;

	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "年龄")
	private String age;

	@ApiModelProperty(value = "月")
	private String ageMon;

	@ApiModelProperty(value = "天")
	private Integer ageDay;

	@ApiModelProperty(value = "拟施手术名称")
	private String designedOptName;

	@ApiModelProperty(value = "麻醉方法名称")
	private String designedAnaesMethodName;

	@ApiModelProperty(value = "拟施诊断名称")
	private String diagnosisName;

	@ApiModelProperty(value = "状态")
	private String state;

	@ApiModelProperty(value = "是否暂存;0-否,1-是")
	private String isHold;

	@ApiModelProperty(value = "卫生护士")
	private String healthNurseName;

	@ApiModelProperty(value = "卫生护士")
	private String healthNurse;

	@ApiModelProperty(value = "是否急诊;0-非急诊,1-急诊")
	private String emergency;

	@ApiModelProperty(value = "巡回护士")
	private String circunurseName;

	@ApiModelProperty(value = "器械护士")
	private String instrnurseName;

	@ApiModelProperty(value = "手术医生名称")
	private String operaDate;
	
	@ApiModelProperty(value = "手术医生名称")
	private String operatorName;

	@ApiModelProperty(value = "手术医生名称")
	private String operatorSecName;

	@ApiModelProperty(value = "是否局麻;0-不是局麻，即全麻,1-是局麻")
	private String isLocalAnaes;

	@ApiModelProperty(value = "床号")
	private String bed;

	@ApiModelProperty(value = "实际手术名称")
	private String realoperationName;

	@ApiModelProperty(value = "科室名称")
	private String deptName;

	@ApiModelProperty(value = "手术体位")
	private String optBody;

	@ApiModelProperty(value = "手术体位名称")
	private String optBodyName;

	@ApiModelProperty(value = "seq")
	private String seq;

	@ApiModelProperty(value = "助手医生")
	private String assistantName;

	@ApiModelProperty(value = "台次")
	private Integer pcs;

	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "手术等级")
	private String optLevel;
	
	@ApiModelProperty(value = "切口等级")
	private Integer cutLevel;
	
	public String getOptLevel()
    {
        return optLevel;
    }

    public void setOptLevel(String optLevel)
    {
        this.optLevel = optLevel;
    }

    public Integer getCutLevel()
    {
        return cutLevel;
    }

    public void setCutLevel(Integer cutLevel)
    {
        this.cutLevel = cutLevel;
    }

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getPcs() {
		return pcs;
	}

	public void setPcs(Integer pcs) {
		this.pcs = pcs;
	}

	public String getAssistantName() {
		return assistantName;
	}

	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
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

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getOptBodyName() {
		return optBodyName;
	}

	public void setOptBodyName(String optBodyName) {
		this.optBodyName = optBodyName;
	}

	public String getIsLocalAnaes() {
		return isLocalAnaes;
	}

	public void setIsLocalAnaes(String isLocalAnaes) {
		this.isLocalAnaes = isLocalAnaes;
	}

	public String getOptBody() {
		return optBody;
	}

	public void setOptBody(String optBody) {
		this.optBody = optBody;
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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCircunurseName() {
		return circunurseName;
	}

	public void setCircunurseName(String circunurseName) {
		this.circunurseName = circunurseName;
	}

	public String getInstrnurseName() {
		return instrnurseName;
	}

	public void setInstrnurseName(String instrnurseName) {
		this.instrnurseName = instrnurseName;
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

	public String getOperatorSecName() {
		return operatorSecName;
	}

	public void setOperatorSecName(String operatorSecName) {
		this.operatorSecName = operatorSecName;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getHealthNurseName() {
		return healthNurseName;
	}

	public void setHealthNurseName(String healthNurseName) {
		this.healthNurseName = healthNurseName;
	}

	public String getHealthNurse() {
		return healthNurse;
	}

	public void setHealthNurse(String healthNurse) {
		this.healthNurse = healthNurse;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIsHold() {
		return isHold;
	}

	public void setIsHold(String isHold) {
		this.isHold = isHold;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getRegOptName() {
		return regOptName;
	}

	public void setRegOptName(String regOptName) {
		this.regOptName = regOptName;
	}

	public String getOperRoomName() {
		return operRoomName;
	}

	public void setOperRoomName(String operRoomName) {
		this.operRoomName = operRoomName;
	}

	public String getOperRoomId() {
		return operRoomId;
	}

	public void setOperRoomId(String operRoomId) {
		this.operRoomId = operRoomId;
	}

	public String getInstrnurseId1() {
		return instrnurseId1;
	}

	public void setInstrnurseId1(String instrnurseId1) {
		this.instrnurseId1 = instrnurseId1;
	}

	public String getInstrnurseName1() {
		return instrnurseName1;
	}

	public void setInstrnurseName1(String instrnurseName1) {
		this.instrnurseName1 = instrnurseName1;
	}

	public String getCircunurseId1() {
		return circunurseId1;
	}

	public void setCircunurseId1(String circunurseId1) {
		this.circunurseId1 = circunurseId1;
	}

	public String getCircunurseName1() {
		return circunurseName1;
	}

	public void setCircunurseName1(String circunurseName1) {
		this.circunurseName1 = circunurseName1;
	}

	public String getAnesthetistId() {
		return anesthetistId;
	}

	public void setAnesthetistId(String anesthetistId) {
		this.anesthetistId = anesthetistId;
	}

	public String getAnesthetistName() {
		return anesthetistName;
	}

	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}

	public String getCircuanesthetistId() {
		return circuanesthetistId;
	}

	public void setCircuanesthetistId(String circuanesthetistId) {
		this.circuanesthetistId = circuanesthetistId;
	}

	public String getCircuanesthetistName() {
		return circuanesthetistName;
	}

	public void setCircuanesthetistName(String circuanesthetistName) {
		this.circuanesthetistName = circuanesthetistName;
	}

	public String getPerfusiondoctorId() {
		return perfusiondoctorId;
	}

	public void setPerfusiondoctorId(String perfusiondoctorId) {
		this.perfusiondoctorId = perfusiondoctorId;
	}

	public String getPerfusiondoctorName() {
		return perfusiondoctorName;
	}

	public void setPerfusiondoctorName(String perfusiondoctorName) {
		this.perfusiondoctorName = perfusiondoctorName;
	}

	public String getInstrnurseId2() {
		return instrnurseId2;
	}

	public void setInstrnurseId2(String instrnurseId2) {
		this.instrnurseId2 = instrnurseId2;
	}

	public String getInstrnurseName2() {
		return instrnurseName2;
	}

	public void setInstrnurseName2(String instrnurseName2) {
		this.instrnurseName2 = instrnurseName2;
	}

	public String getCircunurseId2() {
		return circunurseId2;
	}

	public void setCircunurseId2(String circunurseId2) {
		this.circunurseId2 = circunurseId2;
	}

	public String getCircunurseName2() {
		return circunurseName2;
	}

	public void setCircunurseName2(String circunurseName2) {
		this.circunurseName2 = circunurseName2;
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
		System.out.println(UserUtils.getAge(age, ageMon, ageDay)
				+ "______________" + getRegOptName());
		return UserUtils.getAge(age, ageMon, ageDay);
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

}
