/*
 * DocAnaesPostop.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "术后随访对象")
public class DocAnaesPostop {

	@ApiModelProperty(value = "主键id")
    private String anaPostopId;

	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 血压
     */
	@ApiModelProperty(value = "血压")
    private String beforeBloodPre;

    /**
     * 心率
     */
	@ApiModelProperty(value = "心率")
    private Integer beforeHeartrate;

    /**
     * 呼吸
     */
	@ApiModelProperty(value = "呼吸")
    private Integer beforeBreath;

    /**
     * 意识
     */
	@ApiModelProperty(value = "意识")
    private String beforeMentalState;

    /**
     * 感觉
     */
	@ApiModelProperty(value = "感觉")
    private String beforeFeel;

    /**
     * 运动功能
     */
	@ApiModelProperty(value = "运动功能")
    private String beforeMotorFunction;

    /**
     * 氧饱和度
     */
	@ApiModelProperty(value = "氧饱和度")
    private Integer spo2;

    /**
     * 麻醉有关导管
     */
	@ApiModelProperty(value = "麻醉有关导管")
    private String anaesCatheter;

    /**
     * 拔除时间
     */
	@ApiModelProperty(value = "拔除时间")
    private String removalTime;

	@ApiModelProperty(value = "beforeOther")
    private String beforeOther;

    /**
     * 心率
     */
	@ApiModelProperty(value = "心率")
    private Integer afterHeartrate;

    /**
     * 呼吸
     */
	@ApiModelProperty(value = "呼吸")
    private Integer afterBreath;

    /**
     * 血压
     */
	@ApiModelProperty(value = "血压")
    private String afterBloodPre;

    /**
     * 意识
     */
	@ApiModelProperty(value = "意识")
    private String afterMentalState;

    /**
     * 感觉
     */
	@ApiModelProperty(value = "感觉")
    private String afterFeel;

    /**
     * 运动功能
     */
	@ApiModelProperty(value = "运动功能")
    private String afterMotorFunction;

    /**
     * 麻醉操作部位情况
     */
	@ApiModelProperty(value = "麻醉操作部位情况")
    private String opePartsCase;

    /**
     * 其他
     */
	@ApiModelProperty(value = "其他")
    private String afterOther;

	@ApiModelProperty(value = "麻醉医生id")
    private String anaestheitistId;

	@ApiModelProperty(value = "signTime")
    private String signTime;

    /**
     * 咽喉疼痛：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "咽喉疼痛：“有/无”，1-有、0-无")
    private Integer throatAche;

    /**
     * 咳嗽：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "咳嗽：“有/无”，1-有、0-无")
    private Integer cough;

    /**
     * 呼吸道梗塞：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "呼吸道梗塞：“有/无”，1-有、0-无")
    private Integer respTractInfarct;

    /**
     * 缺氧：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "缺氧：“有/无”，1-有、0-无")
    private Integer anoxia;

    /**
     * 呼吸抑制：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "呼吸抑制：“有/无”，1-有、0-无")
    private Integer respDepress;

    /**
     * 声音嘶哑：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "声音嘶哑：“有/无”，1-有、0-无")
    private Integer soundHoarseness;

    /**
     * 二氧化碳蓄积：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "二氧化碳蓄积：“有/无”，1-有、0-无")
    private Integer carboDioxidAccum;

    /**
     * 肺不张：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "肺不张：“有/无”，1-有、0-无")
    private Integer atelectasis;

    /**
     * 肺部感染：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "肺部感染：“有/无”，1-有、0-无")
    private Integer pulmInfect;

    /**
     * 呼吸系统其他情况
     */
	@ApiModelProperty(value = "呼吸系统其他情况")
    private String respSystemCond;

    /**
     * 循环系统：“有/无”，1-有、0-正常
     */
	@ApiModelProperty(value = "循环系统：“有/无”，1-有、0-正常")
    private Integer circulSystem;

    /**
     * 血压：1，高血压；-1：低血压
     */
	@ApiModelProperty(value = "血压：1，高血压；-1：低血压")
    private Integer bloodCond;

    /**
     * 心率失常：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "心率失常：“有/无”，1-有、0-无")
    private Integer arrhythmia;

    /**
     * 心肌缺血：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "心肌缺血：“有/无”，1-有、0-无")
    private Integer ischMyocard;

    /**
     * 休克：“有/无”，1-有、0-无
     */
	@ApiModelProperty(value = "休克：“有/无”，1-有、0-无")
    private Integer shock;

    /**
     * 术中知晓
     */
	@ApiModelProperty(value = "术中知晓")
    private Integer intraoperAware;

    /**
     * 神志
     */
	@ApiModelProperty(value = "神志")
    private Integer consciousness;

    /**
     * 术后躁动
     */
	@ApiModelProperty(value = "术后躁动")
    private Integer postoperAgit;

    /**
     * 认知障碍
     */
	@ApiModelProperty(value = "认知障碍")
    private Integer disgnosia;

    /**
     * 循环系统其它情况
     */
	@ApiModelProperty(value = "循环系统其它情况")
    private String circulSystemCond;

    /**
     * 疼痛程度：0，无；1：轻度；2：中度；3：重度
     */
	@ApiModelProperty(value = "疼痛程度：0，无；1：轻度；2：中度；3：重度")
    private Integer painDeg;

    /**
     * 呃逆
     */
	@ApiModelProperty(value = "呃逆")
    private Integer hiccup;

    /**
     * 呕吐
     */
	@ApiModelProperty(value = "呕吐")
    private Integer disgorge;

    /**
     * 恶心
     */
	@ApiModelProperty(value = "恶心")
    private Integer naupathia;

	@ApiModelProperty(value = "麻醉医生姓名")
	private String anaestheitistName;
    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成")
    private String processState;

    public String getAnaPostopId() {
        return anaPostopId;
    }

    public void setAnaPostopId(String anaPostopId) {
        this.anaPostopId = anaPostopId == null ? null : anaPostopId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getBeforeBloodPre() {
        return beforeBloodPre;
    }

    public void setBeforeBloodPre(String beforeBloodPre) {
        this.beforeBloodPre = beforeBloodPre == null ? null : beforeBloodPre.trim();
    }

    public Integer getBeforeHeartrate() {
        return beforeHeartrate;
    }

    public void setBeforeHeartrate(Integer beforeHeartrate) {
        this.beforeHeartrate = beforeHeartrate;
    }

    public Integer getBeforeBreath() {
        return beforeBreath;
    }

    public void setBeforeBreath(Integer beforeBreath) {
        this.beforeBreath = beforeBreath;
    }

    public String getBeforeMentalState() {
        return beforeMentalState;
    }

    public void setBeforeMentalState(String beforeMentalState) {
        this.beforeMentalState = beforeMentalState == null ? null : beforeMentalState.trim();
    }

    public String getBeforeFeel() {
        return beforeFeel;
    }

    public void setBeforeFeel(String beforeFeel) {
        this.beforeFeel = beforeFeel == null ? null : beforeFeel.trim();
    }

    public String getBeforeMotorFunction() {
        return beforeMotorFunction;
    }

    public void setBeforeMotorFunction(String beforeMotorFunction) {
        this.beforeMotorFunction = beforeMotorFunction == null ? null : beforeMotorFunction.trim();
    }

    public Integer getSpo2() {
        return spo2;
    }

    public void setSpo2(Integer spo2) {
        this.spo2 = spo2;
    }

    public String getAnaesCatheter() {
        return anaesCatheter;
    }

    public void setAnaesCatheter(String anaesCatheter) {
        this.anaesCatheter = anaesCatheter == null ? null : anaesCatheter.trim();
    }

    public String getRemovalTime() {
        return removalTime;
    }

    public void setRemovalTime(String removalTime) {
        this.removalTime = removalTime == null ? null : removalTime.trim();
    }

    public String getBeforeOther() {
        return beforeOther;
    }

    public void setBeforeOther(String beforeOther) {
        this.beforeOther = beforeOther == null ? null : beforeOther.trim();
    }

    public Integer getAfterHeartrate() {
        return afterHeartrate;
    }

    public void setAfterHeartrate(Integer afterHeartrate) {
        this.afterHeartrate = afterHeartrate;
    }

    public Integer getAfterBreath() {
        return afterBreath;
    }

    public void setAfterBreath(Integer afterBreath) {
        this.afterBreath = afterBreath;
    }

    public String getAfterBloodPre() {
        return afterBloodPre;
    }

    public void setAfterBloodPre(String afterBloodPre) {
        this.afterBloodPre = afterBloodPre == null ? null : afterBloodPre.trim();
    }

    public String getAfterMentalState() {
        return afterMentalState;
    }

    public void setAfterMentalState(String afterMentalState) {
        this.afterMentalState = afterMentalState == null ? null : afterMentalState.trim();
    }

    public String getAfterFeel() {
        return afterFeel;
    }

    public void setAfterFeel(String afterFeel) {
        this.afterFeel = afterFeel == null ? null : afterFeel.trim();
    }

    public String getAfterMotorFunction() {
        return afterMotorFunction;
    }

    public void setAfterMotorFunction(String afterMotorFunction) {
        this.afterMotorFunction = afterMotorFunction == null ? null : afterMotorFunction.trim();
    }

    public String getOpePartsCase() {
        return opePartsCase;
    }

    public void setOpePartsCase(String opePartsCase) {
        this.opePartsCase = opePartsCase == null ? null : opePartsCase.trim();
    }

    public String getAfterOther() {
        return afterOther;
    }

    public void setAfterOther(String afterOther) {
        this.afterOther = afterOther == null ? null : afterOther.trim();
    }

    public String getAnaestheitistId() {
        return anaestheitistId;
    }

    public void setAnaestheitistId(String anaestheitistId) {
        this.anaestheitistId = anaestheitistId == null ? null : anaestheitistId.trim();
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime == null ? null : signTime.trim();
    }

    public Integer getThroatAche() {
        return throatAche;
    }

    public void setThroatAche(Integer throatAche) {
        this.throatAche = throatAche;
    }

    public Integer getCough() {
        return cough;
    }

    public void setCough(Integer cough) {
        this.cough = cough;
    }

    public Integer getRespTractInfarct() {
        return respTractInfarct;
    }

    public void setRespTractInfarct(Integer respTractInfarct) {
        this.respTractInfarct = respTractInfarct;
    }

    public Integer getAnoxia() {
        return anoxia;
    }

    public void setAnoxia(Integer anoxia) {
        this.anoxia = anoxia;
    }

    public Integer getRespDepress() {
        return respDepress;
    }

    public void setRespDepress(Integer respDepress) {
        this.respDepress = respDepress;
    }

    public Integer getSoundHoarseness() {
        return soundHoarseness;
    }

    public void setSoundHoarseness(Integer soundHoarseness) {
        this.soundHoarseness = soundHoarseness;
    }

    public Integer getCarboDioxidAccum() {
        return carboDioxidAccum;
    }

    public void setCarboDioxidAccum(Integer carboDioxidAccum) {
        this.carboDioxidAccum = carboDioxidAccum;
    }

    public Integer getAtelectasis() {
        return atelectasis;
    }

    public void setAtelectasis(Integer atelectasis) {
        this.atelectasis = atelectasis;
    }

    public Integer getPulmInfect() {
        return pulmInfect;
    }

    public void setPulmInfect(Integer pulmInfect) {
        this.pulmInfect = pulmInfect;
    }

    public String getRespSystemCond() {
        return respSystemCond;
    }

    public void setRespSystemCond(String respSystemCond) {
        this.respSystemCond = respSystemCond == null ? null : respSystemCond.trim();
    }

    public Integer getCirculSystem() {
        return circulSystem;
    }

    public void setCirculSystem(Integer circulSystem) {
        this.circulSystem = circulSystem;
    }

    public Integer getBloodCond() {
        return bloodCond;
    }

    public void setBloodCond(Integer bloodCond) {
        this.bloodCond = bloodCond;
    }

    public Integer getArrhythmia() {
        return arrhythmia;
    }

    public void setArrhythmia(Integer arrhythmia) {
        this.arrhythmia = arrhythmia;
    }

    public Integer getIschMyocard() {
        return ischMyocard;
    }

    public void setIschMyocard(Integer ischMyocard) {
        this.ischMyocard = ischMyocard;
    }

    public Integer getShock() {
        return shock;
    }

    public void setShock(Integer shock) {
        this.shock = shock;
    }

    public Integer getIntraoperAware() {
        return intraoperAware;
    }

    public void setIntraoperAware(Integer intraoperAware) {
        this.intraoperAware = intraoperAware;
    }

    public Integer getConsciousness() {
        return consciousness;
    }

    public void setConsciousness(Integer consciousness) {
        this.consciousness = consciousness;
    }

    public Integer getPostoperAgit() {
        return postoperAgit;
    }

    public void setPostoperAgit(Integer postoperAgit) {
        this.postoperAgit = postoperAgit;
    }

    public Integer getDisgnosia() {
        return disgnosia;
    }

    public void setDisgnosia(Integer disgnosia) {
        this.disgnosia = disgnosia;
    }

    public String getCirculSystemCond() {
        return circulSystemCond;
    }

    public void setCirculSystemCond(String circulSystemCond) {
        this.circulSystemCond = circulSystemCond == null ? null : circulSystemCond.trim();
    }

    public Integer getPainDeg() {
        return painDeg;
    }

    public void setPainDeg(Integer painDeg) {
        this.painDeg = painDeg;
    }

    public Integer getHiccup() {
        return hiccup;
    }

    public void setHiccup(Integer hiccup) {
        this.hiccup = hiccup;
    }

    public Integer getDisgorge() {
        return disgorge;
    }

    public void setDisgorge(Integer disgorge) {
        this.disgorge = disgorge;
    }

    public Integer getNaupathia() {
        return naupathia;
    }

    public void setNaupathia(Integer naupathia) {
        this.naupathia = naupathia;
    }

    public String getAnaestheitistName() {
		return anaestheitistName;
	}

	public void setAnaestheitistName(String anaestheitistName) {
		this.anaestheitistName = anaestheitistName;
	}

	public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }
}