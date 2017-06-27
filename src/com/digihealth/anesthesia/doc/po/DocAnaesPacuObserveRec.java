/*
 * DocAnaesPacuObserveRec.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.digihealth.anesthesia.evt.formbean.SearchOptOperIoevent;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperMedicalevent;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="复苏记录单对象")
public class DocAnaesPacuObserveRec {
    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
     * 复苏单id
     */
    @ApiModelProperty(value="复苏单id")
    private String pacuRecId;

    /**
     * hr 心率 次/分
     */
    @ApiModelProperty(value="心率")
    private Float hr;

    /**
     * pr 脉搏 次/分
     */
    @ApiModelProperty(value="脉搏")
    private Float r;

    /**
     * bp 血压
     */
    @ApiModelProperty(value="血压")
    private Float bp;

    /**
     * SPO2
     */
    @ApiModelProperty(value="SPO2")
    private Float spo2;

    /**
     * 吸氧方式
     */
    @ApiModelProperty(value="吸氧方式")
    private Integer oxInhalMeth;

    /**
     * 流量
     */
    @ApiModelProperty(value="流量")
    private Float oxFlow;

    /**
     * 清醒程度
     */
    @ApiModelProperty(value="清醒程度")
    private Integer consLev;

    /**
     * 呼吸道通畅程度
     */
    @ApiModelProperty(value="呼吸道通畅程度")
    private Integer airwayPatency;

    /**
     * 肢体活动度
     */
    @ApiModelProperty(value="肢体活动度")
    private Integer physicalActivity;

    /**
     * 输液通畅
     */
    @ApiModelProperty(value="输液通畅")
    private Integer fluidInfusion;

    /**
     * 是否有导尿管
     */
    @ApiModelProperty(value="是否有导尿管")
    private Integer catheter;

    /**
     * 尿量
     */
    @ApiModelProperty(value="尿量")
    private Float upd;

    /**
     * 小便性状
     */
    @ApiModelProperty(value="小便性状")
    private String urineCharac;

    /**
     * 哭闹程度
     */
    @ApiModelProperty(value="哭闹程度")
    private Integer cryingDegree;

    /**
     * 恶心呕吐
     */
    @ApiModelProperty(value="恶心呕吐")
    private Integer nauseaVomit;

    /**
     * 寒颤
     */
    @ApiModelProperty(value="寒颤")
    private Integer shivering;

    /**
     * 疼痛评分
     */
    @ApiModelProperty(value="疼痛评分")
    private Integer painScore;

    /**
     * 伤口情况
     */
    @ApiModelProperty(value="伤口情况")
    private String woundCondition;

    /**
     * 引流性状
     */
    @ApiModelProperty(value="引流性状")
    private String drainageCharac;

    /**
     * 引流量
     */
    @ApiModelProperty(value="引流量")
    private Float drainageFlow;

    /**
     * 观察记录
     */
    @ApiModelProperty(value="观察记录")
    private String obserRec;

    /**
     * 0：液体；1：药
     */
    @ApiModelProperty(value="0：液体；1：药")
    private Integer medType;

    /**
     * 液体/药物Id，多个以“，”分隔
     */
    @ApiModelProperty(value="液体/药物Id")
    private String medId;

    /**
     * 液体/药物名称
     */
    @ApiModelProperty(value="液体/药物名称")
    private String medName;

    /**
     * 液体/药物量
     */
    @ApiModelProperty(value="液体/药物量")
    private Float medFlow;

    /**
     * 液体/药物单位
     */
    @ApiModelProperty(value="液体/药物单位")
    private String medUnit;

    @ApiModelProperty(value="签名")
    private String sign;

    @ApiModelProperty(value="记录时间")
    private Date recordTime;

    /**
     * 高血压
     */
    @ApiModelProperty(value="高血压")
    private Float hypertension;

    /**
     * 低血压
     */
    @ApiModelProperty(value="低血压")
    private Float hypopiesia;
    
    // 药品list
    @ApiModelProperty(value="药品集合")
    private List<SearchOptOperMedicalevent> obsMedList = new ArrayList<SearchOptOperMedicalevent>();

    // 药品LIST
    @ApiModelProperty(value="药品集合")
    private List<SearchOptOperMedicalevent> medList = new ArrayList<SearchOptOperMedicalevent>();

    // 液体LIST
    @ApiModelProperty(value="液体集合")
    private List<SearchOptOperIoevent> ioList = new ArrayList<SearchOptOperIoevent>();

    public List<SearchOptOperMedicalevent> getObsMedList()
    {
        return obsMedList;
    }

    public void setObsMedList(List<SearchOptOperMedicalevent> obsMedList)
    {
        this.obsMedList = obsMedList;
    }

    public List<SearchOptOperMedicalevent> getMedList()
    {
        return medList;
    }

    public void setMedList(List<SearchOptOperMedicalevent> medList)
    {
        this.medList = medList;
    }

    public List<SearchOptOperIoevent> getIoList()
    {
        return ioList;
    }

    public void setIoList(List<SearchOptOperIoevent> ioList)
    {
        this.ioList = ioList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPacuRecId() {
        return pacuRecId;
    }

    public void setPacuRecId(String pacuRecId) {
        this.pacuRecId = pacuRecId == null ? null : pacuRecId.trim();
    }

    public Float getHr() {
        return hr;
    }

    public void setHr(Float hr) {
        this.hr = hr;
    }

    public Float getR() {
        return r;
    }

    public void setR(Float r) {
        this.r = r;
    }

    public Float getBp() {
        return bp;
    }

    public void setBp(Float bp) {
        this.bp = bp;
    }

    public Float getSpo2() {
        return spo2;
    }

    public void setSpo2(Float spo2) {
        this.spo2 = spo2;
    }

    public Integer getOxInhalMeth() {
        return oxInhalMeth;
    }

    public void setOxInhalMeth(Integer oxInhalMeth) {
        this.oxInhalMeth = oxInhalMeth;
    }

    public Float getOxFlow() {
        return oxFlow;
    }

    public void setOxFlow(Float oxFlow) {
        this.oxFlow = oxFlow;
    }

    public Integer getConsLev() {
        return consLev;
    }

    public void setConsLev(Integer consLev) {
        this.consLev = consLev;
    }

    public Integer getAirwayPatency() {
        return airwayPatency;
    }

    public void setAirwayPatency(Integer airwayPatency) {
        this.airwayPatency = airwayPatency;
    }

    public Integer getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(Integer physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    public Integer getFluidInfusion() {
        return fluidInfusion;
    }

    public void setFluidInfusion(Integer fluidInfusion) {
        this.fluidInfusion = fluidInfusion;
    }

    public Integer getCatheter() {
        return catheter;
    }

    public void setCatheter(Integer catheter) {
        this.catheter = catheter;
    }

    public Float getUpd() {
        return upd;
    }

    public void setUpd(Float upd) {
        this.upd = upd;
    }

    public String getUrineCharac() {
        return urineCharac;
    }

    public void setUrineCharac(String urineCharac) {
        this.urineCharac = urineCharac == null ? null : urineCharac.trim();
    }

    public Integer getCryingDegree() {
        return cryingDegree;
    }

    public void setCryingDegree(Integer cryingDegree) {
        this.cryingDegree = cryingDegree;
    }

    public Integer getNauseaVomit() {
        return nauseaVomit;
    }

    public void setNauseaVomit(Integer nauseaVomit) {
        this.nauseaVomit = nauseaVomit;
    }

    public Integer getShivering() {
        return shivering;
    }

    public void setShivering(Integer shivering) {
        this.shivering = shivering;
    }

    public Integer getPainScore() {
        return painScore;
    }

    public void setPainScore(Integer painScore) {
        this.painScore = painScore;
    }

    public String getWoundCondition() {
        return woundCondition;
    }

    public void setWoundCondition(String woundCondition) {
        this.woundCondition = woundCondition == null ? null : woundCondition.trim();
    }

    public String getDrainageCharac() {
        return drainageCharac;
    }

    public void setDrainageCharac(String drainageCharac) {
        this.drainageCharac = drainageCharac == null ? null : drainageCharac.trim();
    }

    public Float getDrainageFlow() {
        return drainageFlow;
    }

    public void setDrainageFlow(Float drainageFlow) {
        this.drainageFlow = drainageFlow;
    }

    public String getObserRec() {
        return obserRec;
    }

    public void setObserRec(String obserRec) {
        this.obserRec = obserRec == null ? null : obserRec.trim();
    }

    public Integer getMedType() {
        return medType;
    }

    public void setMedType(Integer medType) {
        this.medType = medType;
    }

    public String getMedId() {
        return medId;
    }

    public void setMedId(String medId) {
        this.medId = medId == null ? null : medId.trim();
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName == null ? null : medName.trim();
    }

    public Float getMedFlow() {
        return medFlow;
    }

    public void setMedFlow(Float medFlow) {
        this.medFlow = medFlow;
    }

    public String getMedUnit() {
        return medUnit;
    }

    public void setMedUnit(String medUnit) {
        this.medUnit = medUnit == null ? null : medUnit.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Float getHypertension() {
        return hypertension;
    }

    public void setHypertension(Float hypertension) {
        this.hypertension = hypertension;
    }

    public Float getHypopiesia() {
        return hypopiesia;
    }

    public void setHypopiesia(Float hypopiesia) {
        this.hypopiesia = hypopiesia;
    }
}