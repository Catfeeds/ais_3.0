package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class StaticDeptCountByAnalgesic implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "部门id")
	private String deptId;

	@ApiModelProperty(value = "部门名称")
	private String deptName;

	@ApiModelProperty(value = "pcia")
	private Long pcia;

	@ApiModelProperty(value = "pcea")
	private Long pcea;

	@ApiModelProperty(value = "pcsa")
	private Long pcsa;

	@ApiModelProperty(value = "pcna")
	private Long pcna;

	@ApiModelProperty(value = "总数")
	private Long total;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

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

	public Long getPcia() {
		return pcia;
	}

	public void setPcia(Long pcia) {
		this.pcia = pcia;
	}

	public Long getPcea() {
		return pcea;
	}

	public void setPcea(Long pcea) {
		this.pcea = pcea;
	}

	public Long getPcsa() {
		return pcsa;
	}

	public void setPcsa(Long pcsa) {
		this.pcsa = pcsa;
	}

	public Long getPcna() {
		return pcna;
	}

	public void setPcna(Long pcna) {
		this.pcna = pcna;
	}

}
