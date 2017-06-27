package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.digihealth.anesthesia.evt.formbean.SearchMyOperationFormBean;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class IncompleteThingFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "数据集合")
	private List<SearchMyOperationFormBean> resultList = new ArrayList<SearchMyOperationFormBean>();

	@ApiModelProperty(value = "总计")
	private int total;

	public List<SearchMyOperationFormBean> getResultList() {
		return resultList;
	}

	public void setResultList(List<SearchMyOperationFormBean> resultList) {
		this.resultList = resultList;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
