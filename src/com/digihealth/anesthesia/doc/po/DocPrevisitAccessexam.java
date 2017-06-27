/*
 * DocPrevisitAccessexam.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "术前访视常规检查对象")
public class DocPrevisitAccessexam {
	@ApiModelProperty(value = "主键id")
	private String id;

	/**
	 * 外键，关联pre_visit_id
	 */
	@ApiModelProperty(value = "外键，关联pre_visit_id")
	private String preVisitId;

	@ApiModelProperty(value = "患者id")
	private String regOptId;

	/**
	 * 血常规
	 */
	@ApiModelProperty(value = "血常规")
	private Integer routBloodTest;

	/**
	 * 血常规情况
	 */
	@ApiModelProperty(value = "血常规情况")
	private String routBloodTestRes;

	/**
	 * 尿常规
	 */
	@ApiModelProperty(value = "尿常规")
	private Integer routUrineTest;

	/**
	 * 尿常规情况
	 */
	@ApiModelProperty(value = "尿常规情况")
	private String routUrineTestRes;

	/**
	 * 胸片
	 */
	@ApiModelProperty(value = "胸片")
	private Integer rabat;

	/**
	 * 胸片情况
	 */
	@ApiModelProperty(value = "胸片情况")
	private String rabatRes;

	/**
	 * 肺功能
	 */
	@ApiModelProperty(value = "肺功能")
	private Integer lungFunc;

	/**
	 * 肺功能情况
	 */
	@ApiModelProperty(value = "肺功能情况")
	private String lungFuncRes;

	/**
	 * ecg
	 */
	@ApiModelProperty(value = "ecg")
	private Integer ecg;

	/**
	 * ecg情况
	 */
	@ApiModelProperty(value = "ecg情况")
	private String ecgRes;

	/**
	 * 超声心电图
	 */
	@ApiModelProperty(value = "超声心电图")
	private Integer ucg;

	/**
	 * 超声心电图情况
	 */
	@ApiModelProperty(value = "超声心电图情况")
	private String ucgRes;

	/**
	 * 肝功能
	 */
	@ApiModelProperty(value = "肝功能")
	private Integer liverFunc;

	/**
	 * 肝功能
	 */
	@ApiModelProperty(value = "肝功能")
	private String liverFuncRes;

	/**
	 * 肾功能
	 */
	@ApiModelProperty(value = "肾功能")
	private Integer renalFunc;

	/**
	 * 肾功能
	 */
	@ApiModelProperty(value = "肾功能")
	private String renalFuncRes;

	/**
	 * 凝血功能
	 */
	@ApiModelProperty(value = "凝血功能")
	private Integer coagulFunc;

	/**
	 * 凝血功能
	 */
	@ApiModelProperty(value = "凝血功能")
	private String coagulFuncRes;

	/**
	 * 电解质
	 */
	@ApiModelProperty(value = "电解质")
	private Integer electrolytic;

	/**
	 * 电解质
	 */
	@ApiModelProperty(value = "电解质")
	private String electrolyticRes;

	@ApiModelProperty(value = "")
	private String other;

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

	public Integer getRoutBloodTest() {
		return routBloodTest;
	}

	public void setRoutBloodTest(Integer routBloodTest) {
		this.routBloodTest = routBloodTest;
	}

	public String getRoutBloodTestRes() {
		return routBloodTestRes;
	}

	public void setRoutBloodTestRes(String routBloodTestRes) {
		this.routBloodTestRes = routBloodTestRes == null ? null
				: routBloodTestRes.trim();
	}

	public Integer getRoutUrineTest() {
		return routUrineTest;
	}

	public void setRoutUrineTest(Integer routUrineTest) {
		this.routUrineTest = routUrineTest;
	}

	public String getRoutUrineTestRes() {
		return routUrineTestRes;
	}

	public void setRoutUrineTestRes(String routUrineTestRes) {
		this.routUrineTestRes = routUrineTestRes == null ? null
				: routUrineTestRes.trim();
	}

	public Integer getRabat() {
		return rabat;
	}

	public void setRabat(Integer rabat) {
		this.rabat = rabat;
	}

	public String getRabatRes() {
		return rabatRes;
	}

	public void setRabatRes(String rabatRes) {
		this.rabatRes = rabatRes == null ? null : rabatRes.trim();
	}

	public Integer getLungFunc() {
		return lungFunc;
	}

	public void setLungFunc(Integer lungFunc) {
		this.lungFunc = lungFunc;
	}

	public String getLungFuncRes() {
		return lungFuncRes;
	}

	public void setLungFuncRes(String lungFuncRes) {
		this.lungFuncRes = lungFuncRes == null ? null : lungFuncRes.trim();
	}

	public Integer getEcg() {
		return ecg;
	}

	public void setEcg(Integer ecg) {
		this.ecg = ecg;
	}

	public String getEcgRes() {
		return ecgRes;
	}

	public void setEcgRes(String ecgRes) {
		this.ecgRes = ecgRes == null ? null : ecgRes.trim();
	}

	public Integer getUcg() {
		return ucg;
	}

	public void setUcg(Integer ucg) {
		this.ucg = ucg;
	}

	public String getUcgRes() {
		return ucgRes;
	}

	public void setUcgRes(String ucgRes) {
		this.ucgRes = ucgRes == null ? null : ucgRes.trim();
	}

	public Integer getLiverFunc() {
		return liverFunc;
	}

	public void setLiverFunc(Integer liverFunc) {
		this.liverFunc = liverFunc;
	}

	public String getLiverFuncRes() {
		return liverFuncRes;
	}

	public void setLiverFuncRes(String liverFuncRes) {
		this.liverFuncRes = liverFuncRes == null ? null : liverFuncRes.trim();
	}

	public Integer getRenalFunc() {
		return renalFunc;
	}

	public void setRenalFunc(Integer renalFunc) {
		this.renalFunc = renalFunc;
	}

	public String getRenalFuncRes() {
		return renalFuncRes;
	}

	public void setRenalFuncRes(String renalFuncRes) {
		this.renalFuncRes = renalFuncRes == null ? null : renalFuncRes.trim();
	}

	public Integer getCoagulFunc() {
		return coagulFunc;
	}

	public void setCoagulFunc(Integer coagulFunc) {
		this.coagulFunc = coagulFunc;
	}

	public String getCoagulFuncRes() {
		return coagulFuncRes;
	}

	public void setCoagulFuncRes(String coagulFuncRes) {
		this.coagulFuncRes = coagulFuncRes == null ? null : coagulFuncRes
				.trim();
	}

	public Integer getElectrolytic() {
		return electrolytic;
	}

	public void setElectrolytic(Integer electrolytic) {
		this.electrolytic = electrolytic;
	}

	public String getElectrolyticRes() {
		return electrolyticRes;
	}

	public void setElectrolyticRes(String electrolyticRes) {
		this.electrolyticRes = electrolyticRes == null ? null : electrolyticRes
				.trim();
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other == null ? null : other.trim();
	}
}