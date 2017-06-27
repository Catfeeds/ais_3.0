/*
 * DocAnaesSummaryAppendixCanal.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉总结附录单椎管穿刺麻醉对象")
public class DocAnaesSummaryAppendixCanal {
	@ApiModelProperty(value = "主键id")
    private String anaSumAppCanId;

	@ApiModelProperty(value = "麻醉总结单id")
    private String anaSumId;

    /**
     * 椎管内麻醉
     */
	@ApiModelProperty(value = "椎管内麻醉")
    private Integer spinalAnes;

    /**
     * 腰麻
     */
	@ApiModelProperty(value = "腰麻")
    private Integer waistAnes;

    /**
     * 硬膜外麻醉
     */
	@ApiModelProperty(value = "硬膜外麻醉")
    private Integer epiduralAnes;

    /**
     * 腰硬联合麻醉
     */
	@ApiModelProperty(value = "腰硬联合麻醉")
    private Integer cseUnionAnes;

    /**
     * 骶麻
     */
	@ApiModelProperty(value = "骶麻")
    private Integer sacralAnes;

    /**
     * 穿刺点
     */
	@ApiModelProperty(value = "穿刺点")
    private String puncPoint1;

    /**
     * 置管位置
     */
	@ApiModelProperty(value = "置管位置")
    private Float catheterPoint1;

    /**
     * 方向
     */
	@ApiModelProperty(value = "方向")
    private String direction1;

    /**
     * 穿刺点2
     */
	@ApiModelProperty(value = "穿刺点2")
    private String puncPoint2;

    /**
     * 置管位置2
     */
	@ApiModelProperty(value = "置管位置2")
    private Float catheterPoint2;

    /**
     * 方向2
     */
	@ApiModelProperty(value = "方向2")
    private String direction2;

    /**
     * 麻醉平面
     */
	@ApiModelProperty(value = "麻醉平面")
    private String anesFlat;

    /**
     * 药品
     */
	@ApiModelProperty(value = "药品")
    private String medicine;

    /**
     * 神经阻滞
     */
	@ApiModelProperty(value = "神经阻滞")
    private Integer nerveBlock;

    /**
     * 超声定位
     */
	@ApiModelProperty(value = "超声定位")
    private Integer ultrasound;

    /**
     * 神经刺激器
     */
	@ApiModelProperty(value = "神经刺激器")
    private Integer nerveStimulator;

    /**
     * 颈丛神经阻滞
     */
	@ApiModelProperty(value = "颈丛神经阻滞")
    private Integer cervicalPlexusBlock;

    /**
     * 浅丛 左\右
     */
	@ApiModelProperty(value = "浅丛 左\\右")
    private Integer shallowCong;

    /**
     * 深丛 左\右
     */
	@ApiModelProperty(value = "深丛 左\\右")
    private Integer deepPlexus;

    /**
     * c
     */
	@ApiModelProperty(value = "c")
    private String c;

    /**
     * 臂丛神经阻滞
     */
	@ApiModelProperty(value = "臂丛神经阻滞")
    private Integer brachialPlexusBlock;

    /**
     * 臂丛神经阻滞 (左\右)
     */
	@ApiModelProperty(value = "臂丛神经阻滞 (左\\右)")
    private Integer brachialValue;

    /**
     * 肌间沟法
     */
	@ApiModelProperty(value = "肌间沟法")
    private Integer interscaleneLaw;

    /**
     * 腋路法
     */
	@ApiModelProperty(value = "腋路法")
    private Integer axillaryMethod;

    /**
     * 锁骨上法
     */
	@ApiModelProperty(value = "锁骨上法")
    private Integer clavicleLaw;

    /**
     * 腰丛神经阻滞
     */
	@ApiModelProperty(value = "腰丛神经阻滞")
    private Integer waistPlexusBlock;

    /**
     * 腰丛神经阻滞值
     */
	@ApiModelProperty(value = "腰丛神经阻滞值")
    private Integer waistPlexusValue;

    /**
     * 坐骨神经阻滞
     */
	@ApiModelProperty(value = "坐骨神经阻滞")
    private Integer sciaticNerveBlock;

    /**
     * 坐骨神经阻滞值
     */
	@ApiModelProperty(value = "坐骨神经阻滞值")
    private Integer sciaticNerveValue;

    /**
     * 股神经阻滞
     */
	@ApiModelProperty(value = "股神经阻滞")
    private Integer femoralNerveBlock;

    /**
     * 股神经阻滞值
     */
	@ApiModelProperty(value = "股神经阻滞值")
    private Integer femoralNerveValue;

    /**
     * 股外侧皮神经阻滞
     */
	@ApiModelProperty(value = "股外侧皮神经阻滞")
    private Integer cutaneousNerveBlock;

    /**
     * 股外侧皮神经阻滞值
     */
	@ApiModelProperty(value = "股外侧皮神经阻滞值")
    private Integer cutaneousNerveValue;

    /**
     * 其他
     */
	@ApiModelProperty(value = "其他")
    private Integer other1;

    /**
     * 其他说明
     */
	@ApiModelProperty(value = "其他说明")
    private String other1Value;

    /**
     * 药品1
     */
	@ApiModelProperty(value = "药品1")
    private String medicine1;

    /**
     * 有创操作
     */
	@ApiModelProperty(value = "有创操作")
    private Integer invasiveProcedure;

    /**
     * 动脉穿刺置管
     */
	@ApiModelProperty(value = "动脉穿刺置管")
    private Integer arteryCathete;

    /**
     * 桡动脉
     */
	@ApiModelProperty(value = "桡动脉")
    private Integer radialArtery;

    /**
     * 股动脉
     */
	@ApiModelProperty(value = "股动脉")
    private Integer femoralArtery;

    /**
     * 足背动脉
     */
	@ApiModelProperty(value = "足背动脉")
    private Integer footArtery;

    /**
     * 足背动脉(左\右)
     */
	@ApiModelProperty(value = "足背动脉(左\\右)")
    private Integer footArteryValue;

    /**
     * 深静脉穿刺置管
     */
	@ApiModelProperty(value = "深静脉穿刺置管")
    private Integer deepVeinCathete;

    /**
     * 颈内静脉
     */
	@ApiModelProperty(value = "颈内静脉")
    private Integer jugularVein;

    /**
     * 锁骨下静脉
     */
	@ApiModelProperty(value = "锁骨下静脉")
    private Integer subclavianVein;

    /**
     * 股静脉
     */
	@ApiModelProperty(value = "股静脉")
    private Integer femoralVein;

    /**
     * 股静脉(左\右)
     */
	@ApiModelProperty(value = "股静脉(左\\右)")
    private Integer femoralVeinValue;

    /**
     * 超声定位
     */
	@ApiModelProperty(value = "超声定位")
    private Integer ultrasound1;

    /**
     * 单腔
     */
	@ApiModelProperty(value = "单腔")
    private Integer singleChamber;

    /**
     * 双腔
     */
	@ApiModelProperty(value = "双腔")
    private Integer dualChamber;

    /**
     * 三腔
     */
	@ApiModelProperty(value = "三腔")
    private Integer threeChamber;

    /**
     * SG导管
     */
	@ApiModelProperty(value = "SG导管")
    private Integer sgCatheter;

    /**
     * 其他2
     */
	@ApiModelProperty(value = "其他2")
    private String other2;

    public String getAnaSumAppCanId() {
        return anaSumAppCanId;
    }

    public void setAnaSumAppCanId(String anaSumAppCanId) {
        this.anaSumAppCanId = anaSumAppCanId == null ? null : anaSumAppCanId.trim();
    }

    public String getAnaSumId() {
        return anaSumId;
    }

    public void setAnaSumId(String anaSumId) {
        this.anaSumId = anaSumId == null ? null : anaSumId.trim();
    }

    public Integer getSpinalAnes() {
        return spinalAnes;
    }

    public void setSpinalAnes(Integer spinalAnes) {
        this.spinalAnes = spinalAnes;
    }

    public Integer getWaistAnes() {
        return waistAnes;
    }

    public void setWaistAnes(Integer waistAnes) {
        this.waistAnes = waistAnes;
    }

    public Integer getEpiduralAnes() {
        return epiduralAnes;
    }

    public void setEpiduralAnes(Integer epiduralAnes) {
        this.epiduralAnes = epiduralAnes;
    }

    public Integer getCseUnionAnes() {
        return cseUnionAnes;
    }

    public void setCseUnionAnes(Integer cseUnionAnes) {
        this.cseUnionAnes = cseUnionAnes;
    }

    public Integer getSacralAnes() {
        return sacralAnes;
    }

    public void setSacralAnes(Integer sacralAnes) {
        this.sacralAnes = sacralAnes;
    }

    public String getPuncPoint1() {
        return puncPoint1;
    }

    public void setPuncPoint1(String puncPoint1) {
        this.puncPoint1 = puncPoint1 == null ? null : puncPoint1.trim();
    }

    public Float getCatheterPoint1() {
        return catheterPoint1;
    }

    public void setCatheterPoint1(Float catheterPoint1) {
        this.catheterPoint1 = catheterPoint1;
    }

    public String getDirection1() {
        return direction1;
    }

    public void setDirection1(String direction1) {
        this.direction1 = direction1 == null ? null : direction1.trim();
    }

    public String getPuncPoint2() {
        return puncPoint2;
    }

    public void setPuncPoint2(String puncPoint2) {
        this.puncPoint2 = puncPoint2 == null ? null : puncPoint2.trim();
    }

    public Float getCatheterPoint2() {
        return catheterPoint2;
    }

    public void setCatheterPoint2(Float catheterPoint2) {
        this.catheterPoint2 = catheterPoint2;
    }

    public String getDirection2() {
        return direction2;
    }

    public void setDirection2(String direction2) {
        this.direction2 = direction2 == null ? null : direction2.trim();
    }

    public String getAnesFlat() {
        return anesFlat;
    }

    public void setAnesFlat(String anesFlat) {
        this.anesFlat = anesFlat == null ? null : anesFlat.trim();
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine == null ? null : medicine.trim();
    }

    public Integer getNerveBlock() {
        return nerveBlock;
    }

    public void setNerveBlock(Integer nerveBlock) {
        this.nerveBlock = nerveBlock;
    }

    public Integer getUltrasound() {
        return ultrasound;
    }

    public void setUltrasound(Integer ultrasound) {
        this.ultrasound = ultrasound;
    }

    public Integer getNerveStimulator() {
        return nerveStimulator;
    }

    public void setNerveStimulator(Integer nerveStimulator) {
        this.nerveStimulator = nerveStimulator;
    }

    public Integer getCervicalPlexusBlock() {
        return cervicalPlexusBlock;
    }

    public void setCervicalPlexusBlock(Integer cervicalPlexusBlock) {
        this.cervicalPlexusBlock = cervicalPlexusBlock;
    }

    public Integer getShallowCong() {
        return shallowCong;
    }

    public void setShallowCong(Integer shallowCong) {
        this.shallowCong = shallowCong;
    }

    public Integer getDeepPlexus() {
        return deepPlexus;
    }

    public void setDeepPlexus(Integer deepPlexus) {
        this.deepPlexus = deepPlexus;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c == null ? null : c.trim();
    }

    public Integer getBrachialPlexusBlock() {
        return brachialPlexusBlock;
    }

    public void setBrachialPlexusBlock(Integer brachialPlexusBlock) {
        this.brachialPlexusBlock = brachialPlexusBlock;
    }

    public Integer getBrachialValue() {
        return brachialValue;
    }

    public void setBrachialValue(Integer brachialValue) {
        this.brachialValue = brachialValue;
    }

    public Integer getInterscaleneLaw() {
        return interscaleneLaw;
    }

    public void setInterscaleneLaw(Integer interscaleneLaw) {
        this.interscaleneLaw = interscaleneLaw;
    }

    public Integer getAxillaryMethod() {
        return axillaryMethod;
    }

    public void setAxillaryMethod(Integer axillaryMethod) {
        this.axillaryMethod = axillaryMethod;
    }

    public Integer getClavicleLaw() {
        return clavicleLaw;
    }

    public void setClavicleLaw(Integer clavicleLaw) {
        this.clavicleLaw = clavicleLaw;
    }

    public Integer getWaistPlexusBlock() {
        return waistPlexusBlock;
    }

    public void setWaistPlexusBlock(Integer waistPlexusBlock) {
        this.waistPlexusBlock = waistPlexusBlock;
    }

    public Integer getWaistPlexusValue() {
        return waistPlexusValue;
    }

    public void setWaistPlexusValue(Integer waistPlexusValue) {
        this.waistPlexusValue = waistPlexusValue;
    }

    public Integer getSciaticNerveBlock() {
        return sciaticNerveBlock;
    }

    public void setSciaticNerveBlock(Integer sciaticNerveBlock) {
        this.sciaticNerveBlock = sciaticNerveBlock;
    }

    public Integer getSciaticNerveValue() {
        return sciaticNerveValue;
    }

    public void setSciaticNerveValue(Integer sciaticNerveValue) {
        this.sciaticNerveValue = sciaticNerveValue;
    }

    public Integer getFemoralNerveBlock() {
        return femoralNerveBlock;
    }

    public void setFemoralNerveBlock(Integer femoralNerveBlock) {
        this.femoralNerveBlock = femoralNerveBlock;
    }

    public Integer getFemoralNerveValue() {
        return femoralNerveValue;
    }

    public void setFemoralNerveValue(Integer femoralNerveValue) {
        this.femoralNerveValue = femoralNerveValue;
    }

    public Integer getCutaneousNerveBlock() {
        return cutaneousNerveBlock;
    }

    public void setCutaneousNerveBlock(Integer cutaneousNerveBlock) {
        this.cutaneousNerveBlock = cutaneousNerveBlock;
    }

    public Integer getCutaneousNerveValue() {
        return cutaneousNerveValue;
    }

    public void setCutaneousNerveValue(Integer cutaneousNerveValue) {
        this.cutaneousNerveValue = cutaneousNerveValue;
    }

    public Integer getOther1() {
        return other1;
    }

    public void setOther1(Integer other1) {
        this.other1 = other1;
    }

    public String getOther1Value() {
        return other1Value;
    }

    public void setOther1Value(String other1Value) {
        this.other1Value = other1Value == null ? null : other1Value.trim();
    }

    public String getMedicine1() {
        return medicine1;
    }

    public void setMedicine1(String medicine1) {
        this.medicine1 = medicine1 == null ? null : medicine1.trim();
    }

    public Integer getInvasiveProcedure() {
        return invasiveProcedure;
    }

    public void setInvasiveProcedure(Integer invasiveProcedure) {
        this.invasiveProcedure = invasiveProcedure;
    }

    public Integer getArteryCathete() {
        return arteryCathete;
    }

    public void setArteryCathete(Integer arteryCathete) {
        this.arteryCathete = arteryCathete;
    }

    public Integer getRadialArtery() {
        return radialArtery;
    }

    public void setRadialArtery(Integer radialArtery) {
        this.radialArtery = radialArtery;
    }

    public Integer getFemoralArtery() {
        return femoralArtery;
    }

    public void setFemoralArtery(Integer femoralArtery) {
        this.femoralArtery = femoralArtery;
    }

    public Integer getFootArtery() {
        return footArtery;
    }

    public void setFootArtery(Integer footArtery) {
        this.footArtery = footArtery;
    }

    public Integer getFootArteryValue() {
        return footArteryValue;
    }

    public void setFootArteryValue(Integer footArteryValue) {
        this.footArteryValue = footArteryValue;
    }

    public Integer getDeepVeinCathete() {
        return deepVeinCathete;
    }

    public void setDeepVeinCathete(Integer deepVeinCathete) {
        this.deepVeinCathete = deepVeinCathete;
    }

    public Integer getJugularVein() {
        return jugularVein;
    }

    public void setJugularVein(Integer jugularVein) {
        this.jugularVein = jugularVein;
    }

    public Integer getSubclavianVein() {
        return subclavianVein;
    }

    public void setSubclavianVein(Integer subclavianVein) {
        this.subclavianVein = subclavianVein;
    }

    public Integer getFemoralVein() {
        return femoralVein;
    }

    public void setFemoralVein(Integer femoralVein) {
        this.femoralVein = femoralVein;
    }

    public Integer getFemoralVeinValue() {
        return femoralVeinValue;
    }

    public void setFemoralVeinValue(Integer femoralVeinValue) {
        this.femoralVeinValue = femoralVeinValue;
    }

    public Integer getUltrasound1() {
        return ultrasound1;
    }

    public void setUltrasound1(Integer ultrasound1) {
        this.ultrasound1 = ultrasound1;
    }

    public Integer getSingleChamber() {
        return singleChamber;
    }

    public void setSingleChamber(Integer singleChamber) {
        this.singleChamber = singleChamber;
    }

    public Integer getDualChamber() {
        return dualChamber;
    }

    public void setDualChamber(Integer dualChamber) {
        this.dualChamber = dualChamber;
    }

    public Integer getThreeChamber() {
        return threeChamber;
    }

    public void setThreeChamber(Integer threeChamber) {
        this.threeChamber = threeChamber;
    }

    public Integer getSgCatheter() {
        return sgCatheter;
    }

    public void setSgCatheter(Integer sgCatheter) {
        this.sgCatheter = sgCatheter;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2 == null ? null : other2.trim();
    }
}