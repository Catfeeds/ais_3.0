/*
 * DocPrevisitPhyexam.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "术前访视一般情况及体格检查表对象")
public class DocPrevisitPhyexam {
	@ApiModelProperty(value = "主键id")
	private String id;

	/**
	 * 外键，关联pre_visit_id
	 */
	@ApiModelProperty(value = "外键，关联pre_visit_id")
	private String preVisitId;

	@ApiModelProperty(value = "患者ID")
	private String regOptId;

	/**
	 * 神志
	 */
	@ApiModelProperty(value = "神志")
	private Integer consciou;

	/**
	 * 呼吸困难
	 */
	@ApiModelProperty(value = "呼吸困难")
	private Integer dyspnea;

	/**
	 * 紫绀
	 */
	@ApiModelProperty(value = "紫绀")
	private Integer cyanosis;

	/**
	 * 困难气道
	 */
	@ApiModelProperty(value = "困难气道")
	private Integer diffAirway;

	/**
	 * 开口度
	 */
	@ApiModelProperty(value = "开口度")
	private Integer aperture;

	/**
	 * 牙齿松动
	 */
	@ApiModelProperty(value = "牙齿松动")
	private Integer toothMobility;

	/**
	 * 体温T
	 */
	@ApiModelProperty(value = "体温T")
	private Float temp;

	/**
	 * 血压BP
	 */
	@ApiModelProperty(value = "血压BP")
	private String bloodPre;

	/**
	 * 心率R
	 */
	@ApiModelProperty(value = "心率R")
	private Integer heartrate;

	/**
	 * 呼吸
	 */
	@ApiModelProperty(value = "呼吸")
	private Integer breath;

	/**
	 * 脉搏P
	 */
	@ApiModelProperty(value = "脉搏P")
	private Float pr;

	/**
	 * 头颈活动度
	 */
	@ApiModelProperty(value = "头颈活动度")
	private Integer headActivity;

	/**
	 * mallampati
	 */
	@ApiModelProperty(value = "mallampati")
	private Integer mallampati;

	/**
	 * 心脏检查
	 */
	@ApiModelProperty(value = "心脏检查")
	private Integer cardiacWorkup;

	/**
	 * 心脏检查情况
	 */
	@ApiModelProperty(value = "心脏检查情况")
	private String cardiacWorkupRes;

	/**
	 * 肺部检查
	 */
	@ApiModelProperty(value = "肺部检查")
	private Integer pulmExam;

	/**
	 * 肺部检查情况
	 */
	@ApiModelProperty(value = "肺部检查情况")
	private String pulmExamRes;

	/**
	 * 脊椎畸形
	 */
	@ApiModelProperty(value = "脊椎畸形")
	private Integer hemivertebra;

	/**
	 * 椎间隙
	 */
	@ApiModelProperty(value = "椎间隙")
	private Integer intervSpace;

	/**
	 * 穿刺点
	 */
	@ApiModelProperty(value = "穿刺点")
	private Integer puncPoint;

	/**
	 * 双下肢
	 */
	@ApiModelProperty(value = "双下肢")
	private Integer bleFeel;

	@ApiModelProperty(value = "其他")
	private String other;

	/**
	 * 双下肢情况
	 */
	@ApiModelProperty(value = "双下肢情况")
	private String bleFeelRes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

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

	public Integer getConsciou() {
		return consciou;
	}

	public void setConsciou(Integer consciou) {
		this.consciou = consciou;
	}

	public Integer getDyspnea() {
		return dyspnea;
	}

	public void setDyspnea(Integer dyspnea) {
		this.dyspnea = dyspnea;
	}

	public Integer getCyanosis() {
		return cyanosis;
	}

	public void setCyanosis(Integer cyanosis) {
		this.cyanosis = cyanosis;
	}

	public Integer getDiffAirway() {
		return diffAirway;
	}

	public void setDiffAirway(Integer diffAirway) {
		this.diffAirway = diffAirway;
	}

	public Integer getAperture() {
		return aperture;
	}

	public void setAperture(Integer aperture) {
		this.aperture = aperture;
	}

	public Integer getToothMobility() {
		return toothMobility;
	}

	public void setToothMobility(Integer toothMobility) {
		this.toothMobility = toothMobility;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public String getBloodPre() {
		return bloodPre;
	}

	public void setBloodPre(String bloodPre) {
		this.bloodPre = bloodPre == null ? null : bloodPre.trim();
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

	public Float getPr() {
		return pr;
	}

	public void setPr(Float pr) {
		this.pr = pr;
	}

	public Integer getHeadActivity() {
		return headActivity;
	}

	public void setHeadActivity(Integer headActivity) {
		this.headActivity = headActivity;
	}

	public Integer getMallampati() {
		return mallampati;
	}

	public void setMallampati(Integer mallampati) {
		this.mallampati = mallampati;
	}

	public Integer getCardiacWorkup() {
		return cardiacWorkup;
	}

	public void setCardiacWorkup(Integer cardiacWorkup) {
		this.cardiacWorkup = cardiacWorkup;
	}

	public String getCardiacWorkupRes() {
		return cardiacWorkupRes;
	}

	public void setCardiacWorkupRes(String cardiacWorkupRes) {
		this.cardiacWorkupRes = cardiacWorkupRes == null ? null
				: cardiacWorkupRes.trim();
	}

	public Integer getPulmExam() {
		return pulmExam;
	}

	public void setPulmExam(Integer pulmExam) {
		this.pulmExam = pulmExam;
	}

	public String getPulmExamRes() {
		return pulmExamRes;
	}

	public void setPulmExamRes(String pulmExamRes) {
		this.pulmExamRes = pulmExamRes == null ? null : pulmExamRes.trim();
	}

	public Integer getHemivertebra() {
		return hemivertebra;
	}

	public void setHemivertebra(Integer hemivertebra) {
		this.hemivertebra = hemivertebra;
	}

	public Integer getIntervSpace() {
		return intervSpace;
	}

	public void setIntervSpace(Integer intervSpace) {
		this.intervSpace = intervSpace;
	}

	public Integer getPuncPoint() {
		return puncPoint;
	}

	public void setPuncPoint(Integer puncPoint) {
		this.puncPoint = puncPoint;
	}

	public Integer getBleFeel() {
		return bleFeel;
	}

	public void setBleFeel(Integer bleFeel) {
		this.bleFeel = bleFeel;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other == null ? null : other.trim();
	}

	public String getBleFeelRes() {
		return bleFeelRes;
	}

	public void setBleFeelRes(String bleFeelRes) {
		this.bleFeelRes = bleFeelRes == null ? null : bleFeelRes.trim();
	}
}