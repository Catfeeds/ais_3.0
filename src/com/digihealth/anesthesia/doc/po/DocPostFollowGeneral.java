/*
 * DocPostFollowGeneral.java
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

@ApiModel(value = "全麻术后观察记录对象")
public class DocPostFollowGeneral {
    /**
     * 主键
     */
	@ApiModelProperty(value = "主键id")
    private String generalFolllowId;

	@ApiModelProperty(value = "麻醉术后随访单id")
    private String postFollowId;

    /**
     * 观察时间
     */
	@ApiModelProperty(value = "观察时间")
    private Date observeTime;

    /**
     * 术中知晓
     */
	@ApiModelProperty(value = "术中知晓")
    private Integer intraAware;

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
     * 咽喉痛
     */
	@ApiModelProperty(value = "咽喉痛")
    private Integer soreThroat;

    /**
     * 声音嘶哑
     */
	@ApiModelProperty(value = "声音嘶哑")
    private Integer hoarse;

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
     * 意识
     */
	@ApiModelProperty(value = "意识")
    private Integer consciousness;

    public String getGeneralFolllowId() {
        return generalFolllowId;
    }

    public void setGeneralFolllowId(String generalFolllowId) {
        this.generalFolllowId = generalFolllowId == null ? null : generalFolllowId.trim();
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

    public Integer getIntraAware() {
        return intraAware;
    }

    public void setIntraAware(Integer intraAware) {
        this.intraAware = intraAware;
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

    public Integer getSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(Integer soreThroat) {
        this.soreThroat = soreThroat;
    }

    public Integer getHoarse() {
        return hoarse;
    }

    public void setHoarse(Integer hoarse) {
        this.hoarse = hoarse;
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

    public Integer getConsciousness() {
        return consciousness;
    }

    public void setConsciousness(Integer consciousness) {
        this.consciousness = consciousness;
    }
}