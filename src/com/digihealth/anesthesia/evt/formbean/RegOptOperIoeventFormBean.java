package com.digihealth.anesthesia.evt.formbean;

import java.util.List;

public class RegOptOperIoeventFormBean {

	private String ioDefId;
	private String name;
	private String unit;
	private String totalAmout;
	private String dosageUnit;
	private List<SearchOptOperIoevent> ioeventList;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDosageUnit() {
		return dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}

	public String getIoDefId() {
		return ioDefId;
	}

	public void setIoDefId(String ioDefId) {
		this.ioDefId = ioDefId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SearchOptOperIoevent> getIoeventList() {
		return ioeventList;
	}

	public void setIoeventList(List<SearchOptOperIoevent> ioeventList) {
		this.ioeventList = ioeventList;
	}

	public String getTotalAmout() {
		return totalAmout;
	}

	public void setTotalAmout(String totalAmout) {
		this.totalAmout = totalAmout;
	}

}