/*
 * DocInsuredChargeInform.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "参保患者使用自费药品、医用材料和服务设施告知书对象")
public class DocInsuredChargeInform {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
     private String id;

    /**
     * 患者id
     */
    @ApiModelProperty(value = "患者id")
     private String regOptId;

    /**
     * 文书状态END,NO_END
     */
    @ApiModelProperty(value = "文书状态END,NO_END")
     private String processState;

    /**
     * 是否首次进入文书标识;0-否，1-是
     */
    @ApiModelProperty(value = "是否首次进入文书标识;0-否，1-是")
     private Integer flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}