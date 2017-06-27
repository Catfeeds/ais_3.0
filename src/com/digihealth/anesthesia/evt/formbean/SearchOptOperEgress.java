package com.digihealth.anesthesia.evt.formbean;

public class SearchOptOperEgress {

	private String egressId;
	private String startTime;
	private String endTime;
	private String createUser;
	private Integer ioDefId;
	private String docId;
	private String value;
	private String state;
	private String name;
	private String createUserName;
	private String unit;
	private String egressName;
	private String dosageUnit;

	public String getDosageUnit() {
		return dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getEgressId() {
		return egressId;
	}

	public void setEgressId(String egressId) {
		this.egressId = egressId;
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

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public Integer getIoDefId() {
		return ioDefId;
	}

	public void setIoDefId(Integer ioDefId) {
		this.ioDefId = ioDefId;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEgressName() {
		return egressName;
	}

	public void setEgressName(String egressName) {
		this.egressName = egressName;
	}

}