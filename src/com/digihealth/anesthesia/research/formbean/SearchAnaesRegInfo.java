package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchAnaesRegInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "手术id")
	private String regOptId;

	@ApiModelProperty(value = "患者姓名")
	private String name;

	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "年龄")
	private String age;

	@ApiModelProperty(value = "月份")
	private String ageMon;

	@ApiModelProperty(value = "天")
	private Integer ageDay;

	@ApiModelProperty(value = "住院号")
	private String hid;

	@ApiModelProperty(value = "手术日期")
	private String operaDate;

	@ApiModelProperty(value = "床号")
	private String bed;

	@ApiModelProperty(value = "病区名称")
	private String regionName;

	@ApiModelProperty(value = "诊断名称")
	private String optLatterDiag; // 诊断名称

	@ApiModelProperty(value = "手术名称")
	private String optRealOper; // 手术名称

	@ApiModelProperty(value = "麻醉时长")
	private Float anaesTime; // 麻醉时长

	@ApiModelProperty(value = "麻醉医生")
	private String anaesDoc; // 麻醉医生

	@ApiModelProperty(value = "接班医生")
	private String shiftAnaesDoc; // 接班医生

	@ApiModelProperty(value = "科室")
	private String deptName;// 科室

	@ApiModelProperty(value = "拟施麻醉方法")
	private String designedAnaesMethodName;// 拟施麻醉方法

	@ApiModelProperty(value = "拟施手术名称")
	private String designedOptName;// 拟施手术名称

	@ApiModelProperty(value = "手术医生")
	private String operatorName; // 手术医生

	@ApiModelProperty(value = "实施麻醉方法")
	private String realAnaesMethod; // 实施麻醉方法

	@ApiModelProperty(value = "是否局麻;0-不是局麻，即全麻,1-是局麻")
	private String isLocalAnaes;//

	public String getIsLocalAnaes() {
		return isLocalAnaes;
	}

	public void setIsLocalAnaes(String isLocalAnaes) {
		this.isLocalAnaes = isLocalAnaes;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDesignedAnaesMethodName() {
		return designedAnaesMethodName;
	}

	public void setDesignedAnaesMethodName(String designedAnaesMethodName) {
		this.designedAnaesMethodName = designedAnaesMethodName;
	}

	public String getDesignedOptName() {
		return designedOptName;
	}

	public void setDesignedOptName(String designedOptName) {
		this.designedOptName = designedOptName;
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

	public String getOperaDate() {
		return operaDate;
	}

	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
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

	public String getOptLatterDiag() {
		return optLatterDiag;
	}

	public void setOptLatterDiag(String optLatterDiag) {
		this.optLatterDiag = optLatterDiag;
	}

	public String getOptRealOper() {
		return optRealOper;
	}

	public void setOptRealOper(String optRealOper) {
		this.optRealOper = optRealOper;
	}

	public Float getAnaesTime() {
		return anaesTime;
	}

	public void setAnaesTime(Float anaesTime) {
		this.anaesTime = anaesTime;
	}

	public String getAnaesDoc() {
		return anaesDoc;
	}

	public void setAnaesDoc(String anaesDoc) {
		this.anaesDoc = anaesDoc;
	}

	public String getShiftAnaesDoc() {
		return shiftAnaesDoc;
	}

	public void setShiftAnaesDoc(String shiftAnaesDoc) {
		this.shiftAnaesDoc = shiftAnaesDoc;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getRealAnaesMethod() {
		return realAnaesMethod;
	}

	public void setRealAnaesMethod(String realAnaesMethod) {
		this.realAnaesMethod = realAnaesMethod;
	}

}
