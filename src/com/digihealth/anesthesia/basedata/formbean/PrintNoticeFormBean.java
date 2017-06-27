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
@ApiModel(value = "手术室外屏显信息参数对象")
public class PrintNoticeFormBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病人id
	 */
	@ApiModelProperty(value = "手术日期")
	private String operaDate;

	@ApiModelProperty(value = "开始时间")
	private String startTime;

	@ApiModelProperty(value = "病区名称")
	private String regionName;

	@ApiModelProperty(value = "床号")
	private String bed;

	@ApiModelProperty(value = "住院号")
	private String hid;

	@ApiModelProperty(value = "患者姓名")
	private String regOptName;

	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "拟施诊断名称")
	private String diagnosisName;

	@ApiModelProperty(value = "身高")
	private String height;

	@ApiModelProperty(value = "药物过敏")
	private String hypersusceptibility;

	@ApiModelProperty(value = "hbsag")
	private String hbsag;

	@ApiModelProperty(value = "hcv")
	private String hcv;

	@ApiModelProperty(value = "hiv")
	private String hiv;

	@ApiModelProperty(value = "hp")
	private String hp;

	@ApiModelProperty(value = "拟施手术名称")
	private String designedOptName;

	@ApiModelProperty(value = "手术体位")
	private String optBodyName;

	@ApiModelProperty(value = "麻醉方法名称")
	private String designedAnaesMethodName;

	@ApiModelProperty(value = "麻醉医生姓名")
	private String anesthetistName;

	@ApiModelProperty(value = "手术医生姓名")
	private String operatorName;

	@ApiModelProperty(value = "助手医生")
	private String assistantName;

	@ApiModelProperty(value = "手术间")
	private String operRoomName;

	@ApiModelProperty(value = "器械护士")
	private String instrnurseName;

	@ApiModelProperty(value = "巡回护士")
	private String circunurseName;

	@ApiModelProperty(value = "患者id")
	private String regOptId;

	@ApiModelProperty(value = "年龄")
	private String age;

	@ApiModelProperty(value = "月份")
	private String ageMon;

	@ApiModelProperty(value = "天")
	private Integer ageDay;

	@ApiModelProperty(value = "seq")
	private String seq;

	@ApiModelProperty(value = "术后去向")
	private String leaveTo;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "科室名称")
	private String deptName;

	@ApiModelProperty(value = "operatorSecName")
	private String operatorSecName;

	@ApiModelProperty(value = "realoperationName")
	private String realoperationName;

	@ApiModelProperty(value = "状态")
	private String state;

	@ApiModelProperty(value = "台次")
	private Integer pcs;

	@ApiModelProperty(value = "备注")
	private String remark;

	public Integer getPcs() {
		return pcs;
	}

	public void setPcs(Integer pcs) {
		this.pcs = pcs;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getOperatorSecName() {
		return operatorSecName;
	}

	public void setOperatorSecName(String operatorSecName) {
		this.operatorSecName = operatorSecName;
	}

	public String getRealoperationName() {
		return realoperationName;
	}

	public void setRealoperationName(String realoperationName) {
		this.realoperationName = realoperationName;
	}

	public String getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(String leaveTo) {
		this.leaveTo = leaveTo;
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

	public String getAge() {
		return UserUtils.getAge(age, ageMon, ageDay);
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getRegOptName() {
		return regOptName;
	}

	public void setRegOptName(String regOptName) {
		this.regOptName = regOptName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getHypersusceptibility() {
		return hypersusceptibility;
	}

	public void setHypersusceptibility(String hypersusceptibility) {
		this.hypersusceptibility = hypersusceptibility;
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

	public String getDesignedOptName() {
		return designedOptName;
	}

	public void setDesignedOptName(String designedOptName) {
		this.designedOptName = designedOptName;
	}

	public String getOptBodyName() {
		return optBodyName;
	}

	public void setOptBodyName(String optBodyName) {
		this.optBodyName = optBodyName;
	}

	public String getDesignedAnaesMethodName() {
		return designedAnaesMethodName;
	}

	public void setDesignedAnaesMethodName(String designedAnaesMethodName) {
		this.designedAnaesMethodName = designedAnaesMethodName;
	}

	public String getAnesthetistName() {
		return anesthetistName;
	}

	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}

	public String getOperatorName() {
		return operatorName;
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

	public String getOperRoomName() {
		return operRoomName;
	}

	public void setOperRoomName(String operRoomName) {
		this.operRoomName = operRoomName;
	}

	public String getInstrnurseName() {
		return instrnurseName;
	}

	public void setInstrnurseName(String instrnurseName) {
		this.instrnurseName = instrnurseName;
	}

	public String getCircunurseName() {
		return circunurseName;
	}

	public void setCircunurseName(String circunurseName) {
		this.circunurseName = circunurseName;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

}
