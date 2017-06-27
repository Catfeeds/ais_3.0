package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchBadEventInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "文书id")
	private String docId;

	@ApiModelProperty(value = "姓名")
	private String name; // 姓名

	@ApiModelProperty(value = "手术id")
	private String regOptId;

	@ApiModelProperty(value = "年龄")
	private String age; // 年龄

	@ApiModelProperty(value = "失误原因")
	private String lapseReason;

	@ApiModelProperty(value = "技术原因")
	private String technologyReason;

	@ApiModelProperty(value = "外科手术原因")
	private String surgeryReason;

	@ApiModelProperty(value = "不良事件原因")
	private String badEventReson; // 不良事件原因

	@ApiModelProperty(value = "麻醉方法")
	private String anaesMethod; // 麻醉方法

	@ApiModelProperty(value = "麻醉医生")
	private String anaesDoc; // 麻醉医生

	@ApiModelProperty(value = "手术医生")
	private String operateDoc; // 手术医生

	@ApiModelProperty(value = "病区")
	private String regionName; // 病区

	@ApiModelProperty(value = "住院科室")
	private String deptName; // 住院科室

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

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getTechnologyReason() {
		return technologyReason;
	}

	public void setTechnologyReason(String technologyReason) {
		this.technologyReason = technologyReason;
	}

	public String getSurgeryReason() {
		return surgeryReason;
	}

	public void setSurgeryReason(String surgeryReason) {
		this.surgeryReason = surgeryReason;
	}

	public String getBadEventReson() {
		return badEventReson;
	}

	public void setBadEventReson(String badEventReson) {
		this.badEventReson = badEventReson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLapseReason() {
		return lapseReason;
	}

	public void setLapseReason(String lapseReason) {
		this.lapseReason = lapseReason;
	}

	public String getAnaesMethod() {
		return anaesMethod;
	}

	public void setAnaesMethod(String anaesMethod) {
		this.anaesMethod = anaesMethod;
	}

	public String getAnaesDoc() {
		return anaesDoc;
	}

	public void setAnaesDoc(String anaesDoc) {
		this.anaesDoc = anaesDoc;
	}

	public String getOperateDoc() {
		return operateDoc;
	}

	public void setOperateDoc(String operateDoc) {
		this.operateDoc = operateDoc;
	}

}
