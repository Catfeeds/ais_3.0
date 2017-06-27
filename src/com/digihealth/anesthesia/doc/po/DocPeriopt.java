package com.digihealth.anesthesia.doc.po;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 围手术期表
 * 
 * @author liukui
 * 
 */
@ApiModel(value = "围手术期表对象")
public class DocPeriopt implements Serializable {

	@ApiModelProperty(value = "主键ID")
	private String perioperativeVisitId;

	@NotEmpty(message = "手术ID不能为空")
	@ApiModelProperty(value = "患者ID")
	private String regOptId;

	@ApiModelProperty(value = "宽度")
	private float weight;

	@ApiModelProperty(value = "高度")
	private float height;
	
	@Length(max = 40, message = "职业长度不能大于40")
	@ApiModelProperty(value = "职业")
	private String occupation;
	
	@Length(max = 20, message = "血型长度不能大于20")
	@ApiModelProperty(value = "血型")
	private String bloodType;
	
	@Length(max = 20, message = "文化程度长度不能大于20")
	@ApiModelProperty(value = "文化程度")
	private String education;

	@ApiModelProperty(value = "temp")
	private float temp;
	
	@Min(value = 20, message = "脉搏最小值不能小于20")
	@Max(value = 180, message = "脉搏最大值不能大于180")
	@ApiModelProperty(value = "脉搏")
	private Integer pulse;
	
	@Length(max = 7, message = "血压长度不能大于7")
	@ApiModelProperty(value = "血压")
	private String bloodPressure;
	
	@Length(max = 7, message = "异常项长度不能大于40")
	@ApiModelProperty(value = "异常项")
	private String abnormal;
	
	@Length(max = 7, message = "心电图长度不能大于20")
	@ApiModelProperty(value = "心电图")
	private String ecg;
	
	@Length(max = 40, message = "肝肾功能长度不能大于40")
	@ApiModelProperty(value = "肝肾功能")
	private String liverKidney;
	
	@Length(max = 40, message = "血常规长度不能大于40")
	@ApiModelProperty(value = "血常规")
	private String bloodExam;

	@ApiModelProperty(value = "clottingTime")
	private String clottingTime;
	
	@Length(max = 40, message = "异常项输入框中值长度不能大于40")
	@ApiModelProperty(value = "异常项输入框中值")
	private String beforeTransfusion;
	
	@Length(max = 40, message = "三项知情同意不完善输入框中值长度不能大于40")
	@ApiModelProperty(value = "三项知情同意不完善输入框中值")
	private String threeInformed;
	
	@Length(max = 40, message = "备血不完善输入框中值长度不能大于40")
	@ApiModelProperty(value = "备血不完善输入框中值")
	private String preparationBlood;
	
	@Length(max = 40, message = "精神异常输入框中值长度不能大于40")
	@ApiModelProperty(value = "精神异常输入框中值")
	private String consciousness;

	@ApiModelProperty(value = "psychological")
	private String psychological;

	@ApiModelProperty(value = "weightAssessment")
	private String weightAssessment;

	@ApiModelProperty(value = "vascularFilling")
	private String vascularFilling;
	
	@Length(max = 40, message = "体内植入物选择有的输入框中值长度不能大于40")
	@ApiModelProperty(value = "体内植入物选择有的输入框中值")
	private String implantInvivo;
	
	@Length(max = 40, message = "疾病选择其他的输入框中值长度不能大于40")
	@ApiModelProperty(value = "疾病选择其他的输入框中值")
	private String disease;
	
	@Length(max = 40, message = "手术史选择有的输入框中值长度不能大于40")
	@ApiModelProperty(value = "手术史选择有的输入框中值")
	private String surgery;
	
	@Length(max = 40, message = "肢体感觉运动选择差的输入框中值长度不能大于40")
	@ApiModelProperty(value = "肢体感觉运动选择差的输入框中值")
	private String limbsFeel;

	@ApiModelProperty(value = "healthCard")
	private String healthCard;

	@ApiModelProperty(value = "orthostatic")
	private String orthostatic;
	
	@Length(max = 40, message = "特殊器械长度不能大于40")
	@ApiModelProperty(value = "特殊器械")
	private String specialEquipment;

	@ApiModelProperty(value = "outcompanyDevices")
	private String outcompanyDevices;
	
	@Length(max = 20, message = "特殊要求长度不能大于20")
	@ApiModelProperty(value = "特殊要求")
	private String specialRequest;
	
	@Length(max = 40, message = "手术间手术台次需修改长度不能大于40")
	@ApiModelProperty(value = "手术间手术台次")
	private String operationroomSchedule;

	@ApiModelProperty(value = "instrumentReady")
	private String instrumentReady;

	@ApiModelProperty(value = "surgicalProcedures")
	private String surgicalProcedures;

	@ApiModelProperty(value = "operationroomOutcompanyDevices")
	private String operationroomOutcompanyDevices;

	@ApiModelProperty(value = "equipmentUse")
	private String equipmentUse;

	@ApiModelProperty(value = "tourniquetUse")
	private String tourniquetUse;
	
