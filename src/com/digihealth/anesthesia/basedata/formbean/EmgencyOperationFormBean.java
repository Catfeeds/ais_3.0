package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.basedata.po.BasDispatch;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Project Name:ais File EmgencyOperationFormBean Package
 * Name:com.digihealth.anesthesia.basedata.formbean Date:2015-10-22 上午10:31:58
 * Copyright (c) 2015, ly351x@sina.com All Rights Reserved.
 */
@ApiModel(value = "急诊参数对象")
public class EmgencyOperationFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "手术信息")
	private BasRegOpt regOpt;

	@ApiModelProperty(value = "排程信息")
	private BasDispatch dispatch;

	public BasRegOpt getRegOpt() {
		return regOpt;
	}

	public void setRegOpt(BasRegOpt regOpt) {
		this.regOpt = regOpt;
	}

	public BasDispatch getDispatch() {
		return dispatch;
	}

	public void setDispatch(BasDispatch dispatch) {
		this.dispatch = dispatch;
	}

	@Override
	public String toString() {
		return "EmgencyOperationFormBean [regOpt=" + regOpt.toString()
				+ ", dispatch=" + dispatch.toString() + "]";
	}

}
