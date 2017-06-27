package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchDeptOperatCountBySteward implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "部门id")
	private String deptId;

	@ApiModelProperty(value = "部门名称")
	private String deptName;

	@ApiModelProperty(value = "zer")
	private Long zer;

	@ApiModelProperty(value = "fst")
	private Long fst;

	@ApiModelProperty(value = "sec")
	private Long sec;

	@ApiModelProperty(value = "thd")
	private Long thd;

	@ApiModelProperty(value = "fou")
	private Long fou;

	@ApiModelProperty(value = "fif")
	private Long fif;

	@ApiModelProperty(value = "six")
	private Long six;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getZer() {
		return zer;
	}

	public void setZer(Long zer) {
		this.zer = zer;
	}

	public Long getFst() {
		return fst;
	}

	public void setFst(Long fst) {
		this.fst = fst;
	}

	public Long getSec() {
		return sec;
	}

	public void setSec(Long sec) {
		this.sec = sec;
	}

	public Long getThd() {
		return thd;
	}

	public void setThd(Long thd) {
		this.thd = thd;
	}

	public Long getFou() {
		return fou;
	}

	public void setFou(Long fou) {
		this.fou = fou;
	}

	public Long getFif() {
		return fif;
	}

	public void setFif(Long fif) {
		this.fif = fif;
	}

	public Long getSix() {
		return six;
	}

	public void setSix(Long six) {
		this.six = six;
	}

}
