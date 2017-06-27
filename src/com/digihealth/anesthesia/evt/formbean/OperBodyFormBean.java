package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;

/**
 * 手术病人体位变更事件表
 * @author dell
 *
 */
public class OperBodyFormBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String optBodyeventId;
	private String starttime;
	private String optBody;
	private String docId;
	private String state;
	private String optBodyName;
	private String optBodyOld;
	private String optBodyOldName;
	
	
	
	public String getOptBodyOld() {
		return optBodyOld;
	}
	public void setOptBodyOld(String optBodyOld) {
		this.optBodyOld = optBodyOld;
	}
	public String getOptBodyOldName() {
		return optBodyOldName;
	}
	public void setOptBodyOldName(String optBodyOldName) {
		this.optBodyOldName = optBodyOldName;
	}
	public String getOptBodyName() {
		return optBodyName;
	}
	public void setOptBodyName(String optBodyName) {
		this.optBodyName = optBodyName;
	}
	public String getOptBodyeventId() {
		return optBodyeventId;
	}
	public void setOptBodyeventId(String optBodyeventId) {
		this.optBodyeventId = optBodyeventId;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getOptBody() {
		return optBody;
	}
	public void setOptBody(String optBody) {
		this.optBody = optBody;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}