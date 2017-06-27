/*
 * DocOptCareRecord.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术护理记录对象")
public class DocOptCareRecord {
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
     * 药物过敏
     */
    @ApiModelProperty(value = "药物过敏")
     private Integer allergic;

    @ApiModelProperty(value = "手术CODE")
     private String operationCode;

    /**
     * 手术名称
     */
    @ApiModelProperty(value = "手术名称")
     private String operationName;

    /**
     * 神志
     */
    @ApiModelProperty(value = "神志")
     private String senses;

    /**
     * 术前静脉输液
     */
    @ApiModelProperty(value = "术前静脉输液")
     private Integer venousInfusion1;

    /**
     * 深静脉穿刺
     */
    @ApiModelProperty(value = "深静脉穿刺")
     private Integer venipuncture;

    /**
     * 管道
     */
    @ApiModelProperty(value = "管道")
     private String pipeline;

    /**
     * x线片
     */
    @ApiModelProperty(value = "x线片")
     private Integer xray;

    /**
     * CT片
     */
    @ApiModelProperty(value = "CT片")
     private Integer CT;

    /**
     * MRI片
     */
    @ApiModelProperty(value = "MRI片")
     private Integer MRI;

    /**
     * 手术体位
     */
    @ApiModelProperty(value = "手术体位")
     private String optbody;

    /**
     * 手术体位集合
     */
    @ApiModelProperty(value = "手术体位集合")
     private List<String> optbodys;
    
    /**
     * 高频电刀
     */
    @ApiModelProperty(value = "高频电刀")
     private Integer elecKnife;

    /**
     * 标本
     */
    @ApiModelProperty(value = "标本")
     private Integer specimen;

    /**
     * 送检
     */
    @ApiModelProperty(value = "送检")
     private Integer inspection;

    /**
     * 标本名称
     */
    @ApiModelProperty(value = "标本名称")
     private String specimenName;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
     private String remark;

    /**
     * 手术室交班护士
     */
    @ApiModelProperty(value = "手术室交班护士")
     private String shiftChangedNurse;

    /**
     * 病房接班护士
     */
    @ApiModelProperty(value = "病房接班护士")
     private String shiftChangeNurse;

    /**
     * 洗手护士ID
     */
    @ApiModelProperty(value = "洗手护士ID")
     private String instrnurseId;

    /**
     * 交班时间
     */
    @ApiModelProperty(value = "交班时间")
     private Date shiftTime;

    /**
     * 术前皮肤情况
     */
    @ApiModelProperty(value = "术前皮肤情况")
     private String skin1;

    /**
     * 负极板位置
     */
    @ApiModelProperty(value = "负极板位置")
     private String negativePosition;

    /**
     * 止血带
     */
    @ApiModelProperty(value = "止血带")
     private String tourniquet;

    /**
     * 体位支持用物
     */
    @ApiModelProperty(value = "体位支持用物")
     private String supportMaterial;

    /**
     * 体内植入物
     */
    @ApiModelProperty(value = "体内植入物")
     private String implants;

    /**
     * 送至
     */
    @ApiModelProperty(value = "送至")
     private String leaveTo;

    /**
     * 术后静脉输液
     */
    @ApiModelProperty(value = "术后静脉输液")
     private String venousInfusion2;

    /**
     * 引流管
     */
    @ApiModelProperty(value = "引流管")
     private String drainageTube;

    /**
     * 术后皮肤情况
     */
    @ApiModelProperty(value = "术后皮肤情况")
     private String skin2;

    @ApiModelProperty(value = "手术名称集合")
     private List<Map<String, Object>> operationNameList;

    @ApiModelProperty(value = "接班巡回护士集合")
     private List<String> shiftChangeNurseList;

    @ApiModelProperty(value = "交班巡回护士集合")
     private List<String> shiftChangedNurseList;

    @ApiModelProperty(value = "洗手护士集合")
     private List<String> instrnurseList;
    
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

    public Integer getAllergic() {
        return allergic;
    }

    public void setAllergic(Integer allergic) {
        this.allergic = allergic;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode == null ? null : operationCode.trim();
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
    }

    public String getSenses() {
        return senses;
    }

    public void setSenses(String senses) {
        this.senses = senses == null ? null : senses.trim();
    }

    public Integer getVenousInfusion1() {
        return venousInfusion1;
    }

    public void setVenousInfusion1(Integer venousInfusion1) {
        this.venousInfusion1 = venousInfusion1;
    }

    public Integer getVenipuncture() {
        return venipuncture;
    }

    public void setVenipuncture(Integer venipuncture) {
        this.venipuncture = venipuncture;
    }

    public String getPipeline() {
        return pipeline;
    }

    public void setPipeline(String pipeline) {
        this.pipeline = pipeline == null ? null : pipeline.trim();
    }

    public Integer getXray() {
        return xray;
    }

    public void setXray(Integer xray) {
        this.xray = xray;
    }

    public Integer getCT() {
        return CT;
    }

    public void setCT(Integer CT) {
        this.CT = CT;
    }

    public Integer getMRI() {
        return MRI;
    }

    public void setMRI(Integer MRI) {
        this.MRI = MRI;
    }

    public String getOptbody() {
        return optbody;
    }

    public void setOptbody(String optbody) {
        this.optbody = optbody == null ? null : optbody.trim();
    }

    public List<String> getOptbodys() {
		return optbodys;
	}

	public void setOptbodys(List<String> optbodys) {
		this.optbodys = optbodys;
	}

	public Integer getElecKnife() {
        return elecKnife;
    }

    public void setElecKnife(Integer elecKnife) {
        this.elecKnife = elecKnife;
    }

    public Integer getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Integer specimen) {
        this.specimen = specimen;
    }

    public Integer getInspection() {
        return inspection;
    }

    public void setInspection(Integer inspection) {
        this.inspection = inspection;
    }

    public String getSpecimenName() {
        return specimenName;
    }

    public void setSpecimenName(String specimenName) {
        this.specimenName = specimenName == null ? null : specimenName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getShiftChangedNurse() {
        return shiftChangedNurse;
    }

    public void setShiftChangedNurse(String shiftChangedNurse) {
        this.shiftChangedNurse = shiftChangedNurse == null ? null : shiftChangedNurse.trim();
    }

    public String getShiftChangeNurse() {
        return shiftChangeNurse;
    }

    public void setShiftChangeNurse(String shiftChangeNurse) {
        this.shiftChangeNurse = shiftChangeNurse == null ? null : shiftChangeNurse.trim();
    }

    public String getInstrnurseId() {
        return instrnurseId;
    }

    public void setInstrnurseId(String instrnurseId) {
        this.instrnurseId = instrnurseId == null ? null : instrnurseId.trim();
    }

    public Date getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(Date shiftTime) {
        this.shiftTime = shiftTime;
    }

    public String getSkin1() {
        return skin1;
    }

    public void setSkin1(String skin1) {
        this.skin1 = skin1 == null ? null : skin1.trim();
    }

    public String getNegativePosition() {
        return negativePosition;
    }

    public void setNegativePosition(String negativePosition) {
        this.negativePosition = negativePosition == null ? null : negativePosition.trim();
    }

    public String getTourniquet() {
        return tourniquet;
    }

    public void setTourniquet(String tourniquet) {
        this.tourniquet = tourniquet == null ? null : tourniquet.trim();
    }

    public String getSupportMaterial() {
        return supportMaterial;
    }

    public void setSupportMaterial(String supportMaterial) {
        this.supportMaterial = supportMaterial == null ? null : supportMaterial.trim();
    }

    public String getImplants() {
        return implants;
    }

    public void setImplants(String implants) {
        this.implants = implants == null ? null : implants.trim();
    }

    public String getLeaveTo() {
        return leaveTo;
    }

    public void setLeaveTo(String leaveTo) {
        this.leaveTo = leaveTo == null ? null : leaveTo.trim();
    }

    public String getVenousInfusion2() {
        return venousInfusion2;
    }

    public void setVenousInfusion2(String venousInfusion2) {
        this.venousInfusion2 = venousInfusion2 == null ? null : venousInfusion2.trim();
    }

    public String getDrainageTube() {
        return drainageTube;
    }

    public void setDrainageTube(String drainageTube) {
        this.drainageTube = drainageTube == null ? null : drainageTube.trim();
    }

    public String getSkin2() {
        return skin2;
    }

    public void setSkin2(String skin2) {
        this.skin2 = skin2 == null ? null : skin2.trim();
    }

	public List<Map<String, Object>> getOperationNameList() {
		return operationNameList;
	}

	public void setOperationNameList(List<Map<String, Object>> operationNameList) {
		this.operationNameList = operationNameList;
	}

	public List<String> getShiftChangeNurseList() {
		return shiftChangeNurseList;
	}

	public void setShiftChangeNurseList(List<String> shiftChangeNurseList) {
		this.shiftChangeNurseList = shiftChangeNurseList;
	}

	public List<String> getShiftChangedNurseList() {
		return shiftChangedNurseList;
	}

	public void setShiftChangedNurseList(List<String> shiftChangedNurseList) {
		this.shiftChangedNurseList = shiftChangedNurseList;
	}

	public List<String> getInstrnurseList() {
		return instrnurseList;
	}

	public void setInstrnurseList(List<String> instrnurseList) {
		this.instrnurseList = instrnurseList;
	}
    
}