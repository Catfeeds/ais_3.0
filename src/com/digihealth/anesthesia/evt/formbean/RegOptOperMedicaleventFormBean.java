package com.digihealth.anesthesia.evt.formbean;

import java.util.List;

public class RegOptOperMedicaleventFormBean {
	private String code;
	private String name;
	private float dosage;
	private String dosageUnit;
	private List<SearchOptOperMedicalevent> medicalEventList;
	private String durable; // 是否是持续性 1持续,0不持续,2:TCI

	public String getDosageUnit() {
		return dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}

	public float getDosage() {
		return dosage;
	}

	public void setDosage(float dosage) {
		this.dosage = dosage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SearchOptOperMedicalevent> getMedicalEventList() {
		return medicalEventList;
	}

	public void setMedicalEventList(List<SearchOptOperMedicalevent> medicalEventList) {
		this.medicalEventList = medicalEventList;
	}

	public String getDurable() {
		return durable;
	}

	public void setDurable(String durable) {
		this.durable = durable;
	}

}