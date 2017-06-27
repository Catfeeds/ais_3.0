package com.digihealth.anesthesia.operProceed.po;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 观察点
 * 
 * @author liukui
 * 
 */
@ApiModel(value = "观察点对象")
public class Observe implements Serializable, Cloneable {

	private static final long serialVersionUID = 1000L;

	@ApiModelProperty(value = "观测项id")
	private String observeId;

	@ApiModelProperty(value = "名称")
	private String name; // 名称

	@ApiModelProperty(value = "精度")
	private int precision;// 精度

	@ApiModelProperty(value = "频率")
	private int freq;// 频率

	@ApiModelProperty(value = "上限")
	private double max;// 上限

	@ApiModelProperty(value = "下限")
	private double min;// 下限

	@ApiModelProperty(value = "是否修正")
	private Boolean isAmend;// 是否修正

	@ApiModelProperty(value = "设备参数ID")
	private String paraId;// 设备参数ID

	@ApiModelProperty(value = "设备参数名称")
	private String paraName;// 设备参数名称

	@ApiModelProperty(value = "设备ID")
	private String deviceId;

	@ApiModelProperty(value = "观测项值")
	private String observeValue;

	@ApiModelProperty(value = "文书id")
	private String docId;

	@ApiModelProperty(value = "颜色")
	private String color;// 颜色

	@ApiModelProperty(value = "图标")
	private String icon;// 图标

	@ApiModelProperty(value = "值id")
	private String id;// 值id

	@ApiModelProperty(value = "位置")
	private int position;// 值id

	@ApiModelProperty(value = "生理告警状态是否正常值，0正常，-1过低，1过高")
	private int state;// 生理告警状态是否正常值，0正常，-1过低，1过高

	@ApiModelProperty(value = "单位")
	private String units; // 单位

	@ApiModelProperty(value = "点发送时间，以发送时间为准")
	private String timeSend; // 点发送时间，以发送时间为准

	@ApiModelProperty(value = "点实际时间")
	private String time;// 点实际时间

	@ApiModelProperty(value = "局点id")
	private String beid; // 局点id

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getObserveId() {
		return observeId;
	}

	public void setObserveId(String observeId) {
		this.observeId = observeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public Boolean getIsAmend() {
		return isAmend;
	}

	public void setIsAmend(Boolean isAmend) {
		this.isAmend = isAmend;
	}

	public String getParaName() {
		return paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

	public String getObserveValue() {
		return observeValue;
	}

	public void setObserveValue(String value) {
		this.observeValue = value;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public String getParaId() {
		return paraId;
	}

	public void setParaId(String paraId) {
		this.paraId = paraId;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getTimeSend() {
		return timeSend;
	}

	public void setTimeSend(String timeSend) {
		this.timeSend = timeSend;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

	@Override
	public Observe clone() {
		Observe observe = new Observe();
		observe.color = this.color;
		observe.deviceId = this.deviceId;
		observe.docId = this.docId;
		observe.freq = this.freq;
		observe.icon = this.icon;
		observe.id = this.id;
		observe.isAmend = this.isAmend;
		observe.max = this.max;
		observe.min = this.min;
		observe.name = this.name;
		observe.observeId = this.observeId;
		observe.observeValue = this.observeValue;
		observe.paraId = this.paraId;
		observe.paraName = this.paraName;
		observe.position = this.position;
		observe.precision = this.precision;
		observe.state = this.state;
		observe.time = this.time;
		observe.timeSend = this.timeSend;
		observe.beid = this.beid;
		return observe;
	}
}