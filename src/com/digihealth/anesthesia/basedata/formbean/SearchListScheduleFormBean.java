package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchListScheduleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// 手术ID
	@ApiModelProperty(value = "患者id")
	private String regOptId;
	// 手术类型
	@ApiModelProperty(value = "手术类型")
	private String emergencyName;
	// 姓名
	@ApiModelProperty(value = "姓名")
	private String name;
	// 性别
	@ApiModelProperty(value = "性别")
	private String sex;
	// 年
	@ApiModelProperty(value = "年")
	private String age;
	// 月
	@ApiModelProperty(value = "月")
	private String ageMon;
	// 天
	@ApiModelProperty(value = "天")
	private Integer ageDay;
	// 住院号
	@ApiModelProperty(value = "住院号")
	private String hid;
	// 病区名称
	@ApiModelProperty(value = "病区名称")
	private String regionName;
	// 科室名称
	@ApiModelProperty(value = "科室名称")
	private String deptName;
	// 床号
	@ApiModelProperty(value = "床号")
	private String bed;
	// 术前诊断
	@ApiModelProperty(value = "术前诊断")
	private String diagnosisName;
	// 拟施手术
	@ApiModelProperty(value = "拟施手术")
	private String designedOptName;
	// 麻醉方法
	@ApiModelProperty(value = "麻醉方法")
	private String designedAnaesMethodName;
	// 手术医生
	@ApiModelProperty(value = "手术医生")
	private String operatorName;
	// 助手医生
	@ApiModelProperty(value = "助手医生")
	private String assistantName;
	// 手术日期
	@ApiModelProperty(value = "手术日期")
	private String operaDate;
	// 手术开始时间
	@ApiModelProperty(value = "手术开始时间")
	private String startTime;
	// 手术室ID
	@ApiModelProperty(value = "手术室ID")
	private Integer operRoomId;
	// 手术室名称
	@ApiModelProperty(value = "手术室名称")
	private String operRoomName;
	// 台次
	@ApiModelProperty(value = "台次")
	private Integer pcs;
	// 洗手护士1
	@ApiModelProperty(value = "洗手护士1")
	private String instrnurseId1;
	// 洗手护士2
	@ApiModelProperty(value = "洗手护士2")
	private String instrnurseId2;
	// 巡回护士1
	@ApiModelProperty(value = "巡回护士1")
	private String circunurseId1;
	// 巡回护士2
	@ApiModelProperty(value = "巡回护士2")
	private String circunurseId2;
	// 体位
	@ApiModelProperty(value = "体位")
	private String optBody;
	// 备注
	@ApiModelProperty(value = "备注")
	private String remark;
	// 手术麻醉医师
	@ApiModelProperty(value = "手术麻醉医师")
	private String anesthetistId;
	// 巡台麻醉医师
	@ApiModelProperty(value = "巡台麻醉医师")
	private String circuAnesthetistId;
	// 灌注医生
	@ApiModelProperty(value = "灌注医生")
	private String perfusionDoctorId;

	@ApiModelProperty(value = "是否局麻;0-不是局麻，即全麻,1-是局麻")
	private String isLocalAnaes;

	public String getIsLocalAnaes() {
		return isLocalAnaes;
	}

	public void setIsLocalAnaes(String isLocalAnaes) {
		this.isLocalAnaes = isLocalAnaes;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
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

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
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
		return operatorName
				+ (StringUtils.isEmpty(assistantName) ? "" : assistantName);
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getAssistantName() {
		return assistantName;
	}

	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}

	public String getOperaDate() {
		return operaDate;
	}

	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getOperRoomId() {
		return operRoomId;
	}

	public void setOperRoomId(Integer operRoomId) {
		this.operRoomId = operRoomId;
	}

	public String getOperRoomName() {
		return operRoomName;
	}

	public void setOperRoomName(String operRoomName) {
		this.operRoomName = operRoomName;
	}

	public Integer getPcs() {
		return pcs;
	}

	public void setPcs(Integer pcs) {
		this.pcs = pcs;
	}

	public String getInstrnurseId1() {
		return instrnurseId1;
	}

	public void setInstrnurseId1(String instrnurseId1) {
		this.instrnurseId1 = instrnurseId1;
	}

	public String getInstrnurseId2() {
		return instrnurseId2;
	}

	public void setInstrnurseId2(String instrnurseId2) {
		this.instrnurseId2 = instrnurseId2;
	}

	public String getCircunurseId1() {
		return circunurseId1;
	}

	public void setCircunurseId1(String circunurseId1) {
		this.circunurseId1 = circunurseId1;
	}

	public String getCircunurseId2() {
		return circunurseId2;
	}

	public void setCircunurseId2(String circunurseId2) {
		this.circunurseId2 = circunurseId2;
	}

	public String getOptBody() {
		return optBody;
	}

	public void setOptBody(String optBody) {
		this.optBody = optBody;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAnesthetistId() {
		return anesthetistId;
	}

	public void setAnesthetistId(String anesthetistId) {
		this.anesthetistId = anesthetistId;
	}

	public String getCircuAnesthetistId() {
		return circuAnesthetistId;
	}

	public void setCircuAnesthetistId(String circuAnesthetistId) {
		this.circuAnesthetistId = circuAnesthetistId;
	}

	public String getPerfusionDoctorId() {
		return perfusionDoctorId;
	}

	public void setPerfusionDoctorId(String perfusionDoctorId) {
		this.perfusionDoctorId = perfusionDoctorId;
	}

}
