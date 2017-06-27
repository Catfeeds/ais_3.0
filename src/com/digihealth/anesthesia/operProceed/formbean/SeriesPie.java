package com.digihealth.anesthesia.operProceed.formbean;

import java.util.List;

public class SeriesPie {
	
	private String name;
	private String type;
	private List<SeriesDataObject> data;
	private String stack;
	
	
	public String getStack() {
		return stack;
	}
	public void setStack(String stack) {
		this.stack = stack;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<SeriesDataObject> getData() {
		return data;
	}
	public void setData(List<SeriesDataObject> data) {
		this.data = data;
	}
	
	
}
