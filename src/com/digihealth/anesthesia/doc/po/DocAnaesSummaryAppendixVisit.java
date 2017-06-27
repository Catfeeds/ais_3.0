/*
 * DocAnaesSummaryAppendixVisit.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉总结附录单术后访视记录对象")
public class DocAnaesSummaryAppendixVisit {
    /**
     * 麻醉总结术后访视记录
     */
	@ApiModelProperty(value = "主键id")
    private String anesSumVisId;

	@ApiModelProperty(value = "麻醉总结单id")
    private String anaSumId;

    /**
     * 循环合并症
     */
	@ApiModelProperty(value = "循环合并症")
    private Integer cycleComb;

    /**
     * 呼吸合并症
     */
	@ApiModelProperty(value = "呼吸合并症")
    private Integer breathComb;

    /**
     * 意识障碍
     */
	@ApiModelProperty(value = "意识障碍")
    private Integer confusion;

    /**
     * 认知障碍
     */
	@ApiModelProperty(value = "认知障碍")
    private Integer cognitive;

    /**
     * 术中知晓
     */
	@ApiModelProperty(value = "术中知晓")
    private Integer intraAware;

    /**
     * 运动障碍
     */
	@ApiModelProperty(value = "运动障碍")
    private Integer moveDis;

    /**
     * 导尿管
     */
	@ApiModelProperty(value = "导尿管")
    private Integer catheters;

    /**
     * 恶心呕吐
     */
	@ApiModelProperty(value = "恶心呕吐")
    private Integer nausea;

    /**
     * 红肿压痛
     */
	@ApiModelProperty(value = "红肿压痛")
    private Integer redTender;

    /**
     * 喉咙痛
     */
	@ApiModelProperty(value = "喉咙痛")
    private Integer soreThroat;

    /**
     * 声嘶
     */
	@ApiModelProperty(value = "声嘶")
    private Integer hoarseness;

    /**
     * 视力障碍
     */
	@ApiModelProperty(value = "视力障碍")
    private Integer visualImpair;

    /**
     * 视力障碍值
     */
	@ApiModelProperty(value = "视力障碍值")
    private Integer visualImpairValue;

    /**
     * 留置心静脉导管者
     */
	@ApiModelProperty(value = "留置心静脉导管者")
    private Integer indwelVeinCathetor;

    /**
     * 留置心静脉导管值
     */
	@ApiModelProperty(value = "留置心静脉导管值")
    private Integer indwelVeinValue;

    /**
     * 留置心动脉导管者
     */
	@ApiModelProperty(value = "留置心动脉导管者")
    private Integer indwelArteryCathetor;

    /**
     * 留置心动脉导管值
     */
	@ApiModelProperty(value = "留置心动脉导管值")
    private Integer indwelArteryValue;

    /**
     * 其他
     */
	@ApiModelProperty(value = "其他")
    private Integer other;

    /**
     * 说明与医嘱
     */
	@ApiModelProperty(value = "说明与医嘱")
    private String doctorAdvice;

    public String getAnesSumVisId() {
        return anesSumVisId;
    }

    public void setAnesSumVisId(String anesSumVisId) {
        this.anesSumVisId = anesSumVisId == null ? null : anesSumVisId.trim();
    }

    public String getAnaSumId() {
        return anaSumId;
    }

    public void setAnaSumId(String anaSumId) {
        this.anaSumId = anaSumId == null ? null : anaSumId.trim();
    }

    public Integer getCycleComb() {
        return cycleComb;
    }

    public void setCycleComb(Integer cycleComb) {
        this.cycleComb = cycleComb;
    }

    public Integer getBreathComb() {
        return breathComb;
    }

    public void setBreathComb(Integer breathComb) {
        this.breathComb = breathComb;
    }

    public Integer getConfusion() {
        return confusion;
    }

    public void setConfusion(Integer confusion) {
        this.confusion = confusion;
    }

    public Integer getCognitive() {
        return cognitive;
    }

    public void setCognitive(Integer cognitive) {
        this.cognitive = cognitive;
    }

    public Integer getIntraAware() {
        return intraAware;
    }

    public void setIntraAware(Integer intraAware) {
        this.intraAware = intraAware;
    }

    public Integer getMoveDis() {
        return moveDis;
    }

    public void setMoveDis(Integer moveDis) {
        this.moveDis = moveDis;
    }

    public Integer getCatheters() {
        return catheters;
    }

    public void setCatheters(Integer catheters) {
        this.catheters = catheters;
    }

    public Integer getNausea() {
        return nausea;
    }

    public void setNausea(Integer nausea) {
        this.nausea = nausea;
    }

    public Integer getRedTender() {
        return redTender;
    }

    public void setRedTender(Integer redTender) {
        this.redTender = redTender;
    }

    public Integer getSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(Integer soreThroat) {
        this.soreThroat = soreThroat;
    }

    public Integer getHoarseness() {
        return hoarseness;
    }

    public void setHoarseness(Integer hoarseness) {
        this.hoarseness = hoarseness;
    }

    public Integer getVisualImpair() {
        return visualImpair;
    }

    public void setVisualImpair(Integer visualImpair) {
        this.visualImpair = visualImpair;
    }

    public Integer getVisualImpairValue() {
        return visualImpairValue;
    }

    public void setVisualImpairValue(Integer visualImpairValue) {
        this.visualImpairValue = visualImpairValue;
    }

    public Integer getIndwelVeinCathetor() {
        return indwelVeinCathetor;
    }

    public void setIndwelVeinCathetor(Integer indwelVeinCathetor) {
        this.indwelVeinCathetor = indwelVeinCathetor;
    }

    public Integer getIndwelVeinValue() {
        return indwelVeinValue;
    }

    public void setIndwelVeinValue(Integer indwelVeinValue) {
        this.indwelVeinValue = indwelVeinValue;
    }

    public Integer getIndwelArteryCathetor() {
        return indwelArteryCathetor;
    }

    public void setIndwelArteryCathetor(Integer indwelArteryCathetor) {
        this.indwelArteryCathetor = indwelArteryCathetor;
    }

    public Integer getIndwelArteryValue() {
        return indwelArteryValue;
    }

    public void setIndwelArteryValue(Integer indwelArteryValue) {
        this.indwelArteryValue = indwelArteryValue;
    }

    public Integer getOther() {
        return other;
    }

    public void setOther(Integer other) {
        this.other = other;
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice == null ? null : doctorAdvice.trim();
    }
}