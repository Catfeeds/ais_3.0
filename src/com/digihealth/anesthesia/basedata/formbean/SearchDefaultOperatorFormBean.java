package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Project Name:ais File SearchDispatchFormBean Package
 * Name:com.digihealth.anesthesia.basedata.formbean Date:2015-10-22 上午10:31:58
 * Copyright (c) 2015, ly351x@sina.com All Rights Reserved.
 */

@ApiModel(value = "手术查询参数对象")
public class SearchDefaultOperatorFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 手术室名称
	 */
	@ApiModelProperty(value = "手术室名称")
	private String operRoomName;
	/**
	 * 手术室id
	 */
	@ApiModelProperty(value = "手术室id")
	private int operRoomId;
	/**
	 * 器械护士1的id
	 */
	@ApiModelProperty(value = "器械护士1的id")
	private String instrnurseId1;

	@ApiModelProperty(value = "器械护士1")
	private String instrnurseName1;
	/**
	 * 巡回护士1的ID
	 */
	@ApiModelProperty(value = "巡回护士1的ID")
	private String circunurseId1;

	@ApiModelProperty(value = "巡回护士1")
	private String circunurseName1;
	/**
	 * 麻醉医生id
	 */
	@ApiModelProperty(value = "麻醉医生id")
	private String anesthetistId;

	@ApiModelProperty(value = "麻醉医生")
	private String anesthetistName;
	/**
	 * 灌注医生id
	 */
	@ApiModelProperty(value = "灌注医生id")
	private String perfusiondoctorId;

	@ApiModelProperty(value = "灌注医生")
	private String perfusiondoctorName;
	/**
	 * 器械护士2的id
	 */
	@ApiModelProperty(value = "器械护士2的id")
	private String instrnurseId2;

	@ApiModelProperty(value = "器械护士2")
	private String instrnurseName2;
	/**
	 * 巡回护士2的id
	 */
	@ApiModelProperty(value = "巡回护士2的id")
	private String circunurseId2;

	@ApiModelProperty(value = "巡回护士2")
	private String circunurseName2;

	@ApiModelProperty(value = "卫生护士名称")
	private String healthNurseName;

	@ApiModelProperty(value = "卫生护士")
	private String healthNurse;

	public String getHealthNurseName() {
		return healthNurseName;
	}

	public void setHealthNurseName(String healthNurseName) {
		this.healthNurseName = healthNurseName;
	}

	public String getHealthNurse() {
		return healthNurse;
	}

	public void setHealthNurse(String healthNurse) {
		this.healthNurse = healthNurse;
	}

	public String getOperRoomName() {
		return operRoomName;
	}

	public void setOperRoomName(String operRoomName) {
		this.operRoomName = operRoomName;
	}

	public int getOperRoomId() {
		return operRoomId;
	}

	public void setOperRoomId(int operRoomId) {
		this.operRoomId = operRoomId;
	}

	public String getInstrnurseId1() {
		return instrnurseId1;
	}

	public void setInstrnurseId1(String instrnurseId1) {
		this.instrnurseId1 = instrnurseId1;
	}

	public String getInstrnurseName1() {
		return instrnurseName1;
	}

	public void setInstrnurseName1(String instrnurseName1) {
		this.instrnurseName1 = instrnurseName1;
	}

	public String getCircunurseId1() {
		return circunurseId1;
	}

	public void setCircunurseId1(String circunurseId1) {
		this.circunurseId1 = circunurseId1;
	}

	public String getCircunurseName1() {
		return circunurseName1;
	}

	public void setCircunurseName1(String circunurseName1) {
		this.circunurseName1 = circunurseName1;
	}

	public String getAnesthetistId() {
		return anesthetistId;
	}

	public void setAnesthetistId(String anesthetistId) {
		this.anesthetistId = anesthetistId;
	}

	public String getAnesthetistName() {
		return anesthetistName;
	}

	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}

	public String getPerfusiondoctorId() {
		return perfusiondoctorId;
	}

	public void setPerfusiondoctorId(String perfusiondoctorId) {
		this.perfusiondoctorId = perfusiondoctorId;
	}

	public String getPerfusiondoctorName() {
		return perfusiondoctorName;
	}

	public void setPerfusiondoctorName(String perfusiondoctorName) {
		this.perfusiondoctorName = perfusiondoctorName;
	}

	public String getInstrnurseId2() {
		return instrnurseId2;
	}

	public void setInstrnurseId2(String instrnurseId2) {
		this.instrnurseId2 = instrnurseId2;
	}

	public String getInstrnurseName2() {
		return instrnurseName2;
	}

	public void setInstrnurseName2(String instrnurseName2) {
		this.instrnurseName2 = instrnurseName2;
	}

	public String getCircunurseId2() {
		return circunurseId2;
	}

	public void setCircunurseId2(String circunurseId2) {
		this.circunurseId2 = circunurseId2;
	}

	public String getCircunurseName2() {
		return circunurseName2;
	}

	public void setCircunurseName2(String circunurseName2) {
		this.circunurseName2 = circunurseName2;
	}

}
