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
@ApiModel(value = "麻醉方法查询对象")
public class AnaesMethodFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "麻醉方法ID")
	private String anaMedId;

	@ApiModelProperty(value = "麻醉方法名称")
	private String name;

	@ApiModelProperty(value = "拼音")
	private String pinYin;

	public String getPinYin()
	{
		return pinYin;
	}

	public void setPinYin(String pinYin)
	{
		this.pinYin = pinYin;
	}

	public String getAnaMedId() {
		return anaMedId;
	}

	public void setAnaMedId(String anaMedId) {
		this.anaMedId = anaMedId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
