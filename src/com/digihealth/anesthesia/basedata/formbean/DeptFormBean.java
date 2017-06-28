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
@ApiModel(value = "科室参数对象")
public class DeptFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "科室id")
	private String deptId;

	@ApiModelProperty(value = "科室名称")
	private String name;

	@ApiModelProperty(value = "拼音")
	private String pinYin;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinYin() {
		return pinYin;
	}

	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}

}
