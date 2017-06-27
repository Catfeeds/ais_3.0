package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class ResearchAnalysisFormbean implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "不能为空!")
	@Size(min = 1, max = 40, message = "长度必须是1~40之间")
	@ApiModelProperty(value = "模板名称")
	private String tempName;

	@ApiModelProperty(value = "创建人")
	private Integer createUser;

	@ApiModelProperty(value = "resAnaId")
	private Integer resAnaId;

	@ApiModelProperty(value = "regOptFilters")
	private List<ResearchAnalysisList> regOptFilters;

	@ApiModelProperty(value = "recordFilters")
	private List<ResearchAnalysisList> recordFilters;

	@ApiModelProperty(value = "diagDefFilters")
	private List<ResearchAnalysisList> diagDefFilters;

	@ApiModelProperty(value = "realOperFilters")
	private List<ResearchAnalysisList> realOperFilters;

	@ApiModelProperty(value = "realAnaesMethodFilters")
	private List<ResearchAnalysisList> realAnaesMethodFilters;

	@ApiModelProperty(value = "instrubillItemFilters")
	private List<ResearchAnalysisList> instrubillItemFilters;

	@ApiModelProperty(value = "mazuiMedicineFilters")
	private List<ResearchAnalysisList> mazuiMedicineFilters;

	@ApiModelProperty(value = "zhiliaoMedicineFilters")
	private List<ResearchAnalysisList> zhiliaoMedicineFilters;

	@ApiModelProperty(value = "ioEventFilters")
	private Map<String, ResearchAnalysisList> ioEventFilters = new HashMap<String, ResearchAnalysisList>();

	@ApiModelProperty(value = "egressFilters")
	private Map<String, ResearchAnalysisList> egressFilters = new HashMap<String, ResearchAnalysisList>();

	@ApiModelProperty(value = "miaodianFilters")
	private Map<String, ResearchAnalysisList> miaodianFilters = new HashMap<String, ResearchAnalysisList>();

	public Integer getResAnaId() {
		return resAnaId;
	}

	public void setResAnaId(Integer resAnaId) {
		this.resAnaId = resAnaId;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Map<String, ResearchAnalysisList> getMiaodianFilters() {
		return miaodianFilters;
	}

	public void setMiaodianFilters(
			Map<String, ResearchAnalysisList> miaodianFilters) {
		this.miaodianFilters = miaodianFilters;
	}

	public Map<String, ResearchAnalysisList> getIoEventFilters() {
		return ioEventFilters;
	}

	public void setIoEventFilters(
			Map<String, ResearchAnalysisList> ioEventFilters) {
		this.ioEventFilters = ioEventFilters;
	}

	public Map<String, ResearchAnalysisList> getEgressFilters() {
		return egressFilters;
	}

	public void setEgressFilters(Map<String, ResearchAnalysisList> egressFilters) {
		this.egressFilters = egressFilters;
	}

	public List<ResearchAnalysisList> getInstrubillItemFilters() {
		return instrubillItemFilters;
	}

	public void setInstrubillItemFilters(
			List<ResearchAnalysisList> instrubillItemFilters) {
		this.instrubillItemFilters = instrubillItemFilters;
	}

	public List<ResearchAnalysisList> getMazuiMedicineFilters() {
		return mazuiMedicineFilters;
	}

	public void setMazuiMedicineFilters(
			List<ResearchAnalysisList> mazuiMedicineFilters) {
		this.mazuiMedicineFilters = mazuiMedicineFilters;
	}

	public List<ResearchAnalysisList> getZhiliaoMedicineFilters() {
		return zhiliaoMedicineFilters;
	}

	public void setZhiliaoMedicineFilters(
			List<ResearchAnalysisList> zhiliaoMedicineFilters) {
		this.zhiliaoMedicineFilters = zhiliaoMedicineFilters;
	}

	public List<ResearchAnalysisList> getRealOperFilters() {
		return realOperFilters;
	}

	public void setRealOperFilters(List<ResearchAnalysisList> realOperFilters) {
		this.realOperFilters = realOperFilters;
	}

	public List<ResearchAnalysisList> getRealAnaesMethodFilters() {
		return realAnaesMethodFilters;
	}

	public void setRealAnaesMethodFilters(
			List<ResearchAnalysisList> realAnaesMethodFilters) {
		this.realAnaesMethodFilters = realAnaesMethodFilters;
	}

	public List<ResearchAnalysisList> getDiagDefFilters() {
		return diagDefFilters;
	}

	public void setDiagDefFilters(List<ResearchAnalysisList> diagDefFilters) {
		this.diagDefFilters = diagDefFilters;
	}

	public List<ResearchAnalysisList> getRegOptFilters() {
		return regOptFilters;
	}

	public void setRegOptFilters(List<ResearchAnalysisList> regOptFilters) {
		this.regOptFilters = regOptFilters;
	}

	public List<ResearchAnalysisList> getRecordFilters() {
		return recordFilters;
	}

	public void setRecordFilters(List<ResearchAnalysisList> recordFilters) {
		this.recordFilters = recordFilters;
	}

}