	@ApiModelProperty(value = "electricknifeUse")
	private String electricknifeUse;

	@ApiModelProperty(value = "nursingDiagnosisId")
	private String nursingDiagnosisId;
	
	@Length(max = 10, message = "出血量长度不能大于10")
	@ApiModelProperty(value = "出血量")
	private String bleeding;
	
	@Length(max = 10, message = "尿量长度不能大于10")
	@ApiModelProperty(value = "尿量")
	private String urine;
	
	@Length(max = 10, message = "输液量长度不能大于10")
	@ApiModelProperty(value = "输液量")
	private String fluidVolume;
	
	@Length(max = 20, message = "皮肤长度不能大于20")
	@ApiModelProperty(value = "皮肤")
	private String skin;
	
	@Length(max = 7, message = "血压长度不能大于7")
	@ApiModelProperty(value = "血压")
	private String bloodPressureAfter;
	
	@Max(value = 100, message = "手术切口清洁度最大值不能大于100")
	@ApiModelProperty(value = "手术切口清洁度")
	private Integer incisionCleanliness;
	
	@Max(value = 100, message = "ASA分级最大值不能大于100")
	@ApiModelProperty(value = "ASA分级")
	private Integer asa;
	
	@Max(value = 100, message = "手术持续时间最大值不能大于100")
	@ApiModelProperty(value = "手术持续时间")
	private Integer durationOfSurgery;

	@ApiModelProperty(value = "nnis")
	private String nnis;

	@ApiModelProperty(value = "tempDay3")
	private float tempDay3;
	
	@Length(max = 7, message = "术后三天血压长度不能大于7")
	@ApiModelProperty(value = "术后三天血压")
	private String bloodPressureDay3;
	
	@Length(max = 20, message = "术后三天伤口敷料长度不能大于20")
	@ApiModelProperty(value = "术后三天伤口敷料")
	private String woundDressingsDay3;
	
	@Length(max = 20, message = "术后三天皮肤长度不能大于20")
	@ApiModelProperty(value = "术后三天皮肤")
	private String skinDay3;
	
	@Length(max = 40, message = "术后三天肢体感觉长度不能大于40")
	@ApiModelProperty(value = "术后三天肢体感觉")
	private String limbsFeelDay3;

	@ApiModelProperty(value = "完成状态")
	private String processState;

	@ApiModelProperty(value = "完成时间")
	private String finishTime;

	@ApiModelProperty(value = "visitor")
	private String visitor;

	@ApiModelProperty(value = "flag")
	private String flag;

