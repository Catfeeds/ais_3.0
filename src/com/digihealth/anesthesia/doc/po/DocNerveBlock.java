/*
 * DocNerveBlock.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "神经阻滞对象")
public class DocNerveBlock {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键id")
     private String nerveBlockId;

    /**
     * 麻醉总结ID
     */
    @ApiModelProperty(value = "麻醉总结ID")
     private String anaSumId;

    /**
     * 阻滞部位
     */
    @ApiModelProperty(value = "阻滞部位")
     private String blockPoint;

    /**
     * 是否穿刺顺利
     */
    @ApiModelProperty(value = "是否穿刺顺利")
     private String isSucc;

    /**
     * 异感
     */
    @ApiModelProperty(value = "异感")
     private String diffFeel;

    /**
     * 回抽
     */
    @ApiModelProperty(value = "回抽")
     private String backBlood;

    /**
     * 实验剂量
     */
    @ApiModelProperty(value = "实验剂量")
     private String experDose;

    /**
     * 不良反应
     */
    @ApiModelProperty(value = "不良反应")
     private String untowardEffect;

    /**
     * 效果
     */
    @ApiModelProperty(value = "效果")
     private String anaesFeel;

    @ApiModelProperty(value = "succCnt")
     private String succCnt;

    public String getNerveBlockId() {
        return nerveBlockId;
    }

    public void setNerveBlockId(String nerveBlockId) {
        this.nerveBlockId = nerveBlockId == null ? null : nerveBlockId.trim();
    }

    public String getAnaSumId() {
        return anaSumId;
    }

    public void setAnaSumId(String anaSumId) {
        this.anaSumId = anaSumId == null ? null : anaSumId.trim();
    }

    public String getBlockPoint() {
        return blockPoint;
    }

    public void setBlockPoint(String blockPoint) {
        this.blockPoint = blockPoint == null ? null : blockPoint.trim();
    }

    public String getIsSucc() {
        return isSucc;
    }

    public void setIsSucc(String isSucc) {
        this.isSucc = isSucc == null ? null : isSucc.trim();
    }

    public String getDiffFeel() {
        return diffFeel;
    }

    public void setDiffFeel(String diffFeel) {
        this.diffFeel = diffFeel == null ? null : diffFeel.trim();
    }

    public String getBackBlood() {
        return backBlood;
    }

    public void setBackBlood(String backBlood) {
        this.backBlood = backBlood == null ? null : backBlood.trim();
    }

    public String getExperDose() {
        return experDose;
    }

    public void setExperDose(String experDose) {
        this.experDose = experDose == null ? null : experDose.trim();
    }

    public String getUntowardEffect() {
        return untowardEffect;
    }

    public void setUntowardEffect(String untowardEffect) {
        this.untowardEffect = untowardEffect == null ? null : untowardEffect.trim();
    }

    public String getAnaesFeel() {
        return anaesFeel;
    }

    public void setAnaesFeel(String anaesFeel) {
        this.anaesFeel = anaesFeel == null ? null : anaesFeel.trim();
    }

    public String getSuccCnt() {
        return succCnt;
    }

    public void setSuccCnt(String succCnt) {
        this.succCnt = succCnt == null ? null : succCnt.trim();
    }
}