package com.digihealth.anesthesia.interfacedata.po;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: OperList.java Description: his预约
 * 
 * @author chengwang
 * @created 2015年11月12日 下午3:30:19
 */
@ApiModel(value = "查询对象")
public class OperList implements Serializable {

	@ApiModelProperty(value = "手术预约号")
	private String reservenumber;// 手术预约号

	@NotEmpty(message = "姓名不能为空!")
	@ApiModelProperty(value = "姓名")
	private String name;// 姓名

	@ApiModelProperty(value = "岁")
	private Integer age;// 岁

	@ApiModelProperty(value = "月")
	private Integer ageMon;// 月

	@ApiModelProperty(value = "天")
	private Integer ageDay;// 天

	@ApiModelProperty(value = "出生日期")
	private String birthday;// 出生日期

	@NotEmpty(message = "性别不能为空!")
	@ApiModelProperty(value = "性别")
	private String sex;// 性别

	@ApiModelProperty(value = "医疗类型 （自费、公费、医保）")
	private String medicalType;// 医疗类型 （自费、公费、医保）

	@ApiModelProperty(value = "病人证件号")
	private String credNumber;// 病人证件号

	@ApiModelProperty(value = "住院号")
	private String hid;// 住院号

	@ApiModelProperty(value = "并按号")
	private String cid;// 并按号

	@ApiModelProperty(value = "病区ID")
	private String regionId;// 病区ID

	@ApiModelProperty(value = "病区名称")
	private String regionName;// 病区名称

	@ApiModelProperty(value = "科室ID")
	private String deptId;// 科室ID

	@ApiModelProperty(value = "科室名称")
	private String deptName;// 科室名称

	@ApiModelProperty(value = "床号")
	private String bed;// 床号

	@ApiModelProperty(value = "诊断编码")
	private String diagCode;// 诊断编码

	@ApiModelProperty(value = "诊断名称")
	private String diagName;// 诊断名称

	@ApiModelProperty(value = "拟施手术编码")
	private String operCode;// 拟施手术编码

	@ApiModelProperty(value = "拟施手术名称")
	private String operName;// 拟施手术名称

	@NotEmpty(message = "手术日期不能为空!")
	@ApiModelProperty(value = "手术日期")
	private String operDate;// 手术日期

	@ApiModelProperty(value = "药物过敏")
	private String dragAllergy;// 药物过敏

	@ApiModelProperty(value = "手术级别 （一级、二级、三级、四级）")
	private String operLevel;// 手术级别 （一级、二级、三级、四级）

	@ApiModelProperty(value = "手术类型 0为择期，1为急诊")
	private String operType;// 手术类型 0为择期，1为急诊

	@ApiModelProperty(value = "麻醉类型 0为全麻，1为局麻")
	private String anaesType;// 麻醉类型 0为全麻，1为局麻

	@ApiModelProperty(value = "麻醉方法ID")
	private String anaesId;// 麻醉方法ID

	@ApiModelProperty(value = "麻醉方法名称")
	private String anaesName;// 麻醉方法名称

	@ApiModelProperty(value = "主刀医生ID")
	private String surgeryDoctorId;// 主刀医生ID

	@ApiModelProperty(value = "主刀医生名称")
	private String surgeryDoctorName;// 主刀医生名称

	@ApiModelProperty(value = "助手医生ID")
	private String operAssistantId;// 助手医生ID

	@ApiModelProperty(value = "助手医生名称")
	private String operAssistantName;// 助手医生名称

	@ApiModelProperty(value = "体重")
	private float weight;

	@ApiModelProperty(value = "身高")
	private float height;

	@ApiModelProperty(value = "hbsag")
	private String hbsag;

	@ApiModelProperty(value = "hcv")
	private String hcv;

	@ApiModelProperty(value = "hiv")
	private String hiv;

	@ApiModelProperty(value = "hp")
	private String hp;

	@ApiModelProperty(value = "创建人")
	private String createUser;

	@ApiModelProperty(value = "手术开始时间")
	private String operStartTime;

	@ApiModelProperty(value = "手术结束时间")
	private String operEndTime;

	public String getOperStartTime() {
		return operStartTime;
	}

	public void setOperStartTime(String operStartTime) {
		this.operStartTime = operStartTime;
	}

	public String getOperEndTime() {
		return operEndTime;
	}

	public void setOperEndTime(String operEndTime) {
		this.operEndTime = operEndTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getReservenumber() {
		return reservenumber;
	}

	public void setReservenumber(String reservenumber) {
		this.reservenumber = reservenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAgeMon() {
		return ageMon;
	}

	public void setAgeMon(Integer ageMon) {
		this.ageMon = ageMon;
	}

	public Integer getAgeDay() {
		return ageDay;
	}

	public void setAgeDay(Integer ageDay) {
		this.ageDay = ageDay;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMedicalType() {
		return medicalType;
	}

	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}

	public String getCredNumber() {
		return credNumber;
	}

	public void setCredNumber(String credNumber) {
		this.credNumber = credNumber;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
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

	public String getDiagCode() {
		return diagCode;
	}

	public void setDiagCode(String diagCode) {
		this.diagCode = diagCode;
	}

	public String getDiagName() {
		return diagName;
	}

	public void setDiagName(String diagName) {
		this.diagName = diagName;
	}

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getOperDate() {
		return operDate;
	}

	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}

	public String getDragAllergy() {
		return dragAllergy;
	}

	public void setDragAllergy(String dragAllergy) {
		this.dragAllergy = dragAllergy;
	}

	public String getOperLevel() {
		return operLevel;
	}

	public void setOperLevel(String operLevel) {
		this.operLevel = operLevel;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public String getAnaesType() {
		return anaesType;
	}

	public void setAnaesType(String anaesType) {
		this.anaesType = anaesType;
	}

	public String getAnaesId() {
		return anaesId;
	}

	public void setAnaesId(String anaesId) {
		this.anaesId = anaesId;
	}

	public String getAnaesName() {
		return anaesName;
	}

	public void setAnaesName(String anaesName) {
		this.anaesName = anaesName;
	}

	public String getSurgeryDoctorId() {
		return surgeryDoctorId;
	}

	public void setSurgeryDoctorId(String surgeryDoctorId) {
		this.surgeryDoctorId = surgeryDoctorId;
	}

	public String getSurgeryDoctorName() {
		return surgeryDoctorName;
	}

	public void setSurgeryDoctorName(String surgeryDoctorName) {
		this.surgeryDoctorName = surgeryDoctorName;
	}

	public String getOperAssistantId() {
		return operAssistantId;
	}

	public void setOperAssistantId(String operAssistantId) {
		this.operAssistantId = operAssistantId;
	}

	public String getOperAssistantName() {
		return operAssistantName;
	}

	public void setOperAssistantName(String operAssistantName) {
		this.operAssistantName = operAssistantName;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
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

}