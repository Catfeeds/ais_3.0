package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class DocStateListFormbean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "文书id")
	private String docId;

	@ApiModelProperty(value = "文书名称")
	private String docName;

	@ApiModelProperty(value = "用户id")
	private String userId;

	@ApiModelProperty(value = "完成数量")
	private Integer endTotal;

	@ApiModelProperty(value = "未完成数量")
	private Integer unfinishedTotal;

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public Integer getEndTotal() {
		return endTotal;
	}

	public void setEndTotal(Integer endTotal) {
		this.endTotal = endTotal;
	}

	public Integer getUnfinishedTotal() {
		return unfinishedTotal;
	}

	public void setUnfinishedTotal(Integer unfinishedTotal) {
		this.unfinishedTotal = unfinishedTotal;
	}

}
