package com.digihealth.anesthesia.evt.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: CancleRegOptFormBean.java Description: 取消手术
 * 
 * @author chengwang
 * @created 2015年10月30日 上午9:13:49
 */
@ApiModel(value = "取消手术信息对象")
public class CancleRegOptFormBean {
	@ApiModelProperty(value = "手术ID")
	private String regOptId;
	
	@ApiModelProperty(value = "手术停止原因")
	private String reasons;

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

}
