package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: AnaesObserveFormBean.java Description: 麻醉监测点设置formbean
 * 
 * @author liukui
 * @created 2015年11月6日 上午10:41:36
 */
@ApiModel(value = "麻醉监测点设置对象")
public class AnaesObserveFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "监测点ID")
	private String observeId;

	@ApiModelProperty(value = "监测点名称")
	private String observeName;

	@ApiModelProperty(value = "颜色")
	private String color;

	@ApiModelProperty(value = "图标")
	private String icon;

	@ApiModelProperty(value = "手术室ID")
	private int roomId;

	@ApiModelProperty(value = "名称")
	private String name;

	public String getObserveName() {
		return observeName;
	}

	public void setObserveName(String observeName) {
		this.observeName = observeName;
	}

	public String getObserveId() {
		return observeId;
	}

	public void setObserveId(String observeId) {
		this.observeId = observeId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
