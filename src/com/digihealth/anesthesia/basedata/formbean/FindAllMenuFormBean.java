package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "菜单参数对象")
public class FindAllMenuFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "菜单id")
	private String id;

	@ApiModelProperty(value = "父id")
	private String parentId;

	@ApiModelProperty(value = "父id组")
	private String parentIds;

	@ApiModelProperty(value = "菜单名称")
	private String name;

	@ApiModelProperty(value = "子菜单对象")
	private List<FindAllMenuFormBean> children = new ArrayList<FindAllMenuFormBean>();

	@ApiModelProperty(value = "是否选择")
	private Boolean selected;

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public List<FindAllMenuFormBean> getChildren() {
		return children;
	}

	public void setChildren(List<FindAllMenuFormBean> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
