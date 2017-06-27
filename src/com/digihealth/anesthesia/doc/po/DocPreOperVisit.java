/*
 * DocPreOperVisit.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉术前访视单对象")
public class DocPreOperVisit {
	@ApiModelProperty(value = "主键id")
	private String id;

	@ApiModelProperty(value = "患者id")
	private String regOptId;

	@ApiModelProperty(value = "是否完成")
	private String processState;

	/**
	 * 麻醉辅助措施
	 */
	@ApiModelProperty(value = "麻醉辅助措施")
	private Integer assistMeasure;

	/**
	 * 麻醉辅助措施详情
	 */
	@ApiModelProperty(value = "麻醉辅助措施详情")
	private String assistDetail;

	/**
	 * 血压收缩压
	 */
	@ApiModelProperty(value = "血压收缩压")
	private Integer SBP;

	/**
	 * 血压舒张压
	 */
	@ApiModelProperty(value = "血压舒张压")
	private Integer DBP;

	/**
	 * P
	 */
	@ApiModelProperty(value = "P")
	private Integer p;

	/**
	 * R
	 */
	@ApiModelProperty(value = "R")
	private Integer r;

	/**
	 * 依赖性药物用药史
	 */
	@ApiModelProperty(value = "依赖性药物用药史")
	private Integer drugAddiction;

	/**
	 * 药物过敏史
	 */
	@ApiModelProperty(value = "药物过敏史")
	private Integer allergic;

	/**
	 * 身体畸形
	 */
	@ApiModelProperty(value = "身体畸形")
	private Integer deformity;

	/**
	 * 颈椎活动情况
	 */
	@ApiModelProperty(value = "颈椎活动情况")
	private Integer cervicalVertebra;

	/**
	 * 张口困难
	 */
	@ApiModelProperty(value = "张口困难")
	private Integer dehisceHard;

	/**
	 * 张口度
	 */
	@ApiModelProperty(value = "张口度")
	private Integer aperture;

	/**
	 * 松牙假牙
	 */
	@ApiModelProperty(value = "松牙假牙")
	private Integer denture;

	/**
	 * 呼吸困难
	 */
	@ApiModelProperty(value = "呼吸困难")
	private Integer dyspnea;

	/**
	 * 气道评估Mallampatis分级
	 */
	@ApiModelProperty(value = "气道评估Mallampatis分级")
	private Integer mallampatis;

	/**
	 * 心脏功能分级
	 */
	@ApiModelProperty(value = "心脏功能分级")
	private Integer heartLevel;

	/**
	 * 高血压病
	 */
	@ApiModelProperty(value = "高血压病")
	private Integer hypertension;

	/**
	 * 冠心病
	 */
	@ApiModelProperty(value = "冠心病")
	private Integer coronary;

	/**
	 * 心电图
	 */
	@ApiModelProperty(value = "心电图")
	private Integer ecg;

	/**
	 * 肺功能
	 */
	@ApiModelProperty(value = "肺功能")
	private Integer lungFunc;

	/**
	 * 肺部疾病
	 */
	@ApiModelProperty(value = "肺部疾病")
	private Integer lungDisease;

	/**
	 * 内分泌系统疾病
	 */
	@ApiModelProperty(value = "内分泌系统疾病")
	private Integer endocrine;

	/**
	 * 神经系统疾病
	 */
	@ApiModelProperty(value = "神经系统疾病")
	private Integer nervous;

	/**
	 * 胸片
	 */
	@ApiModelProperty(value = "胸片")
	private Integer rabat;

	/**
	 * 肝功能
	 */
	@ApiModelProperty(value = "肝功能")
	private Integer liverFunc;

	/**
	 * 肾功能
	 */
	@ApiModelProperty(value = "肾功能")
	private Integer renalFunc;

	/**
	 * 电解质
	 */
	@ApiModelProperty(value = "电解质")
	private Integer electrolytic;

	/**
	 * 其他辅助检查情况
	 */
	@ApiModelProperty(value = "其他辅助检查情况")
	private String assistCheckOther;

	/**
	 * 禁食
	 */
	@ApiModelProperty(value = "禁食")
	private Integer fasting;

	/**
	 * 禁饮
	 */
	@ApiModelProperty(value = "禁饮")
	private Integer banDrink;

	/**
	 * 其他术前麻醉医嘱
	 */
	@ApiModelProperty(value = "其他术前麻醉医嘱")
	private String otherDocord;

	/**
	 * 病人体格情况分级
	 */
	@ApiModelProperty(value = "病人体格情况分级")
	private Integer asa;

	/**
	 * 手术麻醉风险评估
	 */
	@ApiModelProperty(value = "手术麻醉风险评估")
	private Integer riskLevel;

	/**
	 * 其他需要说明情况
	 */
	@ApiModelProperty(value = "其他需要说明情况")
	private String otherSituation;

	/**
	 * 麻醉医师签名
	 */
	@ApiModelProperty(value = "麻醉医师签名")
	private String anesthetistSign;

	/**
	 * 日期时间
	 */
	@ApiModelProperty(value = "日期时间")
	private Date time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId == null ? null : regOptId.trim();
	}

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState == null ? null : processState.trim();
	}

	public Integer getAssistMeasure() {
		return assistMeasure;
	}

	public void setAssistMeasure(Integer assistMeasure) {
		this.assistMeasure = assistMeasure;
	}

	public String getAssistDetail() {
		return assistDetail;
	}

	public void setAssistDetail(String assistDetail) {
		this.assistDetail = assistDetail == null ? null : assistDetail.trim();
	}

	public Integer getSBP() {
		return SBP;
	}

	public void setSBP(Integer SBP) {
		this.SBP = SBP;
	}

	public Integer getDBP() {
		return DBP;
	}

	public void setDBP(Integer DBP) {
		this.DBP = DBP;
	}

	public Integer getP() {
		return p;
	}

	public void setP(Integer p) {
		this.p = p;
	}

	public Integer getR() {
		return r;
	}

	public void setR(Integer r) {
		this.r = r;
	}

	public Integer getDrugAddiction() {
		return drugAddiction;
	}

	public void setDrugAddiction(Integer drugAddiction) {
		this.drugAddiction = drugAddiction;
	}

	public Integer getAllergic() {
		return allergic;
	}

	public void setAllergic(Integer allergic) {
		this.allergic = allergic;
	}

	public Integer getDeformity() {
		return deformity;
	}

	public void setDeformity(Integer deformity) {
		this.deformity = deformity;
	}

	public Integer getCervicalVertebra() {
		return cervicalVertebra;
	}

	public void setCervicalVertebra(Integer cervicalVertebra) {
		this.cervicalVertebra = cervicalVertebra;
	}

	public Integer getDehisceHard() {
		return dehisceHard;
	}

	public void setDehisceHard(Integer dehisceHard) {
		this.dehisceHard = dehisceHard;
	}

	public Integer getAperture() {
		return aperture;
	}

	public void setAperture(Integer aperture) {
		this.aperture = aperture;
	}

	public Integer getDenture() {
		return denture;
	}

	public void setDenture(Integer denture) {
		this.denture = denture;
	}

	public Integer getDyspnea() {
		return dyspnea;
	}

	public void setDyspnea(Integer dyspnea) {
		this.dyspnea = dyspnea;
	}

	public Integer getMallampatis() {
		return mallampatis;
	}

	public void setMallampatis(Integer mallampatis) {
		this.mallampatis = mallampatis;
	}

	public Integer getHeartLevel() {
		return heartLevel;
	}

	public void setHeartLevel(Integer heartLevel) {
		this.heartLevel = heartLevel;
	}

	public Integer getHypertension() {
		return hypertension;
	}

	public void setHypertension(Integer hypertension) {
		this.hypertension = hypertension;
	}

	public Integer getCoronary() {
		return coronary;
	}

	public void setCoronary(Integer coronary) {
		this.coronary = coronary;
	}

	public Integer getEcg() {
		return ecg;
	}

	public void setEcg(Integer ecg) {
		this.ecg = ecg;
	}

	public Integer getLungFunc() {
		return lungFunc;
	}

	public void setLungFunc(Integer lungFunc) {
		this.lungFunc = lungFunc;
	}

	public Integer getLungDisease() {
		return lungDisease;
	}

	public void setLungDisease(Integer lungDisease) {
		this.lungDisease = lungDisease;
	}

	public Integer getEndocrine() {
		return endocrine;
	}

	public void setEndocrine(Integer endocrine) {
		this.endocrine = endocrine;
	}

	public Integer getNervous() {
		return nervous;
	}

	public void setNervous(Integer nervous) {
		this.nervous = nervous;
	}

	public Integer getRabat() {
		return rabat;
	}

	public void setRabat(Integer rabat) {
		this.rabat = rabat;
	}

	public Integer getLiverFunc() {
		return liverFunc;
	}

	public void setLiverFunc(Integer liverFunc) {
		this.liverFunc = liverFunc;
	}

	public Integer getRenalFunc() {
		return renalFunc;
	}

	public void setRenalFunc(Integer renalFunc) {
		this.renalFunc = renalFunc;
	}

	public Integer getElectrolytic() {
		return electrolytic;
	}

	public void setElectrolytic(Integer electrolytic) {
		this.electrolytic = electrolytic;
	}

	public String getAssistCheckOther() {
		return assistCheckOther;
	}

	public void setAssistCheckOther(String assistCheckOther) {
		this.assistCheckOther = assistCheckOther == null ? null
				: assistCheckOther.trim();
	}

	public Integer getFasting() {
		return fasting;
	}

	public void setFasting(Integer fasting) {
		this.fasting = fasting;
	}

	public Integer getBanDrink() {
		return banDrink;
	}

	public void setBanDrink(Integer banDrink) {
		this.banDrink = banDrink;
	}

	public String getOtherDocord() {
		return otherDocord;
	}

	public void setOtherDocord(String otherDocord) {
		this.otherDocord = otherDocord == null ? null : otherDocord.trim();
	}

	public Integer getAsa() {
		return asa;
	}

	public void setAsa(Integer asa) {
		this.asa = asa;
	}

	public Integer getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getOtherSituation() {
		return otherSituation;
	}

	public void setOtherSituation(String otherSituation) {
		this.otherSituation = otherSituation == null ? null : otherSituation
				.trim();
	}

	public String getAnesthetistSign() {
		return anesthetistSign;
	}

	public void setAnesthetistSign(String anesthetistSign) {
		this.anesthetistSign = anesthetistSign == null ? null : anesthetistSign
				.trim();
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}