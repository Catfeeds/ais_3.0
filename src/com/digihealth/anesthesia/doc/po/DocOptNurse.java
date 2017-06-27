/*
 * DocOptNurse.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术清点单对象")
public class DocOptNurse {
	@ApiModelProperty(value = "主键id")
    private String optNurseId;

	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 标本名称
     */
	@ApiModelProperty(value = "标本名称")
    private String specimenName;

    /**
     * 输液
     */
	@ApiModelProperty(value = "输液")
    private Integer infusion;

    /**
     * 出血量
     */
	@ApiModelProperty(value = "出血量")
    private Integer bleeding;

    /**
     * 尿量
     */
	@ApiModelProperty(value = "尿量")
    private Integer urine;

    /**
     * 血型
     */
	@ApiModelProperty(value = "血型")
    private String bloodType;

    /**
     * 血液成分
     */
	@ApiModelProperty(value = "血液成分")
    private String bloodComponents;

    /**
     * 血量
     */
	@ApiModelProperty(value = "血量")
    private Integer blood;

	@ApiModelProperty(value = "手术医生id")
    private String operatorId;

	@ApiModelProperty(value = "手术医生名字")
    private String operatorName;

	@ApiModelProperty(value = "")
    private String instrnuseId;

	@ApiModelProperty(value = "")
    private String circunurseId;

    /**
     * 医生确认
     */
	@ApiModelProperty(value = "医生确认")
    private String doctorConfirm;

    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成")
    private String processState;

	@ApiModelProperty(value = "仅手术室时间")
    private Date inOperRoomTime;

	@ApiModelProperty(value = "出手术室时间")
    private Date outOperRoomTime;

    /**
     * 无菌外包指示卡
     */
	@ApiModelProperty(value = "无菌外包指示卡")
    private Integer asepticPackage;

    /**
     * 包内化学指示卡
     */
	@ApiModelProperty(value = "包内化学指示卡")
    private Integer bagChemistry;

    /**
     * 植入物
     */
	@ApiModelProperty(value = "植入物")
    private Integer implant;

    /**
     * 生物监测结果
     */
	@ApiModelProperty(value = "生物监测结果")
    private Integer biologicalMonitor;

    /**
     * 特殊情况说明
     */
	@ApiModelProperty(value = "特殊情况说明")
    private String excepCase;

    /**
     * 术前洗手护士ID
     */
	@ApiModelProperty(value = "术前洗手护士id")
    private String preInstrnurseId;

    /**
     * 术后洗手护士ID
     */
	@ApiModelProperty(value = "术后洗手护士id")
    private String postInstrnurseId;

    /**
     * 术中洗手护士ID
     */
	@ApiModelProperty(value = "术中洗手护士id")
    private String midInstrnurseId;

    /**
     * 术前巡回护士ID
     */
	@ApiModelProperty(value = "术前巡回护士id")
    private String preCircunurseId;

    /**
     * 术后巡回护士ID
     */
	@ApiModelProperty(value = "术后巡回护士id")
    private String postCircunurseId;

    /**
     * 术中巡回护士ID
     */
	@ApiModelProperty(value = "术中巡回护士id")
    private String midCircunurseId;

	@ApiModelProperty(value = "")
	private int shuHouState;

	@ApiModelProperty(value = "术前巡回护士集合")
    private List<String> preCircunurseList;

	@ApiModelProperty(value = "术后巡回护士集合")
    private List<String> postCircunurseList;

	@ApiModelProperty(value = "术中巡回护士集合")
    private List<String> midCircunurseList;
    
    public String getOptNurseId() {
        return optNurseId;
    }

    public void setOptNurseId(String optNurseId) {
        this.optNurseId = optNurseId == null ? null : optNurseId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getSpecimenName() {
        return specimenName;
    }

    public void setSpecimenName(String specimenName) {
        this.specimenName = specimenName == null ? null : specimenName.trim();
    }

    public Integer getInfusion() {
        return infusion;
    }

    public void setInfusion(Integer infusion) {
        this.infusion = infusion;
    }

    public Integer getBleeding() {
        return bleeding;
    }

    public void setBleeding(Integer bleeding) {
        this.bleeding = bleeding;
    }

    public Integer getUrine() {
        return urine;
    }

    public void setUrine(Integer urine) {
        this.urine = urine;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public String getBloodComponents() {
        return bloodComponents;
    }

    public void setBloodComponents(String bloodComponents) {
        this.bloodComponents = bloodComponents == null ? null : bloodComponents.trim();
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getInstrnuseId() {
        return instrnuseId;
    }

    public void setInstrnuseId(String instrnuseId) {
        this.instrnuseId = instrnuseId == null ? null : instrnuseId.trim();
    }

    public String getCircunurseId() {
        return circunurseId;
    }

    public void setCircunurseId(String circunurseId) {
        this.circunurseId = circunurseId == null ? null : circunurseId.trim();
    }

    public String getDoctorConfirm() {
        return doctorConfirm;
    }

    public void setDoctorConfirm(String doctorConfirm) {
        this.doctorConfirm = doctorConfirm == null ? null : doctorConfirm.trim();
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public Date getInOperRoomTime() {
        return inOperRoomTime;
    }

    public void setInOperRoomTime(Date inOperRoomTime) {
        this.inOperRoomTime = inOperRoomTime;
    }

    public Date getOutOperRoomTime() {
        return outOperRoomTime;
    }

    public void setOutOperRoomTime(Date outOperRoomTime) {
        this.outOperRoomTime = outOperRoomTime;
    }

    public Integer getAsepticPackage() {
        return asepticPackage;
    }

    public void setAsepticPackage(Integer asepticPackage) {
        this.asepticPackage = asepticPackage;
    }

    public Integer getBagChemistry() {
        return bagChemistry;
    }

    public void setBagChemistry(Integer bagChemistry) {
        this.bagChemistry = bagChemistry;
    }

    public Integer getImplant() {
        return implant;
    }

    public void setImplant(Integer implant) {
        this.implant = implant;
    }

    public Integer getBiologicalMonitor() {
        return biologicalMonitor;
    }

    public void setBiologicalMonitor(Integer biologicalMonitor) {
        this.biologicalMonitor = biologicalMonitor;
    }

    public String getExcepCase() {
        return excepCase;
    }

    public void setExcepCase(String excepCase) {
        this.excepCase = excepCase == null ? null : excepCase.trim();
    }

    public String getPreInstrnurseId() {
        return preInstrnurseId;
    }

    public void setPreInstrnurseId(String preInstrnurseId) {
        this.preInstrnurseId = preInstrnurseId == null ? null : preInstrnurseId.trim();
    }

    public String getPostInstrnurseId() {
        return postInstrnurseId;
    }

    public void setPostInstrnurseId(String postInstrnurseId) {
        this.postInstrnurseId = postInstrnurseId == null ? null : postInstrnurseId.trim();
    }

    public String getMidInstrnurseId() {
        return midInstrnurseId;
    }

    public void setMidInstrnurseId(String midInstrnurseId) {
        this.midInstrnurseId = midInstrnurseId == null ? null : midInstrnurseId.trim();
    }

    public String getPreCircunurseId() {
        return preCircunurseId;
    }

    public void setPreCircunurseId(String preCircunurseId) {
        this.preCircunurseId = preCircunurseId == null ? null : preCircunurseId.trim();
    }

    public String getPostCircunurseId() {
        return postCircunurseId;
    }

    public void setPostCircunurseId(String postCircunurseId) {
        this.postCircunurseId = postCircunurseId == null ? null : postCircunurseId.trim();
    }

    public String getMidCircunurseId() {
        return midCircunurseId;
    }

    public void setMidCircunurseId(String midCircunurseId) {
        this.midCircunurseId = midCircunurseId == null ? null : midCircunurseId.trim();
    }

	public int getShuHouState() {
		return shuHouState;
	}

	public void setShuHouState(int shuHouState) {
		this.shuHouState = shuHouState;
	}

	public List<String> getPreCircunurseList() {
		return preCircunurseList;
	}

	public void setPreCircunurseList(List<String> preCircunurseList) {
		this.preCircunurseList = preCircunurseList;
	}

	public List<String> getPostCircunurseList() {
		return postCircunurseList;
	}

	public void setPostCircunurseList(List<String> postCircunurseList) {
		this.postCircunurseList = postCircunurseList;
	}

	public List<String> getMidCircunurseList() {
		return midCircunurseList;
	}

	public void setMidCircunurseList(List<String> midCircunurseList) {
		this.midCircunurseList = midCircunurseList;
	}
    
}