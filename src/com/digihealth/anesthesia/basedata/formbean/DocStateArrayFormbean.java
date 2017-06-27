package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "文书状态参数对象")
public class DocStateArrayFormbean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "文书名称")
	private String docName;

	@ApiModelProperty(value = "isNeed")
	private Integer isNeed;

	@ApiModelProperty(value = "文书状态")
	private List<DocumentStateFormbean> docStateList = new ArrayList<DocumentStateFormbean>();

	public Integer getIsNeed() {
		return isNeed;
	}

	public void setIsNeed(Integer isNeed) {
		this.isNeed = isNeed;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public List<DocumentStateFormbean> getDocStateList() {
		return docStateList;
	}

	public void setDocStateList(List<DocumentStateFormbean> docStateList) {
		this.docStateList = docStateList;
	}
}
