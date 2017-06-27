package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 科室
 * 
 * @author liukui
 * 
 */
public class HisDept implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "DeptId")
	private Integer deptId;
	
	@JsonProperty(value = "Name")
	private String name;
	
	@JsonProperty(value = "Enable")
	private String enable;
	
	private String roomDep;
	
	private String deptDep;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = StringUtils.isEmpty(name) ? name : name.trim();
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getRoomDep() {
		return roomDep;
	}

	public void setRoomDep(String roomDep) {
		this.roomDep = roomDep;
	}

	public String getDeptDep() {
		return deptDep;
	}

	public void setDeptDep(String deptDep) {
		this.deptDep = deptDep;
	}

}