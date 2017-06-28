package com.digihealth.anesthesia.evt.formbean;

import java.util.Date;

public class SearchOptOperEgress {

	private String egressId;
	private Date startTime;
	private Date endTime;
	private String createUser;
	private String ioDefId;
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

	public String getIoDefId() {
		return ioDefId;
	}

	public void setIoDefId(String ioDefId) {
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