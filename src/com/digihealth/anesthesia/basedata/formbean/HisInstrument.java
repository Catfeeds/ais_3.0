package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: Instrument.java Description: 器械
 * 
 * @author chengwang
 * @created 2015-10-22 下午2:48:52
 */
@ApiModel(value = "his器械参数对象")
public class HisInstrument implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "Code")
	@ApiModelProperty(value = "器械编号")
	private String code;

	@JsonProperty(value = "Name")
	@ApiModelProperty(value = "器械名称")
	private String name;

	@JsonProperty(value = "Type")
	@ApiModelProperty(value = "类型")
	private String type;

	@JsonProperty(value = "Pinyin")
	@ApiModelProperty(value = "拼音")
	private String pinyin;

	@JsonProperty(value = "Enable")
	@ApiModelProperty(value = "是否可用")
	private String enable;

	@ApiModelProperty(value = "器械id")
	private Integer instrumentId;

	@ApiModelProperty(value = "数量")
	private Integer amount;

	@ApiModelProperty(value = "instrSuitRelId")
	private Integer instrSuitRelId;

	public Integer getInstrSuitRelId() {
		return instrSuitRelId;
	}

	public void setInstrSuitRelId(Integer instrSuitRelId) {
		this.instrSuitRelId = instrSuitRelId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午4:40:02
	 * @return type
	 */

	public Integer getInstrumentId() {
		return instrumentId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午4:40:02
	 * @param instrumentId
	 */
	public void setInstrumentId(Integer instrumentId) {
		this.instrumentId = instrumentId;
	}

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
		this.name = StringUtils.isEmpty(name) ? name : name.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = StringUtils.isEmpty(pinyin) ? pinyin : pinyin.trim();
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
}