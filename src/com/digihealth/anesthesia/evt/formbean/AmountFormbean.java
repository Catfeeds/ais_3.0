package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;

public class AmountFormbean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private Float amount;
	private String unit;
	private String dosageUnit;
	
	
	
	public String getDosageUnit()
    {
        return dosageUnit;
    }
    public void setDosageUnit(String dosageUnit)
    {
        this.dosageUnit = dosageUnit;
    }
    public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	
	
}
