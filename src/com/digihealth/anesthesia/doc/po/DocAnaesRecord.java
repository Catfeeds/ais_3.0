/*
 * DocAnaesRecord.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉记录单对象")
public class DocAnaesRecord {
    /**
     * 麻醉记录单主键
     */
	@ApiModelProperty(value = "主键id")
    private String anaRecordId;

    /**
     * 手术ID
     */
	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 麻醉开始时间
     */
	@ApiModelProperty(value = "麻醉开始时间")
    private String anaesStartTime;

    /**
     * 麻醉结束时间
     */
	@ApiModelProperty(value = "麻醉结束时间")
    private String anaesEndTime;

    /**
     * ASA分级
     */
	@ApiModelProperty(value = "ASA分级")
    private String asaLevel;

    /**
     * 麻醉分级
     */
	@ApiModelProperty(value = "麻醉分级")
    private String anaesLevel;

    /**
     * 手术体位
     */
	@ApiModelProperty(value = "手术体位")
    private String optBody;

    /**
     * 手术体位
     */
	@ApiModelProperty(value = "手术体位集合")
    private List<String> optBodys;
	
	@ApiModelProperty(value = "手术开始时间")
    private String operStartTime;

	@ApiModelProperty(value = "手术结束时间")
    private String operEndTime;

    /**
     * 入室时间
     */
	@ApiModelProperty(value = "入室时间")
    private String inOperRoomTime;

    /**
     * 出室时间
     */
	@ApiModelProperty(value = "出室时间")
    private String outOperRoomTime;

    /**
     * 出室情况
     */
	@ApiModelProperty(value = "出室情况")
    private String leaveTo;

    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成")
    private String processState;

    /**
     * 特殊情况
     */
	@ApiModelProperty(value = "特殊情况")
    private String specialInfection;

	@ApiModelProperty(value = "materialPart")
    private String materialPart;

	@ApiModelProperty(value = "其他")
    private String other;

	@ApiModelProperty(value = "asaLevelE")
    private Boolean asaLevelE;

    /**
     * 镇痛方式 0:无; 1:PCIA; 2:PCEA; 3:PCSA; 4:PCNA
     */
	@ApiModelProperty(value = "镇痛方式 0:无; 1:PCIA; 2:PCEA; 3:PCSA; 4:PCNA")
    private String analgesicMethod;

    /**
     * 病人自控镇痛 0:无; 1:静脉; 2:椎管内; 3:局部;
     */
	@ApiModelProperty(value = "病人自控镇痛 0:无; 1:静脉; 2:椎管内; 3:局部;")
    private String patAnalgesia;

	@ApiModelProperty(value = "术前禁食:0-否;1-是;")
	private Integer frontOperForbidTake; // 术前禁食:0-否;1-是;

	@ApiModelProperty(value = "术前特殊情况")
	private String frontOperSpecialCase; // 术前特殊情况

	@ApiModelProperty(value = "呼吸频率")
	private Float f; // 呼吸频率
	
	@ApiModelProperty(value = "呼吸比")
	private String ie;// 呼吸比
	
	@ApiModelProperty(value = "潮气量")
	private Float vt;// 潮气量
	
	@ApiModelProperty(value = "术后状态")
	private Integer postOperState;
    
	@ApiModelProperty(value = "手术间")
    private String operRoomName;
	
    public Integer getPostOperState()
    {
        return postOperState;
    }

    public void setPostOperState(Integer postOperState)
    {
        this.postOperState = postOperState;
    }

    public String getOperRoomName()
    {
        return operRoomName;
    }

    public void setOperRoomName(String operRoomName)
    {
        this.operRoomName = operRoomName;
    }

    public String getAnaRecordId() {
        return anaRecordId;
    }

    public void setAnaRecordId(String anaRecordId) {
        this.anaRecordId = anaRecordId == null ? null : anaRecordId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getAnaesStartTime() {
        return anaesStartTime;
    }

    public void setAnaesStartTime(String anaesStartTime) {
        this.anaesStartTime = anaesStartTime == null ? null : anaesStartTime.trim();
    }

    public String getAnaesEndTime() {
        return anaesEndTime;
    }

    public void setAnaesEndTime(String anaesEndTime) {
        this.anaesEndTime = anaesEndTime == null ? null : anaesEndTime.trim();
    }

    public String getAsaLevel() {
        return asaLevel;
    }

    public void setAsaLevel(String asaLevel) {
        this.asaLevel = asaLevel == null ? null : asaLevel.trim();
    }

    public String getAnaesLevel() {
        return anaesLevel;
    }

    public void setAnaesLevel(String anaesLevel) {
        this.anaesLevel = anaesLevel == null ? null : anaesLevel.trim();
    }

    public String getOptBody() {
        return optBody;
    }

    public void setOptBody(String optBody) {
        this.optBody = optBody == null ? null : optBody.trim();
    }

    public List<String> getOptBodys() {
		return optBodys;
	}

	public void setOptBodys(List<String> optBodys) {
		this.optBodys = optBodys;
	}

	public String getOperStartTime() {
        return operStartTime;
    }

    public void setOperStartTime(String operStartTime) {
        this.operStartTime = operStartTime == null ? null : operStartTime.trim();
    }

    public String getOperEndTime() {
        return operEndTime;
    }

    public void setOperEndTime(String operEndTime) {
        this.operEndTime = operEndTime == null ? null : operEndTime.trim();
    }

    public String getInOperRoomTime() {
        return inOperRoomTime;
    }

    public void setInOperRoomTime(String inOperRoomTime) {
        this.inOperRoomTime = inOperRoomTime == null ? null : inOperRoomTime.trim();
    }

    public String getOutOperRoomTime() {
        return outOperRoomTime;
    }

    public void setOutOperRoomTime(String outOperRoomTime) {
        this.outOperRoomTime = outOperRoomTime == null ? null : outOperRoomTime.trim();
    }

    public String getLeaveTo() {
        return leaveTo;
    }

    public void setLeaveTo(String leaveTo) {
        this.leaveTo = leaveTo == null ? null : leaveTo.trim();
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getSpecialInfection() {
        return specialInfection;
    }

    public void setSpecialInfection(String specialInfection) {
        this.specialInfection = specialInfection == null ? null : specialInfection.trim();
    }

    public String getMaterialPart() {
        return materialPart;
    }

    public void setMaterialPart(String materialPart) {
        this.materialPart = materialPart == null ? null : materialPart.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Boolean getAsaLevelE() {
        return asaLevelE;
    }

    public void setAsaLevelE(Boolean asaLevelE) {
        this.asaLevelE = asaLevelE;
    }

    public String getAnalgesicMethod() {
        return analgesicMethod;
    }

    public void setAnalgesicMethod(String analgesicMethod) {
        this.analgesicMethod = analgesicMethod == null ? null : analgesicMethod.trim();
    }

    public String getPatAnalgesia() {
        return patAnalgesia;
    }

    public void setPatAnalgesia(String patAnalgesia) {
        this.patAnalgesia = patAnalgesia == null ? null : patAnalgesia.trim();
    }

	public Integer getFrontOperForbidTake() {
		return frontOperForbidTake;
	}

	public void setFrontOperForbidTake(Integer frontOperForbidTake) {
		this.frontOperForbidTake = frontOperForbidTake;
	}

	public String getFrontOperSpecialCase() {
		return frontOperSpecialCase;
	}

	public void setFrontOperSpecialCase(String frontOperSpecialCase) {
		this.frontOperSpecialCase = frontOperSpecialCase;
	}

	public Float getF() {
		return f;
	}

	public void setF(Float f) {
		this.f = f;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public Float getVt() {
		return vt;
	}

	public void setVt(Float vt) {
		this.vt = vt;
	}
    
}