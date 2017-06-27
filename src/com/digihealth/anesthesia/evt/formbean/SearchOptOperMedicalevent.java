package com.digihealth.anesthesia.evt.formbean;

import java.util.ArrayList;
import java.util.List;

import com.digihealth.anesthesia.evt.po.EvtMedicalEventDetail;

public class SearchOptOperMedicalevent {
	private String medEventId;
	private float dosage;
	private float thickness;
	private String thicknessUnit;
	private float flow;
	private String flowUnit;
	private Integer diluentQuant;
	private String startTime;
	private String endTime;
	private Integer ended;
	private String dosageUnit;
	private String medicineId;
	private String occurHour;
	private String color;
	private String docId;
	private Integer isContinued;
	private String spec;
	private String createUser;
	private String createUserName;
	private String name;
	private String medTakeWayId;
	private String medTakeWayName;
	private String firm;
	private String reason;
	private String durable;
	private String priceId;
	private String pacuObsId;

	private Integer pcorec;// 血浆浓度pc:0,效应室浓度ec:1
	private Float tciValue; // 血浆浓度值或效应室浓度值
	private String tciUnit; // tci单位:ug/ml,ng/ml

	private Integer docType;// 1-麻醉记录单 2-pacu复苏单

	private List<EvtMedicalEventDetail> medDetailList; // 用药详情list
	
	public SearchOptOperMedicalevent() {
		medDetailList = new ArrayList<EvtMedicalEventDetail>();
	}

	public String getPacuObsId() {
		return pacuObsId;
	}

	public void setPacuObsId(String pacuObsId) {
		this.pacuObsId = pacuObsId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getDurable() {
		return durable;
	}

	public void setDurable(String durable) {
		this.durable = durable;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMedTakeWayName() {
		return medTakeWayName;
	}

	public void setMedTakeWayName(String medTakeWayName) {
		this.medTakeWayName = medTakeWayName;
	}

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMedEventId() {
		return medEventId;
	}

	public void setMedEventId(String medEventId) {
		this.medEventId = medEventId;
	}

	public String getThicknessUnit() {
		return thicknessUnit;
	}

	public void setThicknessUnit(String thicknessUnit) {
		this.thicknessUnit = thicknessUnit;
	}

	public float getDosage() {
		return dosage;
	}

	public void setDosage(float dosage) {
		this.dosage = dosage;
	}

	public float getThickness() {
		return thickness;
	}

	public void setThickness(float thickness) {
		this.thickness = thickness;
	}

	public float getFlow() {
		return flow;
	}

	public void setFlow(float flow) {
		this.flow = flow;
	}

	public String getFlowUnit() {
		return flowUnit;
	}

	public void setFlowUnit(String flowUnit) {
		this.flowUnit = flowUnit;
	}

	public Integer getDiluentQuant() {
		return diluentQuant;
	}

	public void setDiluentQuant(Integer diluentQuant) {
		this.diluentQuant = diluentQuant;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getEnded() {
		return ended;
	}

	public void setEnded(Integer ended) {
		this.ended = ended;
	}

	public String getDosageUnit() {
		return dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}

	public String getOccurHour() {
		return occurHour;
	}

	public void setOccurHour(String occurHour) {
		this.occurHour = occurHour;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public List<EvtMedicalEventDetail> getMedDetailList() {
		return medDetailList;
	}

	public void setMedDetailList(List<EvtMedicalEventDetail> medDetailList) {
		this.medDetailList = medDetailList;
	}

	public Integer getPcorec() {
		return pcorec;
	}

	public void setPcorec(Integer pcorec) {
		this.pcorec = pcorec;
	}

	public Float getTciValue() {
		return tciValue;
	}

	public void setTciValue(Float tciValue) {
		this.tciValue = tciValue;
	}

	public String getTciUnit() {
		return tciUnit;
	}

	public void setTciUnit(String tciUnit) {
		this.tciUnit = tciUnit;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public Integer getIsContinued() {
		return isContinued;
	}

	public void setIsContinued(Integer isContinued) {
		this.isContinued = isContinued;
	}

	public String getMedTakeWayId() {
		return medTakeWayId;
	}

	public void setMedTakeWayId(String medTakeWayId) {
		this.medTakeWayId = medTakeWayId;
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
		this.docType = docType;
	}

}