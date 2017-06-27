package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 病区
 * 
 * @author liukui
 * 
 */
@ApiModel(value = "his病区参数对象")
public class HisRegion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "RegionId")
	@ApiModelProperty(value = "主键id")
	private Integer regionId;

	@JsonProperty(value = "Name")
	@ApiModelProperty(value = "病区名称")
	private String name;

	@JsonProperty(value = "Enable")
	@ApiModelProperty(value = "是否可用;1-是，0-无")
	private String enable;

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = StringUtils.isEmpty(name) ? name : name.trim();
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

}