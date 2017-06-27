/*
 * DocPatOutRangeAgree.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "医疗保险病人超范围用药对象")
public class DocPatOutRangeAgree {

	@ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 手术id
     */
	@ApiModelProperty(value = "手术id")
    private String regOptId;

    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成 END,NO_END")
    private String processState;

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
}