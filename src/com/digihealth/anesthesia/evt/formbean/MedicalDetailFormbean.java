package com.digihealth.anesthesia.evt.formbean;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class MedicalDetailFormbean {
	
	@ApiModelProperty(value = "主键id")
	private String id;

	/**
	 * 文书id
	 */
	@ApiModelProperty(value = "文书ID")
	private String docId;

	/**
	 * 用药id
	 */
	@ApiModelProperty(value = "用药id")
	private String medEventId;

	/**
	 * 浓度
	 */
	// @DecimalMin(value="0",message="浓度最低不能小于0")
	// @DecimalMax(value="999999",message="浓度最高不能高于999999")
	@ApiModelProperty(value = "浓度")
	private Float thickness;

	/**
	 * 浓度单位
	 */
	@ApiModelProperty(value = "浓度单位")
	private String thicknessUnit;

	/**
	 * 流速
	 */
	@DecimalMin(value = "0", message = "流速最低不能小于0")
	@DecimalMax(value = "999999", message = "流速最高不能高于999999")
	@ApiModelProperty(value = "流速")
	private Float flow;

	/**
	 * 流速单位
	 */
	@ApiModelProperty(value = "流速单位")
	private String flowUnit;

	/**
	 * 插入时间
	 */
	@ApiModelProperty(value = "插入时间")
	private Date insertTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getMedEventId() {
		return medEventId;
	}

	public void setMedEventId(String medEventId) {
		this.medEventId = medEventId;
	}

	public Float getThickness() {
		return thickness;
	}

	public void setThickness(Float thickness) {
		this.thickness = thickness;
	}

	public String getThicknessUnit() {
		return thicknessUnit;
	}

	public void setThicknessUnit(String thicknessUnit) {
		this.thicknessUnit = thicknessUnit;
	}

	public Float getFlow() {
		return flow;
	}

	public void setFlow(Float flow) {
		this.flow = flow;
	}

	public String getFlowUnit() {
		return flowUnit;
	}

	public void setFlowUnit(String flowUnit) {
		this.flowUnit = flowUnit;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
