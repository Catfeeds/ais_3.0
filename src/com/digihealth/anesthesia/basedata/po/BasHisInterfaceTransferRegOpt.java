/*
 * BasHisInterfaceTransferRegOpt.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="his接口的手术信息临时表对象")
public class BasHisInterfaceTransferRegOpt {
    /**
     * 患者记录标识。主键，由专用函数统一计算产生，格式：YYYYMMDDHHMMSS+4位流水号
     */
    @ApiModelProperty(value="患者记录标识")
    private String regOptId;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 性别
     */
    @ApiModelProperty(value="性别")
    private String sex;

    /**
     * 出生年月
     */
    @ApiModelProperty(value="出生年月")
    private String birthday;

    /**
     * 年龄
     */
    @ApiModelProperty(value="年龄")
    private Integer age;

    /**
     * 月
     */
    @ApiModelProperty(value="月")
    private Integer ageMon;

    /**
     * 天
     */
    @ApiModelProperty(value="天")
    private Integer ageDay;

    /**
     * 预约单号
     */
    @ApiModelProperty(value="预约单号")
    private String preengagementnumber;

    /**
     * 费用类型
     */
    @ApiModelProperty(value="费用类型")
    private String medicalType;

    /**
     * 证件号
     */
    @ApiModelProperty(value="证件号")
    private String identityNo;

    /**
     * 住院号
     */
    @ApiModelProperty(value="住院号")
    private String hid;

    /**
     * 病案号
     */
    @ApiModelProperty(value="病案号")
    private String cid;

    /**
     * 床号
     */
    @ApiModelProperty(value="床号")
    private String bed;

    /**
     * 病区ID
     */
    @ApiModelProperty(value="病区ID")
    private String regionId;

    /**
     * 病区名称
     */
    @ApiModelProperty(value="病区名称")
    private String regionName;

    /**
     * 科室ID
     */
    @ApiModelProperty(value="科室ID")
    private String deptId;

    /**
     * 科室名称
     */
    @ApiModelProperty(value="科室名称")
    private String deptName;

    /**
     * 拟施手术名称
     */
    @ApiModelProperty(value="拟施手术名称")
    private String designedOptName;

    /**
     * 拟施手术CODE
     */
    @ApiModelProperty(value="拟施手术CODE")
    private String designedOptCode;

    /**
     * 拟施诊断名称
     */
    @ApiModelProperty(value="拟施诊断名称")
    private String diagnosisName;

    /**
     * 拟施诊断CODE
     */
    @ApiModelProperty(value="拟施诊断CODE")
    private String diagnosisCode;

    /**
     * 手术日期
     */
    @ApiModelProperty(value="手术日期")
    private String operaDate;

    /**
     * 开始时间
     */
    @ApiModelProperty(value="开始时间")
    private String startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value="结束时间")
    private String endTime;

    /**
     * 创建者
     */
    @ApiModelProperty(value="创建者")
    private String createUser;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private String createTime;

    /**
     * 术后诊断名称
     */
    @ApiModelProperty(value="术后诊断名称")
    private String latierDiagName;

    /**
     * 术后诊断CODE
     */
    @ApiModelProperty(value="术后诊断CODE")
    private String latierDiagCode;

    /**
     * 实际手术名称
     */
    @ApiModelProperty(value="实际手术名称")
    private String realOperationName;

    /**
     * 实际手术CODE
     */
    @ApiModelProperty(value="实际手术CODE")
    private String realOperationCode;

    /**
     * 是否急诊;0-非急诊,1-急诊
     */
    @ApiModelProperty(value="是否急诊;0-非急诊,1-急诊")
    private Integer emergency;

    /**
     * 药物过敏
     */
    @ApiModelProperty(value="药物过敏")
    private String hyperSusceptiBility;

    /**
     * 手术等级
     */
    @ApiModelProperty(value="手术等级")
    private String optLevel;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 是否局麻;0-全麻,1-局麻
     */
    @ApiModelProperty(value="是否局麻;0-全麻,1-局麻")
    private String isLocalAnaes;

    /**
     * 麻醉方法名称
     */
    @ApiModelProperty(value="麻醉方法名称")
    private String designedAnaesMethodName;

    /**
     * 麻醉方法CODE
     */
    @ApiModelProperty(value="麻醉方法CODE")
    private String designedAnaesMethodCode;

    /**
     * 手术医生ID
     */
    @ApiModelProperty(value="手术医生ID")
    private String operatorId;

    /**
     * 手术医生名称
     */
    @ApiModelProperty(value="手术医生名称")
    private String operatorName;

    /**
     * 身高
     */
    @ApiModelProperty(value="身高")
    private Float height;

    /**
     * 体重
     */
    @ApiModelProperty(value="体重")
    private Float weight;

    /**
     * 修改手术室名称
     */
    @ApiModelProperty(value="修改手术室名称")
    private String changeOperroomReason;

    /**
     * 实际麻醉方法名称
     */
    @ApiModelProperty(value="实际麻醉方法名称")
    private String realDesignedAnaesMethodName;

    /**
     * 实际麻醉方法CODE
     */
    @ApiModelProperty(value="实际麻醉方法CODE")
    private String realDesignedAnaesMethodCode;

    @ApiModelProperty(value="hbsag")
    private String hbsag;

    @ApiModelProperty(value="hcv")
    private String hcv;

    @ApiModelProperty(value="hiv")
    private String hiv;

    @ApiModelProperty(value="hp")
    private String hp;

    /**
     * 助手id
     */
    @ApiModelProperty(value="助手id")
    private String assistantId;

    /**
     * 助手名称
     */
    @ApiModelProperty(value="助手名称")
    private String assistantName;

    /**
     * 医保号
     */
    @ApiModelProperty(value="医保号")
    private String msId;

    /**
     * 术前禁食:0-否;1-是;
     */
    @ApiModelProperty(value="术前禁食:0-否;1-是;")
    private Integer frontOperForbidTake;

    /**
     * 术前特殊情况
     */
    @ApiModelProperty(value="术前特殊情况")
    private String frontOperSpecialCase;

    /**
     * 是否门诊;0-住院,1-门诊
     */
    @ApiModelProperty(value="是否门诊;0-住院,1-门诊")
    private Integer operSource;

    /**
     * 切口等级
     */
    @ApiModelProperty(value="切口等级")
    private Integer cutLevel;

    /**
     * 来源;1-HIS,2-本地创建
     */
    @ApiModelProperty(value="来源;1-HIS,2-本地创建")
    private Integer origin;

    /**
     * 是否审核通过;0-否,1-是
     */
    @ApiModelProperty(value="是否审核通过;0-否,1-是")
    private Integer status;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getPreengagementnumber() {
        return preengagementnumber;
    }

    public void setPreengagementnumber(String preengagementnumber) {
        this.preengagementnumber = preengagementnumber == null ? null : preengagementnumber.trim();
    }

    public String getMedicalType() {
        return medicalType;
    }

    public void setMedicalType(String medicalType) {
        this.medicalType = medicalType == null ? null : medicalType.trim();
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo == null ? null : identityNo.trim();
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid == null ? null : hid.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
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
        this.regionId = regionId == null ? null : regionId.trim();
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
        this.deptId = deptId == null ? null : deptId.trim();
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

    public String getOperaDate() {
        return operaDate;
    }

    public void setOperaDate(String operaDate) {
        this.operaDate = operaDate == null ? null : operaDate.trim();
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getLatierDiagName() {
        return latierDiagName;
    }

    public void setLatierDiagName(String latierDiagName) {
        this.latierDiagName = latierDiagName == null ? null : latierDiagName.trim();
    }

    public String getLatierDiagCode() {
        return latierDiagCode;
    }

    public void setLatierDiagCode(String latierDiagCode) {
        this.latierDiagCode = latierDiagCode == null ? null : latierDiagCode.trim();
    }

    public String getRealOperationName() {
        return realOperationName;
    }

    public void setRealOperationName(String realOperationName) {
        this.realOperationName = realOperationName == null ? null : realOperationName.trim();
    }

    public String getRealOperationCode() {
        return realOperationCode;
    }

    public void setRealOperationCode(String realOperationCode) {
        this.realOperationCode = realOperationCode == null ? null : realOperationCode.trim();
    }

    public Integer getEmergency() {
        return emergency;
    }

    public void setEmergency(Integer emergency) {
        this.emergency = emergency;
    }

    public String getHyperSusceptiBility() {
        return hyperSusceptiBility;
    }

    public void setHyperSusceptiBility(String hyperSusceptiBility) {
        this.hyperSusceptiBility = hyperSusceptiBility == null ? null : hyperSusceptiBility.trim();
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

    public String getChangeOperroomReason() {
        return changeOperroomReason;
    }

    public void setChangeOperroomReason(String changeOperroomReason) {
        this.changeOperroomReason = changeOperroomReason == null ? null : changeOperroomReason.trim();
    }

    public String getRealDesignedAnaesMethodName() {
        return realDesignedAnaesMethodName;
    }

    public void setRealDesignedAnaesMethodName(String realDesignedAnaesMethodName) {
        this.realDesignedAnaesMethodName = realDesignedAnaesMethodName == null ? null : realDesignedAnaesMethodName.trim();
    }

    public String getRealDesignedAnaesMethodCode() {
        return realDesignedAnaesMethodCode;
    }

    public void setRealDesignedAnaesMethodCode(String realDesignedAnaesMethodCode) {
        this.realDesignedAnaesMethodCode = realDesignedAnaesMethodCode == null ? null : realDesignedAnaesMethodCode.trim();
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

    public String getMsId() {
        return msId;
    }

    public void setMsId(String msId) {
        this.msId = msId == null ? null : msId.trim();
    }

    public Integer getFrontOperForbidTake() {
        return frontOperForbidTake;
    }

    public void setFrontOperForbidTake(Integer frontOperForbidTake) {
        this.frontOperForbidTake = frontOperForbidTake;
    }

    public String getFrontOperSpecialCase() {
        return frontOperSpecialCase;
    }

    public void setFrontOperSpecialCase(String frontOperSpecialCase) {
        this.frontOperSpecialCase = frontOperSpecialCase == null ? null : frontOperSpecialCase.trim();
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

    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}