package com.digihealth.anesthesia.sysMng.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "参数对象")
public class ButtonPermission
{
	@ApiModelProperty(value = "id")
	String id;
	@ApiModelProperty(value = "名称")
	String name;
	// 是否选择 
	@ApiModelProperty(value = "是否选择 ")
	Boolean check;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Boolean getCheck()
	{
		return check;
	}

	public void setCheck(Boolean check)
	{
		this.check = check;
	}

}
