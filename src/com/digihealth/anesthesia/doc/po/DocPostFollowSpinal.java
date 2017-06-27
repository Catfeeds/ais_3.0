/*
 * DocPostFollowSpinal.java
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

@ApiModel(value = "椎管内麻醉观察记录对象")
public class DocPostFollowSpinal {
	@ApiModelProperty(value = "主键id")
    private String spinalFollowId;

	@ApiModelProperty(value = "麻醉术后随访单id")
    private String postFollowId;

    /**
     * 观察时间
     */
	@ApiModelProperty(value = "观察时间")
    private Date observeTime;

    /**
     * 腰痛
     */
	@ApiModelProperty(value = "腰痛")
    private Integer lumbago;

    /**
     * 恶心
     */
	@ApiModelProperty(value = "恶心")
    private Integer nausea;

    /**
     * 呕吐
     */
	@ApiModelProperty(value = "呕吐")
    private Integer vomit;

    /**
     * 下肢感觉异常
     */
	@ApiModelProperty(value = "下肢感觉异常")
    private Integer limbsFeelImp;

    /**
     * 下肢运动异常
     */
	@ApiModelProperty(value = "下肢运动异常")
    private Integer limbsMoveImp;

    /**
     * 老年认知功能障碍
     */
	@ApiModelProperty(value = "老年认知功能障碍")
    private Integer cognitObstacle;

    /**
     * 随访者
     */
	@ApiModelProperty(value = "随访者")
    private String vistorId;

    /**
     * 左下肢感觉异常
     */
	@ApiModelProperty(value = "左下肢感觉异常")
    private Integer leftLimbsFeelImp;

    /**
     * 右下肢感觉异常
     */
	@ApiModelProperty(value = "右下肢感觉异常")
    private Integer rightLimbsFeelImp;

    /**
     * 左下肢运动异常
     */
	@ApiModelProperty(value = "左下肢运动异常")
    private Integer leftMoveFeelImp;

    /**
     * 右下肢运动异常
     */
	@ApiModelProperty(value = "右下肢运动异常")
    private Integer rightMoveFeelImp;

    /**
     * 重度头痛
     */
	@ApiModelProperty(value = "重度头痛")
    private Integer severeHeadache;

    /**
     * 意识
     */
	@ApiModelProperty(value = "意识")
    private Integer consciousness;

    public String getSpinalFollowId() {
        return spinalFollowId;
    }

    public void setSpinalFollowId(String spinalFollowId) {
        this.spinalFollowId = spinalFollowId == null ? null : spinalFollowId.trim();
    }

    public String getPostFollowId() {
        return postFollowId;
    }

    public void setPostFollowId(String postFollowId) {
        this.postFollowId = postFollowId == null ? null : postFollowId.trim();
    }

    public Date getObserveTime() {
        return observeTime;
    }

    public void setObserveTime(Date observeTime) {
        this.observeTime = observeTime;
    }

    public Integer getLumbago() {
        return lumbago;
    }

    public void setLumbago(Integer lumbago) {
        this.lumbago = lumbago;
    }

    public Integer getNausea() {
        return nausea;
    }

    public void setNausea(Integer nausea) {
        this.nausea = nausea;
    }

    public Integer getVomit() {
        return vomit;
    }

    public void setVomit(Integer vomit) {
        this.vomit = vomit;
    }

    public Integer getLimbsFeelImp() {
        return limbsFeelImp;
    }

    public void setLimbsFeelImp(Integer limbsFeelImp) {
        this.limbsFeelImp = limbsFeelImp;
    }

    public Integer getLimbsMoveImp() {
        return limbsMoveImp;
    }

    public void setLimbsMoveImp(Integer limbsMoveImp) {
        this.limbsMoveImp = limbsMoveImp;
    }

    public Integer getCognitObstacle() {
        return cognitObstacle;
    }

    public void setCognitObstacle(Integer cognitObstacle) {
        this.cognitObstacle = cognitObstacle;
    }

    public String getVistorId() {
        return vistorId;
    }

    public void setVistorId(String vistorId) {
        this.vistorId = vistorId == null ? null : vistorId.trim();
    }

    public Integer getLeftLimbsFeelImp() {
        return leftLimbsFeelImp;
    }

    public void setLeftLimbsFeelImp(Integer leftLimbsFeelImp) {
        this.leftLimbsFeelImp = leftLimbsFeelImp;
    }

    public Integer getRightLimbsFeelImp() {
        return rightLimbsFeelImp;
    }

    public void setRightLimbsFeelImp(Integer rightLimbsFeelImp) {
        this.rightLimbsFeelImp = rightLimbsFeelImp;
    }

    public Integer getLeftMoveFeelImp() {
        return leftMoveFeelImp;
    }

    public void setLeftMoveFeelImp(Integer leftMoveFeelImp) {
        this.leftMoveFeelImp = leftMoveFeelImp;
    }

    public Integer getRightMoveFeelImp() {
        return rightMoveFeelImp;
    }

    public void setRightMoveFeelImp(Integer rightMoveFeelImp) {
        this.rightMoveFeelImp = rightMoveFeelImp;
    }

    public Integer getSevereHeadache() {
        return severeHeadache;
    }

    public void setSevereHeadache(Integer severeHeadache) {
        this.severeHeadache = severeHeadache;
    }

    public Integer getConsciousness() {
        return consciousness;
    }

    public void setConsciousness(Integer consciousness) {
        this.consciousness = consciousness;
    }
}