/*
 * DocAnalgesicPostflup.java
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
public class DocAnalgesicPostflup {
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

	@ApiModelProperty(value = "是否完成")
    private String processState;

    /**
     * 随访类型：1：出室；2：小时；3：第*天
     */
	@ApiModelProperty(value = "随访类型：1：出室；2：小时；3：第*天")
    private Integer type;

    /**
     * 末次给药时间
     */
	@ApiModelProperty(value = "末次给药时间")
    private Date lastDrugTime;

    /**
     * 类型事件对应的时间，比如多少小时，第几天等
     */
	@ApiModelProperty(value = "类型事件对应的时间，比如多少小时，第几天等")
    private String postTime;

    /**
     * SPO2
     */
	@ApiModelProperty(value = "SPO2")
    private String spo2;

    /**
     * 心率
     */
	@ApiModelProperty(value = "心率")
    private String cardiotach;

    /**
     * 呼吸
     */
	@ApiModelProperty(value = "呼吸")
    private String breath;

    /**
     * VAS评分
     */
	@ApiModelProperty(value = "VAS评分")
    private String vasScore;

    /**
     * 镇静评级
     */
	@ApiModelProperty(value = "镇静评级")
    private Date calmnessScore;

    /**
     * 运动阻滞评级
     */
	@ApiModelProperty(value = "运动阻滞评级")
    private Date sportBlockScore;

    /**
     * 恶心评分
     */
	@ApiModelProperty(value = "恶心评分")
    private Integer nauseaScore;

    /**
     * 呕吐评分
     */
	@ApiModelProperty(value = "呕吐评分")
    private Integer vomitScore;

    /**
     * 尿潴留评分
     */
	@ApiModelProperty(value = "尿潴留评分")
    private Integer emictionRetentionScore;

    /**
     * 保留导尿评分
     */
	@ApiModelProperty(value = "保留导尿评分")
    private Integer catheterScore;

    /**
     * 其它不良反应
     */
	@ApiModelProperty(value = "其它不良反应")
    private String otherKickback;

    /**
     * 总按压
     */
	@ApiModelProperty(value = "总按压")
    private Integer totalPress;

    /**
     * 有效按压
     */
	@ApiModelProperty(value = "有效按压")
    private Integer validPress;

    /**
     * 用量,持续+PCA，单位ml
     */
	@ApiModelProperty(value = "用量,持续+PCA，单位ml")
    private Float drugUsed;

    /**
     * 随访人员，以","分隔
     */
	@ApiModelProperty(value = "随访人员，以,分隔")
    private String inquiryDoctor;

    /**
     * 镇痛术毕导管处置,1:留/2:拔
     */
	@ApiModelProperty(value = "镇痛术毕导管处置,1:留/2:拔")
    private Integer analgesicCatheter;

    /**
     * 总体满意度，1— 很满意；2— 满意；3— 一般；4— 不满意
     */
	@ApiModelProperty(value = "总体满意度，1— 很满意；2— 满意；3— 一般；4— 不满意")
    private Integer totalSatisf;

    /**
     * 备注
     */
	@ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 记录时间
     */
	@ApiModelProperty(value = "记录时间")
    private Date recordTime;

    /**
     * 记录人员
     */
	@ApiModelProperty(value = "记录人员")
    private String recorder;

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

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getLastDrugTime() {
        return lastDrugTime;
    }

    public void setLastDrugTime(Date lastDrugTime) {
        this.lastDrugTime = lastDrugTime;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime == null ? null : postTime.trim();
    }

    public String getSpo2() {
        return spo2;
    }

    public void setSpo2(String spo2) {
        this.spo2 = spo2 == null ? null : spo2.trim();
    }

    public String getCardiotach() {
        return cardiotach;
    }

    public void setCardiotach(String cardiotach) {
        this.cardiotach = cardiotach == null ? null : cardiotach.trim();
    }

    public String getBreath() {
        return breath;
    }

    public void setBreath(String breath) {
        this.breath = breath == null ? null : breath.trim();
    }

    public String getVasScore() {
        return vasScore;
    }

    public void setVasScore(String vasScore) {
        this.vasScore = vasScore == null ? null : vasScore.trim();
    }

    public Date getCalmnessScore() {
        return calmnessScore;
    }

    public void setCalmnessScore(Date calmnessScore) {
        this.calmnessScore = calmnessScore;
    }

    public Date getSportBlockScore() {
        return sportBlockScore;
    }

    public void setSportBlockScore(Date sportBlockScore) {
        this.sportBlockScore = sportBlockScore;
    }

    public Integer getNauseaScore() {
        return nauseaScore;
    }

    public void setNauseaScore(Integer nauseaScore) {
        this.nauseaScore = nauseaScore;
    }

    public Integer getVomitScore() {
        return vomitScore;
    }

    public void setVomitScore(Integer vomitScore) {
        this.vomitScore = vomitScore;
    }

    public Integer getEmictionRetentionScore() {
        return emictionRetentionScore;
    }

    public void setEmictionRetentionScore(Integer emictionRetentionScore) {
        this.emictionRetentionScore = emictionRetentionScore;
    }

    public Integer getCatheterScore() {
        return catheterScore;
    }

    public void setCatheterScore(Integer catheterScore) {
        this.catheterScore = catheterScore;
    }

    public String getOtherKickback() {
        return otherKickback;
    }

    public void setOtherKickback(String otherKickback) {
        this.otherKickback = otherKickback == null ? null : otherKickback.trim();
    }

    public Integer getTotalPress() {
        return totalPress;
    }

    public void setTotalPress(Integer totalPress) {
        this.totalPress = totalPress;
    }

    public Integer getValidPress() {
        return validPress;
    }

    public void setValidPress(Integer validPress) {
        this.validPress = validPress;
    }

    public Float getDrugUsed() {
        return drugUsed;
    }

    public void setDrugUsed(Float drugUsed) {
        this.drugUsed = drugUsed;
    }

    public String getInquiryDoctor() {
        return inquiryDoctor;
    }

    public void setInquiryDoctor(String inquiryDoctor) {
        this.inquiryDoctor = inquiryDoctor == null ? null : inquiryDoctor.trim();
    }

    public Integer getAnalgesicCatheter() {
        return analgesicCatheter;
    }

    public void setAnalgesicCatheter(Integer analgesicCatheter) {
        this.analgesicCatheter = analgesicCatheter;
    }

    public Integer getTotalSatisf() {
        return totalSatisf;
    }

    public void setTotalSatisf(Integer totalSatisf) {
        this.totalSatisf = totalSatisf;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
    }
}