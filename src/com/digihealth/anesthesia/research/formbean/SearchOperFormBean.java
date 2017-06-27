package com.digihealth.anesthesia.research.formbean;

import com.digihealth.anesthesia.basedata.utils.UserUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchOperFormBean {

	@ApiModelProperty(value = "手术id")
	private String regOptId;

	@ApiModelProperty(value = "文书id")
	private String docId;

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

	@ApiModelProperty(value = "手术医生ID")
	private String operatorName;

	@ApiModelProperty(value = "拟施手术名称")
	private String designedOptName;

	@ApiModelProperty(value = "麻醉医生姓名")
	private String anesthetistName;

	@ApiModelProperty(value = "是否局麻;0-不是局麻，即全麻,1-是局麻")
	private String isLocalAnaes;

	@ApiModelProperty(value = "麻醉开始时间")
	private String anaesStartTime;// 麻醉开始时间

	@ApiModelProperty(value = "巡回护士")
	private String circunurseName;// 巡回护士

	@ApiModelProperty(value = "麻醉方法")
	private String anaesMethodName;// 麻醉方法

	@ApiModelProperty(value = "入pacu时间")
	private String enterTime;// 入pacu时间

	@ApiModelProperty(value = "出pacu时间")
	private String exitTime;// 出pacu时间

	@ApiModelProperty(value = "入室体温")
	private String enterTemp;// 入室体温

	@ApiModelProperty(value = "严重过敏反应原因")
	private String contents; // 严重过敏反应原因

	@ApiModelProperty(value = "过敏反应发生时间")
	private String allergicReactionTime;// 过敏反应发生时间

	@ApiModelProperty(value = "是否心跳骤停")
	private String cardiacArrest;// 是否心跳骤停

	@ApiModelProperty(value = "心跳骤停时间")
	private String cardiacArrestTime;// 心跳骤停时间

	@ApiModelProperty(value = "计划转入")
	private String planTo;// 计划转入

	@ApiModelProperty(value = "实际转入")
	private String actualTo;// 实际转入

	@ApiModelProperty(value = "是否死亡")
	private String isDeath;// 是否死亡

	@ApiModelProperty(value = "死亡时间")
	private String deathTime;// 死亡时间

	@ApiModelProperty(value = "声音嘶哑")
	private String hoarse;// 声音嘶哑

	@ApiModelProperty(value = "是否昏迷")
	private String coma;// 是否昏迷

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

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getDesignedOptName() {
		return designedOptName;
	}

	public void setDesignedOptName(String designedOptName) {
		this.designedOptName = designedOptName;
	}

	public String getAnesthetistName() {
		return anesthetistName;
	}

	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}

	public String getAnaesStartTime() {
		return anaesStartTime;
	}

	public void setAnaesStartTime(String anaesStartTime) {
		this.anaesStartTime = anaesStartTime;
	}

	public String getCircunurseName() {
		return circunurseName;
	}

	public void setCircunurseName(String circunurseName) {
		this.circunurseName = circunurseName;
	}

	public String getAnaesMethodName() {
		return anaesMethodName;
	}

	public void setAnaesMethodName(String anaesMethodName) {
		this.anaesMethodName = anaesMethodName;
	}

	public String getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

	public String getEnterTemp() {
		return enterTemp;
	}

	public void setEnterTemp(String enterTemp) {
		this.enterTemp = enterTemp;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAllergicReactionTime() {
		return allergicReactionTime;
	}

	public void setAllergicReactionTime(String allergicReactionTime) {
		this.allergicReactionTime = allergicReactionTime;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getCardiacArrest() {
		return cardiacArrest;
	}

	public void setCardiacArrest(String cardiacArrest) {
		this.cardiacArrest = cardiacArrest;
	}

	public String getCardiacArrestTime() {
		return cardiacArrestTime;
	}

	public void setCardiacArrestTime(String cardiacArrestTime) {
		this.cardiacArrestTime = cardiacArrestTime;
	}

	public String getIsDeath() {
		return isDeath;
	}

	public void setIsDeath(String isDeath) {
		this.isDeath = isDeath;
	}

	public String getDeathTime() {
		return deathTime;
	}

	public void setDeathTime(String deathTime) {
		this.deathTime = deathTime;
	}

	public String getHoarse() {
		return hoarse;
	}

	public void setHoarse(String hoarse) {
		this.hoarse = hoarse;
	}

	public String getIsLocalAnaes() {
		return isLocalAnaes;
	}

	public void setIsLocalAnaes(String isLocalAnaes) {
		this.isLocalAnaes = isLocalAnaes;
	}

	public String getComa() {
		return coma;
	}

	public void setComa(String coma) {
		this.coma = coma;
	}

	public String getPlanTo() {
		return planTo;
	}

	public void setPlanTo(String planTo) {
		this.planTo = planTo;
	}

	public String getActualTo() {
		return actualTo;
	}

	public void setActualTo(String actualTo) {
		this.actualTo = actualTo;
	}

}
