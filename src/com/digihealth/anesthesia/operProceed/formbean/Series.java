package com.digihealth.anesthesia.operProceed.formbean;

import java.util.List;

public class Series {
	
	private String name;
	private String type;
	private List<Float> data;
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
	public List<Float> getData() {
		return data;
	}
	public void setData(List<Float> data) {
		this.data = data;
	}
	
	
}
