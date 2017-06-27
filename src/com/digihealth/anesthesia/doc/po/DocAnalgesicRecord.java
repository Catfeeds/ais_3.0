/*
 * DocAnalgesicRecord.java
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

@ApiModel(value = "镇痛记录单对象")
public class DocAnalgesicRecord {
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
     * 麻醉记录Id
     */
	@ApiModelProperty(value = "麻醉记录Id")
    private String anaesId;

	@ApiModelProperty(value = "状态")
    private String state;

    /**
     * 镇痛方式
     */
	@ApiModelProperty(value = "镇痛方式")
    private String analgesicMethod;

    /**
     * 硬膜外导管位置
     */
	@ApiModelProperty(value = "硬膜外导管位置")
    private String extraCatheterLoca;

    /**
     * 静脉导管位置
     */
	@ApiModelProperty(value = "静脉导管位置")
    private String intravCatheterLoca;

    /**
     * 镇痛泵机型
     */
	@ApiModelProperty(value = "镇痛泵机型")
    private String analgesicPumpsType;

    /**
     * PCA开机时间
     */
	@ApiModelProperty(value = "PCA开机时间")
    private Date pcaStart;

    /**
     * PCA关机时间
     */
	@ApiModelProperty(value = "PCA关机时间")
    private Date pcaStop;

    /**
     * 首次剂量,ml
     */
	@ApiModelProperty(value = "首次剂量,ml")
    private Float firstDosage;

    /**
     * 持续剂量,ml/h
     */
	@ApiModelProperty(value = "持续剂量,ml/h")
    private Float durativeDosage;

    /**
     * PCA剂量,ml
     */
	@ApiModelProperty(value = "PCA剂量,ml")
    private Float pcaDosage;

    /**
     * 锁定时间
     */
	@ApiModelProperty(value = "锁定时间")
    private Float lockTime;

    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成")
    private String processState;

	@ApiModelProperty(value = "其他")
    private String other;

    /**
     * 途径
     */
	@ApiModelProperty(value = "途径")
    private Integer channel;

    /**
     * 配方1
     */
	@ApiModelProperty(value = "配方1")
    private Float formula1;

    /**
     * 负荷量
     */
	@ApiModelProperty(value = "负荷量")
    private Float loadCapacity1;

    /**
     * 维持量
     */
	@ApiModelProperty(value = "维持量")
    private Float mainteAmount1;

    /**
     * 追加量
     */
	@ApiModelProperty(value = "追加量")
    private Float addAmount1;

    /**
     * 开始时间
     */
	@ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 麻醉医生
     */
	@ApiModelProperty(value = "麻醉医生")
    private String anaesDocId;

    /**
     * 麻醉医生
     */
	@ApiModelProperty(value = "麻醉医生")
    private String anaesDocName;

    /**
     * 配方2
     */
	@ApiModelProperty(value = "配方2")
    private Float formula2;

    /**
     * 续泵时间
     */
	@ApiModelProperty(value = "续泵时间")
    private Date continuePumpTime;

    /**
     * 负荷量2
     */
	@ApiModelProperty(value = "负荷量2")
    private Float loadCapacity2;

    /**
     * 维持量2
     */
	@ApiModelProperty(value = "维持量2")
    private Float mainteAmount2;

    /**
     * 追加量2
     */
	@ApiModelProperty(value = "追加量2")
    private Float addAmount2;

    /**
     * 续泵医生
     */
	@ApiModelProperty(value = "续泵医生id")
    private String continuePumpDocId;

	@ApiModelProperty(value = "续泵医生姓名")
    private String continuePumpDocName;

    /**
     * 终止时间
     */
	@ApiModelProperty(value = "终止时间")
    private Date endTime;

    /**
     * 拔泵者
     */
	@ApiModelProperty(value = "拔泵者")
    private String pullPump;

    /**
     * 拔泵者
     */
	@ApiModelProperty(value = "拔泵者")
    private String pullPumpName;

    /**
     * 其他系统情况
     */
	@ApiModelProperty(value = "其他系统情况")
    private String otherSystemSick;

    /**
     * 术中情况
     */
	@ApiModelProperty(value = "术中情况")
    private String operingCase;

    /**
     * 总容量
     */
	@ApiModelProperty(value = "总容量")
    private Float totalVolume;

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

    public String getAnaesId() {
        return anaesId;
    }

    public void setAnaesId(String anaesId) {
        this.anaesId = anaesId == null ? null : anaesId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getAnalgesicMethod() {
        return analgesicMethod;
    }

    public void setAnalgesicMethod(String analgesicMethod) {
        this.analgesicMethod = analgesicMethod == null ? null : analgesicMethod.trim();
    }

    public String getExtraCatheterLoca() {
        return extraCatheterLoca;
    }

    public void setExtraCatheterLoca(String extraCatheterLoca) {
        this.extraCatheterLoca = extraCatheterLoca == null ? null : extraCatheterLoca.trim();
    }

    public String getIntravCatheterLoca() {
        return intravCatheterLoca;
    }

    public void setIntravCatheterLoca(String intravCatheterLoca) {
        this.intravCatheterLoca = intravCatheterLoca == null ? null : intravCatheterLoca.trim();
    }

    public String getAnalgesicPumpsType() {
        return analgesicPumpsType;
    }

    public void setAnalgesicPumpsType(String analgesicPumpsType) {
        this.analgesicPumpsType = analgesicPumpsType == null ? null : analgesicPumpsType.trim();
    }

    public Date getPcaStart() {
        return pcaStart;
    }

    public void setPcaStart(Date pcaStart) {
        this.pcaStart = pcaStart;
    }

    public Date getPcaStop() {
        return pcaStop;
    }

    public void setPcaStop(Date pcaStop) {
        this.pcaStop = pcaStop;
    }

    public Float getFirstDosage() {
        return firstDosage;
    }

    public void setFirstDosage(Float firstDosage) {
        this.firstDosage = firstDosage;
    }

    public Float getDurativeDosage() {
        return durativeDosage;
    }

    public void setDurativeDosage(Float durativeDosage) {
        this.durativeDosage = durativeDosage;
    }

    public Float getPcaDosage() {
        return pcaDosage;
    }

    public void setPcaDosage(Float pcaDosage) {
        this.pcaDosage = pcaDosage;
    }

    public Float getLockTime() {
        return lockTime;
    }

    public void setLockTime(Float lockTime) {
        this.lockTime = lockTime;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Float getFormula1() {
        return formula1;
    }

    public void setFormula1(Float formula1) {
        this.formula1 = formula1;
    }

    public Float getLoadCapacity1() {
        return loadCapacity1;
    }

    public void setLoadCapacity1(Float loadCapacity1) {
        this.loadCapacity1 = loadCapacity1;
    }

    public Float getMainteAmount1() {
        return mainteAmount1;
    }

    public void setMainteAmount1(Float mainteAmount1) {
        this.mainteAmount1 = mainteAmount1;
    }

    public Float getAddAmount1() {
        return addAmount1;
    }

    public void setAddAmount1(Float addAmount1) {
        this.addAmount1 = addAmount1;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getAnaesDocId() {
        return anaesDocId;
    }

    public void setAnaesDocId(String anaesDocId) {
        this.anaesDocId = anaesDocId == null ? null : anaesDocId.trim();
    }

    public String getAnaesDocName() {
        return anaesDocName;
    }

    public void setAnaesDocName(String anaesDocName) {
        this.anaesDocName = anaesDocName == null ? null : anaesDocName.trim();
    }

    public Float getFormula2() {
        return formula2;
    }

    public void setFormula2(Float formula2) {
        this.formula2 = formula2;
    }

    public Date getContinuePumpTime() {
        return continuePumpTime;
    }

    public void setContinuePumpTime(Date continuePumpTime) {
        this.continuePumpTime = continuePumpTime;
    }

    public Float getLoadCapacity2() {
        return loadCapacity2;
    }

    public void setLoadCapacity2(Float loadCapacity2) {
        this.loadCapacity2 = loadCapacity2;
    }

    public Float getMainteAmount2() {
        return mainteAmount2;
    }

    public void setMainteAmount2(Float mainteAmount2) {
        this.mainteAmount2 = mainteAmount2;
    }

    public Float getAddAmount2() {
        return addAmount2;
    }

    public void setAddAmount2(Float addAmount2) {
        this.addAmount2 = addAmount2;
    }

    public String getContinuePumpDocId() {
        return continuePumpDocId;
    }

    public void setContinuePumpDocId(String continuePumpDocId) {
        this.continuePumpDocId = continuePumpDocId == null ? null : continuePumpDocId.trim();
    }

    public String getContinuePumpDocName() {
        return continuePumpDocName;
    }

    public void setContinuePumpDocName(String continuePumpDocName) {
        this.continuePumpDocName = continuePumpDocName == null ? null : continuePumpDocName.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPullPump() {
        return pullPump;
    }

    public void setPullPump(String pullPump) {
        this.pullPump = pullPump == null ? null : pullPump.trim();
    }

    public String getPullPumpName() {
        return pullPumpName;
    }

    public void setPullPumpName(String pullPumpName) {
        this.pullPumpName = pullPumpName == null ? null : pullPumpName.trim();
    }

    public String getOtherSystemSick() {
        return otherSystemSick;
    }

    public void setOtherSystemSick(String otherSystemSick) {
        this.otherSystemSick = otherSystemSick == null ? null : otherSystemSick.trim();
    }

    public String getOperingCase() {
        return operingCase;
    }

    public void setOperingCase(String operingCase) {
        this.operingCase = operingCase == null ? null : operingCase.trim();
    }

    public Float getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Float totalVolume) {
        this.totalVolume = totalVolume;
    }
}