/*
 * TmpMedicineEvent.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.tmp.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="麻醉事件模版对应的药品表对象")
public class TmpMedicineEvent {
    /**
     * 麻醉事件模版药品主键
     */
    @ApiModelProperty(value="麻醉事件模版药品主键")
    private String medEventId;

    /**
     * 模板ID
     */
    @ApiModelProperty(value="模板ID")
    private String medTempId;

    /**
     * 剂量
     */
    @ApiModelProperty(value="剂量")
    private Float dosage;

    /**
     * 浓度
     */
    @ApiModelProperty(value="浓度")
    private Float thickness;

    /**
     * 浓度单位
     */
    @ApiModelProperty(value="浓度单位")
    private String thicknessUnit;

    /**
     * 流速
     */
    @ApiModelProperty(value="流速")
    private Float flow;

    /**
     * 流速单位
     */
    @ApiModelProperty(value="流速单位")
    private String flowUnit;

    /**
     * 计价用量
     */
    @ApiModelProperty(value="计价用量")
    private Integer diluentQuant;

    /**
     * 是否是持续性 1持续，0不持续
     */
    @ApiModelProperty(value="是否是持续性")
    private String durable;

    /**
     * 开始时间
     */
    @ApiModelProperty(value="开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value="结束时间")
    private Date endTime;

    /**
     * 是否结束
     */
    @ApiModelProperty(value="是否结束")
    private Integer ended;

    /**
     * 用药类型
     */
    @ApiModelProperty(value="用药类型")
    private String type;

    @ApiModelProperty(value="创建用户")
    private String createUser;

    @ApiModelProperty(value="收费id")
    private Integer isCharged;

    @ApiModelProperty(value="药品id")
    private String medicineId;

    @ApiModelProperty(value="发生时间")
    private String occurHour;

    @ApiModelProperty(value="showOption")
    private String showOption;

    @ApiModelProperty(value="是否持续")
    private Integer isContinued;

    @ApiModelProperty(value="原因")
    private String reason;

    @ApiModelProperty(value="用药途径id")
    private String medTakeWayId;

    /**
     * 药品价格id
     */
    @ApiModelProperty(value="药品价格id")
    private String priceId;
    
    @ApiModelProperty(value="名称")
    private String name;
    
    @ApiModelProperty(value="厂家")
    private String firm;
    
    @ApiModelProperty(value="规格")
    private String spec;
    
    @ApiModelProperty(value="用药途径名称")
    private String medTakeWayName;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFirm()
    {
        return firm;
    }

    public void setFirm(String firm)
    {
        this.firm = firm;
    }

    public String getSpec()
    {
        return spec;
    }

    public void setSpec(String spec)
    {
        this.spec = spec;
    }

    public String getMedTakeWayName()
    {
        return medTakeWayName;
    }

    public void setMedTakeWayName(String medTakeWayName)
    {
        this.medTakeWayName = medTakeWayName;
    }

    public String getMedEventId() {
        return medEventId;
    }

    public void setMedEventId(String medEventId) {
        this.medEventId = medEventId == null ? null : medEventId.trim();
    }

    public String getMedTempId() {
        return medTempId;
    }

    public void setMedTempId(String medTempId) {
        this.medTempId = medTempId == null ? null : medTempId.trim();
    }

    public Float getDosage() {
        return dosage;
    }

    public void setDosage(Float dosage) {
        this.dosage = dosage;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public String getThicknessUnit() {
        return thicknessUnit;
    }

    public void setThicknessUnit(String thicknessUnit) {
        this.thicknessUnit = thicknessUnit == null ? null : thicknessUnit.trim();
    }

    public Float getFlow() {
        return flow;
    }

    public void setFlow(Float flow) {
        this.flow = flow;
    }

    public String getFlowUnit() {
        return flowUnit;
    }

    public void setFlowUnit(String flowUnit) {
        this.flowUnit = flowUnit == null ? null : flowUnit.trim();
    }

    public Integer getDiluentQuant() {
        return diluentQuant;
    }

    public void setDiluentQuant(Integer diluentQuant) {
        this.diluentQuant = diluentQuant;
    }

    public String getDurable() {
        return durable;
    }

    public void setDurable(String durable) {
        this.durable = durable == null ? null : durable.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getEnded() {
        return ended;
    }

    public void setEnded(Integer ended) {
        this.ended = ended;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Integer getIsCharged() {
        return isCharged;
    }

    public void setIsCharged(Integer isCharged) {
        this.isCharged = isCharged;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId == null ? null : medicineId.trim();
    }

    public String getOccurHour() {
        return occurHour;
    }

    public void setOccurHour(String occurHour) {
        this.occurHour = occurHour == null ? null : occurHour.trim();
    }

    public String getShowOption() {
        return showOption;
    }

    public void setShowOption(String showOption) {
        this.showOption = showOption == null ? null : showOption.trim();
    }

    public Integer getIsContinued() {
        return isContinued;
    }

    public void setIsContinued(Integer isContinued) {
        this.isContinued = isContinued;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getMedTakeWayId() {
        return medTakeWayId;
    }

    public void setMedTakeWayId(String medTakeWayId) {
        this.medTakeWayId = medTakeWayId == null ? null : medTakeWayId.trim();
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId == null ? null : priceId.trim();
    }
}