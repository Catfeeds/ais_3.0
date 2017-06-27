/*
 * DocPostFollowAnalgesic.java
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

@ApiModel(value = "麻醉术后镇痛记录对象")
public class DocPostFollowAnalgesic {
	@ApiModelProperty(value = "主键id")
    private String analgesicFollowId;

	@ApiModelProperty(value = "麻醉术后随访单id")
    private String postFollowId;

    /**
     * 观察时间
     */
	@ApiModelProperty(value = "观察时间")
    private Date observeTime;

    /**
     * 痛觉评分(安静)
     */
	@ApiModelProperty(value = "痛觉评分(安静)")
    private Integer quietScore;

    /**
     * 痛觉评分(活动)
     */
	@ApiModelProperty(value = "痛觉评分(活动)")
    private Integer activScore;

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
     * 瘙痒
     */
	@ApiModelProperty(value = "瘙痒")
    private Integer ltch;

    /**
     * 随访者
     */
	@ApiModelProperty(value = "随访者")
    private String vistorId;

    public String getAnalgesicFollowId() {
        return analgesicFollowId;
    }

    public void setAnalgesicFollowId(String analgesicFollowId) {
        this.analgesicFollowId = analgesicFollowId == null ? null : analgesicFollowId.trim();
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

    public Integer getQuietScore() {
        return quietScore;
    }

    public void setQuietScore(Integer quietScore) {
        this.quietScore = quietScore;
    }

    public Integer getActivScore() {
        return activScore;
    }

    public void setActivScore(Integer activScore) {
        this.activScore = activScore;
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

    public Integer getLtch() {
        return ltch;
    }

    public void setLtch(Integer ltch) {
        this.ltch = ltch;
    }

    public String getVistorId() {
        return vistorId;
    }

    public void setVistorId(String vistorId) {
        this.vistorId = vistorId == null ? null : vistorId.trim();
    }
}