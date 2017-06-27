/*
 * DocAnalgesicVisitInfo.java
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

@ApiModel(value = "镇痛术后随访记录单对象")
public class DocAnalgesicVisitInfo {
    /**
     * 记录单主键
     */
	@ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 患者Id
     */
	@ApiModelProperty(value = "患者Id")
    private String regOptId;

    /**
     * 镇痛随访记录Id
     */
	@ApiModelProperty(value = "镇痛随访记录Id")
    private String analgesicId;

    /**
     * 访视时间
     */
	@ApiModelProperty(value = "访视时间")
    private Date visitTime;

    /**
     * 镇痛评分
     */
	@ApiModelProperty(value = "镇痛评分")
    private Integer analgesiaScore;

    /**
     * 镇静评分
     */
	@ApiModelProperty(value = "镇静评分")
    private Integer calmScore;

    /**
     * 不良反应
     */
	@ApiModelProperty(value = "不良反应")
    private Integer adverseReactions;

    /**
     * 恶心呕吐
     */
	@ApiModelProperty(value = "恶心呕吐")
    private Integer nausea;

    /**
     * 循环抑制
     */
	@ApiModelProperty(value = "循环抑制")
    private Integer cyclicInhibition;

    /**
     * 呼吸抑制
     */
	@ApiModelProperty(value = "呼吸抑制")
    private Integer respiratory;

    /**
     * 嗜睡
     */
	@ApiModelProperty(value = "嗜睡")
    private Integer sleepiness;

    /**
     * 头晕
     */
	@ApiModelProperty(value = "头晕")
    private Integer dizzy;

    /**
     * 无力
     */
	@ApiModelProperty(value = "无力")
    private Integer incapable;

    /**
     * 肢体麻木
     */
	@ApiModelProperty(value = "肢体麻木")
    private Integer limbs;

    /**
     * 总体满意度，1— 很满意；2— 满意；3— 一般；4— 不满意
     */
	@ApiModelProperty(value = "总体满意度，1— 很满意；2— 满意；3— 一般；4— 不满意")
    private Integer other;

    /**
     * 累积用药量
     */
	@ApiModelProperty(value = "累积用药量")
    private Float drugUse;

    /**
     * 记录人员
     */
	@ApiModelProperty(value = "记录人员")
    private String inquiryDoctor;

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

    public String getAnalgesicId() {
        return analgesicId;
    }

    public void setAnalgesicId(String analgesicId) {
        this.analgesicId = analgesicId == null ? null : analgesicId.trim();
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Integer getAnalgesiaScore() {
        return analgesiaScore;
    }

    public void setAnalgesiaScore(Integer analgesiaScore) {
        this.analgesiaScore = analgesiaScore;
    }

    public Integer getCalmScore() {
        return calmScore;
    }

    public void setCalmScore(Integer calmScore) {
        this.calmScore = calmScore;
    }

    public Integer getAdverseReactions() {
        return adverseReactions;
    }

    public void setAdverseReactions(Integer adverseReactions) {
        this.adverseReactions = adverseReactions;
    }

    public Integer getNausea() {
        return nausea;
    }

    public void setNausea(Integer nausea) {
        this.nausea = nausea;
    }

    public Integer getCyclicInhibition() {
        return cyclicInhibition;
    }

    public void setCyclicInhibition(Integer cyclicInhibition) {
        this.cyclicInhibition = cyclicInhibition;
    }

    public Integer getRespiratory() {
        return respiratory;
    }

    public void setRespiratory(Integer respiratory) {
        this.respiratory = respiratory;
    }

    public Integer getSleepiness() {
        return sleepiness;
    }

    public void setSleepiness(Integer sleepiness) {
        this.sleepiness = sleepiness;
    }

    public Integer getDizzy() {
        return dizzy;
    }

    public void setDizzy(Integer dizzy) {
        this.dizzy = dizzy;
    }

    public Integer getIncapable() {
        return incapable;
    }

    public void setIncapable(Integer incapable) {
        this.incapable = incapable;
    }

    public Integer getLimbs() {
        return limbs;
    }

    public void setLimbs(Integer limbs) {
        this.limbs = limbs;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }

    public Float getDrugUse() {
        return drugUse;
    }

    public void setDrugUse(Float drugUse) {
        this.drugUse = drugUse;
    }

    public String getInquiryDoctor() {
        return inquiryDoctor;
    }

    public void setInquiryDoctor(String inquiryDoctor) {
        this.inquiryDoctor = inquiryDoctor == null ? null : inquiryDoctor.trim();
    }
}