package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "his手术名称参数对象")
public class HisOperdef implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "Code")
	@ApiModelProperty(value = "编码")
	private String code;
	
	@JsonProperty(value = "Name")
	@ApiModelProperty(value = "名称")
	private String name;
	
	@JsonProperty(value = "Pinyin")
	@ApiModelProperty(value = "拼音")
	private String pinyin;
	
	@JsonProperty(value = "Enable")
	@ApiModelProperty(value = "是否可用;1-是，0-否")
	private String enable;

	@ApiModelProperty(value = "主键id")
	private Integer operdefId;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	
	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	/**    
	 * @author chengwang       
	 * @created 2015-10-23 下午4:42:44 
	 * @return type 
	 */
	
	public Integer getOperdefId() {
		return operdefId;
	}

	/**     
	 * @author chengwang       
	 * @created 2015-10-23 下午4:42:44         
	 * @param operdefId   
	 */
	public void setOperdefId(Integer operdefId) {
		this.operdefId = operdefId;
	}
	
	
}