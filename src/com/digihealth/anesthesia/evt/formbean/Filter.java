package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;


public class Filter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String field;
	private String value;
	public String getField() {
//		if(StringUtils.isNotBlank(field)){
//			field = StringUtils.sqlValidate(StringUtils.zhuanData(field));
//		}
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
