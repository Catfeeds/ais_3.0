package com.digihealth.anesthesia.sysMng.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.common.utils.StringUtils;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户信息查询参数对象")
public class UserInfoFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键id")
	private String id;
	
	@ApiModelProperty(value = "用户名")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return StringUtils.isEmpty(name) ? "" : name.trim();
	}

	public void setName(String name) {
		this.name = StringUtils.isEmpty(name) ? "" : name.trim();
	}

}
