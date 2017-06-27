package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;
import java.util.List;

import com.digihealth.anesthesia.basedata.formbean.DocumentStateFormbean;

public class SearchMyOperationFormBean implements Serializable{

	private String regOptId;
	private String name;
	private String hid;
	private String operaDate;
	private String state;
	private String deptName;
	private String regionName;
	private String designedOptName;
	private String operRoomName;
	private String operatorName;
	private String anesthetistName;
	private String designedAnaesMethodName;
	private List<DocumentStateFormbean> documentStateList;
	private String documentState;
	
	public String getDesignedAnaesMethodName() {
		return designedAnaesMethodName;
	}
	public void setDesignedAnaesMethodName(String designedAnaesMethodName) {
		this.designedAnaesMethodName = designedAnaesMethodName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getDesignedOptName() {
		return designedOptName;
	}
	public void setDesignedOptName(String designedOptName) {
		this.designedOptName = designedOptName;
	}
	public String getOperRoomName() {
		return operRoomName;
	}
	public void setOperRoomName(String operRoomName) {
		this.operRoomName = operRoomName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getAnesthetistName() {
		return anesthetistName;
	}
	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}
	public String getDocumentState() {
		return documentState;
	}
	public void setDocumentState(String documentState) {
		this.documentState = documentState;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<DocumentStateFormbean> getDocumentStateList() {
		return documentStateList;
	}
	public void setDocumentStateList(List<DocumentStateFormbean> documentStateList) {
		this.documentStateList = documentStateList;
	}
	public String getRegOptId() {
		return regOptId;
	}
	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getOperaDate() {
		return operaDate;
	}
	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
	}
	
	
}
