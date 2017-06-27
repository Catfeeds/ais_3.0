package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术排程参数对象")
public class DispatchFormbean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 病人id
	 */
	@ApiModelProperty(value = "患者id")
	private String regOptId;
	/**
	 * 手术室名称
	 */
	@ApiModelProperty(value = "手术室名称")
	private String operRoomName;
	/**
	 * 手术室id
	 */
	@ApiModelProperty(value = "手术室id")
	private String operRoomId;

	@ApiModelProperty(value = "手术体位")
	private String optBodyName;
	/**
	 * 器械护士1的id
	 */
	@ApiModelProperty(value = "器械护士1id")
	private String instrnurseId1;
	/**
	 * 巡回护士1的ID
	 */
	@NotEmpty(message = "巡回护士不能为空")
	@ApiModelProperty(value = "巡回护士1id")
	private String circunurseId1;
	/**
	 * 麻醉医生id
	 */
	@ApiModelProperty(value = "麻醉医生id")
	private String anesthetistId;
	/**
	 * 上级麻醉医生id
	 */
	@ApiModelProperty(value = "上级麻醉医生id")
	private String circuanesthetistId;
	/**
	 * 灌注医生id
	 */
	@ApiModelProperty(value = "灌注医生id")
	private String perfusionDoctorId;
	/**
	 * 排班
	 */
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	/**
	 * 器械护士2的id
	 */
	@ApiModelProperty(value = "器械护士2id")
	private String instrnurseId2;
	/**
	 * 巡回护士2的id
	 */
	@ApiModelProperty(value = "巡回护士2id")
	private String circunurseId2;
	
	// 器械护士1
	@ApiModelProperty(value = "器械护士1")
	private String instrnurseName1;
	
	// 器械护士2
	@ApiModelProperty(value = "器械护士2")
	private String instrnurseName2;
	
	// 巡回护士1
	@ApiModelProperty(value = "巡回护士1")
	private String circunurseName1;
	
	// 巡回护士2
	@ApiModelProperty(value = "巡回护士2")
	private String circunurseName2;
	
	// 麻醉医生
	@ApiModelProperty(value = "麻醉医生")
	private String anesthetistName;
	
	// 上级麻醉医生
	@ApiModelProperty(value = "上级麻醉医生")
	private String circuanesthetistName;

	// 灌注医生
	@ApiModelProperty(value = "灌注医生")
	private String perfusiondoctorName;

	/**
	 * 卫生护士
	 */
	@ApiModelProperty(value = "卫生护士")
	private String healthnurseName;
	/**
	 * 卫生护士
	 */
	@ApiModelProperty(value = "卫生护士")
	private String healthNurse;

	@ApiModelProperty(value = "手术排程日期")
	private String operaDate; // 手术排程日期

	@ApiModelProperty(value = "手术体位")
	private String optBody;

	@ApiModelProperty(value = "手术申请时填写的手术时间")
	private String operRegDate; // 手术申请时填写的手术时间

	@ApiModelProperty(value = "描述当前排程暂存状态 1:暂存 0:保存")
	private String isHold;// 描述当前排程暂存状态 1:暂存 0:保存

	@ApiModelProperty(value = "台次")
	private String pcs; // 台次

	public String getPcs() {
		return pcs;
	}

	public void setPcs(String pcs) {
		this.pcs = pcs;
	}

	public String getOptBodyName() {
		return optBodyName;
	}

	public void setOptBodyName(String optBodyName) {
		this.optBodyName = optBodyName;
	}

	public String getPerfusiondoctorName() {
		return perfusiondoctorName;
	}

	public void setPerfusiondoctorName(String perfusiondoctorName) {
		this.perfusiondoctorName = perfusiondoctorName;
	}

	public String getHealthnurseName() {
		return healthnurseName;
	}

	public void setHealthnurseName(String healthnurseName) {
		this.healthnurseName = healthnurseName;
	}

	public String getInstrnurseName1() {
		return instrnurseName1;
	}

	public void setInstrnurseName1(String instrnurseName1) {
		this.instrnurseName1 = instrnurseName1;
	}

	public String getInstrnurseName2() {
		return instrnurseName2;
	}

	public void setInstrnurseName2(String instrnurseName2) {
		this.instrnurseName2 = instrnurseName2;
	}

	public String getCircunurseName1() {
		return circunurseName1;
	}

	public void setCircunurseName1(String circunurseName1) {
		this.circunurseName1 = circunurseName1;
	}

	public String getCircunurseName2() {
		return circunurseName2;
	}

	public void setCircunurseName2(String circunurseName2) {
		this.circunurseName2 = circunurseName2;
	}

	public String getAnesthetistName() {
		return anesthetistName;
	}

	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}

	public String getCircuanesthetistName() {
		return circuanesthetistName;
	}

	public void setCircuanesthetistName(String circuanesthetistName) {
		this.circuanesthetistName = circuanesthetistName;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getOperRoomName() {
		return operRoomName;
	}

	public void setOperRoomName(String operRoomName) {
		this.operRoomName = operRoomName;
	}

	public String getOperRoomId() {
		return operRoomId;
	}

	public void setOperRoomId(String operRoomId) {
		this.operRoomId = operRoomId;
	}

	public String getInstrnurseId1() {
		return instrnurseId1;
	}

	public void setInstrnurseId1(String instrnurseId1) {
		this.instrnurseId1 = instrnurseId1;
	}

	public String getCircunurseId1() {
		return circunurseId1;
	}

	public void setCircunurseId1(String circunurseId1) {
		this.circunurseId1 = circunurseId1;
	}

	public String getAnesthetistId() {
		return anesthetistId;
	}

	public void setAnesthetistId(String anesthetistId) {
		this.anesthetistId = anesthetistId;
	}

	public String getCircuanesthetistId() {
		return circuanesthetistId;
	}

	public void setCircuanesthetistId(String circuanesthetistId) {
		this.circuanesthetistId = circuanesthetistId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getInstrnurseId2() {
		return instrnurseId2;
	}

	public void setInstrnurseId2(String instrnurseId2) {
		this.instrnurseId2 = instrnurseId2;
	}

	public String getCircunurseId2() {
		return circunurseId2;
	}

	public void setCircunurseId2(String circunurseId2) {
		this.circunurseId2 = circunurseId2;
	}

	public String getIsHold() {
		return isHold;
	}

	public void setIsHold(String isHold) {
		this.isHold = isHold;
	}

	public String getOperaDate() {
		return operaDate;
	}

	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
	}

	public String getPerfusionDoctorId() {
		return perfusionDoctorId;
	}

	public void setPerfusionDoctorId(String perfusionDoctorId) {
		this.perfusionDoctorId = perfusionDoctorId;
	}

	public String getHealthNurse() {
		return healthNurse;
	}

	public void setHealthNurse(String healthNurse) {
		this.healthNurse = healthNurse;
	}

	public String getOptBody() {
		return optBody;
	}

	public void setOptBody(String optBody) {
		this.optBody = optBody;
	}

	public String getOperRegDate() {
		return operRegDate;
	}

	public void setOperRegDate(String operRegDate) {
		this.operRegDate = operRegDate;
	}

}
