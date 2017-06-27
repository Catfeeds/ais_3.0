package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.common.utils.StringUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: AnaesMethodFormBean.java Description: 基础数据查询返回formbean
 * 
 * @author chengwang
 * @created 2015年11月6日 上午10:41:36
 */
@ApiModel(value = "手术人员参数对象")
public class OperPeopleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "主键id")
	private String operatorId;

	@ApiModelProperty(value = "手术人员名字")
	private String name;

	@ApiModelProperty(value = "拼音")
	private String pinYin;

	public String getPinYin() {
		return pinYin;
	}

	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}

	public String getName() {
		return StringUtils.isEmpty(name) ? "" : name.trim();
	}

	public void setName(String name) {
		this.name = StringUtils.isEmpty(name) ? "" : name.trim();
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

}
