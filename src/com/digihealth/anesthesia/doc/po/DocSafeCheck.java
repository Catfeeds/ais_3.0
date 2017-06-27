/*
 * DocSafeCheck.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "安全核查对象")
public class DocSafeCheck {
	@ApiModelProperty(value = "主键id")
    private String safCheckId;

	@ApiModelProperty(value = "患者ID")
    private String regOptId;

    /**
     * 特殊耗材条码粘贴处
     */
	@ApiModelProperty(value = "特殊耗材条码粘贴处")
    private String remarks;

    /**
     * 签字时间
     */
	@ApiModelProperty(value = "签字时间")
    private String signTime;

    /**
     * 巡回护士签名
     */
	@ApiModelProperty(value = "巡回护士签名")
    private String circunurseId;

	@ApiModelProperty(value = "巡回护士签名")
    private String circunurseName;
    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成 END,NO_END")
    private String processState;

    public String getSafCheckId() {
        return safCheckId;
    }

    public void setSafCheckId(String safCheckId) {
        this.safCheckId = safCheckId == null ? null : safCheckId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public String getCircunurseId() {
		return circunurseId;
	}

	public void setCircunurseId(String circunurseId) {
		this.circunurseId = circunurseId;
	}

	public String getCircunurseName() {
		return circunurseName;
	}

	public void setCircunurseName(String circunurseName) {
		this.circunurseName = circunurseName;
	}

	public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }
}