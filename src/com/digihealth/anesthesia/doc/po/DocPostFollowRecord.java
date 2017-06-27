/*
 * DocPostFollowRecord.java
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

@ApiModel(value = "麻醉术后随访记录单对象")
public class DocPostFollowRecord {
	@ApiModelProperty(value = "主键id")
    private String postFollowId;

	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 血压
     */
	@ApiModelProperty(value = "血压")
    private String bloodPressure;

    /**
     * 脉搏
     */
	@ApiModelProperty(value = "脉搏")
    private String pulse;

    /**
     * 全麻术后其他特殊情况处理
     */
	@ApiModelProperty(value = "全麻术后其他特殊情况处理")
    private String generalExceptCase;

    /**
     * 椎管内术后其他特殊情况处理
     */
	@ApiModelProperty(value = "椎管内术后其他特殊情况处理")
    private String spinalExceptCase;

    /**
     * 术后镇痛其他特殊情况说明
     */
	@ApiModelProperty(value = "术后镇痛其他特殊情况说明")
    private String analgesicExceptCase;

    /**
     * 麻醉医生
     */
	@ApiModelProperty(value = "麻醉医生")
    private String anesthetistId;

    /**
     * 二次插管
     */
	@ApiModelProperty(value = "二次插管")
    private Integer secondIntubat;

    /**
     * 插管时间
     */
	@ApiModelProperty(value = "插管时间")
    private Date intubatTime;

    /**
     * 完成状态:END,NO_END
     */
	@ApiModelProperty(value = "完成状态:END,NO_END")
    private String processState;

    /**
     * 是否死亡 1是 0否
     */
	@ApiModelProperty(value = "是否死亡 1是 0否")
    private Integer isDeath;

    /**
     * 死亡时间
     */
	@ApiModelProperty(value = "死亡时间")
    private Date deathTime;

    public String getPostFollowId() {
        return postFollowId;
    }

    public void setPostFollowId(String postFollowId) {
        this.postFollowId = postFollowId == null ? null : postFollowId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse == null ? null : pulse.trim();
    }

    public String getGeneralExceptCase() {
        return generalExceptCase;
    }

    public void setGeneralExceptCase(String generalExceptCase) {
        this.generalExceptCase = generalExceptCase == null ? null : generalExceptCase.trim();
    }

    public String getSpinalExceptCase() {
        return spinalExceptCase;
    }

    public void setSpinalExceptCase(String spinalExceptCase) {
        this.spinalExceptCase = spinalExceptCase == null ? null : spinalExceptCase.trim();
    }

    public String getAnalgesicExceptCase() {
        return analgesicExceptCase;
    }

    public void setAnalgesicExceptCase(String analgesicExceptCase) {
        this.analgesicExceptCase = analgesicExceptCase == null ? null : analgesicExceptCase.trim();
    }

    public String getAnesthetistId() {
        return anesthetistId;
    }

    public void setAnesthetistId(String anesthetistId) {
        this.anesthetistId = anesthetistId == null ? null : anesthetistId.trim();
    }

    public Integer getSecondIntubat() {
        return secondIntubat;
    }

    public void setSecondIntubat(Integer secondIntubat) {
        this.secondIntubat = secondIntubat;
    }

    public Date getIntubatTime() {
        return intubatTime;
    }

    public void setIntubatTime(Date intubatTime) {
        this.intubatTime = intubatTime;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public Integer getIsDeath() {
        return isDeath;
    }

    public void setIsDeath(Integer isDeath) {
        this.isDeath = isDeath;
    }

    public Date getDeathTime() {
        return deathTime;
    }

    public void setDeathTime(Date deathTime) {
        this.deathTime = deathTime;
    }
}