package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "胎盘处置知情同意书对象")
public class DocPlacentaHandleAgree {
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
     * 胎盘情况
     */
    @ApiModelProperty(value = "胎盘情况")
    private Integer placentaCase;

    /**
     * 胎盘处理
     */
    @ApiModelProperty(value = "胎盘处理")
    private Integer placentaHandle;

    /**
     * 医护人员签名
     */
    @ApiModelProperty(value = "医护人员签名")
    private String docSign;

    /**
     * 文书状态，END,NO_END
     */
    @ApiModelProperty(value = "文书状态")
    private String processState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId;
    }

    public Integer getPlacentaCase() {
        return placentaCase;
    }

    public void setPlacentaCase(Integer placentaCase) {
        this.placentaCase = placentaCase;
    }

    public Integer getPlacentaHandle() {
        return placentaHandle;
    }

    public void setPlacentaHandle(Integer placentaHandle) {
        this.placentaHandle = placentaHandle;
    }

    public String getDocSign() {
        return docSign;
    }

    public void setDocSign(String docSign) {
        this.docSign = docSign;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }
}