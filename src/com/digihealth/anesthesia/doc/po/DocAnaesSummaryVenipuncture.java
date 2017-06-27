/*
 * DocAnaesSummaryVenipuncture.java
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

@ApiModel(value = "中心静脉穿刺并发症对象")
public class DocAnaesSummaryVenipuncture {
	@ApiModelProperty(value = "主键id")
    private String anesSumVenId;

	@ApiModelProperty(value = "麻醉总结单id")
    private String anaSumId;

    /**
     * 气胸
     */
	@ApiModelProperty(value = "气胸")
    private Integer pneumothorax;

    /**
     * 血胸
     */
	@ApiModelProperty(value = "血胸")
    private Integer hemothorax;

    /**
     * 局部血肿
     */
	@ApiModelProperty(value = "局部血肿")
    private Integer localHematoma;

    /**
     * 导管异常
     */
	@ApiModelProperty(value = "导管异常")
    private Integer ductalAnomaly;

    /**
     * 导丝异常
     */
	@ApiModelProperty(value = "导丝异常")
    private Integer abnormalWire;

    /**
     * 其他
     */
	@ApiModelProperty(value = "其他")
    private Integer other;

    /**
     * 其他说明
     */
	@ApiModelProperty(value = "其他说明")
    private String otherContent;

    /**
     * 并发症发生时间
     */
	@ApiModelProperty(value = "并发症发生时间")
    private Date venipunctureTime;

    public String getAnesSumVenId() {
        return anesSumVenId;
    }

    public void setAnesSumVenId(String anesSumVenId) {
        this.anesSumVenId = anesSumVenId == null ? null : anesSumVenId.trim();
    }

    public String getAnaSumId() {
        return anaSumId;
    }

    public void setAnaSumId(String anaSumId) {
        this.anaSumId = anaSumId == null ? null : anaSumId.trim();
    }

    public Integer getPneumothorax() {
        return pneumothorax;
    }

    public void setPneumothorax(Integer pneumothorax) {
        this.pneumothorax = pneumothorax;
    }

    public Integer getHemothorax() {
        return hemothorax;
    }

    public void setHemothorax(Integer hemothorax) {
        this.hemothorax = hemothorax;
    }

    public Integer getLocalHematoma() {
        return localHematoma;
    }

    public void setLocalHematoma(Integer localHematoma) {
        this.localHematoma = localHematoma;
    }

    public Integer getDuctalAnomaly() {
        return ductalAnomaly;
    }

    public void setDuctalAnomaly(Integer ductalAnomaly) {
        this.ductalAnomaly = ductalAnomaly;
    }

    public Integer getAbnormalWire() {
        return abnormalWire;
    }

    public void setAbnormalWire(Integer abnormalWire) {
        this.abnormalWire = abnormalWire;
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

    public Date getVenipunctureTime() {
        return venipunctureTime;
    }

    public void setVenipunctureTime(Date venipunctureTime) {
        this.venipunctureTime = venipunctureTime;
    }
}