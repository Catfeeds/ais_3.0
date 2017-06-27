/*
 * DocSpinalCanalPuncture.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "椎管内穿刺对象")
public class DocSpinalCanalPuncture {
	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键ID")
	private String spinalCanalId;

	/**
	 * 麻醉总结Id
	 */
	@ApiModelProperty(value = "麻醉总结Id")
	private String anaSumId;

	/**
	 * 穿刺位置
	 */
	@ApiModelProperty(value = "穿刺位置")
	private String puncBodyPoint;

	/**
	 * 穿刺体位
	 */
	@ApiModelProperty(value = "穿刺体位")
	private String puncPosi;

	@ApiModelProperty(value = "puncPoint")
	private String puncPoint;

	/**
	 * 是否穿刺顺利
	 */
	@ApiModelProperty(value = "是否穿刺顺利")
	private String isSucc;

	/**
	 * 黄韧带感
	 */
	@ApiModelProperty(value = "黄韧带感")
	private String ligamentumFlavum;

	/**
	 * 插管
	 */
	@ApiModelProperty(value = "插管")
	private String intubation;

	/**
	 * 异感
	 */
	@ApiModelProperty(value = "异感")
	private String diffFeel;

	/**
	 * 导管回血
	 */
	@ApiModelProperty(value = "导管回血")
	private String catheterBlood;

	/**
	 * 实验剂量
	 */
	@ApiModelProperty(value = "实验剂量")
	private String experDose;

	/**
	 * 麻醉范围
	 */
	@ApiModelProperty(value = "麻醉范围")
	private String anaesRange;

	/**
	 * 不良反应
	 */
	@ApiModelProperty(value = "不良反应")
	private String untowardEffect;

	/**
	 * 效果
	 */
	@ApiModelProperty(value = "效果")
	private String effect;

	/**
	 * 骶尾韧带感有无
	 */
	@ApiModelProperty(value = "骶尾韧带感有无")
	private String sacrococcygealLigamentum;

	/**
	 * 骶尾韧带感是否顺利
	 */
	@ApiModelProperty(value = "骶尾韧带感是否顺利")
	private String sacrococcygealLigamentumSucc;

	/**
	 * 气泡压缩
	 */
	@ApiModelProperty(value = "气泡压缩")
	private String bubbleCompress;

	/**
	 * 负压
	 */
	@ApiModelProperty(value = "负压")
	private String negativePressure;

	/**
	 * 气泡外涌
	 */
	@ApiModelProperty(value = "气泡外涌")
	private String bubbleOutside;

	/**
	 * 骶管穿刺有无
	 */
	@ApiModelProperty(value = "骶管穿刺有无")
	private String sacralCanalPuncture;

	/**
	 * 阻力消失
	 */
	@ApiModelProperty(value = "阻力消失")
	private String resistanceDisappear;

	public String getSpinalCanalId() {
		return spinalCanalId;
	}

	public void setSpinalCanalId(String spinalCanalId) {
		this.spinalCanalId = spinalCanalId == null ? null : spinalCanalId
				.trim();
	}

	public String getAnaSumId() {
		return anaSumId;
	}

	public void setAnaSumId(String anaSumId) {
		this.anaSumId = anaSumId == null ? null : anaSumId.trim();
	}

	public String getPuncBodyPoint() {
		return puncBodyPoint;
	}

	public void setPuncBodyPoint(String puncBodyPoint) {
		this.puncBodyPoint = puncBodyPoint == null ? null : puncBodyPoint
				.trim();
	}

	public String getPuncPosi() {
		return puncPosi;
	}

	public void setPuncPosi(String puncPosi) {
		this.puncPosi = puncPosi == null ? null : puncPosi.trim();
	}

	public String getPuncPoint() {
		return puncPoint;
	}

	public void setPuncPoint(String puncPoint) {
		this.puncPoint = puncPoint == null ? null : puncPoint.trim();
	}

	public String getIsSucc() {
		return isSucc;
	}

	public void setIsSucc(String isSucc) {
		this.isSucc = isSucc == null ? null : isSucc.trim();
	}

	public String getLigamentumFlavum() {
		return ligamentumFlavum;
	}

	public void setLigamentumFlavum(String ligamentumFlavum) {
		this.ligamentumFlavum = ligamentumFlavum == null ? null
				: ligamentumFlavum.trim();
	}

	public String getIntubation() {
		return intubation;
	}

	public void setIntubation(String intubation) {
		this.intubation = intubation == null ? null : intubation.trim();
	}

	public String getDiffFeel() {
		return diffFeel;
	}

	public void setDiffFeel(String diffFeel) {
		this.diffFeel = diffFeel == null ? null : diffFeel.trim();
	}

	public String getCatheterBlood() {
		return catheterBlood;
	}

	public void setCatheterBlood(String catheterBlood) {
		this.catheterBlood = catheterBlood == null ? null : catheterBlood
				.trim();
	}

	public String getExperDose() {
		return experDose;
	}

	public void setExperDose(String experDose) {
		this.experDose = experDose == null ? null : experDose.trim();
	}

	public String getAnaesRange() {
		return anaesRange;
	}

	public void setAnaesRange(String anaesRange) {
		this.anaesRange = anaesRange == null ? null : anaesRange.trim();
	}

	public String getUntowardEffect() {
		return untowardEffect;
	}

	public void setUntowardEffect(String untowardEffect) {
		this.untowardEffect = untowardEffect == null ? null : untowardEffect
				.trim();
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect == null ? null : effect.trim();
	}

	public String getSacrococcygealLigamentum() {
		return sacrococcygealLigamentum;
	}

	public void setSacrococcygealLigamentum(String sacrococcygealLigamentum) {
		this.sacrococcygealLigamentum = sacrococcygealLigamentum == null ? null
				: sacrococcygealLigamentum.trim();
	}

	public String getSacrococcygealLigamentumSucc() {
		return sacrococcygealLigamentumSucc;
	}

	public void setSacrococcygealLigamentumSucc(
			String sacrococcygealLigamentumSucc) {
		this.sacrococcygealLigamentumSucc = sacrococcygealLigamentumSucc == null ? null
				: sacrococcygealLigamentumSucc.trim();
	}

	public String getBubbleCompress() {
		return bubbleCompress;
	}

	public void setBubbleCompress(String bubbleCompress) {
		this.bubbleCompress = bubbleCompress == null ? null : bubbleCompress
				.trim();
	}

	public String getNegativePressure() {
		return negativePressure;
	}

	public void setNegativePressure(String negativePressure) {
		this.negativePressure = negativePressure == null ? null
				: negativePressure.trim();
	}

	public String getBubbleOutside() {
		return bubbleOutside;
	}

	public void setBubbleOutside(String bubbleOutside) {
		this.bubbleOutside = bubbleOutside == null ? null : bubbleOutside
				.trim();
	}

	public String getSacralCanalPuncture() {
		return sacralCanalPuncture;
	}

	public void setSacralCanalPuncture(String sacralCanalPuncture) {
		this.sacralCanalPuncture = sacralCanalPuncture == null ? null
				: sacralCanalPuncture.trim();
	}

	public String getResistanceDisappear() {
		return resistanceDisappear;
	}

	public void setResistanceDisappear(String resistanceDisappear) {
		this.resistanceDisappear = resistanceDisappear == null ? null
				: resistanceDisappear.trim();
	}
}