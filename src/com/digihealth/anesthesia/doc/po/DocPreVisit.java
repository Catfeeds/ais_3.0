/*
 * DocPreVisit.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.List;
import java.util.Map;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "术前访视对象")
public class DocPreVisit {
	@ApiModelProperty(value = "主键id")
	private String preVisitId;

	@ApiModelProperty(value = "患者id")
	private String regOptId;

	/**
	 * 简要病史
	 */
	@ApiModelProperty(value = "简要病史")
	private String briefHis;

	/**
	 * 并存疾病
	 */
	@ApiModelProperty(value = "并存疾病")
	private String comorbidity;

	/**
	 * 药物成瘾
	 */
	@ApiModelProperty(value = "药物成瘾")
	private String drugAddiction;

	/**
	 * 药物成瘾详情
	 */
	@ApiModelProperty(value = "药物成瘾详情")
	private String drugAddictionCond;

	/**
	 * 其他并存疾病
	 */
	@ApiModelProperty(value = "其他并存疾病")
	private String othComorbidity;

	/**
	 * 心血管病史
	 */
	@ApiModelProperty(value = "心血管病史")
	private String heartBool;

	/**
	 * 呼吸系统病史
	 */
	@ApiModelProperty(value = "呼吸系统病史")
	private String lungbreath;

	/**
	 * 过敏史
	 */
	@ApiModelProperty(value = "过敏史")
	private String allergic;

	/**
	 * 过敏详情
	 */
	@ApiModelProperty(value = "过敏详情")
	private String allergicCond;

	/**
	 * 药物使用史
	 */
	@ApiModelProperty(value = "药物使用史")
	private String medHis;

	/**
	 * 糖尿病史
	 */
	@ApiModelProperty(value = "糖尿病史")
	private String diabetes;

	/**
	 * 手术麻醉史
	 */
	@ApiModelProperty(value = "手术麻醉史")
	private String anaes;

	/**
	 * 手术麻醉史
	 */
	@ApiModelProperty(value = "手术麻醉史")
	private String anaesCond;

	/**
	 * 既往手术史
	 */
	@ApiModelProperty(value = "既往手术史")
	private Integer operHis;

	/**
	 * 既往手术史
	 */
	@ApiModelProperty(value = "既往手术史")
	private String operHisCond;

	/**
	 * 血压
	 */
	@ApiModelProperty(value = "血压")
	private String bloodPre;

	/**
	 * 心率
	 */
	@ApiModelProperty(value = "心率")
	private Integer heartrate;

	/**
	 * 呼吸
	 */
	@ApiModelProperty(value = "呼吸")
	private Integer breath;

	/**
	 * 器官正常
	 */
	@ApiModelProperty(value = "器官正常")
	private String organNormal;

	/**
	 * 器官异常
	 */
	@ApiModelProperty(value = "器官异常")
	private String organAbnormal;

	/**
	 * 其他情况
	 */
	@ApiModelProperty(value = "其他情况")
	private String other1;

	/**
	 * 麻醉前评估分级
	 */
	@ApiModelProperty(value = "麻醉前评估分级")
	private String preAnesEvaLevel;

	/**
	 * 全身情况分级
	 */
	@ApiModelProperty(value = "全身情况分级")
	private String situationLevel;

	/**
	 * 手术分级
	 */
	@ApiModelProperty(value = "手术分级")
	private String operationLevel;

	/**
	 * 患者年龄
	 */
	@ApiModelProperty(value = "患者年龄")
	private String preAge;

	/**
	 * 麻醉前评估分级
	 */
	@ApiModelProperty(value = "麻醉前评估分级")
	private String preAnesEvaLevel1;

	/**
	 * 麻醉危险性
	 */
	@ApiModelProperty(value = "麻醉危险性")
	private String anaesDanger;

	@ApiModelProperty(value = "其他2")
	private String other2;

	@ApiModelProperty(value = "麻醉医生id")
	private String anaestheitistId;

	@ApiModelProperty(value = "signDate")
	private String signDate;

	@ApiModelProperty(value = "是否完成")
	private String processState;

	/**
	 * 麻醉监测
	 */
	@ApiModelProperty(value = "麻醉监测")
	private String anaesMonitor;

	/**
	 * 麻醉有关措施
	 */
	@ApiModelProperty(value = "麻醉有关措施")
	private String anaesStep;

	/**
	 * 妊娠
	 */
	@ApiModelProperty(value = "妊娠")
	private Integer gestationTime;

	/**
	 * 心血管病史详情
	 */
	@ApiModelProperty(value = "心血管病史详情")
	private String heartBoolCond;

	/**
	 * 心血管病史时间
	 */
	@ApiModelProperty(value = "心血管病史时间")
	private String heartBoolRegion;

	/**
	 * 心血管病史其他
	 */
	@ApiModelProperty(value = "心血管病史其他")
	private String heartBoolOther;

	/**
	 * 呼吸系统病史详情
	 */
	@ApiModelProperty(value = "呼吸系统病史详情")
	private String lungbreathCond;

	/**
	 * 呼吸系统病史其他
	 */
	@ApiModelProperty(value = "呼吸系统病史其他")
	private String lungbreathOther;

	/**
	 * 脑神经病史
	 */
	@ApiModelProperty(value = "脑神经病史")
	private String brainNerve;

	/**
	 * 脑神经病史其他
	 */
	@ApiModelProperty(value = "脑神经病史其他")
	private String brainNerveOther;

	/**
	 * 脊柱与四肢疾病
	 */
	@ApiModelProperty(value = "脊柱与四肢疾病")
	private String spineLimb;

	/**
	 * 截瘫
	 */
	@ApiModelProperty(value = "截瘫")
	private String paraplegia;

	/**
	 * 脊柱与四肢疾病其他
	 */
	@ApiModelProperty(value = "脊柱与四肢疾病其他")
	private String spineLimbOther;

	/**
	 * 肢体感觉运动障碍
	 */
	@ApiModelProperty(value = "肢体感觉运动障碍")
	private String limbDyskinesia;

	/**
	 * 肢体感觉运动障碍其他
	 */
	@ApiModelProperty(value = "肢体感觉运动障碍其他")
	private String limbDyskinesiaOther;

	/**
	 * 血液系统疾病
	 */
	@ApiModelProperty(value = "血液系统疾病")
	private String blood;

	/**
	 * 血液系统疾病其他
	 */
	@ApiModelProperty(value = "血液系统疾病其他")
	private String bloodOther;

	/**
	 * 肾脏疾病
	 */
	@ApiModelProperty(value = "肾脏疾病")
	private String kidney;

	@ApiModelProperty(value = "kidneyCond")
	private String kidneyCond;

	/**
	 * 肾脏疾病其他
	 */
	@ApiModelProperty(value = "肾脏疾病其他")
	private String kidneyOther;

	/**
	 * 消化系统疾病
	 */
	@ApiModelProperty(value = "消化系统疾病")
	private String digestion;

	/**
	 * 消化系统疾病其他
	 */
	@ApiModelProperty(value = "消化系统疾病其他")
	private String digestionOther;

	/**
	 * 内分泌系统疾病
	 */
	@ApiModelProperty(value = "内分泌系统疾病")
	private String endocrine;

	/**
	 * 内分泌系统疾病其他
	 */
	@ApiModelProperty(value = "内分泌系统疾病其他")
	private String endocrineOther;

	/**
	 * 传染病
	 */
	@ApiModelProperty(value = "传染病")
	private String infectious;

	/**
	 * 传染病其他
	 */
	@ApiModelProperty(value = "传染病其他")
	private String infectiousOther;

	/**
	 * 酗酒
	 */
	@ApiModelProperty(value = "酗酒")
	private String alcoholism;

	/**
	 * 酗酒时间
	 */
	@ApiModelProperty(value = "酗酒时间")
	private Integer alcoholismTime;

	/**
	 * 酗酒频率
	 */
	@ApiModelProperty(value = "酗酒频率")
	private Integer alcoholismFreq;

	/**
	 * 吸烟
	 */
	@ApiModelProperty(value = "吸烟")
	private String smoking;

	/**
	 * 吸烟时间
	 */
	@ApiModelProperty(value = "吸烟时间")
	private Integer smokingTime;

	/**
	 * 吸烟频率
	 */
	@ApiModelProperty(value = "吸烟频率")
	private Integer smokingFreq;

	/**
	 * 特殊用药
	 */
	@ApiModelProperty(value = "特殊用药")
	private String specialTreatment;

	/**
	 * 特殊用药详情
	 */
	@ApiModelProperty(value = "特殊用药详情")
	private String specialTreatmentCond;

	/**
	 * 血压、体温、心率、呼吸异常
	 */
	@ApiModelProperty(value = "血压、体温、心率、呼吸异常")
	private String vitalSignsAbnormal;

	/**
	 * 意识
	 */
	@ApiModelProperty(value = "意识")
	private String awareness;

	/**
	 * 气道评估Mallampatis分级
	 */
	@ApiModelProperty(value = "气道评估Mallampatis分级")
	private String mallampatis;

	/**
	 * 甲骸间距及张口度小
	 */
	@ApiModelProperty(value = "甲骸间距及张口度小")
	private String bonesPitch;

	/**
	 * 头颈活动受限
	 */
	@ApiModelProperty(value = "头颈活动受限")
	private String neckRestricted;

	/**
	 * 心胸异常
	 */
	@ApiModelProperty(value = "心胸异常")
	private String cardiothoracicAbnormal;

	/**
	 * 牙齿异常
	 */
	@ApiModelProperty(value = "牙齿异常")
	private String toothAbnormal;

	/**
	 * 牙齿异常详情
	 */
	@ApiModelProperty(value = "牙齿异常详情")
	private String toothAbnormalCond;

	/**
	 * 牙齿异常其他
	 */
	@ApiModelProperty(value = "牙齿异常其他")
	private String toothAbnormalOther;

	/**
	 * 肢体感觉与运动异常
	 */
	@ApiModelProperty(value = "肢体感觉与运动异常")
	private String motionAbnormal;

	/**
	 * Allens Test
	 */
	@ApiModelProperty(value = "Allens Test")
	private String allensTest;

	/**
	 * 体格检查说明及其他
	 */
	@ApiModelProperty(value = "体格检查说明及其他")
	private String physicalOther;

	/**
	 * 与麻醉相关的化验检查异常
	 */
	@ApiModelProperty(value = "与麻醉相关的化验检查异常")
	private String assayAbnormal;

	/**
	 * 与麻醉相关的化验检查异常详情
	 */
	@ApiModelProperty(value = "与麻醉相关的化验检查异常详情")
	private String assayAbnormalCond;

	/**
	 * 与麻醉相关的影像学检查异常其他
	 */
	@ApiModelProperty(value = "与麻醉相关的影像学检查异常其他")
	private String assayAbnormalOther;

	/**
	 * 与麻醉相关的影像学检查异常
	 */
	@ApiModelProperty(value = "与麻醉相关的影像学检查异常")
	private String videographyAbnormal;

	/**
	 * 心电图异常
	 */
	@ApiModelProperty(value = "心电图异常")
	private String ECGAbnormal;

	/**
	 * 辅助检查说明及其他
	 */
	@ApiModelProperty(value = "辅助检查说明及其他")
	private String auxiliaryOther;

	/**
	 * ASA分级
	 */
	@ApiModelProperty(value = "ASA分级")
	private String asa;

	/**
	 * 心功能分级
	 */
	@ApiModelProperty(value = "心功能分级")
	private String nyha;

	/**
	 * 特殊情况与防范措施
	 */
	@ApiModelProperty(value = "特殊情况与防范措施")
	private String specialcasePrecautions;

	@ApiModelProperty(value = "麻醉方法CODE")
	private String designedAnaesCode;

	/**
	 * 拟行麻醉
	 */
	@ApiModelProperty(value = "拟行麻醉")
	private String designedAnaes;

	/**
	 * 气道管理
	 */
	@ApiModelProperty(value = "气道管理")
	private String airwayManage;

	/**
	 * 特殊处理
	 */
	@ApiModelProperty(value = "特殊处理")
	private String specialHandle;

	/**
	 * 术后镇痛
	 */
	@ApiModelProperty(value = "术后镇痛")
	private String analgesic;

	/**
	 * 术后镇痛详情
	 */
	@ApiModelProperty(value = "术后镇痛详情")
	private String analgesicCond;

	/**
	 * 术中监测
	 */
	@ApiModelProperty(value = "术中监测")
	private String monitor;

	/**
	 * 术后去向
	 */
	@ApiModelProperty(value = "术后去向")
	private String leaveTo;

	/**
	 * 麻醉前评估其他
	 */
	@ApiModelProperty(value = "麻醉前评估其他")
	private String evaluationOther;

	@ApiModelProperty(value = "麻醉医生姓名")
	private String anaestheitistName;

	@ApiModelProperty(value = "拟行麻醉集合")
	private List<String> designedAnaesList;

	@ApiModelProperty(value = "简要病史对象")
	private Map<String, Object> briefHisMap;

	@ApiModelProperty(value = "心血管病史详情对象")
	private Map<String, Object> heartBoolCondMap;

	@ApiModelProperty(value = "呼吸系统病史详情对象")
	private Map<String, Object> lungbreathCondMap;

	@ApiModelProperty(value = "脑神经病史对象")
	private Map<String, Object> brainNerveMap;

	@ApiModelProperty(value = "脊柱与四肢疾病对象")
	private Map<String, Object> spineLimbMap;

	@ApiModelProperty(value = "血液系统疾病对象")
	private Map<String, Object> bloodMap;

	@ApiModelProperty(value = "消化系统疾病对象")
	private Map<String, Object> digestionMap;

	@ApiModelProperty(value = "内分泌系统疾病对象")
	private Map<String, Object> endocrineMap;

	@ApiModelProperty(value = "传染病对象")
	private Map<String, Object> infectiousMap;

	@ApiModelProperty(value = "牙齿异常对象")
	private Map<String, Object> toothAbnormalMap;

	@ApiModelProperty(value = "与麻醉相关的化验检查异常对象")
	private Map<String, Object> assayAbnormalMap;

	@ApiModelProperty(value = "气道管理对象")
	private Map<String, Object> airwayManageMap;

	@ApiModelProperty(value = "特殊处理对象")
	private Map<String, Object> specialHandleMap;

	@ApiModelProperty(value = "术后镇痛对象")
	private Map<String, Object> analgesicMap;

	@ApiModelProperty(value = "术中监测对象")
	private Map<String, Object> monitorMap;
	
	private Map specialTreatmentCondMap;

	/**
     * 其他病史详情
     */
	@ApiModelProperty(value = "其他病史详情")
    private String otherBriefHisCond;

    /**
     * 气管偏移
     */
	@ApiModelProperty(value = "气管偏移")
    private String tracheaOffset;

    /**
     * 心彩超及左心功能异常
     */
	@ApiModelProperty(value = "心彩超及左心功能异常")
    private String ucgAbnormal;

    /**
     * EF
     */
	@ApiModelProperty(value = "EF")
    private String ef;

    /**
     * 其他问题
     */
	@ApiModelProperty(value = "其他问题")
    private String otherProblem;

    /**
     * 其他措施
     */
	@ApiModelProperty(value = "其他措施")
    private String otherMeasures;

	public String getPreVisitId() {
		return preVisitId;
	}

	public void setPreVisitId(String preVisitId) {
		this.preVisitId = preVisitId == null ? null : preVisitId.trim();
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId == null ? null : regOptId.trim();
	}

	public String getBriefHis() {
		return briefHis;
	}

	public void setBriefHis(String briefHis) {
		this.briefHis = briefHis == null ? null : briefHis.trim();
	}

	public String getComorbidity() {
		return comorbidity;
	}

	public void setComorbidity(String comorbidity) {
		this.comorbidity = comorbidity == null ? null : comorbidity.trim();
	}

	public String getDrugAddiction() {
		return drugAddiction;
	}

	public void setDrugAddiction(String drugAddiction) {
		this.drugAddiction = drugAddiction == null ? null : drugAddiction
				.trim();
	}

	public String getDrugAddictionCond() {
		return drugAddictionCond;
	}

	public void setDrugAddictionCond(String drugAddictionCond) {
		this.drugAddictionCond = drugAddictionCond == null ? null
				: drugAddictionCond.trim();
	}

	public String getOthComorbidity() {
		return othComorbidity;
	}

	public void setOthComorbidity(String othComorbidity) {
		this.othComorbidity = othComorbidity == null ? null : othComorbidity
				.trim();
	}

	public String getLungbreath() {
		return lungbreath;
	}

	public void setLungbreath(String lungbreath) {
		this.lungbreath = lungbreath == null ? null : lungbreath.trim();
	}

	public String getAllergic() {
		return allergic;
	}

	public void setAllergic(String allergic) {
		this.allergic = allergic == null ? null : allergic.trim();
	}

	public String getAllergicCond() {
		return allergicCond;
	}

	public void setAllergicCond(String allergicCond) {
		this.allergicCond = allergicCond == null ? null : allergicCond.trim();
	}

	public String getMedHis() {
		return medHis;
	}

	public void setMedHis(String medHis) {
		this.medHis = medHis == null ? null : medHis.trim();
	}

	public String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes == null ? null : diabetes.trim();
	}

	public String getAnaes() {
		return anaes;
	}

	public void setAnaes(String anaes) {
		this.anaes = anaes == null ? null : anaes.trim();
	}

	public String getAnaesCond() {
		return anaesCond;
	}

	public void setAnaesCond(String anaesCond) {
		this.anaesCond = anaesCond == null ? null : anaesCond.trim();
	}

	public Integer getOperHis() {
		return operHis;
	}

	public void setOperHis(Integer operHis) {
		this.operHis = operHis;
	}

	public String getOperHisCond() {
		return operHisCond;
	}

	public void setOperHisCond(String operHisCond) {
		this.operHisCond = operHisCond == null ? null : operHisCond.trim();
	}

	public Integer getHeartrate() {
		return heartrate;
	}

	public void setHeartrate(Integer heartrate) {
		this.heartrate = heartrate;
	}

	public Integer getBreath() {
		return breath;
	}

	public void setBreath(Integer breath) {
		this.breath = breath;
	}

	public String getOrganNormal() {
		return organNormal;
	}

	public void setOrganNormal(String organNormal) {
		this.organNormal = organNormal == null ? null : organNormal.trim();
	}

	public String getOrganAbnormal() {
		return organAbnormal;
	}

	public void setOrganAbnormal(String organAbnormal) {
		this.organAbnormal = organAbnormal == null ? null : organAbnormal
				.trim();
	}

	public String getOther1() {
		return other1;
	}

	public void setOther1(String other1) {
		this.other1 = other1 == null ? null : other1.trim();
	}

	public String getPreAnesEvaLevel() {
		return preAnesEvaLevel;
	}

	public void setPreAnesEvaLevel(String preAnesEvaLevel) {
		this.preAnesEvaLevel = preAnesEvaLevel == null ? null : preAnesEvaLevel
				.trim();
	}

	public String getSituationLevel() {
		return situationLevel;
	}

	public void setSituationLevel(String situationLevel) {
		this.situationLevel = situationLevel == null ? null : situationLevel
				.trim();
	}

	public String getOperationLevel() {
		return operationLevel;
	}

	public void setOperationLevel(String operationLevel) {
		this.operationLevel = operationLevel == null ? null : operationLevel
				.trim();
	}

	public String getPreAge() {
		return preAge;
	}

	public void setPreAge(String preAge) {
		this.preAge = preAge == null ? null : preAge.trim();
	}

	public String getPreAnesEvaLevel1() {
		return preAnesEvaLevel1;
	}

	public void setPreAnesEvaLevel1(String preAnesEvaLevel1) {
		this.preAnesEvaLevel1 = preAnesEvaLevel1 == null ? null
				: preAnesEvaLevel1.trim();
	}

	public String getAnaesDanger() {
		return anaesDanger;
	}

	public void setAnaesDanger(String anaesDanger) {
		this.anaesDanger = anaesDanger == null ? null : anaesDanger.trim();
	}

	public String getOther2() {
		return other2;
	}

	public void setOther2(String other2) {
		this.other2 = other2 == null ? null : other2.trim();
	}

	public String getAnaestheitistId() {
		return anaestheitistId;
	}

	public void setAnaestheitistId(String anaestheitistId) {
		this.anaestheitistId = anaestheitistId == null ? null : anaestheitistId
				.trim();
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate == null ? null : signDate.trim();
	}

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState == null ? null : processState.trim();
	}

	public String getAnaesMonitor() {
		return anaesMonitor;
	}

	public void setAnaesMonitor(String anaesMonitor) {
		this.anaesMonitor = anaesMonitor == null ? null : anaesMonitor.trim();
	}

	public String getAnaesStep() {
		return anaesStep;
	}

	public void setAnaesStep(String anaesStep) {
		this.anaesStep = anaesStep == null ? null : anaesStep.trim();
	}

	public Integer getGestationTime() {
		return gestationTime;
	}

	public void setGestationTime(Integer gestationTime) {
		this.gestationTime = gestationTime;
	}

	public String getHeartBoolCond() {
		return heartBoolCond;
	}

	public void setHeartBoolCond(String heartBoolCond) {
		this.heartBoolCond = heartBoolCond == null ? null : heartBoolCond
				.trim();
	}

	public String getHeartBoolRegion() {
		return heartBoolRegion;
	}

	public void setHeartBoolRegion(String heartBoolRegion) {
		this.heartBoolRegion = heartBoolRegion == null ? null : heartBoolRegion
				.trim();
	}

	public String getHeartBoolOther() {
		return heartBoolOther;
	}

	public void setHeartBoolOther(String heartBoolOther) {
		this.heartBoolOther = heartBoolOther == null ? null : heartBoolOther
				.trim();
	}

	public String getLungbreathCond() {
		return lungbreathCond;
	}

	public void setLungbreathCond(String lungbreathCond) {
		this.lungbreathCond = lungbreathCond == null ? null : lungbreathCond
				.trim();
	}

	public String getLungbreathOther() {
		return lungbreathOther;
	}

	public void setLungbreathOther(String lungbreathOther) {
		this.lungbreathOther = lungbreathOther == null ? null : lungbreathOther
				.trim();
	}

	public String getBrainNerve() {
		return brainNerve;
	}

	public void setBrainNerve(String brainNerve) {
		this.brainNerve = brainNerve == null ? null : brainNerve.trim();
	}

	public String getBrainNerveOther() {
		return brainNerveOther;
	}

	public void setBrainNerveOther(String brainNerveOther) {
		this.brainNerveOther = brainNerveOther == null ? null : brainNerveOther
				.trim();
	}

	public String getSpineLimb() {
		return spineLimb;
	}

	public void setSpineLimb(String spineLimb) {
		this.spineLimb = spineLimb == null ? null : spineLimb.trim();
	}

	public String getParaplegia() {
		return paraplegia;
	}

	public void setParaplegia(String paraplegia) {
		this.paraplegia = paraplegia == null ? null : paraplegia.trim();
	}

	public String getSpineLimbOther() {
		return spineLimbOther;
	}

	public void setSpineLimbOther(String spineLimbOther) {
		this.spineLimbOther = spineLimbOther == null ? null : spineLimbOther
				.trim();
	}

	public String getLimbDyskinesia() {
		return limbDyskinesia;
	}

	public void setLimbDyskinesia(String limbDyskinesia) {
		this.limbDyskinesia = limbDyskinesia == null ? null : limbDyskinesia
				.trim();
	}

	public String getLimbDyskinesiaOther() {
		return limbDyskinesiaOther;
	}

	public void setLimbDyskinesiaOther(String limbDyskinesiaOther) {
		this.limbDyskinesiaOther = limbDyskinesiaOther == null ? null
				: limbDyskinesiaOther.trim();
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood == null ? null : blood.trim();
	}

	public String getBloodOther() {
		return bloodOther;
	}

	public void setBloodOther(String bloodOther) {
		this.bloodOther = bloodOther == null ? null : bloodOther.trim();
	}

	public String getKidney() {
		return kidney;
	}

	public void setKidney(String kidney) {
		this.kidney = kidney == null ? null : kidney.trim();
	}

	public String getKidneyCond() {
		return kidneyCond;
	}

	public void setKidneyCond(String kidneyCond) {
		this.kidneyCond = kidneyCond == null ? null : kidneyCond.trim();
	}

	public String getKidneyOther() {
		return kidneyOther;
	}

	public void setKidneyOther(String kidneyOther) {
		this.kidneyOther = kidneyOther == null ? null : kidneyOther.trim();
	}

	public String getDigestion() {
		return digestion;
	}

	public void setDigestion(String digestion) {
		this.digestion = digestion == null ? null : digestion.trim();
	}

	public String getDigestionOther() {
		return digestionOther;
	}

	public void setDigestionOther(String digestionOther) {
		this.digestionOther = digestionOther == null ? null : digestionOther
				.trim();
	}

	public String getEndocrine() {
		return endocrine;
	}

	public void setEndocrine(String endocrine) {
		this.endocrine = endocrine == null ? null : endocrine.trim();
	}

	public String getEndocrineOther() {
		return endocrineOther;
	}

	public void setEndocrineOther(String endocrineOther) {
		this.endocrineOther = endocrineOther == null ? null : endocrineOther
				.trim();
	}

	public String getInfectious() {
		return infectious;
	}

	public void setInfectious(String infectious) {
		this.infectious = infectious == null ? null : infectious.trim();
	}

	public String getInfectiousOther() {
		return infectiousOther;
	}

	public void setInfectiousOther(String infectiousOther) {
		this.infectiousOther = infectiousOther == null ? null : infectiousOther
				.trim();
	}

	public String getAlcoholism() {
		return alcoholism;
	}

	public void setAlcoholism(String alcoholism) {
		this.alcoholism = alcoholism == null ? null : alcoholism.trim();
	}

	public Integer getAlcoholismTime() {
		return alcoholismTime;
	}

	public void setAlcoholismTime(Integer alcoholismTime) {
		this.alcoholismTime = alcoholismTime;
	}

	public Integer getAlcoholismFreq() {
		return alcoholismFreq;
	}

	public void setAlcoholismFreq(Integer alcoholismFreq) {
		this.alcoholismFreq = alcoholismFreq;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking == null ? null : smoking.trim();
	}

	public Integer getSmokingTime() {
		return smokingTime;
	}

	public void setSmokingTime(Integer smokingTime) {
		this.smokingTime = smokingTime;
	}

	public Integer getSmokingFreq() {
		return smokingFreq;
	}

	public void setSmokingFreq(Integer smokingFreq) {
		this.smokingFreq = smokingFreq;
	}

	public String getSpecialTreatment() {
		return specialTreatment;
	}

	public void setSpecialTreatment(String specialTreatment) {
		this.specialTreatment = specialTreatment == null ? null
				: specialTreatment.trim();
	}

	public String getSpecialTreatmentCond() {
		return specialTreatmentCond;
	}

	public void setSpecialTreatmentCond(String specialTreatmentCond) {
		this.specialTreatmentCond = specialTreatmentCond == null ? null
				: specialTreatmentCond.trim();
	}

	public String getVitalSignsAbnormal() {
		return vitalSignsAbnormal;
	}

	public void setVitalSignsAbnormal(String vitalSignsAbnormal) {
		this.vitalSignsAbnormal = vitalSignsAbnormal == null ? null
				: vitalSignsAbnormal.trim();
	}

	public String getAwareness() {
		return awareness;
	}

	public void setAwareness(String awareness) {
		this.awareness = awareness == null ? null : awareness.trim();
	}

	public String getMallampatis() {
		return mallampatis;
	}

	public void setMallampatis(String mallampatis) {
		this.mallampatis = mallampatis == null ? null : mallampatis.trim();
	}

	public String getBonesPitch() {
		return bonesPitch;
	}

	public void setBonesPitch(String bonesPitch) {
		this.bonesPitch = bonesPitch == null ? null : bonesPitch.trim();
	}

	public String getNeckRestricted() {
		return neckRestricted;
	}

	public void setNeckRestricted(String neckRestricted) {
		this.neckRestricted = neckRestricted == null ? null : neckRestricted
				.trim();
	}

	public String getCardiothoracicAbnormal() {
		return cardiothoracicAbnormal;
	}

	public void setCardiothoracicAbnormal(String cardiothoracicAbnormal) {
		this.cardiothoracicAbnormal = cardiothoracicAbnormal == null ? null
				: cardiothoracicAbnormal.trim();
	}

	public String getToothAbnormal() {
		return toothAbnormal;
	}

	public void setToothAbnormal(String toothAbnormal) {
		this.toothAbnormal = toothAbnormal == null ? null : toothAbnormal
				.trim();
	}

	public String getToothAbnormalCond() {
		return toothAbnormalCond;
	}

	public void setToothAbnormalCond(String toothAbnormalCond) {
		this.toothAbnormalCond = toothAbnormalCond == null ? null
				: toothAbnormalCond.trim();
	}

	public String getToothAbnormalOther() {
		return toothAbnormalOther;
	}

	public void setToothAbnormalOther(String toothAbnormalOther) {
		this.toothAbnormalOther = toothAbnormalOther == null ? null
				: toothAbnormalOther.trim();
	}

	public String getMotionAbnormal() {
		return motionAbnormal;
	}

	public void setMotionAbnormal(String motionAbnormal) {
		this.motionAbnormal = motionAbnormal == null ? null : motionAbnormal
				.trim();
	}

	public String getAllensTest() {
		return allensTest;
	}

	public void setAllensTest(String allensTest) {
		this.allensTest = allensTest == null ? null : allensTest.trim();
	}

	public String getPhysicalOther() {
		return physicalOther;
	}

	public void setPhysicalOther(String physicalOther) {
		this.physicalOther = physicalOther == null ? null : physicalOther
				.trim();
	}

	public String getAssayAbnormal() {
		return assayAbnormal;
	}

	public void setAssayAbnormal(String assayAbnormal) {
		this.assayAbnormal = assayAbnormal == null ? null : assayAbnormal
				.trim();
	}

	public String getAssayAbnormalCond() {
		return assayAbnormalCond;
	}

	public void setAssayAbnormalCond(String assayAbnormalCond) {
		this.assayAbnormalCond = assayAbnormalCond == null ? null
				: assayAbnormalCond.trim();
	}

	public String getAssayAbnormalOther() {
		return assayAbnormalOther;
	}

	public void setAssayAbnormalOther(String assayAbnormalOther) {
		this.assayAbnormalOther = assayAbnormalOther == null ? null
				: assayAbnormalOther.trim();
	}

	public String getVideographyAbnormal() {
		return videographyAbnormal;
	}

	public void setVideographyAbnormal(String videographyAbnormal) {
		this.videographyAbnormal = videographyAbnormal == null ? null
				: videographyAbnormal.trim();
	}

	public String getECGAbnormal() {
		return ECGAbnormal;
	}

	public void setECGAbnormal(String ECGAbnormal) {
		this.ECGAbnormal = ECGAbnormal == null ? null : ECGAbnormal.trim();
	}

	public String getAuxiliaryOther() {
		return auxiliaryOther;
	}

	public void setAuxiliaryOther(String auxiliaryOther) {
		this.auxiliaryOther = auxiliaryOther == null ? null : auxiliaryOther
				.trim();
	}

	public String getAsa() {
		return asa;
	}

	public void setAsa(String asa) {
		this.asa = asa == null ? null : asa.trim();
	}

	public String getNyha() {
		return nyha;
	}

	public void setNyha(String nyha) {
		this.nyha = nyha == null ? null : nyha.trim();
	}

	public String getSpecialcasePrecautions() {
		return specialcasePrecautions;
	}

	public void setSpecialcasePrecautions(String specialcasePrecautions) {
		this.specialcasePrecautions = specialcasePrecautions == null ? null
				: specialcasePrecautions.trim();
	}

	public String getDesignedAnaesCode() {
		return designedAnaesCode;
	}

	public void setDesignedAnaesCode(String designedAnaesCode) {
		this.designedAnaesCode = designedAnaesCode == null ? null
				: designedAnaesCode.trim();
	}

	public String getDesignedAnaes() {
		return designedAnaes;
	}

	public void setDesignedAnaes(String designedAnaes) {
		this.designedAnaes = designedAnaes == null ? null : designedAnaes
				.trim();
	}

	public String getAirwayManage() {
		return airwayManage;
	}

	public void setAirwayManage(String airwayManage) {
		this.airwayManage = airwayManage == null ? null : airwayManage.trim();
	}

	public String getSpecialHandle() {
		return specialHandle;
	}

	public void setSpecialHandle(String specialHandle) {
		this.specialHandle = specialHandle == null ? null : specialHandle
				.trim();
	}

	public String getHeartBool() {
		return heartBool;
	}

	public void setHeartBool(String heartBool) {
		this.heartBool = heartBool;
	}

	public String getBloodPre() {
		return bloodPre;
	}

	public void setBloodPre(String bloodPre) {
		this.bloodPre = bloodPre;
	}

	public String getAnalgesic() {
		return analgesic;
	}

	public void setAnalgesic(String analgesic) {
		this.analgesic = analgesic == null ? null : analgesic.trim();
	}

	public String getAnalgesicCond() {
		return analgesicCond;
	}

	public void setAnalgesicCond(String analgesicCond) {
		this.analgesicCond = analgesicCond == null ? null : analgesicCond
				.trim();
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor == null ? null : monitor.trim();
	}

	public String getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(String leaveTo) {
		this.leaveTo = leaveTo == null ? null : leaveTo.trim();
	}

	public String getEvaluationOther() {
		return evaluationOther;
	}

	public void setEvaluationOther(String evaluationOther) {
		this.evaluationOther = evaluationOther == null ? null : evaluationOther
				.trim();
	}

	public Map<String, Object> getBriefHisMap() {
		return briefHisMap;
	}

	public void setBriefHisMap(Map<String, Object> briefHisMap) {
		this.briefHisMap = briefHisMap;
	}

	public Map<String, Object> getHeartBoolCondMap() {
		return heartBoolCondMap;
	}

	public void setHeartBoolCondMap(Map<String, Object> heartBoolCondMap) {
		this.heartBoolCondMap = heartBoolCondMap;
	}

	public Map<String, Object> getLungbreathCondMap() {
		return lungbreathCondMap;
	}

	public void setLungbreathCondMap(Map<String, Object> lungbreathCondMap) {
		this.lungbreathCondMap = lungbreathCondMap;
	}

	public Map<String, Object> getBrainNerveMap() {
		return brainNerveMap;
	}

	public void setBrainNerveMap(Map<String, Object> brainNerveMap) {
		this.brainNerveMap = brainNerveMap;
	}

	public Map<String, Object> getSpineLimbMap() {
		return spineLimbMap;
	}

	public void setSpineLimbMap(Map<String, Object> spineLimbMap) {
		this.spineLimbMap = spineLimbMap;
	}

	public Map<String, Object> getBloodMap() {
		return bloodMap;
	}

	public void setBloodMap(Map<String, Object> bloodMap) {
		this.bloodMap = bloodMap;
	}

	public Map<String, Object> getDigestionMap() {
		return digestionMap;
	}

	public void setDigestionMap(Map<String, Object> digestionMap) {
		this.digestionMap = digestionMap;
	}

	public Map<String, Object> getEndocrineMap() {
		return endocrineMap;
	}

	public void setEndocrineMap(Map<String, Object> endocrineMap) {
		this.endocrineMap = endocrineMap;
	}

	public Map<String, Object> getInfectiousMap() {
		return infectiousMap;
	}

	public void setInfectiousMap(Map<String, Object> infectiousMap) {
		this.infectiousMap = infectiousMap;
	}

	public Map<String, Object> getToothAbnormalMap() {
		return toothAbnormalMap;
	}

	public void setToothAbnormalMap(Map<String, Object> toothAbnormalMap) {
		this.toothAbnormalMap = toothAbnormalMap;
	}

	public Map<String, Object> getAssayAbnormalMap() {
		return assayAbnormalMap;
	}

	public void setAssayAbnormalMap(Map<String, Object> assayAbnormalMap) {
		this.assayAbnormalMap = assayAbnormalMap;
	}

	public Map<String, Object> getAirwayManageMap() {
		return airwayManageMap;
	}

	public void setAirwayManageMap(Map<String, Object> airwayManageMap) {
		this.airwayManageMap = airwayManageMap;
	}

	public Map<String, Object> getSpecialHandleMap() {
		return specialHandleMap;
	}

	public void setSpecialHandleMap(Map<String, Object> specialHandleMap) {
		this.specialHandleMap = specialHandleMap;
	}

	public Map<String, Object> getAnalgesicMap() {
		return analgesicMap;
	}

	public void setAnalgesicMap(Map<String, Object> analgesicMap) {
		this.analgesicMap = analgesicMap;
	}

	public Map<String, Object> getMonitorMap() {
		return monitorMap;
	}

	public void setMonitorMap(Map<String, Object> monitorMap) {
		this.monitorMap = monitorMap;
	}

	public String getAnaestheitistName() {
		return anaestheitistName;
	}

	public void setAnaestheitistName(String anaestheitistName) {
		this.anaestheitistName = anaestheitistName;
	}

	public List<String> getDesignedAnaesList() {
		return designedAnaesList;
	}

	public void setDesignedAnaesList(List<String> designedAnaesList) {
		this.designedAnaesList = designedAnaesList;
	}

    public String getOtherBriefHisCond()
    {
        return otherBriefHisCond;
    }

    public void setOtherBriefHisCond(String otherBriefHisCond)
    {
        this.otherBriefHisCond = otherBriefHisCond;
    }

    public String getTracheaOffset()
    {
        return tracheaOffset;
    }

    public void setTracheaOffset(String tracheaOffset)
    {
        this.tracheaOffset = tracheaOffset;
    }

    public String getUcgAbnormal()
    {
        return ucgAbnormal;
    }

    public void setUcgAbnormal(String ucgAbnormal)
    {
        this.ucgAbnormal = ucgAbnormal;
    }

    public String getEf()
    {
        return ef;
    }

    public void setEf(String ef)
    {
        this.ef = ef;
    }

    public String getOtherProblem()
    {
        return otherProblem;
    }

    public void setOtherProblem(String otherProblem)
    {
        this.otherProblem = otherProblem;
    }

    public String getOtherMeasures()
    {
        return otherMeasures;
    }

    public void setOtherMeasures(String otherMeasures)
    {
        this.otherMeasures = otherMeasures;
    }

    public Map getSpecialTreatmentCondMap()
    {
        return specialTreatmentCondMap;
    }

    public void setSpecialTreatmentCondMap(Map specialTreatmentCondMap)
    {
        this.specialTreatmentCondMap = specialTreatmentCondMap;
    }

}