package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StatisticsWorkingFormBean implements Serializable{

	//private String name;
	private Map map = new HashMap();
	
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	
	
	
	
}
