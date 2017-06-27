package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "文书类别参数对象")
public class DocumentStateFormbean implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "患者id")
	private String regOptId;

	@ApiModelProperty(value = "文书名称")
	private String name;

	@ApiModelProperty(value = "状态")
	private String state;

	@ApiModelProperty(value = "总数")
	private Integer total;

	@ApiModelProperty(value = "表名")
	private String table;

	@ApiModelProperty(value = "impName")
	private String impName;

	@ApiModelProperty(value = "表名")
	private String tabName;

	public String getImpName() {
		return impName;
	}

	public void setImpName(String impName) {
		this.impName = impName;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
