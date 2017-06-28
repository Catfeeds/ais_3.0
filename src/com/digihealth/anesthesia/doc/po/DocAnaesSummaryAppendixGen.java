/*
 * DocAnaesSummaryAppendixGen.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉总结附录单全麻模块对象")
public class DocAnaesSummaryAppendixGen {
	@ApiModelProperty(value = "主键id")
    private String anaSumAppGenId;

	@ApiModelProperty(value = "麻醉总结单id")
    private String anaSumId;

    /**
     * 全身麻醉
     */
	@ApiModelProperty(value = "全身麻醉")
    private Integer genAnesthesia;

    /**
     * 快诱导
     */
	@ApiModelProperty(value = "快诱导")
    private Integer fastInduction;

    /**
     * 慢诱导
     */
	@ApiModelProperty(value = "慢诱导")
    private Integer slowInduction;

    /**
     * 气管插管
     */
	@ApiModelProperty(value = "气管插管")
    private Integer intubation;

    /**
     * 气管内
     */
	@ApiModelProperty(value = "气管内")
    private Integer endotracheal;

    /**
     * 支气管
     */
	@ApiModelProperty(value = "支气管")
    private Integer bronchial;

    /**
     * 左腔
     */
	@ApiModelProperty(value = "左腔")
    private Integer leftChamber;

    /**
     * 右腔
     */
	@ApiModelProperty(value = "右腔")
    private Integer rightChamber;

    /**
     * 双腔
     */
	@ApiModelProperty(value = "双腔")
    private Integer doubleCavity;

    /**
     * 阻塞器
     */
	@ApiModelProperty(value = "阻塞器")
    private Integer blockDevice;

    /**
     * 纤支镜定位
     */
	@ApiModelProperty(value = "纤支镜定位")
    private Integer fiberLocal;

    /**
     * 经口
     */
	@ApiModelProperty(value = "经口")
    private Integer pyrosulfite;

    /**
     * 经鼻
     */
	@ApiModelProperty(value = "经鼻")
    private Integer transnasal;

    /**
     * 经气管
     */
	@ApiModelProperty(value = "经气管")
    private Integer transtracheal;

    /**
     * 型号
     */
	@ApiModelProperty(value = "型号")
    private String model1;

    /**
     * 深度
     */
	@ApiModelProperty(value = "深度")
    private Float depth;

    /**
     * 套囊
     */
	@ApiModelProperty(value = "套囊")
    private Integer cuff;

    /**
     * 直视
     */
	@ApiModelProperty(value = "直视")
    private Integer look;

    /**
     * 盲探
     */
	@ApiModelProperty(value = "盲探")
    private Integer blind;

    /**
     * 逆行
     */
	@ApiModelProperty(value = "逆行")
    private Integer retrograde;

    /**
     * 纤支镜引导
     */
	@ApiModelProperty(value = "纤支镜引导")
    private Integer fiberGuide;

    /**
     * 可视喉镜
     */
	@ApiModelProperty(value = "可视喉镜")
    private Integer glidescope;

    /**
     * 光索
     */
	@ApiModelProperty(value = "光索")
    private Integer opticalCable;

    /**
     * 气管插管套件
     */
	@ApiModelProperty(value = "气管插管套件")
    private Integer intubationSuite;

    /**
     * 加强管
     */
	@ApiModelProperty(value = "加强管")
    private Integer reinPipe;

    /**
     * 异形管
     */
	@ApiModelProperty(value = "异形管")
    private Integer shapedTube;

	@ApiModelProperty(value = "其他")
    private Integer other;

	@ApiModelProperty(value = "其他内容")
    private String otherContent;

    /**
     * 喉罩
     */
	@ApiModelProperty(value = "喉罩")
    private Integer laryMask;

    /**
     * 型号
     */
	@ApiModelProperty(value = "型号")
    private String model2;

    /**
     * 插管困难
     */
	@ApiModelProperty(value = "插管困难")
    private Integer diffIntub;

    /**
     * 维持方法
     */
	@ApiModelProperty(value = "维持方法")
    private String keepMethod;

    /**
     * 基础或强化麻醉
     */
	@ApiModelProperty(value = "基础或强化麻醉")
    private Integer baseAnes;

    /**
     * 麻醉监护
     */
	@ApiModelProperty(value = "麻醉监护")
    private Integer anesCare;

    /**
     * 监测项目7项以内
     */
	@ApiModelProperty(value = "监测项目7项以内")
    private Integer monitProject7;

    /**
     * 监测项目8-13项
     */
	@ApiModelProperty(value = "监测项目8-13项")
    private Integer monitProject13;

    /**
     * 监测项目14项以上
     */
	@ApiModelProperty(value = "监测项目14项以上")
    private Integer monitProject14;

	@ApiModelProperty(value = "ecgSt")
    private Integer ecgSt;

	@ApiModelProperty(value = "vtMv")
    private Integer vtMv;

	@ApiModelProperty(value = "petCo2")
    private Integer petCo2;

	@ApiModelProperty(value = "aGas")
    private Integer aGas;

	@ApiModelProperty(value = "fio2")
    private Integer fio2;

    /**
     * ibp
     */
	@ApiModelProperty(value = "ibp")
    private Integer ibp;

    /**
     * cvp
     */
	@ApiModelProperty(value = "cvp")
    private Integer cvp;

    /**
     * t
     */
	@ApiModelProperty(value = "t")
    private Integer t;

    /**
     * tof
     */
	@ApiModelProperty(value = "tof")
    private Integer tof;

    /**
     * 麻醉深度
     */
	@ApiModelProperty(value = "麻醉深度")
    private Integer anesDeep;

    /**
     * 心排量
     */
	@ApiModelProperty(value = "心排量")
    private Integer cardOutput;

    /**
     * tee
     */
	@ApiModelProperty(value = "tee")
    private Integer tee;

    /**
     * 血糖
     */
	@ApiModelProperty(value = "血糖")
    private Integer bloodSugar;

    /**
     * 血气
     */
	@ApiModelProperty(value = "血气")
    private Integer blood;

    /**
     * 血电解质
     */
	@ApiModelProperty(value = "血电解质")
    private Integer bloodElect;

    /**
     * 血红蛋白
     */
	@ApiModelProperty(value = "血红蛋白")
    private Integer hemoglobin;

    /**
     * 控制性降压
     */
	@ApiModelProperty(value = "控制性降压")
    private Integer controlerHyp;

    /**
     * 麻醉效果
     */
	@ApiModelProperty(value = "麻醉效果")
    private Integer anesEffect;

    /**
     * 更改麻醉方法
     */
	@ApiModelProperty(value = "更改麻醉方法")
    private Integer changeAnesMethod;

    /**
     * 更改原因
     */
	@ApiModelProperty(value = "更改原因")
    private String changeReason;
	
	/**
     * 声门暴露分级
     */
	@ApiModelProperty(value = "声门暴露分级")
    private Integer glottisExpClass;
    
    /**
     * 第几次插管成功
     */
	@ApiModelProperty(value = "第几次插管成功")
    private Integer succCount;

    public Integer getGlottisExpClass()
    {
        return glottisExpClass;
    }

    public void setGlottisExpClass(Integer glottisExpClass)
    {
        this.glottisExpClass = glottisExpClass;
    }

    public Integer getSuccCount()
    {
        return succCount;
    }

    public void setSuccCount(Integer succCount)
    {
        this.succCount = succCount;
    }

    public String getAnaSumAppGenId() {
        return anaSumAppGenId;
    }

    public void setAnaSumAppGenId(String anaSumAppGenId) {
        this.anaSumAppGenId = anaSumAppGenId == null ? null : anaSumAppGenId.trim();
    }

    public String getAnaSumId() {
        return anaSumId;
    }

    public void setAnaSumId(String anaSumId) {
        this.anaSumId = anaSumId == null ? null : anaSumId.trim();
    }

    public Integer getGenAnesthesia() {
        return genAnesthesia;
    }

    public void setGenAnesthesia(Integer genAnesthesia) {
        this.genAnesthesia = genAnesthesia;
    }

    public Integer getFastInduction() {
        return fastInduction;
    }

    public void setFastInduction(Integer fastInduction) {
        this.fastInduction = fastInduction;
    }

    public Integer getSlowInduction() {
        return slowInduction;
    }

    public void setSlowInduction(Integer slowInduction) {
        this.slowInduction = slowInduction;
    }

    public Integer getIntubation() {
        return intubation;
    }

    public void setIntubation(Integer intubation) {
        this.intubation = intubation;
    }

    public Integer getEndotracheal() {
        return endotracheal;
    }

    public void setEndotracheal(Integer endotracheal) {
        this.endotracheal = endotracheal;
    }

    public Integer getBronchial() {
        return bronchial;
    }

    public void setBronchial(Integer bronchial) {
        this.bronchial = bronchial;
    }

    public Integer getLeftChamber() {
        return leftChamber;
    }

    public void setLeftChamber(Integer leftChamber) {
        this.leftChamber = leftChamber;
    }

    public Integer getRightChamber() {
        return rightChamber;
    }

    public void setRightChamber(Integer rightChamber) {
        this.rightChamber = rightChamber;
    }

    public Integer getDoubleCavity() {
        return doubleCavity;
    }

    public void setDoubleCavity(Integer doubleCavity) {
        this.doubleCavity = doubleCavity;
    }

    public Integer getBlockDevice() {
        return blockDevice;
    }

    public void setBlockDevice(Integer blockDevice) {
        this.blockDevice = blockDevice;
    }

    public Integer getFiberLocal() {
        return fiberLocal;
    }

    public void setFiberLocal(Integer fiberLocal) {
        this.fiberLocal = fiberLocal;
    }

    public Integer getPyrosulfite() {
        return pyrosulfite;
    }

    public void setPyrosulfite(Integer pyrosulfite) {
        this.pyrosulfite = pyrosulfite;
    }

    public Integer getTransnasal() {
        return transnasal;
    }

    public void setTransnasal(Integer transnasal) {
        this.transnasal = transnasal;
    }

    public Integer getTranstracheal() {
        return transtracheal;
    }

    public void setTranstracheal(Integer transtracheal) {
        this.transtracheal = transtracheal;
    }

    public String getModel1() {
        return model1;
    }

    public void setModel1(String model1) {
        this.model1 = model1 == null ? null : model1.trim();
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public Integer getCuff() {
        return cuff;
    }

    public void setCuff(Integer cuff) {
        this.cuff = cuff;
    }

    public Integer getLook() {
        return look;
    }

    public void setLook(Integer look) {
        this.look = look;
    }

    public Integer getBlind() {
        return blind;
    }

    public void setBlind(Integer blind) {
        this.blind = blind;
    }

    public Integer getRetrograde() {
        return retrograde;
    }

    public void setRetrograde(Integer retrograde) {
        this.retrograde = retrograde;
    }

    public Integer getFiberGuide() {
        return fiberGuide;
    }

    public void setFiberGuide(Integer fiberGuide) {
        this.fiberGuide = fiberGuide;
    }

    public Integer getGlidescope() {
        return glidescope;
    }

    public void setGlidescope(Integer glidescope) {
        this.glidescope = glidescope;
    }

    public Integer getOpticalCable() {
        return opticalCable;
    }

    public void setOpticalCable(Integer opticalCable) {
        this.opticalCable = opticalCable;
    }

    public Integer getIntubationSuite() {
        return intubationSuite;
    }

    public void setIntubationSuite(Integer intubationSuite) {
        this.intubationSuite = intubationSuite;
    }

    public Integer getReinPipe() {
        return reinPipe;
    }

    public void setReinPipe(Integer reinPipe) {
        this.reinPipe = reinPipe;
    }

    public Integer getShapedTube() {
        return shapedTube;
    }

    public void setShapedTube(Integer shapedTube) {
        this.shapedTube = shapedTube;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent == null ? null : otherContent.trim();
    }

    public Integer getLaryMask() {
        return laryMask;
    }

    public void setLaryMask(Integer laryMask) {
        this.laryMask = laryMask;
    }

    public String getModel2() {
        return model2;
    }

    public void setModel2(String model2) {
        this.model2 = model2 == null ? null : model2.trim();
    }

    public Integer getDiffIntub() {
        return diffIntub;
    }

    public void setDiffIntub(Integer diffIntub) {
        this.diffIntub = diffIntub;
    }

    public String getKeepMethod() {
        return keepMethod;
    }

    public void setKeepMethod(String keepMethod) {
        this.keepMethod = keepMethod == null ? null : keepMethod.trim();
    }

    public Integer getBaseAnes() {
        return baseAnes;
    }

    public void setBaseAnes(Integer baseAnes) {
        this.baseAnes = baseAnes;
    }

    public Integer getAnesCare() {
        return anesCare;
    }

    public void setAnesCare(Integer anesCare) {
        this.anesCare = anesCare;
    }

    public Integer getMonitProject7() {
        return monitProject7;
    }

    public void setMonitProject7(Integer monitProject7) {
        this.monitProject7 = monitProject7;
    }

    public Integer getMonitProject13() {
        return monitProject13;
    }

    public void setMonitProject13(Integer monitProject13) {
        this.monitProject13 = monitProject13;
    }

    public Integer getMonitProject14() {
        return monitProject14;
    }

    public void setMonitProject14(Integer monitProject14) {
        this.monitProject14 = monitProject14;
    }

    public Integer getEcgSt() {
        return ecgSt;
    }

    public void setEcgSt(Integer ecgSt) {
        this.ecgSt = ecgSt;
    }

    public Integer getVtMv() {
        return vtMv;
    }

    public void setVtMv(Integer vtMv) {
        this.vtMv = vtMv;
    }

    public Integer getPetCo2() {
        return petCo2;
    }

    public void setPetCo2(Integer petCo2) {
        this.petCo2 = petCo2;
    }

    public Integer getaGas() {
        return aGas;
    }

    public void setaGas(Integer aGas) {
        this.aGas = aGas;
    }

    public Integer getFio2() {
        return fio2;
    }

    public void setFio2(Integer fio2) {
        this.fio2 = fio2;
    }

    public Integer getIbp() {
        return ibp;
    }

    public void setIbp(Integer ibp) {
        this.ibp = ibp;
    }

    public Integer getCvp() {
        return cvp;
    }

    public void setCvp(Integer cvp) {
        this.cvp = cvp;
    }

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    public Integer getTof() {
        return tof;
    }

    public void setTof(Integer tof) {
        this.tof = tof;
    }

    public Integer getAnesDeep() {
        return anesDeep;
    }

    public void setAnesDeep(Integer anesDeep) {
        this.anesDeep = anesDeep;
    }

    public Integer getCardOutput() {
        return cardOutput;
    }

    public void setCardOutput(Integer cardOutput) {
        this.cardOutput = cardOutput;
    }

    public Integer getTee() {
        return tee;
    }

    public void setTee(Integer tee) {
        this.tee = tee;
    }

    public Integer getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Integer bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public Integer getBloodElect() {
        return bloodElect;
    }

    public void setBloodElect(Integer bloodElect) {
        this.bloodElect = bloodElect;
    }

    public Integer getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(Integer hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public Integer getControlerHyp() {
        return controlerHyp;
    }

    public void setControlerHyp(Integer controlerHyp) {
        this.controlerHyp = controlerHyp;
    }

    public Integer getAnesEffect() {
        return anesEffect;
    }

    public void setAnesEffect(Integer anesEffect) {
        this.anesEffect = anesEffect;
    }

    public Integer getChangeAnesMethod() {
        return changeAnesMethod;
    }

    public void setChangeAnesMethod(Integer changeAnesMethod) {
        this.changeAnesMethod = changeAnesMethod;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason == null ? null : changeReason.trim();
    }
}