	@ApiModelProperty(value = "visitorName")
	private String visitorName;

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getVisitor() {
		return visitor;
	}

	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}

	public String getProcessState() {
		return processState;
	}

	public void setProcessState(String processState) {
		this.processState = processState;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getPerioperativeVisitId() {
		return perioperativeVisitId;
	}

	public void setPerioperativeVisitId(String perioperativeVisitId) {
		this.perioperativeVisitId = perioperativeVisitId;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public Integer getPulse() {
		return pulse;
	}

	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getAbnormal() {
		return abnormal;
	}

	public void setAbnormal(String abnormal) {
		this.abnormal = abnormal;
	}

	public String getEcg() {
		return ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	public String getLiverKidney() {
		return liverKidney;
	}

	public void setLiverKidney(String liverKidney) {
		this.liverKidney = liverKidney;
	}

	public String getBloodExam() {
		return bloodExam;
	}

	public void setBloodExam(String bloodExam) {
		this.bloodExam = bloodExam;
	}

	public String getClottingTime() {
		return clottingTime;
	}

	public void setClottingTime(String clottingTime) {
		this.clottingTime = clottingTime;
	}

	public String getBeforeTransfusion() {
		return beforeTransfusion;
	}

	public void setBeforeTransfusion(String beforeTransfusion) {
		this.beforeTransfusion = beforeTransfusion;
	}

	public String getThreeInformed() {
		return threeInformed;
	}

	public void setThreeInformed(String threeInformed) {
		this.threeInformed = threeInformed;
	}

	public String getPreparationBlood() {
		return preparationBlood;
	}

	public void setPreparationBlood(String preparationBlood) {
		this.preparationBlood = preparationBlood;
	}

	public String getConsciousness() {
		return consciousness;
	}

	public void setConsciousness(String consciousness) {
		this.consciousness = consciousness;
	}

	public String getPsychological() {
		return psychological;
	}

	public void setPsychological(String psychological) {
		this.psychological = psychological;
	}

	public String getWeightAssessment() {
		return weightAssessment;
	}

	public void setWeightAssessment(String weightAssessment) {
		this.weightAssessment = weightAssessment;
	}

	public String getVascularFilling() {
		return vascularFilling;
	}

	public void setVascularFilling(String vascularFilling) {
		this.vascularFilling = vascularFilling;
	}

	public String getImplantInvivo() {
		return implantInvivo;
	}

	public void setImplantInvivo(String implantInvivo) {
		this.implantInvivo = implantInvivo;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getSurgery() {
		return surgery;
	}

	public void setSurgery(String surgery) {
		this.surgery = surgery;
	}

	public String getLimbsFeel() {
		return limbsFeel;
	}

	public void setLimbsFeel(String limbsFeel) {
		this.limbsFeel = limbsFeel;
	}

	public String getHealthCard() {
		return healthCard;
	}

	public void setHealthCard(String healthCard) {
		this.healthCard = healthCard;
	}

	public String getOrthostatic() {
		return orthostatic;
	}

	public void setOrthostatic(String orthostatic) {
		this.orthostatic = orthostatic;
	}

	public String getSpecialEquipment() {
		return specialEquipment;
	}

	public void setSpecialEquipment(String specialEquipment) {
		this.specialEquipment = specialEquipment;
	}

	public String getOutcompanyDevices() {
		return outcompanyDevices;
	}

	public void setOutcompanyDevices(String outcompanyDevices) {
		this.outcompanyDevices = outcompanyDevices;
	}

	public String getSpecialRequest() {
		return specialRequest;
	}

	public void setSpecialRequest(String specialRequest) {
		this.specialRequest = specialRequest;
	}

	public String getOperationroomSchedule() {
		return operationroomSchedule;
	}

	public void setOperationroomSchedule(String operationroomSchedule) {
		this.operationroomSchedule = operationroomSchedule;
	}

	public String getInstrumentReady() {
		return instrumentReady;
	}

	public void setInstrumentReady(String instrumentReady) {
		this.instrumentReady = instrumentReady;
	}

	public String getSurgicalProcedures() {
		return surgicalProcedures;
	}

	public void setSurgicalProcedures(String surgicalProcedures) {
		this.surgicalProcedures = surgicalProcedures;
	}

	public String getOperationroomOutcompanyDevices() {
		return operationroomOutcompanyDevices;
	}

	public void setOperationroomOutcompanyDevices(
			String operationroomOutcompanyDevices) {
		this.operationroomOutcompanyDevices = operationroomOutcompanyDevices;
	}

	public String getEquipmentUse() {
		return equipmentUse;
	}

	public void setEquipmentUse(String equipmentUse) {
		this.equipmentUse = equipmentUse;
	}

	public String getTourniquetUse() {
		return tourniquetUse;
	}

	public void setTourniquetUse(String tourniquetUse) {
		this.tourniquetUse = tourniquetUse;
	}

	public String getElectricknifeUse() {
		return electricknifeUse;
	}

	public void setElectricknifeUse(String electricknifeUse) {
		this.electricknifeUse = electricknifeUse;
	}

	public String getNursingDiagnosisId() {
		return nursingDiagnosisId;
	}

	public void setNursingDiagnosisId(String nursingDiagnosisId) {
		this.nursingDiagnosisId = nursingDiagnosisId;
	}

	public String getBleeding() {
		return bleeding;
	}

	public void setBleeding(String bleeding) {
		this.bleeding = bleeding;
	}

	public String getUrine() {
		return urine;
	}

	public void setUrine(String urine) {
		this.urine = urine;
	}

	public String getFluidVolume() {
		return fluidVolume;
	}

	public void setFluidVolume(String fluidVolume) {
		this.fluidVolume = fluidVolume;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getBloodPressureAfter() {
		return bloodPressureAfter;
	}

	public void setBloodPressureAfter(String bloodPressureAfter) {
		this.bloodPressureAfter = bloodPressureAfter;
	}

	public Integer getIncisionCleanliness() {
		return incisionCleanliness;
	}

	public void setIncisionCleanliness(Integer incisionCleanliness) {
		this.incisionCleanliness = incisionCleanliness;
	}

	public Integer getAsa() {
		return asa;
	}

	public void Integer(Integer asa) {
		this.asa = asa;
	}

	public Integer getDurationOfSurgery() {
		return durationOfSurgery;
	}

	public void setDurationOfSurgery(Integer durationOfSurgery) {
		this.durationOfSurgery = durationOfSurgery;
	}

	public String getNnis() {
		return nnis;
	}

	public void setNnis(String nnis) {
		this.nnis = nnis;
	}

	public float getTempDay3() {
		return tempDay3;
	}

	public void setTempDay3(float tempDay3) {
		this.tempDay3 = tempDay3;
	}

	public String getBloodPressureDay3() {
		return bloodPressureDay3;
	}

	public void setBloodPressureDay3(String bloodPressureDay3) {
		this.bloodPressureDay3 = bloodPressureDay3;
	}

	public String getWoundDressingsDay3() {
		return woundDressingsDay3;
	}

	public void setWoundDressingsDay3(String woundDressingsDay3) {
		this.woundDressingsDay3 = woundDressingsDay3;
	}

	public String getSkinDay3() {
		return skinDay3;
	}

	public void setSkinDay3(String skinDay3) {
		this.skinDay3 = skinDay3;
	}

	public String getLimbsFeelDay3() {
		return limbsFeelDay3;
	}

	public void setLimbsFeelDay3(String limbsFeelDay3) {
		this.limbsFeelDay3 = limbsFeelDay3;
	}
}