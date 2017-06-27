package com.digihealth.anesthesia.sysMng.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "权限菜单查询参数对象")
public class RoleSelectMenuFormBean {

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "父id")
	private String pId;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "是否选中")
	private Integer selected;

	/**
	 * 类型：0-仅目录，1-页面
	 */
	@ApiModelProperty(value = "类型：0-仅目录，1-页面")
	private Integer type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
