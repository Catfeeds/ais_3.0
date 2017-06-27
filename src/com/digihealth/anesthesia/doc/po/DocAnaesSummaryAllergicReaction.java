/*
 * DocAnaesSummaryAllergicReaction.java
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

@ApiModel(value = "麻醉期间严重过敏反应对象")
public class DocAnaesSummaryAllergicReaction {
	@ApiModelProperty(value = "主键id")
    private String anaSumAllReaId;

	@ApiModelProperty(value = "麻醉总结单id")
    private String anaSumId;

    /**
     * 麻醉期间严重过敏反应
     */
	@ApiModelProperty(value = "麻醉期间严重过敏反应")
    private String allergicReaction;

    /**
     * 循环衰竭
     */
	@ApiModelProperty(value = "循环衰竭")
    private Integer circulatFailure;

    /**
     * 衰竭原因
     */
	@ApiModelProperty(value = "衰竭原因")
    private String failureContents;

    /**
     * 明显皮疹
     */
	@ApiModelProperty(value = "明显皮疹")
    private Integer obviousRash;

    /**
     * 皮疹情况
     */
	@ApiModelProperty(value = "皮疹情况")
    private String rashContents;

    /**
     * 严重气道反应
     */
	@ApiModelProperty(value = "严重气道反应")
    private Integer airwayResp;

    /**
     * 痉挛
     */
	@ApiModelProperty(value = "痉挛")
    private Integer spasm;

    /**
     * 水肿
     */
	@ApiModelProperty(value = "水肿")
    private Integer edema;

    /**
     * 气道反应说明
     */
	@ApiModelProperty(value = "气道反应说明")
    private String airwayContents;

    /**
     * 肾上腺素
     */
	@ApiModelProperty(value = "肾上腺素")
    private Integer adrenaline;

    /**
     * 过敏反应发生时间
     */
	@ApiModelProperty(value = "过敏反应发生时间")
    private Date allergicReactionTime;

    public String getAnaSumAllReaId() {
        return anaSumAllReaId;
    }

    public void setAnaSumAllReaId(String anaSumAllReaId) {
        this.anaSumAllReaId = anaSumAllReaId == null ? null : anaSumAllReaId.trim();
    }

    public String getAnaSumId() {
        return anaSumId;
    }

    public void setAnaSumId(String anaSumId) {
        this.anaSumId = anaSumId == null ? null : anaSumId.trim();
    }

    public String getAllergicReaction() {
        return allergicReaction;
    }

    public void setAllergicReaction(String allergicReaction) {
        this.allergicReaction = allergicReaction == null ? null : allergicReaction.trim();
    }

    public Integer getCirculatFailure() {
        return circulatFailure;
    }

    public void setCirculatFailure(Integer circulatFailure) {
        this.circulatFailure = circulatFailure;
    }

    public String getFailureContents() {
        return failureContents;
    }

    public void setFailureContents(String failureContents) {
        this.failureContents = failureContents == null ? null : failureContents.trim();
    }

    public Integer getObviousRash() {
        return obviousRash;
    }

    public void setObviousRash(Integer obviousRash) {
        this.obviousRash = obviousRash;
    }

    public String getRashContents() {
        return rashContents;
    }

    public void setRashContents(String rashContents) {
        this.rashContents = rashContents == null ? null : rashContents.trim();
    }

    public Integer getAirwayResp() {
        return airwayResp;
    }

    public void setAirwayResp(Integer airwayResp) {
        this.airwayResp = airwayResp;
    }

    public Integer getSpasm() {
        return spasm;
    }

    public void setSpasm(Integer spasm) {
        this.spasm = spasm;
    }

    public Integer getEdema() {
        return edema;
    }

    public void setEdema(Integer edema) {
        this.edema = edema;
    }

    public String getAirwayContents() {
        return airwayContents;
    }

    public void setAirwayContents(String airwayContents) {
        this.airwayContents = airwayContents == null ? null : airwayContents.trim();
    }

    public Integer getAdrenaline() {
        return adrenaline;
    }

    public void setAdrenaline(Integer adrenaline) {
        this.adrenaline = adrenaline;
    }

    public Date getAllergicReactionTime() {
        return allergicReactionTime;
    }

    public void setAllergicReactionTime(Date allergicReactionTime) {
        this.allergicReactionTime = allergicReactionTime;
    }
}