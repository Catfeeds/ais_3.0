package com.digihealth.anesthesia.basedata.po;

import java.io.Serializable;

/**
 * 麻醉监测标记点设置
 * @author liukui
 *
 */
public class AnaesObserve implements Serializable{
	
	private String observeId;
	private String color;
	private String icon;
	private int roomId;
	
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
	@Override
	public String toString() {
		return "AnaesObserve [observeId=" + observeId + ", color=" + color
				+ ", icon=" + icon + ", roomId=" + roomId + "]";
	}
	
	
	
}
