package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: AnaesMethodFormBean.java Description: 基础数据查询返回formbean
 * 
 * @author chengwang
 * @created 2015年11月6日 上午10:41:36
 */
@ApiModel(value = "手术间参数对象")
public class OperRoomFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "手术间id")
	private String operRoomId;

	@ApiModelProperty(value = "手术间名称")
	private String name;

	public String getOperRoomId() {
		return operRoomId;
	}

	public void setOperRoomId(String operRoomId) {
		this.operRoomId = operRoomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
