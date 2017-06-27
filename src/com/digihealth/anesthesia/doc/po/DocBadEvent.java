/*
 * DocBadEvent.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "不良事件对象")
public class DocBadEvent {
	@ApiModelProperty(value = "主键id")
    private String badEventId;

    /**
     * 不良事件发生经过
     */
	@ApiModelProperty(value = "不良事件发生经过")
    private String description;

    /**
     * 失误原因
     */
	@ApiModelProperty(value = "失误原因")
    private String lapseReason;

    /**
     * 技术原因
     */
	@ApiModelProperty(value = "技术原因")
    private String technologyReason;

    /**
     * 外科手术原因
     */
	@ApiModelProperty(value = "外科手术原因")
    private String surgeryReason;

    /**
     * 计划错误1
     */
	@ApiModelProperty(value = "计划错误1")
    private String planError1;

    /**
     * 计划错误1其他
     */
	@ApiModelProperty(value = "计划错误1其他")
    private String planError1Other;

    /**
     * 计划错误2
     */
	@ApiModelProperty(value = "计划错误2")
    private String planError2;

    /**
     * 计划错误2其他
     */
	@ApiModelProperty(value = "计划错误2其他")
    private String planError2Other;

    /**
     * 监护
     */
	@ApiModelProperty(value = "监护")
    private String guardianship;

    /**
     * 监护其他
     */
	@ApiModelProperty(value = "监护其他")
    private String guardianshipOther;

    /**
     * 处理问题1
     */
	@ApiModelProperty(value = "处理问题1")
    private String processPro1;

    /**
     * 处理问题1其他
     */
	@ApiModelProperty(value = "处理问题1其他")
    private String processPro1Other;

    /**
     * 处理问题2
     */
	@ApiModelProperty(value = "处理问题2")
    private String processPro2;

    /**
     * 处理问题2其他
     */
	@ApiModelProperty(value = "处理问题2其他")
    private String processPro2Other;

	@ApiModelProperty(value = "患者id")
    private String regOptId;

	@ApiModelProperty(value = "signTime")
    private String signTime;

	@ApiModelProperty(value = "上级医生id")
    private String circuanesthetistId;

	@ApiModelProperty(value = "上级医生姓名")
	private String circuanesthetistName;
	
    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成")
    private String processState;

    /**
     * 气道正常
     */
	@ApiModelProperty(value = "气道正常")
    private Integer normalAirway;

    /**
     * 喉罩
     */
	@ApiModelProperty(value = "喉罩")
    private Integer laryngealMask;

    /**
     * 气管内导管
     */
	@ApiModelProperty(value = "气管内导管")
    private Integer trachealCatheter;

    /**
     * 气管导管脱落
     */
	@ApiModelProperty(value = "气管导管脱落")
    private Integer catheterFall;

    /**
     * 连接异常脱落
     */
	@ApiModelProperty(value = "连接异常脱落")
    private Integer anomaly;

    /**
     * 不当拔管
     */
	@ApiModelProperty(value = "不当拔管")
    private Integer impExtubat;

    /**
     * 呼吸机故障
     */
	@ApiModelProperty(value = "呼吸机故障")
    private Integer ventLnop;

    /**
     * 气管内导管阻塞
     */
	@ApiModelProperty(value = "气管内导管阻塞")
    private Integer ductObstruct;

    /**
     * 食道插管
     */
	@ApiModelProperty(value = "食道插管")
    private Integer esophagusIntubat;

    /**
     * 通气无效其他
     */
	@ApiModelProperty(value = "通气无效其他")
    private String aerateIneffectiveOther;

    /**
     * 部分气道梗阻
     */
	@ApiModelProperty(value = "部分气道梗阻")
    private Integer partAirwayObstruct;

    /**
     * 麻醉药/其他药物所致
     */
	@ApiModelProperty(value = "麻醉药/其他药物所致")
    private Integer drugInduced;

    /**
     * 支气管痉挛
     */
	@ApiModelProperty(value = "支气管痉挛")
    private Integer bronchialSpasm;

    /**
     * 误咽误吸引发呼吸道梗阻
     */
	@ApiModelProperty(value = "误咽误吸引发呼吸道梗阻")
    private Integer airwayObstruct;

    /**
     * 前述的任何原因
     */
	@ApiModelProperty(value = "前述的任何原因")
    private Integer theWhateverReason;

    /**
     * 支气管插管
     */
	@ApiModelProperty(value = "支气管插管")
    private Integer bronchialCannula;

    /**
     * 误吸
     */
	@ApiModelProperty(value = "误吸")
    private Integer aspirat;

    /**
     * 气胸
     */
	@ApiModelProperty(value = "气胸")
    private Integer pneumothorax;

    /**
     * 氧合不当其他
     */
	@ApiModelProperty(value = "氧合不当其他")
    private String oxygenSuitablyOther;

    /**
     * 心律失常
     */
	@ApiModelProperty(value = "心律失常")
    private Integer arrhythmia;

    /**
     * 血压异常
     */
	@ApiModelProperty(value = "血压异常")
    private Integer abnormalBlood;

    /**
     * 心跳骤停
     */
	@ApiModelProperty(value = "心跳骤停")
    private Integer cardiacArrest;

    /**
     * 氧饱和度重度降低
     */
	@ApiModelProperty(value = "氧饱和度重度降低")
    private Integer oxygenSatReduce;

    /**
     * 循环异常其他
     */
	@ApiModelProperty(value = "循环异常其他")
    private String cycleAbnormalOther;

    /**
     * 静脉通路连接异常脱落
     */
	@ApiModelProperty(value = "静脉通路连接异常脱落")
    private Integer veinConnectFall;

    /**
     * 静脉通路其他
     */
	@ApiModelProperty(value = "静脉通路其他")
    private String veinPassageOther;

    /**
     * CO2吸收
     */
	@ApiModelProperty(value = "CO2吸收")
    private Integer co2Absorb;

    /**
     * 单向活瓣
     */
	@ApiModelProperty(value = "单向活瓣")
    private Integer singleValve;

    /**
     * T型管回路
     */
	@ApiModelProperty(value = "T型管回路")
    private Integer tubeLoop;

    /**
     * 麻醉机回路故障其他
     */
	@ApiModelProperty(value = "麻醉机回路故障其他")
    private String anesMachineCircleOther;

    /**
     * 挥发罐
     */
	@ApiModelProperty(value = "挥发罐")
    private Integer volatileTank;

    /**
     * 监测部分
     */
	@ApiModelProperty(value = "监测部分")
    private Integer monitorPart;

    /**
     * 供养故障
     */
	@ApiModelProperty(value = "供养故障")
    private Integer oxygenFail;

    /**
     * 流量计
     */
	@ApiModelProperty(value = "流量计")
    private Integer flowmeter;

    /**
     * 麻醉机其他
     */
	@ApiModelProperty(value = "麻醉机其他")
    private String anesMachineOther;

    /**
     * 输液泵
     */
	@ApiModelProperty(value = "输液泵")
    private Integer infusionPump;

    /**
     * 喉镜
     */
	@ApiModelProperty(value = "喉镜")
    private Integer laryngoscope;

    /**
     * 保暖设备
     */
	@ApiModelProperty(value = "保暖设备")
    private Integer warmDevice;

    /**
     * 用药错误
     */
	@ApiModelProperty(value = "用药错误")
    private Integer errorMedicat;

    /**
     * 剂量错误
     */
	@ApiModelProperty(value = "剂量错误")
    private Integer errorDose;

    /**
     * 途径错误
     */
	@ApiModelProperty(value = "途径错误")
    private Integer wrongWay;

    /**
     * 全麻结束时使用催醒药物
     */
	@ApiModelProperty(value = "全麻结束时使用催醒药物")
    private Integer wakeDrugs;

    /**
     * 用药其他
     */
	@ApiModelProperty(value = "用药其他")
    private String medicineUsingOther;

    /**
     * 周围神经阻滞
     */
	@ApiModelProperty(value = "周围神经阻滞")
    private Integer peripheralNerveBlock;

    /**
     * 骶管阻滞
     */
	@ApiModelProperty(value = "骶管阻滞")
    private Integer sacralCanalBlock;

    /**
     * 硬膜外阻滞
     */
	@ApiModelProperty(value = "硬膜外阻滞")
    private Integer epiduralBlock;

    /**
     * 局麻技术其他
     */
	@ApiModelProperty(value = "局麻技术其他")
    private String localAnaesTechOther;

    /**
     * 非预期的意识
     */
	@ApiModelProperty(value = "非预期的意识")
    private Integer unintendedAware;

    /**
     * 意外死亡
     */
	@ApiModelProperty(value = "意外死亡")
    private Integer accidentDeath;

    /**
     * 其他
     */
	@ApiModelProperty(value = "其他")
    private String other;

    public String getBadEventId() {
        return badEventId;
    }

    public void setBadEventId(String badEventId) {
        this.badEventId = badEventId == null ? null : badEventId.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getLapseReason() {
        return lapseReason;
    }

    public void setLapseReason(String lapseReason) {
        this.lapseReason = lapseReason == null ? null : lapseReason.trim();
    }

    public String getTechnologyReason() {
        return technologyReason;
    }

    public void setTechnologyReason(String technologyReason) {
        this.technologyReason = technologyReason == null ? null : technologyReason.trim();
    }

    public String getSurgeryReason() {
        return surgeryReason;
    }

    public void setSurgeryReason(String surgeryReason) {
        this.surgeryReason = surgeryReason == null ? null : surgeryReason.trim();
    }

    public String getPlanError1() {
        return planError1;
    }

    public void setPlanError1(String planError1) {
        this.planError1 = planError1 == null ? null : planError1.trim();
    }

    public String getPlanError1Other() {
        return planError1Other;
    }

    public void setPlanError1Other(String planError1Other) {
        this.planError1Other = planError1Other == null ? null : planError1Other.trim();
    }

    public String getPlanError2() {
        return planError2;
    }

    public void setPlanError2(String planError2) {
        this.planError2 = planError2 == null ? null : planError2.trim();
    }

    public String getPlanError2Other() {
        return planError2Other;
    }

    public void setPlanError2Other(String planError2Other) {
        this.planError2Other = planError2Other == null ? null : planError2Other.trim();
    }

    public String getGuardianship() {
        return guardianship;
    }

    public void setGuardianship(String guardianship) {
        this.guardianship = guardianship == null ? null : guardianship.trim();
    }

    public String getGuardianshipOther() {
        return guardianshipOther;
    }

    public void setGuardianshipOther(String guardianshipOther) {
        this.guardianshipOther = guardianshipOther == null ? null : guardianshipOther.trim();
    }

    public String getProcessPro1() {
        return processPro1;
    }

    public void setProcessPro1(String processPro1) {
        this.processPro1 = processPro1 == null ? null : processPro1.trim();
    }

    public String getProcessPro1Other() {
        return processPro1Other;
    }

    public void setProcessPro1Other(String processPro1Other) {
        this.processPro1Other = processPro1Other == null ? null : processPro1Other.trim();
    }

    public String getProcessPro2() {
        return processPro2;
    }

    public void setProcessPro2(String processPro2) {
        this.processPro2 = processPro2 == null ? null : processPro2.trim();
    }

    public String getProcessPro2Other() {
        return processPro2Other;
    }

    public void setProcessPro2Other(String processPro2Other) {
        this.processPro2Other = processPro2Other == null ? null : processPro2Other.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime == null ? null : signTime.trim();
    }

    public String getCircuanesthetistId() {
        return circuanesthetistId;
    }

    public void setCircuanesthetistId(String circuanesthetistId) {
        this.circuanesthetistId = circuanesthetistId == null ? null : circuanesthetistId.trim();
    }

    public String getCircuanesthetistName() {
		return circuanesthetistName;
	}

	public void setCircuanesthetistName(String circuanesthetistName) {
		this.circuanesthetistName = circuanesthetistName;
	}

	public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public Integer getNormalAirway() {
        return normalAirway;
    }

    public void setNormalAirway(Integer normalAirway) {
        this.normalAirway = normalAirway;
    }

    public Integer getLaryngealMask() {
        return laryngealMask;
    }

    public void setLaryngealMask(Integer laryngealMask) {
        this.laryngealMask = laryngealMask;
    }

    public Integer getTrachealCatheter() {
        return trachealCatheter;
    }

    public void setTrachealCatheter(Integer trachealCatheter) {
        this.trachealCatheter = trachealCatheter;
    }

    public Integer getCatheterFall() {
        return catheterFall;
    }

    public void setCatheterFall(Integer catheterFall) {
        this.catheterFall = catheterFall;
    }

    public Integer getAnomaly() {
        return anomaly;
    }

    public void setAnomaly(Integer anomaly) {
        this.anomaly = anomaly;
    }

    public Integer getImpExtubat() {
        return impExtubat;
    }

    public void setImpExtubat(Integer impExtubat) {
        this.impExtubat = impExtubat;
    }

    public Integer getVentLnop() {
        return ventLnop;
    }

    public void setVentLnop(Integer ventLnop) {
        this.ventLnop = ventLnop;
    }

    public Integer getDuctObstruct() {
        return ductObstruct;
    }

    public void setDuctObstruct(Integer ductObstruct) {
        this.ductObstruct = ductObstruct;
    }

    public Integer getEsophagusIntubat() {
        return esophagusIntubat;
    }

    public void setEsophagusIntubat(Integer esophagusIntubat) {
        this.esophagusIntubat = esophagusIntubat;
    }

    public String getAerateIneffectiveOther() {
        return aerateIneffectiveOther;
    }

    public void setAerateIneffectiveOther(String aerateIneffectiveOther) {
        this.aerateIneffectiveOther = aerateIneffectiveOther == null ? null : aerateIneffectiveOther.trim();
    }

    public Integer getPartAirwayObstruct() {
        return partAirwayObstruct;
    }

    public void setPartAirwayObstruct(Integer partAirwayObstruct) {
        this.partAirwayObstruct = partAirwayObstruct;
    }

    public Integer getDrugInduced() {
        return drugInduced;
    }

    public void setDrugInduced(Integer drugInduced) {
        this.drugInduced = drugInduced;
    }

    public Integer getBronchialSpasm() {
        return bronchialSpasm;
    }

    public void setBronchialSpasm(Integer bronchialSpasm) {
        this.bronchialSpasm = bronchialSpasm;
    }

    public Integer getAirwayObstruct() {
        return airwayObstruct;
    }

    public void setAirwayObstruct(Integer airwayObstruct) {
        this.airwayObstruct = airwayObstruct;
    }

    public Integer getTheWhateverReason() {
        return theWhateverReason;
    }

    public void setTheWhateverReason(Integer theWhateverReason) {
        this.theWhateverReason = theWhateverReason;
    }

    public Integer getBronchialCannula() {
        return bronchialCannula;
    }

    public void setBronchialCannula(Integer bronchialCannula) {
        this.bronchialCannula = bronchialCannula;
    }

    public Integer getAspirat() {
        return aspirat;
    }

    public void setAspirat(Integer aspirat) {
        this.aspirat = aspirat;
    }

    public Integer getPneumothorax() {
        return pneumothorax;
    }

    public void setPneumothorax(Integer pneumothorax) {
        this.pneumothorax = pneumothorax;
    }

    public String getOxygenSuitablyOther() {
        return oxygenSuitablyOther;
    }

    public void setOxygenSuitablyOther(String oxygenSuitablyOther) {
        this.oxygenSuitablyOther = oxygenSuitablyOther == null ? null : oxygenSuitablyOther.trim();
    }

    public Integer getArrhythmia() {
        return arrhythmia;
    }

    public void setArrhythmia(Integer arrhythmia) {
        this.arrhythmia = arrhythmia;
    }

    public Integer getAbnormalBlood() {
        return abnormalBlood;
    }

    public void setAbnormalBlood(Integer abnormalBlood) {
        this.abnormalBlood = abnormalBlood;
    }

    public Integer getCardiacArrest() {
        return cardiacArrest;
    }

    public void setCardiacArrest(Integer cardiacArrest) {
        this.cardiacArrest = cardiacArrest;
    }

    public Integer getOxygenSatReduce() {
        return oxygenSatReduce;
    }

    public void setOxygenSatReduce(Integer oxygenSatReduce) {
        this.oxygenSatReduce = oxygenSatReduce;
    }

    public String getCycleAbnormalOther() {
        return cycleAbnormalOther;
    }

    public void setCycleAbnormalOther(String cycleAbnormalOther) {
        this.cycleAbnormalOther = cycleAbnormalOther == null ? null : cycleAbnormalOther.trim();
    }

    public Integer getVeinConnectFall() {
        return veinConnectFall;
    }

    public void setVeinConnectFall(Integer veinConnectFall) {
        this.veinConnectFall = veinConnectFall;
    }

    public String getVeinPassageOther() {
        return veinPassageOther;
    }

    public void setVeinPassageOther(String veinPassageOther) {
        this.veinPassageOther = veinPassageOther == null ? null : veinPassageOther.trim();
    }

    public Integer getCo2Absorb() {
        return co2Absorb;
    }

    public void setCo2Absorb(Integer co2Absorb) {
        this.co2Absorb = co2Absorb;
    }

    public Integer getSingleValve() {
        return singleValve;
    }

    public void setSingleValve(Integer singleValve) {
        this.singleValve = singleValve;
    }

    public Integer getTubeLoop() {
        return tubeLoop;
    }

    public void setTubeLoop(Integer tubeLoop) {
        this.tubeLoop = tubeLoop;
    }

    public String getAnesMachineCircleOther() {
        return anesMachineCircleOther;
    }

    public void setAnesMachineCircleOther(String anesMachineCircleOther) {
        this.anesMachineCircleOther = anesMachineCircleOther == null ? null : anesMachineCircleOther.trim();
    }

    public Integer getVolatileTank() {
        return volatileTank;
    }

    public void setVolatileTank(Integer volatileTank) {
        this.volatileTank = volatileTank;
    }

    public Integer getMonitorPart() {
        return monitorPart;
    }

    public void setMonitorPart(Integer monitorPart) {
        this.monitorPart = monitorPart;
    }

    public Integer getOxygenFail() {
        return oxygenFail;
    }

    public void setOxygenFail(Integer oxygenFail) {
        this.oxygenFail = oxygenFail;
    }

    public Integer getFlowmeter() {
        return flowmeter;
    }

    public void setFlowmeter(Integer flowmeter) {
        this.flowmeter = flowmeter;
    }

    public String getAnesMachineOther() {
        return anesMachineOther;
    }

    public void setAnesMachineOther(String anesMachineOther) {
        this.anesMachineOther = anesMachineOther == null ? null : anesMachineOther.trim();
    }

    public Integer getInfusionPump() {
        return infusionPump;
    }

    public void setInfusionPump(Integer infusionPump) {
        this.infusionPump = infusionPump;
    }

    public Integer getLaryngoscope() {
        return laryngoscope;
    }

    public void setLaryngoscope(Integer laryngoscope) {
        this.laryngoscope = laryngoscope;
    }

    public Integer getWarmDevice() {
        return warmDevice;
    }

    public void setWarmDevice(Integer warmDevice) {
        this.warmDevice = warmDevice;
    }

    public Integer getErrorMedicat() {
        return errorMedicat;
    }

    public void setErrorMedicat(Integer errorMedicat) {
        this.errorMedicat = errorMedicat;
    }

    public Integer getErrorDose() {
        return errorDose;
    }

    public void setErrorDose(Integer errorDose) {
        this.errorDose = errorDose;
    }

    public Integer getWrongWay() {
        return wrongWay;
    }

    public void setWrongWay(Integer wrongWay) {
        this.wrongWay = wrongWay;
    }

    public Integer getWakeDrugs() {
        return wakeDrugs;
    }

    public void setWakeDrugs(Integer wakeDrugs) {
        this.wakeDrugs = wakeDrugs;
    }

    public String getMedicineUsingOther() {
        return medicineUsingOther;
    }

    public void setMedicineUsingOther(String medicineUsingOther) {
        this.medicineUsingOther = medicineUsingOther == null ? null : medicineUsingOther.trim();
    }

    public Integer getPeripheralNerveBlock() {
        return peripheralNerveBlock;
    }

    public void setPeripheralNerveBlock(Integer peripheralNerveBlock) {
        this.peripheralNerveBlock = peripheralNerveBlock;
    }

    public Integer getSacralCanalBlock() {
        return sacralCanalBlock;
    }

    public void setSacralCanalBlock(Integer sacralCanalBlock) {
        this.sacralCanalBlock = sacralCanalBlock;
    }

    public Integer getEpiduralBlock() {
        return epiduralBlock;
    }

    public void setEpiduralBlock(Integer epiduralBlock) {
        this.epiduralBlock = epiduralBlock;
    }

    public String getLocalAnaesTechOther() {
        return localAnaesTechOther;
    }

    public void setLocalAnaesTechOther(String localAnaesTechOther) {
        this.localAnaesTechOther = localAnaesTechOther == null ? null : localAnaesTechOther.trim();
    }

    public Integer getUnintendedAware() {
        return unintendedAware;
    }

    public void setUnintendedAware(Integer unintendedAware) {
        this.unintendedAware = unintendedAware;
    }

    public Integer getAccidentDeath() {
        return accidentDeath;
    }

    public void setAccidentDeath(Integer accidentDeath) {
        this.accidentDeath = accidentDeath;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}