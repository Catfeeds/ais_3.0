/*
 * BasConsultation.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.List;

import com.digihealth.anesthesia.basedata.formbean.DesignedOptCodes;
import com.digihealth.anesthesia.basedata.formbean.DiagnosisCodes;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "外部会诊对象")
public class BasConsultation {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String conttId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 费用类型
     */
    @ApiModelProperty(value = "费用类型")
    private String medicalType;

    /**
     * 住院号
     */
    @ApiModelProperty(value = "住院号")
    private String hid;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 出生年月
     */
    @ApiModelProperty(value = "出生年月")
    private String birthday;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 月
     */
    @ApiModelProperty(value = "月")
    private Integer ageMon;

    /**
     * 天
     */
    @ApiModelProperty(value = "天")
    private Integer ageDay;

    /**
     * 床号
     */
    @ApiModelProperty(value = "床号")
    private String bed;

    /**
     * 病区ID
     */
    @ApiModelProperty(value = "病区ID")
    private String regionId;

    /**
     * 病区名称
     */
    @ApiModelProperty(value = "病区名称")
    private String regionName;

    /**
     * 科室ID
     */
    @ApiModelProperty(value = "科室ID")
    private String deptId;

    /**
     * 科室名称
     */
    @ApiModelProperty(value = "科室名称")
    private String deptName;

    /**
     * 拟施手术名称
     */
    @ApiModelProperty(value = "拟施手术名称")
    private String designedOptName;

    /**
     * 拟施手术CODE
     */
    @ApiModelProperty(value = "拟施手术CODE")
    private String designedOptCode;

    /**
     * 拟施诊断名称
     */
    @ApiModelProperty(value = "拟施诊断名称")
    private String diagnosisName;

    /**
     * 拟施诊断CODE
     */
    @ApiModelProperty(value = "拟施诊断CODE")
    private String diagnosisCode;

    /**
     * 会诊开始时间
     */
    @ApiModelProperty(value = "会诊开始时间")
    private String startTime;

    /**
     * 会诊结束时间
     */
    @ApiModelProperty(value = "会诊结束时间")
    private String endTime;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String createUser;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者姓名")
    private String createUserName;
    
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String createTime;

    /**
     * 是否急诊
     */
    @ApiModelProperty(value = "是否急诊")
    private Integer emergency;

    /**
     * 药物过敏
     */
    @ApiModelProperty(value = "药物过敏")
    private String hypersusceptibility;

    /**
     * 手术等级
     */
    @ApiModelProperty(value = "手术等级")
    private String optLevel;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 是否局麻
     */
    @ApiModelProperty(value = "是否局麻")
    private String isLocalAnaes;

    /**
     * 麻醉方法名称
     */
    @ApiModelProperty(value = "麻醉方法名称")
    private String designedAnaesMethodName;

    /**
     * 麻醉方法CODE
     */
    @ApiModelProperty(value = "麻醉方法CODE")
    private String designedAnaesMethodCode;

    /**
     * 手术医生ID
     */
    @ApiModelProperty(value = "手术医生ID")
    private String operatorId;

    /**
     * 手术医生名称
     */
    @ApiModelProperty(value = "手术医生名称")
    private String operatorName;

    /**
     * 身高
     */
    @ApiModelProperty(value = "身高")
    private Float height;

    /**
     * 体重
     */
    @ApiModelProperty(value = "体重")
    private Float weight;

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

	@ApiModelProperty(value = "助手医生对象")
	private List<String> assistants;

	@ApiModelProperty(value = "拟施诊断对象")
	private List<DiagnosisCodes> diagnosisCodes;

	@ApiModelProperty(value = "拟施手术对象")
	private List<DesignedOptCodes> designedOptCodes;

	@ApiModelProperty(value = "麻醉方法对象")
	private List<String> designedAnaesMethodCodes;
	
    /**
     * 基线id
     */
    @ApiModelProperty(value = "基线id")
    private String beid;

    public String getConttId() {
        return conttId;
    }

    public void setConttId(String conttId) {
        this.conttId = conttId == null ? null : conttId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMedicalType() {
        return medicalType;
    }

    public void setMedicalType(String medicalType) {
        this.medicalType = medicalType == null ? null : medicalType.trim();
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid == null ? null : hid.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
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

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed == null ? null : bed.trim();
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
        this.regionName = regionName == null ? null : regionName.trim();
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
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDesignedOptName() {
        return designedOptName;
    }

    public void setDesignedOptName(String designedOptName) {
        this.designedOptName = designedOptName == null ? null : designedOptName.trim();
    }

    public String getDesignedOptCode() {
        return designedOptCode;
    }

    public void setDesignedOptCode(String designedOptCode) {
        this.designedOptCode = designedOptCode == null ? null : designedOptCode.trim();
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName == null ? null : diagnosisName.trim();
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode == null ? null : diagnosisCode.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
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
        this.hypersusceptibility = hypersusceptibility == null ? null : hypersusceptibility.trim();
    }

    public String getOptLevel() {
        return optLevel;
    }

    public void setOptLevel(String optLevel) {
        this.optLevel = optLevel == null ? null : optLevel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsLocalAnaes() {
        return isLocalAnaes;
    }

    public void setIsLocalAnaes(String isLocalAnaes) {
        this.isLocalAnaes = isLocalAnaes == null ? null : isLocalAnaes.trim();
    }

    public String getDesignedAnaesMethodName() {
        return designedAnaesMethodName;
    }

    public void setDesignedAnaesMethodName(String designedAnaesMethodName) {
        this.designedAnaesMethodName = designedAnaesMethodName == null ? null : designedAnaesMethodName.trim();
    }

    public String getDesignedAnaesMethodCode() {
        return designedAnaesMethodCode;
    }

    public void setDesignedAnaesMethodCode(String designedAnaesMethodCode) {
        this.designedAnaesMethodCode = designedAnaesMethodCode == null ? null : designedAnaesMethodCode.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getHbsag() {
        return hbsag;
    }

    public void setHbsag(String hbsag) {
        this.hbsag = hbsag == null ? null : hbsag.trim();
    }

    public String getHcv() {
        return hcv;
    }

    public void setHcv(String hcv) {
        this.hcv = hcv == null ? null : hcv.trim();
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv == null ? null : hiv.trim();
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp == null ? null : hp.trim();
    }

    public String getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(String assistantId) {
        this.assistantId = assistantId == null ? null : assistantId.trim();
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName == null ? null : assistantName.trim();
    }

    public List<String> getAssistants() {
		return assistants;
	}

	public void setAssistants(List<String> assistants) {
		this.assistants = assistants;
	}

	public List<DiagnosisCodes> getDiagnosisCodes()
	{
		return diagnosisCodes;
	}

	public void setDiagnosisCodes(List<DiagnosisCodes> diagnosisCodes)
	{
		this.diagnosisCodes = diagnosisCodes;
	}

	public List<DesignedOptCodes> getDesignedOptCodes()
	{
		return designedOptCodes;
	}

	public void setDesignedOptCodes(List<DesignedOptCodes> designedOptCodes)
	{
		this.designedOptCodes = designedOptCodes;
	}

	public List<String> getDesignedAnaesMethodCodes() {
		return designedAnaesMethodCodes;
	}

	public void setDesignedAnaesMethodCodes(List<String> designedAnaesMethodCodes) {
		this.designedAnaesMethodCodes = designedAnaesMethodCodes;
	}

	public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}