package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class AnaesDocumentStateCountFormbean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "文书状态集合对象")
	private List<DocStateListFormbean> docStateList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DocStateListFormbean> getDocStateList() {
		return docStateList;
	}

	public void setDocStateList(List<DocStateListFormbean> docStateList) {
		this.docStateList = docStateList;
	}

}
