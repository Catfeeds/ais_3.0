/*
 * DocExitOperSafeCheck.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "患者离开手术室前安全核查单对象")
public class DocExitOperSafeCheck {
	@ApiModelProperty(value = "主键id")
    private String exitOperId;

	@ApiModelProperty(value = "患者id")
    private String regOptId;

    /**
     * 患者基本信息确认
     */
	@ApiModelProperty(value = "患者基本信息确认")
    private String patientInfoConfirm;

    /**
     * 实际手术方式确认
     */
	@ApiModelProperty(value = "实际手术方式确认")
    private String realOperConfirm;

    /**
     * 手术用药输血核查
     */
	@ApiModelProperty(value = "手术用药输血核查")
    private String operMedBloodConfirm;

    /**
     * 手术用物清点正确
     */
	@ApiModelProperty(value = "手术用物清点正确")
    private String operThingInventoryConfirm;

    /**
     * 手术标本确认
     */
	@ApiModelProperty(value = "手术标本确认")
    private String operSpecimenConfirm;

    /**
     * 皮肤是否有其他损伤
     */
	@ApiModelProperty(value = "皮肤是否有其他损伤")
    private String skinDamageConfirm;

    /**
     * 中心静脉导管
     */
	@ApiModelProperty(value = "中心静脉导管")
    private String centralVenousCatheter;

    /**
     * 外周静脉管导管
     */
	@ApiModelProperty(value = "外周静脉管导管")
    private String perVenousCatheterTube;

    /**
     * 动脉导管
     */
	@ApiModelProperty(value = "动脉导管")
    private String ductusArteriosus;

    /**
     * 气管导管
     */
	@ApiModelProperty(value = "气管导管")
    private String fluidConduit;

    /**
     * 伤口引流管
     */
	@ApiModelProperty(value = "伤口引流管")
    private String wDrainageTube;

    /**
     * 胃管
     */
	@ApiModelProperty(value = "胃管")
    private String stomach;

    /**
     * 导尿管
     */
	@ApiModelProperty(value = "导尿管")
    private String catheter;

	@ApiModelProperty(value = "其他")
    private String other1;

    /**
     * 去向
     */
	@ApiModelProperty(value = "去向")
    private String whereabouts;

	@ApiModelProperty(value = "其他")
    private String other2;

    /**
     * 麻醉医生
     */
	@ApiModelProperty(value = "麻醉医生id")
    private String anesthetistId;

    /**
     * 手术医生
     */
	@ApiModelProperty(value = "手术医生id")
    private String operatorId;

    /**
     * 巡回护士
     */
	@ApiModelProperty(value = "巡回护士id")
    private String circuNurseId;

    /**
     * END,NO_END
     */
	@ApiModelProperty(value = "是否完成")
    private String processState;

    /**
     * 鼻肠管
     */
	@ApiModelProperty(value = "鼻肠管")
    private String bc;

    /**
     * 胃造瘘管
     */
	@ApiModelProperty(value = "胃造瘘管")
    private String wzwg;

    /**
     * 经胃造瘘小肠管
     */
	@ApiModelProperty(value = "经胃造瘘小肠管")
    private String jwzwxcg;

	@ApiModelProperty(value = "手术医生")
	private String operatorName;
	
	@ApiModelProperty(value = "巡回护士")
	private String circunurseName;
	
	@ApiModelProperty(value = "麻醉医生")
	private String anesthetistName;
	
    public String getExitOperId() {
        return exitOperId;
    }

    public void setExitOperId(String exitOperId) {
        this.exitOperId = exitOperId == null ? null : exitOperId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getPatientInfoConfirm() {
        return patientInfoConfirm;
    }

    public void setPatientInfoConfirm(String patientInfoConfirm) {
        this.patientInfoConfirm = patientInfoConfirm == null ? null : patientInfoConfirm.trim();
    }

    public String getRealOperConfirm() {
        return realOperConfirm;
    }

    public void setRealOperConfirm(String realOperConfirm) {
        this.realOperConfirm = realOperConfirm == null ? null : realOperConfirm.trim();
    }

    public String getOperMedBloodConfirm() {
        return operMedBloodConfirm;
    }

    public void setOperMedBloodConfirm(String operMedBloodConfirm) {
        this.operMedBloodConfirm = operMedBloodConfirm == null ? null : operMedBloodConfirm.trim();
    }

    public String getOperThingInventoryConfirm() {
        return operThingInventoryConfirm;
    }

    public void setOperThingInventoryConfirm(String operThingInventoryConfirm) {
        this.operThingInventoryConfirm = operThingInventoryConfirm == null ? null : operThingInventoryConfirm.trim();
    }

    public String getOperSpecimenConfirm() {
        return operSpecimenConfirm;
    }

    public void setOperSpecimenConfirm(String operSpecimenConfirm) {
        this.operSpecimenConfirm = operSpecimenConfirm == null ? null : operSpecimenConfirm.trim();
    }

    public String getSkinDamageConfirm() {
        return skinDamageConfirm;
    }

    public void setSkinDamageConfirm(String skinDamageConfirm) {
        this.skinDamageConfirm = skinDamageConfirm == null ? null : skinDamageConfirm.trim();
    }

    public String getCentralVenousCatheter() {
        return centralVenousCatheter;
    }

    public void setCentralVenousCatheter(String centralVenousCatheter) {
        this.centralVenousCatheter = centralVenousCatheter == null ? null : centralVenousCatheter.trim();
    }

    public String getPerVenousCatheterTube() {
        return perVenousCatheterTube;
    }

    public void setPerVenousCatheterTube(String perVenousCatheterTube) {
        this.perVenousCatheterTube = perVenousCatheterTube == null ? null : perVenousCatheterTube.trim();
    }

    public String getDuctusArteriosus() {
        return ductusArteriosus;
    }

    public void setDuctusArteriosus(String ductusArteriosus) {
        this.ductusArteriosus = ductusArteriosus == null ? null : ductusArteriosus.trim();
    }

    public String getFluidConduit() {
        return fluidConduit;
    }

    public void setFluidConduit(String fluidConduit) {
        this.fluidConduit = fluidConduit == null ? null : fluidConduit.trim();
    }

    public String getwDrainageTube() {
        return wDrainageTube;
    }

    public void setwDrainageTube(String wDrainageTube) {
        this.wDrainageTube = wDrainageTube == null ? null : wDrainageTube.trim();
    }

    public String getStomach() {
        return stomach;
    }

    public void setStomach(String stomach) {
        this.stomach = stomach == null ? null : stomach.trim();
    }

    public String getCatheter() {
        return catheter;
    }

    public void setCatheter(String catheter) {
        this.catheter = catheter == null ? null : catheter.trim();
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1 == null ? null : other1.trim();
    }

    public String getWhereabouts() {
        return whereabouts;
    }

    public void setWhereabouts(String whereabouts) {
        this.whereabouts = whereabouts == null ? null : whereabouts.trim();
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2 == null ? null : other2.trim();
    }

    public String getAnesthetistId() {
        return anesthetistId;
    }

    public void setAnesthetistId(String anesthetistId) {
        this.anesthetistId = anesthetistId == null ? null : anesthetistId.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getCircuNurseId() {
		return circuNurseId;
	}

	public void setCircuNurseId(String circuNurseId) {
		this.circuNurseId = circuNurseId;
	}

	public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState == null ? null : processState.trim();
    }

    public String getBc() {
        return bc;
    }

    public void setBc(String bc) {
        this.bc = bc == null ? null : bc.trim();
    }

    public String getWzwg() {
        return wzwg;
    }

    public void setWzwg(String wzwg) {
        this.wzwg = wzwg == null ? null : wzwg.trim();
    }

    public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCircunurseName() {
		return circunurseName;
	}

	public void setCircunurseName(String circunurseName) {
		this.circunurseName = circunurseName;
	}

	public String getAnesthetistName() {
		return anesthetistName;
	}

	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}

	public String getJwzwxcg() {
        return jwzwxcg;
    }

    public void setJwzwxcg(String jwzwxcg) {
        this.jwzwxcg = jwzwxcg == null ? null : jwzwxcg.trim();
    }
}