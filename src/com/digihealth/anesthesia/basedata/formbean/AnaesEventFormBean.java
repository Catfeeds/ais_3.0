package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "麻醉事件对象")
public class AnaesEventFormBean implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3211951171854720380L;

	@ApiModelProperty(value = "码表ID")
	private String sysCodeId;

	@ApiModelProperty(value = "组（使用下划线方式作为组id）")
	private String groupId;

	@ApiModelProperty(value = "组对应名称")
	private String groupName;

	@ApiModelProperty(value = "码值")
	private String codeValue;

	@ApiModelProperty(value = "码值名称")
	private String codeName;

	@ApiModelProperty(value = "是否可用;1-可用，0-不可用")
	private Integer enable;

	@ApiModelProperty(value = "排序")
	private Integer order;

	@ApiModelProperty(value = "基线id")
	private String beid;

	public String getSysCodeId() {
		return sysCodeId;
	}

	public void setSysCodeId(String sysCodeId) {
		this.sysCodeId = sysCodeId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}
	
}
