/*
 * DocAnaesPlan.java
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

@ApiModel(value = "麻醉计划对象")
public class DocAnaesPlan {
	@ApiModelProperty(value = "主键id")
    private String id;

	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成END,NO_END")
    private String processState;

    /**
     * 特殊情况
     */
	@ApiModelProperty(value = "特殊情况")
    private String specialCase;

    /**
     * asa分级
     */
	@ApiModelProperty(value = "asa分级")
    private Integer asa;

    /**
     * 麻醉方法code
     */
	@ApiModelProperty(value = "麻醉方法code")
    private String anaesMethodCode;

    /**
     * 麻醉方法名字
     */
	@ApiModelProperty(value = "麻醉方法名字")
    private String anaesMethodName;

    /**
     * 监护项目
     */
	@ApiModelProperty(value = "监护项目")
    private String guardianship;

    /**
     * 诱导方法
     */
	@ApiModelProperty(value = "诱导方法")
    private String inductionMethod;

    /**
     * 人工气道
     */
	@ApiModelProperty(value = "人工气道")
    private String artificialAirway;

    /**
     * 穿刺点
     */
	@ApiModelProperty(value = "穿刺点")
    private Integer puncPoint;

    /**
     * 神经阻滞方法
     */
	@ApiModelProperty(value = "神经阻滞方法")
    private String nerveBlock;

    /**
     * 特殊操作
     */
	@ApiModelProperty(value = "特殊操作")
    private String specialOperate;

    /**
     * 麻醉器械
     */
	@ApiModelProperty(value = "麻醉器械")
    private String anaesInstrument;

    /**
     * 螺纹管
     */
	@ApiModelProperty(value = "螺纹管")
    private Integer threadedPipe;

    /**
     * 面罩
     */
	@ApiModelProperty(value = "面罩")
    private Integer mask;

    /**
     * 喉镜
     */
	@ApiModelProperty(value = "喉镜")
    private Integer laryngoscope;

    /**
     * 气管导管
     */
	@ApiModelProperty(value = "气管导管")
    private Integer tracheaPipe;

    /**
     * 气管导管ID
     */
	@ApiModelProperty(value = "气管导管ID")
    private Integer tracheaPipeId;

    /**
     * 双腔气管导管
     */
	@ApiModelProperty(value = "双腔气管导管")
    private Integer doubleChamber;

    /**
     * 双腔气管导管ID
     */
	@ApiModelProperty(value = "双腔气管导管ID")
    private Integer doubleChamberId;

    /**
     * 喉罩ID
     */
	@ApiModelProperty(value = "喉罩ID")
    private Integer laryngealId;

    /**
     * 中心静脉穿刺包
     */
	@ApiModelProperty(value = "中心静脉穿刺包")
    private Integer centralVenous;

    /**
     * 压力传感器
     */
	@ApiModelProperty(value = "压力传感器")
    private Integer pressureSensor;

    /**
     * 动脉穿刺针
     */
	@ApiModelProperty(value = "动脉穿刺针")
    private Integer arterialPuncture;

    /**
     * 微量泵
     */
	@ApiModelProperty(value = "微量泵")
    private Integer microPump;

    /**
     * 其他器械
     */
	@ApiModelProperty(value = "其他器械")
    private String otherInstrument;

    /**
     * 局麻药
     */
	@ApiModelProperty(value = "局麻药")
    private String localAnest;

    /**
     * 其他局麻药
     */
	@ApiModelProperty(value = "其他局麻药")
    private String otherlocalAnest;

    /**
     * 镇静药
     */
	@ApiModelProperty(value = "镇静药")
    private String sedatives;

    /**
     * 其他镇静药
     */
	@ApiModelProperty(value = "其他镇静药")
    private String otherSedatives;

    /**
     * 镇痛药
     */
	@ApiModelProperty(value = "镇痛药")
    private String analgesics;

    /**
     * 其他镇痛药
     */
	@ApiModelProperty(value = "其他镇痛药")
    private String otherAnalgesics;

    /**
     * 肌松药
     */
	@ApiModelProperty(value = "肌松药")
    private String muscleRelaxant;

    /**
     * 其他肌松药
     */
	@ApiModelProperty(value = "其他肌松药")
    private String otherMuscleRelaxant;

    /**
     * 静脉全麻药
     */
	@ApiModelProperty(value = "静脉全麻药")
    private String intravenousAnest;

    /**
     * 其他静脉全麻药
     */
	@ApiModelProperty(value = "其他静脉全麻药")
    private String otherIntravenousAnest;

    /**
     * 吸入麻醉药
     */
	@ApiModelProperty(value = "吸入麻醉药")
    private String inhalationAnest;

    /**
     * 其他吸入麻醉药
     */
	@ApiModelProperty(value = "其他吸入麻醉药")
    private String otherInhalationAnest;

    /**
     * 辅助用药
     */
	@ApiModelProperty(value = "辅助用药")
    private String adjuvantTherapy;

    /**
     * 其他辅助用药
     */
	@ApiModelProperty(value = "其他辅助用药")
    private String otherAdjuvantTherapy;

    /**
     * 急救用药
     */
	@ApiModelProperty(value = "急救用药")
    private String aidMedication;

    /**
     * 其他急救用药
     */
	@ApiModelProperty(value = "其他急救用药")
    private String otherAidMedication;

    /**
     * 输液
     */
	@ApiModelProperty(value = "输液")
    private String infusion;

    /**
     * 其他输液
     */
	@ApiModelProperty(value = "其他输液")
    private String otherInfusion;

    /**
     * 镇痛泵方案
     */
	@ApiModelProperty(value = "镇痛泵方案")
    private String analgesicPumpMethod;

    /**
     * 去向
     */
	@ApiModelProperty(value = "去向")
    private Integer leaveTo;

    /**
     * 麻醉医生ID
     */
	@ApiModelProperty(value = "麻醉医生ID")
    private String anaesDoctorId;

    /**
     * 麻醉医生名字
     */
	@ApiModelProperty(value = "麻醉医生名字")
    private String anaesDoctorName;

    /**
     * 日期
     */
	@ApiModelProperty(value = "日期")
    private Date date;

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

    public String getSpecialCase() {
        return specialCase;
    }

    public void setSpecialCase(String specialCase) {
        this.specialCase = specialCase == null ? null : specialCase.trim();
    }

    public Integer getAsa() {
        return asa;
    }

    public void setAsa(Integer asa) {
        this.asa = asa;
    }

    public String getAnaesMethodCode() {
        return anaesMethodCode;
    }

    public void setAnaesMethodCode(String anaesMethodCode) {
        this.anaesMethodCode = anaesMethodCode == null ? null : anaesMethodCode.trim();
    }

    public String getAnaesMethodName() {
        return anaesMethodName;
    }

    public void setAnaesMethodName(String anaesMethodName) {
        this.anaesMethodName = anaesMethodName == null ? null : anaesMethodName.trim();
    }

    public String getGuardianship() {
        return guardianship;
    }

    public void setGuardianship(String guardianship) {
        this.guardianship = guardianship == null ? null : guardianship.trim();
    }

    public String getInductionMethod() {
        return inductionMethod;
    }

    public void setInductionMethod(String inductionMethod) {
        this.inductionMethod = inductionMethod == null ? null : inductionMethod.trim();
    }

    public String getArtificialAirway() {
        return artificialAirway;
    }

    public void setArtificialAirway(String artificialAirway) {
        this.artificialAirway = artificialAirway == null ? null : artificialAirway.trim();
    }

    public Integer getPuncPoint() {
        return puncPoint;
    }

    public void setPuncPoint(Integer puncPoint) {
        this.puncPoint = puncPoint;
    }

    public String getNerveBlock() {
        return nerveBlock;
    }

    public void setNerveBlock(String nerveBlock) {
        this.nerveBlock = nerveBlock == null ? null : nerveBlock.trim();
    }

    public String getSpecialOperate() {
        return specialOperate;
    }

    public void setSpecialOperate(String specialOperate) {
        this.specialOperate = specialOperate == null ? null : specialOperate.trim();
    }

    public String getAnaesInstrument() {
        return anaesInstrument;
    }

    public void setAnaesInstrument(String anaesInstrument) {
        this.anaesInstrument = anaesInstrument == null ? null : anaesInstrument.trim();
    }

    public Integer getThreadedPipe() {
        return threadedPipe;
    }

    public void setThreadedPipe(Integer threadedPipe) {
        this.threadedPipe = threadedPipe;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    public Integer getLaryngoscope() {
        return laryngoscope;
    }

    public void setLaryngoscope(Integer laryngoscope) {
        this.laryngoscope = laryngoscope;
    }

    public Integer getTracheaPipe() {
        return tracheaPipe;
    }

    public void setTracheaPipe(Integer tracheaPipe) {
        this.tracheaPipe = tracheaPipe;
    }

    public Integer getTracheaPipeId() {
        return tracheaPipeId;
    }

    public void setTracheaPipeId(Integer tracheaPipeId) {
        this.tracheaPipeId = tracheaPipeId;
    }

    public Integer getDoubleChamber() {
        return doubleChamber;
    }

    public void setDoubleChamber(Integer doubleChamber) {
        this.doubleChamber = doubleChamber;
    }

    public Integer getDoubleChamberId() {
        return doubleChamberId;
    }

    public void setDoubleChamberId(Integer doubleChamberId) {
        this.doubleChamberId = doubleChamberId;
    }

    public Integer getLaryngealId() {
        return laryngealId;
    }

    public void setLaryngealId(Integer laryngealId) {
        this.laryngealId = laryngealId;
    }

    public Integer getCentralVenous() {
        return centralVenous;
    }

    public void setCentralVenous(Integer centralVenous) {
        this.centralVenous = centralVenous;
    }

    public Integer getPressureSensor() {
        return pressureSensor;
    }

    public void setPressureSensor(Integer pressureSensor) {
        this.pressureSensor = pressureSensor;
    }

    public Integer getArterialPuncture() {
        return arterialPuncture;
    }

    public void setArterialPuncture(Integer arterialPuncture) {
        this.arterialPuncture = arterialPuncture;
    }

    public Integer getMicroPump() {
        return microPump;
    }

    public void setMicroPump(Integer microPump) {
        this.microPump = microPump;
    }

    public String getOtherInstrument() {
        return otherInstrument;
    }

    public void setOtherInstrument(String otherInstrument) {
        this.otherInstrument = otherInstrument == null ? null : otherInstrument.trim();
    }

    public String getLocalAnest() {
        return localAnest;
    }

    public void setLocalAnest(String localAnest) {
        this.localAnest = localAnest == null ? null : localAnest.trim();
    }

    public String getOtherlocalAnest() {
        return otherlocalAnest;
    }

    public void setOtherlocalAnest(String otherlocalAnest) {
        this.otherlocalAnest = otherlocalAnest == null ? null : otherlocalAnest.trim();
    }

    public String getSedatives() {
        return sedatives;
    }

    public void setSedatives(String sedatives) {
        this.sedatives = sedatives == null ? null : sedatives.trim();
    }

    public String getOtherSedatives() {
        return otherSedatives;
    }

    public void setOtherSedatives(String otherSedatives) {
        this.otherSedatives = otherSedatives == null ? null : otherSedatives.trim();
    }

    public String getAnalgesics() {
        return analgesics;
    }

    public void setAnalgesics(String analgesics) {
        this.analgesics = analgesics == null ? null : analgesics.trim();
    }

    public String getOtherAnalgesics() {
        return otherAnalgesics;
    }

    public void setOtherAnalgesics(String otherAnalgesics) {
        this.otherAnalgesics = otherAnalgesics == null ? null : otherAnalgesics.trim();
    }

    public String getMuscleRelaxant() {
        return muscleRelaxant;
    }

    public void setMuscleRelaxant(String muscleRelaxant) {
        this.muscleRelaxant = muscleRelaxant == null ? null : muscleRelaxant.trim();
    }

    public String getOtherMuscleRelaxant() {
        return otherMuscleRelaxant;
    }

    public void setOtherMuscleRelaxant(String otherMuscleRelaxant) {
        this.otherMuscleRelaxant = otherMuscleRelaxant == null ? null : otherMuscleRelaxant.trim();
    }

    public String getIntravenousAnest() {
        return intravenousAnest;
    }

    public void setIntravenousAnest(String intravenousAnest) {
        this.intravenousAnest = intravenousAnest == null ? null : intravenousAnest.trim();
    }

    public String getOtherIntravenousAnest() {
        return otherIntravenousAnest;
    }

    public void setOtherIntravenousAnest(String otherIntravenousAnest) {
        this.otherIntravenousAnest = otherIntravenousAnest == null ? null : otherIntravenousAnest.trim();
    }

    public String getInhalationAnest() {
        return inhalationAnest;
    }

    public void setInhalationAnest(String inhalationAnest) {
        this.inhalationAnest = inhalationAnest == null ? null : inhalationAnest.trim();
    }

    public String getOtherInhalationAnest() {
        return otherInhalationAnest;
    }

    public void setOtherInhalationAnest(String otherInhalationAnest) {
        this.otherInhalationAnest = otherInhalationAnest == null ? null : otherInhalationAnest.trim();
    }

    public String getAdjuvantTherapy() {
        return adjuvantTherapy;
    }

    public void setAdjuvantTherapy(String adjuvantTherapy) {
        this.adjuvantTherapy = adjuvantTherapy == null ? null : adjuvantTherapy.trim();
    }

    public String getOtherAdjuvantTherapy() {
        return otherAdjuvantTherapy;
    }

    public void setOtherAdjuvantTherapy(String otherAdjuvantTherapy) {
        this.otherAdjuvantTherapy = otherAdjuvantTherapy == null ? null : otherAdjuvantTherapy.trim();
    }

    public String getAidMedication() {
        return aidMedication;
    }

    public void setAidMedication(String aidMedication) {
        this.aidMedication = aidMedication == null ? null : aidMedication.trim();
    }

    public String getOtherAidMedication() {
        return otherAidMedication;
    }

    public void setOtherAidMedication(String otherAidMedication) {
        this.otherAidMedication = otherAidMedication == null ? null : otherAidMedication.trim();
    }

    public String getInfusion() {
        return infusion;
    }

    public void setInfusion(String infusion) {
        this.infusion = infusion == null ? null : infusion.trim();
    }

    public String getOtherInfusion() {
        return otherInfusion;
    }

    public void setOtherInfusion(String otherInfusion) {
        this.otherInfusion = otherInfusion == null ? null : otherInfusion.trim();
    }

    public String getAnalgesicPumpMethod() {
        return analgesicPumpMethod;
    }

    public void setAnalgesicPumpMethod(String analgesicPumpMethod) {
        this.analgesicPumpMethod = analgesicPumpMethod == null ? null : analgesicPumpMethod.trim();
    }

    public Integer getLeaveTo() {
        return leaveTo;
    }

    public void setLeaveTo(Integer leaveTo) {
        this.leaveTo = leaveTo;
    }

    public String getAnaesDoctorId() {
        return anaesDoctorId;
    }

    public void setAnaesDoctorId(String anaesDoctorId) {
        this.anaesDoctorId = anaesDoctorId == null ? null : anaesDoctorId.trim();
    }

    public String getAnaesDoctorName() {
        return anaesDoctorName;
    }

    public void setAnaesDoctorName(String anaesDoctorName) {
        this.anaesDoctorName = anaesDoctorName == null ? null : anaesDoctorName.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}